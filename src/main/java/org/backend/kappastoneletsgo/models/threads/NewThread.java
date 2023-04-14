package org.backend.kappastoneletsgo.models.threads;

import jakarta.validation.constraints.Size;
import org.backend.kappastoneletsgo.models.IdGenerator;

public class NewThread extends IdGenerator {

    @Size(min = 3, max = 50, message = "Title can have between 3 and 50 characters.")
    private String title;

    @Size(min = 3, max = 700, message = "Post must be between 3 and 700 characters.")
    private String titleContent;

    public NewThread() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleContent() {
        return titleContent;
    }

    public void setTitleContent(String titleContent) {
        this.titleContent = titleContent;
    }
}
