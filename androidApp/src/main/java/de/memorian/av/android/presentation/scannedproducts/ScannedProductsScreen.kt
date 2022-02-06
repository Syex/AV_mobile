package de.memorian.av.android.presentation.scannedproducts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import de.memorian.av.domain.model.ScannedProductSummary
import de.memorian.av.presentation.scannedproducts.ScannedProductsState
import de.memorian.gzg.ui.theme.AppTheme

@Composable
fun ScannedProductsScreen(
    _screenState: State<ScannedProductsState>,
    onScannedProductClicked: (ScannedProductSummary) -> Unit,
) {
    val screenState by _screenState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        for (scannedProduct in screenState.scannedProducts) {
            ScannedProductSummaryView(model = scannedProduct) {
                onScannedProductClicked(scannedProduct)
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
fun DefaultPreview(
    @PreviewParameter(ScannedProductsPreviewParameterProvider::class)
    scannedProducts: List<ScannedProductSummary>,
) {
    AppTheme {
        ScannedProductsScreen(
            _screenState = object : State<ScannedProductsState> {
                override val value: ScannedProductsState
                    get() = ScannedProductsState(
                        scannedProducts = scannedProducts
                    )
            },
            onScannedProductClicked = {}
        )
    }
}