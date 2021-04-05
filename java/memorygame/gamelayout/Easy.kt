package hu.bme.aut.android.memorygame.gamelayout

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.android.memorygame.Game
import hu.bme.aut.android.memorygame.R
import hu.bme.aut.android.memorygame.toplist.model.ResultGame
import kotlinx.android.synthetic.main.activity_easy.*


class Easy : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)

        val image: MutableList<Int> = mutableListOf(
            R.drawable.cat,
            R.drawable.sheep,
            R.drawable.fox,
            R.drawable.tiger,
            R.drawable.cow,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.sheep,
            R.drawable.fox,
            R.drawable.tiger,
            R.drawable.cow,
            R.drawable.dog
        )

        val buttons: Array<ImageButton> = arrayOf(
            btn1,
            btn2,
            btn3,
            btn4,
            btn5,
            btn6,
            btn7,
            btn8,
            btn9,
            btn10,
            btn11,
            btn12
        )

        val game = Game(11, image, buttons, this)
        game.gameStart()

    }

    override fun onBackPressed() {
        val resultIntent =Intent()
        resultIntent.putExtra("key", ResultGame(date="-1", seconds=0, mode=null));
        setResult(0, resultIntent);
        finish()
    }



}