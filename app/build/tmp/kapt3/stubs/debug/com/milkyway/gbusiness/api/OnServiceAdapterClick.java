package com.milkyway.gbusiness.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/milkyway/gbusiness/api/OnServiceAdapterClick;", "", "onClickServiceItem", "", "service_id", "", "name", "enqri", "price", "first_heading", "second_heading", "serviceType", "image", "app_debug"})
public abstract interface OnServiceAdapterClick {
    
    public abstract void onClickServiceItem(@org.jetbrains.annotations.NotNull()
    java.lang.String service_id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String enqri, @org.jetbrains.annotations.NotNull()
    java.lang.String price, @org.jetbrains.annotations.NotNull()
    java.lang.String first_heading, @org.jetbrains.annotations.NotNull()
    java.lang.String second_heading, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceType, @org.jetbrains.annotations.NotNull()
    java.lang.String image);
}