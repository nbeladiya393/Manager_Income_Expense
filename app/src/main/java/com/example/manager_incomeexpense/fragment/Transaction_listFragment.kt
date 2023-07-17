package com.example.manager_incomeexpense.fragment

import android.app.Dialog
import android.graphics.Color
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

    var isExpense = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTransactionListBinding.inflate(layoutInflater)



        database = Database(context)
        transList = database.getTransaction()
//        transList = transList.reversed() as ArrayList<TransModel>


        adapter = TransListAdapter{

            updateDialog(it)


        }
        adapter.setTrans(transList)

        binding.rcvTransList.layoutManager = LinearLayoutManager(context)
        binding.rcvTransList.adapter = adapter

        return binding.root

    }

    private fun updateDialog(transModel: TransModel) {

        var dialog = Dialog(requireContext())
        var binding = UpdateDialogueBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)

        binding.cardincome.setOnClickListener {
            isExpense = 0
            binding.cardincome.setCardBackgroundColor(Color.parseColor("#4CAF50"))

        }

        binding.cardexpense.setOnClickListener {
            isExpense = 1
            binding.cardexpense.setCardBackgroundColor(Color.parseColor("#F44336"))
        }

        binding.btnsubmit.setOnClickListener {
            var amount = binding.edtamount.toString().toInt()
            var category = binding.edtcategory.toString()
            var note = binding.edtnote.toString()
            var model = TransModel(transModel.id,amount, category, note, isExpense)
            database.updateTrans(model)
            binding.edtamount.setText("")
            binding.edtcategory.setText("")
            binding.edtnote.setText("")


        }



        dialog.show()

    }


}
