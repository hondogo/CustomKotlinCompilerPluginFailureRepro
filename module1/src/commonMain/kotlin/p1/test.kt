package p1

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


interface ITest {

    @Composable
    fun test(modifier: Modifier = Modifier)
}