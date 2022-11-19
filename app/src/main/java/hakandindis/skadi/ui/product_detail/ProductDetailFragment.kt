package hakandindis.skadi.ui.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import hakandindis.skadi.R
import hakandindis.skadi.common.viewBinding
import hakandindis.skadi.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment(R.layout.fragment_product_detail) {

    private val binding by viewBinding(FragmentProductDetailBinding::bind)
    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            args.product.let {
                titleText.text = it.title
                priceText.text = "${it.price} $"
                Glide.with(productImage)
                    .load(it.thumbnail)
                    .into(productImage)
            }
        }
    }
}