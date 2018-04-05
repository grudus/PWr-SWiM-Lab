package pl.edu.pwr.lab3


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class Fragment12 : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        retainInstance = true
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_fragment12, container, false)
    }

}// Required empty public constructor
