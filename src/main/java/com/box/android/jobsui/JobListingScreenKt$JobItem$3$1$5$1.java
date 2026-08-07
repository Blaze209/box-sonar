package com.box.android.jobsui;

import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JobListingScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class JobListingScreenKt$JobItem$3$1$5$1 implements Function0<Unit> {
    final /* synthetic */ Store<JobItemReducer.State, JobItemReducer.Action> $store;

    JobListingScreenKt$JobItem$3$1$5$1(Store<JobItemReducer.State, JobItemReducer.Action> store) {
        this.$store = store;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$store.send(JobItemReducer.Action.SecondaryAction.INSTANCE);
    }
}
