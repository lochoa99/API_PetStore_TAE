package api.endpoints;

/**
 * Clase para almacenar todas las URLs de la API de PetStore.
 * Documentación base: https://petstore.swagger.io
 */
public class Routes {

    // URL Base
    public static String base_url = "https://petstore.swagger.io/v2";

    // Rutas del módulo User
    public static String post_url = base_url + "/user";
    public static String login_url = base_url + "/user/login";
    public static String logout_url = base_url + "/user/logout";

    // Rutas del módulo Pet
    public static String pet_by_status_url = base_url + "/pet/findByStatus";
    public static String pet_by_id_url = base_url + "/pet/{petId}";

    // Rutas del módulo Store (Ordenes)
    public static String store_order_url = base_url + "/store/order";
}