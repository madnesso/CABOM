package com.thicc.cabom.data

import com.google.android.youtube.player.YouTubePlayer
import com.library.NavigationBar

interface VideoAndProgressBarInterface : NavigationBar.OnTabSelected, NavigationBar.OnTabClick,
    YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener,
    YouTubePlayer.PlayerStateChangeListener
