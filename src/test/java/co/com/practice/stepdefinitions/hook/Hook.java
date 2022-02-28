package co.com.practice.stepdefinitions.hook;

import static net.serenitybdd.screenplay.actors.OnStage.*;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook {

    private EnvironmentVariables environmentVariables;

    @Before
    public void configureBaseUrl(){
        setTheStage(new OnlineCast());
        theActorCalled("ReqRes Post Alvaro");

        String theRestApiBaseUrl = environmentVariables.optionalProperty("environments.qa.base.url")
                .orElse("environments.dev.base.url");

        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

}
