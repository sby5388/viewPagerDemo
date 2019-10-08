package sw.iot.droid.viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import sw.iot.droid.viewpager.bean.MyFragmentItem;

/**
 * ViewPager 适配器
 * TODO FragmentPagerAdapter是另外一种可用的PagerAdapter，其用法与FragmentStatePagerAdapter基本一致。
 * 唯一的区别在于，卸载不再需要的fragment时，各自采用的处理方法有所不同。
 * TODO FragmentStatePagerAdapter会销毁不需要的fragment。
 * 事务提交后，activity的Fragment- Manager中的fragment会被彻底移除。
 * FragmentStatePagerAdapter类名中的“state”表明：在 销毁fragment时，可在onSaveInstanceState(Bundle)方法中保存fragment的Bundle信息。
 * 用户切换回来时，保存的实例状态可用来生成新的fragment（如图11-4所示）。
 * TODO 相比之下，FragmentPagerAdapter有不同的做法。
 * 对于不再需要的fragment，FragmentPagerAdapter会选择调用事务的detach(Fragment)方法来处理它，而非remove(Fragment)方 法。
 * 也就是说，FragmentPagerAdapter只是销毁了而fragment的视图，而fragment实例还保留在 FragmentManager中。
 * TODO 因此，FragmentPagerAdapter 创建的fragment永远不会被销毁（如图11-5 所示）。
 * TODO 选择哪种adapter取决于应用的要求。通常来说，使用FragmentStatePagerAdapter更节省 内存。
 * CriminalIntent应用需显示大量crime记录，每份记录最终还会包含图片。在内存中保存所有 信息显然不合适，因此我们选择使用FragmentStatePagerAdapter
 * 另一方面，如果用户界面只需要少量固定的fragment，则FragmentPagerAdapter是安全、 合适的选择。
 * 最常见的例子为使用tab选项页显示用户界面。例如，某些应用的明细视图所含内 容较多，通常需分两页显示。
 * 这时就可以将这些明细信息分拆开来，以多页面的形式展现。显然,为用户界面添加支持滑动切换的ViewPager，能增强应用的触摸体验。
 * 此外，将fragment保存在 内存中，更易于管理控制器层的代码。对于这种类型的用户界面，每个activity通常只有两三个 fragment，基本不用担心有内存不足的风险。
 *
 * @author by5388  on 2018/12/14.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<MyFragmentItem> mFragmentList;


    public ViewPagerAdapter(FragmentManager fm, List<MyFragmentItem> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position).getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // TODO: 2019/1/22 这里并不能起到修改Activity标题的效果
        return mFragmentList.get(position).getTitle();
    }
}
