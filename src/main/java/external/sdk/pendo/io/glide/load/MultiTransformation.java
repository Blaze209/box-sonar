package external.sdk.pendo.io.glide.load;

import android.content.Context;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import sdk.pendo.io.h.c;

/* JADX INFO: loaded from: classes4.dex */
public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = collection;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.transformations.equals(((MultiTransformation) obj).transformations);
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return this.transformations.hashCode();
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public c<T> transform(Context context, c<T> cVar, int i, int i2) {
        Iterator<? extends Transformation<T>> it = this.transformations.iterator();
        c<T> cVar2 = cVar;
        while (it.hasNext()) {
            c<T> cVarTransform = it.next().transform(context, cVar2, i, i2);
            if (cVar2 != null && !cVar2.equals(cVar) && !cVar2.equals(cVarTransform)) {
                cVar2.recycle();
            }
            cVar2 = cVarTransform;
        }
        return cVar2;
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator<? extends Transformation<T>> it = this.transformations.iterator();
        while (it.hasNext()) {
            it.next().updateDiskCacheKey(messageDigest);
        }
    }

    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.transformations = Arrays.asList(transformationArr);
    }
}
