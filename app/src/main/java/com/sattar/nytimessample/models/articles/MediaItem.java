package com.sattar.nytimessample.models.articles;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MediaItem implements Parcelable {

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("media-metadata")
	private List<MediaMetadataItem> mediaMetadata;

	@SerializedName("subtype")
	private String subtype;

	@SerializedName("caption")
	private String caption;

	@SerializedName("type")
	private String type;

	@SerializedName("approved_for_syndication")
	private int approvedForSyndication;


	protected MediaItem(Parcel in) {
		copyright = in.readString();
		mediaMetadata = in.createTypedArrayList(MediaMetadataItem.CREATOR);
		subtype = in.readString();
		caption = in.readString();
		type = in.readString();
		approvedForSyndication = in.readInt();
	}

	public static final Creator<MediaItem> CREATOR = new Creator<MediaItem>() {
		@Override
		public MediaItem createFromParcel(Parcel in) {
			return new MediaItem(in);
		}

		@Override
		public MediaItem[] newArray(int size) {
			return new MediaItem[size];
		}
	};

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setMediaMetadata(List<MediaMetadataItem> mediaMetadata){
		this.mediaMetadata = mediaMetadata;
	}

	public List<MediaMetadataItem> getMediaMetadata(){
		return mediaMetadata;
	}

	public void setSubtype(String subtype){
		this.subtype = subtype;
	}

	public String getSubtype(){
		return subtype;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setApprovedForSyndication(int approvedForSyndication){
		this.approvedForSyndication = approvedForSyndication;
	}

	public int getApprovedForSyndication(){
		return approvedForSyndication;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(copyright);
		parcel.writeTypedList(mediaMetadata);
		parcel.writeString(subtype);
		parcel.writeString(caption);
		parcel.writeString(type);
		parcel.writeInt(approvedForSyndication);
	}
}