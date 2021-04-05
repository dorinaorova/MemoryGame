package hu.bme.aut.android.memorygame

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.android.memorygame.gamelayout.Easy
import hu.bme.aut.android.memorygame.gamelayout.Hard
import hu.bme.aut.android.memorygame.gamelayout.Medium
import hu.bme.aut.android.memorygame.toplist.ToplistActivity
import hu.bme.aut.android.memorygame.toplist.model.ResultGame
import hu.bme.aut.android.memorygame.toplist.viewmodel.ResultViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            intent
            if (settingsFragment.getModeX() == 0) {
                val intent = Intent(this, Easy::class.java)
                startActivity(intent)
            }
            if (settingsFragment.getModeX() == 1) {
                val intent = Intent(this, Medium::class.java)
                startActivity(intent)
            }
            if (settingsFragment.getModeX() == 2) {
                val intent = Intent(this, Hard::class.java)
                startActivity(intent)
            }
        }

        btnToplist.setOnClickListener {
            val intent = Intent(this, ToplistActivity::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {
            settingsFragment.show(supportFragmentManager, "TAG")
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }
}

