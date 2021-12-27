package com.example.mvprecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvprecyclerview.databinding.MovieRowBinding
import com.example.mvprecyclerview.model.Result




class MovieAdapter(val moveList:ArrayList<Result>, context: Context):RecyclerView.Adapter<MovieAdapter.MyHolder> (){

    class MyHolder(val binding: MovieRowBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Result) {
      binding.apply {
          titleTv.text=movie.original_title
          releaseDate.text=movie.release_date
       //   Glide.with(this).load

      }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding=MovieRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       // return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row,parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val movie=moveList.get(position)
        holder.bind(movie)

        /*val options: RequestOptions = RequestOptions()
            .centerCrop()*/
          /*  .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round);*/


      //  Glide.with().load(movie.).apply(options).into(holder.itemView.movie_iv);

    }

    override fun getItemCount(): Int {
     return moveList.size
    }
}