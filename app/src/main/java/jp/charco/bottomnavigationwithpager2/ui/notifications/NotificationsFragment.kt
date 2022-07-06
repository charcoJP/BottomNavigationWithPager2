package jp.charco.bottomnavigationwithpager2.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import jp.charco.bottomnavigationwithpager2.databinding.FragmentNotificationsBinding
import jp.charco.bottomnavigationwithpager2.ui.BottomNavContentFragment
import jp.charco.bottomnavigationwithpager2.ui.BottomNavigationFragmentDirections
import jp.charco.bottomnavigationwithpager2.ui.MyAdapter

class NotificationsFragment : BottomNavContentFragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = (0..100).map { it.toString() }
        binding.recyclerView.adapter = MyAdapter(requireContext(), data) {
            findNavController().navigate(
                BottomNavigationFragmentDirections.actionBottomNavigationFragmentToDetailFragment(1)
            )
        }
        binding.recyclerView.adapter?.notifyDataSetChanged()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}