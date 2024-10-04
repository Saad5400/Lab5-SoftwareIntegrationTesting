import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeApiTest {

    // Base URL for the employee API
    private static final String BASE_URL = "https://apex.oracle.com/pls/apex/i4210132_01/hr/employees";

    /**
     * Test fetching all employees and ensure the response contains data
     */
    @Test
    public void testGetAllEmployees() throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        assertEquals(HttpURLConnection.HTTP_OK, responseCode, "Response Code should be 200");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        assertTrue(response.length() > 0, "Response should contain employee data");
    }

    /**
     * Test fetching a specific employee with id 101 and validate response data
     */
    @Test
    public void testGetSpecificEmployee() throws Exception {
        URL url = new URL(BASE_URL + "/101");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        assertEquals(HttpURLConnection.HTTP_OK, responseCode, "Response Code should be 200");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        } 
        in.close();

        System.out.println(response.toString());
        assertTrue(response.toString().contains("Neena"), "Response should contain 'Neena'");
        assertTrue(response.toString().contains("Kochhar"), "Response should contain 'Kochhar'");
    }


}
