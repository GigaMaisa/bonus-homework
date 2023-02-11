package ge.tbc.testautomation.data.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public static Object[][] nameInXmlProvider() {
        return new Object[][]{
                {"Xavier"}
        };
    }
}
