package sdk.pendo.io.s7;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\f\u0010B)\u0012\u0006\u0010\"\u001a\u00020!\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R(\u0010\u001b\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lsdk/pendo/io/s7/i0;", "Landroid/view/View;", "", "getReference", "", "getFeatureSelector", "Lsdk/pendo/io/s7/i0$b;", "newStatus", "", "setStatus", "Lsdk/pendo/io/s7/i0$a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", TypedValues.Custom.S_REFERENCE, "b", "Ljava/lang/String;", "featureSelector", "c", "Lsdk/pendo/io/s7/i0$b;", "getStatus$pendoIO_release", "()Lsdk/pendo/io/s7/i0$b;", "setStatus$pendoIO_release", "(Lsdk/pendo/io/s7/i0$b;)V", "getStatus$pendoIO_release$annotations", "()V", "status", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "listeners", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class i0 extends View {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private WeakReference<Object> reference;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private String featureSelector;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private b status;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private ArrayList<a> listeners;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/s7/i0$a;", "", "Lsdk/pendo/io/s7/i0$b;", "newStatus", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public interface a {
        void a(b newStatus);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/s7/i0$b;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "UPDATED", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public enum b {
        ENABLED,
        DISABLED,
        UPDATED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(Context context, WeakReference<Object> reference, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reference, "reference");
        this.reference = reference;
        this.featureSelector = str;
        this.status = b.ENABLED;
    }

    public static /* synthetic */ void getStatus$pendoIO_release$annotations() {
    }

    public final void a(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.listeners == null) {
            this.listeners = new ArrayList<>();
        }
        ArrayList<a> arrayList = this.listeners;
        if (arrayList != null) {
            arrayList.add(listener);
        }
    }

    public final String getFeatureSelector() {
        return this.featureSelector;
    }

    public final Object getReference() {
        return this.reference.get();
    }

    /* JADX INFO: renamed from: getStatus$pendoIO_release, reason: from getter */
    public final b getStatus() {
        return this.status;
    }

    public final void setStatus(b newStatus) {
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        this.status = newStatus;
        ArrayList<a> arrayList = this.listeners;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(this.status);
            }
        }
    }

    public final void setStatus$pendoIO_release(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.status = bVar;
    }
}
