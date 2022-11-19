package hakandindis.skadi.ui.product_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hakandindis.skadi.data.model.Product
import hakandindis.skadi.databinding.ProductListItemBinding

class ProductsAdapter : ListAdapter<Product, ProductViewHolder>(ProductDiffUtilCallback) {

    var onProductClick: (Product) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding, onProductClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) = holder.bind(currentList[position])
}

class ProductViewHolder(private val binding: ProductListItemBinding, private val onProductClick: (Product) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product) {
        with(binding) {
            titleText.text = product.title
            priceText.text = product.price.toString()
            Glide.with(productImage).load(product.thumbnail).into(productImage)

            root.setOnClickListener { onProductClick(product) }
        }
    }
}

object ProductDiffUtilCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean = oldItem == newItem
}