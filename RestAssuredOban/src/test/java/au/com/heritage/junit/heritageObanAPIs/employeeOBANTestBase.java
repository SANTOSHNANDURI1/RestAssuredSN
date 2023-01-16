package au.com.heritage.junit.heritageObanAPIs;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class employeeOBANTestBase {

    @BeforeClass
    public static void init() {
       // RestAssured.baseURI = "https://open-banking-ey-gateway-stage-ob.apps.ocp-tstb.hbs.net.au";
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

    }
}
