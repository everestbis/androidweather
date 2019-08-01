package infodevelopers.com.np.weatherapp.model.pojo.topcities

import com.google.gson.annotations.SerializedName

data class CitiesResponse(

	@field:SerializedName("AdministrativeArea")
	val administrativeArea: AdministrativeArea? = null,

	@field:SerializedName("LocalizedName")
	val localizedName: String? = null,

	@field:SerializedName("SupplementalAdminAreas")
	val supplementalAdminAreas: List<Any?>? = null,

	@field:SerializedName("DataSets")
	val dataSets: List<Any?>? = null,

	@field:SerializedName("Rank")
	val rank: Int? = null,

	@field:SerializedName("IsAlias")
	val isAlias: Boolean? = null,

	@field:SerializedName("Type")
	val type: String? = null,

	@field:SerializedName("TimeZone")
	val timeZone: TimeZone? = null,

	@field:SerializedName("Version")
	val version: Int? = null,

	@field:SerializedName("PrimaryPostalCode")
	val primaryPostalCode: String? = null,

	@field:SerializedName("Region")
	val region: Region? = null,

	@field:SerializedName("Country")
	val country: Country? = null,

	@field:SerializedName("GeoPosition")
	val geoPosition: GeoPosition? = null,

	@field:SerializedName("Key")
	val key: String? = null,

	@field:SerializedName("EnglishName")
	val englishName: String? = null
)