package co.com.practice.tasks;

import co.com.practice.interactions.ExecutePost;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CunsumePost implements Task {

    private final String resource;

    public CunsumePost(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecutePost.service(resource));
    }

    public static CunsumePost service(String resource) {
        return Tasks.instrumented(CunsumePost.class, resource);
    }



}
