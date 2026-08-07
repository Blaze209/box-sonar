package com.box.android.base.presentation.utilities;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IItemClickHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u001a\u001b\u001c\u001dJ6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0015H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0019H&¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "", ViewProps.ON_CLICK, "", "item", "Lcom/box/androidsdk/content/models/BoxItem;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "shouldLog", "", "onFileClick", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "config", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$FileClickConfig;", "onFolderClick", "boxFolder", "Lcom/box/androidsdk/content/models/BoxFolder;", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$FolderClickConfig;", "onBookmarkClick", "boxBookmark", "Lcom/box/androidsdk/content/models/BoxBookmark;", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$BookmarkClickConfig;", "FileClickConfig", "BookmarkClickConfig", "FolderClickConfig", "Factory", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IItemClickHandler {

    /* JADX INFO: compiled from: IItemClickHandler.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemClickHandler$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        IItemClickHandler create(AppCompatActivity activity);
    }

    void onBookmarkClick(BoxBookmark boxBookmark, BookmarkClickConfig config);

    void onClick(BoxItem item, PreviewSource previewSource, ActivityResultLauncher<Intent> launcher, boolean shouldLog);

    void onFileClick(BoxFile boxFile, FileClickConfig config);

    void onFolderClick(BoxFolder boxFolder, FolderClickConfig config);

    /* JADX INFO: compiled from: IItemClickHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void onClick$default(IItemClickHandler iItemClickHandler, BoxItem boxItem, PreviewSource previewSource, ActivityResultLauncher activityResultLauncher, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClick");
        }
        if ((i & 2) != 0) {
            previewSource = PreviewSource.Unknown.INSTANCE;
        }
        if ((i & 4) != 0) {
            activityResultLauncher = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        iItemClickHandler.onClick(boxItem, previewSource, activityResultLauncher, z);
    }

    static /* synthetic */ void onFolderClick$default(IItemClickHandler iItemClickHandler, BoxFolder boxFolder, FolderClickConfig folderClickConfig, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFolderClick");
        }
        if ((i & 2) != 0) {
            folderClickConfig = new FolderClickConfig(null, 0, null, false, 15, null);
        }
        iItemClickHandler.onFolderClick(boxFolder, folderClickConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void onBookmarkClick$default(IItemClickHandler iItemClickHandler, BoxBookmark boxBookmark, BookmarkClickConfig bookmarkClickConfig, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBookmarkClick");
        }
        if ((i & 2) != 0) {
            bookmarkClickConfig = new BookmarkClickConfig(null, false, 3, 0 == true ? 1 : 0);
        }
        iItemClickHandler.onBookmarkClick(boxBookmark, bookmarkClickConfig);
    }

    /* JADX INFO: compiled from: IItemClickHandler.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003J\t\u0010,\u001a\u00020\u000fHÆ\u0003J\u008c\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u000e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\"R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"¨\u00064"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemClickHandler$FileClickConfig;", "", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "sharedLinkUrl", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onPermissionDenied", "Lkotlin/Function0;", "", "intentConfigurator", "Lkotlin/Function1;", "isRecentSharedFileValue", "", "uploadName", "isNewlyCreatedFile", "shouldLog", "<init>", "(Lcom/box/android/domain/models/preview/PreviewSource;Ljava/lang/String;Landroidx/activity/result/ActivityResultLauncher;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/Boolean;Ljava/lang/String;ZZ)V", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "getSharedLinkUrl", "()Ljava/lang/String;", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "getOnPermissionDenied", "()Lkotlin/jvm/functions/Function0;", "getIntentConfigurator", "()Lkotlin/jvm/functions/Function1;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUploadName", "()Z", "getShouldLog", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/preview/PreviewSource;Ljava/lang/String;Landroidx/activity/result/ActivityResultLauncher;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/Boolean;Ljava/lang/String;ZZ)Lcom/box/android/base/presentation/utilities/IItemClickHandler$FileClickConfig;", "equals", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileClickConfig {
        public static final int $stable = 8;
        private final Function1<Intent, Unit> intentConfigurator;
        private final boolean isNewlyCreatedFile;
        private final Boolean isRecentSharedFileValue;
        private final ActivityResultLauncher<Intent> launcher;
        private final Function0<Unit> onPermissionDenied;
        private final PreviewSource previewSource;
        private final String sharedLinkUrl;
        private final boolean shouldLog;
        private final String uploadName;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FileClickConfig copy$default(FileClickConfig fileClickConfig, PreviewSource previewSource, String str, ActivityResultLauncher activityResultLauncher, Function0 function0, Function1 function1, Boolean bool, String str2, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                previewSource = fileClickConfig.previewSource;
            }
            if ((i & 2) != 0) {
                str = fileClickConfig.sharedLinkUrl;
            }
            if ((i & 4) != 0) {
                activityResultLauncher = fileClickConfig.launcher;
            }
            if ((i & 8) != 0) {
                function0 = fileClickConfig.onPermissionDenied;
            }
            if ((i & 16) != 0) {
                function1 = fileClickConfig.intentConfigurator;
            }
            if ((i & 32) != 0) {
                bool = fileClickConfig.isRecentSharedFileValue;
            }
            if ((i & 64) != 0) {
                str2 = fileClickConfig.uploadName;
            }
            if ((i & 128) != 0) {
                z = fileClickConfig.isNewlyCreatedFile;
            }
            if ((i & 256) != 0) {
                z2 = fileClickConfig.shouldLog;
            }
            boolean z3 = z;
            boolean z4 = z2;
            Boolean bool2 = bool;
            String str3 = str2;
            Function1 function2 = function1;
            ActivityResultLauncher activityResultLauncher2 = activityResultLauncher;
            return fileClickConfig.copy(previewSource, str, activityResultLauncher2, function0, function2, bool2, str3, z3, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSharedLinkUrl() {
            return this.sharedLinkUrl;
        }

        public final ActivityResultLauncher<Intent> component3() {
            return this.launcher;
        }

        public final Function0<Unit> component4() {
            return this.onPermissionDenied;
        }

        public final Function1<Intent, Unit> component5() {
            return this.intentConfigurator;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsRecentSharedFileValue() {
            return this.isRecentSharedFileValue;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getUploadName() {
            return this.uploadName;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsNewlyCreatedFile() {
            return this.isNewlyCreatedFile;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getShouldLog() {
            return this.shouldLog;
        }

        public final FileClickConfig copy(PreviewSource previewSource, String sharedLinkUrl, ActivityResultLauncher<Intent> launcher, Function0<Unit> onPermissionDenied, Function1<? super Intent, Unit> intentConfigurator, Boolean isRecentSharedFileValue, String uploadName, boolean isNewlyCreatedFile, boolean shouldLog) {
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            return new FileClickConfig(previewSource, sharedLinkUrl, launcher, onPermissionDenied, intentConfigurator, isRecentSharedFileValue, uploadName, isNewlyCreatedFile, shouldLog);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileClickConfig)) {
                return false;
            }
            FileClickConfig fileClickConfig = (FileClickConfig) other;
            return Intrinsics.areEqual(this.previewSource, fileClickConfig.previewSource) && Intrinsics.areEqual(this.sharedLinkUrl, fileClickConfig.sharedLinkUrl) && Intrinsics.areEqual(this.launcher, fileClickConfig.launcher) && Intrinsics.areEqual(this.onPermissionDenied, fileClickConfig.onPermissionDenied) && Intrinsics.areEqual(this.intentConfigurator, fileClickConfig.intentConfigurator) && Intrinsics.areEqual(this.isRecentSharedFileValue, fileClickConfig.isRecentSharedFileValue) && Intrinsics.areEqual(this.uploadName, fileClickConfig.uploadName) && this.isNewlyCreatedFile == fileClickConfig.isNewlyCreatedFile && this.shouldLog == fileClickConfig.shouldLog;
        }

        public int hashCode() {
            int iHashCode = this.previewSource.hashCode() * 31;
            String str = this.sharedLinkUrl;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            ActivityResultLauncher<Intent> activityResultLauncher = this.launcher;
            int iHashCode3 = (iHashCode2 + (activityResultLauncher == null ? 0 : activityResultLauncher.hashCode())) * 31;
            Function0<Unit> function0 = this.onPermissionDenied;
            int iHashCode4 = (iHashCode3 + (function0 == null ? 0 : function0.hashCode())) * 31;
            Function1<Intent, Unit> function1 = this.intentConfigurator;
            int iHashCode5 = (iHashCode4 + (function1 == null ? 0 : function1.hashCode())) * 31;
            Boolean bool = this.isRecentSharedFileValue;
            int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.uploadName;
            return ((((iHashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isNewlyCreatedFile)) * 31) + Boolean.hashCode(this.shouldLog);
        }

        public String toString() {
            return "FileClickConfig(previewSource=" + this.previewSource + ", sharedLinkUrl=" + this.sharedLinkUrl + ", launcher=" + this.launcher + ", onPermissionDenied=" + this.onPermissionDenied + ", intentConfigurator=" + this.intentConfigurator + ", isRecentSharedFileValue=" + this.isRecentSharedFileValue + ", uploadName=" + this.uploadName + ", isNewlyCreatedFile=" + this.isNewlyCreatedFile + ", shouldLog=" + this.shouldLog + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FileClickConfig(PreviewSource previewSource, String str, ActivityResultLauncher<Intent> activityResultLauncher, Function0<Unit> function0, Function1<? super Intent, Unit> function1, Boolean bool, String str2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            this.previewSource = previewSource;
            this.sharedLinkUrl = str;
            this.launcher = activityResultLauncher;
            this.onPermissionDenied = function0;
            this.intentConfigurator = function1;
            this.isRecentSharedFileValue = bool;
            this.uploadName = str2;
            this.isNewlyCreatedFile = z;
            this.shouldLog = z2;
        }

        public /* synthetic */ FileClickConfig(PreviewSource previewSource, String str, ActivityResultLauncher activityResultLauncher, Function0 function0, Function1 function1, Boolean bool, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(previewSource, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : activityResultLauncher, (i & 8) != 0 ? null : function0, (i & 16) != 0 ? null : function1, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? false : z, (i & 256) != 0 ? true : z2);
        }

        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public final String getSharedLinkUrl() {
            return this.sharedLinkUrl;
        }

        public final ActivityResultLauncher<Intent> getLauncher() {
            return this.launcher;
        }

        public final Function0<Unit> getOnPermissionDenied() {
            return this.onPermissionDenied;
        }

        public final Function1<Intent, Unit> getIntentConfigurator() {
            return this.intentConfigurator;
        }

        public final Boolean isRecentSharedFileValue() {
            return this.isRecentSharedFileValue;
        }

        public final String getUploadName() {
            return this.uploadName;
        }

        public final boolean isNewlyCreatedFile() {
            return this.isNewlyCreatedFile;
        }

        public final boolean getShouldLog() {
            return this.shouldLog;
        }
    }

    /* JADX INFO: compiled from: IItemClickHandler.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemClickHandler$BookmarkClickConfig;", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "shouldLog", "", "<init>", "(Landroidx/activity/result/ActivityResultLauncher;Z)V", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "getShouldLog", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BookmarkClickConfig {
        public static final int $stable = 8;
        private final ActivityResultLauncher<Intent> launcher;
        private final boolean shouldLog;

        /* JADX WARN: Multi-variable type inference failed */
        public BookmarkClickConfig() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BookmarkClickConfig copy$default(BookmarkClickConfig bookmarkClickConfig, ActivityResultLauncher activityResultLauncher, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                activityResultLauncher = bookmarkClickConfig.launcher;
            }
            if ((i & 2) != 0) {
                z = bookmarkClickConfig.shouldLog;
            }
            return bookmarkClickConfig.copy(activityResultLauncher, z);
        }

        public final ActivityResultLauncher<Intent> component1() {
            return this.launcher;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShouldLog() {
            return this.shouldLog;
        }

        public final BookmarkClickConfig copy(ActivityResultLauncher<Intent> launcher, boolean shouldLog) {
            return new BookmarkClickConfig(launcher, shouldLog);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BookmarkClickConfig)) {
                return false;
            }
            BookmarkClickConfig bookmarkClickConfig = (BookmarkClickConfig) other;
            return Intrinsics.areEqual(this.launcher, bookmarkClickConfig.launcher) && this.shouldLog == bookmarkClickConfig.shouldLog;
        }

        public int hashCode() {
            ActivityResultLauncher<Intent> activityResultLauncher = this.launcher;
            return ((activityResultLauncher == null ? 0 : activityResultLauncher.hashCode()) * 31) + Boolean.hashCode(this.shouldLog);
        }

        public String toString() {
            return "BookmarkClickConfig(launcher=" + this.launcher + ", shouldLog=" + this.shouldLog + ")";
        }

        public BookmarkClickConfig(ActivityResultLauncher<Intent> activityResultLauncher, boolean z) {
            this.launcher = activityResultLauncher;
            this.shouldLog = z;
        }

        public /* synthetic */ BookmarkClickConfig(ActivityResultLauncher activityResultLauncher, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : activityResultLauncher, (i & 2) != 0 ? true : z);
        }

        public final ActivityResultLauncher<Intent> getLauncher() {
            return this.launcher;
        }

        public final boolean getShouldLog() {
            return this.shouldLog;
        }
    }

    /* JADX INFO: compiled from: IItemClickHandler.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\fHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/box/android/base/presentation/utilities/IItemClickHandler$FolderClickConfig;", "", "customNavigationHandler", "Lkotlin/Function1;", "Lcom/box/androidsdk/content/models/BoxFolder;", "", "flags", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "shouldLog", "", "<init>", "(Lkotlin/jvm/functions/Function1;ILandroidx/activity/result/ActivityResultLauncher;Z)V", "getCustomNavigationHandler", "()Lkotlin/jvm/functions/Function1;", "getFlags", "()I", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "getShouldLog", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FolderClickConfig {
        public static final int $stable = 8;
        private final Function1<BoxFolder, Unit> customNavigationHandler;
        private final int flags;
        private final ActivityResultLauncher<Intent> launcher;
        private final boolean shouldLog;

        public FolderClickConfig() {
            this(null, 0, null, false, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FolderClickConfig copy$default(FolderClickConfig folderClickConfig, Function1 function1, int i, ActivityResultLauncher activityResultLauncher, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                function1 = folderClickConfig.customNavigationHandler;
            }
            if ((i2 & 2) != 0) {
                i = folderClickConfig.flags;
            }
            if ((i2 & 4) != 0) {
                activityResultLauncher = folderClickConfig.launcher;
            }
            if ((i2 & 8) != 0) {
                z = folderClickConfig.shouldLog;
            }
            return folderClickConfig.copy(function1, i, activityResultLauncher, z);
        }

        public final Function1<BoxFolder, Unit> component1() {
            return this.customNavigationHandler;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFlags() {
            return this.flags;
        }

        public final ActivityResultLauncher<Intent> component3() {
            return this.launcher;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getShouldLog() {
            return this.shouldLog;
        }

        public final FolderClickConfig copy(Function1<? super BoxFolder, Unit> customNavigationHandler, int flags, ActivityResultLauncher<Intent> launcher, boolean shouldLog) {
            return new FolderClickConfig(customNavigationHandler, flags, launcher, shouldLog);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FolderClickConfig)) {
                return false;
            }
            FolderClickConfig folderClickConfig = (FolderClickConfig) other;
            return Intrinsics.areEqual(this.customNavigationHandler, folderClickConfig.customNavigationHandler) && this.flags == folderClickConfig.flags && Intrinsics.areEqual(this.launcher, folderClickConfig.launcher) && this.shouldLog == folderClickConfig.shouldLog;
        }

        public int hashCode() {
            Function1<BoxFolder, Unit> function1 = this.customNavigationHandler;
            int iHashCode = (((function1 == null ? 0 : function1.hashCode()) * 31) + Integer.hashCode(this.flags)) * 31;
            ActivityResultLauncher<Intent> activityResultLauncher = this.launcher;
            return ((iHashCode + (activityResultLauncher != null ? activityResultLauncher.hashCode() : 0)) * 31) + Boolean.hashCode(this.shouldLog);
        }

        public String toString() {
            return "FolderClickConfig(customNavigationHandler=" + this.customNavigationHandler + ", flags=" + this.flags + ", launcher=" + this.launcher + ", shouldLog=" + this.shouldLog + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FolderClickConfig(Function1<? super BoxFolder, Unit> function1, int i, ActivityResultLauncher<Intent> activityResultLauncher, boolean z) {
            this.customNavigationHandler = function1;
            this.flags = i;
            this.launcher = activityResultLauncher;
            this.shouldLog = z;
        }

        public /* synthetic */ FolderClickConfig(Function1 function1, int i, ActivityResultLauncher activityResultLauncher, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : function1, (i2 & 2) != 0 ? 335544320 : i, (i2 & 4) != 0 ? null : activityResultLauncher, (i2 & 8) != 0 ? true : z);
        }

        public final Function1<BoxFolder, Unit> getCustomNavigationHandler() {
            return this.customNavigationHandler;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final ActivityResultLauncher<Intent> getLauncher() {
            return this.launcher;
        }

        public final boolean getShouldLog() {
            return this.shouldLog;
        }
    }
}
