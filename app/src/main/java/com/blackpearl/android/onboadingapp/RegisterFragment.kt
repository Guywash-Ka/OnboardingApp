package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.*
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class RegisterFragment : Fragment() {

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        disableNavigation(requireActivity())

        val registerButton: Button = requireActivity().findViewById(R.id.registerButton)
        val nameEditText: EditText = requireActivity().findViewById(R.id.editTextTextPersonName)

        registerButton.setOnClickListener {
            if (!TextUtils.isEmpty(nameEditText.text.toString())) {
                mainActivityViewModel.setName(nameEditText.text.toString())
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        enableNavigation(requireActivity())
    }

    private fun disableNavigation(activity: FragmentActivity) {
        val bottomNavView: BottomNavigationView = activity.findViewById(R.id.bottomNavigation)
        val drawerLayout: DrawerLayout = activity.findViewById(R.id.drawer_layout)
        val toolbar: Toolbar = activity.findViewById(R.id.toolbar)

        drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
        toolbar.visibility = View.GONE
        bottomNavView.visibility = View.GONE
    }

    private fun enableNavigation(activity: FragmentActivity) {
        val bottomNavView: BottomNavigationView = activity.findViewById(R.id.bottomNavigation)
        val drawerLayout: DrawerLayout = activity.findViewById(R.id.drawer_layout)
        val toolbar: Toolbar = activity.findViewById(R.id.toolbar)

        drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED)
        toolbar.visibility = View.VISIBLE
        bottomNavView.visibility = View.VISIBLE
    }

}