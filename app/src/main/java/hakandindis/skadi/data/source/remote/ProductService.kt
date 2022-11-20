package hakandindis.skadi.data.source.remote

import hakandindis.skadi.common.ProductApiConstants.GET_CATEGORIES
import hakandindis.skadi.common.ProductApiConstants.GET_PRODUCTS
import hakandindis.skadi.common.ProductApiConstants.GET_PRODUCTS_BY_CATEGORY
import hakandindis.skadi.common.ProductApiConstants.GET_SINGLE_PRODUCT
import hakandindis.skadi.common.ProductApiConstants.SEARCH_PRODUCTS
import hakandindis.skadi.data.model.Product
import hakandindis.skadi.data.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

    @GET(GET_PRODUCTS)
    fun getProducts(): Call<ProductResponse?>

    @GET(GET_SINGLE_PRODUCT)
    fun getSingleProduct(@Path("id") id: Int): Call<Product?>

    @GET(SEARCH_PRODUCTS)
    fun searchProducts(@Query("q") query: String): Call<ProductResponse?>

    @GET(GET_CATEGORIES)
    fun getCategories(): Call<List<String>?>

    @GET(GET_PRODUCTS_BY_CATEGORY)
    fun getProductsByCategory(@Path("category") category: String): Call<ProductResponse?>
}