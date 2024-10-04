import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.AppConfig;
import com.example.IClientService;
import org.junit.jupiter.api.Test;

public class CompositionIntegrationTest {
    @Test
    public void testCalculateSquareUsingDI() {
        // Create the configuration class
        AppConfig config = new AppConfig();
        // Get the client service with dependencies injected
        IClientService clientService = config.getClientService();
        // Fetch square of 5 from ComputationService through ClientService
        String response = clientService.fetchSquare(5);
        // Validate the response
        assertEquals("25", response, "The square of 5 should be 25");
    }
}
