package infodevelopers.com.np.weatherapp.model.repository

import infodevelopers.com.np.weatherapp.common.api_key
import infodevelopers.com.np.weatherapp.model.api.ApiInterface
import infodevelopers.com.np.weatherapp.model.pojo.current.CurrentResponse
import infodevelopers.com.np.weatherapp.model.pojo.daily_forecast.DailyForecastResponse
import infodevelopers.com.np.weatherapp.model.pojo.forecast.ForecastResponse
import infodevelopers.com.np.weatherapp.model.pojo.location.LocationResponse
import infodevelopers.com.np.weatherapp.model.pojo.search.SuggestionResponse
import infodevelopers.com.np.weatherapp.model.pojo.topcities.CitiesResponse

class DataRepository(private val weatherApi:ApiInterface): BaseRepository() {

    suspend fun getLocationInfo(queryLocation:String):LocationResponse?{

        return safeApiCall(
            call = {weatherApi.getLocationInformation(query= queryLocation, key = api_key).await()},
            error ="Error getting location"
        )


    }

    suspend fun getLocationSuggestion(queryLocation: String):List<SuggestionResponse>?{

        return safeApiCall(
            call = {weatherApi.getLocationSuggestion(apiKey = api_key,query = queryLocation).await()},
            error = "Can't get suggestion")

    }
 suspend fun  getWeatherData(key: String): CurrentResponse?{


         return safeApiCall(
             //await the result of deferred type
             call = {weatherApi.getWeatherData(key, api_key).await()},
             error = "Error getting weather"
         )?.first()

     }

    suspend fun getWeatherForecast(locationKey:String): List<ForecastResponse>?{
        return safeApiCall(
            call ={weatherApi.getWeatherForecast(key = api_key,locationId = locationKey).await()},
            error ="Error getting forecast"
        )
    }

    suspend fun getDailyForecast():DailyForecastResponse?{
        return safeApiCall(
            call ={weatherApi.getDailyForecast(locationId ="241809",key = api_key).await()},
            error = "Error getting daily forecast"
        )
    }

    suspend fun getTopCities():List<CitiesResponse>?{
        return safeApiCall(
            call = {weatherApi.getTopCities(api_key).await()},
            error = "error getting cities"
        )
    }


}
