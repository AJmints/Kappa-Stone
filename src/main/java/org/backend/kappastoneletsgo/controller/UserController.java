package org.backend.kappastoneletsgo.controller;

import org.backend.kappastoneletsgo.data.UserRepository;
import org.backend.kappastoneletsgo.exception.UserNotFoundException;
import org.backend.kappastoneletsgo.models.usermodels.User;
import org.backend.kappastoneletsgo.models.usermodels.UserProfile;
import org.backend.kappastoneletsgo.service.UserProfileService;
import org.backend.kappastoneletsgo.service.UserProfileServiceImpl;
import org.backend.kappastoneletsgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileServiceImpl userProfileService;


    @RequestMapping(value = "/user/{username}")
    public String findUserByUsernameAndViewProfilePage(@PathVariable String username,
                                                       Model model) {
        model.addAttribute("title", username + "'s History");
        UserProfile userProfile;
        try {
            userProfile = userProfileService.findOne(username);
        } catch (NullPointerException e) {
                throw new UserNotFoundException();
        }

        model.addAttribute("userProfile", userProfile);
        return "user/user-profile";
    }


    @RequestMapping(value = "/users")
    public String listOfAllUser(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("title", "User Profiles");
        return "user/users";
    }

    @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
    public String myProfile(Authentication authentication, Model model) {

        String username = authentication.getName();
        UserProfile userProfile;
        try {
            userProfile = userProfileService.findOne(username);
        } catch (NullPointerException e) {
            throw new UserNotFoundException();
        }
        model.addAttribute("userProfile", userProfile);
        return "user/user-profile";
    }

}
