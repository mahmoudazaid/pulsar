# API Test Automation Framework

## 🎯 Overview

This project now includes a comprehensive API testing framework for testing CRUD operations on the "Users" endpoint of `https://gorest.co.in/`. The framework is built using Java and Cucumber with TestNG, providing BDD-style API testing without Rest Assured.

## 🏗️ Clean Architecture

```
src/test/java/com/orange/api/
├── BaseApiTest.java           # Base class with common HTTP client functionality
├── config/
│   └── ApiConfig.java        # Configuration manager for API properties
├── model/
│   └── User.java             # User data model
├── service/
│   └── UserApiService.java   # Service layer for API operations
├── stepDef/
│   └── ApiStepDef.java       # Cucumber step definitions for API testing
└── runner/
    └── ApiTestRunner.java    # Dedicated runner for API tests

src/main/resources/
└── system.properties          # Environment configuration (includes API settings)

src/test/resources/
├── features/
│   └── api_users_crud.feature # Cucumber feature file for API testing
├── testdata/
│   └── users.json            # Test data for API tests
└── testng-api.xml            # TestNG configuration for API tests
```

## 📋 Features

### ✅ **CRUD Operations Implemented:**
- **CREATE**: Create new users with validation
- **READ**: Get all users and get user by ID
- **UPDATE**: Update existing users
- **DELETE**: Delete users and verify deletion

### ✅ **Comprehensive Validation:**
- HTTP status codes validation
- Response schema validation (JSON)
- Content-type validation
- Response body validation
- Data integrity validation

### ✅ **BDD Approach:**
- Cucumber feature files for test scenarios
- Step definitions for all API operations
- Human-readable test descriptions
- Data-driven testing with DataTables

### ✅ **Environment Configuration:**
- Centralized configuration in `system.properties`
- Environment-specific settings
- Runtime configuration override
- Flexible property management

### ✅ **Test Data Management:**
- JSON-based test data files
- Dynamic test data generation
- Test scenario management
- Automatic data cleanup and teardown

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6+
- Internet connection for API access

### Configuration
1. **Update Authentication Token** in `src/main/resources/system.properties`:
   ```properties
   api.auth.token=Bearer YOUR_ACTUAL_TOKEN_HERE
   ```

2. **Get Token from GoRest**:
   - Visit: https://gorest.co.in/
   - Sign up for free account
   - Generate API token
   - Replace `YOUR_ACTUAL_TOKEN_HERE` with your token

3. **Environment Configuration**:
   The framework automatically loads configuration from `system.properties`:
   ```properties
   # API Configuration
   api.base.url=https://gorest.co.in
   api.users.endpoint=/public/v2/users
   api.auth.token=Bearer YOUR_TOKEN_HERE
   
   # Timeouts and Settings
   api.connection.timeout=10000
   api.read.timeout=30000
   api.rate.limit.delay=1000
   ```

## 🧪 Running Tests

### Option 1: Using the API Test Runner Script (Recommended)
```bash
# Run Cucumber API tests in default environment (dev)
./run-api-tests.sh -c

# Run Cucumber API tests in specific environment
./run-api-tests.sh -c -e staging

# Run specific test method
./run-api-tests.sh -t testCreateUser

# Run tests in all environments
./run-api-tests.sh -a

# Show help
./run-api-tests.sh -h
```

### Option 2: Direct Maven Commands
```bash
# Run all API tests with Cucumber
mvn test -Dtest=ApiTestRunner

# Run with specific environment
mvn test -Dtest=ApiTestRunner -Denv=staging

# Run with TestNG XML
mvn test -DsuiteXmlFile=src/test/resources/testng-api.xml
```

### Option 3: Run with Main TestRunner
```bash
# Run both UI and API tests
mvn test -Dtest=TestRunner

# Run only API tests
mvn test -Dtest=TestRunner -Dcucumber.filter.tags="@api"
```

## 📊 Test Execution Flow

The Cucumber scenarios are designed to run with proper setup and teardown:

1. **Background**: Configure API base URL, authentication, and test data
2. **@create scenarios**: Test user creation with various data sets
3. **@read scenarios**: Test user retrieval operations
4. **@update scenarios**: Test user update operations
5. **@delete scenarios**: Test user deletion operations
6. **@validation scenarios**: Test error handling and validation
7. **@performance scenarios**: Test multiple operations
8. **@security scenarios**: Test authentication and authorization

## 🔧 Configuration Management

### Configuration Hierarchy
1. **Default values** in `ApiConfig.java`
2. **File-based configuration** in `system.properties`
3. **System properties** (can override file properties)
4. **Runtime environment** setting via `-Denv=`

### Key Configuration Properties
```properties
# API Endpoints
api.base.url=https://gorest.co.in
api.users.endpoint=/public/v2/users

# Authentication
api.auth.token=Bearer YOUR_TOKEN_HERE

# Timeouts
api.connection.timeout=10000
api.read.timeout=30000
api.rate.limit.delay=1000

# Test Data
api.test.users.count=5
api.test.user.prefix=TestUser
api.test.email.domain=@example.com

# Logging
api.logging.show.request.body=false
api.logging.show.response.body=false
```

## 📈 Validation Details

### Status Code Validation
- **201**: User created successfully
- **200**: User retrieved/updated successfully
- **204**: User deleted successfully
- **404**: User not found (after deletion)
- **400+**: Validation errors

### Response Schema Validation
- JSON format validation
- Required field presence
- Data type validation
- Field value validation

### Content Validation
- Response body not null/empty
- Content-type header validation
- Data integrity checks
- Field value matching

## 🥒 Cucumber Features

### Feature File Structure
The `api_users_crud.feature` file contains:
- **Background**: Common setup for all scenarios
- **@create**: User creation scenarios
- **@read**: User retrieval scenarios
- **@update**: User update scenarios
- **@delete**: User deletion scenarios
- **@validation**: Error handling scenarios
- **@performance**: Load testing scenarios
- **@security**: Authentication scenarios

### Step Definitions
All steps are implemented in `ApiStepDef.java`:
- **Given**: Setup and configuration steps
- **When**: Action steps (API calls)
- **Then**: Validation and assertion steps

## 🐛 Troubleshooting

### Common Issues

1. **Authentication Errors (401)**
   - Check your API token in `src/main/resources/system.properties`
   - Verify token is valid and not expired

2. **Configuration Not Loading**
   - Ensure `system.properties` is in `src/main/resources/`
   - Check property names match exactly
   - Verify environment setting is correct

3. **Rate Limiting (429)**
   - Adjust `api.rate.limit.delay` in properties
   - GoRest has rate limits for free accounts

4. **Step Definition Not Found**
   - Ensure glue path includes `com.orange.api.stepDef`
   - Check step definition method signatures match feature file

### Debug Mode
Enable verbose logging by updating properties:
```properties
api.logging.show.request.body=true
api.logging.show.response.body=true
api.logging.level=DEBUG
```

## 📝 Customization

### Adding New Test Scenarios
1. Add new scenarios to `api_users_crud.feature`
2. Implement corresponding step definitions in `ApiStepDef.java`
3. Add test data to `users.json` if needed

### Modifying Configuration
1. Update properties in `src/main/resources/system.properties`
2. Add new properties to `ApiConfig.java`
3. Use environment-specific overrides

### Adding New Endpoints
1. Create new service class extending `BaseApiTest`
2. Implement HTTP methods using `ApiConfig`
3. Add corresponding step definitions

## 🔄 Continuous Integration

### Maven Integration
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <configuration>
        <includes>
            <include>**/*Runner*.java</include>
        </includes>
        <systemPropertyVariables>
            <env>${env}</env>
        </systemPropertyVariables>
    </configuration>
</plugin>
```

### CI/CD Pipeline
- Run API tests in parallel with UI tests
- Generate Cucumber reports
- Fail build on test failures
- Store test artifacts

## 📚 API Documentation

### GoRest API Endpoints
- **Base URL**: `https://gorest.co.in`
- **Users Endpoint**: `/public/v2/users`
- **Authentication**: Bearer token required for POST/PUT/DELETE
- **Rate Limits**: Check GoRest documentation

### HTTP Methods Supported
- `GET /users` - List all users
- `GET /users/{id}` - Get user by ID
- `POST /users` - Create new user
- `PUT /users/{id}` - Update user
- `DELETE /users/{id}` - Delete user

## 🎉 Success Metrics

- ✅ All CRUD operations working
- ✅ Comprehensive validation implemented
- ✅ Error handling tested
- ✅ Test data management
- ✅ Clean test execution
- ✅ Proper test cleanup
- ✅ Environment configuration
- ✅ BDD feature files
- ✅ Step definitions implemented
- ✅ Cucumber integration

## 🆘 Support

For issues or questions:
1. Check the troubleshooting section
2. Review test execution logs
3. Verify API endpoint accessibility
4. Check authentication token validity
5. Review configuration in `system.properties`
6. Use the API test runner script for easy execution
7. Check step definition implementations

---

**Note**: This framework provides a solid foundation for BDD-style API testing and can be extended for other endpoints and more complex scenarios. 