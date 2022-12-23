package hakandindis.skadi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import hakandindis.skadi.data.source.common.AppDatabase
import hakandindis.skadi.data.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class SkadiApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this, applicationScope) }
//    val repository by lazy { ProductRepository(database.productDao()) }
}