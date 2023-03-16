package com.rakhimberdin.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class PhonesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPhonesList: ArrayList<PhoneModel> = ArrayList();

    fun setupPhones(phonesList: ArrayList<PhoneModel>) {
        mPhonesList.clear();
        mPhonesList.addAll(phonesList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhonesViewHolder) {
            holder.bind(mPhones = mPhonesList[position])
        }
    }

    override fun getItemCount(): Int {
        return mPhonesList.count();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhonesViewHolder(itemView)
    }

}

class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(mPhones: PhoneModel) {
        itemView.item_name.text = mPhones.name
        itemView.item_price.text = mPhones.price
        itemView.item_date.text = mPhones.data
        itemView.item_score.text = mPhones.score
    }

}