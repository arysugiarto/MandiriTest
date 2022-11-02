package com.arysugiarto.dokutestandroid.ui.applenews

import android.widget.ImageView
import com.arysugiarto.dokutestandroid.base.BaseAdapter
import com.arysugiarto.dokutestandroid.data.remote.model.AppleNewsResponse
import com.arysugiarto.dokutestandroid.databinding.ItemNewsBinding
import com.arysugiarto.dokutestandroid.util.ImageCornerOptions
import com.arysugiarto.dokutestandroid.util.loadImage
import com.arysugiarto.dokutestandroid.util.textOrNull

object AppleNewsAdapter {
    val newsAdapter =
        BaseAdapter.adapterOf<AppleNewsResponse.Article, ItemNewsBinding>(
            register = BaseAdapter.Register(
                onBindHolder = { pos, item, view ->
                    view.run {

                        tvTitle.textOrNull = item.title
                        tvDate.textOrNull = item.publishedAt
                        tvSource.textOrNull = item.source?.name

                        ivPatnerNews.loadImage(
                            item.urlToImage,
                            scaleType = ImageView.ScaleType.CENTER_CROP,
                            corner = ImageCornerOptions.ROUNDED,
                        )

                        clItem.setOnClickListener {
                            SetOnClickItem.onClickListener.invoke(item)
                        }

                    }
                }
            ),
            diff = BaseAdapter.Diff(
                areItemsTheSame = { old, new -> old.source?.id == new.source?.id },
                areContentsTheSame = { old, new -> old == new }
            )
        )

    object SetOnClickItem {
        var onClickListener: (AppleNewsResponse.Article) -> Unit = { _ -> }

        fun setOnClickItemListener(listener: (AppleNewsResponse.Article) -> Unit) {
            onClickListener = listener
        }

    }

}