package readADateFromAJsonFile.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class MyDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source == null) {
            return null;
        }
        Date dateToReturn = null;
        try {
        	dateToReturn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
        	//note : instead of SimpleDateFormat we could use the Date.toJSON format : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date/toJSON
		} catch (ParseException e) {
			//Logging that exception would be nice
			throw new RuntimeException(e);
		}
        return dateToReturn;
    }
}