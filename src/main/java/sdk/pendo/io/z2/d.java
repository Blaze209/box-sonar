package sdk.pendo.io.z2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000b¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/z2/d;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/z2/c;", "b", "()Ljava/lang/Object;", "Lsdk/pendo/io/z2/b;", "context", "", "c", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/z2/b;)Ljava/lang/Object;", "Ljava/lang/Object;", "value", "Lsdk/pendo/io/w2/a;", "beanDefinition", "<init>", "(Lsdk/pendo/io/w2/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class d<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private T value;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ d<T> a;
        final /* synthetic */ b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d<T> dVar, b bVar) {
            super(0);
            this.a = dVar;
            this.b = bVar;
        }

        public final void a() {
            if (this.a.c(this.b)) {
                return;
            }
            d<T> dVar = this.a;
            ((d) dVar).value = dVar.a(this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(sdk.pendo.io.w2.a<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    @Override // sdk.pendo.io.z2.c
    public T b(b context) {
        Intrinsics.checkNotNullParameter(context, "context");
        sdk.pendo.io.i3.b.a.a(this, new a(this, context));
        return b();
    }

    public boolean c(b context) {
        return this.value != null;
    }

    private final T b() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    }

    @Override // sdk.pendo.io.z2.c
    public T a(b context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.value == null ? (T) super.a(context) : b();
    }
}
