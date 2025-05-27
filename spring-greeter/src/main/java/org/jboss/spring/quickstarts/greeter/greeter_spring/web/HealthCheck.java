package org.jboss.spring.quickstarts.greeter.greeter_spring.web;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller
@RequestMapping("health")
public class HealthCheck {

    private static class Health {
        public String status;

        public Health status(String status) {
            this.status = status;
            return this;
        }
    }

    @RequestMapping(value = "readiness",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Health ready(HttpServletResponse response) {
        if (!condition()) {
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return new Health().status("DOWN");
        }
        return new Health().status("UP");
    }

    @RequestMapping(value = "liveness", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Health live(HttpServletResponse response) {
        if (!condition()) {
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return new Health().status("DOWN");
        }
        return new Health().status("UP");
    }

    private boolean condition() {
        return new Random().nextBoolean();
    }

}
