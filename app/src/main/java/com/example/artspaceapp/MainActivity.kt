package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Triple(R.drawable.art1, "Le Cri", "Edvard Munch (1893)"),
        Triple(R.drawable.art2, "La Nuit étoilée", "Vincent van Gogh (1889)"),
        Triple(R.drawable.art3, "La Joconde", "Léonard de Vinci (1503)")
    )
    var currentIndex by remember { mutableStateOf(0) }
    val artwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = artwork.first),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = artwork.second, style = MaterialTheme.typography.headlineSmall)
        Text(text = artwork.third, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                if (currentIndex > 0) currentIndex--
            }) {
                Text("Précédent")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                currentIndex = (currentIndex + 1) % artworks.size
            }) {
                Text("Suivant")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}
