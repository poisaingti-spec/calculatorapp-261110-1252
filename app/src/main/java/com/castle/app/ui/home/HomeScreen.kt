package com.castle.app.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.castle.app.data.model.Video
import com.castle.app.ui.components.VideoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onVideoClick: (String) -> Unit,
    onSearchClick: () -> Unit,
    onWatchlistClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Castle") },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = onSettingsClick) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = { Icon(Icons.Default.Star, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = onWatchlistClick,
                    icon = { Icon(Icons.Default.Star, contentDescription = "Watchlist") },
                    label = { Text("Watchlist") }
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Trending Now",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    items(getTrendingVideos()) { video ->
                        VideoCard(
                            video = video,
                            onClick = { onVideoClick(video.id) }
                        )
                    }
                }
            }
            
            item {
                Text(
                    text = "New Releases",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    items(getNewReleases()) { video ->
                        VideoCard(
                            video = video,
                            onClick = { onVideoClick(video.id) }
                        )
                    }
                }
            }
            
            item {
                Text(
                    text = "Continue Watching",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    items(getContinueWatching()) { video ->
                        VideoCard(
                            video = video,
                            onClick = { onVideoClick(video.id) }
                        )
                    }
                }
            }
        }
    }
}

// Sample data - Replace with actual API calls
fun getTrendingVideos() = listOf(
    Video("1", "Action Movie 1", "Description 1", "https://example.com/thumb1.jpg", 120),
    Video("2", "Action Movie 2", "Description 2", "https://example.com/thumb2.jpg", 135),
    Video("3", "Action Movie 3", "Description 3", "https://example.com/thumb3.jpg", 110),
    Video("4", "Action Movie 4", "Description 4", "https://example.com/thumb4.jpg", 145)
)

fun getNewReleases() = listOf(
    Video("5", "Drama Movie 1", "Description 5", "https://example.com/thumb5.jpg", 125),
    Video("6", "Drama Movie 2", "Description 6", "https://example.com/thumb6.jpg", 130),
    Video("7", "Drama Movie 3", "Description 7", "https://example.com/thumb7.jpg", 115),
    Video("8", "Drama Movie 4", "Description 8", "https://example.com/thumb8.jpg", 140)
)

fun getContinueWatching() = listOf(
    Video("9", "Series S1E1", "Description 9", "https://example.com/thumb9.jpg", 45),
    Video("10", "Series S1E2", "Description 10", "https://example.com/thumb10.jpg", 45),
    Video("11", "Series S1E3", "Description 11", "https://example.com/thumb11.jpg", 45)
)