package parser;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
/**
 * Created by Victor on 04.10.2018.
 */
public class WeatherForecaster {

    public String forecast(City city) throws UnirestException {
        System.out.println(city);
        if (city.getCoordinates() == null){
            System.out.println("Sorry we didn`t support weather for this city");
            return null;
        }

        String apilink = "http://api.apixu.com/v1/current.json?key=f6da3a783d34446f8f4120423180410&q=";
        JsonNode request = Unirest.post(apilink + city.getCoordinates().getLatitude() + "%20" +
                city.getCoordinates().getLongtitude()).asJson().getBody();
        JSONObject request_obj = request.getObject();
        System.out.println("Weather in " + city.getName());
        System.out.printf("Temperature in °C: %s\n" +
                        "Condition: %s\n" +
                        "Humidity: %s\n" +
                        "Last update: %s\n", request_obj.getJSONObject("current").getDouble("temp_c"),
                request_obj.getJSONObject("current").getJSONObject("condition").getString("text"),
                request_obj.getJSONObject("current").getDouble("humidity"),
                request_obj.getJSONObject("current").getString("last_updated"));
        System.out.println("Raw json response:"+request.toString());
        return null;
    }
}
