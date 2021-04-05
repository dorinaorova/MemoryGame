package hu.bme.aut.android.memorygame

import android.os.Build
import android.os.Handler
import android.os.SystemClock
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.android.memorygame.toplist.model.ResultGame
import hu.bme.aut.android.memorygame.toplist.viewmodel.ResultViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Game constructor(
    val size: Int,
    val image: MutableList<Int>,
    val buttons: Array<ImageButton>,
    val activity: AppCompatActivity
){
        var unknown :Int =size
        var clicked = 0 //felfordított kártyák száma
        var turnOver = false //fel lehet-e fordítani kártyát
        var lastClicked = -1 //utoljára felfordított lap
        var handlerUI: Handler = Handler()
        val front_animation=AnimationUtils.loadAnimation(activity, R.anim.front_anim)
    private lateinit var resultViewModel: ResultViewModel


        @RequiresApi(Build.VERSION_CODES.O)
        fun gameStart() {
            resultViewModel = ViewModelProvider(activity).get(ResultViewModel::class.java)
            image.shuffle()
            val current = SystemClock.elapsedRealtime()
            for (i in 0..size) {
                buttons[i].tag = "back"
                buttons[i].setOnClickListener {
                    turn(i)
                    if(checkEndGame()) {
                        val time  = ((SystemClock.elapsedRealtime()-current)/1000 ).toInt()
                        Toast.makeText(
                            activity,
                            "Finished in $time seconds",
                            Toast.LENGTH_LONG
                        ).show()
                        lateinit var result: ResultGame
                        if(size==11) {
                            result= ResultGame(date= getDate(), seconds= time, mode="easy")
                        }
                        else if(size==19) {
                            result= ResultGame(date= getDate(), seconds= time, mode="medium")
                        }
                        else if(size==29){
                            result= ResultGame(date= getDate(), seconds= time, mode="hard")
                        }
                        resultViewModel.insert(result)
                        activity.finish()
                    }
                }
            }
        }

    fun turn(i: Int){
        if (buttons[i].tag == "back" && !turnOver) {
            buttons[i].startAnimation(AnimationUtils.loadAnimation(activity, R.anim.front_anim))
            buttons[i].setBackgroundResource(image[i])
            buttons[i].tag = image[i]
            if (clicked == 0) {
                lastClicked = i
            }
            clicked++
        }
        if (clicked == 2) {
            for(j in 0..size) {
                buttons[j].isClickable=false
            }
            if (buttons[i].tag == buttons[lastClicked].tag) {
                for(j in 0..size) {
                    buttons[j].isClickable=true
                }
                buttons[i].isClickable = false
                buttons[lastClicked].isClickable = false
                clicked = 0
                unknown-=2
            } else {
                handlerUI.postDelayed(Runnable {
                    buttons[lastClicked].setBackgroundResource(R.drawable.star)
                    buttons[lastClicked].tag = "back"
                    buttons[i].setBackgroundResource(R.drawable.star)
                    buttons[i].tag = "back"
                    buttons[lastClicked].startAnimation(front_animation)
                    buttons[i].startAnimation(front_animation)
                    for (j in 0..size) {
                        buttons[j].isClickable = true
                    }
                    clicked = 0
                }, 500)

            }
        } else if (clicked == 0) {
            turnOver = false
        }
    }

    fun checkEndGame(): Boolean {
        if(unknown<0) return true
        return false
    }


    fun getDate(): String{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd.")
        val formatted = current.format(formatter)
        return formatted
    }

}
