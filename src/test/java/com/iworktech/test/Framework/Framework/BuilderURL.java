package com.iworktech.test.Framework.Framework;

import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BuilderURL {
    //FileReader reader=new FileReader("D:\\Automation\\Framework\\IWORKTECH_Base_Framework\\src\\main\\resources\\ChromeProfile\\config.properties");

    FileReader reader;

    private static Properties properties;
    private static RemoteWebDriver webDriver;

    public BuilderURL() throws IOException {

        Properties prop = BuilderURL.loadPropertiesFile("environment.properties");
        String profile = prop.getProperty("profile.path");
        System.out.println("YASHHHHH ussss "+profile);

        if(profile.contains("ChromeProfile")){
            System.out.println("ITS A CHROME");

        //reader=new FileReader("D:\\Automation\\Framework\\IWORKTECH_Base_Framework\\src\\main\\resources\\ChromeProfile\\config.properties");
            properties = BuilderURL.loadPropertiesFile("ChromeProfile/config.properties");
        }


        if(profile.contains("FireFoxProfile")){
            System.out.println("ITS A FF");

           // reader=new FileReader("D:\\Automation\\Framework\\IWORKTECH_Base_Framework\\src\\main\\resources\\FireFoxProfile\\config.properties");
            properties = BuilderURL.loadPropertiesFile("FireFoxProfile/config.properties");
        }

       // properties = new Properties();
        //properties.load(reader);
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("site.url"));
        System.out.println(properties.getProperty("admin.url"));

    }

    public static void openURL() throws IOException {
        SetBrowser.selectBrowserDriver(properties.getProperty("browser"));
        SetBrowser.getWebDriver().navigate().to(properties.getProperty("admin.url"));
    }

    private static Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = BuilderURL.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }

}
