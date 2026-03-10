package com.example.atividade1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TaskScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var title by remember { mutableStateOf("") }

    val done = remember { mutableStateOf(false) }
    var notDone = remember { mutableStateOf(true) }

    var priority = remember { mutableStateOf("Low") }

    var date = remember { mutableStateOf("Choose Date") }
    var time = remember { mutableStateOf("Choose Time") }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text("Title")

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = { Text("Enter Title") },
                modifier = Modifier.fillMaxWidth()
            )

            Text("Status")

            Row {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = done.value, onCheckedChange = {
                            done.value = it
                            notDone.value = !it
                        })
                    Text("Done")
                }

                Spacer(Modifier.width(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = notDone.value, onCheckedChange = {
                            notDone.value = it
                            done.value = !it
                        })
                    Text("Not Done")
                }
            }

            Text("Priority")

            Row {

                listOf("Low", "Medium", "High").forEach {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = priority.value == it, onClick = { priority.value = it })

                        Text(it)

                        Spacer(Modifier.width(8.dp))
                    }
                }
            }

            Text("Time and Date")

            Row {

                Button(onClick = {
                    date.value = "2026-03-06"
                }) {
                    Text(date.value)
                }

                Spacer(Modifier.width(16.dp))

                Button(onClick = {
                    time.value = "17:30"
                }) {
                    Text(time.value)
                }
            }

            Spacer(Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
            ) {

                Button(onClick = {
                    // Cancel
                    title = ""
                }) {
                    Text("Cancel")
                }

                Button(onClick = {
                    // Reset
                    title = ""
                    done.value = false
                    notDone.value = true
                    priority.value = "Low"
                    date.value = "Choose Date"
                    time.value = "Choose Time"
                }) {
                    Text("Reset")
                }

                Button(onClick = {

                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Task Submitted!"
                        )
                    }

                }) {
                    Text("Submit")
                }
            }
        }
    }
}
