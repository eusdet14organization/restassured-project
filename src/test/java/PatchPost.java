import java.util.Objects;

public class PatchPost {

    private String title;

    // Getter Methods


    public String getTitle() {
        return title;
    }


    // Setter Methods


    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PatchPost post = (PatchPost) obj;

        return getTitle().equals(post.getTitle());
    }


    @Override
    public int hashCode() {
        return Objects.hash( title);
    }

    @Override
    public String toString() {
        return "Post{" +

                ", title='" + title + '}';
    }
}
