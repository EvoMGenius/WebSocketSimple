package com.apatrios.WebSocketChat.controller;

import com.apatrios.WebSocketChat.storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin
public class UsersController {

    @GetMapping("/registration/{username}")
    public ResponseEntity<Void> register(@PathVariable String username){
        System.out.println("handling register user request: "+username);
        try {
            UserStorage.getInstance().setUser(username);
        } catch (Exception exception) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping("/fetchAllAUsers")
    public Set<String> fetchAll(){
        return UserStorage.getInstance().getUsers();
    }
}
