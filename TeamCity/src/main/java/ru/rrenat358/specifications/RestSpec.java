package ru.rrenat358.specifications;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.rrenat358.configs.Config;
import ru.rrenat358.models.User;


//@NoArgsConstructor
//@AllArgsConstructor
public class RestSpec {

    private RequestSpecBuilder requestSpecBuilderBase() {
        var requestBuilder = new RequestSpecBuilder();
        requestBuilder.addFilter(new RequestLoggingFilter());
        requestBuilder.addFilter(new ResponseLoggingFilter());

        requestBuilder.setBaseUri("http://" + Config.getInstance().getProperties("host"));

        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.setAccept(ContentType.JSON);

        return requestBuilder;
    }


    public RequestSpecification unAuthSpec() {
        var requestBuilder = RestSpec.getInstance().requestSpecBuilderBase();
        return requestBuilder.build();
    }


    public RequestSpecification authSpec(User user) {
        var requestBuilder = RestSpec.getInstance().requestSpecBuilderBase();
        requestBuilder.setBaseUri("http://" +
                                  user.getUsername() + ":" +
                                  user.getPassword() + "@" +
                                  Config.getInstance().getProperties("host")
                                  );
        return requestBuilder.build();
    }


/*
    private static RestSpec spec;
    private RestSpec() {}

    public static RestSpec getSpec() {
        if (spec == null) {
            spec = new RestSpec();
        }
        return spec;
    }
*/

    private static class SingletonHelper {
        private static final RestSpec INSTANCE = new RestSpec();
    }

    public static RestSpec getInstance() {
        return SingletonHelper.INSTANCE;
    }


}
