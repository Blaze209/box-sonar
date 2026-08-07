package sdk.pendo.io.c3;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import sdk.pendo.io.x2.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b!\u0010\"J#\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J)\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\b\u0010\u0005\u001a\u00020\fH\u0001J\b\u0010\u000e\u001a\u00020\rH\u0016R(\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lsdk/pendo/io/c3/a;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "clazz", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "b", "", "i", "(ILkotlin/reflect/KClass;)Ljava/lang/Object;", "c", "", "", "toString", "", "Ljava/util/List;", "get_values", "()Ljava/util/List;", "get_values$annotations", "()V", "_values", "", "Ljava/lang/Boolean;", "getUseIndexedValues", "()Ljava/lang/Boolean;", "useIndexedValues", "I", "getIndex", "()I", "setIndex", "(I)V", FirebaseAnalytics.Param.INDEX, "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<Object> _values;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Boolean useIndexedValues;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private int index;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final <T> T b(KClass<?> clazz) {
        Object obj = this._values.get(this.index);
        T t = null;
        if (!clazz.isInstance(obj)) {
            obj = null;
        }
        if (obj != null) {
            t = (T) obj;
        }
        if (t != null) {
            a();
        }
        return t;
    }

    public <T> T a(int i, KClass<?> clazz) throws e {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this._values.size() > i) {
            return (T) this._values.get(i);
        }
        throw new e("Can't get injected parameter #" + i + " from " + this + " for type '" + sdk.pendo.io.h3.a.a(clazz) + '\'');
    }

    public <T> T c(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this._values.isEmpty()) {
            return null;
        }
        Boolean bool = this.useIndexedValues;
        if (bool == null) {
            T t = (T) b(clazz);
            if (t != null) {
                return t;
            }
        } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return (T) b(clazz);
        }
        return (T) a(clazz);
    }

    public String toString() {
        return "DefinitionParameters" + CollectionsKt.toList(this._values);
    }

    public a(List<Object> _values, Boolean bool) {
        Intrinsics.checkNotNullParameter(_values, "_values");
        this._values = _values;
        this.useIndexedValues = bool;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001c A[RETURN] */
    private final <T> T a(KClass<?> clazz) {
        for (T t : this._values) {
            if (clazz.isInstance(t)) {
                if (t != null) {
                    return t;
                }
                return null;
            }
        }
        t = null;
        if (t != null) {
            return t;
        }
        return null;
    }

    public /* synthetic */ a(List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? null : bool);
    }

    public final void a() {
        if (this.index < CollectionsKt.getLastIndex(this._values)) {
            this.index++;
        }
    }
}
