package Utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import Constants.ConstantData;

public class FetchDataFromProperty
{
        public static Properties readDataFromProperty() throws IOException 
        {
        	FileReader reader = new FileReader(ConstantData.PropertyFilePath);//path of the global.propertyfile
        	
        	Properties prop = new Properties();
        	
        	prop.load(reader);
        	
        	return prop;
        }
}
