package de.memorian.av.android.presentation.scannedproducts

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import de.memorian.av.domain.model.ScannedProductSummary
import kotlinx.datetime.Clock

class ScannedProductsPreviewParameterProvider :
    PreviewParameterProvider<List<ScannedProductSummary>> {

    override val values: Sequence<List<ScannedProductSummary>>
        get() = sequenceOf(
            listOf(
                ScannedProductSummary(
                    databaseId = 0,
                    title = "Test Product",
                    imageUrl = "https://picsum.photos/200/300",
                    ean = "1111111111111",
                    scannedDate = Clock.System.now(),
                    bestPrice = "24,99€",
                    bestPlatform = "A good buyer"
                ),
                ScannedProductSummary(
                    databaseId = 0,
                    title = "Test Product",
                    imageUrl = "https://picsum.photos/200/300",
                    ean = "1111111111111",
                    scannedDate = Clock.System.now(),
                    bestPrice = "24,99€",
                    bestPlatform = "A good buyer"
                ),
                ScannedProductSummary(
                    databaseId = 0,
                    title = "Test Product",
                    imageUrl = "https://picsum.photos/200/300",
                    ean = "1111111111111",
                    scannedDate = Clock.System.now(),
                    bestPrice = "24,99€",
                    bestPlatform = "A good buyer"
                ),
            )
        )
}