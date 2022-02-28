package co.com.practice.questions;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class TheSchemaIs implements Question<Boolean> {

    private final String schemaResponse;

    public TheSchemaIs(String schemaResponse) {
        this.schemaResponse = schemaResponse;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence.seeThatResponse("Validation schema service response",
                        response -> response.assertThat().body(matchesJsonSchemaInClasspath("schemas/"+schemaResponse+".json"))
                        )
        );

        return true;
    }

    public static TheSchemaIs expected(String schemaResponse) {
        return new TheSchemaIs(schemaResponse);
    }



}
