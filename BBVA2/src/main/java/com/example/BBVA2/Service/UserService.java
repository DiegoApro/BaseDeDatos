package com.example.BBVA2.Service;


import com.example.BBVA2.DoMain.User;
import com.example.BBVA2.Exceptions.InvalidCredentialsException;
import com.example.BBVA2.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User login(String name, String pass) throws InvalidCredentialsException {
        return repository.findByNameAndPassword(name, pass).orElseThrow(()-> new InvalidCredentialsException(name));
    }

    public User create(User user){
        return repository.create(user);
    }
}