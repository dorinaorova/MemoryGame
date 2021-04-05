package hu.bme.aut.android.memorygame.toplist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.memorygame.R
import hu.bme.aut.android.memorygame.toplist.model.ResultGame
import kotlinx.android.synthetic.main.result_fragment.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private var resultList = ArrayList<ResultGame>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.result_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = resultList[position]

        holder.result = result

        holder.Date.text = result.date
        holder.Seconds.text = result.seconds.toString()
        holder.Mode.text = result.mode

    }


    fun addAll(list: List<ResultGame>) {
        val size = resultList.size
        resultList.addAll(list)
        notifyItemRangeInserted(size, list.size)
    }

    fun addByMode(list: List<ResultGame>, mode: String){
        resultList.clear()
        for (item in list) {
            if(item.mode.equals(mode)) resultList.add(item)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount() = resultList.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Date: TextView = itemView.tvDate
        val Seconds: TextView = itemView.tvSeconds
        val Mode: TextView = itemView.tvMode
        var result: ResultGame? = null

    }


}