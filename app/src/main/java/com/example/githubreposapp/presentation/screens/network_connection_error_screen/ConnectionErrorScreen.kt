package com.example.githubreposapp.presentation.screens.network_connection_error_screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubreposapp.R
import com.example.githubreposapp.presentation.screens.common_components.AppBar
import com.example.githubreposapp.presentation.screens.network_connection_error_screen.components.LottieAnimationIcon


@ExperimentalMaterial3Api
@Composable
fun ConnectionErrorScreen(modifier:Modifier = Modifier,onRetry : ()-> Unit)
{
    Scaffold(
        topBar = { AppBar(title = R.string.repository_screen_title,
            titleStyle = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            , showBackButton = false
        )
    }
        ) {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            ,horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.Center) {
        LottieAnimationIcon()
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = stringResource(id = R.string.something_went_wrong)
                ,style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                , color = MaterialTheme.colorScheme.error)

            Text(text = stringResource(id = R.string.network_exception_meesage)
                ,style = MaterialTheme.typography.bodyLarge
                , color = MaterialTheme.colorScheme.outline
                ,modifier = Modifier.padding(bottom = 24.dp))
            OutlinedButton(onClick = onRetry
            ,modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(48.dp),
                border = BorderStroke(2.dp, color = MaterialTheme.colorScheme.error)
            ){
                Text(
                    text = "Retry",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.error // Customize text color
                )
            }
            Spacer(modifier = Modifier.height(120.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ConnectionErrorScreenPreview() {
    ConnectionErrorScreen(onRetry = {})

}