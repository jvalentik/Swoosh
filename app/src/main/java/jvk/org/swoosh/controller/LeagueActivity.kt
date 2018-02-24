package jvk.org.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jvk.org.swoosh.R
import jvk.org.swoosh.model.Player
import jvk.org.swoosh.utils.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState !== null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Please select league", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMenClicked(view: View) {
        toggleWomen.isChecked = false
        toggleCoed.isChecked = false
        player.league = "mens"
    }

    fun onWomenClicked(view: View) {
        toggleMen.isChecked = false
        toggleCoed.isChecked = false
        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        toggleWomen.isChecked = false
        toggleMen.isChecked = false
        player.league = "coed"
    }
}
