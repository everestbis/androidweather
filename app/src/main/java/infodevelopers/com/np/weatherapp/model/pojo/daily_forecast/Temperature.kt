package infodevelopers.com.np.weatherapp.model.pojo.daily_forecast

import com.google.gson.annotations.SerializedName

data class Temperature(

	@field:SerializedName("Minimum")
	val minimum: Minimum? = null,

	@field:SerializedName("Maximum")
	val maximum: Maximum? = null
)