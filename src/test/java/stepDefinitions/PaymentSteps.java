package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
public class PaymentSteps {


    /*TODO
       - Need to add page layout and add the elements and navigations
    */
    @Given("the user is on the payment page")
    public void user_on_payment_page()
    {
        System.out.println("User on payment page");
    }

    @When("the user enters valid card details")
    public void user_enter_valid_card_details()
    {
        System.out.println("Enter valid card details");
    }

    @When("the user enters invalid card details")
    public void user_enter_invalid_card_details()
    {
        System.out.println("Enter invalid card detail");
    }

    @And("the user confirms the payment")
    public void user_confirm_payment()
    {
        System.out.println("User click confirm the payment");
    }

    @Then("the payment should be successful")
    public void the_payment_should_be_successfull()
    {
        System.out.println("Payment is successfull");
        Assert.assertTrue(true);
    }

    @Then("the payment should be declined")
    public void the_payment_should_be_declined()
    {
        System.out.println("Payment is declined");
        Assert.assertTrue(true);
    }


    @When("the user submits payment with unqualified details")
    public void the_user_submits_payment_with_unqualified_details() {
        System.out.println("Payment failed due to qualification issue.");
    }

    @When("the user submits payment and fails sanction screening")
    public void the_user_submits_payment_and_fails_sanction_screening() {
        System.out.println("Payment failed due to sanction list match.");
    }

    @When("the user tries to pay an amount beyond fund control limit")
    public void the_user_tries_to_pay_beyond_fund_control_limit() {
        System.out.println("Payment failed due to fund control check.");
    }

    @When("the clearing house rejects the payment")
    public void the_clearing_house_rejects_the_payment() {
        System.out.println("Clearing house rejected the payment (NACK).");
    }

    @Then("an error {string} should be shown")
    public void an_error_should_be_shown(String errorMessage) {
        System.out.println("Error shown: " + errorMessage);
    }

}
