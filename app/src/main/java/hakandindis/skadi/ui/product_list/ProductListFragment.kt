package hakandindis.skadi.ui.product_list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yagmurerdogan.toasticlib.Toastic
import hakandindis.skadi.R
import hakandindis.skadi.common.viewBinding
import hakandindis.skadi.databinding.FragmentProductListBinding

class ProductListFragment : Fragment(R.layout.fragment_product_list) {

    private val binding by viewBinding(FragmentProductListBinding::bind)
    private val viewModel: ProductListViewModel by viewModels()
    private val productsAdapter by lazy { ProductsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
        initViews()
    }

    private fun initObservers() {
        viewModel.productList.observe(viewLifecycleOwner) {
            it?.let { productsAdapter.submitList(it) }
        }
    }

    private fun initViews() {
        binding.productsList.adapter = productsAdapter

        productsAdapter.onProductClick = {
            val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(it)
            findNavController().navigate(action)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchProducts(query)
                }.run {
                    Toastic.toastic(
                        context = requireContext(),
                        message = "Bu isimle eşleşen ürün yok",
                        duration = Toastic.LENGTH_LONG,
                        type = Toastic.INFO,
                        isIconAnimated = true
                    ).show()
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