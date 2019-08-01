package infodevelopers.com.np.weatherapp.dashboard.daily_forecast.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import infodevelopers.com.np.weatherapp.R
import infodevelopers.com.np.weatherapp.common.inflate
import infodevelopers.com.np.weatherapp.common.weatherIcon
import infodevelopers.com.np.weatherapp.model.pojo.daily_forecast.DailyForecastsItem
import kotlinx.android.synthetic.main.item_daily_forecast.view.*
import kotlinx.android.synthetic.main.item_hourly_forecast.view.*

class DailyForecastAdapter(private val forecastList: List<DailyForecastsItem?>?) :
    RecyclerView.Adapter<DailyForecastAdapter.ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(parent.inflate(R.layout.item_daily_forecast, false))

    }

    override fun getItemCount(): Int {
           return forecastList!!.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item=forecastList!!.get(position)
        holder.bindView(item)
    }


    class ForecastViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {

        private var item: DailyForecastsItem? = null
        fun bindView(item: DailyForecastsItem?) {
            this.item = item
            v.daily_forecast_min_max_tv.text=v.context.getString(R.string.forecast_weather_degree,item?.temperature?.minimum?.value,item?.temperature?.maximum?.value);
//            v.daily_forecast_temperature_tv.text=item?.day?.iconPhrase
            v.daily_forecast_day_tv.text=item?.time
            Glide.with(v).load(weatherIcon.get(item?.day?.icon)).into(v.daily_forecast_icon_iv)

        }
    }

}
