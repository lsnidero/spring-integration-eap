package org.jboss.spring.quickstarts.greeter.greeter_spring.service;

import org.jboss.logging.Logger;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.User;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {


    private static final Logger LOGGER = Logger.getLogger(IntegrationService.class);

    @Autowired
    UserDao userDao;


    public String saveData(User user) {
        LOGGER.infof("on service %s in saveData method", IntegrationService.class.getName());
        userDao.createUser(user);
        return String.format("User %s created using an EIP", user.getId());
    }

    public String customActivator(String what) {
        LOGGER.infof("on service %s in customActivator method and the value of what is %s", IntegrationService.class.getName(), what);
        StringBuilder sb = new StringBuilder(what);
        return sb.reverse().toString();
    }
}
