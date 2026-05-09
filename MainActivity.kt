package com.example.meumundo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import androidx.core.net.toUri
import com.example.meumundo.ui.theme.MeumundoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MeumundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaTelefone(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("QueryPermissionsNeeded")
@Composable
fun TelaTelefone(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Abrir discador com Intent")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val telefoneIntent = Intent(Intent.ACTION_DIAL).apply {

                    data = "tel:83999999999".toUri()
                }

                if (telefoneIntent.resolveActivity(context.packageManager) != null) {

                    context.startActivity(telefoneIntent)

                } else {

                    Toast.makeText(
                        context,
                        "Nenhum aplicativo de telefone encontrado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {

            Text("Abrir Discador")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaTelefone() {

    MeumundoTheme {

        TelaTelefone()
    }
}
