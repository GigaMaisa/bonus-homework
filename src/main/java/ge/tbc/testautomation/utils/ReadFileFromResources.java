package ge.tbc.testautomation.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ReadFileFromResources {
    public static File readFile(String fileName) throws URISyntaxException {
        URL resourceFile = ReadFileFromResources.class.getClassLoader().getResource(fileName);
        assert resourceFile != null;
        return new File(resourceFile.toURI());
    }
}
