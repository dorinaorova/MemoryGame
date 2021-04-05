package hu.bme.aut.android.memorygame.gamelayout

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import hu.bme.aut.android.memorygame.Game
import hu.bme.aut.android.memorygame.R
import hu.bme.aut.android.memorygame.toplist.model.ResultGame
import kotlinx.android.synthetic.main.activity_medium.*

class Medium : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medium)

        val image: MutableList<Int> = mutableListOf(
                R.drawable.cat,
                R.drawable.sheep,
                R.drawable.fox,
                R.drawable.cheetah,
                R.drawable.camel,
                R.drawable.cow,
                R.drawable.dog,
                R.drawable.horse,
                R.drawable.koala,
                R.drawable.lion,
                R.drawable.cat,
                R.drawable.sheep,
                R.drawable.fox,
                R.drawable.cheetah,
                R.drawable.camel,
                R.drawable.cow,
                R.drawable.dog,
                R.drawable.horse,
                R.drawable.koala,
                R.drawable.lion
        )

        val buttons: Array<ImageButton> = arrayOf(
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9,
            button10,
            button11,
            button12,
            button13,
            button14,
            button15,
            button16,
            button17,
            button18,
            button19,
            button20
        )
        val game = Game(19, image, buttons, this)
        game.gameStart()
    }

    override fun onBackPressed() {
        val resultIntent =Intent()
        resultIntent.putExtra("key", ResultGame(date="-1", seconds=0, mode=null));
        setResult(0, resultIntent);
        finish()
    }
}