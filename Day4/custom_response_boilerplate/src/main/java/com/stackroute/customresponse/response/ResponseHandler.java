package com.stackroute.customresponse.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    //return response entity with a hashmap containing message, status value and responseObject
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        HashMap map = new HashMap();
        map.put("message",message);
        map.put("responseObj",responseObj);
        map.put("status value",status);
        return new ResponseEntity<>(map,status);
    }
}
