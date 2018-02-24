package jvk.org.swoosh.controller

import android.content.Intent
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.common.Scopes
import com.google.firebase.auth.FirebaseAuth
import jvk.org.swoosh.R
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : BaseActivity() {
    private val RC_SIGN_IN = 123
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        getStartedBtn.setOnClickListener {
            val providers: MutableList<AuthUI.IdpConfig> = mutableListOf()
            providers.add(AuthUI.IdpConfig.GoogleBuilder().setScopes(mutableListOf(Scopes.EMAIL, Scopes.PROFILE)).build())
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(), RC_SIGN_IN)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
            finish()
            return
        }
    }

    override fun onResume() {
        super.onResume()
        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
            finish()
            return
        }
    }
}
