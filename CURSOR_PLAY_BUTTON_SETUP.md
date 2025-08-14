# 🎯 Cursor IDE Play Button Setup Guide

## 🚀 **Your Run Configurations Are Ready!**

You now have **exactly the same setup** as shown in the image - dedicated run configurations for UI Tests, API Tests, and All Tests that appear in the play button dropdown!

## 🎮 **How to Access Your Run Configurations**

### **Method 1: Run and Debug Panel (Recommended)**

1. **Click the Run and Debug icon** in the left sidebar (▶️ icon)
2. **Look at the dropdown** at the top of the panel
3. **You'll see your configurations:**
   - 🧪 **UI Tests** - UI testing with browser
   - 🔌 **API Tests** - API testing without browser
   - 🚀 **All Tests** - Complete test suite
   - 🐛 **Debug UI Tests** - Debug UI tests
   - 🐛 **Debug API Tests** - Debug API tests
   - 🐛 **Debug All Tests** - Debug complete suite

### **Method 2: Command Palette**

1. **Press `Ctrl+Shift+P`** (Windows/Linux) or **`Cmd+Shift+P`** (macOS)
2. **Type:** `Debug: Start Debugging`
3. **Select** your desired configuration

### **Method 3: Keyboard Shortcut**

1. **Press `F5`** to start debugging
2. **Select** your desired configuration from the dropdown

## 🎯 **Your Run Configurations Explained**

### **🧪 UI Tests**
- **Main Class:** `UICucumberRunner`
- **Tags:** `@ui or @cart`
- **Browser:** ✅ Starts browser for UI testing
- **Use Case:** When you want to test UI functionality with Selenium
- **What it does:** Runs all UI-related tests from `features/ui/` folder

### **🔌 API Tests**
- **Main Class:** `APICucumberRunner`
- **Tags:** `@api`
- **Browser:** ❌ No browser (pure HTTP client testing)
- **Use Case:** When you want to test API endpoints without browser overhead
- **What it does:** Runs all API-related tests from `features/api/` folder

### **🚀 All Tests**
- **Main Class:** `TestRunner`
- **Tags:** `not @ignore`
- **Browser:** ✅ Starts browser (includes UI tests)
- **Use Case:** When you want to run the complete test suite
- **What it does:** Runs both UI and API tests from all feature folders

## 🎨 **Visual Configuration Names**

Your configurations are clearly labeled with emojis for easy identification:

- **🧪 UI Tests** - UI testing with browser
- **🔌 API Tests** - API testing without browser
- **🚀 All Tests** - Complete test suite
- **🐛 Debug UI Tests** - Debug UI tests with breakpoints
- **🐛 Debug API Tests** - Debug API tests with breakpoints
- **🐛 Debug All Tests** - Debug complete suite with breakpoints

## 🚀 **Using the Play Button**

### **Step 1: Select Configuration**
1. **Click the dropdown** next to the play button
2. **Choose your desired configuration:**
   - **🧪 UI Tests** for UI testing
   - **🔌 API Tests** for API testing
   - **🚀 All Tests** for complete testing

### **Step 2: Run Tests**
1. **Click the green play button** ▶️ to run tests
2. **Click the bug button** 🐛 to debug with breakpoints
3. **Watch the Debug Console** for test output

### **Step 3: View Results**
1. **Check the Debug Console** for real-time output
2. **Look for test results** in the console
3. **Check the terminal** for Maven output

## 🔧 **Pre-Launch Tasks**

Each configuration automatically runs these tasks before execution:

1. **⚙️ Compile Project** - Compiles your Java code
2. **🧹 Clean Project** - Cleans previous builds
3. **Environment Setup** - Sets up test environment

## 🎯 **Example Usage**

### **Running UI Tests:**
1. **Select "🧪 UI Tests"** from dropdown
2. **Click play button** ▶️
3. **Watch browser start** and run UI tests
4. **Check Debug Console** for results

### **Running API Tests:**
1. **Select "🔌 API Tests"** from dropdown
2. **Click play button** ▶️
3. **No browser starts** - pure API testing
4. **Check Debug Console** for results

### **Debugging Tests:**
1. **Set breakpoints** in your step definitions
2. **Select debug configuration** (🐛 Debug UI Tests)
3. **Click bug button** 🐛
4. **Step through code** line by line

## 🎉 **What You'll See**

### **In the Dropdown:**
```
🧪 UI Tests          ▶️
🔌 API Tests         ▶️
🚀 All Tests         ▶️
🐛 Debug UI Tests    🐛
🐛 Debug API Tests   🐛
🐛 Debug All Tests   🐛
```

### **In the Debug Console:**
```
✅ API base URL configured: https://gorest.co.in
✅ Authentication token configured
✅ Test user data prepared: TestUser 1234567890
📤 Created user: John Doe
✅ Response status code: 201
✅ Response contains valid JSON
✅ Response contains created user data
✅ User has unique ID: 12345
```

## 🚨 **Troubleshooting**

### **Configuration Not Found**
1. **Check** that `.vscode/launch.json` exists
2. **Verify** Java extension is installed
3. **Reload** Cursor IDE after configuration changes

### **Tests Not Running**
1. **Check** that `preLaunchTask` exists in tasks.json
2. **Verify** Maven is properly configured
3. **Check** Java runtime configuration

### **Browser Not Starting for UI Tests**
1. **Verify** you selected "🧪 UI Tests" configuration
2. **Check** that Selenium dependencies are resolved
3. **Verify** WebDriver configuration

## 🎯 **Quick Reference**

### **Run Configurations (F5)**
- **🧪 UI Tests** - UI testing with browser
- **🔌 API Tests** - API testing without browser
- **🚀 All Tests** - Complete test suite

### **Debug Configurations (🐛)**
- **🐛 Debug UI Tests** - Debug UI tests
- **🐛 Debug API Tests** - Debug API tests
- **🐛 Debug All Tests** - Debug complete suite

## 🎉 **Result**

You now have **professional-grade run configurations** in Cursor IDE that:

✅ **Appear in the play button dropdown** just like Node.js projects  
✅ **Separate UI and API testing** with dedicated configurations  
✅ **Provide dedicated play buttons** for each test type  
✅ **Support debugging** with breakpoints  
✅ **Manage environments** automatically  
✅ **Integrate with Maven** seamlessly  
✅ **Offer modern IDE experience** for testing  

---

**🎯 Pro Tip:** Use the Run and Debug panel as your primary way to execute tests. The separate configurations make it easy to switch between UI and API testing without confusion, exactly like the professional setup shown in the image! 