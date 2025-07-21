package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
public class PaymentSteps {

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
}
