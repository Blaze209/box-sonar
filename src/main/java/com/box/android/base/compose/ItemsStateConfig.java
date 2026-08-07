package com.box.android.base.compose;

import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemStateScreens.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/box/android/base/compose/ItemsStateConfig;", "", "drawableId", "", "mainText", "", "subText", "actionItem", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;)V", "getDrawableId", "()I", "getMainText", "()Ljava/lang/String;", "getSubText", "getActionItem", "()Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemsStateConfig {
    public static final int $stable = 0;
    private final ButtonItem.TextButtonItem actionItem;
    private final int drawableId;
    private final String mainText;
    private final String subText;

    public static /* synthetic */ ItemsStateConfig copy$default(ItemsStateConfig itemsStateConfig, int i, String str, String str2, ButtonItem.TextButtonItem textButtonItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = itemsStateConfig.drawableId;
        }
        if ((i2 & 2) != 0) {
            str = itemsStateConfig.mainText;
        }
        if ((i2 & 4) != 0) {
            str2 = itemsStateConfig.subText;
        }
        if ((i2 & 8) != 0) {
            textButtonItem = itemsStateConfig.actionItem;
        }
        return itemsStateConfig.copy(i, str, str2, textButtonItem);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDrawableId() {
        return this.drawableId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMainText() {
        return this.mainText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubText() {
        return this.subText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ButtonItem.TextButtonItem getActionItem() {
        return this.actionItem;
    }

    public final ItemsStateConfig copy(int drawableId, String mainText, String subText, ButtonItem.TextButtonItem actionItem) {
        return new ItemsStateConfig(drawableId, mainText, subText, actionItem);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemsStateConfig)) {
            return false;
        }
        ItemsStateConfig itemsStateConfig = (ItemsStateConfig) other;
        return this.drawableId == itemsStateConfig.drawableId && Intrinsics.areEqual(this.mainText, itemsStateConfig.mainText) && Intrinsics.areEqual(this.subText, itemsStateConfig.subText) && Intrinsics.areEqual(this.actionItem, itemsStateConfig.actionItem);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.drawableId) * 31;
        String str = this.mainText;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ButtonItem.TextButtonItem textButtonItem = this.actionItem;
        return iHashCode3 + (textButtonItem != null ? textButtonItem.hashCode() : 0);
    }

    public String toString() {
        return "ItemsStateConfig(drawableId=" + this.drawableId + ", mainText=" + this.mainText + ", subText=" + this.subText + ", actionItem=" + this.actionItem + ")";
    }

    public ItemsStateConfig(int i, String str, String str2, ButtonItem.TextButtonItem textButtonItem) {
        this.drawableId = i;
        this.mainText = str;
        this.subText = str2;
        this.actionItem = textButtonItem;
    }

    public /* synthetic */ ItemsStateConfig(int i, String str, String str2, ButtonItem.TextButtonItem textButtonItem, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : textButtonItem);
    }

    public final int getDrawableId() {
        return this.drawableId;
    }

    public final String getMainText() {
        return this.mainText;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final ButtonItem.TextButtonItem getActionItem() {
        return this.actionItem;
    }
}
