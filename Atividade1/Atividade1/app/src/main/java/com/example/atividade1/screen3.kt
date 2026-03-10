package com.example.atividade1

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen() {

    val categories = listOf(
        "Woman", "Man", "Baby", "Travel", "Tech", "Food&Drink"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Categories") })
        }) { padding ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(2), modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            items(categories.size) { index ->

                CategoryItem(
                    title = categories[index], color = when (index) {
                        0 -> Color(0xFF8FAFB0)
                        1 -> Color(0xFF7FA4A5)
                        2 -> Color(0xFF5E8C8E)
                        3 -> Color(0xFF4F7C80)
                        4 -> Color(0xFF3C6A6E)
                        else -> Color(0xFF2F5C60)
                    }
                )

            }
        }
    }
}

@Composable
fun CategoryItem(title: String, color: Color) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(color),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title, color = Color.White
            )
        }
    }
}