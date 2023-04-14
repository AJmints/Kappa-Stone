package org.backend.kappastoneletsgo.models.threads;

import jakarta.persistence.Entity;
import org.backend.kappastoneletsgo.models.IdGenerator;
import org.backend.kappastoneletsgo.models.usermodels.User;

@Entity
public class Thread extends IdGenerator {

//    private User user;

    private String title;

    private String content;

    public Thread() {
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
