package recycle.demo.com.mvp_recycleview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import recycle.demo.com.mvp_recycleview.R;
import recycle.demo.com.mvp_recycleview.adapter.MyRecyclerViewAdapter;
import recycle.demo.com.mvp_recycleview.model.Repo;
import recycle.demo.com.mvp_recycleview.presenter.RepoListPresenter;
import recycle.demo.com.mvp_recycleview.retrofit.JsonResponse;
import recycle.demo.com.mvp_recycleview.view.IRepoListView;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RepoListActivity extends ActionBarActivity implements IRepoListView, MyRecyclerViewAdapter.ItemClickListener {


    @Bind(R.id.repo_list_view)
    ListView listView;

    @Bind(R.id.titleName)
    EditText txtSearchName;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private RepoListPresenter presenter;
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);
        presenter = new RepoListPresenter(this);
//        listView.setOnItemClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        txtSearchName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    JsonResponse.getInstance().getData().clear();
                    presenter.validateField(v.getText().toString());
//                    presenter.loadCommits(v.getText().toString());
//                    performSearch();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onReposLoadedSuccess(JsonResponse list, Response response) {
//        listView.setAdapter(new RepoAdapter(this, list));
        adapter = new MyRecyclerViewAdapter(this, list.getData());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        if (list.getData().size()==0){
            Toast.makeText(this, "Data not foung!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onReposLoadedFailure(RetrofitError error) {
        Toast.makeText(this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationSuccess(String strName) {
        Toast.makeText(this, "onValidationSuccess", Toast.LENGTH_SHORT).show();
        presenter.loadCommits(strName.toString());
    }

    @Override
    public void onValidationFaliure() {
        Toast.makeText(this, "Please enter valid search item", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemClick(View view, int position) {
        Repo repo =  adapter.getItem(position);
        Toast.makeText(this, repo.collectionName, Toast.LENGTH_SHORT).show();

        Intent in = new Intent(RepoListActivity.this, MainActivity.class);
        in.putExtra("detailedData", (Parcelable) repo);
        startActivity(in);

    }

    public String moketest(String strName){

        Log.i("",strName);
        return strName;

    }
}
