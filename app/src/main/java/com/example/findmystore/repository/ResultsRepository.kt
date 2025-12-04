package com.example.findmystore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.findmystore.domain.CategoryModel
import com.example.findmystore.domain.StoreModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class ResultsRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadSubCategory(id : String) : LiveData<MutableList<CategoryModel>> {
        val listdata = MutableLiveData<MutableList<CategoryModel>>()
        val refs = firebaseDatabase.getReference("SubCategory")
        val query: Query = refs.orderByChild("CategoryId").equalTo(id)
        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<CategoryModel>()
                for (child in snapshot.children){
                    val model = child.getValue(CategoryModel::class.java)
                    if (model != null){
                        lists.add(model)
                    }
                }
                listdata.value = lists

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return listdata
    }



    fun loadPopular(id : String) : LiveData<MutableList<StoreModel>> {
        val listdata = MutableLiveData<MutableList<StoreModel>>()
        val refs = firebaseDatabase.getReference("Stores")
        val query: Query = refs.orderByChild("CategoryId").equalTo(id)
        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<StoreModel>()
                for (child in snapshot.children){
                    val model = child.getValue(StoreModel::class.java)
                    if (model != null){
                        lists.add(model)
                    }
                }
                listdata.value = lists

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return listdata
    }

    fun loadNearest(id : String) : LiveData<MutableList<StoreModel>> {
        val listdata = MutableLiveData<MutableList<StoreModel>>()
        val refs = firebaseDatabase.getReference("Nearest")
        val query: Query = refs.orderByChild("CategoryId").equalTo(id)
        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<StoreModel>()
                for (child in snapshot.children){
                    val model = child.getValue(StoreModel::class.java)
                    if (model != null){
                        lists.add(model)
                    }
                }
                listdata.value = lists

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return listdata
    }
}