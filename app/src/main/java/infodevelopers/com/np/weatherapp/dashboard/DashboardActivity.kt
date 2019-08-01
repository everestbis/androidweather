package infodevelopers.com.np.weatherapp.dashboard


import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.bottomnavigation.BottomNavigationView
import infodevelopers.com.np.weatherapp.R
import infodevelopers.com.np.weatherapp.common.location_KEY


class DashboardActivity : AppCompatActivity() {
    private val MY_PERMISSIONS_ACCESS_COARSE_LOCATION: Int=2
    private lateinit var nav: NavController
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var sharedPref:SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref=this.getPreferences(Context.MODE_PRIVATE)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        nav = Navigation.findNavController(this, R.id.fragment)


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                MY_PERMISSIONS_ACCESS_COARSE_LOCATION)

        }

       else {
            getLocation()
            //   NavigationUI.setupWithNavController(navView,nav)

        }
        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    nav.navigate(R.id.weatherView, null)
                    // this.toast("navigation home")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    nav.navigate(R.id.weatherForecastView)
                    //     this.toast("navigation dashboard")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                nav.navigate(R.id.loginView)
                    //     this.toast("navigation notification")
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_ACCESS_COARSE_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    getLocation()

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }

    private fun getLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if(location!=null) {
                val latitude = location.latitude
                val longitude = location.longitude
                with(sharedPref.edit()) {

                    putString(location_KEY, "$latitude,$longitude")
                    apply()
                }
            }

        }
    }

}

