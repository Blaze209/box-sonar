package com.box.android.base.cpl;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IPreviewLauncher.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0017J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\b\u000bH&Jk\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\b\u000bH¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/box/android/base/cpl/IPreviewLauncher;", "", "launchPreview", "", "data", "Lcom/box/android/base/cpl/IPreviewLauncher$NavigationData;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "modifyIntent", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "context", "Landroid/content/Context;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "(Lcom/box/android/domain/models/ItemId;Landroid/content/Context;Lcom/box/android/domain/models/preview/PreviewSource;Ljava/lang/String;Landroidx/activity/result/ActivityResultLauncher;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NavigationData", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IPreviewLauncher {
    Object launchPreview(ItemId itemId, Context context, PreviewSource previewSource, String str, ActivityResultLauncher<Intent> activityResultLauncher, Function1<? super Intent, Unit> function1, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    void launchPreview(NavigationData data, ActivityResultLauncher<Intent> launcher, Function1<? super Intent, Unit> modifyIntent);

    /* JADX INFO: compiled from: IPreviewLauncher.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void launchPreview$default(IPreviewLauncher iPreviewLauncher, NavigationData navigationData, ActivityResultLauncher activityResultLauncher, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchPreview");
        }
        if ((i & 2) != 0) {
            activityResultLauncher = null;
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.box.android.base.cpl.IPreviewLauncher$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return IPreviewLauncher.launchPreview$lambda$0((Intent) obj2);
                }
            };
        }
        iPreviewLauncher.launchPreview(navigationData, activityResultLauncher, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit launchPreview$lambda$0(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object launchPreview$default(IPreviewLauncher iPreviewLauncher, ItemId itemId, Context context, PreviewSource previewSource, String str, ActivityResultLauncher activityResultLauncher, Function1 function1, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchPreview");
        }
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            activityResultLauncher = null;
        }
        if ((i & 32) != 0) {
            function1 = new Function1() { // from class: com.box.android.base.cpl.IPreviewLauncher$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return IPreviewLauncher.launchPreview$lambda$1((Intent) obj2);
                }
            };
        }
        return iPreviewLauncher.launchPreview(itemId, context, previewSource, str, activityResultLauncher, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit launchPreview$lambda$1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: IPreviewLauncher.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003JS\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001b¨\u0006)"}, d2 = {"Lcom/box/android/base/cpl/IPreviewLauncher$NavigationData;", "", "context", "Landroid/content/Context;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "previewNavigationTarget", "Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "isOpeningCreatedOfficeFile", "", "isNewlyCreatedFile", "<init>", "(Landroid/content/Context;Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/preview/PreviewSource;Ljava/lang/String;Lcom/box/android/base/routing/preview/PreviewNavigationTarget;ZZ)V", "getContext", "()Landroid/content/Context;", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "getSharedLink", "()Ljava/lang/String;", "getPreviewNavigationTarget", "()Lcom/box/android/base/routing/preview/PreviewNavigationTarget;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NavigationData {
        public static final int $stable = 8;
        private final Context context;
        private final FileModel fileModel;
        private final boolean isNewlyCreatedFile;
        private final boolean isOpeningCreatedOfficeFile;
        private final PreviewNavigationTarget previewNavigationTarget;
        private final PreviewSource previewSource;
        private final String sharedLink;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public NavigationData(Context context, FileModel fileModel, PreviewSource previewSource) {
            this(context, fileModel, previewSource, null, null, false, false, 120, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public NavigationData(Context context, FileModel fileModel, PreviewSource previewSource, String str) {
            this(context, fileModel, previewSource, str, null, false, false, 112, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public NavigationData(Context context, FileModel fileModel, PreviewSource previewSource, String str, PreviewNavigationTarget previewNavigationTarget) {
            this(context, fileModel, previewSource, str, previewNavigationTarget, false, false, 96, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public NavigationData(Context context, FileModel fileModel, PreviewSource previewSource, String str, PreviewNavigationTarget previewNavigationTarget, boolean z) {
            this(context, fileModel, previewSource, str, previewNavigationTarget, z, false, 64, null);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        }

        public static /* synthetic */ NavigationData copy$default(NavigationData navigationData, Context context, FileModel fileModel, PreviewSource previewSource, String str, PreviewNavigationTarget previewNavigationTarget, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                context = navigationData.context;
            }
            if ((i & 2) != 0) {
                fileModel = navigationData.fileModel;
            }
            if ((i & 4) != 0) {
                previewSource = navigationData.previewSource;
            }
            if ((i & 8) != 0) {
                str = navigationData.sharedLink;
            }
            if ((i & 16) != 0) {
                previewNavigationTarget = navigationData.previewNavigationTarget;
            }
            if ((i & 32) != 0) {
                z = navigationData.isOpeningCreatedOfficeFile;
            }
            if ((i & 64) != 0) {
                z2 = navigationData.isNewlyCreatedFile;
            }
            boolean z3 = z;
            boolean z4 = z2;
            PreviewNavigationTarget previewNavigationTarget2 = previewNavigationTarget;
            PreviewSource previewSource2 = previewSource;
            return navigationData.copy(context, fileModel, previewSource2, str, previewNavigationTarget2, z3, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSharedLink() {
            return this.sharedLink;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final PreviewNavigationTarget getPreviewNavigationTarget() {
            return this.previewNavigationTarget;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsOpeningCreatedOfficeFile() {
            return this.isOpeningCreatedOfficeFile;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsNewlyCreatedFile() {
            return this.isNewlyCreatedFile;
        }

        public final NavigationData copy(Context context, FileModel fileModel, PreviewSource previewSource, String sharedLink, PreviewNavigationTarget previewNavigationTarget, boolean isOpeningCreatedOfficeFile, boolean isNewlyCreatedFile) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            return new NavigationData(context, fileModel, previewSource, sharedLink, previewNavigationTarget, isOpeningCreatedOfficeFile, isNewlyCreatedFile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigationData)) {
                return false;
            }
            NavigationData navigationData = (NavigationData) other;
            return Intrinsics.areEqual(this.context, navigationData.context) && Intrinsics.areEqual(this.fileModel, navigationData.fileModel) && Intrinsics.areEqual(this.previewSource, navigationData.previewSource) && Intrinsics.areEqual(this.sharedLink, navigationData.sharedLink) && Intrinsics.areEqual(this.previewNavigationTarget, navigationData.previewNavigationTarget) && this.isOpeningCreatedOfficeFile == navigationData.isOpeningCreatedOfficeFile && this.isNewlyCreatedFile == navigationData.isNewlyCreatedFile;
        }

        public int hashCode() {
            int iHashCode = ((((this.context.hashCode() * 31) + this.fileModel.hashCode()) * 31) + this.previewSource.hashCode()) * 31;
            String str = this.sharedLink;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            PreviewNavigationTarget previewNavigationTarget = this.previewNavigationTarget;
            return ((((iHashCode2 + (previewNavigationTarget != null ? previewNavigationTarget.hashCode() : 0)) * 31) + Boolean.hashCode(this.isOpeningCreatedOfficeFile)) * 31) + Boolean.hashCode(this.isNewlyCreatedFile);
        }

        public String toString() {
            return "NavigationData(context=" + this.context + ", fileModel=" + this.fileModel + ", previewSource=" + this.previewSource + ", sharedLink=" + this.sharedLink + ", previewNavigationTarget=" + this.previewNavigationTarget + ", isOpeningCreatedOfficeFile=" + this.isOpeningCreatedOfficeFile + ", isNewlyCreatedFile=" + this.isNewlyCreatedFile + ")";
        }

        public NavigationData(Context context, FileModel fileModel, PreviewSource previewSource, String str, PreviewNavigationTarget previewNavigationTarget, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            this.context = context;
            this.fileModel = fileModel;
            this.previewSource = previewSource;
            this.sharedLink = str;
            this.previewNavigationTarget = previewNavigationTarget;
            this.isOpeningCreatedOfficeFile = z;
            this.isNewlyCreatedFile = z2;
        }

        public /* synthetic */ NavigationData(Context context, FileModel fileModel, PreviewSource previewSource, String str, PreviewNavigationTarget previewNavigationTarget, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, fileModel, previewSource, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : previewNavigationTarget, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2);
        }

        public final Context getContext() {
            return this.context;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public final String getSharedLink() {
            return this.sharedLink;
        }

        public final PreviewNavigationTarget getPreviewNavigationTarget() {
            return this.previewNavigationTarget;
        }

        public final boolean isOpeningCreatedOfficeFile() {
            return this.isOpeningCreatedOfficeFile;
        }

        public final boolean isNewlyCreatedFile() {
            return this.isNewlyCreatedFile;
        }
    }
}
