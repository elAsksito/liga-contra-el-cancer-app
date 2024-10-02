package com.ask.liga_contra_el_cancer_app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ask.liga_contra_el_cancer_app.R
import com.ask.liga_contra_el_cancer_app.fragments.AppointmentFragment
import com.ask.liga_contra_el_cancer_app.fragments.HomeFragment
import com.ask.liga_contra_el_cancer_app.fragments.ProfileFragment
import com.ask.liga_contra_el_cancer_app.fragments.SearchFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation


class ContainerActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        onClickBottomNavigation()
    }

    private fun createBottomNavigation(): CurvedBottomNavigation{
        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottom_navigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1, "Inicio", R.drawable.home)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2, "Buscar", R.drawable.search)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(3, "Citas", R.drawable.calendar)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(4, "Perfil", R.drawable.profile)
        )

        return bottomNavigation
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun onClickBottomNavigation(){
        val bottomNavigation = createBottomNavigation()

        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment())
                }
                2 -> {
                    replaceFragment(SearchFragment())
                }
                3 -> {
                    replaceFragment(AppointmentFragment())
                }
                4 -> {
                    replaceFragment(ProfileFragment())
                }
            }
        }

        replaceFragment(HomeFragment())
        bottomNavigation.show(1)
    }
}