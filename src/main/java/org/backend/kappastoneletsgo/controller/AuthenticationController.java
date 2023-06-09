package org.backend.kappastoneletsgo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.backend.kappastoneletsgo.data.UserRepository;
import org.backend.kappastoneletsgo.exception.UserAlreadyExistException;
import org.backend.kappastoneletsgo.models.usermodels.Role;
import org.backend.kappastoneletsgo.models.usermodels.User;
import org.backend.kappastoneletsgo.models.dto.LoginFormDTO;
import org.backend.kappastoneletsgo.models.dto.RegisterFormDTO;
import org.backend.kappastoneletsgo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();

    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            System.out.println("Error processing");
            return "register";
        }

        User existingUser = userRepository.findByUserName(registerFormDTO.getUserName());

        if (existingUser != null) {
            errors.rejectValue("userName", "userName.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }

        User newUser = new User(registerFormDTO.getUserName(), registerFormDTO.getPassword());
        newUser.setRole(Role.USER);
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }

//    @PostMapping("/register")
//    public ModelAndView registerUserAccount(@ModelAttribute @Valid LoginFormDTO loginFormDTO, HttpServletRequest request, Errors errors) {
//
//        UserServiceImpl userService = new UserServiceImpl();
//
//        try {
//            User registered = userService.registerNewUserAccount(loginFormDTO);
//        } catch (UserAlreadyExistException userAlreadyExistException) {
//            registerUserAccount(loginFormDTO, request, errors).addObject("message", "An account for that username already exists.");
//            return registerUserAccount(loginFormDTO, request, errors);
//        }
//
//        return new ModelAndView("successRegister", "userDTO", loginFormDTO);
//
//    }


    @GetMapping("/loginkappa")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping("/loginkappa")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        User theUser = userRepository.findByUserName(loginFormDTO.getUserName());

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }

}
