package com.box.android.preview.document.copytext;

import com.box.android.base.presentation.components.CopyTextReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopySelectedTextReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CopySelectedTextReducer$build$3 extends FunctionReferenceImpl implements Function1<CopyTextReducer.Action, CopySelectedTextReducer.Action.CopyTextAction> {
    public static final CopySelectedTextReducer$build$3 INSTANCE = new CopySelectedTextReducer$build$3();

    CopySelectedTextReducer$build$3() {
        super(1, CopySelectedTextReducer.Action.CopyTextAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/CopyTextReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CopySelectedTextReducer.Action.CopyTextAction invoke(CopyTextReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CopySelectedTextReducer.Action.CopyTextAction(p0);
    }
}
