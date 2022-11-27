package hakandindis.skadi.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class ProductResponse(
    @SerializedName("products") var products: ArrayList<Product> = arrayListOf(),
    @SerializedName("total") var total: Int? = null,
    @SerializedName("skip") var skip: Int? = null,
    @SerializedName("limit") var limit: Int? = null
)


@Parcelize
@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "price") var price: Int? = null,
    @ColumnInfo(name = "discount_percentage") var discountPercentage: Double? = null,
    @ColumnInfo(name = "rating") var rating: Double? = null,
    @ColumnInfo(name = "stock") var stock: Int? = null,
    @ColumnInfo(name = "brand") var brand: String? = null,
    @ColumnInfo(name = "category") var category: String? = null,
    @ColumnInfo(name = "thumbnail") var thumbnail: String? = null,
    @Ignore var images: ArrayList<String> = arrayListOf(),
) : Parcelable