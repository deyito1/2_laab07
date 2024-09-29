package com.example.crudapp

import AppDatabase
import Locker
import LockerViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : ComponentActivity() {
    private val lockerViewModel: LockerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LockerApp(lockerViewModel)
        }
    }
}

@Composable
fun LockerApp(lockerViewModel: LockerViewModel) {
    val lockers by lockerViewModel.allLockers.collectAsStateWithLifecycle(emptyList())

    Column {
        LazyColumn {
            items(lockers) { locker ->
                Text(text = "Locker: ${locker.lockerNumber} - Available: ${locker.isAvailable}")
            }
        }

        Button(onClick = {
            lockerViewModel.insert(Locker(lockerNumber = "L01", isAvailable = true))
        }) {
            Text(text = "Add Locker")
        }
    }
}
