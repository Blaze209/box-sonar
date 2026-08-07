package sdk.pendo.io.d7;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.style.LogicalEdge;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/d7/b;", "Lcom/facebook/react/uimanager/style/LogicalEdge;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class e {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b.START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[b.END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public static final LogicalEdge a(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return LogicalEdge.ALL;
            case 2:
                return LogicalEdge.LEFT;
            case 3:
                return LogicalEdge.TOP;
            case 4:
                return LogicalEdge.RIGHT;
            case 5:
                return LogicalEdge.BOTTOM;
            case 6:
                return LogicalEdge.START;
            case 7:
                return LogicalEdge.END;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
