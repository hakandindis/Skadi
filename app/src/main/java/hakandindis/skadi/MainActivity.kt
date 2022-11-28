package hakandindis.skadi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import hakandindis.skadi.databinding.ActivityMainBinding
import hakandindis.skadi.ui.product_list.ProductListViewModel
import hakandindis.skadi.ui.product_list.ProductListViewModelFactory


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}