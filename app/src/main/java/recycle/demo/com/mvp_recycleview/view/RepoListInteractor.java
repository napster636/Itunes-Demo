package recycle.demo.com.mvp_recycleview.view;

import recycle.demo.com.mvp_recycleview.presenter.OnRepoInteractorFinishedListener;
import recycle.demo.com.mvp_recycleview.retrofit.GithubService;
import recycle.demo.com.mvp_recycleview.retrofit.JsonResponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by jpotts18 on 5/11/15.
 */
public class RepoListInteractor implements Callback<JsonResponse> {

    private OnRepoInteractorFinishedListener listener;

    public RepoListInteractor(OnRepoInteractorFinishedListener listener) {
        this.listener = listener;
    }

    private RestAdapter initRestAdapter(){
        JsonResponse list = new JsonResponse();
        list.getData().clear();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://itunes.apple.com/search?term=")
//                .setEndpoint("https://api.github.com")
                .build();
        return restAdapter;
    }

    public void loadRecentCommits(String username) {
        RestAdapter adapter = initRestAdapter();
        adapter.create(GithubService.class).listRepos(username, this);
    }

    @Override
    public void success(JsonResponse list, Response response) {
        /*Collections.sort(list, new Comparator<Repo>() {
            @Override
            public int compare(Repo left, Repo right) {
                return (left.stars > right.stars) ? -1 : 1;
            }
        });*/

        listener.onNetworkSuccess(list, response);
    }

    @Override
    public void failure(RetrofitError error) {
        listener.onNetworkFailure(error);
    }
}
