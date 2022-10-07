package com.neilkrishna.basicapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.neilkrishna.basicapplication.AddPeopleInfoActivity
import com.neilkrishna.basicapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        collectUIState()
        return binding.root
    }


    // var num=0;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.increment.setOnClickListener { view1 ->
            //The counter is being incremented by 1 each time it is pressed and the result is displayed.
            // num+=1;
            // binding.counter.text=num.toString();
            viewModel.increaseCountByOne()
        }

        binding.addPeople.setOnClickListener {
            val intent = Intent( this@HomeFragment.requireContext(), AddPeopleInfoActivity::class.java )
            startActivity(intent)
        }
    }

    private fun collectUIState () = lifecycleScope.launchWhenStarted {
        viewModel.uiState.collect { state ->
            binding.apply {
                counter.text = state.count.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}