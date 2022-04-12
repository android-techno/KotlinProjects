package com.example.mycompletemvvmproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mycompletemvvmproject.databinding.ActivityMainBinding
import com.example.mycompletemvvmproject.viewmodel.MainActivityViewModel
import com.example.mycompletemvvmproject.viewmodel.UniversitiesViewModel
import kotlinx.android.synthetic.main.activity_main.*

//class MainActivity : AppCompatActivity(){
//     lateinit var binding: ActivityMainBinding
//     lateinit var viewModel:MainActivityViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)

//        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
//        viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
//        binding.mainactivityViewModel=viewModel
//        binding.lifecycleOwner=this


        mainActivityViewModel.title.observe(this, Observer {  it->

        })

        universityActivity.setOnClickListener(){
            val intent:Intent =Intent(this, UniversityListActivity::class.java)
            startActivity(intent)
        }
   }
    override fun getBindingVariable(): Int {
        return BR.mainactivityViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainActivityViewModel {
        var viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        getViewDataBinding().mainactivityViewModel=viewmodel
        return viewmodel
    }

    override fun backStackChangeListener(backStackCount: Int) {
        TODO("Not yet implemented")
    }



}