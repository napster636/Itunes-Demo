package recycle.demo.com.mvp_recycleview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jpotts18 on 5/12/15.
 */
public class Repo implements Parcelable{

    @SerializedName("collectionName")
    @Expose
    public String collectionName;

    @SerializedName("trackName")
    @Expose
    public String trackName;

    @SerializedName("artworkUrl60")
    @Expose
    public String artworkUrl60;

    @SerializedName("artistName")
    @Expose
    public String artistName;

    @SerializedName("collectionArtistName")
    @Expose
    public String collectionArtistName;

    @SerializedName("primaryGenreName")
    @Expose
    public String primaryGenreName;

    @SerializedName("releaseDate")
    @Expose
    public String releaseDate;


    protected Repo(Parcel in) {
        collectionName = in.readString();
        trackName = in.readString();
        artworkUrl60 = in.readString();
        artistName = in.readString();
        collectionArtistName = in.readString();
        primaryGenreName = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<Repo> CREATOR = new Creator<Repo>() {
        @Override
        public Repo createFromParcel(Parcel in) {
            return new Repo(in);
        }

        @Override
        public Repo[] newArray(int size) {
            return new Repo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(collectionName);
        dest.writeString(trackName);
        dest.writeString(artworkUrl60);
        dest.writeString(artistName);
        dest.writeString(collectionArtistName);
        dest.writeString(primaryGenreName);
        dest.writeString(releaseDate);
    }



}
