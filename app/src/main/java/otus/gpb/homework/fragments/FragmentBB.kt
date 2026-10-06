package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentBB : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_bb, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.sendColor).setOnClickListener {
            parentFragmentManager.setFragmentResult(
                FragmentBA.RESULT_KEY,
                Bundle().apply { putInt(FragmentBA.RESULT_COLOR, ColorGenerator.generateColor()) }
            )
            if (resources.configuration.orientation != android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}
