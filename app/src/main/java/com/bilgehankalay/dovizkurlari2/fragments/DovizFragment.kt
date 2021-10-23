package com.bilgehankalay.dovizkurlari2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bilgehankalay.dovizkurlari2.R
import com.bilgehankalay.dovizkurlari2.adapter.DovizRecyclerViewAdapter
import com.bilgehankalay.dovizkurlari2.databinding.FragmentDovizBinding
import com.bilgehankalay.dovizkurlari2.models.DovizKur
import com.bilgehankalay.dovizkurlari2.network.ApiUtils
import com.bilgehankalay.dovizkurlari2.network.exchangeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DovizFragment : Fragment() {
    private var _binding : FragmentDovizBinding? = null
    private val binding get() = _binding!!
    var dovizlerList : ArrayList<DovizKur> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDovizBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dovizleriGetir()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun dovizleriGetir(){
        ApiUtils.DovizDAOInterfaceGetir().dovizleriAl("TRY",1).enqueue(
            object : Callback<exchangeResponse>{
                override fun onResponse(
                    call: Call<exchangeResponse>,
                    response: Response<exchangeResponse>
                ) {
                    val tempList = response.body()?.result?.data
                    tempList?.let{
                        dovizlerList = it as ArrayList<DovizKur>
                    }
                    val dovizlerAdapter = DovizRecyclerViewAdapter(dovizlerList)
                    binding.recyclerView.adapter = dovizlerAdapter
                    binding.recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                    binding.recyclerView.setHasFixedSize(true)

                }

                override fun onFailure(call: Call<exchangeResponse>, t: Throwable) {
                    Log.e("LOG","ERROR")
                    Log.e("LOG",t.localizedMessage)
                }

            }
        )
    }
}