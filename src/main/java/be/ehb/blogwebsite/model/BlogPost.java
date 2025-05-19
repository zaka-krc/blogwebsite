package be.ehb.blogwebsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime postDate;
    @Size(min = 4, max = 20)
    private String username;
    @NotEmpty
    private String content;

    public BlogPost() {
        this.postDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public @Size(min = 4, max = 20) String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 4, max = 20) String username) {
        this.username = username;
    }

    public @NotEmpty String getContent() {
        return content;
    }

    public void setContent(@NotEmpty String content) {
        this.content = content;
    }
}
