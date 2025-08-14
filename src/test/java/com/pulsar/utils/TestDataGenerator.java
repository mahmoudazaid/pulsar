package com.pulsar.utils;

import com.pulsar.api.model.User;
import net.datafaker.Faker;

import java.util.Locale;

/**
 * Utility class for generating realistic random test data using Java Faker
 * This class is designed to be used across the entire framework for both UI and API tests
 */
public class TestDataGenerator {
    
    private static final Faker faker = new Faker(Locale.of("en"));
    
    /**
     * Generate a random user with realistic data
     */
    public static User generateRandomUser() {
        return new User(
            faker.name().fullName(),
            faker.internet().emailAddress(),
            faker.options().option("male", "female"),
            faker.options().option("active", "inactive")
        );
    }
} 