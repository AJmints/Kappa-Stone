package org.backend.kappastoneletsgo.service;

import jakarta.transaction.Transactional;
import org.backend.kappastoneletsgo.data.UserRepository;
import org.backend.kappastoneletsgo.exception.UserAlreadyExistException;
import org.backend.kappastoneletsgo.exception.UserNotFoundException;
import org.backend.kappastoneletsgo.models.dto.LoginFormDTO;
import org.backend.kappastoneletsgo.models.usermodels.Role;
import org.backend.kappastoneletsgo.models.usermodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User registerNewUserAccount(LoginFormDTO loginFormDTO) throws UserAlreadyExistException {

        if (userExists(loginFormDTO.getUserName())) {
            throw new UserAlreadyExistException();
        }


        User newUser = new User();
        newUser.setUserName(loginFormDTO.getUserName());
//        newUser.setPwHash(loginFormDTO.getPassword());
        newUser.setPassword((loginFormDTO.getPassword()));
        newUser.setRole(Role.USER);

        return userRepository.save(newUser);
    }

    private boolean userExists(String user) {
        return userRepository.findByUserName(user) != null;
    }
}
