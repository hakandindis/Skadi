package hakandindis.skadi.ui.product_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hakandindis.skadi.data.ProductRepository
import hakandindis.skadi.data.model.Product
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    private var _productList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?>
        get() = _productList

    init {
        getProducts()
    }

    fun getProducts() = viewModelScope.launch {
        try {
            _productList.value = productRepository.getProducts()?.products
        } catch (e: Exception) {
            Log.d("Failure", "Empty list")
        }
    }

    fun searchProducts(query: String) = viewModelScope.launch {
        try {
            _productList.value = productRepository.searchProducts(query)?.products
        } catch (e: Exception) {
            Log.d("Failure", "Empty list")
        }
    }

    fun getProductsByCategory(query: String) = viewModelScope.launch {
        try {
            _productList.value = productRepository.searchProducts(query)?.products
        } catch (e: Exception) {
            Log.d("Failure", "Empty list")
        }
    }
}