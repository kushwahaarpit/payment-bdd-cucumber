package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import static org.junit.Assert.assertEquals;

public class UPIPaymentSteps {

    private String bankAccount;
    private String upiId;
    private double amount;
    private String remark;
    private String result;
    private WebDriver driver;

    private String paymentStatus;

    @Given("the user selects bank account {string}")
    public void the_user_selects_bank_account(String bank) {
        this.bankAccount = bank;
    }

    @Given("enters UPI ID {string} and amount {string} with remark {string}")
    public void enters_details(String upiId, String amount, String remark) {
        this.upiId = upiId;
        this.amount = Double.parseDouble(amount);
        this.remark = remark;
    }

    @Given("the user provides UPI ID {string}")
    public void the_user_provides_upi_id(String upi) {
        this.upiId = upi;
    }

    @When("the system checks the payment status from mock API")
    public void the_system_checks_payment_status() {
        String response = RestAssured
                .get("http://localhost:3000/payments?upiId=" + upiId)
                .asString();

        JsonPath json = new JsonPath(response);
        this.paymentStatus = json.getString("status[0]");
    }

    @Then("the payment result should be {string}")
    public void the_payment_result_should_be(String expectedStatus) {
        System.out.println("API Response: " + paymentStatus);
        assertEquals(expectedStatus, paymentStatus);
    }
    @When("the user initiates the UPI payment")
    public void the_user_initiates_payment() {
        if (upiId.contains("failengine")) {
            result = "Payment Engine validation failed";
        } else if (upiId.contains("nobalance") && amount > 10000) {
            result = "Insufficient balance";
        } else if (upiId.contains("clearnack")) {
            result = "Clearing NACK from bank";
        } else {
            result = "Payment Successful";
        }
    }

    @Then("payment should {word} with message {string}")
    public void verify_payment_result(String status, String message) {
        Assert.assertEquals(message, result);
    }

    @Given("the user launches the payment form")
    public void launchPaymentForm() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("file:///path/to/payment-form.html");
    }

    @When("user fills form and submits with valid data")
    public void fillAndSubmitForm() {
        driver.findElement(By.id("bank")).sendKeys("SBI");
        driver.findElement(By.id("upiId")).sendKeys("test@upi");
        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("remark")).sendKeys("Test payment");
        driver.findElement(By.id("submitBtn")).click();
    }

    @Then("the confirmation page should show {string}")
    public void checkConfirmationMessage(String expected) {
        WebElement message = driver.findElement(By.id("result"));
        Assert.assertEquals(expected, message.getText());
        driver.quit();
    }

    @When("the system checks payment status for UPI ID {string}")
    public void checkPaymentStatus(String upiId) {
        String response = RestAssured
                .get("http://localhost:3000/payments?upiId=" + upiId)
                .asString();

        JsonPath json = new JsonPath(response);
        result = json.getString("status[0]");
    }
}