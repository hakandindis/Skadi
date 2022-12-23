package hakandindis.skadi.ui.product_list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yagmurerdogan.toasticlib.Toastic
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.skadi.R
import hakandindis.skadi.data.source.common.viewBinding
import hakandindis.skadi.databinding.FragmentProductListBinding

@AndroidEntryPoint
class ProductListFragment : Fragment(R.layout.fragment_product_list) {

    private val binding by viewBinding(FragmentProductListBinding::bind)
    private val productsAdapter by lazy { ProductsAdapter() }
//    private val viewModel: ProductListViewModel by viewModels {
////        ProductListViewModelFactory((activity?.application as SkadiApplication).repository)
//    }
    private val viewModel: ProductListViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        initViews()
    }

    private fun initObservers() {
        viewModel.productList.observe(viewLifecycleOwner) {
            if (it != null) {
                if (it.isNotEmpty()) {
                    productsAdapter.submitList(it)
//                    viewModel.insert(it[1])
                } else {
                    Toastic.toastic(
                        context = requireContext(),
                        message = "Ürün yok",
                        duration = Toastic.LENGTH_LONG,
                        type = Toastic.INFO,
                        isIconAnimated = true
                    ).show()
                }
            }
        }

        viewModel.allWords.observe(viewLifecycleOwner) { list ->
            list.forEach {
                Log.d("HAKANNN", it.toString())
            }
        }
    }

    private fun initViews() {
        binding.productsList.adapter = productsAdapter

        productsAdapter.onProductClick = {
//            viewModel.insert(it)
            val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(it)
            findNavController().navigate(action)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchProducts(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (newText.isEmpty()) {
                        viewModel.getProducts()
                    }
                }
                return false
            }
        })
    }
}