package com.rdo.octo.numberslight.detail;

import com.rdo.octo.numberslight.entities.NumberDetail;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;

public class DetailPresenter implements Callback<NumberDetail> {

    private DetailView view;
    private DetailService service;

    @Inject
    public DetailPresenter(DetailView view, DetailService service) {
        this.view = view;
        this.service = service;
    }

    public void loadDetail(@NotNull String name) {
        service.getDetail(name).enqueue(this);
    }

    @Override
    public void onResponse(@NotNull Call<NumberDetail> call, Response<NumberDetail> response) {
        if (response.body() != null) {
            view.displayDetail(response.body());
        }
    }

    @Override
    public void onFailure(@NotNull Call<NumberDetail> call, @NotNull Throwable t) {
        view.displayError();
    }
}
