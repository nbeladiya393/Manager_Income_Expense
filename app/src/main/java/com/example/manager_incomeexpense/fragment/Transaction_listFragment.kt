package com.example.manager_incomeexpense.fragment

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.manager_incomeexpense.Adapters.TransListAdapter
import com.example.manager_incomeexpense.Database
import com.example.manager_incomeexpense.Model.TransModel
import com.example.manager_incomeexpense.databinding.FragmentTransactionListBinding
import com.example.manager_incomeexpense.databinding.UpdateDialogueBinding

class transaction_listFragment : Fragment() {


    var transList = ArrayList<TransModel>()
    lateinit var database: Database
    lateinit var binding: FragmentTransactionListBinding
    lateinit var adapter : TransListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTransactionListBinding.inflate(layoutInflater)



        database = Database(context)
        transList = database.getTransaction()
        transList = transList.reversed() as ArrayList<TransModel>


        adapter = TransListAdapter{

            var dialog = Dialog(requireContext())
            var bind = UpdateDialogueBinding.inflate(layoutInflater)

        }
        adapter.setTrans(transList)

        binding.rcvTransList.layoutManager = LinearLayoutManager(context)
        binding.rcvTransList.adapter = adapter

        return binding.root
    }


}
