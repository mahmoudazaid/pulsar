package com.celonis.constants;

import org.apache.log4j.Logger;

import java.util.EnumSet;

public enum User {
    Mahmoud_Abuzaid("Mahmoud Abuzaid", "mahmoud.a.zaid@outlook.com", "Az@123456");

    static Logger logger = Logger.getLogger(User.class.getName());
    private final String name;
    private final String email;
    private final String password;

    User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User getUserByName(String name) {
        logger.trace("getUserByName :: " + name);
        EnumSet<User> allUsers = EnumSet.allOf(User.class);
        for (User user : allUsers) {
            if (name.toUpperCase().equals(user.name.toUpperCase())) {
                return user;
            }
        }
        throw new IllegalArgumentException("User \"" + name + "\" not found.");
    }
    public String getUserEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

}
