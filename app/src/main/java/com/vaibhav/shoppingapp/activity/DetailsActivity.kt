package com.vaibhav.shoppingapp.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vaibhav.shoppingapp.Adapter.ColorAdapter
import com.vaibhav.shoppingapp.Adapter.SizeAdapter
import com.vaibhav.shoppingapp.Adapter.SliderAdapter
import com.vaibhav.shoppingapp.Help.ManagmentCart
import com.vaibhav.shoppingapp.Model.ItemsModel
import com.vaibhav.shoppingapp.Model.SlideModel
import com.vaibhav.shoppingapp.databinding.ActivityDetailsBinding

class DetailsActivity:BaseActivity() {
    private lateinit var binding:ActivityDetailsBinding
    private lateinit var item:ItemsModel
    private var numberOrder = 1
    private lateinit var managmentCart: ManagmentCart
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        managmentCart = ManagmentCart(this)
        getBundle()
        banners()
        initLists()
    }

    private fun initLists() {
        val  sizeList = ArrayList<String>()
        for (size in item.size){
            sizeList.add(size.toString())
        }
        binding.sizeList.adapter = SizeAdapter(sizeList)
        binding.sizeList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val colorList = ArrayList<String>()
        for(imageUrl in item.picUrl){
            colorList.add(imageUrl)
        }
        binding.colorList.adapter = ColorAdapter(colorList)
        binding.colorList.layoutManager =LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun banners() {
        val sliderItems = ArrayList<SlideModel>()
        for (imageUrl in item.picUrl){
            sliderItems.add(SlideModel(imageUrl))
        }
        binding.slide.adapter = SliderAdapter(sliderItems,binding.slide)
        binding.slide.clipToPadding = false
        binding.slide.clipChildren = false
        binding.slide.offscreenPageLimit = 3
        binding.slide.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        if (sliderItems.size>1){
            binding.dotIndicator.visibility = View.VISIBLE
            binding.dotIndicator.attachTo(binding.slide)
        }
    }

    private fun getBundle() {
        item =intent.getParcelableExtra("object")!!

        binding.titleTxt.text = item.title
        binding.description.text = item.desription
        binding.pricetxt.text = "$"+item.price
        binding.ratingTxt.text ="${item.rating}Rating "
        binding.addToCart.setOnClickListener {
            item.numberInCart = numberOrder
            managmentCart.insertFood(item)
        }
        binding.back.setOnClickListener {
            finish()
        }
        binding.cartButton.setOnClickListener {

        }
    }
}