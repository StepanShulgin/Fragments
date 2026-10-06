package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentAB : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_ab, container, false).apply {
            setBackgroundColor(requireArguments().getInt(ARG_COLOR))
        }

    companion object {
        private const val ARG_COLOR = "color"
        fun create(color: Int) = FragmentAB().apply {
            arguments = Bundle().apply { putInt(ARG_COLOR, color) }
        }
    }
}
