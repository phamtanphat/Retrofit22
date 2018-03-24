package com.ptp.phamtanphat.retrofit2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by KhoaPhamPC on 24/3/2018.
 */

public class MonanAdapter extends ArrayAdapter<Monan> {
    public MonanAdapter(@NonNull Context context, int resource, @NonNull List<Monan> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txtten,txtgia;
        ImageView img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_mon_an,null);
            viewHolder = new ViewHolder();
            viewHolder.img = convertView.findViewById(R.id.imageviewmonan);
            viewHolder.txtgia = convertView.findViewById(R.id.textviewgiamonan);
            viewHolder.txtten = convertView.findViewById(R.id.textviewtenmonan);
            convertView.setTag(convertView);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Monan monan = getItem(position);
        viewHolder.txtten.setText(monan.getTenmonan());
        viewHolder.txtgia.setText("Gia : " +monan.getGiamonan() + " D");
        Picasso.get().load(monan.getHinhanh()).into(viewHolder.img);

        return convertView;
    }
}
