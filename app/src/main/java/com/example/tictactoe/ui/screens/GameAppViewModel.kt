package com.example.tictactoe.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tictactoe.model.TicTacToe
import com.example.tictactoe.model.Winner
import com.example.tictactoe.model.findWinner

class GameAppViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    fun startGame() {
        state = UiState(
            ticTacToe = TicTacToe(),
            gameState = GameState.InProgress
        )
    }

    fun move(row: Int, column: Int) {
        val newTicTacToe = state.ticTacToe.move(row, column)
        state = UiState(
            ticTacToe = newTicTacToe,
            gameState = when (val winner = newTicTacToe.findWinner()) {
                null -> GameState.InProgress
                else -> GameState.Finished(winner)
            }
        )
    }
}


data class UiState(
    val ticTacToe: TicTacToe = TicTacToe(),
    val gameState: GameState = GameState.NotStarted
)

sealed interface GameState {
    data object NotStarted : GameState
    data object InProgress : GameState
    data class Finished(val winner: Winner) : GameState
}

