package com.firelord.pie.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.firelord.pie.R
import com.firelord.pie.databinding.FragmentProfileBinding
import com.firelord.pie.ui.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    // init firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        // init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        // handle onClickButton
        binding.btLogout.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

        return binding.root
    }

    private fun checkUser(){
        //check user is logged in or not
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser!=null){
            val email = firebaseUser.email
            // Set to textView
            binding.tvEmail.text = email
        } else {
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }
    }
}