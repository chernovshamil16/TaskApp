package com.example.taskapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskapp.R
import com.example.taskapp.data.Task
import com.example.taskapp.databinding.FragmentHomeBinding
import com.example.taskapp.ui.home.HomeFragment.Companion.TASK
import com.example.taskapp.ui.task.TaskAdapter
import com.example.taskapp.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }
        setFragmentResultListener(
            TASK
        ){
                _, result ->
            val task = result.getSerializable("keetask")as Task
            adapter.addTask(task)
            binding.taskRecycler.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{
        const val TASK = "key.list"
        const val NOTE = "key.live"
    }
}