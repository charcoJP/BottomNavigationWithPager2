package jp.charco.bottomnavigationwithpager2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.charco.bottomnavigationwithpager2.R

class MyAdapter(
    context: Context,
    private val data: List<String>,
    private val onClick: () -> Unit
) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
        holder.itemView.rootView.setOnClickListener {
            onClick.invoke()
        }
    }
}