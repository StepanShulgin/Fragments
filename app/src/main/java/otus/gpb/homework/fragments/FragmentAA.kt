package otus.gpb.homework.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FragmentAA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_a_child, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.setBackgroundColor(requireArguments().getInt(ARG_COLOR))
        view.findViewById<Button>(R.id.openAB).setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.childContainer, FragmentAB.create(ColorGenerator.generateColor()))
                addToBackStack(null)
            }
        }
    }

    companion object {
        private const val ARG_COLOR = "color"
        fun create(color: Int) = FragmentAA().apply {
            arguments = Bundle().apply { putInt(ARG_COLOR, color) }
        }
    }
}
