package com.example.moneyapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.os.Handler
import android.os.Looper

@Composable
fun TransferScreen(
    onTransferSuccess: () -> Unit,
    onBack: () -> Unit
) {
    var recipient by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Send Money", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = recipient,
            onValueChange = { recipient = it },
            label = { Text("Recipient Email or Phone") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount ($)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            label = { Text("Note (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Button(
                onClick = {
                    isLoading = true
                    // TODO: Implement API call to backend here
                    // simulate network delay
                    Handler(Looper.getMainLooper()).postDelayed({
                        isLoading = false
                        onTransferSuccess()
                    }, 2000)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = recipient.isNotBlank() && amount.isNotBlank()
            ) {
                Text("Confirm Transfer")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onBack) {
            Text("Cancel")
        }
    }
}