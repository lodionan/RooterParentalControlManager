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
| **Lombok** | 1.18.42 | Reduce boilerplate code |
| **Typesafe Config** | 1.4.3 | Configuration management |

## Project Structure

```
RooterParentalControlManager/
├── pom.xml                                    # Maven configuration and dependencies
├── README.md                                  # Project documentation
├── IMPLEMENTATION_GUIDE.md                    # Implementation details
├── .gitignore                                 # Git ignored files
│
├── src/test/
│   ├── java/com/rooter/
│   │   ├── Hook.java                          # TestNG hooks/lifecycle
│   │   │
│   │   ├── model/
│   │   │   └── Device.java                    # Device data model
│   │   │
│   │   ├── pages/                             # Page Object Model
│   │   │   ├── BasePage.java                  # Base page with common elements
│   │   │   ├── OnHomePage.java                # Home page object
│   │   │   ├── OnLoginPage.java               # Login page object
│   │   │   └── OnSecurityPage.java           # Security settings page object
│   │   │
│   │   ├── scripts/
│   │   │   └── ParentalControlOps.java       # Test operations/keywords
│   │   │
│   │   └── utils/
│   │       ├── Browser.java                   # Browser enum
│   │       ├── BrowserUtil.java               # Browser utilities
│   │       ├── PageUtil.java                  # Page utilities
│   │       ├── Settings.java                  # Configuration settings
│   │       └── driver/
│   │           └── DriverManager.java         # WebDriver management
│   │
│   └── resources/
│       ├── config.properties                   # Application configuration
│       └── execution_xml/
│           └── ParentalControl.xml             # TestNG XML configuration
│
└── target/                                     # Build and test results
```

## Design Patterns Implemented

### 1. Page Object Model (POM)
Separates presentation logic from test code, making maintenance easier.

### 2. Keyword-Driven Framework
Tests are structured using keywords that map to specific methods in [`ParentalControlOps.java`](src/test/java/com/rooter/scripts/ParentalControlOps.java).

### 3. Factory Pattern
[`DriverManager.java`](src/test/java/com/rooter/utils/driver/DriverManager.java) creates WebDriver instances based on configuration.

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
git clone https://github.com/lodionan/RooterParentalControlManager.git

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
rooter.url=http://192.168.1.1

# Router access credentials
admin.user=admin
admin.password=your_password_here

# Browser configuration
browser.type=chrome
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
mvn test -Dtest=ParentalControlOps
```

#### Run with a specific browser:
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
```

#### Run with specific devices (add/remove):
```bash
mvn test -Ddevices="DeviceName;MAC:Address"
```

Example:
```bash
mvn test -Ddevices="DEVICE_NAME;MAC_ADDRESS,DEVICE_NAME;MAC_ADDRESS"
```

Format: `Name;MAC` where devices are separated by comma, and name is separated from MAC by semicolon.

---

## Supported Browsers Configuration

The framework supports multiple browsers through the [`Browser.java`](src/test/java/com/rooter/utils/Browser.java) enum:

| Browser | Code | Description |
|---------|------|-------------|
| Chrome | `chrome` | Google Chrome (recommended) |
| Firefox | `firefox` | Mozilla Firefox |
| Edge | `edge` | Microsoft Edge |
| Safari | `safari` | Safari (macOS only) |

### Configure Browser in config.properties:
```properties
browser.type=chrome
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

---

*Last updated: 2026*
