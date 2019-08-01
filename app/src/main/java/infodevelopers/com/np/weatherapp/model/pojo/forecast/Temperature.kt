package infodevelopers.com.np.weatherapp.model.pojo.forecast

import com.google.gson.annotations.SerializedName

data class Temperature(

	@field:SerializedName("UnitType")
	val unitType: Int? = null,

	@field:SerializedName("Value")
	val value: Double? = null,

	@field:SerializedName("Unit")
	val unit: String? = null
)