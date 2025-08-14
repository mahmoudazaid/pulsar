# Project Structure Documentation

## 🏗️ Overview

This project has been reorganized with a clear separation between UI and API testing features, and all step definitions are now consolidated under the cucumber package with organized subfolders. The new structure provides better organization, maintainability, and scalability for both testing approaches.

## 📁 New Project Structure

```
orange-bdd/
├── src/
│   ├── main/
│   │   └── resources/
│   │       └── system.properties          # Centralized configuration
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── orange/
│       │           ├── cucumber/
│       │           │   ├── hooks/
│       │           │   │   ├── UIGlobalHooks.java        # 🆕 UI global hooks
│       │           │   │   ├── UIScenarioHooks.java      # 🆕 UI scenario hooks
│       │           │   │   ├── APIGlobalHooks.java       # API global hooks
│       │           │   │   └── APIScenarioHooks.java     # API scenario hooks
│       │           │   ├── runner/
│       │           │   │   ├── TestRunner.java          # Combined tests
│       │           │   │   ├── UICucumberRunner.java    # UI tests only
│       │           │   │   └── APICucumberRunner.java   # API tests only
│       │           │   └── stepDef/                     # 🆕 Consolidated step definitions
│       │           │       ├── ui/                       # 🆕 UI step definitions
│       │           │       │   ├── AbstractStepDef.java
│       │           │       │   ├── CartStepDef.java
│       │           │       │   ├── HomeStepDef.java
│       │           │       │   └── LoginStepDef.java
│       │           │       └── api/                      # 🆕 API step definitions
│       │           │           └── UsersCrud.java
│       │           ├── api/
│       │           │   ├── BaseApiTest.java             # API base class
│       │           │   ├── config/
│       │           │   │   └── ApiConfig.java           # API configuration
│       │           │   ├── model/
│       │           │   │   └── User.java                # User data model
│       │           │   ├── service/
│       │           │   │   └── UserApiService.java      # API service layer
│       │           └── selenium/
│       │               ├── driver/
│       │               │   ├── BrowserFactory.java
│       │               │   └── CustomWebDriver.java
│       │               ├── locator/
│       │               │   ├── CartPageLocator.java
│       │               │   ├── HomePageLocator.java
│       │               │   └── LoginPageLocator.java
│       │               └── page/
│       │                   ├── CartPage.java
│       │                   ├── HomePage.java
│       │                   └── LoginPage.java
│       └── resources/
│           ├── config/                    # Legacy config (can be removed)
│           ├── features/                  # 🆕 Organized feature files
│           │   ├── ui/                    # 🆕 UI test features
│           │   │   └── stackdemo_cart_basic.feature
│           │   └── api/                   # 🆕 API test features
│           │       └── users_crud.feature
│           ├── testdata/
│           │   └── users.json
│           └── testng-api.xml
├── run-tests.sh                          # 🆕 Main test runner
├── run-api-tests.sh                      # API-specific runner
├── open-reports.sh                       # Report viewer
├── pom.xml
└── README.md
```

## 🆕 New Features

### 1. **Organized Feature Structure**
- **`features/ui/`** - Contains all UI-related feature files
- **`features/api/`** - Contains all API-related feature files
- **`features/`** - Root folder for combined testing

### 2. **Consolidated Step Definitions** 🆕
- **`stepDef/ui/`** - All UI step definitions in one place
- **`stepDef/api/`** - All API step definitions in one place
- **`stepDef/`** - Root folder for all step definitions

### 3. **Clear Hook Organization** 🆕
- **`UIGlobalHooks.java`** - UI-specific global hooks (browser management)
- **`UIScenarioHooks.java`** - UI-specific scenario hooks (WebDriver operations)
- **`APIGlobalHooks.java`** - API-specific global hooks (API configuration)
- **`APIScenarioHooks.java`** - API-specific scenario hooks (API scenario handling)

### 4. **Dedicated Test Runners**
- **`TestRunner.java`** - Runs both UI and API tests
- **`UICucumberRunner.java`** - Runs only UI tests
- **`APICucumberRunner.java`** - Runs only API tests

### 5. **Comprehensive Test Runner Script**
- **`run-tests.sh`** - Main script for all test types
- **`run-api-tests.sh`** - Specialized API test runner
- **Environment support** - dev, staging, prod
- **Parallel execution** - Future enhancement

## 🚀 Test Execution Options

### Option 1: Main Test Runner (Recommended)
```bash
# Run all tests (UI + API)
./run-tests.sh

# Run specific test type
./run-tests.sh -t ui          # UI tests only
./run-tests.sh -t api         # API tests only
./run-tests.sh -t combined    # Both UI and API

# Run in specific environment
./run-tests.sh -t api -e staging
./run-tests.sh -t ui -e prod

# Run all test types in all environments
./run-tests.sh -a

# Show project structure
./run-tests.sh --structure
```

### Option 2: Specialized Runners
```bash
# API tests only
./run-api-tests.sh -e dev
./run-api-tests.sh -a

# Direct Maven execution
mvn test -Dtest=UICucumberRunner      # UI tests
mvn test -Dtest=APICucumberRunner     # API tests
mvn test -Dtest=TestRunner            # Combined tests
```

### Option 3: Tag-Based Execution
```bash
# Run by tags
mvn test -Dcucumber.filter.tags="@ui"
mvn test -Dcucumber.filter.tags="@api"
mvn test -Dcucumber.filter.tags="@cart"
mvn test -Dcucumber.filter.tags="@smoke"
```

## 📊 Reporting Structure

### Separate Reports for Each Test Type
```
target/cucumber-reports/
├── ui-cucumber.html           # UI test reports
├── ui-cucumber.json
├── ui-cucumber.xml
├── api-cucumber.html          # API test reports
├── api-cucumber.json
├── api-cucumber.xml
├── combined-cucumber.html     # Combined test reports
├── combined-cucumber.json
└── combined-cucumber.xml
```

### Report Viewing
```bash
# Open reports in browser
./open-reports.sh

# Or navigate manually to:
# target/cucumber-reports/
```

## 🔧 Configuration Management

### Centralized Configuration
- **`src/main/resources/system.properties`** - Single source of truth
- **Environment-specific** settings support
- **Runtime configuration override** capability
- **API and UI** configuration in one place

### Configuration Hierarchy
1. Default values in code
2. File-based configuration (`system.properties`)
3. System properties (`-Denv=`)
4. Runtime environment setting

## 🏷️ Tagging Strategy

### UI Tests
- `@ui` - All UI-related tests
- `@cart` - Cart functionality tests
- `@smoke` - Smoke test scenarios
- `@add_to_cart` - Specific cart operations

### API Tests
- `@api` - All API-related tests
- `@create` - Create operations
- `@read` - Read operations
- `@update` - Update operations
- `@delete` - Delete operations
- `@validation` - Validation scenarios
- `@performance` - Performance testing
- `@security` - Security testing

### Combined Tests
- `@ignore` - Tests to skip
- `@smoke` - Critical path tests
- Environment-specific tags

## 📈 Benefits of New Structure

### ✅ **Organization**
- Clear separation of concerns
- Easy to find specific test types
- Logical grouping of features and step definitions

### ✅ **Maintainability**
- Dedicated runners for specific needs
- Centralized configuration
- Consistent reporting structure
- **Consolidated step definitions** under cucumber package

### ✅ **Scalability**
- Easy to add new UI features
- Simple to extend API endpoints
- Modular test execution
- **Organized step definition structure**

### ✅ **Team Collaboration**
- UI team can focus on UI features and step definitions
- API team can work on API features and step definitions
- Clear ownership and responsibilities
- **Unified cucumber package structure**

### ✅ **CI/CD Integration**
- Separate test suites for different purposes
- Parallel execution capability
- Targeted test execution
- **Consistent glue paths**

## 🔄 Migration Guide

### From Old Structure
If you were using the old structure:

1. **Update feature file paths** in your IDE
2. **Use new test runners** for specific test types
3. **Update CI/CD scripts** to use new runners
4. **Review tag usage** for better organization
5. **Update step definition imports** to new package structure

### To New Structure
1. **Place UI features** in `features/ui/`
2. **Place API features** in `features/api/`
3. **Use appropriate tags** for organization
4. **Choose correct test runner** for your needs
5. **All step definitions** are now under `cucumber.stepDef.*`

## 🚨 Important Notes

### File Locations
- **UI features**: `src/test/resources/features/ui/`
- **API features**: `src/test/resources/features/api/`
- **UI step definitions**: `src/test/java/com/orange/cucumber/stepDef/ui/`
- **API step definitions**: `src/test/java/com/orange/cucumber/stepDef/api/`
- **Configuration**: `src/main/resources/system.properties`
- **Test runners**: `src/test/java/com/orange/*/runner/`

### Glue Paths
- **UI tests**: `com.orange.cucumber.stepDef.ui`
- **API tests**: `com.orange.cucumber.stepDef.api`
- **Combined tests**: Both glue paths included

### Hook Organization
- **UI hooks**: `UIGlobalHooks.java`, `UIScenarioHooks.java`
- **API hooks**: `APIGlobalHooks.java`, `APIScenarioHooks.java`
- **Clear separation**: UI hooks only load for UI tests, API hooks only load for API tests

### Execution Priority
1. **`run-tests.sh`** - Main runner for all scenarios
2. **`run-api-tests.sh`** - Specialized API testing
3. **Direct Maven** - For specific needs

### Environment Support
- **dev** - Development environment
- **staging** - Staging environment
- **prod** - Production environment

## 🆘 Troubleshooting

### Common Issues

1. **Feature files not found**
   - Check file paths in new structure
   - Verify glue paths in test runners

2. **Step definitions not found**
   - Ensure glue path includes correct step definition packages
   - Check step definition implementations
   - Verify package declarations in step definition files

3. **Configuration not loading**
   - Verify `system.properties` location
   - Check environment variable setting

4. **Reports not generating**
   - Check output directory paths
   - Verify plugin configurations

5. **Import errors in step definitions**
   - Check package declarations
   - Verify import statements
   - Ensure correct class paths

6. **Browser starting for API tests**
   - Ensure API runner only loads API hooks
   - Check glue path configuration
   - Verify hook separation

### Getting Help

1. **Show project structure**: `./run-tests.sh --structure`
2. **Show help**: `./run-tests.sh --help`
3. **Check configuration**: Review `system.properties`
4. **Verify paths**: Ensure feature files are in correct folders
5. **Check step definitions**: Verify package structure and imports

## 🔍 Step Definition Organization

### UI Step Definitions (`stepDef/ui/`)
- **AbstractStepDef.java** - Base class for UI step definitions
- **CartStepDef.java** - Cart-related step definitions
- **HomeStepDef.java** - Home page step definitions
- **LoginStepDef.java** - Login-related step definitions

### API Step Definitions (`stepDef/api/`)
- **UsersCrud.java** - All API-related step definitions
  - CRUD operations
  - Validation scenarios
  - Performance testing
  - Security testing

### Benefits of New Organization
- **Clear separation** between UI and API step definitions
- **Easy maintenance** of specific test types
- **Consistent package structure** under cucumber
- **Simplified imports** and dependencies
- **Better team collaboration** with clear ownership

## 🔍 Hook Organization

### UI Hooks
- **`UIGlobalHooks.java`** - Browser initialization and cleanup
- **`UIScenarioHooks.java`** - WebDriver scenario management

### API Hooks
- **`APIGlobalHooks.java`** - API configuration validation
- **`APIScenarioHooks.java`** - API scenario setup and teardown

### Benefits of Hook Organization
- **Clear separation** between UI and API hooks
- **No browser interference** for API tests
- **Proper isolation** of test environments
- **Easy maintenance** and debugging
- **Better performance** for API-only test runs

---

**Note**: This new structure provides a solid foundation for scalable testing and can be easily extended for future needs. The consolidation of all step definitions under the cucumber package with organized subfolders and clear hook separation makes the project more maintainable and easier to work with for different team members. 