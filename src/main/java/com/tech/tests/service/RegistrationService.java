package com.tech.tests.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tech.tests.exception.InvalidEmailException;
import com.tech.tests.exception.UsernameAlreadyExsitsException;
import com.tech.tests.model.Address;
import com.tech.tests.model.Role;
import com.tech.tests.model.User;
import com.tech.tests.payload.AddressPayload;
import com.tech.tests.payload.RegistrationPayload;
import com.tech.tests.repository.RoleRepository;
import com.tech.tests.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public void registration(RegistrationPayload registrationPayload) throws Exception {
		
		String username = registrationPayload.getUsername();
		String email = registrationPayload.getEmail();
		String firstName = registrationPayload.getFirstName();
		String lastName = registrationPayload.getLastName();
		String password = registrationPayload.getPassword();
		
		AddressPayload addresspayLoad = registrationPayload.getAddress();
		String country = addresspayLoad.getCountry();
		String state = addresspayLoad.getState();
		String city = addresspayLoad.getCity();
		String pincode = addresspayLoad.getPincode();
		String addressLineFirst = addresspayLoad.getAddressLineFirst();
		String addressLineSecond = addresspayLoad.getAddressLineSecond();
		String addressLineThird = addresspayLoad.getAddressLineThird();
		
		
		if(userRepository.existsByEmail(email)) {
			throw new InvalidEmailException();
		}
		if(userRepository.existsByUsername(username)) {
			throw new UsernameAlreadyExsitsException();
		}
		
		//creating user from RegisterPayload
		User user = new User(username, email, firstName, lastName, password);
		
		//creating Address from RegisterPayload
		Address address = new Address(country, state, city, pincode, addressLineFirst, addressLineSecond, addressLineThird);
		
		//creating roles add user as default role to all kind of user
		List<Role> roles = roleRepository.findByRoleNameIn(registrationPayload.getRoles());
		Role defaultRole = roleRepository.findByRoleName("ROLE_USER").get();
		roles.add(defaultRole);
		Set<Role> roles_set = roles.stream().collect(Collectors.toSet());
		
		//setting roles and address to user object
		user.setRoles(roles_set);
		user.setAddress(address);
		
		//encrip passwored befor saving
		user.setPassword(passwordEncoder.encode(password));
		
		//save user
		userRepository.save(user);
		
		
		
	}

}
