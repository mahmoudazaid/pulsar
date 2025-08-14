# 🥒 Cucumber Plugin Setup Guide

## 🚨 **Problem: No Play Buttons in Feature Files**

If you can't see play buttons in your `.feature` files, it means the **Cucumber for Java plugin** is not installed or not properly configured in IntelliJ.

## 🔧 **Solution: Install Cucumber Plugin**

### **Step 1: Install the Plugin**

1. **Open IntelliJ IDEA**
2. **Go to File → Settings** (Windows/Linux) or **IntelliJ IDEA → Preferences** (macOS)
3. **Navigate to Plugins**
4. **Click on Marketplace tab**
5. **Search for "Cucumber for Java"**
6. **Click Install** on the official Cucumber plugin
7. **Restart IntelliJ** when prompted

### **Step 2: Verify Plugin Installation**

1. **Go to File → Settings → Plugins**
2. **Check Installed tab**
3. **Look for "Cucumber for Java"** - it should show as installed
4. **Make sure it's enabled** (checkbox should be checked)

### **Step 3: Configure Cucumber Settings**

1. **Go to File → Settings → Languages & Frameworks → Cucumber**
2. **Set Cucumber version** to match your project (likely 7.x)
3. **Set Default glue** to: `com.orange.cucumber.stepDef.ui com.orange.cucumber.stepDef.api`
4. **Click Apply and OK**

## 🎯 **Alternative: Quick Plugin Installation**

### **Method 1: From Welcome Screen**
1. **Close the project**
2. **On welcome screen, click "Plugins"**
3. **Search "Cucumber for Java"**
4. **Install and restart**

### **Method 2: From Plugin Manager**
1. **Press Ctrl+Shift+A** (Windows/Linux) or **Cmd+Shift+A** (macOS)
2. **Type "Plugins"**
3. **Select "Plugins"**
4. **Search and install "Cucumber for Java"**

## 🔍 **Verify Feature File Recognition**

### **After Plugin Installation:**

1. **Open any `.feature` file**
2. **You should see:**
   - ✅ **Green play buttons** next to each scenario
   - ✅ **Green play button** next to the Feature name
   - ✅ **Syntax highlighting** for Gherkin keywords
   - ✅ **Step definition navigation** (Ctrl+Click on steps)

### **Example of What You Should See:**

```gherkin
@ui @smoke @cart
Feature: StackDemo Cart Basic Functionality  ▶️  # Green play button here
  As a user
  I want to add items to my cart
  So that I can purchase them later

  Background:
    Given I am on the StackDemo Home Page

  @add_to_cart
  Scenario: Add item to cart  ▶️  # Green play button here
    Given I am browsing the product catalog
    When I add a product "iPhone 12" to cart
    Then the item should be added to my cart
    And the cart count should show "1"
```

## 🚨 **Common Issues and Solutions**

### **Issue 1: Plugin Not Found**
- **Solution:** Make sure you're searching for "Cucumber for Java" (not just "Cucumber")
- **Alternative:** Try "Gherkin" or "BDD" in the search

### **Issue 2: Plugin Installed But No Buttons**
- **Solution 1:** Restart IntelliJ completely
- **Solution 2:** Check if feature files are recognized as Cucumber files
- **Solution 3:** Right-click on `.feature` file → "Associate with Cucumber"

### **Issue 3: Wrong Cucumber Version**
- **Solution:** Go to Settings → Languages & Frameworks → Cucumber
- **Set version** to match your `pom.xml` (check for `cucumber-java` version)

### **Issue 4: Feature Files Not in Test Sources**
- **Solution:** Make sure feature files are in `src/test/resources/features/`
- **Alternative:** Mark the features folder as "Test Sources Root"

## 🔧 **Manual File Association**

If automatic detection doesn't work:

1. **Right-click on any `.feature` file**
2. **Select "Associate with Cucumber"**
3. **Choose "Cucumber" from the list**
4. **Click OK**

## 📋 **Complete Setup Checklist**

- [ ] **Cucumber for Java plugin installed**
- [ ] **Plugin enabled and active**
- [ ] **IntelliJ restarted after installation**
- [ ] **Cucumber settings configured**
- [ ] **Feature files in correct location**
- [ ] **Files associated with Cucumber**
- [ ] **Green play buttons visible**

## 🎮 **Testing the Setup**

### **Test 1: Feature File Recognition**
1. **Open `src/test/resources/features/ui/stackdemo_cart_basic.feature`**
2. **Look for green play buttons**
3. **Check syntax highlighting**

### **Test 2: Step Definition Navigation**
1. **Ctrl+Click** (Windows/Linux) or **Cmd+Click** (macOS) on any step
2. **Should navigate** to the corresponding step definition

### **Test 3: Run Individual Scenarios**
1. **Click the green play button** next to any scenario
2. **Should run** that specific scenario
3. **Check Run window** for results

## 🚀 **Alternative: Use Test Runner Classes**

If feature file buttons still don't work, you can still use the test runner classes:

1. **Open `UICucumberRunner.java`**
2. **Look for green play button** next to class name
3. **Click to run UI tests**

1. **Open `APICucumberRunner.java`**
2. **Look for green play button** next to class name
3. **Click to run API tests**

## 🔍 **Troubleshooting Commands**

### **Check Cucumber Version in Project:**
```bash
mvn dependency:tree | grep cucumber
```

### **Verify Feature File Structure:**
```bash
find src/test/resources/features -name "*.feature" -exec echo "Found: {}" \;
```

### **Check Plugin Installation:**
- **Go to Help → About**
- **Look for "Cucumber" in the plugin list**

## 📚 **Additional Resources**

- **Official Plugin:** https://plugins.jetbrains.com/plugin/7212-cucumber-for-java
- **Cucumber Documentation:** https://cucumber.io/docs
- **IntelliJ Help:** https://www.jetbrains.com/help/idea/cucumber.html

## 🎉 **Expected Result**

After proper setup, you should see:

✅ **Green play buttons** next to each scenario  
✅ **Green play button** next to Feature name  
✅ **Syntax highlighting** for Gherkin  
✅ **Step definition navigation**  
✅ **Integrated test execution**  
✅ **Professional BDD experience**  

---

**🎯 Pro Tip:** If you still don't see play buttons after following this guide, try creating a new IntelliJ project and importing your existing code. Sometimes plugin conflicts can cause issues that a fresh project resolves. 