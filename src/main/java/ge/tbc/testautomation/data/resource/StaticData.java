package ge.tbc.testautomation.data.resource;



import ge.tbc.testautomation.utils.DateUtilities;

import java.text.ParseException;
import java.util.Date;

public class StaticData {
    public static final String BASEURI = "https://www.crcind.com:443/csp/";
    public static final String BASEPATH = "samples/SOAP.Demo.cls";
    public static final String CONTENT_TYPE = "text/xml; charset=utf-8";
    public static final String SOAP_ACTION = "http://tempuri.org/SOAP.Demo.GetListByName";
    public static final String FIRST_PERSON_NAME = "Xavier,Bob D.";
    public static final String SECOND_PERSON_SSN = "640-94-6892";
    public static final int THIRD_PERSON_ID = 41;
    public static Date FOURTH_PERSON_DOB;

    static {
        try {
            FOURTH_PERSON_DOB = DateUtilities.stringToDate("1966-06-08");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
