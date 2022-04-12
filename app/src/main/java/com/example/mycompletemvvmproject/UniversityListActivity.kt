package com.example.mycompletemvvmproject

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycompletemvvmproject.adapters.CounryUniversitiesAdapter
import com.example.mycompletemvvmproject.databinding.ActivityUniversityListBinding
import com.example.mycompletemvvmproject.viewmodel.UniversitiesViewModel

class UniversityListActivity : BaseActivity<ActivityUniversityListBinding,UniversitiesViewModel>() {

    lateinit var mViewmodel: UniversitiesViewModel
    lateinit var counryUniversitiesAdapter: CounryUniversitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        initViewModel()
    }

    override fun getBindingVariable(): Int {
        return BR.universityViewModel
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_university_list
    }
    override fun getViewModel(): UniversitiesViewModel {
        val viewModel=ViewModelProvider(this).get(UniversitiesViewModel::class.java)
        getViewDataBinding().universityViewModel=viewModel
        mViewmodel=viewModel
        return viewModel
    }
    override fun backStackChangeListener(backStackCount: Int) {
       // TODO("Not yet implemented")
    }




    private fun initViewModel() {
        mViewModel!!.getLiveDataObserver().observe(this, {
            if (it != null) {
                counryUniversitiesAdapter.setCountryList(it)
                counryUniversitiesAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error in getting list", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        getViewDataBinding().countryListRecyclerview.layoutManager = LinearLayoutManager(this)
        counryUniversitiesAdapter = CounryUniversitiesAdapter(this)
        getViewDataBinding().countryListRecyclerview.adapter = counryUniversitiesAdapter
    }
}