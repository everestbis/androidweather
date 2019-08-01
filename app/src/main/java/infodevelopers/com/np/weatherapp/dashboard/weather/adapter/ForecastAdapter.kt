package infodevelopers.com.np.weatherapp.dashboard.weather.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import infodevelopers.com.np.weatherapp.R
import infodevelopers.com.np.weatherapp.common.inflate
import infodevelopers.com.np.weatherapp.common.weatherIcon
import infodevelopers.com.np.weatherapp.model.pojo.forecast.ForecastResponse
import kotlinx.android.synthetic.main.item_hourly_forecast.view.*

class ForecastAdapter(private val forecastList: List<ForecastResponse>) :
    RecyclerView.Adapter<ForecastAdapter.ForecastHolder>() {
//    private val forecastList:List<ListItem>

//    init {
//        this.forecastList = forecastList
//    }

    class ForecastHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        private var item: ForecastResponse? = null
        fun bindForecast(listItem: ForecastResponse) {
            this.item = listItem
//            Glide.with(view.context).load()
//            val icon = listItem?.weather?.get(0)?.icon
//            val icon_url="http://openweathermap.org/img/w/$icon.png"

            Glide.with(view.context).load(weatherIcon.get(listItem.weatherIcon)).override(64,64).into(view.daily_forecast_iv)

            view.daily_forecast_time_tv.text = item?.localTime
            view.daily_forecast_temp.text = view.context.getString(R.string.weather_degree,item?.temperature?.value)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ForecastHolder {
        val inflatedView = parent.inflate(R.layout.item_hourly_forecast, false)
        return ForecastHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ForecastHolder, position: Int) {
        val listItem = forecastList[position]
        holder.bindForecast(listItem)

    }


}