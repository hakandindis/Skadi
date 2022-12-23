package hakandindis.skadi.data

import androidx.annotation.WorkerThread
import hakandindis.skadi.data.source.common.ProductApiUtils
import hakandindis.skadi.data.model.Product
import hakandindis.skadi.data.source.locale.ProductDao
import hakandindis.skadi.data.source.remote.ProductService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService) {


//    fun getLocaleProducts(): Flow<List<Product>> {
//        return productDao.getProducts()
//    }

//    @Suppress("RedundantSuspendModifier")
//    @WorkerThread
//    suspend fun insert(product: Product) {
//        productDao.insert(product)
//    }

    suspend fun getProducts() = productService.getProducts()

    suspend fun searchProducts(query: String) = productService.searchProducts(query)

    suspend fun getProductsByCategory(query: String) = productService.getProductsByCategory(query)

}