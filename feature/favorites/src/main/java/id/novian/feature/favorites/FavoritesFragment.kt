package id.novian.feature.favorites

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.novian.common.base.BaseFragment
import id.novian.feature.favorites.databinding.FragmentFavoritesBinding

@AndroidEntryPoint
class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>(
    FragmentFavoritesBinding::inflate
) {
    private val viewModel: FavoritesViewModel by viewModels()

}