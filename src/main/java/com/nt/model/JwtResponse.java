package com.nt.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
	private String jwtToken;
	private String userName;
}
