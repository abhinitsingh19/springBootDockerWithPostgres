package com.spring.boot.docker.postgres.model;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware 
{

	@Override
	public Optional getCurrentAuditor() 
	{
		// TODO Auto-generated method stub
		return Optional.of("Admin");
	}

}
