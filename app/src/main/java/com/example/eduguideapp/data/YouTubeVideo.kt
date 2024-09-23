package com.example.eduguideapp.data

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun YouTubeVideo(
    YouTuberId :String,
    lifecycleOwner : LifecycleOwner
){
    var shouldPlay by remember {
        mutableStateOf(false)
    }
   AndroidView(
       modifier = Modifier
           .padding(16.dp)
           .clip(RoundedCornerShape(16.dp))
           .fillMaxWidth()
           .height(180.dp).clickable { shouldPlay = !shouldPlay },
       factory ={context ->
           YouTubePlayerView(context=context).apply {
               lifecycleOwner.lifecycle.addObserver(this)
               addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                   override fun onReady(youTubePlayer: YouTubePlayer) {
                       youTubePlayer.loadVideo(YouTuberId,0f)
                       if (shouldPlay) {
                           youTubePlayer.play()
                       } else {
                           youTubePlayer.pause()
                       }
                   }
               })
           }

       }

   )
}

