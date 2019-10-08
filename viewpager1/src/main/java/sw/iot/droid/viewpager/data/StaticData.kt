package sw.iot.droid.viewpager.data

import sw.iot.droid.viewpager.R
import sw.iot.droid.viewpager.bean.ViewPagerItem
import java.util.*

/**
 * 常量数据
 * TODO kotlin 对于单例模式对象，使用的是object来作为关键字，内部详细的实现过程？
 * @author by5388  on 2018/12/14.
 */
object StaticData {
    private var list: MutableList<ViewPagerItem> = ArrayList()

    val viewPagerData: List<ViewPagerItem>
        get() {
            if (list.isEmpty()) {
                val count = 5
                for (i in 0 until count) {
                    list.add(ViewPagerItem("标题$i", R.mipmap.ic_launcher))
                }
            }
            return list
        }
}
