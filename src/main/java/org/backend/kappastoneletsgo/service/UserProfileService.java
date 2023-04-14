package org.backend.kappastoneletsgo.service;

import org.backend.kappastoneletsgo.models.usermodels.UserProfile;

public interface UserProfileService {

    public UserProfile findOne(int userId);

    public UserProfile findOne(String username);
}
