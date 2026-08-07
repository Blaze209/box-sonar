package sdk.pendo.io.i3;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxFile;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003J\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\nJ-\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\n\u0010\r\u001a\u00060\u0001j\u0002`\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0006\u0010\u0010J\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0012¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/i3/b;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/reflect/KClass;", "kClass", "b", "Lkotlin/LazyThreadSafetyMode;", "R", "Lexternal/sdk/pendo/io/org/koin/mp/Lockable;", BoxFile.FIELD_LOCK, "Lkotlin/Function0;", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "c", "<init>", "()V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final LazyThreadSafetyMode a() {
        return LazyThreadSafetyMode.SYNCHRONIZED;
    }

    public final String b() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final <K, V> Map<K, V> c() {
        return new ConcurrentHashMap();
    }

    public final String a(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        String name = JvmClassMappingKt.getJavaClass((KClass) kClass).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    public final String a(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        StringBuilder sbAppend = new StringBuilder().append(e).append("\n\t");
        StackTraceElement[] stackTrace = e.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            if (StringsKt.contains$default((CharSequence) className, (CharSequence) "sun.reflect", false, 2, (Object) null)) {
                break;
            }
            arrayList.add(stackTraceElement);
        }
        return sbAppend.append(CollectionsKt.joinToString$default(arrayList, "\n\t", null, null, 0, null, null, 62, null)).toString();
    }

    public final <R> R a(Object lock, Function0<? extends R> block) {
        R rInvoke;
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (lock) {
            rInvoke = block.invoke();
        }
        return rInvoke;
    }
}
