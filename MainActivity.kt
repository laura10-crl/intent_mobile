package com.example.meumundo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meumundo.ui.theme.MeumundoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MeumundoTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    TelaGoogle(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TelaGoogle(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Abrir site com ACTION_VIEW")
        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {
                val siteIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.imdb.com/pt/chart/top/")
                )
                context.startActivity(siteIntent)
            }
        ) {
            Text(text = "Abrir Site")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewTelaGoogle() {
    MeumundoTheme {
        TelaGoogle()
    }
}
