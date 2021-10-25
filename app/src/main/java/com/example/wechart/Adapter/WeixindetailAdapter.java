package com.example.wechart.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechart.DTO.WeixindetailContent;
import com.example.wechart.R;

import java.util.List;

public class WeixindetailAdapter extends RecyclerView.Adapter<WeixindetailAdapter.WeixindetailViewHolder> {
    private Context context;   //上下文
    private List<WeixindetailContent> wechatData2;   //展示聊天列表的list数组
    private LayoutInflater inflater;

    //添加了一个接口
    public interface OnItemOnClickListener {
        void onItemOnClick(View view, int position);

        void onItemLongOnClick(View view, int position);
    }

    private OnItemOnClickListener mOnItemOnClickListener;

    //供外部来设置监听
    public void setOnItemOnClickListener(OnItemOnClickListener listener) {
        this.mOnItemOnClickListener = listener;
    }

    public WeixindetailAdapter(Context context, List<WeixindetailContent> wechatData2) {
        this.context = context;
        this.wechatData2 = wechatData2;
    }


    @NonNull
    @Override
    public WeixindetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.detai_weixin, parent, false);
        return new WeixindetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeixindetailViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.wechatdetailAvaterView.setImageResource(wechatData2.get(position).getWeChatdetailAvaterId());
        holder.wechatdetaiContentView.setText(wechatData2.get(position).getWeChatdetailContent());
        holder.wechatdetailTimeView.setText(wechatData2.get(position).getWeChatdetailTime());


    }

    @Override
    public int getItemCount() {
        return wechatData2 == null ? 0 : wechatData2.size();
    }

    //根据位置删除wechatDate里的数据
    public void onRemoveItem(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        wechatData2.remove(position);
        notifyItemRemoved(position);
        /*如果移除的是最后一个，忽略。
         * 避免下标错误
         * */
        if (position != wechatData2.size()) {
            notifyItemRangeChanged(position, wechatData2.size() - position);
        }
    }


    public class WeixindetailViewHolder extends RecyclerView.ViewHolder {
        TextView wechatdetaiContentView, wechatdetailTimeView;
        ImageView wechatdetailAvaterView;


        public WeixindetailViewHolder(@NonNull View itemView) {
            super(itemView);
            wechatdetailAvaterView = itemView.findViewById(R.id.detail_img);
            wechatdetaiContentView = itemView.findViewById(R.id.detail_content);
            wechatdetailTimeView = itemView.findViewById(R.id.detail_time);

        }
    }

}