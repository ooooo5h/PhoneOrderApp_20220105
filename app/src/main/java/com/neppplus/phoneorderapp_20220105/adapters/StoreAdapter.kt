package com.neppplus.phoneorderapp_20220105.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neppplus.phoneorderapp_20220105.R
import com.neppplus.phoneorderapp_20220105.ViewStoreDetailActivity
import com.neppplus.phoneorderapp_20220105.models.StoreData
import org.w3c.dom.Text


class StoreAdapter(
    val mContext: Context,
    val mList: List<StoreData>,
) : RecyclerView.Adapter<StoreAdapter.MyViewHolder>() {

    inner class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {

        val imgLogo = row.findViewById<ImageView>(R.id.imgLogo)
        val txtStoreName = row.findViewById<TextView>(R.id.txtStoreName)

        fun bind(data: StoreData) {

            txtStoreName.text = data.name

            Glide.with(mContext).load(data.logoURL).into(imgLogo)

            row.setOnClickListener {

                val myIntent = Intent(mContext, ViewStoreDetailActivity::class.java)
                myIntent.putExtra("store", data)
                mContext.startActivity(myIntent)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val row = LayoutInflater.from(mContext).inflate(R.layout.store_list_item, parent, false)

        return MyViewHolder(row)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.bind(mList[position])

    }

    override fun getItemCount(): Int {

        return mList.size

    }

}