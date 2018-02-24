package jvk.org.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra("EXTRA_LEAGUE")
    }

    fun onBeginnerClicked(view: View) {
        toggleBaller.isChecked = false
        skill = "beginner"
        

    }

    fun onBallerClicked(view: View) {
        toggleBeginner.isChecked = false
        skill = "baller"

    }

    fun onFinishClicked(view: View) {
        if (skill != "") {
            val intent = Intent(this, FinishActivity::class.java)
            intent.putExtra("EXTRA_LEAGUE", league)
            intent.putExtra("EXTRA_SKILL", skill)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please select skill", Toast.LENGTH_SHORT).show()
        }
    }
}
