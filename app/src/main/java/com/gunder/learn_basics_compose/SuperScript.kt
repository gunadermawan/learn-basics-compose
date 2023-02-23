package com.gunder.learn_basics_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.gunder.learn_basics_compose.ui.theme.LearnbasicscomposeTheme

class SuperScript : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnbasicscomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun SuperScriptText (
    normalText:String,
    normalFontSize:TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    superTextFontSize:TextUnit = MaterialTheme.typography.overline.fontSize,
    superTextFontWeight:FontWeight = FontWeight.Normal,
    superText:String) {
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = normalFontSize)){
            append(normalText)
        }
        withStyle(style = SpanStyle(
            fontSize = superTextFontSize,
            fontWeight = superTextFontWeight,
            baselineShift = BaselineShift.Subscript
        )){
            append(superText)
        }
    })
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewSuperScript() {
    LearnbasicscomposeTheme {
        SuperScriptText(normalText = "Hello", superText = "World" )
    }
}