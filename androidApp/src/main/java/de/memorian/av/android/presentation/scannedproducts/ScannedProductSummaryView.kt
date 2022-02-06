package de.memorian.av.android.presentation.scannedproducts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import de.memorian.av.domain.model.ScannedProductSummary
import de.memorian.av.util.toDisplayableFormat
import de.memorian.gzg.ui.theme.AppTheme
import kotlinx.datetime.Clock

@Composable
fun ScannedProductSummaryView(
    model: ScannedProductSummary,
    onClickListener: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickListener() },
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .height(128.dp)
        ) {
            Image(
                painter = rememberImagePainter(model.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
                    .padding(end = 8.dp)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(text = model.title, fontWeight = FontWeight.Bold)

                Text(text = model.ean)

                Text(text = model.scannedDate.toDisplayableFormat(), fontStyle = FontStyle.Italic)

                Spacer(modifier = Modifier.weight(1f))

                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.Bold)
                    ) {
                        append(model.bestPrice)
                    }

                    append(" bei ${model.bestPlatform}")
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CashbackRequestViewPreview() {
    AppTheme {
        ScannedProductSummaryView(
            model = ScannedProductSummary(
                databaseId = 0,
                title = "Test Product",
                imageUrl = "https://picsum.photos/200/300",
                ean = "1111111111111",
                scannedDate = Clock.System.now(),
                bestPrice = "24,99€",
                bestPlatform = "A good buyer"
            ),
            onClickListener = {}
        )
    }
}