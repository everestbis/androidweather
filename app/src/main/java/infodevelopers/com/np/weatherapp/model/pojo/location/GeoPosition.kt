package infodevelopers.com.np.weatherapp.model.pojo.location

import com.google.gson.annotations.SerializedName

data class GeoPosition(

	@field:SerializedName("Elevation")
	val elevation: Elevation? = null,

	@field:SerializedName("Latitude")
	val latitude: Double? = null,

	@field:SerializedName("Longitude")
	val longitude: Double? = null
)