package com.milkyway.gbusiness.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/milkyway/gbusiness/api/RecyclerviewCallbacks;", "T", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "item", "(Landroid/view/View;ILjava/lang/Object;)V", "app_debug"})
public abstract interface RecyclerviewCallbacks<T extends java.lang.Object> {
    
    public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
    android.view.View view, int position, T item);
}