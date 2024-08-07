package com.example.githubreposapp.presentation.screens.repo_details_screen.components

data class RepoDetailsUiModel(
    val name: String,
    val description: String,
    val forksCount: String,
    val starsCount: String,
    val imageUrl: String,
    val language: String,
)