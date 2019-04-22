package com.manggeek.learndemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.manggeek.learndemo.Entity.CompanysModel;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.Util.PinYinStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/4 5:10 PM
 */
public class ContactAdapter extends BaseAdapter {

    private Context context;
    private List<CompanysModel> list;
    public PinYinStyle sortToken;

    public ContactAdapter(Context context, List<CompanysModel> list) {
        super();
        this.context = context;
        this.list = list;
        sortToken = new PinYinStyle();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_company, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CompanysModel companys = list.get(position);
        holder.tv_contact_name.setText(companys.getName());
        String currentAlphabet = companys.getPinyin().charAt(0) + "";
        if (position > 0) {
            String lastAlphabet = list.get(position - 1).getPinyin().charAt(0) + "";
            //获取上一个item的首字母

            if (currentAlphabet.equals(lastAlphabet)) {
                //首字母相同，需要隐藏当前item的字母的TextView
                holder.tv_first_alphabet.setVisibility(View.GONE);
            } else {
                //不相同就要显示当前的首字母
                holder.tv_first_alphabet.setVisibility(View.VISIBLE);
                holder.tv_first_alphabet.setText(currentAlphabet);
            }
        } else {
            holder.tv_first_alphabet.setVisibility(View.VISIBLE);
            holder.tv_first_alphabet.setText(currentAlphabet);
        }
        return convertView;
    }

    class ViewHolder {
        TextView tv_contact_name;
        TextView tv_first_alphabet;

        public ViewHolder(View convertView) {
            tv_contact_name = (TextView) convertView.findViewById(R.id.tv_contact_name);
            tv_first_alphabet = (TextView) convertView.findViewById(R.id.tv_first_alphabet);

            tv_contact_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onCityClickListener != null) {
                        onCityClickListener.onCityClick(tv_contact_name.getText().toString());
                    }
                }
            });
        }

    }

    public interface OnCityClickListener {
        void onCityClick(String name);
    }

    private OnCityClickListener onCityClickListener;

    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }


    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     * @param list
     */
    public void updateListView(List<CompanysModel> list) {
        if (list == null) {
            this.list = new ArrayList<CompanysModel>();
        } else {
            this.list = list;
        }
        notifyDataSetChanged();
    }


    /**
     * 得到首字母的ascii值
     */
    public int getSectionForPosition(int position) {
        return list.get(position).getPinyin().charAt(0);
    }


}
