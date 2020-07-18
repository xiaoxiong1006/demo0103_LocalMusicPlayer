package com.example.demo0103_localmusicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MusicAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1.获取数据
        val musicList = getMusicList()
        // 2.将数据通过适配器传给RecyclerView
        recyclerView.adapter = MusicAdapter(musicList,this)
        // 3.设定RecyclerView子项目的布局方式是线性布局
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(item: MusicItem) {
        Toast.makeText(this,item.musicName, Toast.LENGTH_LONG).show()

    }

    private fun getMusicList():List<MusicItem>{
        // 新建一个空的音乐列表
        val musicList = ArrayList<MusicItem>()

        // 依次添加歌曲名称
        musicList.add(MusicItem("Darktown_Strutters_Ball"))
        musicList.add(MusicItem("Entire"))
        musicList.add(MusicItem("Lovable_Clown_Sit_Com"))
        musicList.add(MusicItem("Lucid_Dreamer"))

        // 返回添加完成的列表
        return musicList

    }

}
