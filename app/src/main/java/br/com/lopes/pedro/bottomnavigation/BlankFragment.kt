package br.com.lopes.pedro.bottomnavigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val tvText = view.findViewById<TextView>(R.id.tvText)

        tvText.text = arguments?.getString("text")

        return view
    }

    companion object {

        fun newInstance(text: String): BlankFragment {

            val fragment = BlankFragment()
            val bundle = Bundle()

            bundle.putString("text", text)

            fragment.arguments = bundle

            return fragment
        }
    }

}
