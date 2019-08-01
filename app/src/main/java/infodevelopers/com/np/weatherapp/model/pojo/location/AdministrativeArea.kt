package infodevelopers.com.np.weatherapp.model.pojo.location

import com.google.gson.annotations.SerializedName

data class AdministrativeArea(

	@field:SerializedName("CountryID")
	val countryID: String? = null,

	@field:SerializedName("LocalizedType")
	val localizedType: String? = null,

	@field:SerializedName("LocalizedName")
	val localizedName: String? = null,

	@field:SerializedName("Level")
	val level: Int? = null,

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("EnglishType")
	val englishType: String? = null,

	@field:SerializedName("EnglishName")
	val englishName: String? = null
)