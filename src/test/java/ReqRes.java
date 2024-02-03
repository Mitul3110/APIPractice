import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.given;

public class ReqRes {

    public static void main(String[] args) {

        String payload= "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";




        Response authmethod=given().contentType(ContentType.JSON).body(payload).log().all().post("https://reqres.in/api/users");
        Assert.assertEquals(authmethod.statusCode(),201);
        String token=authmethod.jsonPath().toString();
        String orderId = authmethod.jsonPath().get("accesstoken").toString();
        System.out.println(orderId);

     Response order= given().header("Authorization","Bearer" +token).get("https://reqres.in/api/users");
     Assert.assertEquals(order.statusCode(),200);



    }







    }






