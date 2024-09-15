package com.example.thirtydays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ThirtyDaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysApp()
                }
            }
        }
    }
}

@Composable
fun ThirtyDaysApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { ThirtyDaysAppBar() }
    ) {
        TipsList(it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysAppBar() {
    CenterAlignedTopAppBar(title = {

        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
    },   colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.background
    ))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThirtyDaysTheme {
        ThirtyDaysApp()
    }
}