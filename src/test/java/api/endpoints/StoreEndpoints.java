package api.endpoints;

import api.payloads.Order;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * Clase encargada de realizar las peticiones HTTP para el módulo de la Tienda (Store/Orders).
 */
public class StoreEndpoints {

    /**
     * Envía una petición POST para crear una orden de compra de una mascota.
     * @param payload Objeto Order que contiene los detalles de la compra.
     * @return Response Objeto con la respuesta del servidor.
     */
    public static Response createOrder(Order payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.store_order_url);
        return response;
    }
}