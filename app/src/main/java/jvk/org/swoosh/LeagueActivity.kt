package jvk.org.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra("EXTRA_LEAGUE", selectedLeague)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Please select league", Toast.LENGTH_SHORT).show()
        }
    }

    fun onMenClicked(view: View) {
        toggleWomen.isChecked = false
        toggleCoed.isChecked = false
        selectedLeague = "mens"
    }

    fun onWomenClicked(view: View) {
        toggleMen.isChecked = false
        toggleCoed.isChecked = false
        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        toggleWomen.isChecked = false
        toggleMen.isChecked = false
        selectedLeague = "coed"
    }
}
