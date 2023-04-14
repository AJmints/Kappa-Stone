package org.backend.kappastoneletsgo.models.usermodels;

import org.backend.kappastoneletsgo.models.postmodels.Post;
import org.backend.kappastoneletsgo.models.threads.Thread;

import java.util.Set;

public class UserProfile {

    private User user;

    private Set<Post> posts;

    private Set<Thread> thread;

    public UserProfile() {
    }

    public UserProfile(User user, Set<Post> posts, Set<Thread> thread) {
        super();
        this.user = user;
        this.posts = posts;
        this.thread = thread;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Thread> getThread() {
        return thread;
    }

    public void setThread(Set<Thread> thread) {
        this.thread = thread;
    }
}
