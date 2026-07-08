#  ParaBank Playwright Automation Framework

## 📌 Overview

This project is an end-to-end UI Automation Framework developed for the ParaBank Banking Application using **Playwright with Java**.

The framework automates critical banking workflows and follows industry-standard automation design principles such as:

- Page Object Model (POM)
- Reusable Components
- Centralized Driver Management
- Data Driven Testing
- Cross Browser Testing
- Extent Reporting
- Screenshot Capture

The framework is designed to be scalable, maintainable, reusable, and interview-ready.

---

## 🎯 Objective

The objective of this automation framework is to validate core banking functionalities of the ParaBank application through automated UI testing.

### Automated Business Flows

- Customer Registration
- Login Validation
- Bill Payment
- Find Transactions
- Transfer Funds
- Request Loan
- Update Contact Information
- Logout
- End-to-End Workflow

---

## 🛠 Technology Stack

### Programming Language

- Java 17

### Automation Tool

- Playwright

### Test Framework

- JUnit 5

### Build Tool

- Maven

### Reporting Tool

- Extent Reports

### Test Data Management

- Apache POI

### IDE

- Eclipse

### Version Control

- Git
- GitHub

### Design Pattern

- Page Object Model (POM)

---

## 🏗 Framework Architecture

```text
src/test/java

base/
│
└── BaseTest.java

pages/
│
├── LoginPage.java
├── RegisterPage.java
├── DashboardPage.java
├── BillPayPage.java
├── FindTransactionPage.java
├── TransferFundsPage.java
├── RequestLoanPage.java
└── UpdateContactInfoPage.java

tests/
│
├── RegisterTest.java
├── LoginTest.java
├── BillPayTest.java
├── FindTransactionTest.java
├── TransferFundsTest.java
├── RequestLoanTest.java
├── UpdateContactInfoTest.java
├── EndToEndTest.java
└── DataDrivenRegisterTest.java

utils/
│
├── DriverFactory.java
├── DriverManager.java
├── PropertyReader.java
├── ExcelReader.java
├── ExtentManager.java
└── FrameworkException.java

src/test/resources/
│
├── config.properties
└── testdata/
    └── parabankNames.xlsx
```

---

## 📖 Framework Design Approach

### ✅ Page Object Model (POM)

The framework follows the Page Object Model design pattern.

Each application page is represented by a separate Java class.

Examples:

```java
LoginPage
BillPayPage
TransferFundsPage
RequestLoanPage
```

UI interactions are encapsulated into reusable methods.

Example:

```java
login();

performBillPayment();

transferFunds();
```

### Benefits

- Better Maintainability
- Better Readability
- Better Reusability
- Reduced Code Duplication

---

## ✅ Layered Architecture

The framework is divided into multiple layers.

### Base Layer

Responsible for test setup and teardown.

```text
BaseTest
```

### Page Layer

Responsible for page interactions.

```text
LoginPage
RegisterPage
BillPayPage
TransferFundsPage
```

### Utility Layer

Responsible for reusable framework functionalities.

```text
DriverFactory
DriverManager
ExcelReader
ExtentManager
```

### Test Layer

Responsible for business scenario execution.

```text
RegisterTest
LoginTest
TransferFundsTest
RequestLoanTest
```

---

## 🎭 Driver Management

Browser management is centralized using:

```java
DriverFactory
DriverManager
```

### Responsibilities

- Browser Initialization
- Browser Closure
- Context Creation
- Page Creation
- Navigation Handling

### Benefits

- Better Maintainability
- Centralized Browser Management
- Easier Configuration
- Supports Cross Browser Execution

---

## 🌐 Cross Browser Testing

The framework supports:

- Chromium
- Microsoft Edge
- Firefox
- WebKit

Browser execution can be controlled through:

```properties
BROWSER=chromium
```

or

```properties
BROWSER=edge
```

or

```properties
BROWSER=firefox
```

or

```properties
BROWSER=webkit
```

No test code changes are required.

---

## 🎯 Playwright Features Used

### Modern Locators

```java
page.locator()

page.getByText()

page.getByRole()

page.getByLabel()

page.getByPlaceholder()

page.getByTestId()
```

### Auto Waiting

Playwright automatically waits for:

- Visibility
- Clickability
- Element Availability

This reduces flaky test execution.

### BrowserContext

Each execution runs inside an isolated browser context.

Benefits:

- Independent Sessions
- Better Test Isolation
- Parallel Execution Ready

---

## 📊 Data Driven Testing

The framework supports Data Driven Testing using Excel files.

### Technologies

```text
Apache POI
```

### Utility Class

```java
ExcelReader
```

### Benefits

- Externalized Test Data
- Multiple User Execution
- Reduced Hardcoding
- Easy Maintenance

---

## 📋 Reporting Mechanism

Reporting is implemented using:

```text
Extent Reports
```

### Features

- Pass / Fail Status
- Step Level Logging
- Execution Summary
- Failure Tracking
- Screenshot Capture

Example:

```java
test.pass();

test.info();

test.fail();
```

---

## 📸 Screenshot Capture

Failure screenshots are automatically captured and embedded in Extent Reports.

### Implementation

```java
ExtentManager.captureScreenshotBase64();
```

### Benefits

- Faster Debugging
- Better Failure Analysis
- Embedded Screenshots
- Improved Traceability

---

## ⚠ Exception Handling

The framework implements centralized exception handling.

Example:

```java
try {

    // Test Logic

}
catch(Throwable e) {

    test.fail(...);

}
```

### Benefits

- Controlled Failures
- Better Stability
- Meaningful Error Reporting

---

## 🔄 Reusable Wrapper Methods

Common UI actions are centralized in BasePage.

Examples:

```java
click()

enterText()

getText()
```

### Benefits

#### Maintainability

Application changes require updates in only one place.

#### Readability

Business actions become easy to understand.

Example:

```java
loginPage.login();
```

instead of

```java
page.locator(...).fill();
page.locator(...).click();
```

#### Reusability

Methods can be reused across multiple test scenarios.

Example:

```java
login()
```

used in:

- BillPayTest
- TransferFundsTest
- RequestLoanTest
- FindTransactionTest
- UpdateContactInfoTest

---
## 🔁 End-to-End Workflow

```text
Register User
      ↓
Login
      ↓
Bill Payment
      ↓
Logout
```

---

## ▶ Execution Instructions

### Clone Repository

```bash
git clone <repository-url>
```

### Navigate To Project

```bash
cd Parabank-Playwright-Framework
```

### Install Dependencies

```bash
mvn clean install
```

### Execute Test Suite

```bash
mvn test
```

or execute individual test classes from Eclipse.

---

## ⭐ Framework Highlights

✅ Playwright Automation

✅ Java + JUnit 5

✅ Page Object Model (POM)

✅ Cross Browser Testing

✅ Extent Reports

✅ Screenshot Capture

✅ Data Driven Testing

✅ Apache POI Integration

✅ Excel Driven Execution

✅ Reusable Components

✅ Exception Handling

✅ Thread-Safe Driver Management

✅ Configuration Driven Execution

✅ Maven Integration

✅ GitHub Integration

---

## 📦 Deliverables

This repository contains:

- Complete Playwright Automation Framework
- Source Code Repository
- Automated Test Scenarios
- Configuration Files
- Test Data Files
- Extent Report
- Supporting Artifacts
- Execution Instructions
- Project Documentation

---

## 🎯 Conclusion

The ParaBank Playwright Automation Framework provides a scalable, maintainable, and reusable automation solution for validating core banking operations. The framework leverages Playwright's modern automation capabilities, Page Object Model architecture, Data Driven Testing, Extent Reporting, Cross Browser Execution, and reusable utility classes to deliver reliable and efficient test automation.
