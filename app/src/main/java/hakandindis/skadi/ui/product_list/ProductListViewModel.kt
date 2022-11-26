package hakandindis.skadi.ui.product_list

import android.util.Log
import androidx.lifecycle.*
import hakandindis.skadi.data.ProductRepository
import hakandindis.skadi.data.model.Product
import kotlinx.coroutines.launch

class ProductListViewModel(private val productRepository: ProductRepository) : ViewModel() {


    private var _allWords = MutableLiveData<List<Product>>()
    val allWords: LiveData<List<Product>>
        get() = _allWords

    private var _productList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?>
        get() = _productList

    init {
        getProducts()
        _allWords = productRepository.getLocaleProducts().asLiveData() as MutableLiveData<List<Product>>
    }

    fun insert(product: Product) = viewModelScope.launch { productRepository.insert(product) }

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

class ProductListViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}