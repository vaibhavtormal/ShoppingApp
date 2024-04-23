package com.vaibhav.shoppingapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.vaibhav.shoppingapp.Model.ItemsModel
import com.vaibhav.shoppingapp.activity.DetailsActivity
import com.vaibhav.shoppingapp.databinding.ViewHolderRecommendentBinding

class PopularAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    private var context: Context? = null

    class ViewHolder(val binding: ViewHolderRecommendentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.ViewHolder {
        context = parent.context
        val binding =
            ViewHolderRecommendentBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PopularAdapter.ViewHolder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.pricetxt.text = "$" + items[position].price.toString()
        holder.binding.ratingTxt.text = items[position].rating.toString()

        val requestOption = RequestOptions().transform(CenterCrop())
        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .apply(requestOption)
            .into(holder.binding.pic)

             holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
                 intent.putExtra("object",items[position])
                 holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size
}