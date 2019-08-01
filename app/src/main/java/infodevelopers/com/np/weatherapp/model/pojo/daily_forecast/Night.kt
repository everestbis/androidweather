package infodevelopers.com.np.weatherapp.model.pojo.daily_forecast

import com.google.gson.annotations.SerializedName

data class Night(

	@field:SerializedName("IconPhrase")
	val iconPhrase: String? = null,

	@field:SerializedName("Icon")
	val icon: Int? = null
)