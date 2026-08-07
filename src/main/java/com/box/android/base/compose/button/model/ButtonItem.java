package com.box.android.base.compose.button.model;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/compose/button/model/ButtonItem;", "", "isEnabled", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "BadgedIconButtonItem", "TextButtonItem", "IconButtonItem", "Lcom/box/android/base/compose/button/model/ButtonItem$BadgedIconButtonItem;", "Lcom/box/android/base/compose/button/model/ButtonItem$IconButtonItem;", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ButtonItem {
    public static final int $stable = 0;
    private final boolean isEnabled;
    private final Function0<Unit> onClick;

    public /* synthetic */ ButtonItem(boolean z, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0);
    }

    private ButtonItem(boolean z, Function0<Unit> function0) {
        this.isEnabled = z;
        this.onClick = function0;
    }

    /* JADX INFO: compiled from: ButtonItem.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JR\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0010¨\u0006("}, d2 = {"Lcom/box/android/base/compose/button/model/ButtonItem$BadgedIconButtonItem;", "Lcom/box/android/base/compose/button/model/ButtonItem;", "isEnabled", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "contentDescription", "", "iconResource", "Lcom/box/android/base/compose/button/model/ButtonItemIconResource;", "badgeCount", "", "isLoading", "<init>", "(ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Lcom/box/android/base/compose/button/model/ButtonItemIconResource;Ljava/lang/Long;Z)V", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getContentDescription", "()Ljava/lang/String;", "getIconResource", "()Lcom/box/android/base/compose/button/model/ButtonItemIconResource;", "getBadgeCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Lcom/box/android/base/compose/button/model/ButtonItemIconResource;Ljava/lang/Long;Z)Lcom/box/android/base/compose/button/model/ButtonItem$BadgedIconButtonItem;", "equals", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BadgedIconButtonItem extends ButtonItem {
        public static final int $stable = 0;
        private final Long badgeCount;
        private final String contentDescription;
        private final ButtonItemIconResource iconResource;
        private final boolean isEnabled;
        private final boolean isLoading;
        private final Function0<Unit> onClick;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BadgedIconButtonItem copy$default(BadgedIconButtonItem badgedIconButtonItem, boolean z, Function0 function0, String str, ButtonItemIconResource buttonItemIconResource, Long l, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = badgedIconButtonItem.isEnabled;
            }
            if ((i & 2) != 0) {
                function0 = badgedIconButtonItem.onClick;
            }
            if ((i & 4) != 0) {
                str = badgedIconButtonItem.contentDescription;
            }
            if ((i & 8) != 0) {
                buttonItemIconResource = badgedIconButtonItem.iconResource;
            }
            if ((i & 16) != 0) {
                l = badgedIconButtonItem.badgeCount;
            }
            if ((i & 32) != 0) {
                z2 = badgedIconButtonItem.isLoading;
            }
            Long l2 = l;
            boolean z3 = z2;
            return badgedIconButtonItem.copy(z, function0, str, buttonItemIconResource, l2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final Function0<Unit> component2() {
            return this.onClick;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContentDescription() {
            return this.contentDescription;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ButtonItemIconResource getIconResource() {
            return this.iconResource;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getBadgeCount() {
            return this.badgeCount;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final BadgedIconButtonItem copy(boolean isEnabled, Function0<Unit> onClick, String contentDescription, ButtonItemIconResource iconResource, Long badgeCount, boolean isLoading) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
            Intrinsics.checkNotNullParameter(iconResource, "iconResource");
            return new BadgedIconButtonItem(isEnabled, onClick, contentDescription, iconResource, badgeCount, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BadgedIconButtonItem)) {
                return false;
            }
            BadgedIconButtonItem badgedIconButtonItem = (BadgedIconButtonItem) other;
            return this.isEnabled == badgedIconButtonItem.isEnabled && Intrinsics.areEqual(this.onClick, badgedIconButtonItem.onClick) && Intrinsics.areEqual(this.contentDescription, badgedIconButtonItem.contentDescription) && Intrinsics.areEqual(this.iconResource, badgedIconButtonItem.iconResource) && Intrinsics.areEqual(this.badgeCount, badgedIconButtonItem.badgeCount) && this.isLoading == badgedIconButtonItem.isLoading;
        }

        public int hashCode() {
            int iHashCode = ((((((Boolean.hashCode(this.isEnabled) * 31) + this.onClick.hashCode()) * 31) + this.contentDescription.hashCode()) * 31) + this.iconResource.hashCode()) * 31;
            Long l = this.badgeCount;
            return ((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.isLoading);
        }

        public String toString() {
            return "BadgedIconButtonItem(isEnabled=" + this.isEnabled + ", onClick=" + this.onClick + ", contentDescription=" + this.contentDescription + ", iconResource=" + this.iconResource + ", badgeCount=" + this.badgeCount + ", isLoading=" + this.isLoading + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BadgedIconButtonItem(boolean z, Function0<Unit> onClick, String contentDescription, ButtonItemIconResource iconResource, Long l, boolean z2) {
            super(z, onClick, null);
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
            Intrinsics.checkNotNullParameter(iconResource, "iconResource");
            this.isEnabled = z;
            this.onClick = onClick;
            this.contentDescription = contentDescription;
            this.iconResource = iconResource;
            this.badgeCount = l;
            this.isLoading = z2;
        }

        public /* synthetic */ BadgedIconButtonItem(boolean z, Function0 function0, String str, ButtonItemIconResource buttonItemIconResource, Long l, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, function0, str, buttonItemIconResource, (i & 16) != 0 ? null : l, (i & 32) != 0 ? false : z2);
        }

        @Override // com.box.android.base.compose.button.model.ButtonItem
        /* JADX INFO: renamed from: isEnabled */
        public boolean getIsEnabled() {
            return this.isEnabled;
        }

        @Override // com.box.android.base.compose.button.model.ButtonItem
        public Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final String getContentDescription() {
            return this.contentDescription;
        }

        public final ButtonItemIconResource getIconResource() {
            return this.iconResource;
        }

        public final Long getBadgeCount() {
            return this.badgeCount;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }
    }

    public Function0<Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* JADX INFO: compiled from: ButtonItem.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "Lcom/box/android/base/compose/button/model/ButtonItem;", "isEnabled", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "textRes", "", "<init>", "(ZLkotlin/jvm/functions/Function0;I)V", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getTextRes", "()I", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TextButtonItem extends ButtonItem {
        public static final int $stable = 0;
        private final boolean isEnabled;
        private final Function0<Unit> onClick;
        private final int textRes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TextButtonItem copy$default(TextButtonItem textButtonItem, boolean z, Function0 function0, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = textButtonItem.isEnabled;
            }
            if ((i2 & 2) != 0) {
                function0 = textButtonItem.onClick;
            }
            if ((i2 & 4) != 0) {
                i = textButtonItem.textRes;
            }
            return textButtonItem.copy(z, function0, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final Function0<Unit> component2() {
            return this.onClick;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTextRes() {
            return this.textRes;
        }

        public final TextButtonItem copy(boolean isEnabled, Function0<Unit> onClick, int textRes) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            return new TextButtonItem(isEnabled, onClick, textRes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextButtonItem)) {
                return false;
            }
            TextButtonItem textButtonItem = (TextButtonItem) other;
            return this.isEnabled == textButtonItem.isEnabled && Intrinsics.areEqual(this.onClick, textButtonItem.onClick) && this.textRes == textButtonItem.textRes;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isEnabled) * 31) + this.onClick.hashCode()) * 31) + Integer.hashCode(this.textRes);
        }

        public String toString() {
            return "TextButtonItem(isEnabled=" + this.isEnabled + ", onClick=" + this.onClick + ", textRes=" + this.textRes + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextButtonItem(boolean z, Function0<Unit> onClick, int i) {
            super(z, onClick, null);
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.isEnabled = z;
            this.onClick = onClick;
            this.textRes = i;
        }

        public /* synthetic */ TextButtonItem(boolean z, Function0 function0, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? true : z, function0, i);
        }

        @Override // com.box.android.base.compose.button.model.ButtonItem
        public Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final int getTextRes() {
            return this.textRes;
        }

        @Override // com.box.android.base.compose.button.model.ButtonItem
        /* JADX INFO: renamed from: isEnabled */
        public boolean getIsEnabled() {
            return this.isEnabled;
        }
    }

    /* JADX INFO: compiled from: ButtonItem.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000e¨\u0006!"}, d2 = {"Lcom/box/android/base/compose/button/model/ButtonItem$IconButtonItem;", "Lcom/box/android/base/compose/button/model/ButtonItem;", "isEnabled", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "contentDescription", "", "iconResource", "Lcom/box/android/base/compose/button/model/ButtonItemIconResource;", "isLoading", "<init>", "(ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Lcom/box/android/base/compose/button/model/ButtonItemIconResource;Z)V", "()Z", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "getContentDescription", "()Ljava/lang/String;", "getIconResource", "()Lcom/box/android/base/compose/button/model/ButtonItemIconResource;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IconButtonItem extends ButtonItem {
        public static final int $stable = 0;
        private final String contentDescription;
        private final ButtonItemIconResource iconResource;
        private final boolean isEnabled;
        private final boolean isLoading;
        private final Function0<Unit> onClick;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IconButtonItem copy$default(IconButtonItem iconButtonItem, boolean z, Function0 function0, String str, ButtonItemIconResource buttonItemIconResource, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = iconButtonItem.isEnabled;
            }
            if ((i & 2) != 0) {
                function0 = iconButtonItem.onClick;
            }
            if ((i & 4) != 0) {
                str = iconButtonItem.contentDescription;
            }
            if ((i & 8) != 0) {
                buttonItemIconResource = iconButtonItem.iconResource;
            }
            if ((i & 16) != 0) {
                z2 = iconButtonItem.isLoading;
            }
            boolean z3 = z2;
            String str2 = str;
            return iconButtonItem.copy(z, function0, str2, buttonItemIconResource, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final Function0<Unit> component2() {
            return this.onClick;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContentDescription() {
            return this.contentDescription;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ButtonItemIconResource getIconResource() {
            return this.iconResource;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final IconButtonItem copy(boolean isEnabled, Function0<Unit> onClick, String contentDescription, ButtonItemIconResource iconResource, boolean isLoading) {
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
            Intrinsics.checkNotNullParameter(iconResource, "iconResource");
            return new IconButtonItem(isEnabled, onClick, contentDescription, iconResource, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IconButtonItem)) {
                return false;
            }
            IconButtonItem iconButtonItem = (IconButtonItem) other;
            return this.isEnabled == iconButtonItem.isEnabled && Intrinsics.areEqual(this.onClick, iconButtonItem.onClick) && Intrinsics.areEqual(this.contentDescription, iconButtonItem.contentDescription) && Intrinsics.areEqual(this.iconResource, iconButtonItem.iconResource) && this.isLoading == iconButtonItem.isLoading;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.isEnabled) * 31) + this.onClick.hashCode()) * 31) + this.contentDescription.hashCode()) * 31) + this.iconResource.hashCode()) * 31) + Boolean.hashCode(this.isLoading);
        }

        public String toString() {
            return "IconButtonItem(isEnabled=" + this.isEnabled + ", onClick=" + this.onClick + ", contentDescription=" + this.contentDescription + ", iconResource=" + this.iconResource + ", isLoading=" + this.isLoading + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IconButtonItem(boolean z, Function0<Unit> onClick, String contentDescription, ButtonItemIconResource iconResource, boolean z2) {
            super(z, onClick, null);
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
            Intrinsics.checkNotNullParameter(iconResource, "iconResource");
            this.isEnabled = z;
            this.onClick = onClick;
            this.contentDescription = contentDescription;
            this.iconResource = iconResource;
            this.isLoading = z2;
        }

        public /* synthetic */ IconButtonItem(boolean z, Function0 function0, String str, ButtonItemIconResource buttonItemIconResource, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, function0, str, buttonItemIconResource, (i & 16) != 0 ? false : z2);
        }

        @Override // com.box.android.base.compose.button.model.ButtonItem
        /* JADX INFO: renamed from: isEnabled */
        public boolean getIsEnabled() {
            return this.isEnabled;
        }

        @Override // com.box.android.base.compose.button.model.ButtonItem
        public Function0<Unit> getOnClick() {
            return this.onClick;
        }

        public final String getContentDescription() {
            return this.contentDescription;
        }

        public final ButtonItemIconResource getIconResource() {
            return this.iconResource;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }
    }
}
