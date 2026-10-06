package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class FragmentBAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_b_host)
        if (savedInstanceState != null) return

        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        supportFragmentManager.commit {
            if (isLandscape) {
                add(R.id.fragmentBAContainer, FragmentBA())
                add(R.id.fragmentBBContainer, FragmentBB())
            } else {
                add(R.id.fragmentContainer, FragmentBA())
            }
        }
    }
}
