package com.redtrade.services.orderservice.model.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private static List<User> users = null;

    private synchronized static void init() {
        users = new ArrayList<>();
    }

    @RequestMapping(path = "/user/all", method = RequestMethod.GET)
    @ResponseBody
    public static ResponseEntity<List<User>> list() {
        if (users == null)
            init();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(path = "/user/create", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public static ResponseEntity<User> createUser(@RequestBody User provided) {
        if(users == null)
            init();
        User user = new User(provided);
        users.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/user/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public static ResponseEntity<User> removeUser(@PathVariable("id") Long id) {
        User removed = null;
        for (int i = 0; i < users.size(); ++i) {
            if (users.get(i).getId().equals(id)) {
                removed = users.get(i);
                users.remove(i);
            }
        }
        if (removed != null)
            return new ResponseEntity<>(removed, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
