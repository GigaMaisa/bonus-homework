package ge.tbc.testautomation;

import ge.tbc.testautomation.data.dataprovider.TestDataProvider;
import ge.tbc.testautomation.pojos.response.PersonIdentification;
import ge.tbc.testautomation.steps.ApiCallSteps;
import ge.tbc.testautomation.utils.ReadFileFromResources;
import ge.tbc.testautomation.utils.XmlUtils;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

public class BonusTest {
    ApiCallSteps callSteps;

    @BeforeClass
    public void setUp(){
        callSteps = new ApiCallSteps();
    }

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "nameInXmlProvider")
    public void runTest(String name) throws URISyntaxException{
        XmlUtils.setValue("tem:name", name);
        File file = ReadFileFromResources.readFile("request.xml");

        Response response = callSteps.getResponse(file);
        int size = callSteps.getPersonListSizeFromApi(response);
        List<PersonIdentification> usersList = callSteps.getListOfPersons(response, size);

        callSteps.validateFirstPersonName(usersList).validateSecondPersonSsn(usersList).
                validateThirdPersonId(usersList).validateFourthPersonDob(usersList);
    }
}
