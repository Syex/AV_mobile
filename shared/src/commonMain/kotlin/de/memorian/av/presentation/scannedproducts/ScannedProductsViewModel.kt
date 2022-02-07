package de.memorian.av.presentation.scannedproducts

import de.memorian.av.Navigator
import de.memorian.av.domain.model.ScannedProductSummary
import de.memorian.av.presentation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScannedProductsViewModel(
    private val navigator: Navigator,
) : BaseViewModel() {

    private val _stateFlow = MutableStateFlow(
        ScannedProductsState(
            scannedProducts = emptyList()
        )
    )
    val stateFlow: StateFlow<ScannedProductsState> = _stateFlow.asStateFlow()

    fun onScannedProductClicked(scannedProduct: ScannedProductSummary) {
    }
}

data class ScannedProductsState(
    val scannedProducts: List<ScannedProductSummary>,
)