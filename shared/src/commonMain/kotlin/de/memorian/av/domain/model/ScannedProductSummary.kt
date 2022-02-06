package de.memorian.av.domain.model

import kotlinx.datetime.Instant

data class ScannedProductSummary(
    val databaseId: Long,
    val title: String,
    val imageUrl: String?,
    val ean: String,
    val scannedDate: Instant,
    val bestPrice: String,
    val bestPlatform: String,
)