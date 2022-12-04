package ensio.ia2.tp3_basic_activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ensio.ia2.tp3_basic_activity.databinding.ActivityConfirmSmsBinding

class ConfirmSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_confirm_sms)
        val binding = ActivityConfirmSmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val n = intent.getStringExtra("phone")
        val msg=intent.getStringExtra("message")
        binding.editTextTextPersonName2.setText(n)
        binding.editTextTextMultiLine2.setText(msg)
        binding.button3.setOnClickListener {
            finish()
            setResult(RESULT_CANCELED)
        }
        binding.button2.setOnClickListener {
            val n = binding.editTextTextPersonName2.text.toString()
            val msg=binding.editTextTextMultiLine2.text.toString()
            //pour les émulateurs on utilise 5556
            val uri = Uri.parse("smsto:$n?body=$msg")
            val i = Intent(Intent.ACTION_SENDTO,uri)
            startActivity(i)
            setResult(RESULT_OK)
        }


    }
}