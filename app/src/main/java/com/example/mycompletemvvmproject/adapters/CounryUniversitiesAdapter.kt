package com.example.mycompletemvvmproject.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycompletemvvmproject.R
import com.example.mycompletemvvmproject.model.CountryUniversitiesModel
import kotlinx.android.synthetic.main.universities_list.view.*

class CounryUniversitiesAdapter(val activity: Activity) : RecyclerView.Adapter<CounryUniversitiesAdapter.ViewHolderClass>() {

    private var countryList: List<CountryUniversitiesModel>? = null

    fun setCountryList(countryList: List<CountryUniversitiesModel>) {
        this.countryList = countryList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CounryUniversitiesAdapter.ViewHolderClass {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.universities_list, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: CounryUniversitiesAdapter.ViewHolderClass, position: Int) {
        holder.bind(countryList!!.get(position),activity)
    }

    override fun getItemCount(): Int {
        if (countryList==null) return 0
       else return countryList!!.size
    }

    class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val country = view.counry
        val state_pro=view.state_province
        val webpage=view.web_pages
        val alpha=view.alpha_to_code
        val names = view.name
        val domain =view.domains

       fun bind(data : CountryUniversitiesModel, activity: Activity){
        country.text= "Country Name: ${data.country}"
           state_pro.text="State province: ${data.state_province}"
           webpage.text="WebPage Link: ${data.web_pages}"
           alpha.text="Alpha: ${data.alpha_two_code}"
           names.text="Name: ${data.name}"
           domain.text="Domain: ${data.domains}"
       }
    }
}