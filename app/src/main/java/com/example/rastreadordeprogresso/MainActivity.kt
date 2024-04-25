package com.example.rastreadordeprogresso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rastreadordeprogresso.ui.theme.Background
import com.example.rastreadordeprogresso.ui.theme.Blue
import com.example.rastreadordeprogresso.ui.theme.RastreadorDeProgressoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RastreadorDeProgressoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val names = mutableListOf("marquis", "alexander", "santos")
    //exemplo de utilizacao de estado. bem parecido com react.
    val (index, setIndex) = remember { mutableStateOf(0) }

    View()
}

@Composable
fun View() {
    Column(
        modifier = Modifier
            .background(Background)
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp, 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            CustomCard("Snack", 1)
            CustomCard("Main", 2)
            CustomCard("Pasta", 3)
            CustomCard("Pasta", 4)
            CustomCard("Pasta", 5)
            CustomCard("Pasta", 6)
            CustomCard("Pasta", 7)
        }
        Column(modifier = Modifier.padding(16.dp)) {
            MainCard()
        }
    }

}

@Composable
fun CustomCard(title: String, index: Int) {
    var paddingLeft = if (index == 1) 16 else 5
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Blue
        ),
        modifier = Modifier
            .size(
                width = 110.dp, height = 110.dp
            )
            .padding(paddingLeft.dp, 0.dp, 0.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "food",
                modifier = Modifier.size(50.dp)
            )
            Text(text = title)
        }
    }
}

@Composable
fun MainCard() {
    Column(
        modifier = Modifier.background(Blue).fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "food",
            modifier = Modifier.height(200.dp).fillMaxWidth()
        )
        Text(text = "Spaghetti Bolognese")
        Text(text = "Spaghetti paste with Italian-style minced meat sauce.")
        Text(text = "$ 19.99")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RastreadorDeProgressoTheme {
        Greeting()
    }
}