package sdk.pendo.io.z2;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/z2/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/z2/c;", "Lsdk/pendo/io/z2/b;", "context", "b", "(Lsdk/pendo/io/z2/b;)Ljava/lang/Object;", "Lsdk/pendo/io/w2/a;", "beanDefinition", "<init>", "(Lsdk/pendo/io/w2/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class a<T> extends c<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(sdk.pendo.io.w2.a<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    @Override // sdk.pendo.io.z2.c
    public T b(b context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return a(context);
    }
}
