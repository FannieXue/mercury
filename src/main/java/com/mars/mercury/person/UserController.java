package com.mars.mercury.person;

import com.mars.depot.person.PersonClientWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @project mercury
 * @author: FannieXue
 * @time 2019-04-17
 */
@RefreshScope
@RestController
public class UserController {

//    @Autowired
//    LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String getUserById(){
//
////        ServiceInstance serviceInstance = loadBalancerClient.choose("person");
////        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/api/person/v1/users/" + 1;
////        System.out.println(url);
////        return restTemplate.getForObject(url, String.class);
//
//        // 在 application启动类的 RestTemplate restTemplate() 上加了@LoadBalanced 后,可以直接这样调用
//        return restTemplate.getForObject("http://person//api/person/v1/users/1", String.class);
//    }
//
//

    @Autowired
    PersonClientWrap personClientWrap;

    @Value("${from}")
    private String from;


    private final Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/api/mercury/v1/users", method = RequestMethod.GET)
    public String getUserById(HttpServletRequest request){
        logger.info("murcury.UserController --> getUserById(), TraceId={}, SpanId={} ",
                request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"));
        personClientWrap.getUser(1L);
        personClientWrap.getUser(1L);
        return personClientWrap.getUser(1L);
    }

    @RequestMapping(value = "/api/mercury/v1/from", method = RequestMethod.GET)
    public String from(){

        return this.from;
    }

}
