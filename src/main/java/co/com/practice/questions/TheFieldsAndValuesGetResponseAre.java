package co.com.practice.questions;

import co.com.practice.models.TestData;
import co.com.practice.utils.DataExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class TheFieldsAndValuesGetResponseAre implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence.seeThatResponse("Validation fields and values post service response exists",
                        response -> {
                            try {
                                response.assertThat()
                                        .and().body("name", equalTo(DataExcel.DataExcelCell(2,1)))
                                        .and().body("job", equalTo(DataExcel.DataExcelCell(2,2)));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        )
        );
        return true;
    }

    public static TheFieldsAndValuesGetResponseAre expected() {
        return new TheFieldsAndValuesGetResponseAre();
    }

}
