package com.example.fitmeets.front.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitmeets.back.Event
import com.example.fitmeets.back.EventStatus
import com.example.fitmeets.back.HomeViewController
import java.util.*


@Composable
fun EventCell(event: Event) {
    Box(
        modifier = Modifier
            .size(width = 200.dp, height = 100.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Image")
            Column {
                Text(text = "Event title")
                Text(text = "Status")
                Text(text = "Description")
            }
        }
    }

}


@Composable
fun HomeView() {
    val controller = HomeViewController.shared
    val events = controller.events

    LazyColumn {
        item {
            Text(text = "Recent Events")
        }
        items(events.size) { index ->
            EventCell(event = events[index])
        }

    }
}

@Composable
@Preview
fun EventCellPreview() {
    val event = Event("Event title", Date(), "",  EventStatus.ACTIVE)
    EventCell(event = event)

}

@Composable
@Preview(showBackground = true)
fun HomePreview() {

    HomeView()
}