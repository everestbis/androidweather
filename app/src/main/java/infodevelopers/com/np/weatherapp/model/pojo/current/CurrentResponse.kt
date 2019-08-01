package infodevelopers.com.np.weatherapp.model.pojo.current

import com.google.gson.annotations.SerializedName

data class CurrentResponse(

	@field:SerializedName("PrecipitationType")
	val precipitationType: Any? = null,

	@field:SerializedName("Temperature")
	val temperature: Temperature? = null,

	@field:SerializedName("HasPrecipitation")
	val hasPrecipitation: Boolean? = null,

	@field:SerializedName("LocalObservationDateTime")
	val localObservationDateTime: String? = null,

	@field:SerializedName("IsDayTime")
	val isDayTime: Boolean? = null,

	@field:SerializedName("WeatherText")
	val weatherText: String? = null,

	@field:SerializedName("EpochTime")
	val epochTime: Int? = null,

	@field:SerializedName("WeatherIcon")
	val weatherIcon: Int? = null,

	@field:SerializedName("Link")
	val link: String? = null,

	@field:SerializedName("MobileLink")
	val mobileLink: String? = null
)