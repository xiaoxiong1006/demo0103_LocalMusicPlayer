package com.example.demo0103_localmusicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jean.jcplayer.model.JcAudio
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MusicAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1.为jcplayer初始化音乐列表
        jcplayer.initPlaylist(getMusicList(), null)
        // 2.将数据通过适配器传给RecyclerView
        recyclerView.adapter = MusicAdapter(jcplayer.myPlaylist!!,this)
        // 3.设定RecyclerView子项目的布局方式是线性布局
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onStop() {
        super.onStop()
        jcplayer.createNotification()
    }

    override fun onPause() {
        super.onPause()
        jcplayer.createNotification()
    }

    override fun onDestroy() {
        super.onDestroy()
        jcplayer.kill()
    }

    override fun onItemClick(item: JcAudio) {
       jcplayer.playAudio(item)
    }

    private fun getMusicList():List<JcAudio>{
        // 新建一个空的音乐列表
        val musicList = ArrayList<JcAudio>()

        // 依次添加歌曲图标和歌曲名称
        musicList.add(JcAudio.createFromRaw("Darktown_Dtrutters_Ball",R.raw.darktown_dtrutters_ball))
        musicList.add(JcAudio.createFromRaw("Entire",R.raw.entire))
        musicList.add(JcAudio.createFromRaw("Lovable_Clown_Sit_Com",R.raw.lovable_clown_sit_com))
        musicList.add(JcAudio.createFromRaw("Lucid_Dreamer",R.raw.lucid_dreamer))

        // 返回添加完成的列表
        return musicList

    }

}
