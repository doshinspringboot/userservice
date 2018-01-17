# userservice

## Application URLs

curl -i -H "Accept: application/xml" -H "Content-Type: application/xml" -X GET http://localhost:8080/user/1

## Managment URLs

	1. Spring endpoints
		a. Endpoint - https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html
			i. To enable management.security.enabled=false
			ii. Endpoints
				1) Env variable
					a) http://localhost:8080/env
					b) management.security.enabled=false
				2) Tread dump
					a) http://localhost:8080/dump
				3) Logger  levels
					a) http://localhost:8080/loggers
					b) http://localhost:8080/loggers/com.doshin
				4) Systme matrix
					a) http://localhost:8080/metrics
				5) Heap dump
					a) http://localhost:8080/heapdump
				6) Health
					a) http://localhost:8080/health
				7) Trace of request and response
					a) http://localhost:8080/trace
				8) All config props
					a) http://localhost:8080/configprops
				9) All bean info
					http://localhost:8080/beans