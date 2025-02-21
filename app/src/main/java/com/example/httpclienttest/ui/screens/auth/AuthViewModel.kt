package com.example.httpclienttest.ui.screens.auth

import com.example.httpclienttest.utils.SessionManager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.httpclienttest.data.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginResult = MutableStateFlow<Boolean?>(null)
    val loginResult: StateFlow<Boolean?> get() = _loginResult

    fun login(email: String, password: String) {
        // Lanzar una coroutine en el viewModelScope
        viewModelScope.launch {
            // Operación asíncrona
            val token = authRepository.login(email, password)
            if (token != null) {
                SessionManager.bearerToken = token
// Actualizar StateFlow con el resultado
                _loginResult.value = true
            } else {
                _loginResult.value = false
            }
        }
    }

}