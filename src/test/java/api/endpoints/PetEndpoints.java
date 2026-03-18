package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * Clase encargada de realizar las peticiones HTTP para el módulo de Mascotas (Pets).
 */
public class PetEndpoints {

    /**
     * Envía una petición GET para listar mascotas filtradas por su estado.
     * @param status Estado de la mascota (ej. "available", "pending", "sold").
     * @return Response Objeto con la respuesta del servidor.
     */
    public static Response findPetsByStatus(String status) {
        Response response = given()
                .queryParam("status", status)
                .when()
                .get(Routes.pet_by_status_url);
        return response;
    }

    /**
     * Envía una petición GET para obtener los detalles de una mascota por su ID.
     * @param petId Identificador único de la mascota.
     * @return Response Objeto con la respuesta del servidor.
     */
    public static Response getPetById(int petId) {
        Response response = given()
                .pathParam("petId", petId)
                .when()
                .get(Routes.pet_by_id_url);
        return response;
    }
}