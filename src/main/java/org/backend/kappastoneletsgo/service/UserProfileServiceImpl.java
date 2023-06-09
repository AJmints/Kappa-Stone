package org.backend.kappastoneletsgo.service;

import org.backend.kappastoneletsgo.models.usermodels.User;
import org.backend.kappastoneletsgo.models.usermodels.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserService userService;

//    @Autowired
//    private PostService postService;

//    @Autowired
//    private TopicService topicService;

    @Override
    public UserProfile findOne(int userId) {
        UserProfile userProfile = new UserProfile();
        User user = userService.findOne(userId);
        userProfile.setUser(user);
//        userProfile.setPosts(postService.findByUser(user));
//        userProfile.setTopics(topicService.findByUser(user));
        return userProfile;
    }

    @Override
    public UserProfile findOne(String username) {
        return findOne(userService.findByUsername(username).getId());
    }

}
