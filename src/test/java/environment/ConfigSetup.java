package environment;

public class ConfigSetup extends ConfigReader{
    public static String getBaseUrl()  {
        return getValue("BASE_URL");
    }
}


