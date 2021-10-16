package com.example.wechart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechart.R;
import com.example.wechart.DTO.WeixinContent;


import java.util.List;

public class WeixinAdapter extends RecyclerView.Adapter<WeixinAdapter.WeixinViewHolder> {
    private Context context;   //上下文
    private List<WeixinContent> wechatData;   //展示聊天列表的list数组
    private LayoutInflater inflater;

    //添加了一个接口
    public interface OnItemOnClickListener{
        void onItemOnClick(View view,int position);
        void onItemLongOnClick(View view ,int position);
    }
    private OnItemOnClickListener mOnItemOnClickListener;
    //供外部来设置监听
    public void setOnItemOnClickListener(OnItemOnClickListener listener){
        this.mOnItemOnClickListener = listener;
    }
    public WeixinAdapter(Context context, List<WeixinContent> wechatData) {
        this.context = context;
        this.wechatData = wechatData;
    }


    @NonNull
    @Override
    public WeixinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.weixin_content, parent, false);
        return new WeixinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeixinViewHolder holder, int position) {
        holder.wechatAvaterView.setImageResource(wechatData.get(position).getWeChatAvaterId());
        holder.wechatNameView.setText(wechatData.get(position).getWeChatName());
        holder.wechatContentView.setText(wechatData.get(position).getWeChatContent());
        holder.wechatTimeView.setText(wechatData.get(position).getWeChatTime());
        //在ViewBinder里进行绑定
        if (mOnItemOnClickListener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "你点击的是：" + wechatData.get(position).getWeChatName(), Toast.LENGTH_SHORT).show();
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemOnClickListener.onItemLongOnClick(holder.itemView, position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return wechatData == null ? 0:wechatData.size();
    }

    //根据位置删除wechatDate里的数据
    public void onRemoveItem(int position) {
        if (position < 0 || position > getItemCount()) {
            return;
        }

        wechatData.remove(position);
        notifyItemRemoved(position);
        /*如果移除的是最后一个，忽略。
         * 避免下标错误
         * */
        if (position != wechatData.size()) {
            notifyItemRangeChanged(position, wechatData.size() - position);
        }
    }


    public class WeixinViewHolder extends RecyclerView.ViewHolder {
        TextView wechatNameView,wechatContentView,wechatTimeView;
        ImageView wechatAvaterView;
        public WeixinViewHolder(@NonNull View itemView) {
            super(itemView);
            wechatAvaterView = itemView.findViewById(R.id.tv_avatar);
            wechatNameView = itemView.findViewById(R.id.tv_wechat_name);
            wechatContentView = itemView.findViewById(R.id.tv_wechat_content);
            wechatTimeView = itemView.findViewById(R.id.tv_we_chat_time);
        }
    }
}

