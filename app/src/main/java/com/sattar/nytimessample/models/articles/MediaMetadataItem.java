package com.sattar.nytimessample.models.articles;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MediaMetadataItem implements Parcelable {

	@SerializedName("format")
	private String format;

	@SerializedName("width")
	private int width;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	protected MediaMetadataItem(Parcel in) {
		format = in.readString();
		width = in.readInt();
		url = in.readString();
		height = in.readInt();
	}

	public static final Creator<MediaMetadataItem> CREATOR = new Creator<MediaMetadataItem>() {
		@Override
		public MediaMetadataItem createFromParcel(Parcel in) {
			return new MediaMetadataItem(in);
		}

		@Override
		public MediaMetadataItem[] newArray(int size) {
			return new MediaMetadataItem[size];
		}
	};

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(format);
		parcel.writeInt(width);
		parcel.writeString(url);
		parcel.writeInt(height);
	}
}