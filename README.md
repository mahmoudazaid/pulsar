# 🧪 Orange BDD Testing Framework

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
cd orange-bdd
```

### **2. Install Required Extensions in Cursor IDE**

Open Cursor IDE and install these extensions:

1. **🥒 Cucumber (Gherkin)** - Official Cucumber extension
2. **☕ Extension Pack for Java** - Java language support
3. **📦 Maven for Java** - Maven project support
4. **🧪 Test Runner for Java** - Test execution and debugging
5. **🔍 Test Explorer UI** - Test discovery interface

**How to install:**
- Press `Ctrl+Shift+X` (Windows/Linux) or `Cmd+Shift+X` (macOS)
- Search for each extension name
- Click Install and reload Cursor IDE

### **3. Verify Project Structure**
```bash
mvn clean compile test-compile
```

## 🎮 **Running Tests**

### **Method 1: Using Run and Debug Panel (Recommended)**

1. **Click the Run and Debug icon** in the left sidebar (▶️ icon)
2. **Select your desired configuration** from the dropdown:
   - 🧪 **UI Tests** - UI testing with browser
   - 🔌 **API Tests** - API testing without browser
   - 🚀 **All Tests** - Complete test suite
3. **Click the green play button** ▶️ to run tests
4. **Click the bug button** 🐛 to debug with breakpoints

### **Method 2: Using Command Palette**

1. **Press `Ctrl+Shift+P`** (Windows/Linux) or `Cmd+Shift+P` (macOS)
2. **Type:** `Debug: Start Debugging`
3. **Select** your desired configuration

### **Method 3: Using Keyboard Shortcut**

1. **Press `F5`** to start debugging
2. **Select** your desired configuration from the dropdown

### **Method 4: Using Maven Commands**

```bash
# UI tests (with browser)
mvn clean test -Dtest=UICucumberRunner

# API tests (no browser)
mvn clean test -Dtest=APICucumberRunner

# All tests
mvn clean test -Dtest=TestRunner

# Run with specific environment
mvn clean test -Dtest=APICucumberRunner -Denv=staging
```

### **Method 5: Using Tasks**

1. **Press `Ctrl+Shift+P`** (Windows/Linux) or `Cmd+Shift+P` (macOS)
2. **Type:** `Tasks: Run Task`
3. **Select** your desired task:
   - 🧪 **Run UI Tests**
   - 🔌 **Run API Tests**
   - 🚀 **Run All Tests**

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

### **🚀 All Tests Configuration**
- **Main Class:** `TestRunner`
- **Tags:** `not @ignore`
- **Browser:** ✅ Starts browser (includes UI tests)
- **Use Case:** When you want to run the complete test suite
- **Features:** Runs both UI and API tests from all feature folders

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
   - Verify Java extension is installed and enabled
   - Check Maven project structure
   - Run `mvn clean compile` first

2. **Feature Files Not Recognized**
   - Install Cucumber (Gherkin) extension
   - Check file associations
   - Verify feature files are in correct folders

3. **Browser Not Starting for UI Tests**
   - Verify you selected "🧪 UI Tests" configuration
   - Check Selenium dependencies
   - Verify WebDriver configuration

4. **API Tests Taking Too Long**
   - Verify you selected "🔌 API Tests" configuration
   - Check API endpoint accessibility
   - Verify authentication token

### **Debug Steps**
1. **Check Output panel** for error messages
2. **Verify Java extension** is working
3. **Check Maven** project structure
4. **Verify Cucumber** dependencies in pom.xml

## 🎉 **Benefits**

### **✅ Professional Setup**
- **Dedicated run configurations** for different test types
- **Clear separation** between UI and API testing
- **Modern IDE experience** with Cursor IDE
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
cd orange-bdd
mvn clean compile

# Run tests
mvn clean test -Dtest=UICucumberRunner      # UI tests
mvn clean test -Dtest=APICucumberRunner     # API tests
mvn clean test -Dtest=TestRunner            # All tests

# Open reports
./open-reports.sh
```

## 📚 **Additional Resources**

- **Cucumber Documentation:** https://cucumber.io/docs
- **Selenium Documentation:** https://selenium.dev/documentation/
- **Maven Documentation:** https://maven.apache.org/guides/
- **Cursor IDE Documentation:** https://cursor.sh/docs

---

**🎯 Pro Tip:** Use the Run and Debug panel as your primary way to execute tests. The separate configurations make it easy to switch between UI and API testing without confusion, providing a professional-grade testing experience!

**Happy testing! 🚀**
