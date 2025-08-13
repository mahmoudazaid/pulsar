# StackDemo Cart Automation Framework

This project is a Java-based BDD automation framework for testing cart operations on the StackDemo e-commerce site. It uses Cucumber for behavior-driven development, TestNG for test execution, and follows the Page Object Model (POM) design pattern.

## Features

- **Page Object Model (POM)**: Separates locators and test logic for maintainable code
- **Multi-environment Support**: Configuration for dev and staging environments
- **BDD Framework**: Cucumber with Gherkin syntax for readable test scenarios
- **Test Execution**: TestNG for parallel execution and reporting
- **Selenium WebDriver**: Cross-browser automation support
- **Comprehensive Reporting**: Console and HTML reports

## Prerequisites

- Java 8 or higher
- Maven 3.6+
- Chrome/Firefox browser
- Git

## Project Structure

```
src/
├── main/
│   └── resources/
│       └── system.properties
└── test/
    ├── java/
    │   └── com/
    │       └── orange/
    │           ├── cucumber/           # Cucumber framework
    │           │   ├── hooks/         # Test hooks
    │           │   ├── runner/        # Test runners
    │           │   └── stepDef/       # Step definitions
    │           ├── selenium/          # Selenium framework
    │           │   ├── driver/        # WebDriver management
    │           │   ├── locator/       # Page locators
    │           │   └── page/          # Page objects
    │           └── utils/             # Utility classes
    └── resources/
        ├── config/                     # Environment configurations
        │   ├── dev.properties
        │   └── staging.properties
        └── features/                   # Cucumber feature files
            └── stackdemo_cart_basic.feature
            ```

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd orange-bdd
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Environment Configuration

The framework supports multiple environments. Configure your environment by updating the properties files:

**Development Environment** (`src/test/resources/config/dev.properties`):
```properties
baseUrl=https://stackdemo.dev.example.com
headless=false
```

**Staging Environment** (`src/test/resources/config/staging.properties`):
```properties
baseUrl=https://stackdemo.staging.example.com
headless=true
```

## Execution Instructions

### Run All Tests
```bash
mvn test
```

### Run Tests for Specific Environment

**Development Environment:**
```bash
mvn test -Pdev
```

**Staging Environment:**
```bash
mvn test -Pstaging
```

### Run Specific Test Categories

**Smoke Tests:**
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

**Cart Tests:**
```bash
mvn test -Dcucumber.filter.tags="@cart"
```

**Specific Test:**
```bash
mvn test -Dcucumber.filter.tags="@smoke and @cart"
```

### Run with Custom Parameters
```bash
mvn test -Dcucumber.filter.tags="@cart" -Dheadless=true -Dbrowser=chrome
```

## Test Scenarios

The framework includes comprehensive test scenarios for cart operations:

### Basic Cart Operations (`stackdemo_cart_basic.feature`)
- Add single item to cart

## Test Execution Reports

### Console Reports
Test execution results are displayed in the console with detailed step-by-step information.

### HTML Reports
After test execution, HTML reports are generated in:
- `target/surefire-reports/` - TestNG reports
- `target/cucumber.html/` - Cucumber HTML reports

### Cucumber JSON Report
JSON format report available at `target/cucumber.json` for integration with other reporting tools.

## Framework Components

### Page Objects
- `CartPage.java` - Cart interactions
- `HomePage.java` - Home management

### Step Definitions
- `AbstractStepDef.java` - Base step definition class
- Custom step definitions for cart operations

### Hooks
- `GlobalHooks.java` - Global test setup and teardown
- `ScenarioHooks.java` - Scenario-specific hooks

### Test Runner
- `TestRunner.java` - Cucumber test runner configuration
- `TestState.java` - Test state management

## Configuration Options

### Browser Configuration
```properties
browser=chrome
headless=false
implicitWait=10
pageLoadTimeout=30
```

### Test Configuration
```properties
parallel=true
threadCount=4
retryCount=2
```

## Troubleshooting

### Common Issues

1. **WebDriver Issues**: Ensure ChromeDriver/FirefoxDriver is in PATH or use WebDriverManager
2. **Environment Issues**: Verify environment properties files are correctly configured
3. **Test Failures**: Check console logs for detailed error information

### Debug Mode
Run tests in debug mode for detailed logging:
```bash
mvn test -Dlog.level=DEBUG
```
