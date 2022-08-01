package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import starter.questions.ResponseCode;
import starter.tasks.RegisterUser;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class RegisterUserStepdefitinions {
    public static final String REST_API_URL = "https://reqres.in/";
    public static final String PATH = "api";
    //register https://reqres.in/api/register
    Actor actorOfScenario;
    @Given("{string} es un cliente que quiere poder administrar sus productos bancaarios")
    public void EsUnClienteQueQuierePoderAdministrarSusProductosBancaarios(String actor) {
         actorOfScenario = Actor.named(actor)
                .whoCan(CallAnApi.at(REST_API_URL+PATH));
    }
    @When("el envia la informacion requerida para el registro")
    public void elEnviaLaInformacionRequeridaParaElRegistro() {
        String registerUserInfo =  "{\n" +
                "    \"job\": \"leader\",\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        actorOfScenario.attemptsTo(RegisterUser.withInfo(registerUserInfo));
    }
    @Then("el debe obtener una cuenta virtual para poder ingresar cuando lo requiera.")
    public void elDebeObtenerUnaCuentaVirtualParaPoderIngresarCuandoLoRequiera() {
        actorOfScenario.should(
                seeThatResponse("el codigo de respuesta",
                        response -> response.statusCode(HttpStatus.SC_OK)
                                .body("id", notNullValue()))
        );
//        actorOfScenario.should(
//                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
//        );
    }
}
