package co.com.practice.stepdefinitions;

import co.com.practice.models.TestData;
import co.com.practice.questions.*;
import co.com.practice.tasks.CunsumePost;
import co.com.practice.tasks.Load;
import co.com.practice.utils.DataExcel;
import co.com.practice.utils.ReadExcelFile;
import co.com.practice.utils.resource.WebServiceEndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Consequence;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

import static net.serenitybdd.screenplay.actors.OnStage.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PostStepDefinition {



    @Given("I load customer information user")
    public void iLoadCustomerInformationUser(List<Map<String, String>> data) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }


    @When("I call Post user API")
    public void iCallPostUserAPI() {
        //System.out.print("Datos::"+ TestData.getData().get("name").toString());
        //System.out.print("Datos::"+ DataExcel.DataExcelCell(1,1));
       theActorInTheSpotlight().attemptsTo(
                CunsumePost.service(
                        WebServiceEndPoints.URI.getUrl()
                )
        );

    }
    @Then("I should see the status code {int}")
    public void iShouldSeeTheStatusCode(int responseCode) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(responseCode)));
    }
    @Then("I validate quantity key is {int}")
    public void iValidateQuantityKeyIs(int quantity) {
        theActorInTheSpotlight()
                .should(seeThat(TheQuantityFieldsService.are(quantity)));
    }
    @Then("I validate schema response {string}")
    public void iValidateSchemaResponse(String schemaResponse) {
        theActorInTheSpotlight()
                .should(seeThat(TheSchemaIs.expected(schemaResponse)));
    }
    @Then("I validate fields get response api")
    public void iValidateFieldsGetResponseApi() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsGetServicesResponseAre.expected()));
    }
    @Then("I validate get response contain data expected")
    public void iValidateGetResponseContainDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuesGetResponseAre.expected()));
    }



}
