package starter.stepdefinitions.resreq;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;
import starter.questions.ResponseCode;
import starter.tasks.RegisterUser;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class RegisterUserStepdefitinions {
    public static  String theRestApiBaseUrl = "https://reqres.in/";
    private EnvironmentVariables environmentVariables;
    public static final String PATH = "api";
    //register https://reqres.in/api/register

    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("environments.default.restapi.baseurl")
                .orElse("---");
    }

    Actor actorOfScenario;
    @Given("{string} es un cliente que quiere poder administrar sus productos bancaarios")
    public void EsUnClienteQueQuierePoderAdministrarSusProductosBancaarios(String actor) {
         actorOfScenario = Actor.named(actor)
                .whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @When("el envia la informacion requerida para el registro")
    public void elEnviaLaInformacionRequeridaParaElRegistro() {
        String registerUserInfo =  "{\n" +
                "    \"job\": \"leader\",\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        givenThat(actorOfScenario).attemptsTo(RegisterUser.withInfo(registerUserInfo));
//        actorOfScenario.attemptsTo(RegisterUser.withInfo(registerUserInfo));
    }
    @Then("el debe obtener una cuenta virtual para poder ingresar cuando lo requiera.")
    public void elDebeObtenerUnaCuentaVirtualParaPoderIngresarCuandoLoRequiera() {
//        actorOfScenario.should(
//                seeThatResponse("El usuario registrado debe devolver",
//                        response -> response.statusCode(HttpStatus.SC_OK)
//                                .body("id", notNullValue()))
//        );

//        SerenityRest.lastResponse().jsonPath().getObject("data", User.class)
//        assertThat(user.getFirstName()).isEqualTo("George");
//        assertThat(user.getLastName()).isEqualTo("Bluth");
//        List<String> userSurnames = SerenityRest.lastResponse().path("data.last_name");
//        assertThat(userSurnames).contains("Bluth", "Weaver", "Wong");
        actorOfScenario.should(
//                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
                seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(200))
//                ,seeThat()
        );
    }
}
