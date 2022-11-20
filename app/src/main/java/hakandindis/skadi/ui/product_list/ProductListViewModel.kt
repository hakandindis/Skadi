package hakandindis.skadi.ui.product_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hakandindis.skadi.data.ProductRepository
import hakandindis.skadi.data.model.Product

class ProductListViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    private var _productList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?>
        get() = _productList

    init {
        getProducts()
    }

    fun getProducts() {
        productRepository.getProducts()
        _productList = productRepository.productList
    }

    fun searchProducts(query: String) {
        productRepository.searchProducts(query)
        _productList = productRepository.productList
    }

    fun getProductsByCategory(category: String) {
        productRepository.getProductsByCategory(category)
        _productList = productRepository.productList
    }
}