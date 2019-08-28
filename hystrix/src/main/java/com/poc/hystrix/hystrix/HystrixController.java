package com.poc.hystrix.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @HystrixCommand(fallbackMethod = "defaultName")
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
	public String getName(@PathVariable String name) {
        return new RestTemplate()
                .getForObject("http://localhost:9090/greeting/{username}",
                        String.class, name);
    }

    private String defaultName(String name) {
        return "Off";
    }
}

