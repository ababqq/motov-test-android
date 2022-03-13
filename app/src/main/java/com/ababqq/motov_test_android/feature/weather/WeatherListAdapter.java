package com.ababqq.motov_test_android.feature.weather;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ababqq.motov_test_android.databinding.WeatherItemBinding;
import com.ababqq.motov_test_android.viewmodels.WeatherViewModel;

class WeatherListAdapter extends RecyclerView.Adapter<WeatherListItemVH> {
    private static final String TAG = WeatherListAdapter.class.getSimpleName();

    private WeatherViewModel mViewModel;
    private Context mContext;

    public WeatherListAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public WeatherListItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WeatherItemBinding binding = WeatherItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WeatherListItemVH(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull WeatherListItemVH holder, int position) {
        holder.bind(mViewModel.getForcastItems().get(position));
    }

    @Override
    public int getItemCount() {
        return mViewModel.getForcastItems() == null ? 0 : (mViewModel.getPage().getValue() + 1) * mViewModel.getNUMBER_PER_PAGE();
    }

    public void setViewModel(WeatherViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    public void refresh() {
        notifyDataSetChanged();
    }
}
