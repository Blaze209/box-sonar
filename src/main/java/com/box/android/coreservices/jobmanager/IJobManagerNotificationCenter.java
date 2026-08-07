package com.box.android.coreservices.jobmanager;

import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import kotlin.Metadata;

/* JADX INFO: compiled from: IJobManagerNotificationCenter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/coreservices/jobmanager/IJobManagerNotificationCenter;", "", "addInProgressJobCollection", "", "jobCollection", "Lcom/box/android/coreservices/jobmanager/jobcollections/BoxJobCollection;", "clearAllCompleted", "clearAllInProgress", "shutdown", "Companion", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IJobManagerNotificationCenter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int NUM_ONGOING_NOTIFS = 20;

    void addInProgressJobCollection(BoxJobCollection jobCollection);

    void clearAllCompleted();

    void clearAllInProgress();

    void shutdown();

    /* JADX INFO: compiled from: IJobManagerNotificationCenter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/coreservices/jobmanager/IJobManagerNotificationCenter$Companion;", "", "<init>", "()V", "NUM_ONGOING_NOTIFS", "", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int NUM_ONGOING_NOTIFS = 20;

        private Companion() {
        }
    }
}
