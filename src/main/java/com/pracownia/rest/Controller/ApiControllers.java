package com.pracownia.rest.Controller;

import com.pracownia.rest.Models.User;
import com.pracownia.rest.Repo.UserRepo;
import com.pracownia.rest.Services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;
    private ApiService apiService;

    public ApiControllers(ApiService apiService) {
        this.apiService = apiService;
    }

    //    Tutaj tworzy end-point domysly, gdy wchodzimy na apke to forward slash /
    @GetMapping(value="/")
    public String getPage() {
        return "Welcome!";
    }

//    GetMapping tworzy endpoint ktory nam cos zwraca
    @GetMapping(value="/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

//    postmapping zapisze cos (http post)

    @PostMapping(value="/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
//        userRepo.save(user);
//        return "Saved..!";
        User userFromDb = apiService.addUser(user);
        if (userFromDb == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } else {
            return ResponseEntity.ok(userFromDb);
        }
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setAge(user.getAge());
        userRepo.save(updatedUser);
        return "Updated!";
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with the id: " + id;
    }

}
