package com.example.horoscopoapp.ui.horoscopo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.R
import com.example.horoscopoapp.domain.model.HoroscopoInfo

class HoroscopoAdapter(private var horosocopoList:List<HoroscopoInfo> = emptyList(),
    private val onItemSelected:(HoroscopoInfo) -> Unit) :
    RecyclerView.Adapter<HoroscopoViewHolder>() {

    fun updateList(list:List<HoroscopoInfo>){
        horosocopoList = list
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        return HoroscopoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo,parent, false)
        )
    }

    override fun getItemCount() = horosocopoList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(horosocopoList[position],onItemSelected)
    }
}