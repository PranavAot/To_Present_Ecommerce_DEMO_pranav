package util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public static JSONObject readJsonFile(String FileName, String Key) {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\PRANACHO\\Desktop\\automation project\\Intilij\\Ecommerce_DEMO_pranav\\src\\main\\resources\\TestData\\"+FileName+".json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray userDataArray = (JSONArray) jsonObject.get("User_Data");

            for (int i = 0; i < userDataArray.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) userDataArray.get(i);
                JSONObject object = (JSONObject) jsonObject1.get(Key);
                return object;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
