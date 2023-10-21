package id.novian.feature.details

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.novian.common.base.BaseFragment
import id.novian.feature.details.databinding.FragmentDetailsBinding

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(
    FragmentDetailsBinding::inflate
) {
    private val viewModel: DetailsViewModel by viewModels()


}