package com.a2dfire.yusuzi.roomwordsample.setting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a2dfire.yusuzi.roomwordsample.R;
import java.util.List;

public class SettingListAdapter extends RecyclerView.Adapter<SettingListAdapter.SettingViewHolder> {

    private final LayoutInflater mInflater;
    private List<SettingBean> mSettings;

    private OnItemClickListener mOnItemClickListener;

    public SettingListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SettingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_setting_item, parent, false);
        return new SettingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingViewHolder holder, int position) {
        if (mSettings != null) {
            final SettingBean current = mSettings.get(position);
            holder.wordItemView.setText(current.getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(current);
                }
            });
        } else {
            holder.wordItemView.setText("NoWord");
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener=onItemClickListener;
    }

    void setItems(List<SettingBean> words) {
        mSettings = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mSettings != null) {
           return mSettings.size();
        } else {
            return 0;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(SettingBean settingBean);
    }

    class SettingViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        public SettingViewHolder(View itemView) {
            super(itemView);
            this.wordItemView = itemView.findViewById(R.id.text_view);
        }
    }

}
