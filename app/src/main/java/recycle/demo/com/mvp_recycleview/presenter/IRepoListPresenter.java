package recycle.demo.com.mvp_recycleview.presenter;

/**
 * Created by jpotts18 on 5/11/15.
 */
public interface IRepoListPresenter {
    public void loadCommits(String username);
    public void validateField(String strName);
}
