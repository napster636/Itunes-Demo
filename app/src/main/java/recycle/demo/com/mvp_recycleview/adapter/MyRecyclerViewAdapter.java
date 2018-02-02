package recycle.demo.com.mvp_recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.ImageOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import recycle.demo.com.mvp_recycleview.R;
import recycle.demo.com.mvp_recycleview.model.Repo;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    private int lastPosition = -1;

    private List<Repo> list = new ArrayList<>();
    private Context context;
    AQuery aq;

    public MyRecyclerViewAdapter(Context context, List<Repo> list) {
        this.list = list;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        aq=new AQuery(context);
    }



    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerow, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        setAnimation(holder.itemView,position);
        Repo repoData = list.get(position);
        holder.myTextView.setText(repoData.collectionName);

        ImageOptions option = new ImageOptions();
        option.round = 90;
        option.fileCache = true;
        option.memCache = true;
        option.animation = android.R.anim.fade_in;
        aq.id(holder.img).image(repoData.artworkUrl60,option);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return list.size();
    }


    public Repo getItem(int position) {
        return list.get(position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        public TextView myTextView;

        @Bind(R.id.tvtitleName)
        TextView myTextView;

        @Bind(R.id.img)
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
//            myTextView = itemView.findViewById(R.id.tvAnimalName);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            AlphaAnimation anim = new AlphaAnimation(0.0f,1.0f);
            anim.setDuration(1000);//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }
}