package com.example.mvprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvprecyclerview.databinding.ActivityMainBinding
import com.example.mvprecyclerview.model.Result

class MainActivity : AppCompatActivity() ,MainActivityContract.View{
    lateinit var binding:ActivityMainBinding
    lateinit var mlist: ArrayList<Result>
    lateinit var mAdapter:MovieAdapter
    lateinit var movieAdapter:MovieAdapterNew

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val presenter=MainViewPresenter(this)
    /*    binding.apply {
            mAdapter=MovieAdapter(mlist,this@MainActivity)
            recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
            recyclerView.adapter=mAdapter
        }*/


    }

    override fun uiSetup() {
        val a= listOf<Int>()
        val dummy=Result(true,"",a,12204,"Telugu","One Nenukodine",
            "",2.2,"","","Nagoor",true,
            4.5,3
        )
        val dummy1=Result(true,"",a,12205,"Telugu","Krack",
            "",2.2,"","","Raviteja",true,
            4.5,3
        )
        mlist=ArrayList()
      //  mAdapter=MovieAdapter(mlist,this@MainActivity)
         movieAdapter=MovieAdapterNew()
        binding.apply {
            recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
            //recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
            recyclerView.adapter=movieAdapter
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun showProgressDialog() {
        binding.progressBar.visibility=View.VISIBLE

    }

    override fun hideProgressDialog() {
        binding.progressBar.visibility=View.GONE

    }

    override fun displayMovieData(list: ArrayList<Result>) {
        Log.e("mvp displayMovieData", list.size.toString() + "");
        mlist=ArrayList()
        mlist.clear()
        mlist.addAll(list)
      movieAdapter.differ.submitList(mlist)
    }
}