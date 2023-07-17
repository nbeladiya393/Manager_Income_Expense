package com.example.manager_incomeexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.manager_incomeexpense.databinding.ActivityMainBinding
import com.example.manager_incomeexpense.fragment.addTransaction
import com.example.manager_incomeexpense.fragment.transaction_listFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottom.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId){

                    R.id.add->{
                        loadFragment(addTransaction())
                    }

                    R.id.list->{
                        loadFragment(transaction_listFragment())
                    }

                    R.id.home->{
                        loadFragment(Home_fragment())
                    }

                }

                return true
            }

        })
    }

    private fun loadFragment(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragFrame,fragment)
            .commit()
    }
}