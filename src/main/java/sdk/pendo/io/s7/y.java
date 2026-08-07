package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0006\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/s7/y;", "", "", TtmlNode.RUBY_DELIMITER, "Ljava/util/TreeSet;", "tokens", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Ljava/lang/String;", "()Ljava/lang/String;", "TAG", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class y {
    public static final y a = new y();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final String TAG;

    static {
        Intrinsics.checkNotNullExpressionValue("y", "getSimpleName(...)");
        TAG = "y";
    }

    private y() {
    }

    public final String a() {
        return TAG;
    }

    public final String a(String delimiter, TreeSet<String> tokens) {
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        StringBuilder sb = new StringBuilder("");
        Iterator<String> it = tokens.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(delimiter);
        }
        if (!Intrinsics.areEqual(delimiter, "")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
