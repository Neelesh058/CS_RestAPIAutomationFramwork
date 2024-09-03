package Api.TestCases;

import Api.Endpoint.userEndpoint;
import Api.Payoad.user;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class userTestData
{
    Faker faker;
    user userPayload;
    @BeforeClass
    public void testGenerateData(){
        faker=new Faker();
        userPayload=new user();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());


    }

    @Test(priority=1)
    public void testCreatUser(){
        Response response=userEndpoint.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority=2)
    public void testGetUser(){
        Response response=userEndpoint.getUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority=3)
    public  void testupdateUser(){
        userPayload.setFirstName(faker.name().firstName());
        Response response=userEndpoint.updateUser(this.userPayload.getUsername(),userPayload);
        Assert.assertEquals(response.getStatusCode(),200);
        response.then().log().all();

    }
    @Test(priority=4)
    public void tetDeleteUser(){
        Response response=userEndpoint.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(),200);
        response.then().log().all();
    }

}
