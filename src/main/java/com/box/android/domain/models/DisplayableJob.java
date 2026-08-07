package com.box.android.domain.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: DisplayableJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/models/DisplayableJob;", "", "getJobDisplayInfoProvider", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "shouldDisplay", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DisplayableJob {
    IJobDisplayInfoProvider getJobDisplayInfoProvider();

    default boolean shouldDisplay() {
        return true;
    }

    /* JADX INFO: compiled from: DisplayableJob.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean shouldDisplay(DisplayableJob displayableJob) {
            return DisplayableJob.super.shouldDisplay();
        }
    }
}
