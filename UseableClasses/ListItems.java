package android.aitlindia.com.saddacanteen.UseableClasses;


/**
 * Created by krishna on 20/4/17.
 */

public class ListItems {

    public ListItems(){}

    public String getTitle() {
        return title;
    }

    public int getPhotoId() {
        return photoId;
    }

    private String title;
    private int photoId;

    public ListItems(String title, int photoId) {
            this.title = title;
            this.photoId = photoId;
        }
}
