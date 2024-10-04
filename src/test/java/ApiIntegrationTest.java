
import com.example.ClientService;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiIntegrationTest {
    @Test
    public void testApiEndpointIsRunning() throws Exception {
        // Check if the API endpoint is running
        String url = "http://localhost:8081/api/square/5"; // Example URL, update if necessary
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Validate the response code to be 200 (OK)
        int responseCode = connection.getResponseCode();
        assertEquals(HttpURLConnection.HTTP_OK, responseCode, "API endpoint should be running and return 200 OK");
    }

    @Test
    public void testCalculateSquare() throws Exception {
        ClientService clientService = new ClientService();
        // Fetch square of 5 from Component B
        String response = clientService.fetchSquare(5);
        // Validate the response
        assertEquals("25", response, "The square of 5 should be  25");
    }
}
