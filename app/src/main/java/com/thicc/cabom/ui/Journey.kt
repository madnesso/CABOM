package com.thicc.cabom.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.library.NavigationBar
import com.library.NvTab
import com.thicc.cabom.R
import com.thicc.cabom.data.VideoAndProgressBarInterface
import kotlinx.android.synthetic.main.activity_journey.*


class Journey : AppCompatActivity(), VideoAndProgressBarInterface {
    val API_KEY: String = "AIzaSyAyWPr7PEAZOl--NFYAgf5g8vVqevxAy6Q"
    val VIDEO_ID: String = "XUhVCoTsBaM"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey)
        val bar = navBar as NavigationBar
        bar.onTabSelected = this
        bar.onTabClick = this
        bar.tabCount = 5
        bar.animateView(3000)
        val pos = 1
        bar.currentPosition = pos
        playerView.initialize(API_KEY, this)

    }

    override fun onTabSelected(touchPosition: Int, prev: NvTab?, nvTab: NvTab?) {
        TODO("Not yet implemented")
    }

    override fun onTabClick(touchPosition: Int, prev: NvTab?, nvTab: NvTab?) {
        TODO("Not yet implemented")
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        p1?.setPlayerStateChangeListener(this)
        p1?.setPlaybackEventListener(this)
        if (!p2) {
            p1?.cueVideo(VIDEO_ID)
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        TODO("Not yet implemented")
    }

    override fun onSeekTo(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun onBuffering(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onPlaying() {
        TODO("Not yet implemented")
    }

    override fun onStopped() {
        TODO("Not yet implemented")
    }

    override fun onPaused() {
        TODO("Not yet implemented")
    }

    override fun onAdStarted() {
        TODO("Not yet implemented")
    }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onVideoStarted() {
        TODO("Not yet implemented")
    }

    override fun onLoaded(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onVideoEnded() {
        TODO("Not yet implemented")
    }

    override fun onError(p0: YouTubePlayer.ErrorReason?) {
        TODO("Not yet implemented")
    }
}