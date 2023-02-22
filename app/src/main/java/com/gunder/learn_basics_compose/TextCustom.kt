package com.gunder.learn_basics_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gunder.learn_basics_compose.ui.theme.LearnbasicscomposeTheme

class TextCustom : ComponentActivity() {
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
fun CustomText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.title_activity_text_custom),
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .width(200.dp)
                .padding(16.dp),
            color = Color.White,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun CustomTextAnnotated() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = ParagraphStyle(textAlign = TextAlign.Center)
            ) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp
                    )
                ) {
                    append('A')
                }
                append('B')
                append('C')
                append('D')
            }
        }, modifier = Modifier.width(200.dp)
    )
}

@Composable
fun StringRepeat() {
    Text(text = "hello compose".repeat(20), maxLines = 3, overflow = TextOverflow.Ellipsis)
}

@Preview(showBackground = true)
@Composable
fun StringRepeatPreview() {
    StringRepeat()
}

@Preview(showBackground = true)
@Composable
fun CustomTextPreview() {
    LearnbasicscomposeTheme {
        CustomText()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun CustomTextAnnotatedPreview() {
    CustomTextAnnotated()
}
