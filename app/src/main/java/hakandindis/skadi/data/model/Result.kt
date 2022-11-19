package hakandindis.skadi.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class ProductModel(
    @SerializedName("products") var products: ArrayList<Product> = arrayListOf(),
    @SerializedName("total") var total: Int? = null,
    @SerializedName("skip") var skip: Int? = null,
    @SerializedName("limit") var limit: Int? = null
)

@Parcelize
data class Product(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("discountPercentage") var discountPercentage: Double? = null,
    @SerializedName("rating") var rating: Double? = null,
    @SerializedName("stock") var stock: Int? = null,
    @SerializedName("brand") var brand: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("images") var images: ArrayList<String> = arrayListOf()
) : Parcelable