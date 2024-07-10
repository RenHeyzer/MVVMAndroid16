package com.ren.onlinestore.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ren.onlinestore.databinding.FragmentHomeBinding
import com.ren.onlinestore.ui.adapters.CatalogAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private var catalogAdapter: CatalogAdapter? = CatalogAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        showProducts()
    }

    private fun setupRecyclerView() {
        catalogAdapter?.let {
            binding.rvCatalog.adapter = it
        }
    }

    private fun showProducts() {
        viewModel.productsState.observe(viewLifecycleOwner) { state ->
            state?.let {
                it.success?.let { products ->
                    catalogAdapter?.submitList(products)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        catalogAdapter = null
        _binding = null
    }
}