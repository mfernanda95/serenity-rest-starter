package starter.stepdefinitions.apiBooker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import starter.facts.AToken;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

public class EliminarReservasSteps {
    Actor actorOfScenario;
    public final String URL_REST_BOOKER = "https://reqres.in/api";

    @Given("{string} es el administrador de la plataforma")
    public void esElAdministradorDeLaPlataforma(String actor) {
        actorOfScenario = Actor.named(actor)
                .describedAs("Administrador")
                .whoCan(CallAnApi.at(URL_REST_BOOKER));
    }

    @And("tiene sus credenciales activas {string} {string}")
    public void tieneSusCredencialesActivas(String user, String password) {
        givenThat(actorOfScenario).has(AToken.toManageBookings(user,password));

    }

    @When("elimina una reserva {string}")
    public void eliminaUnaReserva(String idBooking) {
        String token = when(actorOfScenario).recall("token");
        System.out.println("TOKEN RECORDANDO:  "+token);
    }

    @Then("puede eliminar las reservas que ya no estan activas")
    public void puedeEliminarLasReservasQueYaNoEstanActivas() {
    }
}
