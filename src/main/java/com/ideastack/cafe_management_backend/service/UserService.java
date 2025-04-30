package com.ideastack.cafe_management_backend.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<String> signup(Map<String,String> requestMap);

}
