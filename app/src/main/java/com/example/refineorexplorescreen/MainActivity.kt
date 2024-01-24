package com.example.refineorexplorescreen

// MainActivity.kt
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.refineorexplorescreen.R.id.nav_view
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager
    private val exploreFragment = ExploreFragment()

    private fun ExploreFragment(): Any {
        TODO("Not yet implemented")
    }

    private val refineFragment = RefineFragment()

    private fun RefineFragment(): Any {
        TODO("Not yet implemented")
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_explore -> {
                    replaceFragment(exploreFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_refine -> {
                    replaceFragment(refineFragment)
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(/* id = */ nav_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Default fragment to display when the app starts
        replaceFragment(exploreFragment)
    }

    private fun replaceFragment(fragment: Any) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment as Fragment)
        transaction.commit()
    }
}
