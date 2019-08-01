package infodevelopers.com.np.weatherapp.model.api


import infodevelopers.com.np.weatherapp.model.pojo.current.CurrentResponse
import infodevelopers.com.np.weatherapp.model.pojo.daily_forecast.DailyForecastResponse
import infodevelopers.com.np.weatherapp.model.pojo.forecast.ForecastResponse
import infodevelopers.com.np.weatherapp.model.pojo.location.LocationResponse
import infodevelopers.com.np.weatherapp.model.pojo.search.SuggestionResponse
import infodevelopers.com.np.weatherapp.model.pojo.topcities.CitiesResponse
import kotlinx.coroutines.Deferred

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Response as Response1

interface ApiInterface {

    @GET("currentconditions/v1/{locationId}")
    fun getWeatherData(@Path(value = "locationId") locationId: String, @Query("apikey") apiKey: String): Deferred<Response1<List<CurrentResponse>>>

    @GET("forecasts/v1/hourly/12hour/{locationId}")
    fun getWeatherForecast(@Path(value = "locationId") locationId: String, @Query("apikey") key: String?, @Query("metric") unit: Boolean = true): Deferred<Response1<List<ForecastResponse>>>

    @GET("forecasts/v1/daily/5day/{locationId}")
    fun getDailyForecast(@Path(value = "locationId") locationId: String, @Query("apikey") key: String, @Query("metric") unit: Boolean = true): Deferred<Response1<DailyForecastResponse>>

    @GET("locations/v1/cities/geoposition/search")
    fun getLocationInformation(@Query(value = "apikey") key: String, @Query("q") query: String):Deferred<Response1<LocationResponse>>

    @GET("locations/v1/cities/autocomplete")
    fun getLocationSuggestion(@Query("apikey")apiKey: String,@Query("q") query:String):Deferred<Response1<List<SuggestionResponse>>>

    @GET("locations/v1/topcities/50")
    fun getTopCities(@Query("apikey")apiKey: String):Deferred<Response1<List<CitiesResponse>>>

}