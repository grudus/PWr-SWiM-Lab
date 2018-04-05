package pl.edu.pwr.lab3


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 */
class Fragment11 : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        retainInstance = true;

        return inflater!!.inflate(R.layout.fragment_fragment11, container, false)
    }

}// Required empty public constructor
