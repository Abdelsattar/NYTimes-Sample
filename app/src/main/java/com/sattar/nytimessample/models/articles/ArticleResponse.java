package com.sattar.nytimessample.models.articles;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse implements Parcelable {

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("num_results")
	private int numResults;

	@SerializedName("status")
	private String status;

	public ArticleResponse(String status) {
		this.status = status;
	}

	protected ArticleResponse(Parcel in) {
		copyright = in.readString();
		numResults = in.readInt();
		status = in.readString();
	}

	public static final Creator<ArticleResponse> CREATOR = new Creator<ArticleResponse>() {
		@Override
		public ArticleResponse createFromParcel(Parcel in) {
			return new ArticleResponse(in);
		}

		@Override
		public ArticleResponse[] newArray(int size) {
			return new ArticleResponse[size];
		}
	};

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setNumResults(int numResults){
		this.numResults = numResults;
	}

	public int getNumResults(){
		return numResults;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(copyright);
		parcel.writeInt(numResults);
		parcel.writeString(status);
	}
}