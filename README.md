# 💳 BDD Cucumber Payment Transaction Automation

This project is a real-world BDD (Behavior Driven Development) automation framework using **Cucumber**, **Selenium**, and **JUnit** to simulate a **payment transaction flow** (success and failure cases).

---

## 📌 Features Covered

- ✅ Successful payment with valid card
- ❌ Declined payment with invalid card
- ❌ Failure due to:
  - Qualification failure
  - Sanction screening failure
  - Fund control failure
  - Clearing house rejection (NACK)

---

## 🛠 Tech Stack

| Tool            | Purpose                              |
|-----------------|--------------------------------------|
| Java            | Programming language                 |
| Maven           | Build and dependency management      |
| Selenium        | Browser automation                   |
| Cucumber        | BDD framework                        |
| JUnit           | Test runner                          |
| IntelliJ IDEA   | IDE (Community Edition is enough)    |

---

## 🚀 How to Run This Project

### ✅ Prerequisites

- Java 11+
- Maven installed and configured (`MAVEN_HOME`)
- Chrome browser and [ChromeDriver](https://chromedriver.chromium.org/) added to PATH
- IntelliJ IDEA Community Edition or higher

---

### ▶️ Steps to Run

1. **Clone the repo**
   ```bash
   git clone https://github.com/kushwahaarpit/payment-bdd-cucumber.git
   cd bdd-cucumber-payment
2. Import into IntelliJ IDEA

    Open IntelliJ → Open Project → Select the cloned folder

    Make sure to enable Maven auto-import

3. Run the test

    Right-click on TestRunner.java → Run

    Or from terminal:mvn test

