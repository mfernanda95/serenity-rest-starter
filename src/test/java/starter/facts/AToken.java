package starter.facts;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.facts.Fact;
import starter.interactions.Post;

public class AToken implements Fact {
    private String token;
    private final String user;
    private final String password;

    public AToken(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static AToken toManageBookings(String user, String password) {
        return new AToken(user, password);
    }

    @Override
    public void setup(Actor actor) {
        String userCredentials =   "{\n" +
                "    \"email\": \""+user+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
                "}";
        actor.attemptsTo(
                Post.to("/login").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userCredentials)
                )
        );
        token = SerenityRest.lastResponse().body().jsonPath().getString("token");

        actor.remember("token", token);

    }

    public String toString(){
        return "el siguiente token  '"+token+"'";
    }
}
