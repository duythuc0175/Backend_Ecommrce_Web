package org.sang.backendecommerce.service;

import org.hibernate.query.IllegalQueryOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthServiceImp implements AuthService{

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	@Autowired
	public AuthServiceImpl(UserService userService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@Override
	public UserDTO signUp(UserDTO userDTO){
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		if (userDTO.getRole() == null)
			userDTO.setRole(UserRole.USER);
		return userService.addUser(userDTO).orElseThrow(()->new IllegalQueryOperationException("User already exists"));
	}

	@Override
	public SigninResponseDTO logIn(UserDTO userDTO){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						userDTO.getEmail(),
						userDTO.getPassword()));
		UserDTO user = userService.getUserByEmail(userDTO.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
		var jwt = jwtService.generateToken(UserMapper.INSTANCE.toUser(user));

		return new SigninResponseDTO(jwt, user.getRole());
	}

}
