package com.codegen.controller.api;

import com.codegen.controller.projection.UserLoginProjection;
import com.codegen.exception.EmailAlreadyExistsException;
import com.codegen.model.User;
import com.codegen.service.user.UserService;
import com.codegen.util.security.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@PropertySource("classpath:constants.properties")
@RestController
@RequestMapping("api")
public class MainController {

    @Value("${token_name}")
    private String tokenName;
    @Value("${wrong_password}")
    private String wrongPassword;

    private TokenHandler tokenHandler;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MainController(TokenHandler tokenHandler, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.tokenHandler = tokenHandler;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/token")
    public String getToken() {
        return tokenHandler.generateAccessToken(1L, LocalDateTime.now().plusDays(14));
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody UserLoginProjection userLoginProjection,
                                HttpServletResponse response) {
        String message = null;
        User user = null;
        try {
            user = (User) userService.loadUserByUsername(userLoginProjection.getEmail());
            if (bCryptPasswordEncoder.matches(userLoginProjection.getPassword(), user.getPassword())) {
                response.setHeader(tokenName, tokenHandler.generateAccessToken(user.getId(), LocalDateTime.now().plusDays(14)));
                Map<String, Object> userInfo = new HashMap<>();
                userInfo.put("name", user.getName());
                userInfo.put("roles",
                        user.getAuthorities()
                                .stream()
                                .map(role -> role.getAuthority())
                                .collect(Collectors.toList())
                );
                return ResponseEntity.ok(tokenHandler.encode(userInfo));
            } else {
                message = wrongPassword;
            }
        } catch (UsernameNotFoundException exception) {
            message = exception.getMessage();
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(message);
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        try {
            userService.saveUser(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", e.getMessage()));
        }
    }

    @PostMapping("registration/checkEmail")
    public ResponseEntity checkEmail(@RequestParam String email) {
        try {
            userService.checkEmail(email);
            return new ResponseEntity(HttpStatus.OK);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("message", e.getMessage()));
        }
    }

}
