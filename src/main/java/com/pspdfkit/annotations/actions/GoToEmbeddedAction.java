package com.pspdfkit.annotations.actions;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.document.Destination;
import com.pspdfkit.document.DestinationType;
import com.pspdfkit.document.files.EmbeddedFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u0011J\u0014\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0082\u0004J\n\u0010 \u001a\u00020\u0005H\u0096\u0080\u0004J\n\u0010!\u001a\u00020\u0003H\u0096\u0080\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/pspdfkit/annotations/actions/GoToEmbeddedAction;", "Lcom/pspdfkit/annotations/actions/Action;", "pdfPath", "", "pageIndex", "", "isNewWindow", "", "subActions", "", FirebaseAnalytics.Param.DESTINATION, "Lcom/pspdfkit/document/Destination;", "<init>", "(Ljava/lang/String;IZLjava/util/List;Lcom/pspdfkit/document/Destination;)V", "embeddedFile", "Lcom/pspdfkit/document/files/EmbeddedFile;", "openInNewWindow", "(Lcom/pspdfkit/document/files/EmbeddedFile;Z)V", "getPdfPath", "()Ljava/lang/String;", "getPageIndex", "()I", "()Z", "getDestination", "()Lcom/pspdfkit/document/Destination;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "other", "", "hashCode", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoToEmbeddedAction extends Action {
    public static final int $stable = 8;
    private final Destination destination;
    private final boolean isNewWindow;
    private final int pageIndex;
    private final String pdfPath;
    private final ActionType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoToEmbeddedAction(String str, int i, boolean z, List<? extends Action> list, Destination destination) {
        super(list);
        list.getClass();
        destination.getClass();
        this.pdfPath = str;
        this.pageIndex = i;
        this.isNewWindow = z;
        this.destination = destination;
        this.type = ActionType.GOTO_EMBEDDED;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoToEmbeddedAction)) {
            return false;
        }
        GoToEmbeddedAction goToEmbeddedAction = (GoToEmbeddedAction) other;
        return this.pageIndex == goToEmbeddedAction.pageIndex && this.isNewWindow == goToEmbeddedAction.isNewWindow && Intrinsics.areEqual(this.pdfPath, goToEmbeddedAction.pdfPath) && Intrinsics.areEqual(this.destination, goToEmbeddedAction.destination);
    }

    public final Destination getDestination() {
        return this.destination;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final String getPdfPath() {
        return this.pdfPath;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.pdfPath;
        return Boolean.hashCode(this.isNewWindow) + ((this.destination.hashCode() + ((((str != null ? str.hashCode() : 0) * 31) + this.pageIndex) * 31)) * 31);
    }

    /* JADX INFO: renamed from: isNewWindow, reason: from getter */
    public final boolean getIsNewWindow() {
        return this.isNewWindow;
    }

    public String toString() {
        return "GoToEmbeddedAction(pdfPath=" + this.pdfPath + ", pageIndex=" + this.pageIndex + ", destination=" + this.destination + ", newWindow=" + this.isNewWindow + ")";
    }

    public /* synthetic */ GoToEmbeddedAction(String str, int i, boolean z, List list, Destination destination, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, z, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? new Destination(i, DestinationType.FitPage, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f) : destination);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoToEmbeddedAction(EmbeddedFile embeddedFile, boolean z) {
        this(embeddedFile.getFileName(), 0, z, null, null, 24, null);
        embeddedFile.getClass();
    }
}
