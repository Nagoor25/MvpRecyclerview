package com.example.mvprecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvprecyclerview.api.ApiInterface
import com.example.mvprecyclerview.databinding.MovieRowBinding
import com.example.mvprecyclerview.model.Result
import javax.inject.Inject


class MovieAdapterNew @Inject constructor():RecyclerView.Adapter<MovieAdapterNew.MyHolder> (){
  private val differCallBack=object :DiffUtil.ItemCallback<Result>(){
      override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
          return oldItem.id==newItem.id
      }

      override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
          return oldItem==newItem
      }

  }
    val differ = AsyncListDiffer(this, differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding=MovieRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       // return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row,parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val movie=differ.currentList.get(position)
        holder.bind(movie)

        /*val options: RequestOptions = RequestOptions()
            .centerCrop()*/
          /*  .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round);*/


      //  Glide.with().load(movie.).apply(options).into(holder.itemView.movie_iv);

    }

    override fun getItemCount(): Int {
     return differ.currentList.size
    }

    class MyHolder(val binding: MovieRowBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Result) {
            binding.apply {
                titleTv.text=movie.original_title
                releaseDate.text=movie.release_date
                //   Glide.with(this).load
                movie.poster_path?.let {
                    val imageURL=ApiInterface.ImageBaseURL+movie.poster_path
                    Glide.with(itemView.context)
                        .load(imageURL)
                        .into(movieIv);
                }

            }
        }

    }
}