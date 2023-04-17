package org.backend.kappastoneletsgo.service;
import org.backend.kappastoneletsgo.models.dto.LoginFormDTO;
import org.backend.kappastoneletsgo.models.usermodels.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(int id);

    User findByUsername(String username);

    User save(User user);

    User registerNewUserAccount(LoginFormDTO loginFormDTO);

}
