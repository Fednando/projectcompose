package br.com.tracker_presentation.trackeroverview.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SpaceHeight(
    height: Dp
) {
    Spacer(modifier = Modifier.height(height))
}
@Composable
fun SpaceWidth(
    weight: Dp
) {
    Spacer(modifier = Modifier.width(weight))
}