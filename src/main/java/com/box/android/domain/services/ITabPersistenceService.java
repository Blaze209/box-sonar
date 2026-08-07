package com.box.android.domain.services;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ITabPersistenceService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ITabPersistenceService;", "", "saveLastUsedTab", "", "tabRoute", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveInnerTab", "bottomTabRoute", "innerTabName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSavedTabState", "Lcom/box/android/domain/services/ITabPersistenceService$SavedTabState;", "availableTabRoutes", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SavedTabState", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ITabPersistenceService {
    Object loadSavedTabState(List<String> list, Continuation<? super SavedTabState> continuation);

    Object saveInnerTab(String str, String str2, Continuation<? super Unit> continuation);

    Object saveLastUsedTab(String str, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: ITabPersistenceService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/services/ITabPersistenceService$SavedTabState;", "", "lastUsedTabRoute", "", "innerTabs", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getLastUsedTabRoute", "()Ljava/lang/String;", "getInnerTabs", "()Ljava/util/Map;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SavedTabState {
        private final Map<String, String> innerTabs;
        private final String lastUsedTabRoute;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SavedTabState copy$default(SavedTabState savedTabState, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = savedTabState.lastUsedTabRoute;
            }
            if ((i & 2) != 0) {
                map = savedTabState.innerTabs;
            }
            return savedTabState.copy(str, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLastUsedTabRoute() {
            return this.lastUsedTabRoute;
        }

        public final Map<String, String> component2() {
            return this.innerTabs;
        }

        public final SavedTabState copy(String lastUsedTabRoute, Map<String, String> innerTabs) {
            Intrinsics.checkNotNullParameter(innerTabs, "innerTabs");
            return new SavedTabState(lastUsedTabRoute, innerTabs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SavedTabState)) {
                return false;
            }
            SavedTabState savedTabState = (SavedTabState) other;
            return Intrinsics.areEqual(this.lastUsedTabRoute, savedTabState.lastUsedTabRoute) && Intrinsics.areEqual(this.innerTabs, savedTabState.innerTabs);
        }

        public int hashCode() {
            String str = this.lastUsedTabRoute;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.innerTabs.hashCode();
        }

        public String toString() {
            return "SavedTabState(lastUsedTabRoute=" + this.lastUsedTabRoute + ", innerTabs=" + this.innerTabs + ")";
        }

        public SavedTabState(String str, Map<String, String> innerTabs) {
            Intrinsics.checkNotNullParameter(innerTabs, "innerTabs");
            this.lastUsedTabRoute = str;
            this.innerTabs = innerTabs;
        }

        public final Map<String, String> getInnerTabs() {
            return this.innerTabs;
        }

        public final String getLastUsedTabRoute() {
            return this.lastUsedTabRoute;
        }
    }
}
