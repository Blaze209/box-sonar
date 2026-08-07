package sdk.pendo.io.r7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.j7.v;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0005\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/r7/f;", "", "Lsdk/pendo/io/j7/v;", "root", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "child", "Lsdk/pendo/io/j7/c;", "parent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "rootList", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final ArrayList<v> rootList = new ArrayList<>();

    public final void a(v child, sdk.pendo.io.j7.c parent) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.a(child);
    }

    public final void a(v root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.rootList.add(root);
    }

    public final ArrayList<v> a() {
        return this.rootList;
    }
}
