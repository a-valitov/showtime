package com.avalitov.showtime.pages.populars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.avalitov.showtime.R
import com.avalitov.showtime.common.extensions.asString
import com.avalitov.showtime.databinding.FragmentPopularsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PopularsFragment : Fragment() {

    private lateinit var binding: FragmentPopularsBinding
    private val viewModel by viewModel<PopularsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPopularsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
        setUpSubscriptions()
    }

    private fun setUpUI() {
        binding.buttonTest.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_popularsFragment_to_favoritesFragment)
        }
    }

    private fun setUpSubscriptions() {
        viewModel.timeState.observe(viewLifecycleOwner) {
            binding.textHello.text = it.asString()
        }
    }
}