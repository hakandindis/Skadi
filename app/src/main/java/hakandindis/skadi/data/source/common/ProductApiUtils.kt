package hakandindis.skadi.data.source.common

import hakandindis.skadi.data.source.common.ProductApiConstants.BASE_URL
import hakandindis.skadi.data.source.remote.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductApiUtils {
    private val retrofit:Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val productService: ProductService by lazy { retrofit.create(ProductService::class.java) }
}