package recycle.demo.com.mvp_recycleview.retrofit;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by jpotts18 on 5/12/15.
 */

public interface GithubService {
    /*@GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repo>> callback);*/

    @GET("/{user}")
    void listRepos(@Path("user") String user, Callback<JsonResponse> callback);
}