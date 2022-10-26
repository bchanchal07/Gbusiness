package com.milkyway.gbusiness.api

import android.view.View

interface RecyclerviewCallbacks<T> {

    fun onItemClick(view: View, position: Int, item: T)

}