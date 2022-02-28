package co.com.practice.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import static org.hamcrest.Matchers.hasKey;

public class TheFieldsGetServicesResponseAre  implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence.seeThatResponse("Validation fields get service response exists",
                        response -> response.assertThat()
                                .body("$", hasKey("name"))
                                .body("$", hasKey("job"))
                                .body("$", hasKey("id"))
                                .body("$", hasKey("createdAt"))

                        )
        );
        return true;
    }


    public static TheFieldsGetServicesResponseAre expected() {
        return new TheFieldsGetServicesResponseAre();
    }

}
