package com.ideastack.cafe_management_backend.rest.restimpl;

import com.ideastack.cafe_management_backend.constants.CafeConstants;
import com.ideastack.cafe_management_backend.rest.UserRest;
import com.ideastack.cafe_management_backend.service.UserService;
import com.ideastack.cafe_management_backend.util.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        try{
            return userService.signup(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
