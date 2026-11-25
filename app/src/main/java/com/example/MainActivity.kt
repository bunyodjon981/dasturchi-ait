package com.example.jadval

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { JadvalApp() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JadvalApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Jadval Ilovasi", fontSize = 20.sp) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        TableContent(Modifier.padding(innerPadding))
    }
}

// Sample data class
data class Person(val id: Int, val name: String, val age: Int, val city: String)

val sampleData = listOf(
    Person(1, "Alisher", 28, "Tashkent"),
    Person(2, "Mariya", 34, "Samarkand"),
    Person(3, "Bobur", 22, "Bukhara"),
    Person(4, "Dilnoza", 30, "Namangan"),
    Person(5, "Javohir", 27, "Fergana"),
    Person(6, "Saida", 31, "Andijan"),
    Person(7, "Rustam", 25, "Nukus"),
    Person(8, "Gulbahor", 29, "Jizzax"),
    Person(9, "Oybek", 33, "Qarshi"),
    Person(10, "Nodira", 26, "Termez")
)

@Composable
fun TableContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(vertical = 8.dp)
        ) {
            TableCell(text = "ID", weight = 1f, isHeader = true)
            TableCell(text = "Ism", weight = 3f, isHeader = true)
            TableCell(text = "Yosh", weight = 1f, isHeader = true)
            TableCell(text = "Shahar", weight = 2f, isHeader = true)
        }
        Divider()
        LazyColumn {
            items(sampleData) { person ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    TableCell(text = person.id.toString(), weight = 1f)
                    TableCell(text = person.name, weight = 3f)
                    TableCell(text = person.age.toString(), weight = 1f)
                    TableCell(text = person.city, weight = 2f)
                }
                Divider()
            }
        }
    }
}

@Composable
fun TableCell(text: String, weight: Float, isHeader: Boolean = false) {
    Text(
        text = text,
        modifier = Modifier
            .weight(weight)
            .padding(horizontal = 8.dp),
        fontSize = if (isHeader) 16.sp else 14.sp,
        fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal,
        color = if (isHeader) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurface
    )
}
