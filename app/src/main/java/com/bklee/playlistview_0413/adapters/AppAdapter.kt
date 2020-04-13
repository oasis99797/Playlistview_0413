package com.bklee.playlistview_0413.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bklee.playlistview_0413.R
import com.bklee.playlistview_0413.datas.App

class AppAdapter(context: Context, resId: Int, list:ArrayList<App>) : ArrayAdapter<App>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {
            //            null이 아닐때
        }.let {
            //            null 일때
            tempRow = inf.inflate(R.layout.app_list_item, null)
        }

        val row = tempRow!!


        val titleTxt = row.findViewById<TextView>(R.id.titleTxt)
        val companyNameTxt = row.findViewById<TextView>(R.id.companyNameTxt)
        val starImg1 = row.findViewById<ImageView>(R.id.starImg1)
        val starImg2 = row.findViewById<ImageView>(R.id.starImg2)
        val starImg3 = row.findViewById<ImageView>(R.id.starImg3)
        val starImg4 = row.findViewById<ImageView>(R.id.starImg4)
        val starImg5 = row.findViewById<ImageView>(R.id.starImg5)

        val data = mList.get(position)

        titleTxt.text = "${position+1}. ${data.name}"
        companyNameTxt.text = data.companyName

//        starImg1.setImageResource(R.drawable.fill_star)

        val starImgList = ArrayList<ImageView>()
        starImgList.add(starImg1)
        starImgList.add(starImg2)
        starImgList.add(starImg3)
        starImgList.add(starImg4)
        starImgList.add(starImg5)

        for (index in 0..4) {
            val starImg = starImgList.get(index)

            if (index < data.starCount) {
                starImg.setImageResource(R.drawable.fill_star)
            }
            else {
                starImg.setImageResource(R.drawable.empty_star)
            }

        }



        return row
    }


}