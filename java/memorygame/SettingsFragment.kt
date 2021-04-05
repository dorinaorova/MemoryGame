package hu.bme.aut.android.memorygame

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : DialogFragment() {

    var mode: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.settings_fragment, container, false)
        dialog?.setTitle(R.string.tv_settings)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnEasy.setOnClickListener{
            mode=0
            dismiss()
        }

        btnMedium.setOnClickListener{
            mode=1
            dismiss()
        }

        btnHard.setOnClickListener{
            mode=2
            dismiss()
        }
    }


    public fun getModeX(): Int{
        return mode;
    }


}