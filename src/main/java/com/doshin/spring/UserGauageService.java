package com.doshin.spring;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

@Service
public class UserGauageService {
	
	CounterService counterService;
	GaugeService gaugeService;
	
	public UserGauageService(CounterService counterService, GaugeService gaugeService) {
		super();
		this.counterService = counterService;
		this.gaugeService = gaugeService;
	}
	
	public void increment(String metricName) {
		counterService.increment(metricName);
	}
	
	public void submit(String metricName, Double value) {
		gaugeService.submit(metricName, value);
	}


}
