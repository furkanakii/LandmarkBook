package com.furkanakii.landmarkbook

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.furkanakii.landmarkbook.databinding.RecyclerRowBinding

class characterAdapter(val characterList: List<Characters>) :
    RecyclerView.Adapter<characterAdapter.CharacterHolder>() {
    private val colors: Array<String> = arrayOf("#FFA500", "#755DFF", "#5A2476", "#8A33E1")

    class CharacterHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterHolder(binding)

    }

    override fun getItemCount(): Int {
        return characterList.size
    }


    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.binding.recyclerRow.text = characterList.get(position).name
        fun setColor(colors: Array<String>, position: Int) {
            holder.itemView.setBackgroundColor(Color.parseColor(colors[position]))
        }

       fun hideImages(position: Int) {
            if (position % 2 == 1) {
                holder.binding.click.visibility = View.VISIBLE
            } else {
                holder.binding.click.visibility = View.GONE
            }
        }


        hideImages(position)
        setColor(colors, position)




        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("Characters", characterList.get(position))
            holder.itemView.context.startActivity(intent)
        }


    }
}



