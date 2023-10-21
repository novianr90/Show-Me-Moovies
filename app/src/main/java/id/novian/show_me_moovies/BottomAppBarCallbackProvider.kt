package id.novian.show_me_moovies

import androidx.core.view.isVisible
import com.google.android.material.bottomappbar.BottomAppBar
import id.novian.common.base.BottomAppBarCallback
import javax.inject.Inject
import javax.inject.Provider

class BottomAppBarCallbackImpl @Inject constructor(
    private val activity: MainActivity
) : BottomAppBarCallback {
    override fun setBottomAppBarVisibility(isVisible: Boolean) {
        activity.findViewById<BottomAppBar>(R.id.bottom_app_bar).isVisible = isVisible
    }

}

class BottomAppBarCallbackProvider @Inject constructor(
    private val impl: BottomAppBarCallbackImpl
) : Provider<BottomAppBarCallback> {
    override fun get(): BottomAppBarCallback {
        return impl
    }
}