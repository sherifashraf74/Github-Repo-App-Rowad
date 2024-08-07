package com.example.githubreposapp.presentation.screens.repo_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubreposapp.R
import com.example.githubreposapp.presentation.screens.common_components.AppBar
import com.example.githubreposapp.theme.GithubReposAppTheme

@ExperimentalMaterial3Api
@Composable
fun RepoListScreen(
    modifier: Modifier = Modifier,
    repoListUiModel: List<GithubRepoUiModel>,
    onRepoItemClicked: (repoItem: GithubRepoUiModel) -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            AppBar(
                title = R.string.repository_screen_title,
                showBackButton = false
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 8.dp)
                .padding(innerPadding)
        ) {
            items(repoListUiModel) { repoItem ->
                RepoItem(repoItem, onRepoItemClicked = {
                    onRepoItemClicked(it)
                }
                )
            }
        }
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun PreviewRepoScreen() {
    GithubReposAppTheme {
        RepoListScreen(repoListUiModel = fakeRepoUiModelList) {

        }
    }
}

