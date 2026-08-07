package com.pspdfkit.document.providers;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.pspdfkit.internal.wg;
import com.pspdfkit.utils.PdfLog;
import java.io.InputStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001cB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0014\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/pspdfkit/document/providers/AssetDataProvider;", "Lcom/pspdfkit/document/providers/InputStreamDataProvider;", "Landroid/os/Parcelable;", "Lcom/pspdfkit/document/providers/UriDataProvider;", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "", "<init>", "(Ljava/lang/String;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAssetName", "()Ljava/lang/String;", "size", "", "openInputStream", "Ljava/io/InputStream;", "getSize", "getUid", "getTitle", "describeContents", "", "writeToParcel", "", "dest", "flags", "getUri", "Landroid/net/Uri;", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class AssetDataProvider extends InputStreamDataProvider implements Parcelable, UriDataProvider {
    private static final String LOG_TAG = "Nutri.AssetDataProvider";
    private final String assetName;
    private long size;
    public static final int $stable = 8;
    public static final Parcelable.Creator<AssetDataProvider> CREATOR = new Parcelable.Creator<AssetDataProvider>() { // from class: com.pspdfkit.document.providers.AssetDataProvider$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetDataProvider createFromParcel(Parcel source) {
            source.getClass();
            return new AssetDataProvider(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetDataProvider[] newArray(int size) {
            return new AssetDataProvider[size];
        }
    };

    public AssetDataProvider(String str) {
        str.getClass();
        this.assetName = str;
        this.size = -1L;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAssetName() {
        return this.assetName;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public long getSize() {
        long j = this.size;
        if (j >= 0) {
            return j;
        }
        try {
            if (getInputStreamPosition() != 0) {
                reopenInputStream();
            }
            long jAvailable = getInputStream().available();
            this.size = jAvailable;
            PdfLog.v(LOG_TAG, "Asset %s size is %d.", this.assetName, Long.valueOf(jAvailable));
            return this.size;
        } catch (Exception e) {
            PdfLog.d(LOG_TAG, e, "Could not retrieve asset size!", new Object[0]);
            return -1L;
        }
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public String getTitle() {
        return wg.a(this.assetName);
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public String getUid() {
        return "asset-" + this.assetName;
    }

    @Override // com.pspdfkit.document.providers.UriDataProvider
    public Uri getUri() {
        Uri uriBuild = Uri.parse("file:///android_asset/").buildUpon().appendPath(this.assetName).build();
        uriBuild.getClass();
        return uriBuild;
    }

    @Override // com.pspdfkit.document.providers.InputStreamDataProvider
    public InputStream openInputStream() throws Exception {
        InputStream inputStreamOpen = getContext().getAssets().open(this.assetName, 1);
        inputStreamOpen.getClass();
        return inputStreamOpen;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeString(this.assetName);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AssetDataProvider(Parcel parcel) {
        parcel.getClass();
        String string = parcel.readString();
        string.getClass();
        this(string);
    }
}
