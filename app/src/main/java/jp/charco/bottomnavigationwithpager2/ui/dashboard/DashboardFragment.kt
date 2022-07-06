package jp.charco.bottomnavigationwithpager2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.charco.bottomnavigationwithpager2.databinding.FragmentDashboardBinding
import jp.charco.bottomnavigationwithpager2.ui.BottomNavContentFragment
import jp.charco.bottomnavigationwithpager2.ui.MyAdapter

class DashboardFragment : BottomNavContentFragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = (0..100).map { it.toString() }
        binding.recyclerView.adapter = MyAdapter(requireContext(), data) {}
        binding.recyclerView.adapter?.notifyDataSetChanged()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}