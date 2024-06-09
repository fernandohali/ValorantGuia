package com.example.valorantguia.TelaPrincipal;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class NetworkExample {
    public static void main(String[] args) {
        // Execute the network operation in a separate thread to avoid blocking the UI thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.vavaguiavalorant.com");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");

                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        String inputLine;
                        StringBuilder content = new StringBuilder();

                        while ((inputLine = in.readLine()) != null) {
                            content.append(inputLine);
                        }

                        // Cleanup
                        in.close();
                        urlConnection.disconnect();

                        // Process the content (this is where you would handle the response)
                        System.out.println("Response: " + content.toString());
                    } else {
                        System.out.println("GET request failed");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
