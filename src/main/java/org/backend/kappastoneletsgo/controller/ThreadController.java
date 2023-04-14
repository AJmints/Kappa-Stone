package org.backend.kappastoneletsgo.controller;

import jakarta.validation.Valid;
import org.backend.kappastoneletsgo.models.threads.NewThread;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/thread/")
public class ThreadController {

//    @RequestMapping(value = "new", method = RequestMethod.POST)
//    public String processAndAddNewTopic(@Valid @ModelAttribute("newTopic") NewThread newThread,
//                                        BindingResult result,
//                                        Authentication authentication,
//                                        Model model) {
//
//        if (result.hasErrors()) {
//            return "new_topic_form";
//        }
//
//        Thread thread = new Thread();
////        thread.setUser(userService.findByUsername(authentication.getName()));
////        thread.setTitle(newThread.getTitle());
////        thread.setContent(newThread.getContent());
////        topicService.save(thread);
//
//        return "redirect:/topic/" + thread.getId();
//    }
}
