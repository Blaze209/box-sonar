package com.box.android.preview.previewtype.boxnote;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNoteRequestBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequest;", "", "command", "", SerializedNames.PARAMS, "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getCommand", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BoxNoteRequest {
    public static final int $stable = 8;
    private final String command;
    private final Map<String, String> params;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BoxNoteRequest copy$default(BoxNoteRequest boxNoteRequest, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = boxNoteRequest.command;
        }
        if ((i & 2) != 0) {
            map = boxNoteRequest.params;
        }
        return boxNoteRequest.copy(str, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    public final Map<String, String> component2() {
        return this.params;
    }

    public final BoxNoteRequest copy(String command, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(params, "params");
        return new BoxNoteRequest(command, params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxNoteRequest)) {
            return false;
        }
        BoxNoteRequest boxNoteRequest = (BoxNoteRequest) other;
        return Intrinsics.areEqual(this.command, boxNoteRequest.command) && Intrinsics.areEqual(this.params, boxNoteRequest.params);
    }

    public int hashCode() {
        return (this.command.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "BoxNoteRequest(command=" + this.command + ", params=" + this.params + ")";
    }

    public BoxNoteRequest(String command, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(params, "params");
        this.command = command;
        this.params = params;
    }

    public final String getCommand() {
        return this.command;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }
}
