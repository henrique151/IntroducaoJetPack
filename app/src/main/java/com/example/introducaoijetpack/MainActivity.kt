package com.example.introducaoijetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introducaoijetpack.ui.theme.DebugButtonsColors
import com.example.introducaoijetpack.ui.theme.ErrorButtonsColors
import com.example.introducaoijetpack.ui.theme.InfoButtonsColors
import com.example.introducaoijetpack.ui.theme.IntroducaoiJetPackTheme
import com.example.introducaoijetpack.ui.theme.WarningButtonsColors
import java.lang.Exception
import java.lang.RuntimeException

const val TAG = "TesteAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    IntroducaoiJetPackTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting(name = "JetPack")
                ActionButton(
                    text = "Debug",
                    buttonColors = DebugButtonsColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Log.d(TAG, "App: Clicou em Debug!")
                }

                ActionButton(
                    text = "Info",
                    buttonColors = InfoButtonsColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Log.i(TAG, "App: Clicou em Info!")
                }

                ActionButton(
                    text = "Warning",
                    buttonColors = WarningButtonsColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Log.w(TAG, "App: Clicou em Warning!")
                }

                ActionButton(
                    text = "Error",
                    buttonColors = ErrorButtonsColors(),
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    try {
                        throw RuntimeException("Clicou em Errou!")
                    } catch (ex: Exception) {
                        Log.e(TAG, "${ex.message}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 400)
@Composable
fun AppPreview(){
    App()
}


@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(
            text = text,
        )
    }
}

@Preview(showBackground = true)
@Composable()
fun ActionBunttonPreviw(){
    ActionButton(text = "Cadastrar") {

    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroducaoiJetPackTheme {
        Greeting("Android")
    }
}