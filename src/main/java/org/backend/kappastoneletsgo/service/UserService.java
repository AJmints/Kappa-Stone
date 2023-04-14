package org.backend.kappastoneletsgo.service;
import org.backend.kappastoneletsgo.models.dto.LoginFormDTO;
import org.backend.kappastoneletsgo.models.usermodels.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findOne(int id);

    Optional<User> findByUsername(String username);

    User save(User user);

    User registerNewUserAccount(LoginFormDTO loginFormDTO);

}
