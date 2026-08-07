package sdk.pendo.io.z2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0006*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0001\bB\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0006¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\b\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/z2/c;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lexternal/sdk/pendo/io/org/koin/mp/Lockable;", "Lsdk/pendo/io/z2/b;", "context", "b", "(Lsdk/pendo/io/z2/b;)Ljava/lang/Object;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "other", "", "equals", "", "hashCode", "Lsdk/pendo/io/w2/a;", "Lsdk/pendo/io/w2/a;", "()Lsdk/pendo/io/w2/a;", "beanDefinition", "<init>", "(Lsdk/pendo/io/w2/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final sdk.pendo.io.w2.a<T> beanDefinition;

    public c(sdk.pendo.io.w2.a<T> beanDefinition) {
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
        this.beanDefinition = beanDefinition;
    }

    public T a(b context) throws sdk.pendo.io.x2.c {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getLogger().a("| (+) '" + this.beanDefinition + '\'');
        try {
            sdk.pendo.io.c3.a aVarB = context.getParameters();
            if (aVarB == null) {
                aVarB = sdk.pendo.io.c3.b.a();
            }
            return this.beanDefinition.a().invoke(context.getScope(), aVarB);
        } catch (Exception e) {
            context.getLogger().b("* Instance creation error : could not create instance for '" + this.beanDefinition + "': " + sdk.pendo.io.i3.b.a.a(e));
            throw new sdk.pendo.io.x2.c("Could not create instance for '" + this.beanDefinition + '\'', e);
        }
    }

    public abstract T b(b context);

    public boolean equals(Object other) {
        c cVar = other instanceof c ? (c) other : null;
        return Intrinsics.areEqual(this.beanDefinition, cVar != null ? cVar.beanDefinition : null);
    }

    public int hashCode() {
        return this.beanDefinition.hashCode();
    }

    public final sdk.pendo.io.w2.a<T> a() {
        return this.beanDefinition;
    }
}
