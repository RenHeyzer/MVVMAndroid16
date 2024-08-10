package com.ren.onlinestore.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ren.onlinestore.databinding.ItemProductBinding
import com.ren.onlinestore.models.Product
import com.ren.onlinestore.utils.loadImage

class CatalogAdapter: ListAdapter<Product, CatalogAdapter.ProductViewHolder>(CatalogDiffUtil()) {

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) = with(binding) {
            ivProductCover.loadImage(product.image)
            tvProductPrice.text = product.price.toString()
            tvProductFirm.text = product.firm
            tvProductBody.text = product.description
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class CatalogDiffUtil: DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}