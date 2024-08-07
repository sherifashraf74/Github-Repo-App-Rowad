package com.example.githubreposapp.presentation.screens.repo_list_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.githubreposapp.R

@Composable
fun RepoItem(
    repoItem: GithubRepoUiModel,
    onRepoItemClicked: (repoItem: GithubRepoUiModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onRepoItemClicked(repoItem) }
    ) {
        Image(
            painter =  rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = repoItem.avatar)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(1000)
                        placeholder(R.drawable.ic_github_placeholser)
                    })
                    .build()
            ),
            contentDescription = stringResource(id = R.string.repository_screen_avatar_image_description),
            modifier = Modifier
                .size(50.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Column(
            Modifier.padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = repoItem.name,
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(text = repoItem.stars)
                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = stringResource(id = R.string.repository_screen_star_icon_description),
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .size(30.dp)
                )
            }

            Text(
                text = repoItem.owner,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = repoItem.description,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewRepoItem() {
    RepoItem(fakeRepoUiModelList.first()) {}
}