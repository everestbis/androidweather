package infodevelopers.com.np.weatherapp.search.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import infodevelopers.com.np.weatherapp.R
import infodevelopers.com.np.weatherapp.common.inflate
import infodevelopers.com.np.weatherapp.model.pojo.topcities.CitiesResponse
import kotlinx.android.synthetic.main.item_top_cities.view.*

class TopCitiesAdapter(private val citiesList: List<CitiesResponse>?) :
    RecyclerView.Adapter<TopCitiesAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var view = v
        fun bindView(cityResponse: CitiesResponse?) {
            view.top_cities_name_tv.text = cityResponse?.englishName

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopCitiesAdapter.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_top_cities, false))
    }

    override fun getItemCount(): Int {
        return citiesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: TopCitiesAdapter.ViewHolder, position: Int) {
        val cityResponse = citiesList?.get(position)
        holder.bindView(cityResponse)
    }

}