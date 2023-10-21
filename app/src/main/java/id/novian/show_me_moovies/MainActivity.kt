package id.novian.show_me_moovies

import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import id.novian.common.base.BaseActivity
import id.novian.show_me_moovies.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var navControllerHome: NavController

    override fun setup() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navControllerHome = navHostFragment.navController
        setBottomNavigationView()

//        navigationListener(navControllerHome)
    }

    private fun setBottomNavigationView() {
        val bottomBar = binding.bottomAppBar

        bottomNavigationView = binding.bottomNavigationView

        setSupportActionBar(bottomBar)
        bottomNavigationView.setupWithNavController(navControllerHome)

    }


}