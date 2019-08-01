package infodevelopers.com.np.weatherapp.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import infodevelopers.com.np.weatherapp.R
import infodevelopers.com.np.weatherapp.model.pojo.topcities.CitiesResponse
import infodevelopers.com.np.weatherapp.search.adapter.TopCitiesAdapter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
//        setSupportActionBar(toolbar)
        val viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        viewModel.fetchCities()
        viewModel.getTopCities().observe(this, Observer {
            setTopCitiesAdapter(it)


        })

        suggestion_autocomplete_tv.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
//               viewModel.fetchSuggestion(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        viewModel.getSuggest().observe(this, Observer {
            Log.d("response", Gson().toJson(it))
        })
    }

    private fun setTopCitiesAdapter(it: List<CitiesResponse>?) {
        val citiesAdapter = TopCitiesAdapter(it)
        search_cities_rv.layoutManager=GridLayoutManager(this,4)
        search_cities_rv.adapter=citiesAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
//        (menu!!.findItem(R.id.search).actionView as SearchView).apply {
//            setSearchableInfo(searchManager.getSearchableInfo(componentName))
//        }

        return super.onCreateOptionsMenu(menu)
    }

}
