package seminars.fourth.httpqueries;

public class WebService {
    HttpClient httpClient;

    public WebService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    String httpRequest(String httpReq){

        return httpClient.get(httpReq);
    }

}
