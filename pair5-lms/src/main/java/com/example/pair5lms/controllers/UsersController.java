package com.example.pair5lms.controllers;

import com.example.pair5lms.services.abstracts.UserService;
import com.example.pair5lms.services.dtos.requests.user.AddUserRequest;
import com.example.pair5lms.services.dtos.requests.user.UpdateUserRequest;
import com.example.pair5lms.services.dtos.responses.user.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddUserResponse add(@RequestBody @Valid AddUserRequest request){
        return userService.add(request);
    }

    @PutMapping
    public UpdateUserResponse update(@RequestBody @Valid UpdateUserRequest request){
        return userService.update(request);
    }

    @DeleteMapping
    public DeleteUserResponse delete(@RequestParam int id){
        return userService.delete(id);
    }

    @GetMapping
    public List<ListUserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{getById}")
    public GetUserResponse getById(@PathVariable int getById){
        return userService.getById(getById);
    }
}
