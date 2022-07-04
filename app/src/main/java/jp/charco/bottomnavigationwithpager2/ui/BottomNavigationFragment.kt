package jp.charco.bottomnavigationwithpager2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import jp.charco.bottomnavigationwithpager2.R
import jp.charco.bottomnavigationwithpager2.databinding.FragmentBottomNavBinding
import jp.charco.bottomnavigationwithpager2.ui.dashboard.DashboardFragment
import jp.charco.bottomnavigationwithpager2.ui.home.HomeFragment
import jp.charco.bottomnavigationwithpager2.ui.notifications.NotificationsFragment

class BottomNavigationFragment : Fragment() {

    private var _binding: FragmentBottomNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pager.adapter = BottomNavigationPagerAdapter(requireActivity())
        binding.pager.isUserInputEnabled = false

        binding.navView.setOnItemSelectedListener {
            val currentItem =
                when(it.itemId) {
                    R.id.navigation_home -> 0
                    R.id.navigation_dashboard -> 1
                    else -> 2
                }
            binding.pager.setCurrentItem(currentItem, false)
            return@setOnItemSelectedListener true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


class BottomNavigationPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            else -> NotificationsFragment()
        }
    }
}