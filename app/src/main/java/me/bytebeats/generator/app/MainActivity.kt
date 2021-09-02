package me.bytebeats.generator.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import me.bytebeats.generator.impl.*
import me.bytebeats.generator.impl.bank.BankCardNumberGenerator

class MainActivity : AppCompatActivity() {
    private val name by lazy { findViewById<TextView>(R.id.name) }
    private val mobile by lazy { findViewById<TextView>(R.id.mobile) }
    private val id_card by lazy { findViewById<TextView>(R.id.id_card) }
    private val email by lazy { findViewById<TextView>(R.id.email) }
    private val bank_card by lazy { findViewById<TextView>(R.id.bank_card) }
    private val address by lazy { findViewById<TextView>(R.id.address) }
    private val generate by lazy { findViewById<Button>(R.id.generate) }

    private val nameGenerator by lazy { ChineseNameGenerator() }
    private val mobileGenerator by lazy { ChineseMobilePhoneNumberGenerator() }
    private val id_cardGenerator by lazy { ChineseIdCardGenerator() }
    private val emailGenerator by lazy { EmailAddressGenerator() }
    private val bank_cardGenerator by lazy { BankCardNumberGenerator() }
    private val addressGenerator by lazy { ChineseAddressGenerator() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generate.setOnClickListener {
            name.text = nameGenerator.generate()
            mobile.text = mobileGenerator.generate()
            id_card.text = id_cardGenerator.generate()
            email.text = emailGenerator.generate()
            bank_card.text = bank_cardGenerator.generate()
            address.text = addressGenerator.generate()
        }
    }
}