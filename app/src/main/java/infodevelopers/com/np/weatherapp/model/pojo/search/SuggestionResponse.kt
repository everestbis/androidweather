package infodevelopers.com.np.weatherapp.model.pojo.search

import com.google.gson.annotations.SerializedName

data class SuggestionResponse(

	@field:SerializedName("AdministrativeArea")
	val administrativeArea: AdministrativeArea? = null,

	@field:SerializedName("Type")
	val type: String? = null,

	@field:SerializedName("Version")
	val version: Int? = null,

	@field:SerializedName("LocalizedName")
	val localizedName: String? = null,

	@field:SerializedName("Country")
	val country: Country? = null,

	@field:SerializedName("Rank")
	val rank: Int? = null,

	@field:SerializedName("Key")
	val key: String? = null
)