package androidx.compose.ui.autofill;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentDataType.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"ContentDataType", "Landroidx/compose/ui/autofill/ContentDataType;", "dataType", "", "getDataType", "(Landroidx/compose/ui/autofill/ContentDataType;)I", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContentDataType_androidKt {
    public static final ContentDataType ContentDataType(int i) {
        return AndroidContentDataType.m6311boximpl(AndroidContentDataType.m6312constructorimpl(i));
    }

    public static final int getDataType(ContentDataType contentDataType) {
        Intrinsics.checkNotNull(contentDataType, "null cannot be cast to non-null type androidx.compose.ui.autofill.AndroidContentDataType");
        return ((AndroidContentDataType) contentDataType).m6317unboximpl();
    }
}
