package id.novian.feature.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.facebook.shimmer.Shimmer
import dagger.hilt.android.AndroidEntryPoint
import id.novian.common.base.BaseFragment
import id.novian.common.base.DataState
import id.novian.feature.home.adapter.discover.DiscoverAdapter
import id.novian.feature.home.adapter.popular.PopularAdapter
import id.novian.feature.home.databinding.FragmentHomeBinding
import koleton.api.hideSkeleton
import koleton.api.loadSkeleton
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    private val viewModel: HomeViewModel by viewModels<HomeViewModel>()

    private lateinit var discoverAdapter: DiscoverAdapter
    private lateinit var popularAdapter: PopularAdapter

    private lateinit var discoverRv: RecyclerView
    private lateinit var popularRv: RecyclerView

    private val customShimmer = Shimmer.AlphaHighlightBuilder()
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .build()

    override fun setup() {
        setRecyclerView()

        viewModel.test()
        observeData()
    }

    private fun setRecyclerView() {
        popularRv = binding.rvPopularPagination
        discoverRv = binding.rvDiscover
        popularAdapter = PopularAdapter(::onClickNavigateById)
        discoverAdapter = DiscoverAdapter(::onClickNavigateById)

        binding.rvPopularPagination.apply {
            adapter = popularAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.rvDiscover.apply {
            adapter = discoverAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.popularState.collectLatest { state ->
                when (state) {
                    is DataState.Loading -> {
                        popularRv.loadSkeleton(R.layout.item_popular) {
                            shimmer(customShimmer)
                        }
                    }

                    is DataState.Failure -> { /* Handle Later */
                    }

                    is DataState.Success -> {
                        popularRv.hideSkeleton()
                        state.data?.let { popularAdapter.submitData(it) }
                    }

                    is DataState.Empty -> { /* Handle Later */
                    }
                }
            }

            viewModel.discoverState.collectLatest { state ->
                when (state) {
                    is DataState.Loading -> {
                        discoverRv.loadSkeleton(R.layout.item_popular) {
                            shimmer(customShimmer)
                        }
                    }

                    is DataState.Failure -> { /* Handle Later */
                    }

                    is DataState.Success -> {
                        discoverRv.hideSkeleton()
                        discoverAdapter.submitList(state.data)
                    }

                    is DataState.Empty -> { /* Handle Later */
                    }
                }
            }

            viewModel.getPopular().collectLatest {
                Log.i("pop", "data is ${it.map { data -> data }}")
            }
        }
    }

    private fun onClickNavigateById(id: Int) {

    }
}