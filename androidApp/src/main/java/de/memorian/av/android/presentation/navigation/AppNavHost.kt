package de.memorian.av.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.memorian.av.Navigator
import de.memorian.av.Navigator.NavTarget
import de.memorian.av.android.presentation.scannedproducts.ScannedProductsScreen
import de.memorian.av.presentation.scannedproducts.ScannedProductsViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavHost(navController: NavHostController, navigator: Navigator) {
    LaunchedEffect("navigation") {
        navigator.sharedFlow.onEach {
            if (NavTarget.Back.label == it) {
                navController.popBackStack()
            } else {
                navController.navigate(it)
            }
        }.launchIn(this)
    }

    NavHost(navController = navController, startDestination = NavTarget.ScannedProducts.label) {
        composable(NavTarget.ScannedProducts.label) {
            val viewModel = getViewModel<ScannedProductsViewModel>()
            ScannedProductsScreen(
                viewModel.stateFlow.collectAsState(),
                viewModel::onScannedProductClicked,
            )
        }
        composable(
            NavTarget.Settings.label,
        ) {
//            val viewModel = viewModel<AddCashbackRequestViewModel>(
//                factory = AddCashbackRequestViewModelFactory(campaignUrl, cashbackRequestIdToEdit)
//            )
//            AddCashbackRequestScreen(
//                viewModel.stateFlow.collectAsState(),
//                viewModel::onCashbackRequestedAtSelected,
//                viewModel::onCashbackReceivedAtSelected,
//                viewModel::onPriceChanged,
//                viewModel::onNotesChanged,
//                viewModel::onDeleteImageClicked,
//                viewModel::onAddImageClicked,
//                viewModel::onSaveClicked
//            )
        }
    }
}

