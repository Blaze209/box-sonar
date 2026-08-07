package com.box.android.base.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxListViewItemModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JI\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/box/android/base/models/ClickActionsConfig;", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "onSecondaryActionClick", "onLongClick", "onUpdateClick", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getOnSecondaryActionClick", "getOnLongClick", "getOnUpdateClick", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ClickActionsConfig {
    public static final int $stable = 0;
    private final Function0<Unit> onClick;
    private final Function0<Unit> onLongClick;
    private final Function0<Unit> onSecondaryActionClick;
    private final Function0<Unit> onUpdateClick;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClickActionsConfig copy$default(ClickActionsConfig clickActionsConfig, Function0 function0, Function0 function1, Function0 function2, Function0 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = clickActionsConfig.onClick;
        }
        if ((i & 2) != 0) {
            function1 = clickActionsConfig.onSecondaryActionClick;
        }
        if ((i & 4) != 0) {
            function2 = clickActionsConfig.onLongClick;
        }
        if ((i & 8) != 0) {
            function3 = clickActionsConfig.onUpdateClick;
        }
        return clickActionsConfig.copy(function0, function1, function2, function3);
    }

    public final Function0<Unit> component1() {
        return this.onClick;
    }

    public final Function0<Unit> component2() {
        return this.onSecondaryActionClick;
    }

    public final Function0<Unit> component3() {
        return this.onLongClick;
    }

    public final Function0<Unit> component4() {
        return this.onUpdateClick;
    }

    public final ClickActionsConfig copy(Function0<Unit> onClick, Function0<Unit> onSecondaryActionClick, Function0<Unit> onLongClick, Function0<Unit> onUpdateClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onSecondaryActionClick, "onSecondaryActionClick");
        Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
        Intrinsics.checkNotNullParameter(onUpdateClick, "onUpdateClick");
        return new ClickActionsConfig(onClick, onSecondaryActionClick, onLongClick, onUpdateClick);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClickActionsConfig)) {
            return false;
        }
        ClickActionsConfig clickActionsConfig = (ClickActionsConfig) other;
        return Intrinsics.areEqual(this.onClick, clickActionsConfig.onClick) && Intrinsics.areEqual(this.onSecondaryActionClick, clickActionsConfig.onSecondaryActionClick) && Intrinsics.areEqual(this.onLongClick, clickActionsConfig.onLongClick) && Intrinsics.areEqual(this.onUpdateClick, clickActionsConfig.onUpdateClick);
    }

    public int hashCode() {
        return (((((this.onClick.hashCode() * 31) + this.onSecondaryActionClick.hashCode()) * 31) + this.onLongClick.hashCode()) * 31) + this.onUpdateClick.hashCode();
    }

    public String toString() {
        return "ClickActionsConfig(onClick=" + this.onClick + ", onSecondaryActionClick=" + this.onSecondaryActionClick + ", onLongClick=" + this.onLongClick + ", onUpdateClick=" + this.onUpdateClick + ")";
    }

    public ClickActionsConfig(Function0<Unit> onClick, Function0<Unit> onSecondaryActionClick, Function0<Unit> onLongClick, Function0<Unit> onUpdateClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onSecondaryActionClick, "onSecondaryActionClick");
        Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
        Intrinsics.checkNotNullParameter(onUpdateClick, "onUpdateClick");
        this.onClick = onClick;
        this.onSecondaryActionClick = onSecondaryActionClick;
        this.onLongClick = onLongClick;
        this.onUpdateClick = onUpdateClick;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public /* synthetic */ ClickActionsConfig(Function0 function0, Function0 function1, Function0 function2, Function0 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new Function0() { // from class: com.box.android.base.models.ClickActionsConfig$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function1, (i & 4) != 0 ? new Function0() { // from class: com.box.android.base.models.ClickActionsConfig$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function2, (i & 8) != 0 ? new Function0() { // from class: com.box.android.base.models.ClickActionsConfig$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function3);
    }

    public final Function0<Unit> getOnSecondaryActionClick() {
        return this.onSecondaryActionClick;
    }

    public final Function0<Unit> getOnLongClick() {
        return this.onLongClick;
    }

    public final Function0<Unit> getOnUpdateClick() {
        return this.onUpdateClick;
    }
}
