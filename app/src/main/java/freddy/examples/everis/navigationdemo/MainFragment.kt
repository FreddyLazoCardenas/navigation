package freddy.examples.everis.navigationdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Sending data from one fragment to another fragment
        buttonWelcomeMe.setOnClickListener {

            val name = enterName.text.toString()
            if (name.isEmpty()) {
                enterName.error = "Please enter a name"
            } else {

                val amount = enterName.text.toString().toInt()
                val action = MainFragmentDirections.confirmAction()
                action.setMyArg(amount)
                findNavController().navigate(action)
            }
        }
    }

}

