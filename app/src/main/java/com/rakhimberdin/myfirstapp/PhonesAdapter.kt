package com.rakhimberdin.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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

    private val itemName: TextView = itemView.findViewById(R.id.item_name)
    private val itemPrice: TextView = itemView.findViewById(R.id.item_price)
    private val itemDate: TextView = itemView.findViewById(R.id.item_date)
    private val itemScore: TextView = itemView.findViewById(R.id.item_score)

    fun bind(mPhones: PhoneModel) {
        itemName.text = mPhones.name
        itemPrice.text = mPhones.price
        itemDate.text = mPhones.data
        itemScore.text = mPhones.score
    }

}