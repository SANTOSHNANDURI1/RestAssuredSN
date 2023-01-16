package au.com.heritage.junit.heritageObanAPIs;

import au.com.heritage.junit.commonFunctions.CommonFunctions;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SuppressWarnings("ALL")
@RunWith(SerenityRunner.class)
//@UseTestDataFrom("src/main/resources/testData/openBankingAPI/Accounts.csv")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GetEmployeeData extends employeeOBANTestBase {
	int count = 0;
	int maxTries = 2;
	String statusCode;
	String userId;
	CommonFunctions comm = new CommonFunctions();



	@Title ("Get Employees Testcase")
	@Test
	public void getDataDrivenEmployeesAPITest() throws IOException {
		int res;
		//  String payloadFinal = payload.replace("{{userId}}", userId);
		String url = "/employees";
		try {
			res= comm.serenityGetRequest(url);
			if (res == 200) {
				assert true;
			}
			else{
				if (++count == maxTries){
					assert false;
				}
			}

		} catch (Exception e) {
			System.out.println("");
			//     if (++count == maxTries) throw e;
		}
	}
	@Title ("Create Employee Testcase")
	@Test
	public void postEmployeesAPITest() throws IOException {
		String payload = new String(Files.readAllBytes(Paths.get("src/main/resources/openBankingAPIRequest/CreateEmployee.json")));
		Response res;
		String url = "/create";
		try {
			res= comm.serenityPostRequestMethod(payload,url);
			if (res.statusCode() == 201) {
				assert true;
			}
			else{                    
				assert false;
			}

		} catch (Exception e) {
			System.out.println("");
		}
	}

}
