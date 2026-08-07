package com.margelo.nitro.boxcontext.providers;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: StyleVariant.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FULL_PAGE", "MODAL", "SIDEBAR", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum StyleVariant {
    FULL_PAGE("full-page"),
    MODAL("modal"),
    SIDEBAR("sidebar");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<StyleVariant> getEntries() {
        return $ENTRIES;
    }

    StyleVariant(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
