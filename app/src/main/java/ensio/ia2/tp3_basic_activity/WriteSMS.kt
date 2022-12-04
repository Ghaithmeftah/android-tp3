package ensio.ia2.tp3_basic_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import ensio.ia2.tp3_basic_activity.databinding.ActivityConfirmSmsBinding
import ensio.ia2.tp3_basic_activity.databinding.ActivityWriteSmsBinding

class WriteSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_write_sms)
        val Binding = ActivityWriteSmsBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        val theLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_CANCELED){
                Toast.makeText(this,"operation cancelled",Toast.LENGTH_LONG).show()
            }
        }
        Binding.button.setOnClickListener {
            val num = Binding.editTextTextPersonName.text.toString()
            val m = Binding.editTextTextMultiLine.text.toString()
            val i = Intent(this,ConfirmSMS::class.java)
            i.putExtra("phone",num)
            i.putExtra("message",m)
            theLauncher.launch(i)
        }

    }
}