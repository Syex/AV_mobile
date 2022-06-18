package de.memorian.av.android.presentation.scannedproducts

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import de.memorian.av.domain.model.ScannedProductSummary
import de.memorian.av.presentation.scannedproducts.ScannedProductsMock

class ScannedProductsPreviewParameterProvider :
    PreviewParameterProvider<List<ScannedProductSummary>> {

    override val values: Sequence<List<ScannedProductSummary>>
        get() = sequenceOf(
            ScannedProductsMock().scannedProducts
        )
}