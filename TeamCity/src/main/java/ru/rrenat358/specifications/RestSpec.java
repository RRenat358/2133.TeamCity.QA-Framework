package ru.rrenat358.specifications;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.rrenat358.configs.Config;
import ru.rrenat358.models.User;


//@NoArgsConstructor
//@AllArgsConstructor
public class RestSpec {

    private RequestSpecBuilder requestBuilder() {
        var requestBuilder = new RequestSpecBuilder();
        requestBuilder.addFilter(new RequestLoggingFilter());
        requestBuilder.addFilter(new ResponseLoggingFilter());
        return requestBuilder;
    }


    public RequestSpecification unAuthSpec() {
        var requestBuilder = RestSpec.getInstance().requestBuilder();
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.setAccept(ContentType.JSON);
        return requestBuilder.build();
    }


    public RequestSpecification AuthSpec(User user) {
        var requestBuilder = RestSpec.getInstance().requestBuilder();
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.setAccept(ContentType.JSON);
        requestBuilder.setBaseUri("https://" +
                                  user.getUsername() + ":" +
                                  user.getPassword() + "@" +
                                  Config.getInstance().getProperties("host")
                                  );
        return requestBuilder().build();
    }



    private static class SingletonHelper {
        private static final RestSpec INSTANCE = new RestSpec();
    }

    public static RestSpec getInstance() {
        return SingletonHelper.INSTANCE;
    }


}
