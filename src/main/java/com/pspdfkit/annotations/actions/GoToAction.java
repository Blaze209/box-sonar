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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J\n\u0010\u0016\u001a\u00020\u0003H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/annotations/actions/GoToAction;", "Lcom/pspdfkit/annotations/actions/Action;", "pageIndex", "", "subActions", "", FirebaseAnalytics.Param.DESTINATION, "Lcom/pspdfkit/document/Destination;", "<init>", "(ILjava/util/List;Lcom/pspdfkit/document/Destination;)V", "getPageIndex", "()I", "getDestination", "()Lcom/pspdfkit/document/Destination;", "type", "Lcom/pspdfkit/annotations/actions/ActionType;", "getType", "()Lcom/pspdfkit/annotations/actions/ActionType;", "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoToAction extends Action {
    public static final int $stable = 8;
    private final Destination destination;
    private final int pageIndex;
    private final ActionType type;

    public GoToAction(int i) {
        this(i, null, null, 6, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoToAction)) {
            return false;
        }
        GoToAction goToAction = (GoToAction) other;
        return this.pageIndex == goToAction.pageIndex && Intrinsics.areEqual(this.destination, goToAction.destination);
    }

    public final Destination getDestination() {
        return this.destination;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    @Override // com.pspdfkit.annotations.actions.Action
    public ActionType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.destination.hashCode() + (this.pageIndex * 31);
    }

    public String toString() {
        return "GoToAction(pageIndex=" + this.pageIndex + ", destination=" + this.destination + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoToAction(int i, List<? extends Action> list) {
        this(i, list, null, 4, null);
        list.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoToAction(int i, List<? extends Action> list, Destination destination) {
        super(list);
        list.getClass();
        destination.getClass();
        this.pageIndex = i;
        this.destination = destination;
        this.type = ActionType.GOTO;
    }

    public /* synthetic */ GoToAction(int i, List list, Destination destination, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i3;
        list = (i2 & 2) != 0 ? CollectionsKt.emptyList() : list;
        if ((i2 & 4) != 0) {
            i3 = i;
            destination = new Destination(i3, DestinationType.FitPage, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            i3 = i;
        }
        this(i3, list, destination);
    }
}
