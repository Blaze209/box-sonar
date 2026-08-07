package com.pspdfkit.media;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.internal.nv;
import com.pspdfkit.internal.z40;
import com.pspdfkit.utils.PdfLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes3.dex */
public class MediaUri implements Parcelable {
    public static final Parcelable.Creator<MediaUri> CREATOR = new Parcelable.Creator<MediaUri>() { // from class: com.pspdfkit.media.MediaUri.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaUri createFromParcel(Parcel parcel) {
            return new MediaUri(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaUri[] newArray(int i) {
            return new MediaUri[i];
        }
    };
    private static final String LOG_TAG = "Nutri.MediaUri";
    private final String options;
    private final UriType type;
    private final String uri;

    public enum UriType {
        MEDIA,
        VIDEO_YOUTUBE,
        GALLERY,
        WEB,
        OTHER
    }

    public MediaUri(UriType uriType, String str, String str2) {
        this.type = uriType;
        this.uri = str;
        this.options = str2;
    }

    public static MediaUri parse(String str) {
        UriType uriType;
        UriType uriType2 = UriType.OTHER;
        String str2 = "";
        if (str.startsWith("pspdfkit://")) {
            String strReplace = str.replace("pspdfkit://", "");
            try {
                strReplace = URLDecoder.decode(strReplace, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                PdfLog.w(LOG_TAG, e, "Can't decode media Uri.", new Object[0]);
            }
            String[] strArrExtractOptionsAndPath = MediaLinkUtils.extractOptionsAndPath(strReplace);
            String str3 = strArrExtractOptionsAndPath[0];
            if (str3 == null) {
                str3 = "";
            }
            str = strArrExtractOptionsAndPath[1];
            if (str == null) {
                str = "";
            }
            if (str.contains("youtube.com/")) {
                uriType = UriType.VIDEO_YOUTUBE;
            } else if (str.endsWith(".gallery")) {
                uriType = UriType.GALLERY;
            } else if (uriHasMediaExtension(str)) {
                uriType = UriType.MEDIA;
            } else {
                uriType = str.startsWith("localhost") ? UriType.OTHER : UriType.WEB;
            }
            str2 = str3;
            uriType2 = uriType;
        }
        return new MediaUri(uriType2, str, str2);
    }

    private static boolean uriHasMediaExtension(String str) {
        String[] strArr = {".3gp", ".mp4", ".ts", ".webm", ".mkv", ".m3u8", ".mov", ".avi", ".mpg", ".m4v", ".bmp", ".gif", ".jpeg", ".png", ".webp", ".mp3", ".flac", ".ota", ".ogg"};
        for (int i = 0; i < 19; i++) {
            if (str.endsWith(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaUri)) {
            return false;
        }
        MediaUri mediaUri = (MediaUri) obj;
        if (this.type == mediaUri.type && this.options.equals(mediaUri.options)) {
            return this.uri.equals(mediaUri.uri);
        }
        return false;
    }

    public Uri getFileUri(Context context) {
        if (this.type == UriType.MEDIA) {
            String uri = getUri();
            if (uri.startsWith("localhost/")) {
                return AssetsContentProvider.getAuthority(context).buildUpon().appendPath(uri.replace("localhost/", "")).build();
            }
        }
        return getParsedUri();
    }

    public String getOptions() {
        return this.options;
    }

    public Uri getParsedUri() {
        return Uri.parse(this.uri);
    }

    public UriType getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    public MediaLinkUtils.VideoSettings getVideoSettingsFromOptions() {
        return MediaLinkUtils.getVideoSettingsFromOptions(getOptions());
    }

    public int hashCode() {
        return this.uri.hashCode() + z40.a(this.options, this.type.hashCode() * 31, 31);
    }

    public boolean isVideoUri() {
        return getType() == UriType.MEDIA || getType() == UriType.VIDEO_YOUTUBE;
    }

    public String toString() {
        return nv.a(new StringBuilder("MediaUri{type=").append(this.type).append(", options='").append(this.options).append("', uri='"), this.uri, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getType().ordinal());
        parcel.writeString(getOptions());
        parcel.writeString(getUri());
    }

    public MediaUri(Parcel parcel) {
        int i = parcel.readInt();
        this.type = i == -1 ? UriType.OTHER : UriType.values()[i];
        this.options = parcel.readString();
        this.uri = parcel.readString();
    }
}
