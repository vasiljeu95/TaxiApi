package com.github.vasiljeu95.taxiapi.restController;

import com.github.vasiljeu95.taxiapi.configuration.jwt.JwtTokenProvider;
import com.github.vasiljeu95.taxiapi.dto.requestDto.AuthenticationRequestDto;
import com.github.vasiljeu95.taxiapi.dto.NewUserDto;
import com.github.vasiljeu95.taxiapi.entity.User;
import com.github.vasiljeu95.taxiapi.mapper.UserMapperImpl;
import com.github.vasiljeu95.taxiapi.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * AuthenticationRestController
 *
 * @author Stepan Vasilyeu
 * @since 07.07.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth/")
public class AuthenticationRestController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserServiceImp userService;
    private final UserMapperImpl userMapper;

    @PostMapping("login")
    public ResponseEntity login (@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        try {
            String username = authenticationRequestDto.getUsername();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, authenticationRequestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoleList());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username and password");
        }
    }

    @PostMapping("userRegistration")
    public ResponseEntity<NewUserDto> userRegistration(@RequestBody NewUserDto userDto) {
        if (userService.existByUsername(userDto.getUsername()) || userService.existByEmail(userDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.userRegistr(userMapper.toUser(userDto));
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("driverRegistration")
    public ResponseEntity<NewUserDto> driverRegistration(@RequestBody NewUserDto userDto) {
        if (userService.existByUsername(userDto.getUsername()) || userService.existByEmail(userDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.driverRegistr(userMapper.toUser(userDto));
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

//    @GetMapping("/logout")
//    public ResponseEntity<Map<Object, Object>> logOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Map<Object, Object> resp = new HashMap<>();
//
//        if (auth != null) {
//            resp.put("username", auth.getName());
//            resp.put("session, lastAccessedTime", session.getLastAccessedTime());
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//
//        return new ResponseEntity<>(resp, HttpStatus.OK);
//    }
}
