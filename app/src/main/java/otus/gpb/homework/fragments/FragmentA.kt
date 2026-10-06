package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FragmentA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_a, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.openAA).setOnClickListener {
            childFragmentManager.commit {
                replace(R.id.childContainer, FragmentAA.create(ColorGenerator.generateColor()))
                addToBackStack(null)
            }
        }
    }
}
