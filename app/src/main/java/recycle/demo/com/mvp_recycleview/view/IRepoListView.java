package recycle.demo.com.mvp_recycleview.view;

import recycle.demo.com.mvp_recycleview.retrofit.JsonResponse;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jpotts18 on 5/11/15.
 */
public interface IRepoListView {
    void onReposLoadedSuccess(JsonResponse list, Response response);
    void onReposLoadedFailure(RetrofitError error);

    void onValidationSuccess(String strName);
    void onValidationFaliure();

}
