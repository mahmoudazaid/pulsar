# 🚀 BDD UI-API Testing Framework

A comprehensive **Behavior Driven Development (BDD)** testing framework for both **UI** and **API** testing using **Cucumber**, **Selenium WebDriver**, and **Java**.

## 🎯 **Framework Overview**

This framework provides a **professional-grade testing solution** that combines:
- **🧪 UI Testing** - Selenium WebDriver with Page Object Model
- **🔌 API Testing** - HTTP client with JSON validation
- **🥒 BDD Approach** - Cucumber feature files and step definitions
- **📊 Comprehensive Reporting** - HTML reports and test results
- **⚙️ CI/CD Ready** - GitHub Actions integration
- **🎨 Modern Architecture** - Clean separation of concerns

## 🚀 **Overview**

Orange BDD is a comprehensive testing framework that combines **Cucumber BDD** with **Java** and **Maven**, supporting both **UI testing** (Selenium WebDriver) and **API testing** (HTTP client). The framework provides a modern, professional testing experience with dedicated run configurations for different test types.

## ✨ **Features**

- **🥒 Cucumber BDD** - Behavior-driven development with Gherkin syntax
- **🧪 UI Testing** - Selenium WebDriver integration for web application testing
- **🔌 API Testing** - HTTP client for REST API testing without browser overhead
- **🎯 Dedicated Run Configurations** - Separate configurations for UI, API, and combined tests
- **📊 HTML Reporting** - Comprehensive test reports with Cucumber integration
- **🏗️ Maven Integration** - Standard Maven build system with dependency management
- **🎨 Modern IDE Support** - Optimized for Cursor IDE with VS Code compatibility
- **🏷️ Tag-based Testing** - Organize and run tests by categories (@ui, @api, @smoke, etc.)

## 🏗️ **Project Structure**

```
orange-bdd/
├── src/
│   ├── main/
│   │   └── resources/
│   │       └── system.properties   # Centralized configuration
│   └── test/
│       ├── java/
│       │   └── com/orange/
│       │       ├── cucumber/
│       │       │   ├── hooks/
│       │       │   │   ├── UIGlobalHooks.java        # UI browser management
│       │       │   │   ├── UIScenarioHooks.java      # UI WebDriver operations
│       │       │   │   ├── APIGlobalHooks.java       # API configuration
│       │       │   │   └── APIScenarioHooks.java     # API scenario handling
│       │       │   ├── runner/
│       │       │   │   ├── TestRunner.java          # Combined tests
│       │       │   │   ├── UICucumberRunner.java    # UI tests only
│       │       │   │   └── APICucumberRunner.java   # API tests only
│       │       │   └── stepDef/
│       │       │       ├── ui/                       # UI step definitions
│       │       │       │   ├── AbstractStepDef.java
│       │       │       │   ├── CartStepDef.java
│       │       │       │   ├── HomeStepDef.java
│       │       │       │   └── LoginStepDef.java
│       │       │       └── api/                      # API step definitions
│       │       │           └── UsersCrud.java
│       │       ├── api/
│       │       │   ├── BaseApiTest.java             # API base class
│       │       │   ├── config/
│       │       │   │   └── ApiConfig.java           # API configuration
│       │       │   ├── model/
│       │       │   │   └── User.java                # User data model
│       │       │   └── service/
│       │       │       └── UserApiService.java      # API service layer
│       │       └── selenium/
│       │           ├── driver/
│       │           │   ├── BrowserFactory.java
│       │           │   └── CustomWebDriver.java
│       │           ├── locator/
│       │           │   ├── CartPageLocator.java
│       │           │   ├── HomePageLocator.java
│       │           │   └── LoginPageLocator.java
│       │           └── page/
│       │               ├── CartPage.java
│       │               ├── HomePage.java
│       │               └── LoginPage.java
│       └── resources/
│           ├── features/                  # Organized feature files
│           │   ├── ui/                    # UI test features
│           │   │   └── stackdemo_cart_basic.feature
│           │   └── api/                   # API test features
│           │       └── users_crud.feature
│           └── testdata/
│               └── users.json
├── pom.xml                              # Maven project configuration
├── open-reports.sh                      # Open test reports in browser
└── README.md                            # This file
```

## 📋 **Prerequisites**

- **Java 11+** - JDK 11 or higher
- **Maven 3.6+** - Apache Maven for build management
- **Cursor IDE** - Modern IDE with Java and Cucumber extensions
- **Git** - Version control system

## 🔧 **Setup Instructions**

### **1. Clone the Repository**
```bash
git clone <your-repository-url>
cd bdd-ui-api
```

### **2. Verify Project Structure**
```bash
mvn clean compile test-compile
```

## 🎮 **Running Tests**

### **Method 1: Using Maven Commands (Recommended)**

```bash
# UI tests (with browser)
mvn clean test -Dtest=UICucumberRunner

# API tests (no browser)
mvn clean test -Dtest=APICucumberRunner

# All tests (runs both UI and API sequentially)
mvn clean test

# Run with specific environment
mvn clean test -Dtest=APICucumberRunner -Denv=staging
```

### **Method 2: Using Your IDE's Test Runner**

Most modern IDEs (IntelliJ IDEA, Eclipse, VS Code) can run Maven tests directly:

1. **Right-click on the test class** in your IDE
2. **Select "Run"** or "Debug"
3. **Choose the appropriate runner:**
   - `UICucumberRunner` for UI tests
   - `APICucumberRunner` for API tests
   - `TestRunner` for all tests

### **Method 3: Using IDE Run Configurations**

Create run configurations in your IDE:

1. **Create a new Maven run configuration**
2. **Set the command:** `clean test -Dtest=UICucumberRunner`
3. **Save and reuse** for different test types

## 🎯 **Test Configurations Explained**

### **🧪 UI Tests Configuration**
- **Main Class:** `UICucumberRunner`
- **Tags:** `@ui or @cart`
- **Browser:** ✅ Starts browser for UI testing
- **Use Case:** When you want to test UI functionality with Selenium
- **Features:** Runs all tests from `features/ui/` folder

### **🔌 API Tests Configuration**
- **Main Class:** `APICucumberRunner`
- **Tags:** `@api`
- **Browser:** ❌ No browser (pure HTTP client testing)
- **Use Case:** When you want to test API endpoints without browser overhead
- **Features:** Runs all tests from `features/api/` folder

### **🚀 Complete Test Suite**
- **Command:** `mvn clean test`
- **Execution:** Runs both UI and API tests sequentially
- **Use Case:** When you want to run the complete test suite
- **Features:** Executes all tests from all feature folders

## 🏷️ **Tagging Strategy**

### **UI Tests**
- `@ui` - All UI-related tests
- `@cart` - Cart functionality tests
- `@smoke` - Smoke test scenarios

### **API Tests**
- `@api` - All API-related tests
- `@create` - Create operations
- `@read` - Read operations
- `@update` - Update operations
- `@delete` - Delete operations

### **General Tags**
- `@smoke` - Critical path tests
- `@ignore` - Tests to skip

## 📊 **Test Reports**

### **HTML Reports**
After running tests, reports are generated in:
```
target/cucumber-reports/
├── ui-cucumber.html           # UI test reports
├── api-cucumber.html          # API test reports
└── combined-cucumber.html     # Combined test reports
```

### **Opening Reports**
```bash
# Open reports in browser
./open-reports.sh

# Or navigate manually to:
# target/cucumber-reports/
```

## ⚙️ **Configuration**

### **Environment Configuration**
All configuration is centralized in `src/main/resources/system.properties`:

```properties
# API Configuration
api.base.url=https://gorest.co.in
api.users.endpoint=/public/v2/users
api.auth.token=Bearer your-token-here

# Test Configuration
test.data.generation.enabled=true
test.data.user.prefix=TestUser
test.data.user.suffix.timestamp=true

# Timeout Configuration
api.connection.timeout=10000
api.read.timeout=30000
```

### **Environment Variables**
Override configuration at runtime:
```bash
mvn test -Dtest=APICucumberRunner -Denv=staging
```

## 🔍 **Writing Tests**

### **Feature Files**
Create `.feature` files in the appropriate folder:

```gherkin
@ui @smoke @cart
Feature: StackDemo Cart Basic Functionality
  As a user
  I want to add items to my cart
  So that I can purchase them later

  Background:
    Given I am on the StackDemo Home Page

  @add_to_cart
  Scenario: Add item to cart
    Given I am browsing the product catalog
    When I add a product "iPhone 12" to cart
    Then the item should be added to my cart
    And the cart count should show "1"
```

### **Step Definitions**
Create step definitions in the appropriate package:

```java
package com.orange.cucumber.stepDef.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CartStepDef extends AbstractStepDef {
    
    @Given("I am browsing the product catalog")
    public void iAmBrowsingTheProductCatalog() {
        // Implementation
    }
    
    @When("I add a product {string} to cart")
    public void iAddAProductToCart(String productName) {
        // Implementation
    }
    
    @Then("the item should be added to my cart")
    public void theItemShouldBeAddedToMyCart() {
        // Implementation
    }
}
```

## 🚨 **Troubleshooting**

### **Common Issues**

1. **Tests Not Running**
   - Verify Java is properly installed and configured
   - Check Maven project structure
   - Run `mvn clean compile` first

2. **Feature Files Not Recognized**
   - Check file associations in your IDE
   - Verify feature files are in correct folders
   - Ensure Cucumber dependencies are in pom.xml

3. **Browser Not Starting for UI Tests**
   - Verify you're using the correct test runner (`UICucumberRunner`)
   - Check Selenium dependencies
   - Verify WebDriver configuration

4. **API Tests Taking Too Long**
   - Verify you're using the correct test runner (`APICucumberRunner`)
   - Check API endpoint accessibility
   - Verify authentication token

### **Debug Steps**
1. **Check console output** for error messages
2. **Verify Java installation** and PATH configuration
3. **Check Maven** project structure
4. **Verify Cucumber** dependencies in pom.xml

## 🎉 **Benefits**

### **✅ Professional Setup**
- **Dedicated test runners** for different test types
- **Clear separation** between UI and API testing
- **Modern testing framework** with Cucumber and TestNG
- **Integrated debugging** support

### **✅ Scalability**
- **Easy to add** new UI features
- **Simple to extend** API endpoints
- **Modular test execution**
- **Organized step definition** structure

### **✅ Team Collaboration**
- **Clear ownership** and responsibilities
- **Consistent configuration** across team
- **Easy maintenance** and debugging
- **Professional workflow**

## 🚀 **Quick Start Commands**

```bash
# Setup
git clone <repository>
cd bdd-ui-api
mvn clean compile

# Run tests
mvn clean test -Dtest=UICucumberRunner      # UI tests
mvn clean test -Dtest=APICucumberRunner     # API tests
mvn clean test                               # All tests

# Open reports
./open-reports.sh
```

## 📚 **Additional Resources**

- **Cucumber Documentation:** https://cucumber.io/docs
- **Selenium Documentation:** https://selenium.dev/documentation/
- **Maven Documentation:** https://maven.apache.org/guides/
- **TestNG Documentation:** https://testng.org/doc/

---

**🎯 Pro Tip:** Use Maven commands as your primary way to execute tests. The separate test runners make it easy to switch between UI and API testing without confusion, providing a professional-grade testing experience!

**Happy testing! 🚀**
