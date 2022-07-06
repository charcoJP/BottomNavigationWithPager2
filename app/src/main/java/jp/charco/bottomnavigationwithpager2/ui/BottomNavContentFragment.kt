package jp.charco.bottomnavigationwithpager2.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BottomNavContentFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("@@@", "${this::class.simpleName}: onCreate: $savedInstanceState")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("@@@", "${this::class.simpleName}: onCreateView: $savedInstanceState")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("@@@", "${this::class.simpleName}: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("@@@", "${this::class.simpleName}: onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("@@@", "${this::class.simpleName}: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("@@@", "${this::class.simpleName}: onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("@@@", "${this::class.simpleName}: onDestroyView")
    }
}