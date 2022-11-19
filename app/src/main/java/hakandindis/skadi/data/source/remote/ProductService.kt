package hakandindis.skadi.data.source.remote

import hakandindis.skadi.common.ProductApiConstants.PRODUCTS
import hakandindis.skadi.data.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET(PRODUCTS)
    fun getProducts(): Call<ProductModel?>

//    @GET("")
//    fun getFilteredProducts(): Call<List<Product>>
//
//    @GET("")
//    fun getSingleProduct(): Call<Product>
}