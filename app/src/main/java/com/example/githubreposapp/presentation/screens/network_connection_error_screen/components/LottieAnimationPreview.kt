package com.example.githubreposapp.presentation.screens.network_connection_error_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants.IterateForever
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.githubreposapp.R

@Composable
fun LottieAnimationIcon(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_network_error))
    val animationState = rememberLottieAnimatable()

    LaunchedEffect(composition) {
        animationState.animate(
            composition = composition,
            iterations = IterateForever // Loop the animation infinitely
        )
    }

    // Display the Lottie animation
    LottieAnimation(
        composition = composition,
        progress = { animationState.progress },
        modifier = Modifier.size(400.dp)
    )
}


@Preview
@Composable
fun LottieAnimationPreview() {
    LottieAnimationIcon()


}