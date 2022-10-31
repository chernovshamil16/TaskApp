package com.example.taskapp.ui.task

import com.example.taskapp.data.Task
import com.example.taskapp.ui.home.HomeFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class TaskFragment : Fragment() {
    private  lateinit var binding:com.example.taskapp.databinding.FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = com.example.taskapp.databinding.FragmentTaskBinding.inflate(layoutInflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener{
            val task = Task(
                title = binding.edTitle.toString(),
                desc = binding.edDesc.toString()
            )
            setFragmentResult(
                HomeFragment.TASK , bundleOf("key_task" to task)
            )
            findNavController().navigateUp()
        }

    }

}