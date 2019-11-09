package kz.ticker.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kz.ticker.android.ext.*
import kz.ticker.android.ui.TicketFragment


class HomeActivity : AppCompatActivity() {

    companion object {

        const val HOME = 0

        fun getStartIntent(context: Context, screen: Int): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mToolBar.setToolbarPram(getString(R.string.app_name))
        switchFragment()
    }

    private fun switchFragment() {
        supportFragmentManager.replaceOnce(R.id.frame_container, HOME.toString(), {
            TicketFragment.newInstance()

        }).commit()
    }


}
