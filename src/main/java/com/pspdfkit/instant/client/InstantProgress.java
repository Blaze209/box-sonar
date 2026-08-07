package com.pspdfkit.instant.client;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final class InstantProgress {
    private final int currentProgress;
    private final boolean isInFinalState;

    public InstantProgress(int i, boolean z) {
        this.currentProgress = i;
        this.isInFinalState = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstantProgress)) {
            return false;
        }
        InstantProgress instantProgress = (InstantProgress) obj;
        return this.currentProgress == instantProgress.currentProgress && this.isInFinalState == instantProgress.isInFinalState;
    }

    public int getCurrentProgress() {
        return this.currentProgress;
    }

    public int hashCode() {
        return (this.currentProgress * 31) + (this.isInFinalState ? 1 : 0);
    }

    public boolean isCompleted() {
        return this.isInFinalState;
    }

    public String toString() {
        return "InstantProgress{currentProgress=" + this.currentProgress + ", isCompleted=" + this.isInFinalState + AbstractJsonLexerKt.END_OBJ;
    }
}
