package com.doshin.spring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class UserHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().withDetail("Doshin", "is happy!").build();
	}

}
