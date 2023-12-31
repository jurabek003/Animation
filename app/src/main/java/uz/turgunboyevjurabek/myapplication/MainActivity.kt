package uz.turgunboyevjurabek.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import uz.turgunboyevjurabek.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            GreetingPreview()

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview(
    alignment: Alignment= Alignment.Center,
    
) {
    var sizeState by remember { mutableStateOf(200.dp) }
    val size by animateDpAsState(
        targetValue = sizeState,
        // with tween animation
//        tween(
//            durationMillis = 3000,
//            delayMillis = 300,
//            easing = LinearOutSlowInEasing
//        ), label = ""
//
        //with Spring animation
//        spring(
//            Spring.DampingRatioHighBouncy
//        ), label = ""
        // with keyframes animation
//    keyframes {

//              durationMillis=5000
//        sizeState at 0 with  LinearEasing
//        sizeState * 1.5f at 1000 with FastOutLinearInEasing
//        sizeState * 2f at 5000
//    }, label = ""

    tween(
        durationMillis = 5000
    ), label = ""
    )
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.White,
        targetValue = Color.Black,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ), label = "allambalo"
    )
    Box(
        modifier = Modifier
        .size(size)
        .background(color),
        contentAlignment = Alignment.Center,
    ){
        Button(onClick = {
            sizeState+=50.dp
        }) {
            Text(text = "click me 😉")
        }
    }
}