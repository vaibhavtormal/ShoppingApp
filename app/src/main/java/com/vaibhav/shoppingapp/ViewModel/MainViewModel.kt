package com.vaibhav.shoppingapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vaibhav.shoppingapp.Model.BrandModel
import com.vaibhav.shoppingapp.Model.ItemsModel
import com.vaibhav.shoppingapp.Model.SlideModel

class MainViewModel() : ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _banner = MutableLiveData<List<SlideModel>>()
    private val _brand = MutableLiveData<MutableList<BrandModel>>()
    private val _popular = MutableLiveData<MutableList<ItemsModel>>()

    val brands: LiveData<MutableList<BrandModel>> = _brand
    val popular: LiveData<MutableList<ItemsModel>> = _popular
    val banners: LiveData<List<SlideModel>> = _banner

    fun loadBanners() {
        val Ref = firebaseDatabase.getReference("Banner")
        Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<SlideModel>()
                for (childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue(SlideModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _banner.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    fun loadBrand(){
        val Ref = firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val  lists = mutableListOf<BrandModel>()
                for (childSnapshot in snapshot.children){
                    val list= childSnapshot.getValue(BrandModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _brand.value = lists
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
    fun loadPopular(){
        val Ref = firebaseDatabase.getReference("Items")
        Ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val  lists = mutableListOf<ItemsModel>()
                for (childSnapshot in snapshot.children){
                    val list= childSnapshot.getValue(ItemsModel::class.java)
                    if (list!=null){
                        lists.add(list)
                    }
                }
                _popular.value = lists
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}