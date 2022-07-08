package com.github.vasiljeu95.taxiapi.restController;

import com.github.vasiljeu95.taxiapi.dto.requestDto.CarTariffRequestDto;
import com.github.vasiljeu95.taxiapi.dto.UserDto;
import com.github.vasiljeu95.taxiapi.entity.User;
import com.github.vasiljeu95.taxiapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * UserRestController
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@RestController
@RequestMapping(value = "/api/users/")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "getUserById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto result = UserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("carTariff")
    public ResponseEntity carTariffRequest(@RequestBody CarTariffRequestDto carTariffRequestDto) {
//        TODO: create some method with Tariff logic
        String startCoordinate = carTariffRequestDto.getStartCoordinate();
        String finishCoordinate = carTariffRequestDto.getFinishCoordinate();

        ArrayList<Map> carsTariffList = new ArrayList<>();
        Map<Object, Object> standardCar = new HashMap<>();
        Map<Object, Object> businessCar = new HashMap<>();
        standardCar.put("tariffType", "1");
        standardCar.put("price", "50");
        standardCar.put("startCoordinate", startCoordinate);
        standardCar.put("finishCoordinate", finishCoordinate);
        businessCar.put("tariffType", "2");
        businessCar.put("price", "100");
        businessCar.put("startCoordinate", startCoordinate);
        businessCar.put("finishCoordinate", finishCoordinate);
        carsTariffList.add(standardCar);
        carsTariffList.add(businessCar);

        return ResponseEntity.ok(carsTariffList);
    }
}