

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestSender {
    private static String generateDate(java.util.Date date) {
        int day = date.getDate();
        int month = date.getMonth() + 1;
        int year = date.getYear() + 1900;
        String dayS = day < 10 ? "0" + day : Integer.toString(day);
        String monthS = month < 10 ? "0" + month : Integer.toString(month);
        String generatedDate = dayS + "/" + monthS + "/" + year;
        return generatedDate;
    }

    public static String executeGet(String targetURL, CurrencyArgs pathArgs) {
        HttpURLConnection connection = null;
        try {
            // Create connection
            URL url = new URL(targetURL + "?date_req=" + generateDate(pathArgs.getDate()));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            // Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
