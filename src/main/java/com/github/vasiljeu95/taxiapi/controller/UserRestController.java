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
        TripCostDto tripCostDto = new TripCostDto();

        return ResponseEntity.ok(tripCostDto.fromOrder(order));
    }

//    @PostMapping("createOrder")
//    public ResponseEntity createOrder (@RequestBody TripCostRequestDto tripCostRequestDto) {
//        String startCoordinate = tripCostRequestDto.getStartCoordinate();
//        String finishCoordinate = tripCostRequestDto.getFinishCoordinate();
//
//        Map<Object, Object> orderMap = new HashMap<>();
//        Map<Object, Object> carInfo = new HashMap<>();
//        orderMap.put("orderId","1");
//        orderMap.put("waitingTime","300");
//        orderMap.put("price", "50");
//        orderMap.put("distance", "5");
//        orderMap.put("startCoordinate", startCoordinate);
//        orderMap.put("finishCoordinate", finishCoordinate);
//        carInfo.put("carManufacturer","Volkswagen");
//        carInfo.put("carModel","Polo Sedan");
//        carInfo.put("carColor","Black");
//        carInfo.put("carGovernmentNumber","AV44227");
//        orderMap.put("carInfo", carInfo);
//
//        return ResponseEntity.ok(orderMap);
//    }

//    @PostMapping("createOrder")
//    public ResponseEntity createOrder (@RequestBody TripCostRequestDto tripCostRequestDto) {
//        String startCoordinate = tripCostRequestDto.getStartCoordinate();
//        String finishCoordinate = tripCostRequestDto.getFinishCoordinate();
//
//        // TODO some method with tripCostRequestDto calculate to OrderDto
//
//        OrderDto orderDto = new OrderDto();
//        orderDto.setCarId(1L);
//        orderDto.setOrderTime(300L);
//        orderDto.setPrice(50d);
//        orderDto.setDistance("2.25");
//        orderDto.setStartCoordinate("53.125354, 17.986678");
//        orderDto.setFinishCoordinate("53.108045, 18.007878");
//
//        orderService.orderRegist(orderDto.toOrder());
//        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
//    }

    @PostMapping("getOrderById")
    public ResponseEntity findOrderById (@RequestBody ByIdRequestDto byIdRequestDto) {
        Long id = byIdRequestDto.getId();

        Order order = orderService.findOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        OrderDto result = OrderDto.fromOrder(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("getExecutionOrderById")
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