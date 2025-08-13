package com.orange.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to manage user credentials loaded from JSON configuration
 */
public class UserManager {
    private static final Logger logger = Logger.getLogger(UserManager.class.getName());
    private static final String USERS_CONFIG_FILE = "config/users.json";
    
    private static JsonNode usersConfig;
    private static final Map<String, User> userCache = new HashMap<>();
    
    static {
        loadUsersConfig();
    }
    
    /**
     * User model class
     */
    public static class User {
        private String username;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private String role;
        
        // Default constructor for Jackson
        public User() {}
        
        public User(String username, String password, String email, String firstName, String lastName, String role) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
        }
        
        // Getters and Setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        
        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        
        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
        
        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", email='" + email + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", role='" + role + '\'' +
                    '}';
        }
    }
    
    /**
     * Load users configuration from JSON file
     */
    private static void loadUsersConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = UserManager.class.getClassLoader().getResourceAsStream(USERS_CONFIG_FILE);
            
            if (inputStream != null) {
                usersConfig = mapper.readTree(inputStream);
                logger.info("Users configuration loaded successfully from " + USERS_CONFIG_FILE);
            } else {
                logger.error("Could not find users configuration file: " + USERS_CONFIG_FILE);
            }
        } catch (Exception e) {
            logger.error("Failed to load users configuration: " + e.getMessage(), e);
        }
    }
    
    /**
     * Get user by username
     */
    public static User getUser(String username) {
        if (userCache.containsKey(username)) {
            return userCache.get(username);
        }
        
        try {
            if (usersConfig != null && usersConfig.has("users") && usersConfig.get("users").has(username)) {
                JsonNode userNode = usersConfig.get("users").get(username);
                User user = new User();
                user.setUsername(userNode.get("username").asText());
                user.setPassword(userNode.get("password").asText());
                user.setEmail(userNode.get("email").asText());
                user.setFirstName(userNode.get("firstName").asText());
                user.setLastName(userNode.get("lastName").asText());
                user.setRole(userNode.get("role").asText());
                
                userCache.put(username, user);
                logger.debug("Loaded user: " + username);
                return user;
            }
        } catch (Exception e) {
            logger.error("Failed to load user " + username + ": " + e.getMessage(), e);
        }
        
        return null;
    }
    
    /**
     * Get default user for current environment
     */
    public static User getDefaultUser() {
        String env = System.getProperty("env", "dev");
        String defaultUsername = getDefaultUsernameForEnvironment(env);
        return getUser(defaultUsername);
    }
    
    /**
     * Get default username for specific environment
     */
    private static String getDefaultUsernameForEnvironment(String env) {
        try {
            if (usersConfig != null && usersConfig.has("environments") && 
                usersConfig.get("environments").has(env) &&
                usersConfig.get("environments").get(env).has("defaultUser")) {
                return usersConfig.get("environments").get(env).get("defaultUser").asText();
            }
        } catch (Exception e) {
            logger.warn("Could not get default user for environment " + env + ": " + e.getMessage());
        }
        
        // Fallback to global default
        try {
            if (usersConfig != null && usersConfig.has("defaultUser")) {
                return usersConfig.get("defaultUser").asText();
            }
        } catch (Exception e) {
            logger.warn("Could not get global default user: " + e.getMessage());
        }
        
        // Final fallback
        return "demouser";
    }
    
    /**
     * Get user credentials as a map
     */
    public static Map<String, String> getUserCredentials(String username) {
        User user = getUser(username);
        if (user != null) {
            Map<String, String> credentials = new HashMap<>();
            credentials.put("username", user.getUsername());
            credentials.put("password", user.getPassword());
            credentials.put("email", user.getEmail());
            return credentials;
        }
        return null;
    }
    
    /**
     * Check if user exists
     */
    public static boolean userExists(String username) {
        return getUser(username) != null;
    }
    
    /**
     * Get all available usernames
     */
    public static String[] getAllUsernames() {
        try {
            if (usersConfig != null && usersConfig.has("users")) {
                JsonNode usersNode = usersConfig.get("users");
                String[] usernames = new String[usersNode.size()];
                int i = 0;
                for (JsonNode userNode : usersNode) {
                    usernames[i++] = userNode.get("username").asText();
                }
                return usernames;
            }
        } catch (Exception e) {
            logger.error("Failed to get all usernames: " + e.getMessage(), e);
        }
        return new String[0];
    }
    
    /**
     * Reload users configuration
     */
    public static void reloadConfig() {
        userCache.clear();
        loadUsersConfig();
    }
} 