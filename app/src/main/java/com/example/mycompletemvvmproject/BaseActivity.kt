package com.example.mycompletemvvmproject

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> :
    AppCompatActivity() {

    private var mViewDataBinding: T? = null
    var mViewModel: V? = null
    //  private var isLoading: = ObservableField(false)

    private lateinit var mProgressDialog: Dialog

    //Orerride for setbinding variable
//@return variable id
    abstract fun getBindingVariable(): Int


    //@return layout resource id
    abstract fun getLayoutId(): Int

    // override for set view model
//return view model instance
    abstract fun getViewModel(): V

    fun getViewDataBinding(): T {
        return mViewDataBinding!!
    }

    private var lastFragmentName: String = ""
    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()

        // configureToolbar()
    }

    protected abstract fun backStackChangeListener(backStackCount: Int)

    /**
     * Method to perform data binding on layout for activity
     */
    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = when (this.mViewModel) {
            null -> getViewModel()
            else -> mViewModel
        }
        mViewDataBinding!!.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding!!.executePendingBindings()
        mViewDataBinding!!.lifecycleOwner = this
    }

    fun showProgress() {
        mProgressDialog.show()
    }

    fun dismissProgress() {
        mProgressDialog.dismiss()
    }

    override fun onResume() {
        super.onResume()
    }

    fun sessionExpiredDialog() {
//        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
//        builder.setMessage(resources.getString(R.string.session_expired_msg))
//        builder.setTitle(resources.getString(R.string.session_expired_title))
//        builder.setCancelable(false)
//        builder.setPositiveButton(
//            resources.getString(R.string.okay)
//        ) { dialog, which ->
//
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
    }

    // Create the Alert dialog
    //   val alertDialog: AlertDialog = builder.create()
    //  alertDialog.show()
}
