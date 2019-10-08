package sw.iot.droid.viewpager.bean;

import android.support.annotation.DrawableRes;

/**
 * @author by5388  on 2018/12/14.
 */
public class ViewPagerItem {
    private String title;
    private @DrawableRes
    int imageId;

    public ViewPagerItem(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
