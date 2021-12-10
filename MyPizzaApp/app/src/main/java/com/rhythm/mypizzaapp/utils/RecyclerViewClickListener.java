package com.rhythm.mypizzaapp.utils;

import android.view.View;

/** ClickListener interface for recyclerView item click
 *
 * */
public interface RecyclerViewClickListener {
    void itemClickListener(View view, int position);
    void subTotal(int subTotal);
}
