package infodevelopers.com.np.weatherapp.model.pojo.search

import com.google.gson.annotations.SerializedName

data class Country(

	@field:SerializedName("LocalizedName")
	val localizedName: String? = null,

	@field:SerializedName("ID")
	val iD: String? = null
)