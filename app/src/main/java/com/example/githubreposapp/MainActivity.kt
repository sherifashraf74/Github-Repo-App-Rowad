package com.example.githubreposapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubreposapp.presentation.navigation.AppNavHost
import com.example.githubreposapp.theme.GithubReposAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubReposAppTheme {
                AppNavHost()
            }
        }
    }
}



@Composable
fun Greeting(
    name: String
) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.displayLarge
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "pixel" ,
    device = Devices.NEXUS_10
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "pixel 4" ,
    device = Devices.PIXEL_4
)
@Composable
fun GreetingPreview() {
    GithubReposAppTheme {
        Greeting("Android")
    }
}

@Composable
fun MySwitch() {
    // remember is used
    val checked = remember { mutableStateOf(false) }
    Switch(
       checked = checked.value,
     onCheckedChange = {
        checked.value = it
        }
    )
}

@Composable
fun MySwitch2() {
    // remember is used
    val checked = rememberSaveable { mutableStateOf(false) }
   Switch(
       modifier = Modifier.padding(20.dp),
        checked = checked.value,
        onCheckedChange = {
            checked.value = it
        },
        colors =   SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Green.copy(alpha = 0.5f)
        )
    )
}
