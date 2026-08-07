package sdk.pendo.io.w2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0006\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÖ\u0003R3\u0010\u0011\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/w2/c;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/Function1;", "", "Lexternal/sdk/pendo/io/org/koin/core/definition/OnCloseCallback;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/jvm/functions/Function1;", "getOnClose", "()Lkotlin/jvm/functions/Function1;", "onClose", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final /* data */ class c<T> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function1<T, Unit> onClose;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof c) && Intrinsics.areEqual(this.onClose, ((c) other).onClose);
    }

    public int hashCode() {
        Function1<T, Unit> function1 = this.onClose;
        if (function1 == null) {
            return 0;
        }
        return function1.hashCode();
    }

    public String toString() {
        return "Callbacks(onClose=" + this.onClose + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super T, Unit> function1) {
        this.onClose = function1;
    }

    public /* synthetic */ c(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }
}
