package com.box.android.domain.models.inboxnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationPayloadModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/inboxnotifications/TextModel;", "Lcom/box/android/domain/models/DomainModel;", "type", "", "atoms", "", "Lcom/box/android/domain/models/inboxnotifications/TextAtomModel;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getAtoms", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TextModel implements DomainModel {
    private final List<TextAtomModel> atoms;
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextModel copy$default(TextModel textModel, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textModel.type;
        }
        if ((i & 2) != 0) {
            list = textModel.atoms;
        }
        return textModel.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<TextAtomModel> component2() {
        return this.atoms;
    }

    public final TextModel copy(String type, List<TextAtomModel> atoms) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(atoms, "atoms");
        return new TextModel(type, atoms);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextModel)) {
            return false;
        }
        TextModel textModel = (TextModel) other;
        return Intrinsics.areEqual(this.type, textModel.type) && Intrinsics.areEqual(this.atoms, textModel.atoms);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.atoms.hashCode();
    }

    public String toString() {
        return "TextModel(type=" + this.type + ", atoms=" + this.atoms + ")";
    }

    public TextModel(String type, List<TextAtomModel> atoms) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(atoms, "atoms");
        this.type = type;
        this.atoms = atoms;
    }

    public final List<TextAtomModel> getAtoms() {
        return this.atoms;
    }

    public final String getType() {
        return this.type;
    }
}
