package infodevelopers.com.np.weatherapp.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import infodevelopers.com.np.weatherapp.model.pojo.search.SuggestionResponse
import infodevelopers.com.np.weatherapp.model.pojo.topcities.CitiesResponse
import infodevelopers.com.np.weatherapp.model.repository.ApiFactory
import infodevelopers.com.np.weatherapp.model.repository.DataRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(){

private var locationSuggestion= MutableLiveData<List<SuggestionResponse>>()

    val suggestion:LiveData<List<SuggestionResponse>> = locationSuggestion


    fun getSuggest() = suggestion


    private var topCities= MutableLiveData<List<CitiesResponse>>()

    val cities:LiveData<List<CitiesResponse>> = topCities


    fun getTopCities() = cities


    val dataRepository=DataRepository(ApiFactory.apiInterface)

    fun fetchSuggestion(query:String) {
        viewModelScope.launch {
            val locResponse=dataRepository.getLocationSuggestion(query)
            if(locResponse!=null){
                locationSuggestion.postValue(locResponse)
            }
        }

    }

    fun fetchCities(){
        viewModelScope.launch {
            val citResponse=dataRepository.getTopCities()
            if(citResponse!=null) topCities.postValue(citResponse)
        }
    }

}