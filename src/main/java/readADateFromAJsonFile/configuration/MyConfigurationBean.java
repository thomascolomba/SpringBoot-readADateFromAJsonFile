package readADateFromAJsonFile.configuration;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import readADateFromAJsonFile.mySourceFactory.MyJsonPropertySourceFactory;

@Component
@PropertySource(
		  value = "classpath:myConfiguration.json", 
		  factory = MyJsonPropertySourceFactory.class)
@ConfigurationProperties
public class MyConfigurationBean {
    private Date myDate;
	public Date getMyDate() {
		return myDate;
	}
	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}
}