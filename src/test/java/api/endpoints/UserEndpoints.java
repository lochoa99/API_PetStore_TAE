package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * Clase encargada de realizar las peticiones HTTP (CRUD) para el módulo de Usuarios.
 */
public class UserEndpoints {

    /**
     * Envía una petición POST para crear un nuevo usuario en el sistema.
     * @param payload Objeto User que contiene los datos del usuario.
     * @return Response Objeto con la respuesta del servidor.
     */
    public static Response createUser(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
        return response;
    }

    /**
     * Envía una petición GET para iniciar sesión en el sistema.
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     * @return Response Objeto con la respuesta del servidor.
     */
    public static Response loginUser(String username, String password) {
        Response response = given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get(Routes.login_url);
        return response;
    }

    /**
     * Envía una petición GET para cerrar la sesión actual.
     * @return Response Objeto con la respuesta del servidor.
     */
    public static Response logoutUser() {
        Response response = given()
                .when()
                .get(Routes.logout_url);
        return response;
    }
}
