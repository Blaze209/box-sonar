package sdk.pendo.io.v6;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/v6/a;", "", "x", "y", "", "b", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(a aVar, float f, float f2) {
        return aVar.getBoundsInScreen().getLeft() <= f && aVar.getBoundsInScreen().getRight() >= f && aVar.getBoundsInScreen().getTop() <= f2 && aVar.getBoundsInScreen().getBottom() >= f2;
    }
}
