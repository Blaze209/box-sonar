package external.sdk.pendo.io.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class ThumbFetcher implements external.sdk.pendo.io.glide.load.data.a<InputStream> {
    private static final String TAG = "MediaStoreThumbFetcher";
    private InputStream inputStream;
    private final Uri mediaStoreImageUri;
    private final c opener;

    static class a implements external.sdk.pendo.io.glide.load.data.mediastore.b {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // external.sdk.pendo.io.glide.load.data.mediastore.b
        public Cursor a(Uri uri) {
            return MAMContentResolverManagement.query(this.a, MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class b implements external.sdk.pendo.io.glide.load.data.mediastore.b {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // external.sdk.pendo.io.glide.load.data.mediastore.b
        public Cursor a(Uri uri) {
            return MAMContentResolverManagement.query(this.a, MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    ThumbFetcher(Uri uri, c cVar) {
        this.mediaStoreImageUri = uri;
        this.opener = cVar;
    }

    private static ThumbFetcher build(Context context, Uri uri, external.sdk.pendo.io.glide.load.data.mediastore.b bVar) {
        return new ThumbFetcher(uri, new c(external.sdk.pendo.io.glide.a.a(context).g().a(), bVar, external.sdk.pendo.io.glide.a.a(context).b(), context.getContentResolver()));
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        return build(context, uri, new a(context.getContentResolver()));
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        return build(context, uri, new b(context.getContentResolver()));
    }

    private InputStream openThumbInputStream() throws Throwable {
        InputStream inputStreamC = this.opener.c(this.mediaStoreImageUri);
        int iA = inputStreamC != null ? this.opener.a(this.mediaStoreImageUri) : -1;
        return iA != -1 ? new sdk.pendo.io.f.b(inputStreamC, iA) : inputStreamC;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cancel() {
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void cleanup() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public sdk.pendo.io.e.a getDataSource() {
        return sdk.pendo.io.e.a.LOCAL;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a
    public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super InputStream> interfaceC0307a) throws Throwable {
        try {
            InputStream inputStreamOpenThumbInputStream = openThumbInputStream();
            this.inputStream = inputStreamOpenThumbInputStream;
            interfaceC0307a.a(inputStreamOpenThumbInputStream);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to find thumbnail file", e);
            }
            interfaceC0307a.a((Exception) e);
        }
    }
}
