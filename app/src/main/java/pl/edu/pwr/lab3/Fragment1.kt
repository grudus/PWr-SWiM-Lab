package pl.edu.pwr.lab3


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import android.widget.RadioGroup


class Fragment1 : Fragment() {

    private lateinit var A1: AppCompatActivity
    private lateinit var sluchaczF1: OnWyborOpcjiListener

    private lateinit var radioGroup: RadioGroup

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_fragment1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        radioGroup = activity.findViewById(R.id.radio_grouo)
        radioGroup.setOnCheckedChangeListener { group, id ->
            val index = when (id) {
                R.id.radio_1 -> 1
                R.id.radio_2 -> 2
                else -> -1
            }
            sluchaczF1.onWyborOpcji(index)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            A1 = context as AppCompatActivity
            sluchaczF1 = context as OnWyborOpcjiListener
        } catch (e: ClassCastException) {
            throw ClassCastException(A1.toString() + " musi implementować OnWyborOpcjiListener!")
        }
    }
}// Required empty public constructor
