package $15_network.$06_http.demo02;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.net.http.HttpClient.Version;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;

public class Main {
    // 全局HttpClient:
    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception {
        String url = "https://www.sina.com.cn/";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
            // 设置Header:
            .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
            // 设置超时:
            .timeout(Duration.ofSeconds(5))
            // 设置版本:
            .version(Version.HTTP_2).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // HTTP允许重复的Header，因此一个Header可对应多个Value:
        Map<String, List<String>> headers = response.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }
        System.out.println(response.body().substring(0, 1024) + "...");
    }

    private static void post() throws URISyntaxException, IOException, InterruptedException {
        String url = "http://www.example.com/login";
        String body = "username=bob&password=123456";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                // 设置Header:
                .header("Accept", "*/*")
                .header("Content-Type", "application/x-www-form-urlencoded")
                // 设置超时:
                .timeout(Duration.ofSeconds(5))
                // 设置版本:
                .version(Version.HTTP_2)
                // 使用POST并设置Body:
                .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String s = response.body();
        System.out.println(s);
    }
}