package com.mahir.viewmodelsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahir.viewmodelsample.model.CountryPojo;

import java.util.List;

/**
 * Created by dell on 6/7/2018.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder> {

    Context context;
    List<CountryPojo> countryPojoList;

    public CountryAdapter(Context context, List<CountryPojo> countryPojoList) {
        this.context = context;
        this.countryPojoList = countryPojoList;
    }

    @Override
    public CountryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_country, null);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryHolder holder, int position) {
        holder.tvCountryName.setText(countryPojoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countryPojoList.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder {
        TextView tvCountryName;

        public CountryHolder(View itemView) {
            super(itemView);
            tvCountryName = itemView.findViewById(R.id.tvCountryName);
        }
    }
}
