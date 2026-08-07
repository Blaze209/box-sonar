package sdk.pendo.io.w5;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011JD\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tH\u0007JE\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\r\u001a\u00020\u000fH\u0007¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/w5/b;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "Lsdk/pendo/io/d3/a;", "qualifier", "Lkotlin/Function0;", "Lsdk/pendo/io/c3/a;", "Lexternal/sdk/pendo/io/org/koin/core/parameter/ParametersDefinition;", "parameters", "Lkotlin/Lazy;", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/Class;Lsdk/pendo/io/d3/a;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lsdk/pendo/io/u2/a;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {
    public static final b a = new b();

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class a<T> extends Lambda implements Function0<T> {
        final /* synthetic */ Class<?> a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0<sdk.pendo.io.c3.a> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Class<?> cls, sdk.pendo.io.d3.a aVar, Function0<? extends sdk.pendo.io.c3.a> function0) {
            super(0);
            this.a = cls;
            this.b = aVar;
            this.c = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final T invoke() {
            return (T) b.a(this.a, this.b, this.c);
        }
    }

    private b() {
    }

    @JvmStatic
    public static final <T> T a(Class<?> clazz, sdk.pendo.io.d3.a qualifier, Function0<? extends sdk.pendo.io.c3.a> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) a().a(JvmClassMappingKt.getKotlinClass(clazz), qualifier, parameters);
    }

    @JvmStatic
    public static final <T> Lazy<T> b(Class<?> clazz, sdk.pendo.io.d3.a qualifier, Function0<? extends sdk.pendo.io.c3.a> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new a(clazz, qualifier, parameters));
    }

    @JvmStatic
    public static final sdk.pendo.io.u2.a a() {
        return c.a.a();
    }

    @JvmStatic
    public static final <T> Lazy<T> a(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return a(clazz, null, null, 6, null);
    }

    public static /* synthetic */ Lazy a(Class cls, sdk.pendo.io.d3.a aVar, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar = null;
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        return b(cls, aVar, function0);
    }
}
