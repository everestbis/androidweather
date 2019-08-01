package infodevelopers.com.np.weatherapp.model.pojo.daily_forecast

import com.google.gson.annotations.SerializedName

data class Minimum(

	@field:SerializedName("UnitType")
	val unitType: Int? = null,

	@field:SerializedName("Value")
	val value: Double? = null,

	@field:SerializedName("Unit")
	val unit: String? = null
)