# 🚀 Pulsar - Advanced BDD Testing Framework

> **A comprehensive Behavior Driven Development (BDD) testing framework for UI automation testing and API testing using Cucumber, Selenium WebDriver, and Java. Built for modern software testing and continuous integration.**

[![Java](https://img.shields.io/badge/Java-19+-orange.svg)](https://java.com/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![Cucumber](https://img.shields.io/badge/Cucumber-7.27+-green.svg)](https://cucumber.io/)
[![Selenium](https://img.shields.io/badge/Selenium-3.141+-red.svg)](https://selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.11+-yellow.svg)](https://testng.org/)

## 📋 **Table of Contents**
- [Framework Overview](#-framework-overview)
- [Overview](#-overview)
- [Features](#-features)
- [Use Cases & Applications](#-use-cases--applications)
- [Why Choose Pulsar?](#-why-choose-pulsar)
- [Performance & Scalability](#-performance--scalability)
- [Project Structure](#project-structure)
- [Prerequisites](#-prerequisites)
- [Getting Started with Pulsar](#-getting-started-with-pulsar)
- [Setup Instructions](#-setup-instructions)
- [Running Tests](#-running-tests)
- [Test Configurations Explained](#-test-configurations-explained)
- [Test Reports](#-test-reports)
- [Configuration](#configuration)
- [Writing Tests](#-writing-tests)
- [Troubleshooting](#-troubleshooting)
- [Benefits](#-benefits)
- [Quick Start Commands](#-quick-start-commands)
- [Additional Resources](#-additional-resources)

## 🎯 **Framework Overview**

This framework provides a **professional-grade testing solution** that combines:
- **🧪 UI Testing** - Selenium WebDriver with Page Object Model
- **🔌 API Testing** - HTTP client with JSON validation
- **🥒 BDD Approach** - Cucumber feature files and step definitions
- **📊 Comprehensive Reporting** - HTML reports and test results
- **⚙️ CI/CD Ready** - GitHub Actions integration
- **🎨 Modern Architecture** - Clean separation of concerns

## 🚀 **Overview**

**Pulsar** is a comprehensive testing framework that combines **Cucumber BDD** with **Java** and **Maven**, supporting both **UI testing** (Selenium WebDriver) and **API testing** (HTTP client). The framework provides a modern, professional testing experience with dedicated run configurations for different test types.

**Key Benefits:**
- **🚀 Fast Execution** - Optimized test runners for UI and API testing
- **🔧 Easy Maintenance** - Clean architecture with separation of concerns
- **📱 Cross-Platform** - Works on Windows, macOS, and Linux
- **🔄 CI/CD Ready** - Seamless integration with Jenkins, GitHub Actions, and more
- **📊 Rich Reporting** - Detailed HTML reports with screenshots and logs

## ✨ **Features**

- **🥒 Cucumber BDD** - Behavior-driven development with Gherkin syntax
- **🧪 UI Testing** - Selenium WebDriver integration for web application testing
- **🔌 API Testing** - HTTP client for REST API testing without browser overhead
- **🎯 Dedicated Run Configurations** - Separate configurations for UI, API, and combined tests
- **📊 HTML Reporting** - Comprehensive test reports with Cucumber integration
- **🏗️ Maven Integration** - Standard Maven build system with dependency management
- **🏷️ Tag-based Testing** - Organize and run tests by categories (@ui, @api, @smoke, etc.)
- **🌐 Cross-Browser Support** - Chrome, Firefox, Safari, and Edge
- **🔒 Parallel Execution** - Run multiple tests simultaneously

## 🎯 **Use Cases & Applications**

**Pulsar** is ideal for:
- **🏢 Enterprise Applications** - Large-scale web applications with complex UI flows
- **📱 E-commerce Platforms** - Shopping carts, product catalogs, and checkout processes
- **🏦 Banking & Finance** - Secure applications with strict validation requirements
- **🏥 Healthcare Systems** - Patient portals and medical record management
- **🎓 Educational Platforms** - Learning management systems and student portals
- **📊 SaaS Applications** - Software-as-a-Service platforms with multi-tenant architecture

## 🔍 **Why Choose Pulsar?**

| Feature | Pulsar | Traditional Frameworks |
|---------|--------|----------------------|
| **BDD Support** | ✅ Native Cucumber integration | ❌ Limited or none |
| **UI + API Testing** | ✅ Unified framework | ❌ Separate tools needed |
| **Modern Java** | ✅ Java 19+ support | ❌ Often outdated |
| **CI/CD Ready** | ✅ Built-in support | ❌ Requires configuration |
| **Reporting** | ✅ Rich HTML reports | ❌ Basic or external |
| **Maintenance** | ✅ Clean architecture | ❌ Complex structure |

## 🚀 **Performance & Scalability**

- **⚡ Fast Execution** - Optimized test runners minimize overhead
- **🔄 Parallel Testing** - Run multiple test suites simultaneously
- **📱 Cross-Platform** - Consistent behavior across operating systems
- **🌐 Cross-Browser** - Support for all major browsers
- **📊 Resource Efficient** - Minimal memory and CPU usage

## **Project Structure**

```
pulsar/
├── src/
│   ├── main/
│   │   └── resources/
│   │       └── system.properties   # Centralized configuration
│   └── test/
│       ├── java/
│       │   └── com/pulsar/
│       │       ├── cucumber/
│       │       │   ├── hooks/
│       │       │   │   ├── ui/                        # UI hooks
│       │       │   │   │   ├── UIGlobalHooks.java     # UI browser management
│       │       │   │   │   └── UIScenarioHooks.java   # UI WebDriver operations
│       │       │   │   └── api/                       # API hooks
│       │       │   │       └── APIGlobalHooks.java    # API configuration
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
- **IDE** - Modern IDE with Java and Cucumber extensions
- **Git** - Version control system

## 🚀 **Getting Started with Pulsar**

### **Quick Setup (5 minutes)**
```bash
# 1. Clone the repository
git clone <your-repository-url>
cd pulsar

# 2. Verify setup
mvn clean compile

# 3. Run your first test
mvn clean test -Dtest=APICucumberRunner
```

### **What You'll Get**
- ✅ **Ready-to-use test framework** with examples
- ✅ **Comprehensive documentation** and best practices
- ✅ **Sample test cases** for UI and API testing
- ✅ **Professional project structure** following industry standards
- ✅ **CI/CD integration** ready for production use

## 🔧 **Setup Instructions**

### **1. Clone the Repository**
```bash
git clone <your-repository-url>
cd pulsar
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

# API tests (no browser) - requires token
export API_AUTH_TOKEN="<your-gorest-token>"
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

## 📊 **Test Reports**

### **HTML Reports (Masterthought)**
- Separate reports for UI and API, with a landing page that links to both
- **Landing page**: `target/reports/index.html`
- **UI report**: `target/reports/ui/cucumber-html-reports/index.html`
- **API report**: `target/reports/api/cucumber-html-reports/index.html`
- **Attachments**: UI failures show an inline screenshot under the failing step
- **Hooks**: Hidden from the report for clarity

### **Build the reports locally**
```bash
mvn -P dev -Dmaven.test.failure.ignore=true clean test verify
open target/reports/index.html
```

### **Cucumber JSON inputs**
- Generated to `target/cucumber-reports/*.json`
- Sanitized (hooks removed) to `target/cucumber-reports/*-cucumber.nohooks.json`

### **GitHub Pages deployment**
- The workflow `.github/workflows/ci-cd-pipeline.yml` builds and publishes the entire `target/reports` folder to **GitHub Pages**
- The Pages root serves the landing page with links to both reports


## **Configuration**

### **Environment Configuration**
All configuration is centralized in `src/main/resources/system.properties`:

```properties
# API Configuration
api.base.url=https://gorest.co.in
api.users.endpoint=/public/v2/users
# Tip: Leave token empty in repo and inject via env/CI
api.auth.token=Bearer your-token-here

# Timeout Configuration
api.timeout.connection=30000
api.rate.limit.delay=0
```

### **Environment Variables**
You can override configuration at runtime. For the API token, use either:

```bash
# Option A: Maven system property
mvn test -Dtest=APICucumberRunner -Dapi.auth.token=$API_AUTH_TOKEN

# Option B: Environment variable (auto-detected)
export API_AUTH_TOKEN="<your-token>"
mvn test -Dtest=APICucumberRunner
```

In CI (GitHub Actions), define a repository secret named `API_AUTH_TOKEN` and it will be passed automatically by the workflow.

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
package com.pulsar.cucumber.stepDef.ui;

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
cd pulsar
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
- **Java Documentation:** https://docs.oracle.com/en/java/


**🎯 Pro Tip:** Use Maven commands as your primary way to execute tests. The separate test runners make it easy to switch between UI and API testing without confusion, providing a professional-grade testing experience!

**🚀 Ready to revolutionize your testing workflow? Get started with Pulsar today!**

**Happy testing! 🚀**

---

*Keywords: BDD Testing Framework, Cucumber Testing, Selenium WebDriver, API Testing, UI Automation, Java Testing, Test Automation, Behavior Driven Development, Web Testing, Mobile Testing, Cross-Browser Testing, CI/CD Testing, Test Reporting, Page Object Model, TestNG, Maven Testing*
