package infodevelopers.com.np.weatherapp.dashboard.daily_forecast

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import infodevelopers.com.np.weatherapp.R
import infodevelopers.com.np.weatherapp.dashboard.daily_forecast.adapter.DailyForecastAdapter
import infodevelopers.com.np.weatherapp.dashboard.weather.WeatherViewModel
import infodevelopers.com.np.weatherapp.model.pojo.daily_forecast.DailyForecastResponse
import kotlinx.android.synthetic.main.fragment_weather_forecast.*

class WeatherForecastView: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather_forecast,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: DailyForecastViewModel = ViewModelProviders.of(this).get(DailyForecastViewModel::class.java)
        viewModel.fetchDailyForecast()
        viewModel.getDailyForecast().observe(this, Observer {
            setDailyForecastAdapter(it)
        })

    }

    private fun setDailyForecastAdapter(it: DailyForecastResponse) {
        val weatherAdapter=DailyForecastAdapter(it.dailyForecasts)
        daily_forecast_rv.adapter=weatherAdapter

    }

}