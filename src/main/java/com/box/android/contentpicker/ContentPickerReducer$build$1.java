package com.box.android.contentpicker;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentPickerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ContentPickerReducer$build$1 extends FunctionReferenceImpl implements Function2<ContentPickerReducer.State, ContentPickerReducer.Action, ReducerResult<ContentPickerReducer.State, ContentPickerReducer.Action>> {
    ContentPickerReducer$build$1(Object obj) {
        super(2, obj, ContentPickerReducer.class, "reduceContentPicker", "reduceContentPicker(Lcom/box/android/contentpicker/ContentPickerReducer$State;Lcom/box/android/contentpicker/ContentPickerReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<ContentPickerReducer.State, ContentPickerReducer.Action> invoke(ContentPickerReducer.State p0, ContentPickerReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((ContentPickerReducer) this.receiver).reduceContentPicker(p0, p1);
    }
}
