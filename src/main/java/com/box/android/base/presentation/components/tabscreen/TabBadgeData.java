package com.box.android.base.presentation.components.tabscreen;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: CommonTabsScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/components/tabscreen/TabBadgeData;", "", "text", "", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getTestTag", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TabBadgeData {
    public static final int $stable = 0;
    private final String testTag;
    private final String text;

    public static /* synthetic */ TabBadgeData copy$default(TabBadgeData tabBadgeData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tabBadgeData.text;
        }
        if ((i & 2) != 0) {
            str2 = tabBadgeData.testTag;
        }
        return tabBadgeData.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTestTag() {
        return this.testTag;
    }

    public final TabBadgeData copy(String text, String testTag) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(testTag, "testTag");
        return new TabBadgeData(text, testTag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabBadgeData)) {
            return false;
        }
        TabBadgeData tabBadgeData = (TabBadgeData) other;
        return Intrinsics.areEqual(this.text, tabBadgeData.text) && Intrinsics.areEqual(this.testTag, tabBadgeData.testTag);
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.testTag.hashCode();
    }

    public String toString() {
        return "TabBadgeData(text=" + this.text + ", testTag=" + this.testTag + ")";
    }

    public TabBadgeData(String text, String testTag) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(testTag, "testTag");
        this.text = text;
        this.testTag = testTag;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public final String getText() {
        return this.text;
    }
}
