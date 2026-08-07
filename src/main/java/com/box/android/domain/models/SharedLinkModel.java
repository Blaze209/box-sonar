package com.box.android.domain.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: SharedLinkModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/box/android/domain/models/SharedLinkModel;", "", "<init>", "()V", "Access", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkModel {

    /* JADX INFO: compiled from: SharedLinkModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/domain/models/SharedLinkModel$Access;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "COMPANY", "COLLABORATORS", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Access {
        OPEN,
        COMPANY,
        COLLABORATORS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Access> getEntries() {
            return $ENTRIES;
        }
    }
}
