package com.box.android.contentpicker.uploadcontent;

import com.box.android.base.presentation.components.permission.PermissionReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CaptureMediaHandlerReducer$build$3 extends FunctionReferenceImpl implements Function1<PermissionReducer.Action, CaptureMediaHandlerReducer.Action.PermissionAction> {
    public static final CaptureMediaHandlerReducer$build$3 INSTANCE = new CaptureMediaHandlerReducer$build$3();

    CaptureMediaHandlerReducer$build$3() {
        super(1, CaptureMediaHandlerReducer.Action.PermissionAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CaptureMediaHandlerReducer.Action.PermissionAction invoke(PermissionReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CaptureMediaHandlerReducer.Action.PermissionAction(p0);
    }
}
