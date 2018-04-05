package pl.edu.pwr.lab3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar

class TabActivity : AppCompatActivity(), ActionBar.TabListener {
    private lateinit var fragment11: Fragment11

    private lateinit var fragment12: Fragment12
    private lateinit var transaction: FragmentTransaction

    private val TAG_F11 = "Fragment11"
    private val TAG_F12 = "Fragment12"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        if (savedInstanceState == null) {

            fragment11 = Fragment11()
            fragment12 = Fragment12()

            transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.kontener2, fragment11, TAG_F11)
            transaction.detach(fragment11)
            transaction.add(R.id.kontener2, fragment12, TAG_F12)
            transaction.detach(fragment12)
            transaction.commit()
        }

        else {
            fragment11 = supportFragmentManager.findFragmentByTag(TAG_F11) as Fragment11
            fragment12 = supportFragmentManager.findFragmentByTag(TAG_F12) as Fragment12
        }

        val actionBar = supportActionBar
        actionBar?.navigationMode = ActionBar.NAVIGATION_MODE_TABS;

        val tab = actionBar?.newTab()
        tab?.text = "Jakiś tekst"
        tab?.setTabListener(this)
        actionBar?.addTab(tab)

        val tab2 = actionBar?.newTab()
        tab2?.text = "Jakiś tekst"
        tab2?.setTabListener(this)
        actionBar?.addTab(tab2)

    }


    override fun onTabReselected(tab: ActionBar.Tab, ft: FragmentTransaction) {}

    override fun onTabUnselected(tab: ActionBar.Tab, ft: FragmentTransaction) {
        val position = tab.position
        when (position) {
            0 -> ft.detach(fragment11)
            1 -> ft.detach(fragment12)
        }
    }


    override fun onTabSelected(tab: ActionBar.Tab, ft: FragmentTransaction) {
        val position = tab.position
        when (position) {
            0 -> ft.attach(fragment11)
            1 -> ft.attach(fragment12)
        }
    }


}
