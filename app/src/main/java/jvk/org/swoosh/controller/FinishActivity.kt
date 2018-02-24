package jvk.org.swoosh.controller

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jvk.org.swoosh.R
import jvk.org.swoosh.model.Player
import jvk.org.swoosh.utils.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        searchLeaguesText.text = getString(R.string.search_league, player.league, player.skill)
    }
}
