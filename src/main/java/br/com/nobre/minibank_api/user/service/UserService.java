package br.com.nobre.minibank_api.user.service;

import br.com.nobre.minibank_api.user.model.User;
import br.com.nobre.minibank_api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
