package com.box.android.domain.models.item;

import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SharedLinkAccessModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/models/item/SharedLinkAccessModel;", "Lcom/box/android/domain/models/DomainModel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OPEN", "COMPANY", "COLLABORATORS", "UNKNOWN", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SharedLinkAccessModel implements DomainModel {
    OPEN("open"),
    COMPANY("company"),
    COLLABORATORS("collaborators"),
    UNKNOWN("unknown");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<SharedLinkAccessModel> getEntries() {
        return $ENTRIES;
    }

    SharedLinkAccessModel(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: SharedLinkAccessModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/item/SharedLinkAccessModel$Companion;", "", "<init>", "()V", "fromString", "Lcom/box/android/domain/models/item/SharedLinkAccessModel;", "value", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedLinkAccessModel fromString(String value) {
            SharedLinkAccessModel sharedLinkAccessModel;
            SharedLinkAccessModel sharedLinkAccessModel2 = SharedLinkAccessModel.UNKNOWN;
            SharedLinkAccessModel[] sharedLinkAccessModelArrValues = SharedLinkAccessModel.values();
            int length = sharedLinkAccessModelArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    sharedLinkAccessModel = null;
                    break;
                }
                sharedLinkAccessModel = sharedLinkAccessModelArrValues[i];
                if (StringsKt.equals(sharedLinkAccessModel.name(), value, true)) {
                    break;
                }
                i++;
            }
            SharedLinkAccessModel sharedLinkAccessModel3 = sharedLinkAccessModel;
            if (sharedLinkAccessModel3 != null) {
                sharedLinkAccessModel2 = sharedLinkAccessModel3;
            }
            return sharedLinkAccessModel2;
        }
    }
}
