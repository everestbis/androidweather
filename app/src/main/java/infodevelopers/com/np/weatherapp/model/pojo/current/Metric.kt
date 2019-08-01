package infodevelopers.com.np.weatherapp.model.pojo.current

import com.google.gson.annotations.SerializedName

data class Metric(

	@field:SerializedName("UnitType")
	val unitType: Int? = null,

	@field:SerializedName("Value")
	val value: Double? = null,

	@field:SerializedName("Unit")
	val unit: String? = null
)