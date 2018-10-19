package com.example.administrator.fangbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.fangbook.fragment.BookRackFragment;

/**
 * 作者 ： liyinqing on 2018/10/19 0019
 * 邮箱 ：yinqing_521@163.com
 */
public class BookRackAdapter extends RecyclerView.Adapter<BookRackAdapter.BookRackViewHolder> {


    private final BookRackFragment mContext;

    public BookRackAdapter(BookRackFragment bookRackFragment) {
        this.mContext = bookRackFragment;
    }

    @Override
    public BookRackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BookRackViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BookRackViewHolder extends RecyclerView.ViewHolder{

        public BookRackViewHolder(View itemView) {
            super(itemView);
        }
    }
}
