package com.example.tictactoe.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tictactoe.ui.theme.TicTacToeTheme

@Composable
fun GameApp(content: @Composable () -> Unit) {
    TicTacToeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            content()
        }
    }
}