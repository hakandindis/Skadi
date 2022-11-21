package hakandindis.skadi.data

import hakandindis.skadi.common.ProductApiUtils

class ProductRepository {

    private val productService = ProductApiUtils.productService

    suspend fun getProducts() = productService.getProducts()

    suspend fun searchProducts(query: String) = productService.searchProducts(query)

    suspend fun getProductsByCategory(query: String) = productService.getProductsByCategory(query)

}