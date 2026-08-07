package com.box.android.preview.fileactions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActionsReducer$build$6 extends FunctionReferenceImpl implements Function1<UpdateItemInfoReducer.Action, FileActionsReducer.Action.Rename> {
    public static final FileActionsReducer$build$6 INSTANCE = new FileActionsReducer$build$6();

    FileActionsReducer$build$6() {
        super(1, FileActionsReducer.Action.Rename.class, "<init>", "<init>(Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActionsReducer.Action.Rename invoke(UpdateItemInfoReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActionsReducer.Action.Rename(p0);
    }
}
