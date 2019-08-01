package infodevelopers.com.np.weatherapp.model.pojo.daily_forecast

import com.google.gson.annotations.SerializedName

data class DailyForecastsItem(

	@field:SerializedName("Temperature")
	val temperature: Temperature? = null,

	@field:SerializedName("Night")
	val night: Night? = null,

	@field:SerializedName("EpochDate")
	val epochDate: Int? = null,

	@field:SerializedName("Day")
	val day: Day? = null,

	@field:SerializedName("Sources")
	val sources: List<String?>? = null,

	@field:SerializedName("Date")
	val date: String? = null,

	@field:SerializedName("Link")
	val link: String? = null,

	@field:SerializedName("MobileLink")
	val mobileLink: String? = null,

	var time:String
)