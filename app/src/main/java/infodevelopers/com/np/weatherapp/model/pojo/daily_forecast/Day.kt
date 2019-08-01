package infodevelopers.com.np.weatherapp.model.pojo.daily_forecast

import com.google.gson.annotations.SerializedName

data class Day(

	@field:SerializedName("IconPhrase")
	val iconPhrase: String? = null,

	@field:SerializedName("Icon")
	val icon: Int? = null
)