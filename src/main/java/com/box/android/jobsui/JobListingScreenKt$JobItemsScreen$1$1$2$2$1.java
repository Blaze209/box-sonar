package com.box.android.jobsui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobListingScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class JobListingScreenKt$JobItemsScreen$1$1$2$2$1 extends FunctionReferenceImpl implements Function2<String, JobItemReducer.Action, JobsReducer.Action.JobItemAction> {
    public static final JobListingScreenKt$JobItemsScreen$1$1$2$2$1 INSTANCE = new JobListingScreenKt$JobItemsScreen$1$1$2$2$1();

    JobListingScreenKt$JobItemsScreen$1$1$2$2$1() {
        super(2, JobsReducer.Action.JobItemAction.class, "<init>", "<init>(Ljava/lang/String;Lcom/box/android/jobsui/JobItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final JobsReducer.Action.JobItemAction invoke(String p0, JobItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new JobsReducer.Action.JobItemAction(p0, p1);
    }
}
