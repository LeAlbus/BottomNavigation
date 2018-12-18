package br.com.lopes.pedro.bottomnavigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {

                this.changeFragment("Home")

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                this.changeFragment("Dashboard")

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                this.changeFragment("Notification")

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.changeFragment("Mario")

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val fragmentManager = supportFragmentManager

        if (fragmentManager.backStackEntryCount > 0){
            fragmentManager.popBackStack()
        }

    }

    private fun changeFragment(text: String){
        val ft = supportFragmentManager.beginTransaction()
        val fragment = BlankFragment.newInstance(text)

        ft.replace(R.id.flContainer, fragment)
        ft.addToBackStack(null)//Adiciona ao Stack para o botão voltar do Android

        ft.commit()

    }
}
