package com.yiaxiong.treattracker.gmailAPI;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Message;
import com.yiaxiong.treattracker.entity.Incident;
import com.yiaxiong.treattracker.entity.User;
import lombok.*;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GmailAPI {

    protected static final String APPLICATION_NAME = "treattracker";
    protected static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    protected static final String TOKENS_DIRECTORY_PATH = "tokens";
    protected static final String FROM_EMAIL = "bepstreattracker@gmail.com";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    protected static final List<String> SCOPES = Collections.singletonList(GmailScopes.MAIL_GOOGLE_COM);
    protected static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Instance variables
     */
    private List<User> users = new ArrayList<>();
    private Incident incident = new Incident();
    private String message;

    /**
     * The empty constructor
     */
    public GmailAPI() {}

    /**
     * The argument constructor
     * @param users the users that email will be sent to
     * @param incident the incident that is resolved
     * @param description the message that resolved the incident
     * @param message the email message
     */
    public GmailAPI(List<User> users, Incident incident, String description, String message) {
        this.users = users;
        this.incident = incident;
        this.message = message + "\n\nResolution Detail: \n" + description + "\n\nTreatTracker";
    }

    /**
     * Create a MimeMessage using the parameters provided.
     *
     * @param to email address of the receiver
     * @param from email address of the sender, the mailbox account
     * @param subject subject of the email
     * @param bodyText body text of the email
     * @return the MimeMessage to be used to send email
     * @throws MessagingException
     */
    private static MimeMessage createEmail(String to, String from, String subject, String bodyText) throws MessagingException, AddressException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(to));
        email.setSubject(subject);
        email.setText(bodyText);
        return email;
    }

    /**
     * Create a message from an email.
     *
     * @param emailContent Email to be set to raw of message
     * @return a message containing a base64url encoded email
     * @throws IOException
     * @throws MessagingException
     */
    public static Message createMessageWithEmail(MimeMessage emailContent) throws MessagingException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {

        // Load client secrets.
        InputStream in = GmailAPI.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     * Send an email to all users.
     *
     * @throws MessagingException
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public void send() throws MessagingException, IOException, GeneralSecurityException {
        String subject = "Treat Tracker Incident Resolved for: " + incident.getUser().getFirst_name() +
                " " + incident.getUser().getLast_name();

        for (User user : users) {
            MimeMessage mineMessage = createEmail(user.getEmail(), FROM_EMAIL, subject, message);

            Message message = createMessageWithEmail(mineMessage);

            NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

            Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            message = service.users().messages().send("me", message).execute();
        }
    }
}
