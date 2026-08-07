package com.pspdfkit.annotations.actions;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.document.Destination;
import com.pspdfkit.document.DestinationType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0016\u001a\u00020\u0003H\u0096\u0080\u0004J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0082\u0004J\n\u0010\u001b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/pspdfkit/annotations/actions/GoToRemoteAction;", "Lcom/pspdfkit/annotations/actions/Action;", "pdfPath", "", "pageIndex", "", "subActions", "", FirebaseAnalytics.Param.DESTINATION, "Lcom/pspdfkit/document/Destination;", "<init>", "(Ljava/lang/String;ILjava/util/List;Lcom/pspdfkit/document/Destination;)V", "getPdfPath", "()Ljava/lang/String;", "getPageIndex", "()I", "getDestination", "()Lcom/pspdfkit/document/Destination;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "toString", "equals", "", "other", "", "hashCode", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoToRemoteAction extends Action {
    public static final int $stable = 8;
    private final Destination destination;
    private final int pageIndex;
    private final String pdfPath;
    private final ActionType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoToRemoteAction(String str, int i, List<? extends Action> list, Destination destination) {
        super(list);
        list.getClass();
        destination.getClass();
        this.pdfPath = str;
        this.pageIndex = i;
        this.destination = destination;
        this.type = ActionType.GOTO_REMOTE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoToRemoteAction)) {
            return false;
        }
        GoToRemoteAction goToRemoteAction = (GoToRemoteAction) other;
        return this.pageIndex == goToRemoteAction.pageIndex && Intrinsics.areEqual(this.pdfPath, goToRemoteAction.pdfPath) && Intrinsics.areEqual(this.destination, goToRemoteAction.destination);
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
        return this.destination.hashCode() + ((((str != null ? str.hashCode() : 0) * 31) + this.pageIndex) * 31);
    }

    public String toString() {
        return "GoToRemoteAction(pdfPath=" + this.pdfPath + ", pageIndex=" + this.pageIndex + ", destination=" + this.destination + ")";
    }

    public /* synthetic */ GoToRemoteAction(String str, int i, List list, Destination destination, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i3;
        list = (i2 & 4) != 0 ? CollectionsKt.emptyList() : list;
        if ((i2 & 8) != 0) {
            i3 = i;
            destination = new Destination(i3, DestinationType.FitPage, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            i3 = i;
        }
        this(str, i3, list, destination);
    }
}
