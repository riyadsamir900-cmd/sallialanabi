package com.example.sollialanabi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SalliScreen()
            }
        }
    }
}

@Composable
fun SalliScreen() {
    var count by remember { mutableStateOf(0) }
    val db = FirebaseFirestore.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "اللهم صلِّ وسلم على نبينا محمد ﷺ",
            fontSize = 22.sp,
            style = MaterialTheme.typography.titleLarge
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = "$count",
            fontSize = 48.sp,
            style = MaterialTheme.typography.displayLarge
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = { 
                count++
                db.collection("salawat").add(mapOf("timestamp" to System.currentTimeMillis()))
            },
            modifier = Modifier.height(56.dp).fillMaxWidth()
        ) {
            Text(text = "صلِّ عليه", fontSize = 18.sp)
        }
    }
}
