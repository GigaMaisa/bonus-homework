package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.data.resource.StaticData;
import ge.tbc.testautomation.pojos.response.PersonIdentification;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ApiCallSteps {
    @Step
    public Response getResponse(File file){
        return given().contentType(ContentType.XML).and().
                baseUri(StaticData.BASEURI).basePath(StaticData.BASEPATH).
                header("SOAPAction", StaticData.SOAP_ACTION).
                header("Content-Type", StaticData.CONTENT_TYPE).body(file).post();
    }

    @Step
    public int getPersonListSizeFromApi(Response response){
        List<PersonIdentification> list = response.then().extract().body().xmlPath().
                getList("Envelope.Body.GetListByNameResponse.GetListByNameResult.PersonIdentification");
        return list.size();
    }

    @Step
    public List<PersonIdentification> getListOfPersons(Response response, int listSize){
        List<PersonIdentification> emptyList = new java.util.ArrayList<>(Collections.emptyList());

        for (int i = 0; i < listSize; i++){
            String xmlPath = "Envelope.Body.GetListByNameResponse.GetListByNameResult.PersonIdentification["+i+"]";
            PersonIdentification onePerson = response.then().extract().body().xmlPath().
                    getObject(xmlPath, PersonIdentification.class);
            emptyList.add(onePerson);
        }
        return emptyList;
    }

    @Step
    public ApiCallSteps validateFirstPersonName(List<PersonIdentification> list){
        assertThat(list.get(0).getName(), equalTo(StaticData.FIRST_PERSON_NAME));
        return this;
    }

    @Step
    public ApiCallSteps validateSecondPersonSsn(List<PersonIdentification> list){
        assertThat(list.get(1).getSSN(), equalTo(StaticData.SECOND_PERSON_SSN));
        return this;
    }

    @Step
    public ApiCallSteps validateThirdPersonId(List<PersonIdentification> list){
        assertThat(list.get(2).getID(), equalTo(StaticData.THIRD_PERSON_ID));
        return this;
    }

    @Step
    public ApiCallSteps validateFourthPersonDob(List<PersonIdentification> list){
        assertThat(list.get(3).getDOB(), equalTo(StaticData.FOURTH_PERSON_DOB));
        return this;
    }
}
