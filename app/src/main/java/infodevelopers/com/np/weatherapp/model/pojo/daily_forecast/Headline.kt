package infodevelopers.com.np.weatherapp.model.pojo.daily_forecast

import com.google.gson.annotations.SerializedName

data class Headline(

	@field:SerializedName("Category")
	val category: String? = null,

	@field:SerializedName("EndEpochDate")
	val endEpochDate: Int? = null,

	@field:SerializedName("EffectiveEpochDate")
	val effectiveEpochDate: Int? = null,

	@field:SerializedName("Severity")
	val severity: Int? = null,

	@field:SerializedName("Text")
	val text: String? = null,

	@field:SerializedName("EndDate")
	val endDate: String? = null,

	@field:SerializedName("Link")
	val link: String? = null,

	@field:SerializedName("EffectiveDate")
	val effectiveDate: String? = null,

	@field:SerializedName("MobileLink")
	val mobileLink: String? = null
)