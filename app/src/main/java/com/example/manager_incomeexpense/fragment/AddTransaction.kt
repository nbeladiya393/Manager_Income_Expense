package com.example.manager_incomeexpense.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.manager_incomeexpense.Database
import com.example.manager_incomeexpense.Model.TransModel
import com.example.manager_incomeexpense.databinding.FragmentAddTransactionBinding


class addTransaction : Fragment() {

    lateinit var binding: FragmentAddTransactionBinding
    var isExpense = 0
    lateinit var dbHelper : Database

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentAddTransactionBinding.inflate(layoutInflater)
        return binding.root

        dbHelper = Database(context)


        initview()
    }

    private fun initview() {

        //cardINCOME
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
            var model = TransModel(1,amount, category, note, isExpense)
            dbHelper.addTrans(model)
            binding.edtamount.setText("")
            binding.edtcategory.setText("")
            binding.edtnote.setText("")


        }
    }


}