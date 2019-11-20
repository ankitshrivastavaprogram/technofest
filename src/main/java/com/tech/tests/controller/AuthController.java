package com.tech.tests.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.tests.model.User;
import com.tech.tests.payload.ApiResponse;
import com.tech.tests.payload.LoginPayload;
import com.tech.tests.payload.LoginResponse;
import com.tech.tests.payload.RegistrationPayload;
import com.tech.tests.repository.RoleRepository;
import com.tech.tests.repository.UserRepository;
import com.tech.tests.security.JwtTokenProvider;
import com.tech.tests.security.UserPrincipal;
import com.tech.tests.service.LoginService;
import com.tech.tests.service.RegistrationService;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
	
	@GetMapping("hello/testing")
	public ResponseEntity<Object> hello() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("registration")
	public ResponseEntity<ApiResponse> registration(@RequestBody RegistrationPayload registrationPayload){
		try {
			registrationService.registration(registrationPayload);
		} catch (Exception e) {
			
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), false),HttpStatus.UNAUTHORIZED);
			
		}
		return new ResponseEntity<>(new ApiResponse("registration is done", true),HttpStatus.OK);
	}
	
	@PostMapping("login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginPayload loginPayload){
		
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		loginPayload.getUsernameOrEmail(),
                		loginPayload.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
        String jwt = tokenProvider.generateToken(userPrincipal.getId());
        return ResponseEntity.ok(new LoginResponse(jwt,true));
	}
	
	@GetMapping("/get/{userNameOrEmail}")
	public ResponseEntity<User> get(@PathVariable String userNameOrEmail ){
		System.out.println(userNameOrEmail);
		User user = userRepository.findByUsernameOrEmail(userNameOrEmail, userNameOrEmail).get();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
