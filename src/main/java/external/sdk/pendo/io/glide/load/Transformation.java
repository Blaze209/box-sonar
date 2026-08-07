package external.sdk.pendo.io.glide.load;

import android.content.Context;
import java.security.MessageDigest;
import sdk.pendo.io.e.f;
import sdk.pendo.io.h.c;

/* JADX INFO: loaded from: classes4.dex */
public interface Transformation<T> extends f {
    c<T> transform(Context context, c<T> cVar, int i, int i2);

    @Override // sdk.pendo.io.e.f
    /* synthetic */ void updateDiskCacheKey(MessageDigest messageDigest);
}
