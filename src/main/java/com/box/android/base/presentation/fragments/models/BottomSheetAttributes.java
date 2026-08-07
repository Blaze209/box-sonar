package com.box.android.base.presentation.fragments.models;

import android.content.Context;
import com.box.android.base.R;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: BottomSheetAttributes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u0003J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes;", "", "menuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "<init>", "(Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;)V", "getCustomMenuItemTitle", "", "context", "Landroid/content/Context;", "canDeleteItemBeShown", "", "getCustomMenuType", "canWatermarkingItemBeShown", "isFeatureEnabled", "hasEnterprise", "getCompletionDialog", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog;", "setBottomSheetMenuType", "", "bottomSheetMenuType", "setLaunchContext", "BottomSheetMenuCompletionDialog", "BottomSheetMenuType", "LaunchContext", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BottomSheetAttributes {
    public static final int $stable = 8;
    private LaunchContext launchContext;
    private BottomSheetMenuType menuType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetAttributes(BottomSheetMenuType menuType) {
        this(menuType, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(menuType, "menuType");
    }

    public BottomSheetAttributes(BottomSheetMenuType menuType, LaunchContext launchContext) {
        Intrinsics.checkNotNullParameter(menuType, "menuType");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        this.menuType = menuType;
        this.launchContext = launchContext;
    }

    public /* synthetic */ BottomSheetAttributes(BottomSheetMenuType bottomSheetMenuType, LaunchContext.Default r2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bottomSheetMenuType, (i & 2) != 0 ? LaunchContext.Default.INSTANCE : r2);
    }

    /* JADX INFO: compiled from: BottomSheetAttributes.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog;", "Ljava/io/Serializable;", "<init>", "()V", "None", "AddRemoveCollectionsDialog", "ConfirmationDialog", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog$AddRemoveCollectionsDialog;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog$ConfirmationDialog;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog$None;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class BottomSheetMenuCompletionDialog implements Serializable {
        public static final int $stable = 0;

        public /* synthetic */ BottomSheetMenuCompletionDialog(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog$None;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends BottomSheetMenuCompletionDialog {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof None)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1602484667;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        private BottomSheetMenuCompletionDialog() {
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog$AddRemoveCollectionsDialog;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AddRemoveCollectionsDialog extends BottomSheetMenuCompletionDialog {
            public static final int $stable = 0;
            public static final AddRemoveCollectionsDialog INSTANCE = new AddRemoveCollectionsDialog();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AddRemoveCollectionsDialog)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 563201157;
            }

            public String toString() {
                return "AddRemoveCollectionsDialog";
            }

            private AddRemoveCollectionsDialog() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog$ConfirmationDialog;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog;", BoxItemJob.COLLECTION_ID, "", "<init>", "(Ljava/lang/String;)V", "getCollectionId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ConfirmationDialog extends BottomSheetMenuCompletionDialog {
            public static final int $stable = 0;
            private final String collectionId;

            public static /* synthetic */ ConfirmationDialog copy$default(ConfirmationDialog confirmationDialog, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = confirmationDialog.collectionId;
                }
                return confirmationDialog.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getCollectionId() {
                return this.collectionId;
            }

            public final ConfirmationDialog copy(String collectionId) {
                Intrinsics.checkNotNullParameter(collectionId, "collectionId");
                return new ConfirmationDialog(collectionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConfirmationDialog) && Intrinsics.areEqual(this.collectionId, ((ConfirmationDialog) other).collectionId);
            }

            public int hashCode() {
                return this.collectionId.hashCode();
            }

            public String toString() {
                return "ConfirmationDialog(collectionId=" + this.collectionId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmationDialog(String collectionId) {
                super(null);
                Intrinsics.checkNotNullParameter(collectionId, "collectionId");
                this.collectionId = collectionId;
            }

            public final String getCollectionId() {
                return this.collectionId;
            }
        }
    }

    /* JADX INFO: compiled from: BottomSheetAttributes.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "Ljava/io/Serializable;", "<init>", "()V", "Default", "AddRemoveCollectionItems", "RemoveCollectionItems", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType$AddRemoveCollectionItems;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType$Default;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType$RemoveCollectionItems;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class BottomSheetMenuType implements Serializable {
        public static final int $stable = 0;

        public /* synthetic */ BottomSheetMenuType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType$Default;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Default extends BottomSheetMenuType {
            public static final int $stable = 0;
            public static final Default INSTANCE = new Default();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Default)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -580547446;
            }

            public String toString() {
                return "Default";
            }

            private Default() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        private BottomSheetMenuType() {
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType$AddRemoveCollectionItems;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AddRemoveCollectionItems extends BottomSheetMenuType {
            public static final int $stable = 0;
            public static final AddRemoveCollectionItems INSTANCE = new AddRemoveCollectionItems();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AddRemoveCollectionItems)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1533975892;
            }

            public String toString() {
                return "AddRemoveCollectionItems";
            }

            private AddRemoveCollectionItems() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType$RemoveCollectionItems;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "collectionName", "", BoxItemJob.COLLECTION_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCollectionName", "()Ljava/lang/String;", "getCollectionId", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RemoveCollectionItems extends BottomSheetMenuType {
            public static final int $stable = 0;
            private final String collectionId;
            private final String collectionName;

            public static /* synthetic */ RemoveCollectionItems copy$default(RemoveCollectionItems removeCollectionItems, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = removeCollectionItems.collectionName;
                }
                if ((i & 2) != 0) {
                    str2 = removeCollectionItems.collectionId;
                }
                return removeCollectionItems.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getCollectionName() {
                return this.collectionName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCollectionId() {
                return this.collectionId;
            }

            public final RemoveCollectionItems copy(String collectionName, String collectionId) {
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                Intrinsics.checkNotNullParameter(collectionId, "collectionId");
                return new RemoveCollectionItems(collectionName, collectionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemoveCollectionItems)) {
                    return false;
                }
                RemoveCollectionItems removeCollectionItems = (RemoveCollectionItems) other;
                return Intrinsics.areEqual(this.collectionName, removeCollectionItems.collectionName) && Intrinsics.areEqual(this.collectionId, removeCollectionItems.collectionId);
            }

            public int hashCode() {
                return (this.collectionName.hashCode() * 31) + this.collectionId.hashCode();
            }

            public String toString() {
                return "RemoveCollectionItems(collectionName=" + this.collectionName + ", collectionId=" + this.collectionId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoveCollectionItems(String collectionName, String collectionId) {
                super(null);
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                Intrinsics.checkNotNullParameter(collectionId, "collectionId");
                this.collectionName = collectionName;
                this.collectionId = collectionId;
            }

            public final String getCollectionId() {
                return this.collectionId;
            }

            public final String getCollectionName() {
                return this.collectionName;
            }
        }
    }

    /* JADX INFO: compiled from: BottomSheetAttributes.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "Ljava/io/Serializable;", "<init>", "()V", "Default", "BrowseAllFiles", "BrowseRecents", "BrowseOfflined", "CaptureHistory", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$BrowseAllFiles;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$BrowseOfflined;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$BrowseRecents;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$CaptureHistory;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$Default;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class LaunchContext implements Serializable {
        public static final int $stable = 0;

        public /* synthetic */ LaunchContext(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$Default;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Default extends LaunchContext {
            public static final int $stable = 0;
            public static final Default INSTANCE = new Default();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Default)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 850980921;
            }

            public String toString() {
                return "Default";
            }

            private Default() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        private LaunchContext() {
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$BrowseAllFiles;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BrowseAllFiles extends LaunchContext {
            public static final int $stable = 0;
            public static final BrowseAllFiles INSTANCE = new BrowseAllFiles();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BrowseAllFiles)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -663204600;
            }

            public String toString() {
                return "BrowseAllFiles";
            }

            private BrowseAllFiles() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$BrowseRecents;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BrowseRecents extends LaunchContext {
            public static final int $stable = 0;
            public static final BrowseRecents INSTANCE = new BrowseRecents();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BrowseRecents)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1419290502;
            }

            public String toString() {
                return "BrowseRecents";
            }

            private BrowseRecents() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$BrowseOfflined;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class BrowseOfflined extends LaunchContext {
            public static final int $stable = 0;
            public static final BrowseOfflined INSTANCE = new BrowseOfflined();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof BrowseOfflined)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1094569619;
            }

            public String toString() {
                return "BrowseOfflined";
            }

            private BrowseOfflined() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }

        /* JADX INFO: compiled from: BottomSheetAttributes.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\t\u001a\u00020\nHÖ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext$CaptureHistory;", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "<init>", "()V", "readResolve", "", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CaptureHistory extends LaunchContext {
            public static final int $stable = 0;
            public static final CaptureHistory INSTANCE = new CaptureHistory();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CaptureHistory)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -983737994;
            }

            public String toString() {
                return "CaptureHistory";
            }

            private CaptureHistory() {
                super(null);
            }

            private final Object readResolve() {
                return INSTANCE;
            }
        }
    }

    public final String getCustomMenuItemTitle(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BottomSheetMenuType bottomSheetMenuType = this.menuType;
        if (bottomSheetMenuType instanceof BottomSheetMenuType.AddRemoveCollectionItems) {
            String string = context.getString(R.string.add_to_collections);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (bottomSheetMenuType instanceof BottomSheetMenuType.RemoveCollectionItems) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = context.getString(R.string.remove_from_collection);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String str = String.format(string2, Arrays.copyOf(new Object[]{((BottomSheetMenuType.RemoveCollectionItems) bottomSheetMenuType).getCollectionName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        return "";
    }

    public final boolean canDeleteItemBeShown() {
        return !(this.menuType instanceof BottomSheetMenuType.RemoveCollectionItems);
    }

    /* JADX INFO: renamed from: getCustomMenuType, reason: from getter */
    public final BottomSheetMenuType getMenuType() {
        return this.menuType;
    }

    public static /* synthetic */ boolean canWatermarkingItemBeShown$default(BottomSheetAttributes bottomSheetAttributes, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return bottomSheetAttributes.canWatermarkingItemBeShown(z, z2);
    }

    public final boolean canWatermarkingItemBeShown(boolean isFeatureEnabled, boolean hasEnterprise) {
        return isFeatureEnabled && hasEnterprise && !CollectionsKt.listOf((Object[]) new LaunchContext[]{LaunchContext.BrowseOfflined.INSTANCE, LaunchContext.BrowseRecents.INSTANCE, LaunchContext.CaptureHistory.INSTANCE}).contains(this.launchContext);
    }

    public final BottomSheetMenuCompletionDialog getCompletionDialog() {
        BottomSheetMenuType bottomSheetMenuType = this.menuType;
        if (bottomSheetMenuType instanceof BottomSheetMenuType.RemoveCollectionItems) {
            return new BottomSheetMenuCompletionDialog.ConfirmationDialog(((BottomSheetMenuType.RemoveCollectionItems) bottomSheetMenuType).getCollectionId());
        }
        if (bottomSheetMenuType instanceof BottomSheetMenuType.AddRemoveCollectionItems) {
            return BottomSheetMenuCompletionDialog.AddRemoveCollectionsDialog.INSTANCE;
        }
        if (bottomSheetMenuType instanceof BottomSheetMenuType.Default) {
            return BottomSheetMenuCompletionDialog.None.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setBottomSheetMenuType(BottomSheetMenuType bottomSheetMenuType) {
        Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
        this.menuType = bottomSheetMenuType;
    }

    public final void setLaunchContext(LaunchContext launchContext) {
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        this.launchContext = launchContext;
    }
}
