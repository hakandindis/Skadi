package hakandindis.skadi.ui.product_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yagmurerdogan.toasticlib.Toastic
import hakandindis.skadi.common.ProductApiUtils
import hakandindis.skadi.data.model.ProductModel
import hakandindis.skadi.databinding.FragmentProductListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListFragment : Fragment() {

    private var binding: FragmentProductListBinding? = null
    private val productsAdapter by lazy { ProductsAdapter() }
    private val productService = ProductApiUtils.productService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        productsAdapter.onProductClick = {
            val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailFragment(it)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initViews() {

        productService.getProducts().enqueue(object : Callback<ProductModel?> {
            override fun onResponse(call: Call<ProductModel?>, response: Response<ProductModel?>) {
                response.body().let {
                    productsAdapter.submitList(it?.products)
                    binding?.productsList?.adapter = productsAdapter
                }
            }

            override fun onFailure(call: Call<ProductModel?>, t: Throwable) {
                Log.d("HAKAN07", "ONFAILURE" + t.message.toString())
                Toastic.toastic(
                    context = context!!,
                    message = "No products",
                    duration = Toastic.LENGTH_LONG,
                    type = Toastic.INFO,
                    isIconAnimated = true
                )
            }
        })
    }
}