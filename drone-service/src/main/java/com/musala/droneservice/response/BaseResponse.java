package com.musala.droneservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.sql.Timestamp;
import java.util.Map;

@Data
public class BaseResponse<T> {

    private Timestamp serverUTCTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T businessResponse;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map errors;

    public BaseResponse(T businessResponse, Map errors) {
        this.businessResponse = businessResponse;
        this.errors = errors;
        this.serverUTCTime = new Timestamp(System.currentTimeMillis());
    }

    public BaseResponse(Map errors) {
        this.businessResponse = null;
        this.serverUTCTime = new Timestamp(System.currentTimeMillis());
        this.errors=errors;
    }

}
