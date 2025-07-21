# 💳 UPI Payment Transaction Automation (BDD + Selenium + API)

This project automates a UPI-like payment transaction workflow using:
- **BDD with Cucumber**
- **UI Testing with Selenium**
- **API Testing with RestAssured**
- **Mock backend using json-server**

It covers end-to-end scenarios like payment success, failure, qualification errors, sanction checks, and clearing rejections.

---

## 📦 Tech Stack

- Java 11
- Maven
- Cucumber (Gherkin syntax)
- JUnit
- Selenium WebDriver
- RestAssured (API testing)
- json-server (Mock API server)
- IntelliJ IDEA Community Edition

---

## ✅ Sample Scenarios Covered


| Tool            | Purpose                              |
|-----------------|--------------------------------------|
| Java            | Programming language                 |
| Maven           | Build and dependency management      |
| Selenium        | Browser automation                   |
| Cucumber        | BDD framework                        |
| JUnit           | Test runner                          |
| IntelliJ IDEA   | IDE                                  |
=======
- ✅ Successful Payment Transaction
- ❌ Qualification Failed
- ❌ Sanction Rejected
- ❌ Fund Control Failed
- ❌ Clearing NACK


---

## 🔌 Setup Instructions

### 1. Clone the Project

```
git clone https://github.com/kushwahaarpit/payment-bdd-cucumber.git
cd bdd-cucumber-payment
```



### 2. Install Dependencies

Ensure Maven is installed and set up:

```
mvn clean install
```

### 3. Start Mock API Server

Install json-server globally:

```
npm install -g json-server
```

Start the mock API:

```
cd mock-api
json-server --watch db.json --port 3000
```

API endpoint: http://localhost:3000/payments

🚀 Run the Tests

Run all Cucumber scenarios using Maven:

```
mvn test
```

Or run from IntelliJ by right-clicking the test runner class.