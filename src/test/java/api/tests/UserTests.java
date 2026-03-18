package api.tests;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Clase de pruebas para el módulo de Usuarios utilizando TestNG.
 * Cada prueba es independiente y prepara sus propios datos.
 */
public class UserTests {

    private User userPayload;

    /**
     * Se ejecuta antes de cada @Test para generar datos frescos y únicos.
     * Esto garantiza la independencia de las pruebas.
     */
    @BeforeMethod
    public void setupData() {
        userPayload = new User();
        userPayload.setId((int) (Math.random() * 10000));
        userPayload.setUsername("testuser" + userPayload.getId());
        userPayload.setFirstName("Juan");
        userPayload.setLastName("Perez");
        userPayload.setEmail("juan@test.com");
        userPayload.setPassword("pass1234");
        userPayload.setPhone("123456789");
        userPayload.setUserStatus(1);
    }

    /**
     * Prueba: 1. Crear un usuario.
     */
    @Test
    public void testCreateUser() {
        Response response = UserEndpoints.createUser(userPayload);
        response.then().log().all(); // Imprime la respuesta en consola

        Assert.assertEquals(response.getStatusCode(), 200, "El código de estado no es 200");
    }

    /**
     * Prueba: 2. Hacer login con un usuario.
     * Para ser independiente, primero creamos el usuario en la API y luego intentamos el login.
     */
    @Test
    public void testLoginUser() {
        // Pre-condición: Crear el usuario para asegurar que existe
        UserEndpoints.createUser(userPayload);

        // Acción: Hacer Login
        Response response = UserEndpoints.loginUser(userPayload.getUsername(), userPayload.getPassword());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "El login falló");
    }

    /**
     * Prueba: 6. Hacer logout a la aplicación.
     */
    @Test
    public void testLogoutUser() {
        Response response = UserEndpoints.logoutUser();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "El logout falló");
    }
}