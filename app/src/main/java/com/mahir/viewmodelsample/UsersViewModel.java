package com.mahir.viewmodelsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.mahir.viewmodelsample.model.CountryPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dell on 6/6/2018.
 */

public class UsersViewModel extends AndroidViewModel {

    APIInterface apiInterface = ApiClient.getClient().create(APIInterface.class);
    private List<CountryPojo> usersList;

    private final MutableLiveData<List<CountryPojo>> data =
            new MutableLiveData<List<CountryPojo>>();

    public UsersViewModel(Application application) {
        super(application);
        loadUserList();
    }

    public LiveData<List<CountryPojo>> getData() {
        return data;
    }

    public void loadUserList() {
        apiInterface.getCountryListData().enqueue(new Callback<List<CountryPojo>>() {
            @Override
            public void onResponse(Call<List<CountryPojo>> call, Response<List<CountryPojo>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<CountryPojo>> call, Throwable t) {

            }
        });
    }
}
