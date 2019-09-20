package net.xanir.kariyerassignment.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.xanir.kariyerassignment.databinding.ListItemOrderBinding
import net.xanir.kariyerassignment.restApi.responses.MainResponse

/**
 * Created by Umur Kaya on 18-Sep-19.
 */
class OrdersAdapter : RecyclerView.Adapter<OrdersItemViewHolder>() {

    var mItems  = arrayListOf<MainResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersItemViewHolder {
        return OrdersItemViewHolder(ListItemOrderBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OrdersItemViewHolder, position: Int) {
        holder.binding.response = mItems[position]
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun updateData(mItems : ArrayList<MainResponse>){
        this.mItems = mItems
        notifyDataSetChanged()
    }
}
