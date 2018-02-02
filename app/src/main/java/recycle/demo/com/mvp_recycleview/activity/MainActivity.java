package recycle.demo.com.mvp_recycleview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

import butterknife.Bind;
import butterknife.ButterKnife;
import recycle.demo.com.mvp_recycleview.R;
import recycle.demo.com.mvp_recycleview.model.Repo;
import recycle.demo.com.mvp_recycleview.retrofit.JsonResponse;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.detailIMG)
    ImageView detailImage;

    @Bind(R.id.detailName)
    TextView detailName;

    @Bind(R.id.detailArtistName)
    TextView detailArtistName;

    @Bind(R.id.detailcollectionArtistName)
    TextView detailcollectionArtistName;

    @Bind(R.id.detailDate)
    TextView detailDate;

    @Bind(R.id.detailprimaryGenreName)
    TextView detailprimaryGenreName;

    AQuery aq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        aq = new AQuery(this);

        Repo data = getIntent().getParcelableExtra("detailedData");
        aq.id(detailImage).image(data.artworkUrl60,true,true);
         detailName.setText(data.collectionName);
        detailArtistName.setText(data.artistName);
        detailcollectionArtistName.setText(data.collectionArtistName);
        detailprimaryGenreName.setText(data.primaryGenreName);
        detailDate.setText(data.releaseDate);

    }
}
