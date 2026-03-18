package api.tests;

import api.endpoints.StoreEndpoints;
import api.payloads.Order;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Clase de pruebas para el módulo de la Tienda (Órdenes).
 */
public class StoreTests {

    /**
     * Prueba: 5. Crear una orden de compra.
     * Prepara su propio payload (Order) para ser independiente[cite: 25].
     */
    @Test
    public void testCreateOrder() {
        // Armamos el objeto de la orden
        Order orderPayload = new Order();
        orderPayload.setId((int) (Math.random() * 1000));
        orderPayload.setPetId(1);
        orderPayload.setQuantity(2);
        orderPayload.setShipDate("2026-03-20T10:00:00.000Z");
        orderPayload.setStatus("placed");
        orderPayload.setComplete(true);

        // Enviamos la petición
        Response response = StoreEndpoints.createOrder(orderPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "No se pudo crear la orden de compra");
    }
}