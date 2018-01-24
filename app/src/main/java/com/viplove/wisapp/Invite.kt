package com.viplove.wisapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import kotlinx.android.synthetic.main.activity_invite.*


class Invite : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite)

        var InviteButton = findViewById<Button>(R.id.send_invite_button)

        InviteButton?.setOnClickListener({
            val emailIntent = Intent(android.content.Intent.ACTION_SEND)
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailText.text)
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "WisOpt Invite")
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "")
            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
        })
    }
}
