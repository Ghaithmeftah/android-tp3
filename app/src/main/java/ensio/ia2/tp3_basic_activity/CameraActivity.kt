package ensio.ia2.tp3_basic_activity

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import androidx.activity.result.contract.ActivityResultContracts
import ensio.ia2.tp3_basic_activity.databinding.ActivityCameraBinding
import java.util.BitSet

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_camera)
        val binding=ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val theLancher= registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode== RESULT_OK){
                val imageBitmap=it.data?.extras?.get("data") as Bitmap
                binding.imageView.setImageBitmap(imageBitmap)
            }
        }
        binding.button5.setOnClickListener {
            val picture =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            theLancher.launch(picture)
        }

    }
}