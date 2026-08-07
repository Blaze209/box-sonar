package com.box.android.common.extensions;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0086\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017¨\u0006/"}, d2 = {"Lcom/box/android/common/extensions/DialogConfig;", "", "titleRes", "", "message", "", "positiveButtonRes", "onPositiveClick", "Lkotlin/Function0;", "", "negativeButtonRes", "onNegativeClick", "neutralButtonRes", "onNeutralClick", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "<init>", "(ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function0;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getTitleRes", "()I", "getMessage", "()Ljava/lang/String;", "getPositiveButtonRes", "getOnPositiveClick", "()Lkotlin/jvm/functions/Function0;", "getNegativeButtonRes", "getOnNegativeClick", "getNeutralButtonRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOnNeutralClick", "getOnDismiss", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function0;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Lcom/box/android/common/extensions/DialogConfig;", "equals", "", "other", "hashCode", "toString", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DialogConfig {
    private final String message;
    private final int negativeButtonRes;
    private final Integer neutralButtonRes;
    private final Function0<Unit> onDismiss;
    private final Function0<Unit> onNegativeClick;
    private final Function0<Unit> onNeutralClick;
    private final Function0<Unit> onPositiveClick;
    private final int positiveButtonRes;
    private final int titleRes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DialogConfig copy$default(DialogConfig dialogConfig, int i, String str, int i2, Function0 function0, int i3, Function0 function1, Integer num, Function0 function2, Function0 function3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = dialogConfig.titleRes;
        }
        if ((i4 & 2) != 0) {
            str = dialogConfig.message;
        }
        if ((i4 & 4) != 0) {
            i2 = dialogConfig.positiveButtonRes;
        }
        if ((i4 & 8) != 0) {
            function0 = dialogConfig.onPositiveClick;
        }
        if ((i4 & 16) != 0) {
            i3 = dialogConfig.negativeButtonRes;
        }
        if ((i4 & 32) != 0) {
            function1 = dialogConfig.onNegativeClick;
        }
        if ((i4 & 64) != 0) {
            num = dialogConfig.neutralButtonRes;
        }
        if ((i4 & 128) != 0) {
            function2 = dialogConfig.onNeutralClick;
        }
        if ((i4 & 256) != 0) {
            function3 = dialogConfig.onDismiss;
        }
        Function0 function4 = function2;
        Function0 function5 = function3;
        Function0 function6 = function1;
        Integer num2 = num;
        int i5 = i3;
        int i6 = i2;
        return dialogConfig.copy(i, str, i6, function0, i5, function6, num2, function4, function5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPositiveButtonRes() {
        return this.positiveButtonRes;
    }

    public final Function0<Unit> component4() {
        return this.onPositiveClick;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getNegativeButtonRes() {
        return this.negativeButtonRes;
    }

    public final Function0<Unit> component6() {
        return this.onNegativeClick;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getNeutralButtonRes() {
        return this.neutralButtonRes;
    }

    public final Function0<Unit> component8() {
        return this.onNeutralClick;
    }

    public final Function0<Unit> component9() {
        return this.onDismiss;
    }

    public final DialogConfig copy(int titleRes, String message, int positiveButtonRes, Function0<Unit> onPositiveClick, int negativeButtonRes, Function0<Unit> onNegativeClick, Integer neutralButtonRes, Function0<Unit> onNeutralClick, Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(onPositiveClick, "onPositiveClick");
        Intrinsics.checkNotNullParameter(onNegativeClick, "onNegativeClick");
        return new DialogConfig(titleRes, message, positiveButtonRes, onPositiveClick, negativeButtonRes, onNegativeClick, neutralButtonRes, onNeutralClick, onDismiss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DialogConfig)) {
            return false;
        }
        DialogConfig dialogConfig = (DialogConfig) other;
        return this.titleRes == dialogConfig.titleRes && Intrinsics.areEqual(this.message, dialogConfig.message) && this.positiveButtonRes == dialogConfig.positiveButtonRes && Intrinsics.areEqual(this.onPositiveClick, dialogConfig.onPositiveClick) && this.negativeButtonRes == dialogConfig.negativeButtonRes && Intrinsics.areEqual(this.onNegativeClick, dialogConfig.onNegativeClick) && Intrinsics.areEqual(this.neutralButtonRes, dialogConfig.neutralButtonRes) && Intrinsics.areEqual(this.onNeutralClick, dialogConfig.onNeutralClick) && Intrinsics.areEqual(this.onDismiss, dialogConfig.onDismiss);
    }

    public int hashCode() {
        int iHashCode = ((((((((((Integer.hashCode(this.titleRes) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.positiveButtonRes)) * 31) + this.onPositiveClick.hashCode()) * 31) + Integer.hashCode(this.negativeButtonRes)) * 31) + this.onNegativeClick.hashCode()) * 31;
        Integer num = this.neutralButtonRes;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Function0<Unit> function0 = this.onNeutralClick;
        int iHashCode3 = (iHashCode2 + (function0 == null ? 0 : function0.hashCode())) * 31;
        Function0<Unit> function1 = this.onDismiss;
        return iHashCode3 + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return "DialogConfig(titleRes=" + this.titleRes + ", message=" + this.message + ", positiveButtonRes=" + this.positiveButtonRes + ", onPositiveClick=" + this.onPositiveClick + ", negativeButtonRes=" + this.negativeButtonRes + ", onNegativeClick=" + this.onNegativeClick + ", neutralButtonRes=" + this.neutralButtonRes + ", onNeutralClick=" + this.onNeutralClick + ", onDismiss=" + this.onDismiss + ")";
    }

    public DialogConfig(int i, String message, int i2, Function0<Unit> onPositiveClick, int i3, Function0<Unit> onNegativeClick, Integer num, Function0<Unit> function0, Function0<Unit> function1) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(onPositiveClick, "onPositiveClick");
        Intrinsics.checkNotNullParameter(onNegativeClick, "onNegativeClick");
        this.titleRes = i;
        this.message = message;
        this.positiveButtonRes = i2;
        this.onPositiveClick = onPositiveClick;
        this.negativeButtonRes = i3;
        this.onNegativeClick = onNegativeClick;
        this.neutralButtonRes = num;
        this.onNeutralClick = function0;
        this.onDismiss = function1;
    }

    public /* synthetic */ DialogConfig(int i, String str, int i2, Function0 function0, int i3, Function0 function1, Integer num, Function0 function2, Function0 function3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, function0, i3, function1, (i4 & 64) != 0 ? null : num, (i4 & 128) != 0 ? null : function2, (i4 & 256) != 0 ? null : function3);
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getPositiveButtonRes() {
        return this.positiveButtonRes;
    }

    public final Function0<Unit> getOnPositiveClick() {
        return this.onPositiveClick;
    }

    public final int getNegativeButtonRes() {
        return this.negativeButtonRes;
    }

    public final Function0<Unit> getOnNegativeClick() {
        return this.onNegativeClick;
    }

    public final Integer getNeutralButtonRes() {
        return this.neutralButtonRes;
    }

    public final Function0<Unit> getOnNeutralClick() {
        return this.onNeutralClick;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }
}
