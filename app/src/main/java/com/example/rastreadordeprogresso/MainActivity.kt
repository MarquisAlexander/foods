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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rastreadordeprogresso.ui.theme.Background
import com.example.rastreadordeprogresso.ui.theme.Blue
import com.example.rastreadordeprogresso.ui.theme.Description
import com.example.rastreadordeprogresso.ui.theme.RastreadorDeProgressoTheme
import com.example.rastreadordeprogresso.ui.theme.Title

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
    val obj = arrayOf("Snack", "Pasta", "Main")
    Column(
        modifier = Modifier
            .background(Background)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp, 16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            CustomCard(obj.get(0), 0)
            CustomCard(obj.get(1), 1)
            CustomCard(obj.get(2), 2)
            CustomCard(obj.get(2), 2)
            CustomCard(obj.get(2), 2)
            CustomCard(obj.get(2), 2)
        }
        Column(modifier = Modifier.padding(16.dp)) {
            MainCard(obj.get(1))
        }
    }

}

@Composable
fun CustomCard(title: String, index: Int) {
    var isFirst = if (index == 0) 0 else 6
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Blue
        ),
        modifier = Modifier
            .heightIn(0.dp, 100.dp)
            .widthIn(0.dp, 100.dp)
            .padding(isFirst.dp, 0.dp, 0.dp, 0.dp)
    ) {
        val monthString = when (title) {
            "Snack" -> R.drawable.hamburger
            "Pasta" -> R.drawable.pasta
            "Main" -> R.drawable.main
            else -> R.drawable.hamburger
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = monthString),
                contentDescription = "food",
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Title
            )
        }
    }
}

@Composable
fun MainCard(title: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Blue
        )
    ) {
        val monthString = when (title) {
            "Snack" -> R.drawable.hamburger
            "Pasta" -> R.drawable.pasta
            else -> R.drawable.hamburger
        }
        Image(
            painter = painterResource(id = monthString),
            contentDescription = "food",
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Spaghetti Bolognese",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Title
            )
            Text(
                text = "Spaghetti paste with Italian-style minced meat sauce.",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = Description
            )
            Text(
                text = "$ 19.99",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Description
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RastreadorDeProgressoTheme {
        Greeting()
    }
}