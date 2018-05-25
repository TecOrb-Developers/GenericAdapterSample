package akansha.tecorb.genericsampleapp.Model;

/**
 * Created by tecorb on 24/5/18.
 */

public class MoviesModel {
   private String title ;
   private String subTitle ;
   private int image ;
   private String rating ;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
