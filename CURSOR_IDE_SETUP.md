# 🎯 Cucumber Setup Guide for Cursor IDE

## 🚀 **Yes! Cursor IDE Supports Cucumber with Extensions**

Cursor IDE is built on VS Code, which has excellent Cucumber support through extensions. You can absolutely get play buttons and full Cucumber functionality!

## 📋 **Prerequisites**

- **Cursor IDE** installed and running
- **Java Extension Pack** installed
- **Maven for Java** extension installed
- **Cucumber (Gherkin)** extension installed

## 🔧 **Step 1: Install Required Extensions**

### **Open Extensions Panel**
1. **Press `Ctrl+Shift+X`** (Windows/Linux) or **`Cmd+Shift+X`** (macOS)
2. **Or click the Extensions icon** in the left sidebar

### **Install These Extensions:**

#### **1. Cucumber (Gherkin) - Official Extension**
- **Search for:** `Cucumber (Gherkin)`
- **Publisher:** Cucumber
- **Features:** Syntax highlighting, IntelliSense, step definition navigation
- **Install and reload** when prompted

#### **2. Java Extension Pack**
- **Search for:** `Extension Pack for Java`
- **Publisher:** Microsoft
- **Features:** Java language support, debugging, testing
- **Install and reload** when prompted

#### **3. Maven for Java**
- **Search for:** `Maven for Java`
- **Publisher:** Microsoft
- **Features:** Maven project support, dependency management
- **Install and reload** when prompted

#### **4. Test Runner for Java**
- **Search for:** `Test Runner for Java`
- **Publisher:** Microsoft
- **Features:** Test execution, debugging, test discovery
- **Install and reload** when prompted

## 🎮 **Step 2: Configure Cucumber Settings**

### **Open Settings**
1. **Press `Ctrl+,`** (Windows/Linux) or **`Cmd+,`** (macOS)
2. **Or go to File → Preferences → Settings**

### **Search for "cucumber" and configure:**

```json
{
    "cucumber.features": [
        "src/test/resources/features/**/*.feature"
    ],
    "cucumber.glue": [
        "src/test/java/com/orange/cucumber/stepDef/ui",
        "src/test/java/com/orange/cucumber/stepDef/api"
    ],
    "cucumber.snippets": {
        "framework": "cucumber-java"
    },
    "cucumber.smartSnippets": true,
    "cucumber.strictGherkinCompletion": true
}
```

## 🎯 **Step 3: Verify Feature File Recognition**

### **Open a Feature File**
1. **Open** `src/test/resources/features/ui/stackdemo_cart_basic.feature`
2. **You should see:**
   - ✅ **Syntax highlighting** for Gherkin keywords
   - ✅ **IntelliSense** for step definitions
   - ✅ **Step definition navigation** (Ctrl+Click)
   - ✅ **Error highlighting** for undefined steps

### **Test Step Definition Navigation**
1. **Hold Ctrl** (Windows/Linux) or **Cmd** (macOS)
2. **Click on any step** (Given, When, Then)
3. **Should navigate** to the corresponding step definition

## 🚀 **Step 4: Set Up Test Execution**

### **Method 1: Using Test Explorer (Recommended)**

#### **Install Test Explorer UI**
1. **Search for:** `Test Explorer UI`
2. **Install** the extension
3. **Reload** Cursor IDE

#### **Install Java Test Runner**
1. **Search for:** `Test Runner for Java`
2. **Install** the extension
3. **Reload** Cursor IDE

### **Method 2: Using Maven Commands**

#### **Create Tasks in `.vscode/tasks.json`:**
```json
{
    "version": "2.0.0",
    "tasks": [
        {
            "label": "Run UI Tests",
            "type": "shell",
            "command": "mvn",
            "args": ["clean", "test", "-Dtest=UICucumberRunner"],
            "group": "test",
            "presentation": {
                "echo": true,
                "reveal": "always",
                "focus": false,
                "panel": "shared"
            }
        },
        {
            "label": "Run API Tests",
            "type": "shell",
            "command": "mvn",
            "args": ["clean", "test", "-Dtest=APICucumberRunner"],
            "group": "test",
            "presentation": {
                "echo": true,
                "reveal": "always",
                "focus": false,
                "panel": "shared"
            }
        },
        {
            "label": "Run All Tests",
            "type": "shell",
            "command": "mvn",
            "args": ["clean", "test", "-Dtest=TestRunner"],
            "group": "test",
            "presentation": {
                "echo": true,
                "reveal": "always",
                "focus": false,
                "panel": "shared"
            }
        }
    ]
}
```

## 🎮 **Step 5: Create Launch Configurations**

### **Create `.vscode/launch.json`:**
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Run UI Tests",
            "request": "launch",
            "mainClass": "com.orange.cucumber.runner.UICucumberRunner",
            "projectName": "orange-bdd"
        },
        {
            "type": "java",
            "name": "Run API Tests",
            "request": "launch",
            "mainClass": "com.orange.cucumber.runner.APICucumberRunner",
            "projectName": "orange-bdd"
        },
        {
            "type": "java",
            "name": "Run All Tests",
            "request": "launch",
            "mainClass": "com.orange.cucumber.runner.TestRunner",
            "projectName": "orange-bdd"
        }
    ]
}
```

## 🎯 **Step 6: Using the Test Runner**

### **Method 1: Test Explorer View**
1. **Click the Test Explorer icon** in the left sidebar
2. **Expand your project**
3. **Right-click on test classes** to run/debug
4. **See test results** in the Test Explorer panel

### **Method 2: Command Palette**
1. **Press `Ctrl+Shift+P`** (Windows/Linux) or **`Cmd+Shift+P`** (macOS)
2. **Type:** `Java: Run Tests`
3. **Select** the test class or method to run

### **Method 3: Code Lens**
1. **Open** any test runner class
2. **Look for "Run Test"** above the class declaration
3. **Click** to run all tests in that class

### **Method 4: Maven Tasks**
1. **Press `Ctrl+Shift+P`** (Windows/Linux) or **`Cmd+Shift+P`** (macOS)
2. **Type:** `Tasks: Run Task`
3. **Select** your desired test task

## 🔍 **Step 7: Verify Setup**

### **Check Extensions**
1. **Go to Extensions** (`Ctrl+Shift+X`)
2. **Verify all required extensions** are installed and enabled
3. **Check for any error messages** in the Extensions panel

### **Test Feature File Support**
1. **Open** any `.feature` file
2. **Verify syntax highlighting** works
3. **Test step definition navigation** (Ctrl+Click)
4. **Check for IntelliSense** suggestions

### **Test Test Execution**
1. **Open** any test runner class
2. **Look for "Run Test"** code lens
3. **Try running** a simple test
4. **Check** the Test Explorer for results

## 🎨 **Customization Options**

### **Theme and Colors**
- **Install themes** that support Cucumber syntax
- **Customize colors** in settings for better visibility
- **Use icons** to distinguish different file types

### **Keybindings**
- **Customize shortcuts** for common Cucumber actions
- **Set up quick access** to test runners
- **Configure debugging** shortcuts

### **Workspace Settings**
- **Project-specific** Cucumber configuration
- **Team-shared** settings in `.vscode/settings.json`
- **Environment-specific** configurations

## 🚨 **Troubleshooting**

### **Common Issues**

#### **1. Extensions Not Working**
- **Solution:** Reload Cursor IDE after installation
- **Alternative:** Check extension compatibility
- **Verify:** Java project is properly loaded

#### **2. Feature Files Not Recognized**
- **Solution:** Check file associations
- **Alternative:** Right-click → "Configure File Association for '.feature'"
- **Verify:** Cucumber extension is enabled

#### **3. Step Definitions Not Found**
- **Solution:** Check glue paths in settings
- **Alternative:** Verify step definition annotations
- **Verify:** Java extension is working

#### **4. Tests Not Running**
- **Solution:** Check Java runtime configuration
- **Alternative:** Verify Maven setup
- **Verify:** Test runner extension is installed

### **Debug Steps**
1. **Check Output panel** for error messages
2. **Verify Java extension** is working
3. **Check Maven** project structure
4. **Verify Cucumber** dependencies in pom.xml

## 🎉 **Expected Results**

After proper setup, you'll have:

✅ **Syntax highlighting** in feature files  
✅ **IntelliSense** for step definitions  
✅ **Step definition navigation** (Ctrl+Click)  
✅ **Test execution** through multiple methods  
✅ **Integrated debugging** support  
✅ **Professional BDD experience** in Cursor IDE  

## 🚀 **Quick Start Commands**

### **Install Extensions:**
```bash
# Open Extensions panel
Ctrl+Shift+X (Windows/Linux) or Cmd+Shift+X (macOS)

# Search and install:
# - Cucumber (Gherkin)
# - Extension Pack for Java
# - Maven for Java
# - Test Runner for Java
```

### **Run Tests:**
```bash
# Using Maven
mvn clean test -Dtest=UICucumberRunner
mvn clean test -Dtest=APICucumberRunner
mvn clean test -Dtest=TestRunner

# Using VS Code tasks
Ctrl+Shift+P → Tasks: Run Task
```

### **Debug Tests:**
```bash
# Using launch configurations
F5 → Select test configuration
# Or
Ctrl+Shift+P → Debug: Start Debugging
```

## 📚 **Additional Resources**

- **Cursor IDE Documentation:** https://cursor.sh/docs
- **VS Code Java Extension:** https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack
- **Cucumber Extension:** https://marketplace.visualstudio.com/items?itemName=alexkrechik.cucumberautocomplete
- **Java Testing Guide:** https://code.visualstudio.com/docs/java/java-testing

---

**🎯 Pro Tip:** Cursor IDE with the right extensions can provide an excellent Cucumber development experience, often with better performance than some traditional IDEs. The key is having all the right extensions installed and properly configured! 