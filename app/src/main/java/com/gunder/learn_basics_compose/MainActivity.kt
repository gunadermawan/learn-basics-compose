package com.gunder.learn_basics_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gunder.learn_basics_compose.ui.theme.LearnbasicscomposeTheme

private val sampleName = listOf(
    "Andre",
    "Desta",
    "Parto",
    "Wendy",
    "Komeng",
    "Raffi Ahmad",
    "Andhika Pratama",
    "Vincent Ryan Rompies"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnbasicscomposeTheme {
                ComposeTheme()
            }
        }
    }
}

@Composable
fun ComposeTheme() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        GreetingList(sampleName)
    }
}

@Composable
fun GreetingList(name: List<String>) {
    if (name.isNotEmpty()) {
        Column() {
            for (names in name) {
                Greeting(name = names)
            }
        }
    } else {
        Text("something people!")
    }
}

@Composable
fun Greeting(name: String) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "logo jetpack compose",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Hello $name!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Hello developer!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnbasicscomposeTheme {
        Greeting("Android")
    }
}