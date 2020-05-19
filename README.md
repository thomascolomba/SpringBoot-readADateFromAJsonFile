How to read a date from a json configuration file with Spring Boot.<br/>
<br/>
How to compile and execute :<br/>
mvn package<br/>
java -jar ./target/readSimpleDataFromAJsonFile-0.0.1-SNAPSHOT.jar<br/>
<br/>
<br/>
---myConfiguration.json<br/>
{<br/>
&nbsp;&nbsp;"myDate" : "2020-01-01 00:00:00"<br/>
}<br/>
---MyJsonPropertySourceFactory.java<br/>
Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);<br/>
return new MapPropertySource("json-property", readValue);<br/>
---MyConfigurationBean.java<br/>
@PropertySource(<br/>
&nbsp;&nbsp;value = "classpath:myConfiguration.json", <br/>
&nbsp;&nbsp;factory = MyJsonPropertySourceFactory.class)<br/>
...<br/>
private Date myDate;<br/>
+getter and setter<br/>
---The class who displays the value of the 'myString' configuration<br/>
@Autowired<br/>
MyConfigurationBean myConf;<br/>
...<br/>
System.out.println(myConf.getMyDate());<br/>
<br/>
<br/>
The application will read the value '2020-01-01 00:00:00' from the json configuration file then display it in the terminal.<br/>


