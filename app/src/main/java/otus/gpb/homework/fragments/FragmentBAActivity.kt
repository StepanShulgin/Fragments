package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class FragmentBAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_b_host)
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        if (isLandscape && supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        }
        val primary = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        val secondary = supportFragmentManager.findFragmentById(R.id.fragmentBBContainer)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            if (primary == null) add(R.id.fragmentContainer, FragmentBA())
            if (isLandscape) {
                if (secondary == null) add(R.id.fragmentBBContainer, FragmentBB())
            } else if (secondary != null) {
                remove(secondary)
            }
        }
    }
}
