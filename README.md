# Rooter Parental Control Manager

> Keyword-Driven Framework for automating router parental control panel tests using Selenium, Java, and TestNG.

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/technologies/downloads/)
[![Selenium](https://img.shields.io/badge/Selenium-4.40.0-green)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.11.0-orange)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-3.9%2B-purple)](https://maven.apache.org/)

## Project Description

This is a **keyword-driven test automation framework** developed in Java using Selenium WebDriver and TestNG. The project has a dual purpose:

1. **Professional Portfolio**: Demonstrates advanced skills in test automation, design patterns, and testing framework architecture.
2. **Practical Utility**: Allows you to manage (add/remove) devices from your router/modem parental control list in an automated way.

## Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17+ | Main programming language |
| **Selenium WebDriver** | 4.40.0 | Browser automation |
| **TestNG** | 7.11.0 | Test framework and execution |
| **Maven** | 3.9+ | Dependency management and build |
| **Log4j** | 2.25.3 | Logging system |

## Project Structure

```
RooterParentalControlManager/
├── pom.xml                          # Maven configuration and dependencies
├── README.md                        # Project documentation
├── .gitignore                       # Git ignored files
│
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/pinterest/
│   │   │   │   ├── featrues/        # Test cases / Features
│   │   │   │   │   ├── OnLoginPage.java
│   │   │   │   │   └── ParentalControl.java
│   │   │   │   │
│   │   │   │   ├── pages/           # Page Objects
│   │   │   │   │   └── OnLoginPage.java
│   │   │   │   │
│   │   │   │   └── steps/           # Step Definitions
│   │   │   │       ├── LoginSteps.java
│   │   │   │       ├── HomeSteps.java
│   │   │   │       └── SecuritySteps.java
│   │   │   │
│   │   │   └── com.rooter.utils/               # Framework utilities
│   │   │       └── driver/
│   │   │           ├── Browser.java
│   │   │           ├── WebDriverFactory.java
│   │   │           └── WebDriverUtil.java
│   │   │
│   │   └── resources/
│   │       └── config.properties    # Global configuration
│   │
│   └── main/
│       └── java/
│           └── com/lodionan/         # Main code (plugins)
│               └── MyMojo.java
│
└── target/                          # Build and test results
```

## Design Patterns Implemented

### 1. Page Object Model (POM)
Separates presentation logic from test code, making maintenance easier.

### 2. Keyword-Driven Framework
Tests are structured using keywords (Given/When/Then) that map to specific methods.

### 3. Factory Pattern
[`WebDriverFactory.java`](src/test/java/com.rooter.utils/driver/WebDriverFactory.java) creates WebDriver instances based on configuration.

### 4. Singleton Pattern
Centralized WebDriver management to avoid multiple instances.

---

## Installation and Usage Instructions

### Prerequisites

Before you begin, make sure you have installed:

1. **Java Development Kit (JDK) 17 or higher**
   ```cmd
   java -version
   ```

2. **Apache Maven 3.9 or higher**
   ```cmd
   mvn -version
   ```

3. **Google Chrome** (or the browser you will use for testing)

---

### Step 1: Clone the Repository

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/RooterParentalControlManager.git

# Navigate to the project directory
cd RooterParentalControlManager
```

---

### Step 2: Import into IntelliJ IDEA

1. Open **IntelliJ IDEA**
2. Select **File → Open**
3. Navigate to the project folder and select it
4. Wait for Maven to automatically download all dependencies

---

### Step 3: Configure the Environment

Edit the [`config.properties`](src/test/resources/config.properties) file with your data:

```properties
# URL of your router's parental control panel
router.url=http://192.168.1.1

# Router access credentials
router.username=admin
router.password=your_password_here

# Browser configuration
browser=chrome
headless=false

# Timeouts (in seconds)
implicit.wait=10
explicit.wait=15
page.timeout=30
```

> **Note**: The default configuration is empty. You must complete the data according to your specific router.

---

### Step 4: Compile the Project

```bash
mvn clean compile
```

You should see a message like:
```
[INFO] BUILD SUCCESS
```

---

### Step 5: Run the Tests

#### Run all tests:
```bash
mvn test
```

#### Run a specific test class:
```bash
mvn test -Dtest=ParentalControl
```

#### Run with a specific browser:
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
```

---

## Supported Browsers Configuration

The framework supports multiple browsers through the [`Browser.java`](src/test/java/com.rooter.utils/driver/Browser.java) enum:

| Browser | Code | Description |
|---------|------|-------------|
| Chrome | `chrome` | Google Chrome (recommended) |
| Firefox | `firefox` | Mozilla Firefox |
| Edge | `edge` | Microsoft Edge |
| Safari | `safari` | Safari (macOS only) |

### Configure Browser in config.properties:
```properties
browser=chrome
```

---

## Test Reports

After running tests, you can find the reports at:

- **HTML Report**: `target/surefire-reports/index.html`
- **XML Report**: `target/surefire-reports/testng-results.xml`

---

## Main Use Cases

1. **Add device to parental control**
   - Login to router
   - Navigate to security settings
   - Add device MAC address or IP
   - Save changes

2. **Remove device from parental control**
   - Login to router
   - Navigate to security settings
   - Select device to remove
   - Confirm deletion

3. **View blocked devices list**
   - Login to router
   - Access parental control panel
   - List all blocked devices

---

## Contributing

Contributions are welcome. Please:

1. Fork the project
2. Create a branch (`feature/new-feature`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Open a Pull Request

---

## License

This project is for educational and portfolio purposes.

---

## Contact

If you have questions about the framework, feel free to contact me.

---

## Useful Links

- [Selenium Official Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Page Object Model Tutorial](https://www.selenium.dev/documentation/test_practices/)
- [Cucumber Keywords](https://cucumber.io/docs/gherkin/reference/)

---

*Last updated: 2026*
