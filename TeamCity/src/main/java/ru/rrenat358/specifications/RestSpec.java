package ru.rrenat358.specifications;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
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


    public RequestSpecification AuthSpec() {
        var requestBuilder = RestSpec.getInstance().requestBuilder();
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.setAccept(ContentType.JSON);




    }



    private static class SingletonHelper {
        private static final RestSpec INSTANCE = new RestSpec();
    }

    public static RestSpec getInstance() {
        return SingletonHelper.INSTANCE;
    }


}
