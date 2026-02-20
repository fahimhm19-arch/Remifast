package com.example.moneyapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(transactions: List<Transaction>) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Transactions List") }) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(transactions) { transaction ->
                    TransactionItem(transaction)
                }
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = transaction.date)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = transaction.amount.toString())
        }
    }
}

data class Transaction(val date: String, val amount: Double)

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(transactions = listOf(
        Transaction("2023-02-20", 75.0),
        Transaction("2023-02-21", 100.5)
    ))
}