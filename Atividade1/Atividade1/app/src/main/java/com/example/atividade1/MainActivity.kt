package com.example.atividade1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.atividade1.ui.theme.Atividade1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Atividade1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Tela 1
                    TaskScreen()
                    // Tela 2
                    //ColorLayoutScreen()
                    // Tela 3
                    //CategoriesScreen()
                    // Tela 4
                    //LoginScreen()
                    // Tela 5
                    //FormScreen()
                    // Tela 6
                    //MovieScreen()
                    // Tela 7
                    //BoaViagemScreen()
                }
            }
        }
    }
}