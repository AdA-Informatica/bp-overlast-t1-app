package nl.paulkros.safespace

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope;
import kotlinx.coroutines.launch;
import nl.paulkros.safespace.controllers.DatabaseController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sets status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.statusBarColor = Color.TRANSPARENT
        }

        lifecycleScope.launch() {
            val dc = DatabaseController()
            println(dc.countGemeentes().toString());
            dc.close()
        }
    }

}