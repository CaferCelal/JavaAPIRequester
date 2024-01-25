import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class GetRequest {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://localhost:5227/api/Pokemon");


// Build the GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(uri)
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            System.out.println(body.toString());

        }
        catch (URISyntaxException uriSyntaxException){
            System.out.println(uriSyntaxException.getMessage());
        }
        catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
        catch (InterruptedException interruptedException){
            System.out.println(interruptedException.getMessage());
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}