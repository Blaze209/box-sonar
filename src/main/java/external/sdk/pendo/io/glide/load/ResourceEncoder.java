package external.sdk.pendo.io.glide.load;

import java.io.File;
import sdk.pendo.io.e.d;
import sdk.pendo.io.h.c;

/* JADX INFO: loaded from: classes4.dex */
public interface ResourceEncoder<T> extends d<c<T>> {
    @Override // sdk.pendo.io.e.d
    /* synthetic */ boolean encode(Object obj, File file, Options options);

    sdk.pendo.io.e.c getEncodeStrategy(Options options);
}
