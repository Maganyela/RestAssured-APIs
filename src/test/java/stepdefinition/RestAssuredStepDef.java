package stepdefinition;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;


public class RestAssuredStepDef {

    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int ResponseCode;
    public ResponseBody body;
    public JsonPath jsonPath;
    public String email;
    public String password;
    static ExtentReports report;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();


// Create the user account
    @Given("I hit the post url to create account endpoint")
    public void I_hit_the_post_url_to_create_account_endpoint() {

        test = extent.createTest("To create User account with the request");
        RestAssured.baseURI = "https://automationexercise.com/api/";
        httpRequest = RestAssured.given();

    }

    @When("I pass the body of the create account request")
    public void i_pass_the_url_in_the_create_account_request() {

        response = httpRequest
                .multiPart("name", "Mpho")
                .multiPart("email", "mpho14@gmail.com")
                .multiPart("title", "Mr")
                .multiPart("birthday", "18")
                .multiPart("birthmonth", "11")
                .multiPart("birthyear", "2001")
                .multiPart("firstname", "Vitwend")
                .multiPart("lastname", "Maganyela")
                .multiPart("company", "Digilink")
                .multiPart("address1", "Tembisa")
                .multiPart("country", "South Africa") // Corrected the key from "Mpho" to "country"
                .multiPart("state", "Gauteng")
                .multiPart("city", "Midrand")
                .multiPart("zipcode", "0112")
                .multiPart("password", "Maganyela@09")
                .multiPart("mobile_number", "0818363640")
                .post("createAccount");

    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(Integer int1) {

        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode,200);

        System.out.println(response.getStatusLine());
        System.out.println(response.getBody().asString());
    }

    // Get the user by the email
    @Given("I hit the Get Url to get the User by Email")
    public void i_hit_the_get_url_to_get_the_user_by_email() {

        RestAssured.baseURI = "https://automationexercise.com/api/";
        httpRequest = RestAssured.given();
    }

    @When("I pass the Email {string} in the request")
    public void i_pass_the_email_in_the_request(String email) {

        this.email = email;
        response = httpRequest.get("getUserDetailByEmail?email="+email);
    }

    @Then("I receive the response code as 200 for the request")
    public void i_receive_the_response_code_as_200_for_the_request() {

        ResponseCode = response.getStatusCode();
        assertEquals(ResponseCode,200);

        System.out.println(response.getStatusLine());
//        System.out.println(response.getBody().asString());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            String jsonResponse = objectWriter.writeValueAsString(response.jsonPath().getMap("$"));
            System.out.println(jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Get all the product list
    @Given("I hit the Get Url to get all the product")
    public void i_hit_the_get_url_to_get_all_the_product() {

        RestAssured.baseURI = "https://automationexercise.com/api/";
        httpRequest = RestAssured.given();
    }

    @When("I pass the request i get all the product")
    public void i_pass_the_request_i_get_all_the_product() {

        response = httpRequest.get("productsList");
    }

    // Get all the brands list
    @Given("I hit the Get Url to get all the brands")
    public void i_hit_the_get_url_to_get_all_the_brands() {

        RestAssured.baseURI = "https://automationexercise.com/api/";
        httpRequest = RestAssured.given();
    }

    @When("I pass the request i get all the brands")
    public void i_pass_the_request_i_get_all_the_brands() {

        response = httpRequest.get("brandsList");
    }

    // Search the product by its name
    @Given("I hit the Post Url to search the product")
    public void i_hit_the_post_url_to_search_the_product() {

        RestAssured.baseURI = "https://automationexercise.com/api";
        httpRequest = RestAssured.given();
    }

    @When("I pass the body of the Search the product request")
    public void i_pass_the_body_of_the_search_the_product_request() {

        response = httpRequest
                .multiPart("search_product","Blue Top")
                .post("searchProduct");
    }

    // Search the product with no name
    @When("I pass body of the search with no product name request")
    public void i_pass_body_of_the_search_with_no_product_name_request() {

        response = httpRequest
                .multiPart("search_product", "")
                .post("searchProduct");
    }

    // Login with a Valid email and or password
    @Given("I hit the post url to Login")
    public void i_hit_the_post_url_to_login() {

        RestAssured.baseURI = "https://automationexercise.com/api/";
        httpRequest = RestAssured.given();
    }

    @When("I pass body of the Valid email {string} and Valid Password {string} request")
    public void i_pass_body_of_the_invalid_email_and_or_password_request(String password, String email) {

        this.password = password;
        this.email = email;
        response = httpRequest
                .multiPart("email", email)
                .multiPart("password", password)
                .post("verifyLogin");
    }

        // Update the user account details
    @Given("I hit the Put Url to update the User details")
    public void i_hit_the_put_url_to_update_the_user_details() {

        RestAssured.baseURI = "https://automationexercise.com/api/";
        httpRequest = RestAssured.given();
    }

    @When("I pass body of the user account details in the request")
    public void i_pass_body_of_the_user_account_details_in_the_request() {

        response = httpRequest
                .multiPart("name", "Mpho")
                .multiPart("email", "mpho14@gmail.com")
                .multiPart("title", "Mr")
                .multiPart("birthday", "16")
                .multiPart("birthmonth", "09")
                .multiPart("birthyear", "2001")
                .multiPart("firstname", "Vitwend")
                .multiPart("lastname", "Maganyela")
                .multiPart("company", "Digilink")
                .multiPart("address1", "Mamelodi")
                .multiPart("country", "South Africa") // Corrected the key from "Mpho" to "country"
                .multiPart("state", "Gauteng")
                .multiPart("city", "Pitori")
                .multiPart("zipcode", "0112")
                .multiPart("password", "Maganyela@09")
                .multiPart("mobile_number", "0818363640")
                .put("updateAccount");
    }

    // Delete the user account in the database
    @Given("I hit the Delete Url to delete the user account")
    public void i_hit_the_delete_url_to_delete_the_user_account() {

        RestAssured.baseURI = "https://automationexercise.com/api/";
        httpRequest = RestAssured.given();
    }

    @When("I pass the email and password detail in the request")
    public void i_pass_the_email_and_password_detail_in_the_request() {

        response = httpRequest
                .multiPart("email", "mpho@gmail.com")
                .multiPart("password", "Maganyela@09")
                .delete("deleteAccount");
    }

}
