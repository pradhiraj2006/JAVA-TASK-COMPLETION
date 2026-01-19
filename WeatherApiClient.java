import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

// JSON Parsing
import org.json.JSONObject;

public class WeatherApiClient {

    public static void main(String[] args) {

        try {
            // Weather API (No key needed)
            String url = "https://api.open-meteo.com/v1/forecast?latitude=13.08&longitude=80.27&current_weather=true";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());
            JSONObject current = json.getJSONObject("current_weather");

            double temp = current.getDouble("temperature");
            double wind = current.getDouble("windspeed");
            int code = current.getInt("weathercode");

            System.out.println("------ WEATHER REPORT ------");
            System.out.println("Location: Chennai");
            System.out.println("Temperature: " + temp + " °C");
            System.out.println("Wind Speed: " + wind + " km/h");
            System.out.println("Weather Code: " + code);
            System.out.println("----------------------------");

        } catch (Exception e) {
            System.out.println("Error fetching data!");
            e.printStackTrace();
        }
    }

}
