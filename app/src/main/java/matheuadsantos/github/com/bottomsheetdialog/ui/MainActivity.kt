package matheuadsantos.github.com.bottomsheetdialog.ui

import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import matheuadsantos.github.com.bottomsheetdialog.R
import matheuadsantos.github.com.bottomsheetdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSampleOne.setOnClickListener {
                showDialogBS()
            }
        }
    }


    fun showDialogBS() {
        val dialogBottomSheet = BottomSheetDialog(this)
        dialogBottomSheet.setContentView(R.layout.dialog_bottomsheet)

        val buttonEdit = dialogBottomSheet.findViewById<RelativeLayout>(R.id.relativeLayoutEdit)
        val buttonDelete = dialogBottomSheet.findViewById<RelativeLayout>(R.id.relativeLayoutDelete)
        val buttonAdd = dialogBottomSheet.findViewById<RelativeLayout>(R.id.relativeLayoutAdd)

        var elavationEdit = 9.toFloat()
        var elevationDelete = 9.toFloat()
        var elevationAdd = 9.toFloat()

        buttonEdit?.setOnClickListener {
            showMessage("Clicked on Edit")
            it.elevation = elavationEdit
            buttonDelete?.elevation = 0.toFloat()
            buttonAdd?.elevation = 0.toFloat()
//            it.setBackgroundColor(getColor(R.color.black))
        }
        buttonDelete?.setOnClickListener {
            showMessage("Clicked on Delete")
            it.elevation = elevationDelete
            buttonEdit?.elevation = 0.toFloat()
            buttonAdd?.elevation = 0.toFloat()
//            it.setBackgroundColor(getColor(R.color.black))
        }
        buttonAdd?.setOnClickListener {
            showMessage("Clicked on Add")
            it.elevation = elevationAdd
            buttonDelete?.elevation = 0.toFloat()
            buttonEdit?.elevation = 0.toFloat()
//            it.setBackgroundColor(getColor(R.color.black))
        }

        dialogBottomSheet.show()
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}