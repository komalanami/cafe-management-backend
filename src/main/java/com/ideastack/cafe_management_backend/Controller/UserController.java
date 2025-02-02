package com.ideastack.cafe_management_backend.Controller;

import com.ideastack.cafe_management_backend.constants.CafeConstants;
import com.ideastack.cafe_management_backend.service.UserService;
import com.ideastack.cafe_management_backend.util.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello I am working";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Map<String, String> requestMap) {
        try{
            return  userService.signup(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
