package infodevelopers.com.np.weatherapp.dashboard.weather

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.gson.Gson
import infodevelopers.com.np.weatherapp.R
import infodevelopers.com.np.weatherapp.search.SearchActivity
import infodevelopers.com.np.weatherapp.common.location_KEY
import infodevelopers.com.np.weatherapp.common.weatherIcon
import infodevelopers.com.np.weatherapp.dashboard.weather.adapter.ForecastAdapter
import infodevelopers.com.np.weatherapp.model.pojo.current.CurrentResponse
import infodevelopers.com.np.weatherapp.model.pojo.forecast.ForecastResponse
import kotlinx.android.synthetic.main.fragment_weather_view.*


class WeatherView : Fragment() {

    private val TAG = "weather"
    var sharedPreferences: SharedPreferences?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences=activity?.getPreferences(Context.MODE_PRIVATE)
        val location =sharedPreferences?.getString(location_KEY,"27.68745,85.30844")
        Log.d("location","shard prefs: $location")
        fragment_weather_search_city_btn.setOnClickListener {
            val intent= Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }
        val viewModel: WeatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        viewModel.fetchLocationAndWeather(location)

//        viewModel.fetchForecast(Date())

        viewModel.getLocationResponse().observe(this, Observer {
            weather_location_btn.text="${it.englishName}, ${it.country?.englishName?:""}"
        })

        viewModel.getDailyForecast().observe(this, Observer {
            setDailyForecast(it)
        })
        viewModel.getWeather().observe(this, Observer {
            setWeather(it)

            Log.d(TAG, "response:" + Gson().toJson(it))

        })


    }

    private fun setForecastFragment() {
//        val fragment=WeatherForecastView()

    }

    private fun setDailyForecast(t: List<ForecastResponse>) {
        val forecastAdapter = ForecastAdapter(t)
        weather_forecast_rv.adapter = forecastAdapter
    }

    private fun setWeather(t: CurrentResponse?) {
        val current = t?.temperature
//        val location = t?.coord
        weather_current_tv.text = getString(R.string.weather_degree, current?.metric?.value)
//        val icon="http://"+t?.current?.condition?.icon?.removeRange(0,2)
//        val icon = t?.weather?.get(0)?.icon
//        Glide.with(this).load(iconHashmap.get(icon)).override(100,100).into(weather_icon)
        weather_current_condition_tv.text = t?.weatherText
        Glide.with(this).load(weatherIcon.get(t?.weatherIcon)).into(weather_icon)
//        Log.d(TAG,"response icon:" +icon)
//        weather_location_btn.text = t?.name

    }
}