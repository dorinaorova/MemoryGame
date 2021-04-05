package hu.bme.aut.android.memorygame.timer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import androidx.fragment.app.Fragment
import hu.bme.aut.android.memorygame.R
import kotlinx.android.synthetic.main.timer_fragment.*

class Timer_Fragment : Fragment(){

    private lateinit var timer :Chronometer

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.timer_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timer= chronometerid as Chronometer
        start()
    }

    fun start(){
        timer.start()
    }
    fun stop(){
        timer.stop()
    }
    fun getTime(): String? {
        return timer.format
    }


}