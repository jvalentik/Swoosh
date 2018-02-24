package jvk.org.swoosh

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra("EXTRA_LEAGUE")
        val skill = intent.getStringExtra("EXTRA_SKILL")
        searchLeaguesText.text = getString(R.string.search_league, league, skill)
    }
}
