package id.novian.show_me_moovies

import android.view.LayoutInflater
import dagger.hilt.android.AndroidEntryPoint
import id.novian.common.base.BaseActivity
import id.novian.show_me_moovies.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}