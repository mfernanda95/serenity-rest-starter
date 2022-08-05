package starter.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Post extends RestInteraction {
    private final String resource;

    public Post(String resource) {
        this.resource = resource;
    }

    @Step("{0} ejecuta una petición POST con el recurso #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().post(as(actor).resolve(resource)).then().log().all();
    }

    public static Post to(String resource) {
        return instrumented(Post.class, resource);
    }

}
