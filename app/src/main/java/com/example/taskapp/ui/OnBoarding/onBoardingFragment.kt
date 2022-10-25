package com.example.taskapp.ui.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp.local.PrefOnBoarding
import com.example.taskapp.databinding.OnBoardingFragmentBinding

class onBoardingFragment: Fragment() {
    private lateinit var pref: PrefOnBoarding

    private lateinit var binding:OnBoardingFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OnBoardingFragmentBinding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = PrefOnBoarding(requireContext())
        val adapter=onBoardingAdapter{
            pref.saveOnBoardingShow(true)
            findNavController().navigateUp()
        }
        binding.viewPager.adapter = adapter
        binding.wormDotsIndicator.setViewPager2(binding.viewPager)

    }
}