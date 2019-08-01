package infodevelopers.com.np.weatherapp.dashboard.daily_forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import infodevelopers.com.np.weatherapp.model.pojo.daily_forecast.DailyForecastResponse
import infodevelopers.com.np.weatherapp.model.repository.ApiFactory
import infodevelopers.com.np.weatherapp.model.repository.DataRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class DailyForecastViewModel : ViewModel() {
    var _dailyForecast = MutableLiveData<DailyForecastResponse>()

    fun getDailyForecast(): LiveData<DailyForecastResponse> = _dailyForecast
    val dataRepository = DataRepository(ApiFactory.apiInterface)

    fun fetchDailyForecast() {

        viewModelScope.launch {


            val data = dataRepository.getDailyForecast()
            if (data != null) {
                val filtereddata = filterData(data)
                _dailyForecast.postValue(filtereddata)
            }
        }
    }

    private fun filterData(data: DailyForecastResponse): DailyForecastResponse {

        //adding day name to pojo

        val dateFormatte = SimpleDateFormat("EEEE", Locale.US)
        dateFormatte.timeZone = TimeZone.getDefault()

        val temList = data.dailyForecasts?.filter {
            val time = dateFormatte.format(Date(it?.epochDate!!.toLong() * 1000)).toString()
            it.time = time
            true
        }
        val tempdata: DailyForecastResponse = DailyForecastResponse(data.headline, temList)
        return tempdata

    }

}


