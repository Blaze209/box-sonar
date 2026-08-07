package com.facebook.react.devsupport.interfaces;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: DebuggerFrontendPanelName.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/facebook/react/devsupport/interfaces/DebuggerFrontendPanelName;", "", "internalName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getInternalName", "()Ljava/lang/String;", "CONSOLE", "MEMORY", "NETWORK", "PERFORMANCE", "REACT_COMPONENTS", "REACT_PROFILER", "SOURCES", "WELCOME", "toString", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum DebuggerFrontendPanelName {
    CONSOLE("console"),
    MEMORY("heap-profiler"),
    NETWORK("network"),
    PERFORMANCE("timeline"),
    REACT_COMPONENTS("react-devtools-components"),
    REACT_PROFILER("react-devtools-profiler"),
    SOURCES("sources"),
    WELCOME("rn-welcome");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String internalName;

    public static EnumEntries<DebuggerFrontendPanelName> getEntries() {
        return $ENTRIES;
    }

    DebuggerFrontendPanelName(String str) {
        this.internalName = str;
    }

    public final String getInternalName() {
        return this.internalName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.internalName;
    }
}
