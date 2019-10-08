package sw.iot.droid.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import sw.iot.droid.viewpager.adapter.ViewPagerAdapter;
import sw.iot.droid.viewpager.bean.MyFragmentItem;
import sw.iot.droid.viewpager.bean.ViewPagerItem;
import sw.iot.droid.viewpager.data.StaticData;
import sw.iot.droid.viewpager.fragment.BlankFragment;

/**
 * @author Administrator
 * @date 20181214
 * ViewPagerDemo
 */
public class ViewPagerActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    public static final String TAG = "ViewPagerActivity";
    private ViewPager viewPager;
    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initData();
        initView();
    }

    private void initData() {
        List<MyFragmentItem> fragmentList = new ArrayList<>();
        final List<ViewPagerItem> list = StaticData.INSTANCE.getViewPagerData();
        for (ViewPagerItem item : list) {
            fragmentList.add(new MyFragmentItem(BlankFragment.newInstance(item.getTitle(), item.getImageId()), item.getTitle()));
        }
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(mAdapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                swapToLast();
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                swapToNext();
                return true;
            case KeyEvent.KEYCODE_DPAD_CENTER:
                toMain();
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }

    }

    private void toMain() {
//        startActivity(MainActivity.newIntent(this, String.valueOf(viewPager.getCurrentItem())));
        startActivity(new Intent(this, SettingsActivity.class));
    }

    private void swapToLast() {
        int forwardPosition = viewPager.getCurrentItem() - 1;
        if (forwardPosition >= 0) {
            viewPager.setCurrentItem(forwardPosition);
        } else {
            Toast.makeText(this, "已到开头", Toast.LENGTH_SHORT).show();
            //viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 1);
        }
    }

    private void swapToNext() {
        int nextPosition = viewPager.getCurrentItem() + 1;
        if (nextPosition < viewPager.getAdapter().getCount()) {
            viewPager.setCurrentItem(nextPosition);
        } else {
            Toast.makeText(this, "已到尽头", Toast.LENGTH_SHORT).show();
            //viewPager.setCurrentItem(0);
        }

    }

    @Override
    public void onFragmentInteraction(@NotNull String title) {
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
    }
}
