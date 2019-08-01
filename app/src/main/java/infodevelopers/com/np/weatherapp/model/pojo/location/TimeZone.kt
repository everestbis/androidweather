package infodevelopers.com.np.weatherapp.model.pojo.location

import com.google.gson.annotations.SerializedName

data class TimeZone(

	@field:SerializedName("NextOffsetChange")
	val nextOffsetChange: Any? = null,

	@field:SerializedName("GmtOffset")
	val gmtOffset: Double? = null,

	@field:SerializedName("Code")
	val code: String? = null,

	@field:SerializedName("IsDaylightSaving")
	val isDaylightSaving: Boolean? = null,

	@field:SerializedName("Name")
	val name: String? = null
)