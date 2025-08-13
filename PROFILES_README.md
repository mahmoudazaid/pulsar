# Environment Profiles for bstackdemo.com

This project supports multiple environment profiles for testing the [bstackdemo.com](https://www.bstackdemo.com/) website.

## Available Profiles

### 1. Dev Profile (`-Pdev`)
- **URL**: https://www.bstackdemo.com
- **Headless Mode**: `false` (browser UI visible)
- **Implicit Wait**: 5000ms
- **Page Load Timeout**: 30 seconds
- **Use Case**: Development and debugging with visible browser

### 2. Staging Profile (`-Pstaging`)
- **URL**: https://www.bstackdemo.com
- **Headless Mode**: `true` (browser runs in background)
- **Implicit Wait**: 3000ms
- **Page Load Timeout**: 20 seconds
- **Use Case**: CI/CD pipelines and automated testing

## How to Run Tests with Different Profiles

### Using Maven Profiles
```bash
# Run with dev profile (visible browser)
mvn test -Pdev

# Run with staging profile (headless)
mvn test -Pstaging

# Run with production profile (headless)
mvn test -Pprod
```

### Override Environment via System Property
```bash
# Force specific environment
mvn test -Denv=dev
mvn test -Denv=staging
mvn test -Denv=prod
```

### Override Headless Mode
```bash
# Force non-headless mode regardless of profile
mvn test -Dheadless=false

# Force headless mode regardless of profile
mvn test -Dheadless=true
```

### Run Specific Test Runner
```bash
# Run cart tests with dev profile
mvn test -Dtest=CartTestRunner -Pdev

# Run all tests with staging profile
mvn test -Pstaging
```

## Configuration Hierarchy

Properties are loaded in this order (later values override earlier ones):
1. `src/main/resources/system.properties` (default values)
2. `src/test/resources/config/{env}.properties` (environment-specific)
3. JVM system properties (`-D` arguments)

## Profile-Specific Settings

| Setting | Dev | Staging | Production |
|---------|-----|---------|------------|
| Headless | ❌ | ✅ | ✅ |
| Implicit Wait | 5000ms | 3000ms | 2000ms |
| Page Load Timeout | 30s | 20s | 15s |
| Browser | Chrome | Chrome | Chrome |

## Notes

- **Dev Profile**: Best for development and debugging as you can see the browser UI
- **Staging Profile**: Balanced settings for CI/CD and automated testing
- **Production Profile**: Optimized for performance with minimal wait times
- All profiles use the same base URL: https://www.bstackdemo.com
- Chrome browser is used across all environments

## User Management

The project now includes a JSON-based user management system:

### User Configuration File
- **Location**: `src/test/resources/config/users.json`
- **Default User**: `demouser` with password `testingisfun99`
- **Environment-specific**: Different default users for dev/staging environments

### Available Users
- **demouser**: Default user for development
- **testuser**: Test user for staging environment  
- **admin**: Administrative user

### Running User Management Tests
```bash
# Run user management tests only
mvn test -Dtest=UserManagementTestRunner -Pdev

# Run all tests including user management
mvn test -Pdev
```

### Using Different Users in Tests
```gherkin
# Use default user for environment
And I am logged in as a valid user

# Use specific user
And I am logged in as user "demouser"
And I am logged in as user "testuser"
``` 