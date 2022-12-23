package hakandindis.skadi.data.source.remote

import hakandindis.skadi.data.source.common.ProductApiConstants.GET_CATEGORIES
import hakandindis.skadi.data.source.common.ProductApiConstants.GET_PRODUCTS
import hakandindis.skadi.data.source.common.ProductApiConstants.GET_PRODUCTS_BY_CATEGORY
import hakandindis.skadi.data.source.common.ProductApiConstants.GET_SINGLE_PRODUCT
import hakandindis.skadi.data.source.common.ProductApiConstants.SEARCH_PRODUCTS
import hakandindis.skadi.data.model.Product
import hakandindis.skadi.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

    @GET(GET_PRODUCTS)
    suspend fun getProducts(): ProductResponse?

    @GET(GET_SINGLE_PRODUCT)
    suspend fun getSingleProduct(@Path("id") id: Int): Product?

    @GET(SEARCH_PRODUCTS)
    suspend fun searchProducts(@Query("q") query: String): ProductResponse?

    @GET(GET_CATEGORIES)
    suspend fun getCategories(): List<String>?

    @GET(GET_PRODUCTS_BY_CATEGORY)
    suspend fun getProductsByCategory(@Path("category") category: String): ProductResponse?
}