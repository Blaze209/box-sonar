package external.sdk.pendo.io.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import external.sdk.pendo.io.glide.load.Options;
import java.util.List;
import sdk.pendo.io.e.g;
import sdk.pendo.io.e.i;
import sdk.pendo.io.h.c;
import sdk.pendo.io.o.b;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class ResourceDrawableDecoder implements i<Uri, Drawable> {
    private static final String ANDROID_PACKAGE_NAME = "android";
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int MISSING_RESOURCE_ID = 0;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    public static final g<Resources.Theme> THEME = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.Theme");
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final Context context;

    public ResourceDrawableDecoder(Context context) {
        this.context = context.getApplicationContext();
    }

    private Context findContextForPackage(Uri uri, String str) {
        if (str.equals(this.context.getPackageName())) {
            return this.context;
        }
        try {
            return this.context.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.context.getPackageName())) {
                return this.context;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e);
        }
    }

    private int findResourceIdFromResourceIdUri(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e);
        }
    }

    private int findResourceIdFromTypeAndNameResourceUri(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int findResourceIdFromUri(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return findResourceIdFromTypeAndNameResourceUri(context, uri);
        }
        if (pathSegments.size() == 1) {
            return findResourceIdFromResourceIdUri(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // sdk.pendo.io.e.i
    public c<Drawable> decode(Uri uri, int i, int i2, Options options) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new IllegalStateException("Package name for " + uri + " is null or empty");
        }
        Context contextFindContextForPackage = findContextForPackage(uri, authority);
        int iFindResourceIdFromUri = findResourceIdFromUri(contextFindContextForPackage, uri);
        Resources.Theme theme = ((String) k.a(authority)).equals(this.context.getPackageName()) ? (Resources.Theme) options.get(THEME) : null;
        Context context = this.context;
        return a.a(theme == null ? b.a(context, contextFindContextForPackage, iFindResourceIdFromUri) : b.a(context, iFindResourceIdFromUri, theme));
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(Uri uri, Options options) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }
}
