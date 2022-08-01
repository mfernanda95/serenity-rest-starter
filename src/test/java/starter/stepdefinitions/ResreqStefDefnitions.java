import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.seleniumhq.jetty9.server.Utf8HttpWriter;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Java6Assertions.assertThat;

//theActorCalled(actor).a
public class ResreqStefDefnitions {

    public static final String restApiUrl = "";
    @Given("{string} el entrenador")
    public void elEntrenador(String actor) {
//        theActorCalled(actor).attemptsTo();
        Actor actor1 = Actor.named(actor)
                .whoCan(CallAnApi.at(restApiUrl));
    }

    @When("accede a su lista de alumnos")
    public void accedeASuListaDeAlumnos() {
        theActorInTheSpotlight().attemptsTo(
                Get.resource("/users?page=2")
        );
    }

    @Then("Visualiza la lista")
    public void visualizaLaLista() {
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
    }
}
