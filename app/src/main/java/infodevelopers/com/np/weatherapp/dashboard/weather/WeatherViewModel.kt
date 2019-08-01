package infodevelopers.com.np.weatherapp.dashboard.weather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import infodevelopers.com.np.weatherapp.model.pojo.current.CurrentResponse
import infodevelopers.com.np.weatherapp.model.pojo.forecast.ForecastResponse
import infodevelopers.com.np.weatherapp.model.pojo.location.LocationResponse
import infodevelopers.com.np.weatherapp.model.repository.ApiFactory
import infodevelopers.com.np.weatherapp.model.repository.DataRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class WeatherViewModel : ViewModel() {
    var _weather = MutableLiveData<CurrentResponse>()
    var _daily_forecast = MutableLiveData<List<ForecastResponse>>()
    var _location_response = MutableLiveData<LocationResponse>()

    fun getWeather(): LiveData<CurrentResponse> = _weather

    fun getDailyForecast(): LiveData<List<ForecastResponse>> = _daily_forecast

    fun getLocationResponse():LiveData<LocationResponse> = _location_response


    val dataRepository = DataRepository(ApiFactory.apiInterface)

    fun fetchWeather(key: String) {
        viewModelScope.launch {


        }

        fetchForecast(Date())
    }

    fun fetchForecast(date: Date) {
        viewModelScope.launch {

        }
    }

    fun filterForecast(
        date: Date,
        data: List<ForecastResponse>?
    ) {
        var dateFormatter = SimpleDateFormat("YYYY-MM-dd")
        var tenList = data


//        var filterdList = data.list?.filter { listItem ->
//
//            dateFormatter.timeZone = TimeZone.getDefault()
//            var todayDate = dateFormatter.format(date)
//            var parsed = Date(listItem?.dt!!.toLong() * 1000)
//            var parsedDate = dateFormatter.format(parsed)
//            parsedDate.equals(todayDate)
//
//        }
//        Log.d("test", Gson().toJson(filterdList))


        tenList?.filter { it ->
            val dateFormatte = SimpleDateFormat("h aa", Locale.US)
            dateFormatte.timeZone = TimeZone.getDefault()
            val time = dateFormatte.format(Date(it.epochDateTime!!.toLong() * 1000)).toString()
            it.localTime = time
            true
        }
        _daily_forecast.postValue(tenList)
    }

    fun fetchLocationAndWeather(location: String?) {
        location ?: return
        viewModelScope.launch {
            val locationInfo = dataRepository.getLocationInfo(location)
            if(locationInfo!=null) _location_response.postValue(locationInfo)
            val locationKey: String = locationInfo?.key.toString()
            val data = dataRepository.getWeatherData(locationKey)
            if (data != null) {
                _weather.postValue(data)
            }
            val forecastData = dataRepository.getWeatherForecast(locationKey)
            if (data != null) {
                filterForecast(Date(), forecastData)


            }

            Log.d("location", "location response "+Gson().toJson(locationInfo))
        }
    }


}