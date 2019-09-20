package net.xanir.kariyerassignment.orders

import android.view.View

import androidx.recyclerview.widget.RecyclerView

import net.xanir.kariyerassignment.databinding.ListItemOrderBinding

/**
 * Created by Umur Kaya on 20-Sep-19.
 */
class OrdersItemViewHolder internal constructor(internal var binding: ListItemOrderBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        this.binding.clickHandler.setOnClickListener {
            if(this.binding.detailView.visibility == View.VISIBLE){
                this.binding.detailView.visibility = View.GONE
                this.binding.priceDetail.visibility = View.GONE
                this.binding.productDetail.visibility = View.GONE
                this.binding.lineView.visibility = View.GONE
            }
            else{
                this.binding.detailView.visibility = View.VISIBLE
                this.binding.priceDetail.visibility = View.VISIBLE
                this.binding.productDetail.visibility = View.VISIBLE
                this.binding.lineView.visibility = View.VISIBLE
            }
        }
        this.binding.clickHandler.callOnClick()
    }
}
