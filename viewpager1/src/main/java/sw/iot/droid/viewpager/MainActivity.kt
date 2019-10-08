package sw.iot.droid.viewpager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        val position = intent.getStringExtra(INTENT_KEY)
        textView_show.text = position
    }

    companion object {
        const val INTENT_KEY = "intent_key"
        @JvmStatic
        fun newIntent(context: Context, key: String): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(INTENT_KEY, key)
            return intent
        }
    }
}
