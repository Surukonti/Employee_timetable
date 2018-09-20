package app.springbootdemo.database.dbmodel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.validation.DefaultMessageCodesResolver;

public class BreakDateTimeDeserialize extends JsonDeserializer<String> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    //SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //String output = DefaultMessageCodesResolver.Format.toDelimitedString(String.valueOf(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).replace( "T" , " " );
    @Override
    public String deserialize(JsonParser paramJsonParser,
                              DeserializationContext paramDeserializationContext)
         //   throws IOException, JsonProcessingException {


    throws IOException, JsonProcessingException{

//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//
//
//        //String LocalTime = "08:30:00";
//        String date = "27-07-2018 08:30:00";
//        return "sdf.parse(Date)";
//    }


        String str = paramJsonParser.getText().trim();
        String currentTime = null;
        try {
            currentTime = dateFormat.format(dateFormat.parse(str));
        } catch (Exception e) {
            // Handle exception here
        }
        return currentTime;
    }
}