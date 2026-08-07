package com.box.android.fileactivity.presentation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: FileActivitiesActivity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActivitiesActivity$onCreate$1$1$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    FileActivitiesActivity$onCreate$1$1$1$1(Object obj) {
        super(1, obj, FileActivitiesActivity.class, "closeFileActivities", "closeFileActivities(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((FileActivitiesActivity) this.receiver).closeFileActivities(i);
    }
}
