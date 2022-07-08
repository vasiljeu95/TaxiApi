package com.github.vasiljeu95.taxiapi.restController;

import com.github.vasiljeu95.taxiapi.dto.AdminUserDto;
import com.github.vasiljeu95.taxiapi.dto.OrderDto;
import com.github.vasiljeu95.taxiapi.dto.requestDto.OrderByIdRequestDto;
import com.github.vasiljeu95.taxiapi.dto.requestDto.TripCostRequestDto;
import com.github.vasiljeu95.taxiapi.dto.UserDto;
import com.github.vasiljeu95.taxiapi.entity.Order;
import com.github.vasiljeu95.taxiapi.entity.User;
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
//        TODO: create some method with Tariff logic
        String startCoordinate = tripCostRequestDto.getStartCoordinate();
        String finishCoordinate = tripCostRequestDto.getFinishCoordinate();

        Map<Object, Object> tripCostMap = new HashMap<>();
        tripCostMap.put("tripDistance", "5");
        tripCostMap.put("tripTime", "150");
        tripCostMap.put("tripPrice", "50");
        tripCostMap.put("startCoordinate", startCoordinate);
        tripCostMap.put("finishCoordinate", finishCoordinate);

        return ResponseEntity.ok(tripCostMap);
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

    @PostMapping("createOrder")
    public ResponseEntity createOrder (@RequestBody TripCostRequestDto tripCostRequestDto) {
        String startCoordinate = tripCostRequestDto.getStartCoordinate();
        String finishCoordinate = tripCostRequestDto.getFinishCoordinate();

        // TODO some method with tripCostRequestDto calculate to OrderDto

        OrderDto orderDto = new OrderDto();
        orderDto.setCarId(1L);
        orderDto.setWaitingTime(300L);
        orderDto.setPrice(50d);
        orderDto.setDistance("2.25");
        orderDto.setStartCoordinate("53.125354, 17.986678");
        orderDto.setFinishCoordinate("53.108045, 18.007878");

        orderService.orderRegist(orderDto.toOrder());
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }

    @PostMapping("getOrderById")
    public ResponseEntity getOrderById (@RequestBody OrderByIdRequestDto orderByIdRequestDto) {
        Long id = orderByIdRequestDto.getId();

        Order order = orderService.findOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        OrderDto result = OrderDto.fromOrder(order);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}