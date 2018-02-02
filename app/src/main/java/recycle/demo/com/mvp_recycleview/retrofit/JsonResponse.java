package recycle.demo.com.mvp_recycleview.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import recycle.demo.com.mvp_recycleview.model.Repo;


public class JsonResponse {

    private static JsonResponse instance = null;

    public static JsonResponse getInstance() {
        if (instance == null) {
            instance = new JsonResponse();
        }
        return instance;
    }

    @SerializedName("results")
    @Expose
    private ArrayList<Repo> data = new ArrayList<>();

    public ArrayList<Repo> getData() {
        return data;
    }

    public void setData(ArrayList<Repo> data) {
        this.data = data;
    }
}