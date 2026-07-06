package com.samafther.turno

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    // LÓGICA INTACTA (Tal como la pediste)
    var image = painterResource(R.drawable.ic_main)
    var nameEmpty = stringResource(R.string.str_empty)
    var nameSam = stringResource(R.string.str_sam_name)
    var nameErika = stringResource(R.string.str_erika_name)

    var currentName by remember { mutableStateOf(nameEmpty) }
    var currentImage by remember { mutableStateOf(image) }

    var erikaImage = painterResource(R.drawable.ic_eravft)
    var samImage = painterResource(R.drawable.ic_feather)

    // DISEÑO MEJORADO
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.str_Title),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Image(
            painter = currentImage,
            contentDescription = currentName,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = stringResource(R.string.str_destiny),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.padding(24.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(0.7f),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        ) {
            Text(
                text = currentName,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Button(
            onClick = {
                val turn = Random.nextBoolean()
                if (turn){
                    currentName = nameErika
                    currentImage = erikaImage
                } else {
                    currentName = nameSam
                    currentImage = samImage
                }
            },
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Text(
                text = stringResource(R.string.str_reveal),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun PaintErika(){

}

@Composable
fun PaintSam(){

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TurnoTheme {
        Dream()
    }
}