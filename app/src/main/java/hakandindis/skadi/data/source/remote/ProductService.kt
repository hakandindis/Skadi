package hakandindis.skadi.data.source.remote

import hakandindis.skadi.common.ProductApiConstants.PRODUCTS
import hakandindis.skadi.common.ProductApiUtils
import hakandindis.skadi.data.model.Product
import retrofit2.http.GET

interface ProductService {

    @GET(PRODUCTS)
    fun getAllProducts(): List<Product>
}