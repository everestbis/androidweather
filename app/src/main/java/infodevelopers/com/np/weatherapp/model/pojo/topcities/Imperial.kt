package infodevelopers.com.np.weatherapp.model.pojo.topcities

import com.google.gson.annotations.SerializedName

data class Imperial(

	@field:SerializedName("UnitType")
	val unitType: Int? = null,

	@field:SerializedName("Value")
	val value: Int? = null,

	@field:SerializedName("Unit")
	val unit: String? = null
)