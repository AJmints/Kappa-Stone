package org.backend.kappastoneletsgo.models.postmodels;

import jakarta.validation.constraints.Size;

public class NewPost {

    @Size(min = 3, max = 1000, message = "Post must be between 3 and 1000 characters.")
    private String postContent;

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
