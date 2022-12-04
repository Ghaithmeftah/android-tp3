package ensio.ia2.tp3_basic_activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ensio.ia2.tp3_basic_activity.databinding.ActivityCallBinding
import ensio.ia2.tp3_basic_activity.databinding.ActivityMainBinding

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_call)
        val binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.button4.setOnClickListener {
           val m=binding.editTextPhone.text.toString()
           val uri=Uri.parse("tel: $m")
           val i=Intent(Intent.ACTION_DIAL,uri)
           startActivity(i)
       }

    }
}