package com.scorpiart.cats

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scorpiart.cats.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        var list = ArrayList<ListItem>()
        list.addAll(fillArrays(resources.getStringArray(R.array.cats),
            resources.getStringArray(R.array.cats_content),
        getImageId(R.array.cats_image_array)))
        var recView: RecyclerView = findViewById(R.id.rcView)
        recView.hasFixedSize()
        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter = MyAdapter(list, this)



    }
    fun fillArrays(titleArray:Array<String>,contentArray: Array<String>, imageArray: IntArray):List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1){
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray{
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices){
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }

}