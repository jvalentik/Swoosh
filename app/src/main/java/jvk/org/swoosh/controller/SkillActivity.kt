package jvk.org.swoosh.controller

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Toast
import jvk.org.swoosh.R
import jvk.org.swoosh.model.Player
import jvk.org.swoosh.utils.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState !== null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onBeginnerClicked(view: View) {
        toggleBaller.isChecked = false
        player.skill = "beginner"
        

    }

    fun onBallerClicked(view: View) {
        toggleBeginner.isChecked = false
        player.skill = "baller"
    }

    fun onFinishClicked(view: View) {
        if (player.skill != "") {
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra(EXTRA_PLAYER, player)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please select skill", Toast.LENGTH_SHORT).show()
        }
    }
}
