package hakandindis.skadi.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hakandindis.skadi.common.ProductApiUtils
import hakandindis.skadi.data.model.Product
import hakandindis.skadi.data.model.ProductModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {

    private val productService = ProductApiUtils.productService

    val productList = MutableLiveData<List<Product>?>()

    fun getProducts() {
        productService.getProducts().enqueue(object : Callback<ProductModel?> {
            override fun onResponse(call: Call<ProductModel?>, response: Response<ProductModel?>) {
                if (response.body() != null && response.body()!!.products.isNotEmpty()) {
                    productList.value = response.body()?.products
                } else {
                    productList.value = null
                }
            }

            override fun onFailure(call: Call<ProductModel?>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })
    }

    fun searchProducts(query:String) {
        productService.searchProducts(query).enqueue(object : Callback<ProductModel?> {
            override fun onResponse(call: Call<ProductModel?>, response: Response<ProductModel?>) {
                if (response.body() != null && response.body()!!.products.isNotEmpty()) {
                    productList.value = response.body()?.products
                } else {
                    productList.value = null
                }
            }

            override fun onFailure(call: Call<ProductModel?>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }
        })
    }

}