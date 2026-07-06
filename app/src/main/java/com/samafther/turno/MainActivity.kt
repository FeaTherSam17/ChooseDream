package com.samafther.turno

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.samafther.turno.ui.theme.TurnoTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TurnoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Dream(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Dream(modifier: Modifier = Modifier) {
    var image = painterResource(R.drawable.ic_main)
    var nameEmpty = stringResource(R.string.str_empty)
    var nameSam = stringResource(R.string.str_sam_name)
    var nameErika = stringResource(R.string.str_erika_name)
    var currentName by remember {mutableStateOf(nameEmpty) }
    var currentImage by remember { mutableStateOf(image) }
    var erikaImage = painterResource(R.drawable.ic_eravft)
    var samImage = painterResource(R.drawable.ic_feather)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.str_Title)
        )
        Image(painter = currentImage, contentDescription = currentName)
        Text(
            text = stringResource(R.string.str_destiny)
        )

        Button(
            onClick = {},
        ) {
            Text(text = currentName)
        }
        Button(onClick = {
            val turn = Random.nextBoolean()
            if (turn){
                currentName = nameErika
                currentImage = erikaImage
            }else{
                currentName = nameSam
                currentImage = samImage
            }
        }) {
            Text(stringResource(R.string.str_reveal))
        }
    }

}


@Composable
fun PaintErika(){

}


@Composable
fun PaintSam(){

}

@Preview(showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    TurnoTheme {
        Dream()
    }
}