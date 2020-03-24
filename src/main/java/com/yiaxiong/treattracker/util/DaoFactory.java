package com.yiaxiong.treattracker.util;

import com.yiaxiong.treattracker.persistence.*;

/**
 * Created by paulawaite on 4/28/16.
 */
public class DaoFactory {

    // Empty constructor is private - static class
    private DaoFactory() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);

    }
}