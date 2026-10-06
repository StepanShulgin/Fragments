package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class FragmentAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_a)
        if (savedInstanceState == null) {
            supportFragmentManager.commit { add(R.id.fragmentContainer, FragmentA()) }
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val childManager = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
                    ?.childFragmentManager
                if (childManager != null && childManager.backStackEntryCount > 0) {
                    childManager.popBackStack()
                } else {
                    finish()
                }
            }
        })
    }
}
