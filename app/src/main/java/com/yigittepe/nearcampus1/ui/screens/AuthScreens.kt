package com.yigittepe.nearcampus1.ui.screens

import com.yigittepe.nearcampus1.data.AuthManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yigittepe.nearcampus1.ui.components.BrandTitle
import com.yigittepe.nearcampus1.ui.components.HeaderBar
import com.yigittepe.nearcampus1.ui.theme.Border
import com.yigittepe.nearcampus1.ui.theme.Canvas
import com.yigittepe.nearcampus1.ui.theme.Gold
import com.yigittepe.nearcampus1.ui.theme.GoldText
import com.yigittepe.nearcampus1.ui.theme.Ink
import com.yigittepe.nearcampus1.ui.theme.Muted
import com.yigittepe.nearcampus1.ui.theme.Navy

@Composable
internal fun WelcomeScreen(onLogin: () -> Unit, onRegister: () -> Unit, onGuest: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFEFF2F4), Canvas, Color(0xFFFFF6E3))))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(1.35f)
                .clip(RoundedCornerShape(32.dp))
        ) {
            androidx.compose.foundation.Image(
                painter = androidx.compose.ui.res.painterResource(id = com.yigittepe.nearcampus1.R.drawable.login_page_frame),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color(0x66000000))
                        )
                    )
            )
            Text("BOGAZICI UNIVERSITY", Modifier.align(Alignment.BottomStart).padding(24.dp), color = Color.White, fontWeight = FontWeight.Bold)
            AssistChip(
                onClick = {},
                label = { Text("Student Deals") },
                leadingIcon = { Icon(Icons.Default.LocalOffer, null, Modifier.size(16.dp)) },
                modifier = Modifier.align(Alignment.BottomEnd).padding(20.dp),
                colors = androidx.compose.material3.AssistChipDefaults.assistChipColors(
                    containerColor = Color.White.copy(alpha = 0.9f),
                    labelColor = Ink
                )
            )
        }
        Spacer(Modifier.height(28.dp))
        BrandTitle(size = 44)
        Text("Find your space nearby campus", color = Muted, fontSize = 16.sp)
        Spacer(Modifier.height(32.dp))
        Button(onClick = onRegister, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(16.dp)) {
            Text("Register", fontWeight = FontWeight.SemiBold)
        }
        Spacer(Modifier.height(12.dp))
        OutlinedButton(
            onClick = onLogin,
            modifier = Modifier.fillMaxWidth().height(52.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Gold, contentColor = GoldText),
            border = BorderStroke(1.dp, Color(0xFFE9C176)),
            shape = RoundedCornerShape(16.dp)
        ) { Text("Login", fontWeight = FontWeight.SemiBold) }
        Spacer(Modifier.height(24.dp))
        TextButton(onClick = onGuest) {
            Text("Continue as Guest", color = Ink, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
        }
    }
}

@Composable
internal fun LoginScreen(onBack: () -> Unit, onSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var isResetLoading by remember { mutableStateOf(false) }
    var showResetDialog by remember { mutableStateOf(false) }
    var resetEmail by remember { mutableStateOf("") }
    var resetErrorMessage by remember { mutableStateOf<String?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var successMessage by remember { mutableStateOf<String?>(null) }

    if (showResetDialog) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = {
                if (!isResetLoading) {
                    showResetDialog = false
                }
            },
            title = { Text("Reset Password") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Enter your account email and we will send password reset instructions.", color = Muted)
                    OutlinedTextField(
                        value = resetEmail,
                        onValueChange = { resetEmail = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        enabled = !isResetLoading
                    )
                    if (resetErrorMessage != null) {
                        Text(resetErrorMessage!!, color = Color.Red, fontSize = 14.sp)
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        isResetLoading = true
                        errorMessage = null
                        successMessage = null
                        resetErrorMessage = null
                        AuthManager.sendPasswordResetEmail(resetEmail.trim()) { success, error ->
                            isResetLoading = false
                            if (success) {
                                showResetDialog = false
                                successMessage = "Password reset email sent. Check your inbox."
                            } else {
                                resetErrorMessage = error
                            }
                        }
                    },
                    enabled = resetEmail.contains("@") && !isResetLoading
                ) {
                    Text(if (isResetLoading) "Sending..." else "Send")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetDialog = false }, enabled = !isResetLoading) {
                    Text("Cancel")
                }
            }
        )
    }

    AuthForm(title = "Login", onBack = onBack) {
        OutlinedTextField(email, { email = it }, Modifier.fillMaxWidth(), label = { Text("Email") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), enabled = !isLoading)
        OutlinedTextField(password, { password = it }, Modifier.fillMaxWidth(), label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), enabled = !isLoading)
        
        if (successMessage != null) {
            Text(successMessage!!, color = GoldText, fontSize = 14.sp)
        }

        if (errorMessage != null) {
            Text(errorMessage!!, color = Color.Red, fontSize = 14.sp)
        }

        Button(
            onClick = {
                isLoading = true
                errorMessage = null
                successMessage = null
                AuthManager.signIn(email, password) { success, error ->
                    isLoading = false
                    if (success) {
                        onSuccess()
                    } else {
                        errorMessage = error
                    }
                }
            },
            enabled = email.isNotBlank() && password.isNotBlank() && !isLoading,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (isLoading) {
                androidx.compose.material3.CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
            } else {
                Text("Login")
            }
        }
        TextButton(
            onClick = {
                resetEmail = email.trim()
                errorMessage = null
                successMessage = null
                resetErrorMessage = null
                showResetDialog = true
            },
            enabled = !isLoading
        ) {
            Text("Forgot Password")
        }
    }
}

@Composable
internal fun RegisterScreen(onBack: () -> Unit, onSuccess: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    AuthForm(title = "Create account", onBack = onBack) {
        Text("Discover nearby venues, menus, discounts, and reviews.", color = Muted)
        Text("Student verification is completed later from your Profile.", color = Muted, fontSize = 14.sp)
        OutlinedTextField(name, { name = it }, Modifier.fillMaxWidth(), label = { Text("Name") }, enabled = !isLoading)
        OutlinedTextField(email, { email = it }, Modifier.fillMaxWidth(), label = { Text("Email") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), enabled = !isLoading)
        OutlinedTextField(password, { password = it }, Modifier.fillMaxWidth(), label = { Text("Password") }, visualTransformation = PasswordVisualTransformation(), enabled = !isLoading)
        
        if (errorMessage != null) {
            Text(errorMessage!!, color = Color.Red, fontSize = 14.sp)
        }

        Button(
            onClick = {
                isLoading = true
                errorMessage = null
                AuthManager.signUp(name, email, password) { success, error ->
                    isLoading = false
                    if (success) {
                        onSuccess()
                    } else {
                        errorMessage = error
                    }
                }
            },
            enabled = name.length >= 2 && email.contains("@") && password.length >= 8 && !isLoading,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (isLoading) {
                androidx.compose.material3.CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
            } else {
                Text("Create Account")
            }
        }
    }
}

@Composable
private fun AuthForm(title: String, onBack: () -> Unit, content: @Composable ColumnScope.() -> Unit) {
    LazyColumn(Modifier.fillMaxSize(), contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 24.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        item { HeaderBar(title, onBack) }
        item {
            Column(Modifier.padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                BrandTitle(size = 36)
                content()
            }
        }
    }
}

@Composable
private fun SocialButton(label: String) {
    androidx.compose.material3.Surface(shape = RoundedCornerShape(16.dp), border = BorderStroke(1.dp, Border), color = Color.White) {
        Box(Modifier.size(56.dp), contentAlignment = Alignment.Center) {
            Text(label, color = Ink, fontWeight = FontWeight.Bold)
        }
    }
}
