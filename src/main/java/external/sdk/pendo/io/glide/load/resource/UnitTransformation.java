package external.sdk.pendo.io.glide.load.resource;

import android.content.Context;
import external.sdk.pendo.io.glide.load.Transformation;
import java.security.MessageDigest;
import sdk.pendo.io.h.c;

/* JADX INFO: loaded from: classes4.dex */
public final class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    private UnitTransformation() {
    }

    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation) TRANSFORMATION;
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public c<T> transform(Context context, c<T> cVar, int i, int i2) {
        return cVar;
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
