package developerkampus.kuriohackumn.model;

/**
 * Created by Dodi Rivaldi on 26/11/2016.
 */

public class News {
    private String id,title,image,content,vote,hoax,truth;

    public News() {
    }

    public News(String id,String title,String image,String content,String vote,
                 String hoax,String truth) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.vote = vote;
        this.hoax = hoax;
        this.truth = truth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String setTitle(String title) {
        this.title = title;
        return title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getHoax() {
        return hoax;
    }

    public void setHoax(String hoax) {
        this.hoax = hoax;
    }

    public String getTruth() {
        return truth;
    }

    public void setTruth(String truth) {
        this.truth = truth;
    }
}
