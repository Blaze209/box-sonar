package sdk.pendo.io.o4;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0014J\u0018\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H$R\u0014\u0010\n\u001a\u00028\u00008$X¤\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/o4/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/k3/j;", "Lsdk/pendo/io/k3/o;", "observer", "", "b", "d", CmcdData.STREAM_TYPE_LIVE, "()Ljava/lang/Object;", "initialValue", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class a<T> extends j<T> {
    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        d(observer);
        observer.onNext(l());
    }

    protected abstract void d(o<? super T> observer);

    protected abstract T l();
}
