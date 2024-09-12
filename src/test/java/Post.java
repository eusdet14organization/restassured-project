import java.util.Objects;

public class Post {
    private int id;
    private String title;
    private String body;
    private int userId;

    // Getter Methods

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Post post = (Post) obj;

        return getUserId() == post.getUserId() &&
                getTitle().equals(post.getTitle()) &&
                getBody().equals(post.getBody());
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, userId);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                '}';
    }
}
