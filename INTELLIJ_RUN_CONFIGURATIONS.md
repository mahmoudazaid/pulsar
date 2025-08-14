# 🎯 IntelliJ Run Configurations Setup Guide

## 🚀 **How to Add Play Buttons for Running Tests**

This guide will show you how to set up IntelliJ run configurations that give you convenient play buttons for running different types of tests directly from the IDE.

## 📋 **Prerequisites**

- IntelliJ IDEA (Community or Ultimate)
- Cucumber for Java plugin installed
- TestNG plugin installed
- Project properly imported as Maven project

## 🎮 **Method 1: Using IntelliJ's Run Configuration UI (Recommended)**

### **Step 1: Open Run/Debug Configurations**
1. Go to **Run** → **Edit Configurations...** (or press `Ctrl+Shift+A` / `Cmd+Shift+A` and type "Edit Configurations")
2. Click the **+** button to add a new configuration
3. Select **Cucumber Java** from the list

### **Step 2: Create UI Test Runner Configuration**

**Configuration Name:** `UI Tests Runner`
- **Type:** Cucumber Java
- **Main class:** `com.orange.cucumber.runner.UICucumberRunner`
- **Module:** `orange-bdd`
- **Working directory:** `$MODULE_WORKING_DIR$`
- **VM options:** (leave empty)
- **Program arguments:** (leave empty)
- **Environment variables:** (leave empty)

**Cucumber Options:**
- **Glue:** `com.orange.cucumber.stepDef.ui com.orange.cucumber.hooks.UIGlobalHooks com.orange.cucumber.hooks.UIScenarioHooks`
- **Feature or folder path:** `src/test/resources/features/ui`
- **Tags:** `@ui or @cart`

### **Step 3: Create API Test Runner Configuration**

**Configuration Name:** `API Tests Runner`
- **Type:** Cucumber Java
- **Main class:** `com.orange.cucumber.runner.APICucumberRunner`
- **Module:** `orange-bdd`
- **Working directory:** `$MODULE_WORKING_DIR$`
- **VM options:** (leave empty)
- **Program arguments:** (leave empty)
- **Environment variables:** (leave empty)

**Cucumber Options:**
- **Glue:** `com.orange.cucumber.stepDef.api com.orange.cucumber.hooks.APIGlobalHooks com.orange.cucumber.hooks.APIScenarioHooks`
- **Feature or folder path:** `src/test/resources/features/api`
- **Tags:** `@api`

### **Step 4: Create Combined Test Runner Configuration**

**Configuration Name:** `All Tests Runner`
- **Type:** Cucumber Java
- **Main class:** `com.orange.cucumber.runner.TestRunner`
- **Module:** `orange-bdd`
- **Working directory:** `$MODULE_WORKING_DIR$`
- **VM options:** (leave empty)
- **Program arguments:** (leave empty)
- **Environment variables:** (leave empty)

**Cucumber Options:**
- **Glue:** `com.orange.cucumber.stepDef.ui com.orange.cucumber.stepDef.api com.orange.cucumber.hooks.UIGlobalHooks com.orange.cucumber.hooks.UIScenarioHooks com.orange.cucumber.hooks.APIGlobalHooks com.orange.cucumber.hooks.APIScenarioHooks`
- **Feature or folder path:** `src/test/resources/features`
- **Tags:** `not @ignore`

### **Step 5: Create Maven Test Configurations**

**Configuration Name:** `Maven UI Tests`
- **Type:** Maven
- **Command line:** `clean test -Dtest=UICucumberRunner`
- **Working directory:** `$MODULE_WORKING_DIR$`

**Configuration Name:** `Maven API Tests`
- **Type:** Maven
- **Command line:** `clean test -Dtest=APICucumberRunner`
- **Working directory:** `$MODULE_WORKING_DIR$`

**Configuration Name:** `Maven All Tests`
- **Type:** Maven
- **Command line:** `clean test -Dtest=TestRunner`
- **Working directory:** `$MODULE_WORKING_DIR$`

## 🎮 **Method 2: Direct XML Configuration (Advanced)**

If you prefer to edit the configuration files directly, you can add these configurations to your `.idea/workspace.xml` file in the `<component name="RunManager">` section.

## 🎯 **Method 3: Quick Run from Test Classes**

### **Running Individual Test Classes**
1. Open any of these files in IntelliJ:
   - `UICucumberRunner.java`
   - `APICucumberRunner.java`
   - `TestRunner.java`
2. You'll see a green play button next to the class name
3. Click it to run that specific test runner

### **Running Individual Scenarios**
1. Open any feature file (`.feature`)
2. You'll see green play buttons next to each scenario
3. Click to run individual scenarios

## 🎨 **Customizing Run Configurations**

### **Adding Environment Variables**
- **Environment variables:** `env=dev` or `env=staging` or `env=prod`

### **Adding VM Options**
- **VM options:** `-Dcucumber.filter.tags="@smoke"`

### **Adding Program Arguments**
- **Program arguments:** `--tags "@smoke" --plugin "pretty"`

## 🚀 **Using the Play Buttons**

### **Main Toolbar**
- Look for the run configuration dropdown next to the play button
- Select your desired configuration
- Click the green play button to run tests

### **Right-Click Context Menu**
- Right-click on any test file or class
- Select **Run** or **Debug**
- Choose the appropriate configuration

### **Keyboard Shortcuts**
- **Run:** `Shift+F10` (Windows/Linux) or `Ctrl+R` (macOS)
- **Debug:** `Shift+F9` (Windows/Linux) or `Ctrl+D` (macOS)
- **Stop:** `Ctrl+F2` (Windows/Linux) or `Cmd+F2` (macOS)

## 🔧 **Troubleshooting**

### **Common Issues**

1. **"Cannot find class" error**
   - Make sure the project is properly imported as Maven
   - Run `mvn clean compile` first
   - Check that the main class path is correct

2. **"No tests found" error**
   - Verify the glue paths are correct
   - Check that feature files are in the right locations
   - Ensure step definitions are properly annotated

3. **"Plugin not found" error**
   - Install the Cucumber for Java plugin
   - Restart IntelliJ after plugin installation

4. **Configuration not saving**
   - Make sure to click "Apply" and "OK"
   - Check that you have write permissions to the project

### **Verification Steps**

1. **Check Run Configurations:**
   - Go to **Run** → **Edit Configurations...**
   - Verify your configurations are listed

2. **Test Run:**
   - Select a configuration from the dropdown
   - Click the play button
   - Check the Run tool window for output

3. **Check Project Structure:**
   - Ensure all source folders are marked correctly
   - Verify Maven dependencies are resolved

## 📱 **Mobile/Tablet Support**

### **Touch-Friendly Interface**
- Use the **Run** menu instead of small buttons
- Utilize the **Project** tool window for navigation
- Use **Search Everywhere** (`Shift+Shift`) for quick access

### **Alternative Navigation**
- **Navigate** → **Class** to find test runners
- **View** → **Tool Windows** → **Run** to open run window

## 🎯 **Best Practices**

### **Configuration Naming**
- Use descriptive names: `UI Tests Runner`, `API Tests Runner`
- Include environment info: `UI Tests - Dev`, `API Tests - Staging`
- Group related configs: `Tests - Smoke`, `Tests - Full Suite`

### **Organization**
- Keep related configurations together
- Use consistent naming conventions
- Document any special settings or requirements

### **Maintenance**
- Update configurations when project structure changes
- Remove unused configurations regularly
- Test configurations after major changes

## 🚀 **Advanced Features**

### **Parallel Execution**
- Set **VM options:** `-Dcucumber.execution.parallel.enabled=true`
- Configure thread count: `-Dcucumber.execution.parallel.config.fixed.parallelism=4`

### **Custom Reports**
- Add **Program arguments:** `--plugin "html:target/custom-report.html"`
- Configure multiple output formats

### **Environment Switching**
- Create multiple configurations for different environments
- Use environment variables for dynamic configuration
- Set up profiles for different test scenarios

## 🎉 **Result**

After setting up these configurations, you'll have:

✅ **UI Tests Runner** - Play button for UI tests only
✅ **API Tests Runner** - Play button for API tests only  
✅ **All Tests Runner** - Play button for combined tests
✅ **Maven configurations** - Alternative Maven-based execution
✅ **Quick access** - Easy switching between test types
✅ **Professional setup** - Clean, organized test execution

## 🔗 **Related Documentation**

- [Cucumber for Java Plugin Documentation](https://plugins.jetbrains.com/plugin/7212-cucumber-for-java)
- [IntelliJ Run Configurations Guide](https://www.jetbrains.com/help/idea/run-debug-configuration.html)
- [TestNG Integration](https://www.jetbrains.com/help/idea/testing.html)

---

**🎯 Pro Tip:** Once you have these configurations set up, you can quickly switch between different test types using the dropdown next to the play button, making your testing workflow much more efficient! 