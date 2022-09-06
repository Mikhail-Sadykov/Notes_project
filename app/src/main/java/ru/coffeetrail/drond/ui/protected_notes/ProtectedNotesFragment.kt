package ru.coffeetrail.grou.ui.protected_notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.coffeetrail.drond.databinding.FragmentProtectedNotesBinding

class ProtectedNotesFragment : Fragment() {

    private var _binding: FragmentProtectedNotesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val protectednotesViewModel =
            ViewModelProvider(this).get(ProtectedNotesViewModel::class.java)

        _binding = FragmentProtectedNotesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textProtectedNotes
        protectednotesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}