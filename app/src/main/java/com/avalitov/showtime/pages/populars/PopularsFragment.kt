package com.avalitov.showtime.pages.populars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.avalitov.showtime.R
import com.avalitov.showtime.databinding.FragmentPopularsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PopularsFragment : Fragment() {

    private lateinit var binding: FragmentPopularsBinding
    private val viewModel by viewModel<PopularsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        viewModel.rates.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.textHello.text = it.toString()
            } else {
                // TODO: Toast "Could not download exchange rates from server."
            }
        }
    }
}