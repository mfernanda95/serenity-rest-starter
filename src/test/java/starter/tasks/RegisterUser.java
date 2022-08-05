package starter.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
//import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;
import starter.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {
    private final Object userInfo;

    public RegisterUser(Object userInfo){
        this.userInfo = userInfo;
    }

    public static Performable withInfo(Object userInfo){
        return instrumented(RegisterUser.class, userInfo);
    }

//    public static RegisterUser withInfo(Object userInfo) {
//        return Instrumented.instanceOf(RegisterUser.class).withProperties(userInfo);
//    }
    @Override
    @Step("{0} envia los datos de usuario para el registro")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }
}
