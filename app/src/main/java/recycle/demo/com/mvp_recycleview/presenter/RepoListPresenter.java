package recycle.demo.com.mvp_recycleview.presenter;

import recycle.demo.com.mvp_recycleview.retrofit.JsonResponse;
import recycle.demo.com.mvp_recycleview.view.IRepoListView;
import recycle.demo.com.mvp_recycleview.view.RepoListInteractor;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jpotts18 on 5/11/15.
 */
public class RepoListPresenter implements IRepoListPresenter, OnRepoInteractorFinishedListener {

    private IRepoListView view;
    private RepoListInteractor interactor;

    public RepoListPresenter(IRepoListView view) {
        this.view = view;
        this.interactor = new RepoListInteractor(this); // pass in the InteractorListener
    }

    @Override
    public void loadCommits(String username) {
        interactor.loadRecentCommits(username);
    }

    @Override
    public void validateField(String strName) {
        if (strName.length()==0){
            view.onValidationFaliure();
        }else {
            view.onValidationSuccess(strName);
        }
    }

    @Override
    public void onNetworkSuccess(JsonResponse list, Response response) {
        view.onReposLoadedSuccess(list, response);
    }

    @Override
    public void onNetworkFailure(RetrofitError error) {
        view.onReposLoadedFailure(error);
    }
}
