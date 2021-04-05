package hu.bme.aut.android.memorygame.toplist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.android.memorygame.R
import hu.bme.aut.android.memorygame.toplist.adapter.RecyclerViewAdapter
import hu.bme.aut.android.memorygame.toplist.viewmodel.ResultViewModel
//import hu.bme.aut.android.memorygame.toplist.viewmodel.ResultViewModel
import kotlinx.android.synthetic.main.activity_toplist.*

class ToplistActivity : AppCompatActivity() {

    var mode ="easy"
    val resultadapter = RecyclerViewAdapter()

    private lateinit var resultViewModel: ResultViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toplist)


        setupResults()

        resultViewModel = ViewModelProvider(this).get(ResultViewModel::class.java)
        resultViewModel.allResults.observe(this, Observer { results ->
            resultadapter.addAll(results)
        })
    }

    private fun setupResults() {
        rvResult.layoutManager = LinearLayoutManager(this)
        rvResult.adapter = resultadapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toplist_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.itemEasy) {
            mode="easy"
        }
        else if (item.itemId == R.id.itemMedium) {
            mode="medium"
        }
        else if (item.itemId == R.id.itemHard) {
            mode="hard"
        }
            resultViewModel.allResults.observe(this, Observer { results ->
                resultadapter.addByMode(results, mode)
            })





        return super.onOptionsItemSelected(item)
    }

}