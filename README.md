# Orange BDD Testing Framework

## 🎯 Overview

This project is a comprehensive BDD (Behavior Driven Development) testing framework that supports both UI and API testing. It's built using Java, Cucumber, TestNG, and Selenium, providing a robust foundation for automated testing with organized step definitions under the cucumber package.

## 🏗️ Project Structure

The project is organized with clear separation between UI and API testing, and all step definitions are consolidated under the cucumber package:

```
src/test/resources/features/
├── ui/                    # UI test features
│   └── stackdemo_cart_basic.feature
└── api/                   # API test features
    └── users_crud.feature

src/test/java/com/orange/cucumber/stepDef/
├── ui/                    # UI step definitions
│   ├── AbstractStepDef.java
│   ├── CartStepDef.java
│   ├── HomeStepDef.java
│   └── LoginStepDef.java
└── api/                   # API step definitions
    └── ApiStepDef.java
```

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- Maven 3.6+
- Chrome/Firefox browser (for UI tests)
- Internet connection (for API tests)

### Configuration
1. **Update API token** in `src/main/resources/system.properties`:
   ```properties
   api.auth.token=Bearer YOUR_ACTUAL_TOKEN_HERE
   ```

2. **Get GoRest API token** from [https://gorest.co.in/](https://gorest.co.in/)

### Running Tests

#### Option 1: Main Test Runner (Recommended)
```bash
# Make scripts executable
chmod +x run-tests.sh run-api-tests.sh

# Run all tests
./run-tests.sh

# Run specific test type
./run-tests.sh -t ui          # UI tests only
./run-tests.sh -t api         # API tests only
./run-tests.sh -t combined    # Both UI and API

# Run in specific environment
./run-tests.sh -t api -e staging
./run-tests.sh -t ui -e prod

# Show project structure
./run-tests.sh --structure
```

#### Option 2: Specialized Runners
```bash
# API tests only
./run-api-tests.sh -e dev
./run-api-tests.sh -a

# Direct Maven execution
mvn test -Dtest=UITestRunner      # UI tests
mvn test -Dtest=ApiTestRunner     # API tests
mvn test -Dtest=TestRunner        # Combined tests
```

## 📋 Features

### ✅ **UI Testing**
- Selenium WebDriver integration
- Page Object Model implementation
- Cross-browser support
- Screenshot capture on failure
- Responsive design testing

### ✅ **API Testing**
- HTTP client implementation (no Rest Assured)
- CRUD operations testing
- Response validation
- Schema validation
- Authentication support

### ✅ **BDD Approach**
- Cucumber feature files
- Human-readable scenarios
- Data-driven testing
- Tag-based execution
- **Organized step definitions** under cucumber package

### ✅ **Environment Management**
- Centralized configuration
- Environment-specific settings
- Runtime configuration override
- Flexible property management

## 🧪 Test Types

### UI Tests (`features/ui/`)
- **Cart functionality** - Add/remove items
- **Navigation** - Page navigation and routing
- **Form validation** - Input validation and submission
- **Responsive design** - Cross-device compatibility

### API Tests (`features/api/`)
- **User management** - CRUD operations
- **Authentication** - Token validation
- **Data validation** - Schema and content validation
- **Error handling** - Negative test scenarios

## 📊 Reporting

### Separate Reports
- **UI tests**: `target/cucumber-reports/ui-cucumber.html`
- **API tests**: `target/cucumber-reports/api-cucumber.html`
- **Combined tests**: `target/cucumber-reports/combined-cucumber.html`

### View Reports
```bash
./open-reports.sh
```

## 🔧 Configuration

### Environment Support
- **dev** - Development environment
- **staging** - Staging environment
- **prod** - Production environment

### Configuration Files
- **`system.properties`** - Centralized configuration
- **Environment variables** - Runtime override
- **System properties** - Maven execution override

## 🏷️ Tagging Strategy

### UI Tests
- `@ui` - All UI-related tests
- `@cart` - Cart functionality
- `@smoke` - Critical path tests

### API Tests
- `@api` - All API-related tests
- `@create`, `@read`, `@update`, `@delete` - CRUD operations
- `@validation` - Data validation
- `@performance` - Performance testing

## 📚 Documentation

- **[API Testing Guide](API_TESTING_README.md)** - Comprehensive API testing documentation
- **[Project Structure](PROJECT_STRUCTURE_README.md)** - Detailed project organization guide
- **[Reports Guide](REPORTS_README.md)** - HTML report generation and viewing

## 🔄 CI/CD Integration

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

### Pipeline Examples
```bash
# Development pipeline
mvn clean test -Dtest=TestRunner -Denv=dev

# Staging pipeline
mvn clean test -Dtest=TestRunner -Denv=staging

# Production pipeline
mvn clean test -Dtest=TestRunner -Denv=prod
```

## 🐛 Troubleshooting

### Common Issues
1. **API authentication errors** - Check token in `system.properties`
2. **Feature files not found** - Verify paths in new structure
3. **Step definitions missing** - Check glue paths in test runners
4. **Configuration not loading** - Verify `system.properties` location
5. **Import errors** - Check step definition package structure

### Getting Help
```bash
# Show help
./run-tests.sh --help

# Show project structure
./run-tests.sh --structure

# Check configuration
cat src/main/resources/system.properties
```

## 🎉 Benefits

- **✅ Organized Structure** - Clear separation of UI and API testing
- **✅ Consolidated Step Definitions** - All under cucumber package with organized subfolders
- **✅ Scalable Framework** - Easy to add new features and endpoints
- **✅ Team Collaboration** - Clear ownership and responsibilities
- **✅ CI/CD Ready** - Multiple execution options and environments
- **✅ Comprehensive Reporting** - Separate reports for different test types
- **✅ BDD Approach** - Human-readable test scenarios

## 🆘 Support

For issues or questions:
1. Check the troubleshooting section
2. Review project structure documentation
3. Verify configuration files
4. Use the help options in test runner scripts
5. Check step definition package structure and imports

---

**Note**: This framework provides a solid foundation for scalable testing and can be easily extended for future needs. The consolidation of all step definitions under the cucumber package with organized subfolders makes the project more maintainable and easier to work with for different team members.
