package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class FragmentBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_b)
        if (savedInstanceState == null) {
            supportFragmentManager.commit { add(R.id.fragmentContainer, FragmentB()) }
        }
    }
}
