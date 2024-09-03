package Api.TestCases;

import Api.Endpoint.userEndpoint;
import Api.Payoad.user;
import Api.Utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTestDD {

    @Test(priority=1,dataProvider = "AllData", dataProviderClass = DataProviders.class)
    public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd, String phone)
    {

        user userPayload = new user();

        userPayload.setId(Integer.parseInt(userId));
        userPayload.setUsername(UserName);
        userPayload.setFirstName(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(lname);
        userPayload.setPassword(email);
        userPayload.setPhone(phone);
        Response response = userEndpoint.createUser(userPayload);

        //log response
        response.then().log().all();


        //validation
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
