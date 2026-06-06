package com.yigittepe.nearcampus1.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.userProfileChangeRequest

internal object AuthManager {
    var onRequireAuth: (() -> Unit)? = null

    private val auth: FirebaseAuth
        get() = FirebaseAuth.getInstance()

    fun signUp(name: String, email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = task.result?.user
                    val profileUpdates = userProfileChangeRequest {
                        displayName = name
                    }
                    if (user == null) {
                        onResult(false, "Account created, but failed to initialize user profile. Please try again.")
                        return@addOnCompleteListener
                    }

                    user.updateProfile(profileUpdates)
                        ?.addOnCompleteListener { profileTask ->
                            createUserEntryAfterSignUp(
                                user = user,
                                name = name,
                                email = email,
                                profileError = profileTask.exception?.localizedMessage,
                                onResult = onResult
                            )
                        } ?: createUserEntryAfterSignUp(user, name, email, null, onResult)
                } else {
                    onResult(false, task.exception?.localizedMessage ?: "Registration failed")
                }
            }
    }

    private fun createUserEntryAfterSignUp(
        user: FirebaseUser,
        name: String,
        email: String,
        profileError: String?,
        onResult: (Boolean, String?) -> Unit
    ) {
        FirestoreRepository.createUserEntry(user.uid, email, name) { created ->
            when {
                !created -> onResult(false, "Account created, but failed to initialize user profile. Please try again.")
                profileError != null -> onResult(true, "Account created, but failed to set username: $profileError")
                else -> onResult(true, null)
            }
        }
    }

    fun signIn(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.localizedMessage ?: "Login failed")
                }
            }
    }

    fun sendPasswordResetEmail(email: String, onResult: (Boolean, String?) -> Unit) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.localizedMessage ?: "Failed to send password reset email")
                }
            }
    }

    fun signOut() {
        auth.signOut()
        FirestoreRepository.clearCacheAndFavorites()
    }

    fun changePassword(newPassword: String, onResult: (Boolean, String?) -> Unit) {
        val user = auth.currentUser
        if (user == null) {
            onResult(false, "User is not signed in.")
            return
        }
        user.updatePassword(newPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.localizedMessage ?: "Failed to change password.")
                }
            }
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun isUserSignedIn(): Boolean {
        return auth.currentUser != null
    }
}
