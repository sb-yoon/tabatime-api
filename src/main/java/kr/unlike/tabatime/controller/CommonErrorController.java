package kr.unlike.tabatime.controller;

import kr.unlike.tabatime.dto.response.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class CommonErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CommonErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ApiResponse<?> error(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String, Object> errorRequest = getErrorAttributes(webRequest, false);

        int errorStatus = (int) errorRequest.get("status");
        String errorMessage =  errorRequest.get("error").toString();

        return ApiResponse.error(errorStatus, errorMessage);
    }

    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        return this.errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
