package ru.coffeetrail.drond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import ru.coffeetrail.drond.databinding.ActivityMainBinding
import ru.coffeetrail.grou.ui.archive.ArchiveFragment
import ru.coffeetrail.grou.ui.event.EventFragment
import ru.coffeetrail.grou.ui.info.InfoFragment
import ru.coffeetrail.grou.ui.login.LoginFragment
import ru.coffeetrail.grou.ui.notes.NotesFragment
import ru.coffeetrail.grou.ui.protected_notes.ProtectedNotesFragment
import ru.coffeetrail.grou.ui.question.QuestionFragment
import ru.coffeetrail.grou.ui.register.RegisterFragment
import ru.coffeetrail.grou.ui.settings.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            it.isCheckable = true

            when(it.itemId){

                R.id.nav_notes -> replaceFragment(NotesFragment(), it.title.toString())
                R.id.nav_protected_notes -> replaceFragment(ProtectedNotesFragment(), it.title.toString())
                R.id.nav_event -> replaceFragment(EventFragment(), it.title.toString())
                R.id.nav_archive -> replaceFragment(ArchiveFragment(), it.title.toString())
                R.id.nav_login -> replaceFragment(LoginFragment(), it.title.toString())
                R.id.nav_register -> replaceFragment(RegisterFragment(), it.title.toString())
                R.id.nav_question -> replaceFragment(QuestionFragment(), it.title.toString())
                R.id.nav_settings -> replaceFragment(SettingsFragment(), it.title.toString())
                R.id.nav_info -> replaceFragment(InfoFragment(), it.title.toString())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, title : String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true

        }
        return super.onOptionsItemSelected(item)
    }
}