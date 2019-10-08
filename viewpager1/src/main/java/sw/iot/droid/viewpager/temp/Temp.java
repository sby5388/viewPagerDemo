package sw.iot.droid.viewpager.temp;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * @author by5388  on 2018/12/14.
 */
public class Temp {
    private static final String TAG = "TEMP";

    private void test(@NonNull ViewPager pager, @NonNull PagerAdapter adapter) {
        //设置页数
        pager.setCurrentItem(0);
        //设置设配器
        pager.setAdapter(adapter);
        //
        pager.setCurrentItem(0, true);
//        pager.addView();

    }


    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.d(TAG, "onPageScrolled: position = " + position);
            Log.d(TAG, "onPageScrolled: positionOffset = " + positionOffset);
            Log.d(TAG, "onPageScrolled: positionOffsetPixels = " + positionOffsetPixels);
        }

        @Override
        public void onPageSelected(int position) {
            Log.d(TAG, "onPageSelected:  position = " + position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            Log.d(TAG, "onPageScrollStateChanged: state =  " + state);
        }
    };

}
