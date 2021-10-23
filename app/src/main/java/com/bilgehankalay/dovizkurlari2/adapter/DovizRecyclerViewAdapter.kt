package com.bilgehankalay.dovizkurlari2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bilgehankalay.dovizkurlari2.databinding.DovizCardTasarimBinding
import com.bilgehankalay.dovizkurlari2.models.DovizKur

class DovizRecyclerViewAdapter(private var dovizList : ArrayList<DovizKur>) : RecyclerView.Adapter<DovizRecyclerViewAdapter.DovizCardTasarim>() {
    class DovizCardTasarim(var dovizCardTasarimBinding: DovizCardTasarimBinding) : RecyclerView.ViewHolder(dovizCardTasarimBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DovizRecyclerViewAdapter.DovizCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dovizCardBinding = DovizCardTasarimBinding.inflate(layoutInflater,parent,false)
        return DovizCardTasarim(dovizCardBinding)
    }

    override fun onBindViewHolder(
        holder: DovizRecyclerViewAdapter.DovizCardTasarim,
        position: Int
    ) {
        val doviz = dovizList[position]
        holder.dovizCardTasarimBinding.apply {
            val fiyat = (1.0/doviz.rate)
            this.dovizFiyat.text = "1 ${doviz.code} =  %.2f ₺".format(fiyat)
            this.dovizIsim.text = doviz.name
        }
    }

    override fun getItemCount(): Int {
        return dovizList.size
    }
}