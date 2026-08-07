package external.sdk.pendo.io.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.facebook.common.util.UriUtil;
import external.sdk.pendo.io.glide.load.Options;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ResourceUriLoader<DataT> implements external.sdk.pendo.io.glide.load.model.b<Uri, DataT> {
    private static final int INVALID_RESOURCE_ID = 0;
    private static final String TAG = "ResourceUriLoader";
    private final Context context;
    private final external.sdk.pendo.io.glide.load.model.b<Integer, DataT> delegate;

    private static final class a implements sdk.pendo.io.l.d<Uri, AssetFileDescriptor> {
        private final Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // sdk.pendo.io.l.d
        public external.sdk.pendo.io.glide.load.model.b<Uri, AssetFileDescriptor> build(e eVar) {
            return new ResourceUriLoader(this.a, eVar.a(Integer.class, AssetFileDescriptor.class));
        }
    }

    private static final class b implements sdk.pendo.io.l.d<Uri, InputStream> {
        private final Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // sdk.pendo.io.l.d
        public external.sdk.pendo.io.glide.load.model.b<Uri, InputStream> build(e eVar) {
            return new ResourceUriLoader(this.a, eVar.a(Integer.class, InputStream.class));
        }
    }

    ResourceUriLoader(Context context, external.sdk.pendo.io.glide.load.model.b<Integer, DataT> bVar) {
        this.context = context.getApplicationContext();
        this.delegate = bVar;
    }

    public static sdk.pendo.io.l.d<Uri, AssetFileDescriptor> newAssetFileDescriptorFactory(Context context) {
        return new a(context);
    }

    public static sdk.pendo.io.l.d<Uri, InputStream> newStreamFactory(Context context) {
        return new b(context);
    }

    private external.sdk.pendo.io.glide.load.model.b.a<DataT> parseResourceIdUri(Uri uri, int i, int i2, Options options) {
        try {
            int i3 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i3 != 0) {
                return this.delegate.buildLoadData(Integer.valueOf(i3), i, i2, options);
            }
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to parse resource id from: " + uri, e);
            }
            return null;
        }
    }

    private external.sdk.pendo.io.glide.load.model.b.a<DataT> parseResourceNameUri(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.context.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.context.getPackageName());
        if (identifier != 0) {
            return this.delegate.buildLoadData(Integer.valueOf(identifier), i, i2, options);
        }
        if (!Log.isLoggable(TAG, 5)) {
            return null;
        }
        Log.w(TAG, "Failed to find resource id for: " + uri);
        return null;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public external.sdk.pendo.io.glide.load.model.b.a<DataT> buildLoadData(Uri uri, int i, int i2, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return parseResourceIdUri(uri, i, i2, options);
        }
        if (pathSegments.size() == 2) {
            return parseResourceNameUri(uri, i, i2, options);
        }
        if (!Log.isLoggable(TAG, 5)) {
            return null;
        }
        Log.w(TAG, "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme()) && this.context.getPackageName().equals(uri.getAuthority());
    }
}
