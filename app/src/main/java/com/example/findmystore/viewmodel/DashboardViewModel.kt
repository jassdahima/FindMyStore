package com.example.findmystore.viewmodel

import androidx.lifecycle.LiveData
import com.example.findmystore.domain.BannerModel
import com.example.findmystore.domain.CategoryModel

class DashboardViewModel {

    private val repository = DashboardViewModel()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadBanner() : LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }
}