import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UtilityApi {

    protected String accessToken;

    @Step("Create new user and take token")
    public void createNewUser(UserModel userModel) {
        accessToken = given()
                .baseUri(MainPageObjectsModel.MAIN_PAGE)
                .log().body()
                .contentType(ContentType.JSON)
                .body(userModel)
                .when()
                .post("/api/auth/register")
                .then()
                .extract().path("accessToken");
    }

    @Step("Delete user")
    public void deleteUser() {
        given()
                .baseUri(MainPageObjectsModel.MAIN_PAGE)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + accessToken)
                .log().all()
                .delete("/api/auth/user");
    }

    @Step("Login user token for delete")
    public void loginUser(UserModel userModel) {
        accessToken = given()
                .baseUri(MainPageObjectsModel.MAIN_PAGE)
                .contentType(ContentType.JSON)
                .body(userModel)
                .header("Authorization", "Bearer" + accessToken)
                .when()
                .post("/api/auth/login")
                .then()
                .log().all()
                .extract().path("accessToken");
    }
}
