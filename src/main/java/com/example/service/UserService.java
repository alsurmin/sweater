package com.example.service;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.ropos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        boolean isUserExists = false;
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            isUserExists = true;
        }
        user.setActive(true);
        user.setActivationCode(UUID.randomUUID().toString());
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String subject = "Activation code";
            String message = String.format(
                    "Hello, %s! \n" +
                    "Welcome to Sweater! Please visit next link http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), subject, message);
        }

        return isUserExists;
    }

    public boolean activateUser(String code) {
        boolean userIsFound = true;
        User user = userRepo.findByActivationCode(code);

        if (user == null) {
            userIsFound = false;
        } else {
            user.setActivationCode(null);
            userRepo.save(user);
        }

        return userIsFound;
    }
}