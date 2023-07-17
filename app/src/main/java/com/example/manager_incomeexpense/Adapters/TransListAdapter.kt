package com.example.manager_incomeexpense.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.manager_incomeexpense.Model.TransModel
import com.example.manager_incomeexpense.R
import com.example.manager_incomeexpense.databinding.TransItemBinding
import java.util.ArrayList

@Suppress("UNREACHABLE_CODE")

class TransListAdapter(update: (TransModel) -> Unit): RecyclerView.Adapter<TransListAdapter.TransListHolder>() {

    var update = update
    var transList = ArrayList<TransModel>()
    lateinit var context : Context
    class TransListHolder(itemView: TransItemBinding) : ViewHolder(itemView.root){

        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransListHolder {
        context = parent.context
        var binding = TransItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransListHolder(binding)
    }

    override fun getItemCount(): Int {

        return transList.size
    }

    override fun onBindViewHolder(holder: TransListHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.binding.apply {
              transList.get(position).apply {
                txtcategory.text = category
                txtnote.text = note
                txtamount.text = amount.toString()

                if (isExpense == 0 ){

                    txtamount.setTextColor(Color.GREEN)
                    round.setImageResource(R.drawable.inomcei)



                }else{

                    txtamount.setTextColor(Color.RED)
                    round.setImageResource(R.drawable.expensei)

                }
            }
        }
        holder.itemView.setOnLongClickListener(object : OnLongClickListener{
            override fun onLongClick(p0: View?): Boolean {

                val popupMenu = PopupMenu(context, holder.itemView)
                popupMenu.menuInflater.inflate(R.menu.update,popupMenu.menu)

                popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                    override fun onMenuItemClick(p0: MenuItem?): Boolean {

                        if (p0?.itemId == R.id.update) {

                            update.invoke(transList.get(position))
                        }

                        if (p0?.itemId == R.id.delete) {

                        }


                        return true
                    }


                })



                popupMenu.show()
                return false
            }

        })
    }

    fun setTrans(transList: ArrayList<TransModel>) {

        this.transList = transList
        
    }
}