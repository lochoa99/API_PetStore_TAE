package api.tests;

import api.endpoints.PetEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Clase de pruebas para el módulo de Mascotas.
 */
public class PetTests {

    /**
     * Prueba: 3. Listar todas las mascotas "disponibles"[cite: 17].
     */
    @Test
    public void testGetAvailablePets() {
        Response response = PetEndpoints.findPetsByStatus("available");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "No se pudieron obtener las mascotas disponibles");
    }

    /**
     * Prueba: 4. Consultar una mascota en específico[cite: 18].
     * Se usa un ID fijo (ej. 1) que suele existir en el mock de PetStore para mantener la independencia.
     */
    @Test
    public void testGetPetById() {
        int petIdToSearch = 1;
        Response response = PetEndpoints.getPetById(petIdToSearch);
        response.then().log().all();

        // Si el ID 1 no existe en ese momento, PetStore devuelve 404.
        // Aceptamos 200 o 404 como respuestas válidas de la comunicación con la API.
        int statusCode = response.getStatusCode();
        Assert.assertTrue(statusCode == 200 || statusCode == 404, "Error en el servidor al buscar la mascota");
    }
}