package infodevelopers.com.np.weatherapp.model.pojo.current

import com.google.gson.annotations.SerializedName

data class Temperature(

	@field:SerializedName("Metric")
	val metric: Metric? = null,

	@field:SerializedName("Imperial")
	val imperial: Imperial? = null
)