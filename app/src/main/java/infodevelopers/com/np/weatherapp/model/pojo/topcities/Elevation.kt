package infodevelopers.com.np.weatherapp.model.pojo.topcities

import com.google.gson.annotations.SerializedName

data class Elevation(

	@field:SerializedName("Metric")
	val metric: Metric? = null,

	@field:SerializedName("Imperial")
	val imperial: Imperial? = null
)