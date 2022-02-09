package de.memorian.av.presentation.scannedproducts

import de.memorian.av.Navigator
import de.memorian.av.domain.model.ScannedProductSummary
import de.memorian.av.presentation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.datetime.Clock

class ScannedProductsViewModel(
    private val navigator: Navigator,
) : BaseViewModel() {

    private val _stateFlow = MutableStateFlow(
        ScannedProductsState(
            scannedProducts = listOf(
                ScannedProductSummary(
                    databaseId = 0,
                    title = "Super Mario Odyssey",
                    imageUrl = "https://m.media-amazon.com/images/I/91t3mH6psYL._SL1500_.jpg",
                    ean = "0045496420871",
                    scannedDate = Clock.System.now(),
                    bestPrice = "32,30€",
                    bestPlatform = "Ankäufer"
                ),
                ScannedProductSummary(
                    databaseId = 0,
                    title = "Star Wars: Der Aufstieg Skywalkers Blu-ray",
                    imageUrl = "https://assets.mmsrg.com/isr/166325/c1/-/ASSET_MMS_72974753/fee_786_587_png",
                    ean = "8717418564391",
                    scannedDate = Clock.System.now(),
                    bestPrice = "2,60€",
                    bestPlatform = "Ankäufer"
                ),
                ScannedProductSummary(
                    databaseId = 0,
                    title = "Harry Potter und die Heiligtümer des Todes (Band 7)",
                    imageUrl = "https://images-na.ssl-images-amazon.com/images/I/51L3ygSkwrL._SX357_BO1,204,203,200_.jpg",
                    ean = "9783551577771",
                    scannedDate = Clock.System.now(),
                    bestPrice = "7,30€",
                    bestPlatform = "Ankäufer"
                ),
                ScannedProductSummary(
                    databaseId = 0,
                    title = "FIFA 22 - [PlayStation 5]",
                    imageUrl = "https://assets.mmsrg.com/isr/166325/c1/-/ASSET_MMS_86521422/fee_786_587_png",
                    ean = "5030948123856",
                    scannedDate = Clock.System.now(),
                    bestPrice = "15,00€",
                    bestPlatform = "Ankäufer"
                ),
            )
        )
    )
    val stateFlow: StateFlow<ScannedProductsState> = _stateFlow.asStateFlow()

    fun onScannedProductClicked(scannedProduct: ScannedProductSummary) {
    }
}

data class ScannedProductsState(
    val scannedProducts: List<ScannedProductSummary>,
)