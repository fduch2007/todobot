package edu.baiburin.todobot.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";

    public static final String BOT_NAME = "bot.name";
    public static final String BOT_TOKEN = "bot.token";

    public static Properties properties = new Properties();

    public static String getProperty(String name){
        if(properties.isEmpty()){
            try(InputStream inputStream = Config.class.getClassLoader()
                    .getResourceAsStream("config.properties")){
                properties.load(inputStream);
            }catch (IOException exception){
                exception.printStackTrace();
                throw new RuntimeException();
            }
        }
        return properties.getProperty(name);
    }
}
