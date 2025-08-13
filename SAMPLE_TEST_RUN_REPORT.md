# Sample Test Run Report - StackDemo Cart Operations

**Test Execution Date:** December 15, 2024  
**Environment:** Development  
**Browser:** Chrome 120.0.6099.109  
**Framework Version:** Cucumber 7.27.0 + TestNG 7.11.0  

## Executive Summary

| Metric | Value |
|--------|-------|
| Total Scenarios | 8 |
| Passed | 7 |
| Failed | 1 |
| Skipped | 0 |
| Success Rate | 87.5% |
| Execution Time | 2m 34s |

## Test Results by Feature

### 1. StackDemo Basic Cart Operations (`stackdemo_cart_basic.feature`)

#### ✅ Add item to cart
- **Duration:** 12.3s
- **Status:** PASSED
- **Steps:** 5/5 passed
- **Tags:** @smoke @cart

#### ✅ Add multiple items to cart
- **Duration:** 18.7s
- **Status:** PASSED
- **Steps:** 6/6 passed
- **Tags:** @smoke @cart

#### ✅ Update item quantity in cart
- **Duration:** 15.2s
- **Status:** PASSED
- **Steps:** 4/4 passed
- **Tags:** @cart @quantity

#### ✅ Remove item from cart
- **Duration:** 14.8s
- **Status:** PASSED
- **Steps:** 5/5 passed
- **Tags:** @cart @remove

#### ✅ Proceed to checkout with items in cart
- **Duration:** 22.1s
- **Status:** PASSED
- **Steps:** 5/5 passed
- **Tags:** @cart @checkout

#### ✅ Add out of stock item to cart
- **Duration:** 8.9s
- **Status:** PASSED
- **Steps:** 4/4 passed
- **Tags:** @cart @validation

#### ✅ Verify cart total calculation
- **Duration:** 16.4s
- **Status:** PASSED
- **Steps:** 4/4 passed
- **Tags:** @cart @total

### 2. StackDemo Advanced Cart Operations (`stackdemo_cart_operations.feature`)

#### ❌ Apply valid coupon code to cart
- **Duration:** 0.0s
- **Status:** FAILED
- **Steps:** 2/4 passed
- **Tags:** @cart @coupon
- **Error:** Element not found: coupon input field
- **Screenshot:** `target/screenshots/coupon_test_failure_20241215_143022.png`

## Detailed Test Results

### Passed Scenarios

1. **Add item to cart** - Successfully added iPhone 12 to cart, cart count increased to 1
2. **Add multiple items to cart** - Added 3 items (iPhone 12 x2, Samsung TV x1), total cart count: 3
3. **Update item quantity in cart** - Updated iPhone 12 quantity from 2 to 3, total updated correctly
4. **Remove item from cart** - Removed Samsung TV, cart count decreased to 2
5. **Proceed to checkout** - Successfully navigated to checkout page with all cart items
6. **Add out of stock item** - Properly handled out-of-stock scenario, button disabled
7. **Verify cart total calculation** - Subtotal $2599.97 calculated correctly

### Failed Scenarios

1. **Apply valid coupon code to cart**
   - **Failure Point:** Step 3 - "When I apply coupon code 'SAVE20'"
   - **Error Message:** `org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"id","selector":"coupon-input"}`
   - **Root Cause:** Coupon input field locator not found on the page
   - **Recommendation:** Update page locator or verify page structure

## Performance Metrics

| Scenario Type | Average Duration | Min Duration | Max Duration |
|---------------|------------------|--------------|--------------|
| Smoke Tests | 15.5s | 12.3s | 18.7s |
| Cart Operations | 16.8s | 8.9s | 22.1s |
| Validation Tests | 8.9s | 8.9s | 8.9s |
| Checkout Tests | 22.1s | 22.1s | 22.1s |

## Environment Details

- **Base URL:** https://stackdemo.dev.example.com
- **Browser Version:** Chrome 120.0.6099.109
- **WebDriver Version:** ChromeDriver 120.0.6099.109
- **OS:** macOS 14.2.1
- **Java Version:** OpenJDK 1.8.0_392
- **Maven Version:** 3.9.5

## Screenshots and Evidence

- **Passed Tests:** No screenshots captured (default behavior)
- **Failed Tests:** 1 screenshot captured for coupon test failure
- **Location:** `target/screenshots/`

## Console Logs

```
[INFO] Running TestSuite
[INFO] Tests run: 8, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 154.234 s
[INFO] Results:
[INFO] Tests run: 8, Failures: 1, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-surefire-plugin:3.5.3:test (default-test) @ orange-bdd ---
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 8, Failures: 1, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:34 min
[INFO] Finished at: 2024-12-15T14:30:22+00:00
[INFO] ------------------------------------------------------------------------
```

## Recommendations

### Immediate Actions
1. **Fix Coupon Test:** Update the coupon input field locator in the page object
2. **Add Error Handling:** Implement better error handling for missing elements
3. **Update Test Data:** Verify test data matches current application state

### Long-term Improvements
1. **Element Wait Strategy:** Implement explicit waits for dynamic elements
2. **Test Data Management:** Centralize test data configuration
3. **Parallel Execution:** Enable parallel test execution for faster feedback
4. **Retry Mechanism:** Implement retry logic for flaky tests

## Next Steps

1. **Debug Failed Test:** Investigate coupon functionality and update locators
2. **Re-run Tests:** Execute test suite after fixes
3. **Performance Review:** Analyze test execution times for optimization
4. **Documentation Update:** Update test documentation based on findings

---

**Report Generated:** December 15, 2024 14:30:22 UTC  
**Framework:** Cucumber + TestNG + Selenium  
**Generated By:** StackDemo Cart Automation Framework 