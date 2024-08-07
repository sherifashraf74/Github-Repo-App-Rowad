package com.example.githubreposapp.presentation.screens.repo_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.githubreposapp.R
import com.example.githubreposapp.presentation.screens.common_components.AppBar
import com.example.githubreposapp.presentation.screens.repo_details_screen.components.DetailsItem
import com.example.githubreposapp.presentation.screens.repo_details_screen.components.RepoDetailsUiModel
import com.example.githubreposapp.theme.GithubReposAppTheme

@ExperimentalMaterial3Api
@Composable
fun RepoDetailsScreen(
    modifier: Modifier = Modifier,
    repoDetailsUiModel: RepoDetailsUiModel,
    onClickBack: () -> Unit,
    onClickViewIssues: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            AppBar(
                onBackButtonClicked = onClickBack,
                title = R.string.details_app_bar_title
            )
        }
    ) { innerPadding ->
        // In Jetpack Compose, the Scaffold composable provides a basic layout structure
        // for your app, with optional top, bottom, and floating action buttons.
        // It also includes a content lambda where you can define the main content of your screen.
        // The innerPadding parameter passed to the content lambda is a PaddingValues object representing
        // the padding that should be applied to the content to avoid overlapping with
        // the app bar, bottom bar, or floating action button.
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = repoDetailsUiModel.imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            crossfade(1000)
                            placeholder(R.drawable.ic_github_placeholser)
                        })
                        .build()
                ),
                contentDescription = stringResource(R.string.accessbility_details_your_avatar_image),
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(150.dp))
                    .padding(top = 16.dp),
            )

            Text(
                text = repoDetailsUiModel.name,
                style = MaterialTheme.typography.headlineSmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DetailsItem(
                    value = repoDetailsUiModel.starsCount.toString(),
                    image = R.drawable.ic_star,
                    modifier = Modifier.weight(1f),
                    colorFilter = ColorFilter.tint(Color.Yellow),
                )
                Row {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.Blue)
                    )
                    Text(
                        text = repoDetailsUiModel.language,
                        modifier = Modifier
                            .padding(start = 8.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                DetailsItem(
                    value = repoDetailsUiModel.forksCount.toString(),
                    image = R.drawable.ic_fork,
                    modifier = Modifier.weight(1f),
                )
            }
            Text(
                text = repoDetailsUiModel.description,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyLarge,
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onClickViewIssues,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.show_issues),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                )
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    GithubReposAppTheme {
        RepoDetailsScreen(
            repoDetailsUiModel = RepoDetailsUiModel(
                name = "Jetpack Compose",
                imageUrl = "https://tabris.com/wp-content/uploads/2021/06/jetpack-compose-icon_RGB.png",
                language = "Kotlin",
                forksCount = "100",
                starsCount = "1000",
                description = "Jetpack Compose is Android's modern toolkit for building native user interfaces. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            ),
            onClickBack = {},
            onClickViewIssues = {}
        )
    }
}