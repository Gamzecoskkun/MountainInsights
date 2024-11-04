package com.gamzecoskun.mountaininsights.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gamzecoskun.mountaininsights.model.Mountain
import com.gamzecoskun.mountaininsights.model.mountains
import com.skydoves.orbital.Orbital
import com.skydoves.orbital.animateBounds

@Composable
fun ListScreen() {
    Orbital {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            items(
                items = mountains,
                key = { it.title }
            ) { mountain ->
                MountainListItem(mountain)
            }
        }
    }
}

@Composable
fun MountainListItem(mountain: Mountain) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    AnimatedVisibility(
        visibleState = remember { MutableTransitionState(false).apply { targetState = true } },
        enter = fadeIn(tween(durationMillis = 300)),
        exit = fadeOut(tween(durationMillis = 300))
    ) {
        Orbital(
            modifier = Modifier
                .fillMaxWidth()
                .clickableWithoutRipple { expanded = !expanded }
        ) {
            if (expanded) {
                ExpandedMountainContent(mountain)
            } else {
                CollapsedMountainContent(mountain)
            }
        }
    }
}

@Composable
fun ExpandedMountainContent(mountain: Mountain) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(10.dp))
    ) {
        MountainImage(mountain.image, expanded = true)
        MountainText(mountain.title, mountain.description, expanded = true)
    }
}

@Composable
fun CollapsedMountainContent(mountain: Mountain) {
    Row {
        MountainImage(mountain.image, expanded = false)
        MountainText(mountain.title, mountain.description, expanded = false)
    }
}

@Composable
fun MountainImage(imageUrl: String, expanded: Boolean) {
    AsyncImage(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .animateBounds(
                modifier = if (expanded) Modifier.fillMaxWidth() else Modifier.size(100.dp),
                sizeAnimationSpec = tween(durationMillis = 300),
                positionAnimationSpec = tween(durationMillis = 300)
            ),
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = "Mountain Image",
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun MountainText(title: String, description: String, expanded: Boolean) {
    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .padding(horizontal = if (expanded) 20.dp else 10.dp)
            .animateBounds(
                sizeAnimationSpec = tween(durationMillis = 300),
                positionAnimationSpec = tween(durationMillis = 300)
            )
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Medium,
            maxLines = if (expanded) 2 else 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = if (expanded) 10 else 2,
            overflow = TextOverflow.Clip
        )
    }
}

fun Modifier.clickableWithoutRipple(
    onClick: () -> Unit
): Modifier = composed {
    this.then(
        Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        )
    )
}
