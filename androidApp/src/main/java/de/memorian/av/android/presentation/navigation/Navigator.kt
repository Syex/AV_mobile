package de.memorian.av.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.memorian.av.android.presentation.navigation.Navigator.NavTarget
import kotlinx.coroutines.flow.*

interface Navigator {

    val sharedFlow: SharedFlow<String>

    fun navigateTo(navTarget: NavTarget, args: List<Any> = emptyList())

    enum class NavTarget(val label: String, val arguments: List<NamedNavArgument> = emptyList()) {

        Back("Back"),
        ScannedProducts("scannedProducts"),
        Settings("settings");

        companion object {

            val bottomNavigationTargets = setOf(ScannedProducts, Settings)
        }
    }
}

class NavigatorImpl : Navigator {

    private val _sharedFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)
    override val sharedFlow = _sharedFlow.asSharedFlow()

    override fun navigateTo(navTarget: NavTarget, args: List<Any>) {
//        Timber.v("Navigating to $route")
        _sharedFlow.tryEmit(navTarget.label)
    }
}

@Composable
fun GzgNavHost(navController: NavHostController, navigator: Navigator) {
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
//            val viewModel = viewModel<CashbackRequestsViewModel>(
//                factory = CashbackRequestsViewModelFactory(gzgModel)
//            )
//            CashbackRequestsScreen(
//                viewModel.stateFlow.collectAsState(),
//                viewModel::onCashbackRequestClicked,
//                viewModel::onNewCashbackClicked
//            )
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

