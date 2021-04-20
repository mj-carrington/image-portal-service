package com.image.portal.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07" +
        ".734618300-05:00[America/Chicago]")
@Controller
@RequestMapping("${openapi.portal.base-path:/mcarrington1/portal/1.0.0}")
public class UserApiController implements UserApi {

    private final UserApiDelegate delegate;

    public UserApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) UserApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new UserApiDelegate() {
        });
    }

    @Override
    public UserApiDelegate getDelegate() {
        return delegate;
    }

}
