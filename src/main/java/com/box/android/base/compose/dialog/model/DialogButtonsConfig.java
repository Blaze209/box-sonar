package com.box.android.base.compose.dialog.model;

import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogButtonsConfig.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig;", "", "<init>", "()V", "PositiveButton", "NegativeButton", "PositiveAndNegativeButtons", "Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig$NegativeButton;", "Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig$PositiveAndNegativeButtons;", "Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig$PositiveButton;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DialogButtonsConfig {
    public static final int $stable = 0;

    public /* synthetic */ DialogButtonsConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DialogButtonsConfig() {
    }

    /* JADX INFO: compiled from: DialogButtonsConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig$PositiveButton;", "Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig;", "button", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "<init>", "(Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;)V", "getButton", "()Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PositiveButton extends DialogButtonsConfig {
        public static final int $stable = 0;
        private final ButtonItem.TextButtonItem button;

        public static /* synthetic */ PositiveButton copy$default(PositiveButton positiveButton, ButtonItem.TextButtonItem textButtonItem, int i, Object obj) {
            if ((i & 1) != 0) {
                textButtonItem = positiveButton.button;
            }
            return positiveButton.copy(textButtonItem);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ButtonItem.TextButtonItem getButton() {
            return this.button;
        }

        public final PositiveButton copy(ButtonItem.TextButtonItem button) {
            Intrinsics.checkNotNullParameter(button, "button");
            return new PositiveButton(button);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PositiveButton) && Intrinsics.areEqual(this.button, ((PositiveButton) other).button);
        }

        public int hashCode() {
            return this.button.hashCode();
        }

        public String toString() {
            return "PositiveButton(button=" + this.button + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PositiveButton(ButtonItem.TextButtonItem button) {
            super(null);
            Intrinsics.checkNotNullParameter(button, "button");
            this.button = button;
        }

        public final ButtonItem.TextButtonItem getButton() {
            return this.button;
        }
    }

    /* JADX INFO: compiled from: DialogButtonsConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig$NegativeButton;", "Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig;", "button", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "<init>", "(Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;)V", "getButton", "()Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NegativeButton extends DialogButtonsConfig {
        public static final int $stable = 0;
        private final ButtonItem.TextButtonItem button;

        public static /* synthetic */ NegativeButton copy$default(NegativeButton negativeButton, ButtonItem.TextButtonItem textButtonItem, int i, Object obj) {
            if ((i & 1) != 0) {
                textButtonItem = negativeButton.button;
            }
            return negativeButton.copy(textButtonItem);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ButtonItem.TextButtonItem getButton() {
            return this.button;
        }

        public final NegativeButton copy(ButtonItem.TextButtonItem button) {
            Intrinsics.checkNotNullParameter(button, "button");
            return new NegativeButton(button);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NegativeButton) && Intrinsics.areEqual(this.button, ((NegativeButton) other).button);
        }

        public int hashCode() {
            return this.button.hashCode();
        }

        public String toString() {
            return "NegativeButton(button=" + this.button + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NegativeButton(ButtonItem.TextButtonItem button) {
            super(null);
            Intrinsics.checkNotNullParameter(button, "button");
            this.button = button;
        }

        public final ButtonItem.TextButtonItem getButton() {
            return this.button;
        }
    }

    /* JADX INFO: compiled from: DialogButtonsConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig$PositiveAndNegativeButtons;", "Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig;", "positiveButton", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "negativeButton", "<init>", "(Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;)V", "getPositiveButton", "()Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "getNegativeButton", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PositiveAndNegativeButtons extends DialogButtonsConfig {
        public static final int $stable = 0;
        private final ButtonItem.TextButtonItem negativeButton;
        private final ButtonItem.TextButtonItem positiveButton;

        public static /* synthetic */ PositiveAndNegativeButtons copy$default(PositiveAndNegativeButtons positiveAndNegativeButtons, ButtonItem.TextButtonItem textButtonItem, ButtonItem.TextButtonItem textButtonItem2, int i, Object obj) {
            if ((i & 1) != 0) {
                textButtonItem = positiveAndNegativeButtons.positiveButton;
            }
            if ((i & 2) != 0) {
                textButtonItem2 = positiveAndNegativeButtons.negativeButton;
            }
            return positiveAndNegativeButtons.copy(textButtonItem, textButtonItem2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ButtonItem.TextButtonItem getPositiveButton() {
            return this.positiveButton;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ButtonItem.TextButtonItem getNegativeButton() {
            return this.negativeButton;
        }

        public final PositiveAndNegativeButtons copy(ButtonItem.TextButtonItem positiveButton, ButtonItem.TextButtonItem negativeButton) {
            Intrinsics.checkNotNullParameter(positiveButton, "positiveButton");
            Intrinsics.checkNotNullParameter(negativeButton, "negativeButton");
            return new PositiveAndNegativeButtons(positiveButton, negativeButton);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PositiveAndNegativeButtons)) {
                return false;
            }
            PositiveAndNegativeButtons positiveAndNegativeButtons = (PositiveAndNegativeButtons) other;
            return Intrinsics.areEqual(this.positiveButton, positiveAndNegativeButtons.positiveButton) && Intrinsics.areEqual(this.negativeButton, positiveAndNegativeButtons.negativeButton);
        }

        public int hashCode() {
            return (this.positiveButton.hashCode() * 31) + this.negativeButton.hashCode();
        }

        public String toString() {
            return "PositiveAndNegativeButtons(positiveButton=" + this.positiveButton + ", negativeButton=" + this.negativeButton + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PositiveAndNegativeButtons(ButtonItem.TextButtonItem positiveButton, ButtonItem.TextButtonItem negativeButton) {
            super(null);
            Intrinsics.checkNotNullParameter(positiveButton, "positiveButton");
            Intrinsics.checkNotNullParameter(negativeButton, "negativeButton");
            this.positiveButton = positiveButton;
            this.negativeButton = negativeButton;
        }

        public final ButtonItem.TextButtonItem getNegativeButton() {
            return this.negativeButton;
        }

        public final ButtonItem.TextButtonItem getPositiveButton() {
            return this.positiveButton;
        }
    }
}
