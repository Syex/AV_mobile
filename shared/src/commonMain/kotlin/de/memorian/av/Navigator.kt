package de.memorian.av

import io.github.syex.flykaw.logVerbose
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

interface Navigator {

    val sharedFlow: SharedFlow<String>

    fun navigateTo(navTarget: NavTarget, args: List<Any> = emptyList())

    enum class NavTarget(val label: String) {

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

    override fun navigateTo(navTarget: Navigator.NavTarget, args: List<Any>) {
        logVerbose("Navigating to $navTarget")
        _sharedFlow.tryEmit(navTarget.label)
    }
}