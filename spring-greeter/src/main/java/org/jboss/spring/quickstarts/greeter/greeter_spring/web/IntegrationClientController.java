package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import org.jboss.logging.Logger;
import org.jboss.spring.quickstarts.greeter.greeter_spring.EchoRequestGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("client")
public class IntegrationClientController {

    private static final Logger LOGGER = Logger.getLogger(IntegrationClientController.class);

    @Autowired
    private EchoRequestGateway requestGateway;

    @RequestMapping(method = RequestMethod.GET)
    void getInitialMessage() {
        // do nothing
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ModelAttribute("message") String echo(@RequestParam(required = false) String what) {
        LOGGER.infof("Trying to forward {}", what);
        return requestGateway.echo(what);
    }

}

