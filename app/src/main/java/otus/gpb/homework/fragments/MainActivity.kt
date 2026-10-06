package otus.gpb.homework.fragments

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.openA).setOnClickListener {
            startActivity(Intent(this, FragmentAActivity::class.java))
        }
        findViewById<Button>(R.id.openB).setOnClickListener {
            startActivity(Intent(this, FragmentBActivity::class.java))
        }
        findViewById<Button>(R.id.openExchange).setOnClickListener {
            startActivity(Intent(this, FragmentBAActivity::class.java))
        }
    }
}
