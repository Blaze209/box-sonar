package com.box.android.fileactivity.presentation;

import com.box.android.domain.models.annotations.FileActivityIdModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesReducer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActivitiesReducer$build$3 extends FunctionReferenceImpl implements Function2<FileActivityIdModel, FileActivityReducer.Action, FileActivitiesReducer.Action.FileActivityItemAction> {
    public static final FileActivitiesReducer$build$3 INSTANCE = new FileActivitiesReducer$build$3();

    FileActivitiesReducer$build$3() {
        super(2, FileActivitiesReducer.Action.FileActivityItemAction.class, "<init>", "<init>(Lcom/box/android/domain/models/annotations/FileActivityIdModel;Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final FileActivitiesReducer.Action.FileActivityItemAction invoke(FileActivityIdModel p0, FileActivityReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new FileActivitiesReducer.Action.FileActivityItemAction(p0, p1);
    }
}
