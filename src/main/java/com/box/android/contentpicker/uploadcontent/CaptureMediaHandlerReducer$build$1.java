package com.box.android.contentpicker.uploadcontent;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CaptureMediaHandlerReducer$build$1 extends FunctionReferenceImpl implements Function2<CaptureMediaHandlerReducer.State, CaptureMediaHandlerReducer.Action, ReducerResult<CaptureMediaHandlerReducer.State, CaptureMediaHandlerReducer.Action>> {
    CaptureMediaHandlerReducer$build$1(Object obj) {
        super(2, obj, CaptureMediaHandlerReducer.class, "reduceCapturePhoto", "reduceCapturePhoto(Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$State;Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<CaptureMediaHandlerReducer.State, CaptureMediaHandlerReducer.Action> invoke(CaptureMediaHandlerReducer.State p0, CaptureMediaHandlerReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((CaptureMediaHandlerReducer) this.receiver).reduceCapturePhoto(p0, p1);
    }
}
