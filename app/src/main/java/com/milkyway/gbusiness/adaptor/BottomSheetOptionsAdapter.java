package com.milkyway.gbusiness.adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.milkyway.gbusiness.R;
import com.milkyway.gbusiness.models.BottomSheetOption;

import java.util.ArrayList;

public class BottomSheetOptionsAdapter extends RecyclerView.Adapter<BottomSheetOptionsAdapter.MyViewHolder>
{
    private final String TAG = BottomSheetOptionsAdapter.class.getSimpleName();
    private final Context mContext;
    private ArrayList<BottomSheetOption> mListOptions;
    private final OnOptionsSelectedListener mListener;

    public interface OnOptionsSelectedListener{void onOptionSelected(int option);}

    public BottomSheetOptionsAdapter(Context context, ArrayList<BottomSheetOption> optionList, OnOptionsSelectedListener onOptionsSelectedListener) {
        this.mListOptions = optionList;
        this.mContext=context;
        this.mListener = onOptionsSelectedListener;

        Log.i(TAG,"bottom sheet options size = "+mListOptions.size());


    }

    public void addOptionList(ArrayList<BottomSheetOption> optionList)
    {
        Log.i(TAG,"addContactList() method called , contactList size = "+optionList.size());
        this.mListOptions = optionList;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_fragment_bottom_sheet_options, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {
        if (mListOptions == null)
            return;

        final BottomSheetOption option = mListOptions.get(holder.getAdapterPosition());
        if (option == null)
            return;

        holder.txtTitle.setText(option.getTitle());

        Glide.with(mContext)
                .load(option.getImgResourceId())
                .into(holder.image);


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null)
                    mListener.onOptionSelected(option.getOptionId());
            }
        });
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (mListOptions != null)
            return mListOptions.size();
        else
            return 0;
    }



    // ViewHolder class
    public static class MyViewHolder  extends RecyclerView.ViewHolder
    {
        private final TextView txtTitle;
        private final ImageView image;
        View layout;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            layout = itemView;
            txtTitle =  itemView.findViewById(R.id.bottom_sheet_options_txt);
            image =  itemView.findViewById(R.id.bottom_sheet_options_img);
        }
    }
}
