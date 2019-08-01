package infodevelopers.com.np.weatherapp.model.pojo.forecast

import com.google.gson.annotations.SerializedName

data class ForecastResponse(

	@field:SerializedName("Temperature")
	val temperature: Temperature? = null,

	@field:SerializedName("PrecipitationProbability")
	val precipitationProbability: Int? = null,

	@field:SerializedName("EpochDateTime")
	val epochDateTime: Int? = null,

	@field:SerializedName("IconPhrase")
	val iconPhrase: String? = null,

	@field:SerializedName("IsDaylight")
	val isDaylight: Boolean? = null,

	@field:SerializedName("DateTime")
	val dateTime: String? = null,

	@field:SerializedName("WeatherIcon")
	val weatherIcon: Int? = null,

	@field:SerializedName("Link")
	val link: String? = null,

	@field:SerializedName("MobileLink")
	val mobileLink: String? = null,

var localTime:String?=null //extra variable for storing time
)