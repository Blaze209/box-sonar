package com.box.android.data.api.models.boxai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: AiMode.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiMode;", "", "jsonValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "QA", "HUB_QA", "TEXT_GEN", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum AiMode {
    QA("qa"),
    HUB_QA("hub_qa"),
    TEXT_GEN("text_gen");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jsonValue;

    public static EnumEntries<AiMode> getEntries() {
        return $ENTRIES;
    }

    AiMode(String str) {
        this.jsonValue = str;
    }

    public final String getJsonValue() {
        return this.jsonValue;
    }
}
