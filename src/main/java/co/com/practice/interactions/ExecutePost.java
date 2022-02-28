package co.com.practice.interactions;

import co.com.practice.exceptions.ErrorServicesException;
import co.com.practice.models.JsonData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.apache.http.HttpStatus;

import java.io.IOException;

import static io.restassured.http.ContentType.JSON;

public class ExecutePost implements Interaction {

    private final String resource;
    JsonData jsonData = new JsonData();
    String data = jsonData.Json();

    public ExecutePost(String resource) throws IOException {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();

        actor.attemptsTo(

               Post.to(resource)
                .with(request -> request
                    .contentType(JSON)
                        .body(data)
                        .relaxedHTTPSValidation().log().all()
                )

                /*
                                Delete.from(resource)
                        .with(request -> request
                                .contentType(JSON).params(TestData.getData())
                                .relaxedHTTPSValidation().log().all()
                        )
                 */

        );

        if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_CREATED){
            throw new ErrorServicesException("Apparently there is an erroring the consumplion of the service");
        }


    }

    public static ExecutePost service(String resource) {
        return Tasks.instrumented(ExecutePost.class, resource);
    }

}
