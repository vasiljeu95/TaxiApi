package com.github.vasiljeu95.taxiapi.controller;

import com.github.vasiljeu95.taxiapi.dto.ExecuteOrderDto;
import com.github.vasiljeu95.taxiapi.dto.OrderDto;
import com.github.vasiljeu95.taxiapi.dto.TripCostDto;
import com.github.vasiljeu95.taxiapi.dto.requestDto.ByIdRequestDto;
import com.github.vasiljeu95.taxiapi.dto.requestDto.TripCostRequestDto;
import com.github.vasiljeu95.taxiapi.dto.UserDto;
import com.github.vasiljeu95.taxiapi.entity.order.Order;
import com.github.vasiljeu95.taxiapi.entity.user.User;
import com.github.vasiljeu95.taxiapi.service.OrderServiceImpl;
import com.github.vasiljeu95.taxiapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final OrderServiceImpl orderService;

    @Autowired
    public UserRestController(UserService userService, OrderServiceImpl orderService) {
        this.userService = userService;
        this.orderService = orderService;
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

    @PostMapping("tripCost")
    public ResponseEntity tripCost (@RequestBody TripCostRequestDto tripCostRequestDto) {
        Order order = orderService.tripCost(tripCostRequestDto);

        return ResponseEntity.ok(TripCostDto.fromOrder(order));
    }

    @PostMapping("createOrder")
    public ResponseEntity createOrder (@RequestBody TripCostRequestDto tripCostRequestDto) {
        Order order = orderService.createOrder(tripCostRequestDto);
//        return ResponseEntity.ok(OrderDto.fromOrder(order));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("findOrderById")
    public ResponseEntity findOrderById (@RequestBody ByIdRequestDto byIdRequestDto) {
        Long id = byIdRequestDto.getId();

        Order order = orderService.findOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        OrderDto result = OrderDto.fromOrder(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("findExecutionOrderById")
    public ResponseEntity findExecutionOrderById (@RequestBody ByIdRequestDto byIdRequestDto) {
        Long id = byIdRequestDto.getId();

        Order order = orderService.findOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ExecuteOrderDto result = ExecuteOrderDto.fromOrder(order);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}