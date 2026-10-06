package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FragmentBA : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_ba, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.setFragmentResultListener(RESULT_KEY, viewLifecycleOwner) { _, result ->
            view.setBackgroundColor(result.getInt(RESULT_COLOR))
        }

        val openButton = view.findViewById<Button>(R.id.openBB)
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        openButton.visibility = if (isLandscape) View.GONE else View.VISIBLE
        openButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragmentContainer, FragmentBB())
                addToBackStack(null)
            }
        }
    }

    companion object {
        const val RESULT_KEY = "fragment_color_result"
        const val RESULT_COLOR = "color"
    }
}
