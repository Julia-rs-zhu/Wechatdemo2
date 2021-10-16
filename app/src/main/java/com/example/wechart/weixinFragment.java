package com.example.wechart;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechart.Adapter.WeixinAdapter;
import com.example.wechart.DTO.WeixinContent;
import com.example.wechart.R;

import java.util.ArrayList;
import java.util.List;


public class weixinFragment extends Fragment {
    private List<WeixinContent> weChatData = new ArrayList<>();
    //展示内容的数据集
    private Context context;
    //声明上下文
    private RecyclerView recyclerView;
    //声明recyclerView，在后面onCreateView()函数中通过view.findViewById()进行赋值
    private WeixinAdapter weixinAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weixin, container, false);
        recyclerView = view.findViewById(R.id.rv_weixin);
        initData();
        initView();
        return view;
    }

    //初始化View，为RecyclerView配置适配器，管理器，为Adapter设置自定义的监听器
    private void initView() {
        context = this.getActivity();
        weixinAdapter = new WeixinAdapter(context,weChatData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        weixinAdapter.setOnItemOnClickListener(new WeixinAdapter.OnItemOnClickListener() {
            @Override
            public void onItemOnClick(View view, int position) {
                Toast.makeText(context, "点击"+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongOnClick(View view, int position) {
                showPopMenu(view,position);
            }
        });

        recyclerView.setAdapter(weixinAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
    }

    //初始化数据
    private void initData() {
        List<String> nameList = new ArrayList<>();
        nameList.add("妈妈");
        nameList.add("董小范");
        nameList.add("曹小花");
        nameList.add("小吴");
        nameList.add("姐姐");
        nameList.add("爸爸");
        nameList.add("小余鱼");
        nameList.add("罗黛玉");

        List<String> timeList = new ArrayList<>();
        timeList.add("下午7:00");
        timeList.add("下午5:00");
        timeList.add("下午3:30");
        timeList.add("下午2:00");
        timeList.add("中午12:00");
        timeList.add("上午9:30");
        timeList.add("上午8:00");
        timeList.add("上午7:00");

        List<String> ContentList = new ArrayList<>();
        ContentList.add("买衣服了没");
        ContentList.add("学姐，带个快递");
        ContentList.add("吃啥");
        ContentList.add("有快递帮忙带回去的吗");
        ContentList.add("这个剧还不错");
        ContentList.add("还有生活费么");
        ContentList.add("在哪儿");
        ContentList.add("买这个不");

        List<Integer> AvaterIdList = new ArrayList<>();
        AvaterIdList.add(R.drawable.mam);
        AvaterIdList.add(R.drawable.xiaofan);
        AvaterIdList.add(R.drawable.cao);
        AvaterIdList.add(R.drawable.wu);
        AvaterIdList.add(R.drawable.sis);
        AvaterIdList.add(R.drawable.dad);
        AvaterIdList.add(R.drawable.yu);
        AvaterIdList.add(R.drawable.luo);

        for (int i = 0; i < nameList.size(); i++) {
            WeixinContent weChatContent = new WeixinContent();
            weChatContent.setWeChatAvaterId(AvaterIdList.get(i));
            weChatContent.setWeChatName(nameList.get(i));
            weChatContent.setWeChatContent(ContentList.get(i));
            weChatContent.setWeChatTime(timeList.get(i));
            weChatData.add(weChatContent);
        }
    }
    public void showPopMenu(View view,final int position) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_item, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                weixinAdapter.onRemoveItem(position);
                return false;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(context.getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }
}