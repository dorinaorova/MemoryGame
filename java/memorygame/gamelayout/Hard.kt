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
import kotlinx.android.synthetic.main.activity_hard.*

class Hard : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard)
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
                R.drawable.panda,
                R.drawable.squirrel,
                R.drawable.tiger,
                R.drawable.wolf,
                R.drawable.zebra,
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
                R.drawable.panda,
                R.drawable.squirrel,
                R.drawable.tiger,
                R.drawable.wolf,
                R.drawable.zebra
        )

        val buttons: Array<ImageButton> = arrayOf(
                imageButton1,
                imageButton2,
                imageButton3,
                imageButton4,
                imageButton5,
                imageButton6,
                imageButton7,
                imageButton8,
                imageButton9,
                imageButton10,
                imageButton11,
                imageButton12,
                imageButton13,
                imageButton14,
                imageButton15,
                imageButton16,
                imageButton17,
                imageButton18,
                imageButton19,
                imageButton20,
                imageButton21,
                imageButton22,
                imageButton23,
                imageButton24,
                imageButton25,
                imageButton26,
                imageButton27,
                imageButton28,
                imageButton29,
                imageButton30
        )
        val game = Game(29, image, buttons, this)
        game.gameStart()
    }

    override fun onBackPressed() {
        val resultIntent =Intent()
        resultIntent.putExtra("key", ResultGame(date="-1", seconds=0, mode=null));
        setResult(0, resultIntent);
        finish()
    }
}