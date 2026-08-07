package com.box.android.coreservices.observability.appstart;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppStartType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/AppStartType;", "", "<init>", "()V", "getStartTime", "", "Cold", "Warm", "Hot", "Lcom/box/android/coreservices/observability/appstart/AppStartType$Cold;", "Lcom/box/android/coreservices/observability/appstart/AppStartType$Hot;", "Lcom/box/android/coreservices/observability/appstart/AppStartType$Warm;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AppStartType {
    public /* synthetic */ AppStartType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract long getStartTime();

    private AppStartType() {
    }

    /* JADX INFO: compiled from: AppStartType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/AppStartType$Cold;", "Lcom/box/android/coreservices/observability/appstart/AppStartType;", "coldStartTime", "Lcom/box/android/coreservices/observability/appstart/ColdStartTime;", "<init>", "(Lcom/box/android/coreservices/observability/appstart/ColdStartTime;)V", "getColdStartTime", "()Lcom/box/android/coreservices/observability/appstart/ColdStartTime;", "getStartTime", "", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Cold extends AppStartType {
        private final ColdStartTime coldStartTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Cold(ColdStartTime coldStartTime) {
            super(null);
            Intrinsics.checkNotNullParameter(coldStartTime, "coldStartTime");
            this.coldStartTime = coldStartTime;
        }

        public final ColdStartTime getColdStartTime() {
            return this.coldStartTime;
        }

        @Override // com.box.android.coreservices.observability.appstart.AppStartType
        public long getStartTime() {
            return this.coldStartTime.getProcessStartedTimeMillis();
        }
    }

    /* JADX INFO: compiled from: AppStartType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/AppStartType$Warm;", "Lcom/box/android/coreservices/observability/appstart/AppStartType;", "activityCreatedTime", "", "<init>", "(J)V", "getActivityCreatedTime", "()J", "getStartTime", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Warm extends AppStartType {
        private final long activityCreatedTime;

        public Warm(long j) {
            super(null);
            this.activityCreatedTime = j;
        }

        public final long getActivityCreatedTime() {
            return this.activityCreatedTime;
        }

        @Override // com.box.android.coreservices.observability.appstart.AppStartType
        public long getStartTime() {
            return this.activityCreatedTime;
        }
    }

    /* JADX INFO: compiled from: AppStartType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/AppStartType$Hot;", "Lcom/box/android/coreservices/observability/appstart/AppStartType;", "activityStartedTime", "", "<init>", "(J)V", "getActivityStartedTime", "()J", "getStartTime", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Hot extends AppStartType {
        private final long activityStartedTime;

        public Hot(long j) {
            super(null);
            this.activityStartedTime = j;
        }

        public final long getActivityStartedTime() {
            return this.activityStartedTime;
        }

        @Override // com.box.android.coreservices.observability.appstart.AppStartType
        public long getStartTime() {
            return this.activityStartedTime;
        }
    }
}
