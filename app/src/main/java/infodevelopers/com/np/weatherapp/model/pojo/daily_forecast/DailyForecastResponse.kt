package infodevelopers.com.np.weatherapp.model.pojo.daily_forecast

import com.google.gson.annotations.SerializedName

data class DailyForecastResponse(

	@field:SerializedName("Headline")
	val headline: Headline? = null,

	@field:SerializedName("DailyForecasts")
	val dailyForecasts: List<DailyForecastsItem?>? = null
)