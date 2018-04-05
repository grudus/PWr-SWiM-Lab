package pl.edu.pwr.lab3

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity(), OnWyborOpcjiListener {
    private lateinit var fragment11: Fragment11
    private lateinit var fragment12: Fragment12
    private lateinit var transaction: FragmentTransaction

    private val TAG_F11 = "Fragmentxx11"
    private val TAG_F12 = "Fragmentxx12"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {

            fragment11 = Fragment11()
            fragment12 = Fragment12()

            transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.kontener, fragment11, TAG_F11)
            transaction.detach(fragment11)
            transaction.add(R.id.kontener, fragment12, TAG_F12)
            transaction.detach(fragment12)
            transaction.commit()
        }

        else {
            fragment11 = supportFragmentManager.findFragmentByTag(TAG_F11) as Fragment11
            fragment12 = supportFragmentManager.findFragmentByTag(TAG_F12) as Fragment12
        }

    }

    override fun onWyborOpcji(opcja: Int) {
        val transakcja = supportFragmentManager.beginTransaction()
        when(opcja) {
            1 -> {
                transakcja.detach(fragment12)
                transakcja.attach(fragment11)
            }
            2 -> {
                transakcja.detach(fragment11)
                transakcja.attach(fragment12)
            }
        }
        transakcja.commit()
    }


    fun openTabActivity(view: View) {
        startActivity(Intent(this, TabActivity::class.java))
    }
}
