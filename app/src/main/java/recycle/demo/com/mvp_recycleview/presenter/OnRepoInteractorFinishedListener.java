package recycle.demo.com.mvp_recycleview.presenter;

import recycle.demo.com.mvp_recycleview.retrofit.JsonResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jpotts18 on 5/12/15.
 */
public interface OnRepoInteractorFinishedListener {
    void onNetworkSuccess(JsonResponse list, Response response);
    void onNetworkFailure(RetrofitError error);
}
