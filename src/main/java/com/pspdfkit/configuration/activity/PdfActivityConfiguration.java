package com.pspdfkit.configuration.activity;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.C;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.observability.DiagnosisParams;
import com.pspdfkit.R;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.annotations.AnnotationReplyFeatures;
import com.pspdfkit.configuration.annotations.CopyPasteFeatures;
import com.pspdfkit.configuration.forms.SignaturePickerOrientation;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.search.SearchConfiguration;
import com.pspdfkit.configuration.search.SearchType;
import com.pspdfkit.configuration.settings.SettingsMenuItemType;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.configuration.signatures.SignatureColorOptions;
import com.pspdfkit.configuration.signatures.SignatureCreationMode;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.configuration.theming.ThemeMode;
import com.pspdfkit.document.OutlineElementState;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import com.pspdfkit.internal.tg;
import com.pspdfkit.internal.uc;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ~2\u00020\u0001:\u0002~\u007fBÁ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0018\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\u0006\u0010&\u001a\u00020\u000b\u0012\u0006\u0010'\u001a\u00020\u000b\u0012\u0006\u0010(\u001a\u00020\u000b\u0012\u0006\u0010)\u001a\u00020\u000b\u0012\b\b\u0001\u0010*\u001a\u00020\u0007\u0012\b\u0010+\u001a\u0004\u0018\u00010,\u0012\u0006\u0010-\u001a\u00020\u000b\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u00020\u000b\u0012\u0006\u00101\u001a\u00020\u000b\u0012\u0006\u00102\u001a\u00020\u000b¢\u0006\u0004\b3\u00104J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0007HÆ\u0003J\t\u0010Q\u001a\u00020\u0007HÆ\u0003J\t\u0010R\u001a\u00020\u000bHÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J\t\u0010T\u001a\u00020\u000bHÆ\u0003J\t\u0010U\u001a\u00020\u000bHÆ\u0003J\t\u0010V\u001a\u00020\u000bHÆ\u0003J\t\u0010W\u001a\u00020\u000bHÆ\u0003J\t\u0010X\u001a\u00020\u0012HÆ\u0003J\t\u0010Y\u001a\u00020\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u000bHÆ\u0003J\t\u0010[\u001a\u00020\u000bHÆ\u0003J\t\u0010\\\u001a\u00020\u000bHÆ\u0003J\u000f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0003J\t\u0010^\u001a\u00020\u001bHÆ\u0003J\t\u0010_\u001a\u00020\u000bHÆ\u0003J\t\u0010`\u001a\u00020\u001eHÆ\u0003J\t\u0010a\u001a\u00020\u000bHÆ\u0003J\t\u0010b\u001a\u00020\u000bHÆ\u0003J\t\u0010c\u001a\u00020\u000bHÆ\u0003J\t\u0010d\u001a\u00020\u000bHÆ\u0003J\u000f\u0010e\u001a\b\u0012\u0004\u0012\u00020$0\u0018HÆ\u0003J\t\u0010f\u001a\u00020\u000bHÆ\u0003J\t\u0010g\u001a\u00020\u000bHÆ\u0003J\t\u0010h\u001a\u00020\u000bHÆ\u0003J\t\u0010i\u001a\u00020\u000bHÆ\u0003J\t\u0010j\u001a\u00020\u000bHÆ\u0003J\t\u0010k\u001a\u00020\u0007HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010,HÆ\u0003J\t\u0010m\u001a\u00020\u000bHÆ\u0003J\t\u0010n\u001a\u00020/HÆ\u0003J\t\u0010o\u001a\u00020\u000bHÆ\u0003J\t\u0010p\u001a\u00020\u000bHÆ\u0003J\t\u0010q\u001a\u00020\u000bHÆ\u0003J\u008b\u0003\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00182\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0003\u0010*\u001a\u00020\u00072\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u00020\u000bHÆ\u0001J\u0006\u0010s\u001a\u00020\u0007J\u0014\u0010t\u001a\u00020\u000b2\b\u0010u\u001a\u0004\u0018\u00010vHÖ\u0083\u0004J\n\u0010w\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010x\u001a\u00020\u0005HÖ\u0081\u0004J\u0016\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\b\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0013\u0010\t\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010:R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010=R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010=R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010=R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010=R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010=R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010=R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010=R\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010=R\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010=R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010=R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010=R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u001f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010=R\u0011\u0010 \u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010=R\u0011\u0010!\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010=R\u0011\u0010\"\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010=R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0018¢\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u0011\u0010%\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010=R\u0011\u0010&\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010=R\u0011\u0010'\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010=R\u0011\u0010(\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010=R\u0011\u0010)\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010=R\u0011\u0010*\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u0010:R\u0013\u0010+\u001a\u0004\u0018\u00010,¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010-\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010=R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u00100\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010=R\u0011\u00101\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010=R\u0011\u00102\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010=¨\u0006\u0080\u0001"}, d2 = {"Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "Landroid/os/Parcelable;", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "activityTitle", "", "layout", "", "theme", "darkTheme", "isImmersiveModeEnabled", "", "isShowPageNumberOverlay", "isSignatureButtonPositionForcedInMainToolbar", "isShowPageLabels", "isShowDocumentTitleOverlayEnabled", "isShowNavigationButtonsEnabled", "thumbnailBarMode", "Lcom/pspdfkit/configuration/activity/ThumbnailBarMode;", "isThumbnailGridEnabled", "isDocumentEditorEnabled", "isSearchEnabled", "isSettingsItemEnabled", "settingsMenuItemShown", "Ljava/util/EnumSet;", "Lcom/pspdfkit/configuration/settings/SettingsMenuItemType;", "searchType", "Lcom/pspdfkit/configuration/search/SearchType;", "isPrintingEnabled", "userInterfaceViewMode", "Lcom/pspdfkit/configuration/activity/UserInterfaceViewMode;", "hideUserInterfaceWhenCreatingAnnotations", "isAnnotationListEnabled", "isDefaultToolbarEnabled", "isAnnotationListReorderingEnabled", "listedAnnotationTypes", "Lcom/pspdfkit/annotations/AnnotationType;", "isOutlineEnabled", "isEmbeddedFilesViewEnabled", "isBookmarkListEnabled", "isDocumentInfoViewEnabled", "isDocumentInfoViewSeparated", Location.TYPE_PAGE, "searchConfiguration", "Lcom/pspdfkit/configuration/search/SearchConfiguration;", "isAnnotationNoteHintingEnabled", "tabBarHidingMode", "Lcom/pspdfkit/configuration/activity/TabBarHidingMode;", "isVolumeButtonsNavigationEnabled", "isRedactionUiEnabled", "isReaderViewEnabled", "<init>", "(Lcom/pspdfkit/configuration/PdfConfiguration;Ljava/lang/String;IIIZZZZZZLcom/pspdfkit/configuration/activity/ThumbnailBarMode;ZZZZLjava/util/EnumSet;Lcom/pspdfkit/configuration/search/SearchType;ZLcom/pspdfkit/configuration/activity/UserInterfaceViewMode;ZZZZLjava/util/EnumSet;ZZZZZILcom/pspdfkit/configuration/search/SearchConfiguration;ZLcom/pspdfkit/configuration/activity/TabBarHidingMode;ZZZ)V", "getConfiguration", "()Lcom/pspdfkit/configuration/PdfConfiguration;", "getActivityTitle", "()Ljava/lang/String;", "getLayout", "()I", "getTheme", "getDarkTheme", "()Z", "getThumbnailBarMode", "()Lcom/pspdfkit/configuration/activity/ThumbnailBarMode;", "getSettingsMenuItemShown", "()Ljava/util/EnumSet;", "getSearchType", "()Lcom/pspdfkit/configuration/search/SearchType;", "getUserInterfaceViewMode", "()Lcom/pspdfkit/configuration/activity/UserInterfaceViewMode;", "getHideUserInterfaceWhenCreatingAnnotations", "getListedAnnotationTypes", "getPage", "getSearchConfiguration", "()Lcom/pspdfkit/configuration/search/SearchConfiguration;", "getTabBarHidingMode", "()Lcom/pspdfkit/configuration/activity/TabBarHidingMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "Builder", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PdfActivityConfiguration implements Parcelable {
    private static final EnumSet<AnnotationType> DEFAULT_LISTED_ANNOTATION_TYPES;
    public static final int NO_THEME = -1;
    private final String activityTitle;
    private final PdfConfiguration configuration;
    private final int darkTheme;
    private final boolean hideUserInterfaceWhenCreatingAnnotations;
    private final boolean isAnnotationListEnabled;
    private final boolean isAnnotationListReorderingEnabled;
    private final boolean isAnnotationNoteHintingEnabled;
    private final boolean isBookmarkListEnabled;
    private final boolean isDefaultToolbarEnabled;
    private final boolean isDocumentEditorEnabled;
    private final boolean isDocumentInfoViewEnabled;
    private final boolean isDocumentInfoViewSeparated;
    private final boolean isEmbeddedFilesViewEnabled;
    private final boolean isImmersiveModeEnabled;
    private final boolean isOutlineEnabled;
    private final boolean isPrintingEnabled;
    private final boolean isReaderViewEnabled;
    private final boolean isRedactionUiEnabled;
    private final boolean isSearchEnabled;
    private final boolean isSettingsItemEnabled;
    private final boolean isShowDocumentTitleOverlayEnabled;
    private final boolean isShowNavigationButtonsEnabled;
    private final boolean isShowPageLabels;
    private final boolean isShowPageNumberOverlay;
    private final boolean isSignatureButtonPositionForcedInMainToolbar;
    private final boolean isThumbnailGridEnabled;
    private final boolean isVolumeButtonsNavigationEnabled;
    private final int layout;
    private final EnumSet<AnnotationType> listedAnnotationTypes;
    private final int page;
    private final SearchConfiguration searchConfiguration;
    private final SearchType searchType;
    private final EnumSet<SettingsMenuItemType> settingsMenuItemShown;
    private final TabBarHidingMode tabBarHidingMode;
    private final int theme;
    private final ThumbnailBarMode thumbnailBarMode;
    private final UserInterfaceViewMode userInterfaceViewMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<PdfActivityConfiguration> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration$Companion;", "", "<init>", "()V", "NO_THEME", "", "DEFAULT_LISTED_ANNOTATION_TYPES", "Ljava/util/EnumSet;", "Lcom/pspdfkit/annotations/AnnotationType;", "getDEFAULT_LISTED_ANNOTATION_TYPES", "()Ljava/util/EnumSet;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnumSet<AnnotationType> getDEFAULT_LISTED_ANNOTATION_TYPES() {
            return PdfActivityConfiguration.DEFAULT_LISTED_ANNOTATION_TYPES;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PdfActivityConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PdfActivityConfiguration createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            parcel.getClass();
            PdfConfiguration pdfConfigurationCreateFromParcel = PdfConfiguration.CREATOR.createFromParcel(parcel);
            String string = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            boolean z9 = true;
            boolean z10 = false;
            boolean z11 = parcel.readInt() != 0;
            boolean z12 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z9 = false;
            }
            if (parcel.readInt() != 0) {
                z10 = z9;
            }
            boolean z13 = parcel.readInt() != 0 ? z9 : z10;
            if (parcel.readInt() == 0) {
                z9 = z10;
            }
            ThumbnailBarMode thumbnailBarModeValueOf = ThumbnailBarMode.valueOf(parcel.readString());
            boolean z14 = parcel.readInt() != 0 ? z9 : z10;
            if (parcel.readInt() == 0) {
                z9 = z10;
            }
            if (parcel.readInt() != 0) {
                z = false;
                z2 = true;
            } else {
                z = z10;
                z2 = z;
            }
            boolean z15 = parcel.readInt() != 0 ? z9 : z;
            EnumSet enumSet = (EnumSet) parcel.readSerializable();
            SearchType searchTypeValueOf = SearchType.valueOf(parcel.readString());
            boolean z16 = parcel.readInt() != 0 ? z9 : z;
            UserInterfaceViewMode userInterfaceViewModeValueOf = UserInterfaceViewMode.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                z3 = z;
                z4 = z9;
            } else {
                z3 = z;
                z4 = z3;
            }
            boolean z17 = parcel.readInt() != 0 ? z9 : z3;
            if (parcel.readInt() != 0) {
                z5 = z9;
                z6 = z5;
            } else {
                z5 = z9;
                z6 = z3;
            }
            if (parcel.readInt() != 0) {
                z3 = z5;
            }
            EnumSet enumSet2 = (EnumSet) parcel.readSerializable();
            if (parcel.readInt() == 0) {
                z5 = z3;
            }
            if (parcel.readInt() != 0) {
                z3 = z5;
            }
            boolean z18 = parcel.readInt() != 0 ? z5 : z3;
            if (parcel.readInt() == 0) {
                z5 = z3;
            }
            if (parcel.readInt() != 0) {
                z3 = z5;
            }
            int i4 = parcel.readInt();
            SearchConfiguration searchConfigurationCreateFromParcel = parcel.readInt() == 0 ? null : SearchConfiguration.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                z3 = z5;
            }
            TabBarHidingMode tabBarHidingModeValueOf = TabBarHidingMode.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                z7 = z5;
                z8 = z7;
            } else {
                z7 = z5;
                z8 = z3;
            }
            boolean z19 = parcel.readInt() != 0 ? z7 : z3;
            if (parcel.readInt() == 0) {
                z7 = z3;
            }
            return new PdfActivityConfiguration(pdfConfigurationCreateFromParcel, string, i, i2, i3, z11, z12, z9, z10, z13, z9, thumbnailBarModeValueOf, z14, z9, z2, z15, enumSet, searchTypeValueOf, z16, userInterfaceViewModeValueOf, z4, z17, z6, z3, enumSet2, z5, z3, z18, z5, z3, i4, searchConfigurationCreateFromParcel, z3, tabBarHidingModeValueOf, z8, z19, z7);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PdfActivityConfiguration[] newArray(int i) {
            return new PdfActivityConfiguration[i];
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<AnnotationType> entries$0 = EnumEntriesKt.enumEntries(AnnotationType.values());
    }

    static {
        EnumSet<AnnotationType> enumSetCopyOf = EnumSet.copyOf((Collection) EntriesMappings.entries$0);
        enumSetCopyOf.getClass();
        DEFAULT_LISTED_ANNOTATION_TYPES = enumSetCopyOf;
        enumSetCopyOf.remove(AnnotationType.LINK);
        enumSetCopyOf.remove(AnnotationType.CARET);
        enumSetCopyOf.remove(AnnotationType.RICHMEDIA);
        enumSetCopyOf.remove(AnnotationType.SCREEN);
        enumSetCopyOf.remove(AnnotationType.POPUP);
        enumSetCopyOf.remove(AnnotationType.WATERMARK);
        enumSetCopyOf.remove(AnnotationType.TRAPNET);
        enumSetCopyOf.remove(AnnotationType.TYPE3D);
    }

    public PdfActivityConfiguration(PdfConfiguration pdfConfiguration, String str, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ThumbnailBarMode thumbnailBarMode, boolean z7, boolean z8, boolean z9, boolean z10, EnumSet<SettingsMenuItemType> enumSet, SearchType searchType, boolean z11, UserInterfaceViewMode userInterfaceViewMode, boolean z12, boolean z13, boolean z14, boolean z15, EnumSet<AnnotationType> enumSet2, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, int i4, SearchConfiguration searchConfiguration, boolean z21, TabBarHidingMode tabBarHidingMode, boolean z22, boolean z23, boolean z24) {
        pdfConfiguration.getClass();
        thumbnailBarMode.getClass();
        enumSet.getClass();
        searchType.getClass();
        userInterfaceViewMode.getClass();
        enumSet2.getClass();
        tabBarHidingMode.getClass();
        this.configuration = pdfConfiguration;
        this.activityTitle = str;
        this.layout = i;
        this.theme = i2;
        this.darkTheme = i3;
        this.isImmersiveModeEnabled = z;
        this.isShowPageNumberOverlay = z2;
        this.isSignatureButtonPositionForcedInMainToolbar = z3;
        this.isShowPageLabels = z4;
        this.isShowDocumentTitleOverlayEnabled = z5;
        this.isShowNavigationButtonsEnabled = z6;
        this.thumbnailBarMode = thumbnailBarMode;
        this.isThumbnailGridEnabled = z7;
        this.isDocumentEditorEnabled = z8;
        this.isSearchEnabled = z9;
        this.isSettingsItemEnabled = z10;
        this.settingsMenuItemShown = enumSet;
        this.searchType = searchType;
        this.isPrintingEnabled = z11;
        this.userInterfaceViewMode = userInterfaceViewMode;
        this.hideUserInterfaceWhenCreatingAnnotations = z12;
        this.isAnnotationListEnabled = z13;
        this.isDefaultToolbarEnabled = z14;
        this.isAnnotationListReorderingEnabled = z15;
        this.listedAnnotationTypes = enumSet2;
        this.isOutlineEnabled = z16;
        this.isEmbeddedFilesViewEnabled = z17;
        this.isBookmarkListEnabled = z18;
        this.isDocumentInfoViewEnabled = z19;
        this.isDocumentInfoViewSeparated = z20;
        this.page = i4;
        this.searchConfiguration = searchConfiguration;
        this.isAnnotationNoteHintingEnabled = z21;
        this.tabBarHidingMode = tabBarHidingMode;
        this.isVolumeButtonsNavigationEnabled = z22;
        this.isRedactionUiEnabled = z23;
        this.isReaderViewEnabled = z24;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PdfActivityConfiguration copy$default(PdfActivityConfiguration pdfActivityConfiguration, PdfConfiguration pdfConfiguration, String str, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, ThumbnailBarMode thumbnailBarMode, boolean z7, boolean z8, boolean z9, boolean z10, EnumSet enumSet, SearchType searchType, boolean z11, UserInterfaceViewMode userInterfaceViewMode, boolean z12, boolean z13, boolean z14, boolean z15, EnumSet enumSet2, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, int i4, SearchConfiguration searchConfiguration, boolean z21, TabBarHidingMode tabBarHidingMode, boolean z22, boolean z23, boolean z24, int i5, int i6, Object obj) {
        boolean z25;
        boolean z26;
        PdfConfiguration pdfConfiguration2 = (i5 & 1) != 0 ? pdfActivityConfiguration.configuration : pdfConfiguration;
        String str2 = (i5 & 2) != 0 ? pdfActivityConfiguration.activityTitle : str;
        int i7 = (i5 & 4) != 0 ? pdfActivityConfiguration.layout : i;
        int i8 = (i5 & 8) != 0 ? pdfActivityConfiguration.theme : i2;
        int i9 = (i5 & 16) != 0 ? pdfActivityConfiguration.darkTheme : i3;
        boolean z27 = (i5 & 32) != 0 ? pdfActivityConfiguration.isImmersiveModeEnabled : z;
        boolean z28 = (i5 & 64) != 0 ? pdfActivityConfiguration.isShowPageNumberOverlay : z2;
        boolean z29 = (i5 & 128) != 0 ? pdfActivityConfiguration.isSignatureButtonPositionForcedInMainToolbar : z3;
        boolean z30 = (i5 & 256) != 0 ? pdfActivityConfiguration.isShowPageLabels : z4;
        boolean z31 = (i5 & 512) != 0 ? pdfActivityConfiguration.isShowDocumentTitleOverlayEnabled : z5;
        boolean z32 = (i5 & 1024) != 0 ? pdfActivityConfiguration.isShowNavigationButtonsEnabled : z6;
        ThumbnailBarMode thumbnailBarMode2 = (i5 & 2048) != 0 ? pdfActivityConfiguration.thumbnailBarMode : thumbnailBarMode;
        boolean z33 = (i5 & 4096) != 0 ? pdfActivityConfiguration.isThumbnailGridEnabled : z7;
        boolean z34 = (i5 & 8192) != 0 ? pdfActivityConfiguration.isDocumentEditorEnabled : z8;
        PdfConfiguration pdfConfiguration3 = pdfConfiguration2;
        boolean z35 = (i5 & 16384) != 0 ? pdfActivityConfiguration.isSearchEnabled : z9;
        boolean z36 = (i5 & 32768) != 0 ? pdfActivityConfiguration.isSettingsItemEnabled : z10;
        EnumSet enumSet3 = (i5 & 65536) != 0 ? pdfActivityConfiguration.settingsMenuItemShown : enumSet;
        SearchType searchType2 = (i5 & 131072) != 0 ? pdfActivityConfiguration.searchType : searchType;
        boolean z37 = (i5 & 262144) != 0 ? pdfActivityConfiguration.isPrintingEnabled : z11;
        UserInterfaceViewMode userInterfaceViewMode2 = (i5 & 524288) != 0 ? pdfActivityConfiguration.userInterfaceViewMode : userInterfaceViewMode;
        boolean z38 = (i5 & 1048576) != 0 ? pdfActivityConfiguration.hideUserInterfaceWhenCreatingAnnotations : z12;
        boolean z39 = (i5 & 2097152) != 0 ? pdfActivityConfiguration.isAnnotationListEnabled : z13;
        boolean z40 = (i5 & 4194304) != 0 ? pdfActivityConfiguration.isDefaultToolbarEnabled : z14;
        boolean z41 = (i5 & 8388608) != 0 ? pdfActivityConfiguration.isAnnotationListReorderingEnabled : z15;
        EnumSet enumSet4 = (i5 & 16777216) != 0 ? pdfActivityConfiguration.listedAnnotationTypes : enumSet2;
        boolean z42 = (i5 & 33554432) != 0 ? pdfActivityConfiguration.isOutlineEnabled : z16;
        boolean z43 = (i5 & 67108864) != 0 ? pdfActivityConfiguration.isEmbeddedFilesViewEnabled : z17;
        boolean z44 = (i5 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? pdfActivityConfiguration.isBookmarkListEnabled : z18;
        boolean z45 = (i5 & 268435456) != 0 ? pdfActivityConfiguration.isDocumentInfoViewEnabled : z19;
        boolean z46 = (i5 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? pdfActivityConfiguration.isDocumentInfoViewSeparated : z20;
        int i10 = (i5 & 1073741824) != 0 ? pdfActivityConfiguration.page : i4;
        SearchConfiguration searchConfiguration2 = (i5 & Integer.MIN_VALUE) != 0 ? pdfActivityConfiguration.searchConfiguration : searchConfiguration;
        boolean z47 = (i6 & 1) != 0 ? pdfActivityConfiguration.isAnnotationNoteHintingEnabled : z21;
        TabBarHidingMode tabBarHidingMode2 = (i6 & 2) != 0 ? pdfActivityConfiguration.tabBarHidingMode : tabBarHidingMode;
        boolean z48 = (i6 & 4) != 0 ? pdfActivityConfiguration.isVolumeButtonsNavigationEnabled : z22;
        boolean z49 = (i6 & 8) != 0 ? pdfActivityConfiguration.isRedactionUiEnabled : z23;
        if ((i6 & 16) != 0) {
            z26 = z49;
            z25 = pdfActivityConfiguration.isReaderViewEnabled;
        } else {
            z25 = z24;
            z26 = z49;
        }
        return pdfActivityConfiguration.copy(pdfConfiguration3, str2, i7, i8, i9, z27, z28, z29, z30, z31, z32, thumbnailBarMode2, z33, z34, z35, z36, enumSet3, searchType2, z37, userInterfaceViewMode2, z38, z39, z40, z41, enumSet4, z42, z43, z44, z45, z46, i10, searchConfiguration2, z47, tabBarHidingMode2, z48, z26, z25);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PdfConfiguration getConfiguration() {
        return this.configuration;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsShowDocumentTitleOverlayEnabled() {
        return this.isShowDocumentTitleOverlayEnabled;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsShowNavigationButtonsEnabled() {
        return this.isShowNavigationButtonsEnabled;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final ThumbnailBarMode getThumbnailBarMode() {
        return this.thumbnailBarMode;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsThumbnailGridEnabled() {
        return this.isThumbnailGridEnabled;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsDocumentEditorEnabled() {
        return this.isDocumentEditorEnabled;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getIsSearchEnabled() {
        return this.isSearchEnabled;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsSettingsItemEnabled() {
        return this.isSettingsItemEnabled;
    }

    public final EnumSet<SettingsMenuItemType> component17() {
        return this.settingsMenuItemShown;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final SearchType getSearchType() {
        return this.searchType;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getIsPrintingEnabled() {
        return this.isPrintingEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityTitle() {
        return this.activityTitle;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final UserInterfaceViewMode getUserInterfaceViewMode() {
        return this.userInterfaceViewMode;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final boolean getHideUserInterfaceWhenCreatingAnnotations() {
        return this.hideUserInterfaceWhenCreatingAnnotations;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getIsAnnotationListEnabled() {
        return this.isAnnotationListEnabled;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getIsDefaultToolbarEnabled() {
        return this.isDefaultToolbarEnabled;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getIsAnnotationListReorderingEnabled() {
        return this.isAnnotationListReorderingEnabled;
    }

    public final EnumSet<AnnotationType> component25() {
        return this.listedAnnotationTypes;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getIsOutlineEnabled() {
        return this.isOutlineEnabled;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getIsEmbeddedFilesViewEnabled() {
        return this.isEmbeddedFilesViewEnabled;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final boolean getIsBookmarkListEnabled() {
        return this.isBookmarkListEnabled;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final boolean getIsDocumentInfoViewEnabled() {
        return this.isDocumentInfoViewEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLayout() {
        return this.layout;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final boolean getIsDocumentInfoViewSeparated() {
        return this.isDocumentInfoViewSeparated;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final SearchConfiguration getSearchConfiguration() {
        return this.searchConfiguration;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final boolean getIsAnnotationNoteHintingEnabled() {
        return this.isAnnotationNoteHintingEnabled;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final TabBarHidingMode getTabBarHidingMode() {
        return this.tabBarHidingMode;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final boolean getIsVolumeButtonsNavigationEnabled() {
        return this.isVolumeButtonsNavigationEnabled;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final boolean getIsRedactionUiEnabled() {
        return this.isRedactionUiEnabled;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final boolean getIsReaderViewEnabled() {
        return this.isReaderViewEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTheme() {
        return this.theme;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDarkTheme() {
        return this.darkTheme;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsImmersiveModeEnabled() {
        return this.isImmersiveModeEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsShowPageNumberOverlay() {
        return this.isShowPageNumberOverlay;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsSignatureButtonPositionForcedInMainToolbar() {
        return this.isSignatureButtonPositionForcedInMainToolbar;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsShowPageLabels() {
        return this.isShowPageLabels;
    }

    public final PdfActivityConfiguration copy(PdfConfiguration configuration, String activityTitle, int layout, int theme, int darkTheme, boolean isImmersiveModeEnabled, boolean isShowPageNumberOverlay, boolean isSignatureButtonPositionForcedInMainToolbar, boolean isShowPageLabels, boolean isShowDocumentTitleOverlayEnabled, boolean isShowNavigationButtonsEnabled, ThumbnailBarMode thumbnailBarMode, boolean isThumbnailGridEnabled, boolean isDocumentEditorEnabled, boolean isSearchEnabled, boolean isSettingsItemEnabled, EnumSet<SettingsMenuItemType> settingsMenuItemShown, SearchType searchType, boolean isPrintingEnabled, UserInterfaceViewMode userInterfaceViewMode, boolean hideUserInterfaceWhenCreatingAnnotations, boolean isAnnotationListEnabled, boolean isDefaultToolbarEnabled, boolean isAnnotationListReorderingEnabled, EnumSet<AnnotationType> listedAnnotationTypes, boolean isOutlineEnabled, boolean isEmbeddedFilesViewEnabled, boolean isBookmarkListEnabled, boolean isDocumentInfoViewEnabled, boolean isDocumentInfoViewSeparated, int page, SearchConfiguration searchConfiguration, boolean isAnnotationNoteHintingEnabled, TabBarHidingMode tabBarHidingMode, boolean isVolumeButtonsNavigationEnabled, boolean isRedactionUiEnabled, boolean isReaderViewEnabled) {
        configuration.getClass();
        thumbnailBarMode.getClass();
        settingsMenuItemShown.getClass();
        searchType.getClass();
        userInterfaceViewMode.getClass();
        listedAnnotationTypes.getClass();
        tabBarHidingMode.getClass();
        return new PdfActivityConfiguration(configuration, activityTitle, layout, theme, darkTheme, isImmersiveModeEnabled, isShowPageNumberOverlay, isSignatureButtonPositionForcedInMainToolbar, isShowPageLabels, isShowDocumentTitleOverlayEnabled, isShowNavigationButtonsEnabled, thumbnailBarMode, isThumbnailGridEnabled, isDocumentEditorEnabled, isSearchEnabled, isSettingsItemEnabled, settingsMenuItemShown, searchType, isPrintingEnabled, userInterfaceViewMode, hideUserInterfaceWhenCreatingAnnotations, isAnnotationListEnabled, isDefaultToolbarEnabled, isAnnotationListReorderingEnabled, listedAnnotationTypes, isOutlineEnabled, isEmbeddedFilesViewEnabled, isBookmarkListEnabled, isDocumentInfoViewEnabled, isDocumentInfoViewSeparated, page, searchConfiguration, isAnnotationNoteHintingEnabled, tabBarHidingMode, isVolumeButtonsNavigationEnabled, isRedactionUiEnabled, isReaderViewEnabled);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PdfActivityConfiguration)) {
            return false;
        }
        PdfActivityConfiguration pdfActivityConfiguration = (PdfActivityConfiguration) other;
        return Intrinsics.areEqual(this.configuration, pdfActivityConfiguration.configuration) && Intrinsics.areEqual(this.activityTitle, pdfActivityConfiguration.activityTitle) && this.layout == pdfActivityConfiguration.layout && this.theme == pdfActivityConfiguration.theme && this.darkTheme == pdfActivityConfiguration.darkTheme && this.isImmersiveModeEnabled == pdfActivityConfiguration.isImmersiveModeEnabled && this.isShowPageNumberOverlay == pdfActivityConfiguration.isShowPageNumberOverlay && this.isSignatureButtonPositionForcedInMainToolbar == pdfActivityConfiguration.isSignatureButtonPositionForcedInMainToolbar && this.isShowPageLabels == pdfActivityConfiguration.isShowPageLabels && this.isShowDocumentTitleOverlayEnabled == pdfActivityConfiguration.isShowDocumentTitleOverlayEnabled && this.isShowNavigationButtonsEnabled == pdfActivityConfiguration.isShowNavigationButtonsEnabled && this.thumbnailBarMode == pdfActivityConfiguration.thumbnailBarMode && this.isThumbnailGridEnabled == pdfActivityConfiguration.isThumbnailGridEnabled && this.isDocumentEditorEnabled == pdfActivityConfiguration.isDocumentEditorEnabled && this.isSearchEnabled == pdfActivityConfiguration.isSearchEnabled && this.isSettingsItemEnabled == pdfActivityConfiguration.isSettingsItemEnabled && Intrinsics.areEqual(this.settingsMenuItemShown, pdfActivityConfiguration.settingsMenuItemShown) && this.searchType == pdfActivityConfiguration.searchType && this.isPrintingEnabled == pdfActivityConfiguration.isPrintingEnabled && this.userInterfaceViewMode == pdfActivityConfiguration.userInterfaceViewMode && this.hideUserInterfaceWhenCreatingAnnotations == pdfActivityConfiguration.hideUserInterfaceWhenCreatingAnnotations && this.isAnnotationListEnabled == pdfActivityConfiguration.isAnnotationListEnabled && this.isDefaultToolbarEnabled == pdfActivityConfiguration.isDefaultToolbarEnabled && this.isAnnotationListReorderingEnabled == pdfActivityConfiguration.isAnnotationListReorderingEnabled && Intrinsics.areEqual(this.listedAnnotationTypes, pdfActivityConfiguration.listedAnnotationTypes) && this.isOutlineEnabled == pdfActivityConfiguration.isOutlineEnabled && this.isEmbeddedFilesViewEnabled == pdfActivityConfiguration.isEmbeddedFilesViewEnabled && this.isBookmarkListEnabled == pdfActivityConfiguration.isBookmarkListEnabled && this.isDocumentInfoViewEnabled == pdfActivityConfiguration.isDocumentInfoViewEnabled && this.isDocumentInfoViewSeparated == pdfActivityConfiguration.isDocumentInfoViewSeparated && this.page == pdfActivityConfiguration.page && Intrinsics.areEqual(this.searchConfiguration, pdfActivityConfiguration.searchConfiguration) && this.isAnnotationNoteHintingEnabled == pdfActivityConfiguration.isAnnotationNoteHintingEnabled && this.tabBarHidingMode == pdfActivityConfiguration.tabBarHidingMode && this.isVolumeButtonsNavigationEnabled == pdfActivityConfiguration.isVolumeButtonsNavigationEnabled && this.isRedactionUiEnabled == pdfActivityConfiguration.isRedactionUiEnabled && this.isReaderViewEnabled == pdfActivityConfiguration.isReaderViewEnabled;
    }

    public final String getActivityTitle() {
        return this.activityTitle;
    }

    public final PdfConfiguration getConfiguration() {
        return this.configuration;
    }

    public final int getDarkTheme() {
        return this.darkTheme;
    }

    public final boolean getHideUserInterfaceWhenCreatingAnnotations() {
        return this.hideUserInterfaceWhenCreatingAnnotations;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final EnumSet<AnnotationType> getListedAnnotationTypes() {
        return this.listedAnnotationTypes;
    }

    public final int getPage() {
        return this.page;
    }

    public final SearchConfiguration getSearchConfiguration() {
        return this.searchConfiguration;
    }

    public final SearchType getSearchType() {
        return this.searchType;
    }

    public final EnumSet<SettingsMenuItemType> getSettingsMenuItemShown() {
        return this.settingsMenuItemShown;
    }

    public final TabBarHidingMode getTabBarHidingMode() {
        return this.tabBarHidingMode;
    }

    public final int getTheme() {
        return this.theme;
    }

    public final ThumbnailBarMode getThumbnailBarMode() {
        return this.thumbnailBarMode;
    }

    public final UserInterfaceViewMode getUserInterfaceViewMode() {
        return this.userInterfaceViewMode;
    }

    public int hashCode() {
        int iHashCode = this.configuration.hashCode() * 31;
        String str = this.activityTitle;
        int iA = nd.a(this.page, mv.a(this.isDocumentInfoViewSeparated, mv.a(this.isDocumentInfoViewEnabled, mv.a(this.isBookmarkListEnabled, mv.a(this.isEmbeddedFilesViewEnabled, mv.a(this.isOutlineEnabled, (this.listedAnnotationTypes.hashCode() + mv.a(this.isAnnotationListReorderingEnabled, mv.a(this.isDefaultToolbarEnabled, mv.a(this.isAnnotationListEnabled, mv.a(this.hideUserInterfaceWhenCreatingAnnotations, (this.userInterfaceViewMode.hashCode() + mv.a(this.isPrintingEnabled, (this.searchType.hashCode() + ((this.settingsMenuItemShown.hashCode() + mv.a(this.isSettingsItemEnabled, mv.a(this.isSearchEnabled, mv.a(this.isDocumentEditorEnabled, mv.a(this.isThumbnailGridEnabled, (this.thumbnailBarMode.hashCode() + mv.a(this.isShowNavigationButtonsEnabled, mv.a(this.isShowDocumentTitleOverlayEnabled, mv.a(this.isShowPageLabels, mv.a(this.isSignatureButtonPositionForcedInMainToolbar, mv.a(this.isShowPageNumberOverlay, mv.a(this.isImmersiveModeEnabled, nd.a(this.darkTheme, nd.a(this.theme, nd.a(this.layout, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31), 31), 31), 31)) * 31)) * 31, 31)) * 31, 31), 31), 31), 31)) * 31, 31), 31), 31), 31), 31), 31);
        SearchConfiguration searchConfiguration = this.searchConfiguration;
        return Boolean.hashCode(this.isReaderViewEnabled) + mv.a(this.isRedactionUiEnabled, mv.a(this.isVolumeButtonsNavigationEnabled, (this.tabBarHidingMode.hashCode() + mv.a(this.isAnnotationNoteHintingEnabled, (iA + (searchConfiguration != null ? searchConfiguration.hashCode() : 0)) * 31, 31)) * 31, 31), 31);
    }

    public final boolean isAnnotationListEnabled() {
        return this.isAnnotationListEnabled;
    }

    public final boolean isAnnotationListReorderingEnabled() {
        return this.isAnnotationListReorderingEnabled;
    }

    public final boolean isAnnotationNoteHintingEnabled() {
        return this.isAnnotationNoteHintingEnabled;
    }

    public final boolean isBookmarkListEnabled() {
        return this.isBookmarkListEnabled;
    }

    public final boolean isDefaultToolbarEnabled() {
        return this.isDefaultToolbarEnabled;
    }

    public final boolean isDocumentEditorEnabled() {
        return this.isDocumentEditorEnabled;
    }

    public final boolean isDocumentInfoViewEnabled() {
        return this.isDocumentInfoViewEnabled;
    }

    public final boolean isDocumentInfoViewSeparated() {
        return this.isDocumentInfoViewSeparated;
    }

    public final boolean isEmbeddedFilesViewEnabled() {
        return this.isEmbeddedFilesViewEnabled;
    }

    public final boolean isImmersiveModeEnabled() {
        return this.isImmersiveModeEnabled;
    }

    public final boolean isOutlineEnabled() {
        return this.isOutlineEnabled;
    }

    public final boolean isPrintingEnabled() {
        return this.isPrintingEnabled;
    }

    public final boolean isReaderViewEnabled() {
        return this.isReaderViewEnabled;
    }

    public final boolean isRedactionUiEnabled() {
        return this.isRedactionUiEnabled;
    }

    public final boolean isSearchEnabled() {
        return this.isSearchEnabled;
    }

    public final boolean isSettingsItemEnabled() {
        return this.isSettingsItemEnabled;
    }

    public final boolean isShowDocumentTitleOverlayEnabled() {
        return this.isShowDocumentTitleOverlayEnabled;
    }

    public final boolean isShowNavigationButtonsEnabled() {
        return this.isShowNavigationButtonsEnabled;
    }

    public final boolean isShowPageLabels() {
        return this.isShowPageLabels;
    }

    public final boolean isShowPageNumberOverlay() {
        return this.isShowPageNumberOverlay;
    }

    public final boolean isSignatureButtonPositionForcedInMainToolbar() {
        return this.isSignatureButtonPositionForcedInMainToolbar;
    }

    public final boolean isThumbnailGridEnabled() {
        return this.isThumbnailGridEnabled;
    }

    public final boolean isVolumeButtonsNavigationEnabled() {
        return this.isVolumeButtonsNavigationEnabled;
    }

    public String toString() {
        return "PdfActivityConfiguration(configuration=" + this.configuration + ", activityTitle=" + this.activityTitle + ", layout=" + this.layout + ", theme=" + this.theme + ", darkTheme=" + this.darkTheme + ", isImmersiveModeEnabled=" + this.isImmersiveModeEnabled + ", isShowPageNumberOverlay=" + this.isShowPageNumberOverlay + ", isSignatureButtonPositionForcedInMainToolbar=" + this.isSignatureButtonPositionForcedInMainToolbar + ", isShowPageLabels=" + this.isShowPageLabels + ", isShowDocumentTitleOverlayEnabled=" + this.isShowDocumentTitleOverlayEnabled + ", isShowNavigationButtonsEnabled=" + this.isShowNavigationButtonsEnabled + ", thumbnailBarMode=" + this.thumbnailBarMode + ", isThumbnailGridEnabled=" + this.isThumbnailGridEnabled + ", isDocumentEditorEnabled=" + this.isDocumentEditorEnabled + ", isSearchEnabled=" + this.isSearchEnabled + ", isSettingsItemEnabled=" + this.isSettingsItemEnabled + ", settingsMenuItemShown=" + this.settingsMenuItemShown + ", searchType=" + this.searchType + ", isPrintingEnabled=" + this.isPrintingEnabled + ", userInterfaceViewMode=" + this.userInterfaceViewMode + ", hideUserInterfaceWhenCreatingAnnotations=" + this.hideUserInterfaceWhenCreatingAnnotations + ", isAnnotationListEnabled=" + this.isAnnotationListEnabled + ", isDefaultToolbarEnabled=" + this.isDefaultToolbarEnabled + ", isAnnotationListReorderingEnabled=" + this.isAnnotationListReorderingEnabled + ", listedAnnotationTypes=" + this.listedAnnotationTypes + ", isOutlineEnabled=" + this.isOutlineEnabled + ", isEmbeddedFilesViewEnabled=" + this.isEmbeddedFilesViewEnabled + ", isBookmarkListEnabled=" + this.isBookmarkListEnabled + ", isDocumentInfoViewEnabled=" + this.isDocumentInfoViewEnabled + ", isDocumentInfoViewSeparated=" + this.isDocumentInfoViewSeparated + ", page=" + this.page + ", searchConfiguration=" + this.searchConfiguration + ", isAnnotationNoteHintingEnabled=" + this.isAnnotationNoteHintingEnabled + ", tabBarHidingMode=" + this.tabBarHidingMode + ", isVolumeButtonsNavigationEnabled=" + this.isVolumeButtonsNavigationEnabled + ", isRedactionUiEnabled=" + this.isRedactionUiEnabled + ", isReaderViewEnabled=" + this.isReaderViewEnabled + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        this.configuration.writeToParcel(dest, flags);
        dest.writeString(this.activityTitle);
        dest.writeInt(this.layout);
        dest.writeInt(this.theme);
        dest.writeInt(this.darkTheme);
        dest.writeInt(this.isImmersiveModeEnabled ? 1 : 0);
        dest.writeInt(this.isShowPageNumberOverlay ? 1 : 0);
        dest.writeInt(this.isSignatureButtonPositionForcedInMainToolbar ? 1 : 0);
        dest.writeInt(this.isShowPageLabels ? 1 : 0);
        dest.writeInt(this.isShowDocumentTitleOverlayEnabled ? 1 : 0);
        dest.writeInt(this.isShowNavigationButtonsEnabled ? 1 : 0);
        dest.writeString(this.thumbnailBarMode.name());
        dest.writeInt(this.isThumbnailGridEnabled ? 1 : 0);
        dest.writeInt(this.isDocumentEditorEnabled ? 1 : 0);
        dest.writeInt(this.isSearchEnabled ? 1 : 0);
        dest.writeInt(this.isSettingsItemEnabled ? 1 : 0);
        dest.writeSerializable(this.settingsMenuItemShown);
        dest.writeString(this.searchType.name());
        dest.writeInt(this.isPrintingEnabled ? 1 : 0);
        dest.writeString(this.userInterfaceViewMode.name());
        dest.writeInt(this.hideUserInterfaceWhenCreatingAnnotations ? 1 : 0);
        dest.writeInt(this.isAnnotationListEnabled ? 1 : 0);
        dest.writeInt(this.isDefaultToolbarEnabled ? 1 : 0);
        dest.writeInt(this.isAnnotationListReorderingEnabled ? 1 : 0);
        dest.writeSerializable(this.listedAnnotationTypes);
        dest.writeInt(this.isOutlineEnabled ? 1 : 0);
        dest.writeInt(this.isEmbeddedFilesViewEnabled ? 1 : 0);
        dest.writeInt(this.isBookmarkListEnabled ? 1 : 0);
        dest.writeInt(this.isDocumentInfoViewEnabled ? 1 : 0);
        dest.writeInt(this.isDocumentInfoViewSeparated ? 1 : 0);
        dest.writeInt(this.page);
        SearchConfiguration searchConfiguration = this.searchConfiguration;
        if (searchConfiguration == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            searchConfiguration.writeToParcel(dest, flags);
        }
        dest.writeInt(this.isAnnotationNoteHintingEnabled ? 1 : 0);
        dest.writeString(this.tabBarHidingMode.name());
        dest.writeInt(this.isVolumeButtonsNavigationEnabled ? 1 : 0);
        dest.writeInt(this.isRedactionUiEnabled ? 1 : 0);
        dest.writeInt(this.isReaderViewEnabled ? 1 : 0);
    }

    @Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0010J\u0010\u00109\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\nJ\u0010\u0010:\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0018J\u0010\u0010;\u001a\u00020\u00002\b\b\u0001\u0010<\u001a\u00020\u0018J\u0010\u0010=\u001a\u00020\u00002\b\b\u0001\u0010>\u001a\u00020\u0018J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020DJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\fJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010C\u001a\u00020FJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010C\u001a\u00020HJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\fJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\fJ\u000e\u0010K\u001a\u00020\u00002\u0006\u0010C\u001a\u00020LJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\fJ\u000e\u0010N\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\fJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\fJ\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\fJ\u000e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\fJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0018J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\fJ\u000e\u0010W\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\fJ\u000e\u0010X\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u0014\u0010Z\u001a\u00020\u00002\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u001aJ\u000e\u0010]\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\fJ\u000e\u0010^\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\fJ\u000e\u0010_\u001a\u00020\u00002\u0006\u0010@\u001a\u00020`J\u000e\u0010a\u001a\u00020\u00002\u0006\u0010a\u001a\u00020bJ\u000e\u0010c\u001a\u00020\u00002\u0006\u0010c\u001a\u00020dJ\u0016\u0010e\u001a\u00020\u00002\u000e\b\u0001\u0010e\u001a\b\u0012\u0004\u0012\u00020g0fJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010h\u001a\u00020iJ\u0010\u0010j\u001a\u00020\u00002\b\b\u0001\u0010j\u001a\u00020\u0018J\u0017\u0010k\u001a\u00020\u00002\n\b\u0001\u0010k\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010lJ\u000e\u0010m\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0018J\u000e\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010p\u001a\u00020\fJ\u000e\u0010q\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010r\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010s\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010t\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010u\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u0014\u0010v\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001aJ\u000e\u0010w\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u0014\u0010\u0019\u001a\u00020\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u0014\u0010x\u001a\u00020\u00002\f\u0010y\u001a\b\u0012\u0004\u0012\u00020z0\u001aJ\u000e\u0010{\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010|\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010}\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u000e\u0010~\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\fJ\u0014\u0010\u007f\u001a\u00020\u00002\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u001b0fJ\u0010\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020\fJ\u0017\u0010\u0081\u0001\u001a\u00020\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010fJ\u0010\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fJ\u0010\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fJ\u0010\u0010\u0086\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fJ\u0013\u0010\u0087\u0001\u001a\u00020\u00002\n\b\u0001\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\u0019\u0010\u008a\u0001\u001a\u00020\u00002\u0010\b\u0001\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010fJ\u0010\u0010\u008c\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020\fJ\u0010\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020\fJ\u000f\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u000f\u0010\u0090\u0001\u001a\u00020\u00002\u0006\u00106\u001a\u000207J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\fJ\u0011\u0010\u001d\u001a\u00020\u00002\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u0018J\u0011\u0010\u0092\u0001\u001a\u00020\u00002\b\u0010\u0092\u0001\u001a\u00030\u0089\u0001J\u0013\u0010\u0093\u0001\u001a\u00020\u00002\n\b\u0001\u0010\u0094\u0001\u001a\u00030\u0089\u0001J\u0010\u0010\u0095\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\fJ\u0010\u0010\u0096\u0001\u001a\u00020\u00002\u0007\u0010\u0097\u0001\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u0016\u0010\u0098\u0001\u001a\u00020\u00002\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0fJ\u0010\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u009a\u0001\u001a\u00020\fJ\u0007\u0010\u009b\u0001\u001a\u00020\u0000J\u0010\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\fJ\u0010\u0010\u009e\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020\fJ\u0010\u0010\u009f\u0001\u001a\u00020\u00002\u0007\u0010 \u0001\u001a\u000200J\u0010\u0010¡\u0001\u001a\u00020\u00002\u0007\u0010¢\u0001\u001a\u00020\fJ\u0012\u0010£\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fH\u0007J\u0010\u0010¤\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fJ\u0010\u0010¥\u0001\u001a\u00020\u00002\u0007\u0010¦\u0001\u001a\u00020\fJ\u0010\u0010§\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fJ\u0010\u0010¨\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fJ\u0012\u0010©\u0001\u001a\u00020\u00002\t\b\u0001\u0010ª\u0001\u001a\u00020\u0018J\u0010\u0010«\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\fJ\u0010\u0010¬\u0001\u001a\u00020\u00002\u0007\u0010\u00ad\u0001\u001a\u00020\fJ\u0011\u0010®\u0001\u001a\u00020\u00002\b\u0010¯\u0001\u001a\u00030°\u0001J\u0010\u0010±\u0001\u001a\u00020\u00002\u0007\u0010±\u0001\u001a\u00020\fJ\u000f\u0010²\u0001\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\fJ\u000f\u0010³\u0001\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\fJ\u0010\u0010´\u0001\u001a\u00020\u00002\u0007\u0010µ\u0001\u001a\u00020\fJ\u0010\u0010¶\u0001\u001a\u00020\u00002\u0007\u0010·\u0001\u001a\u00020\fJ\u0010\u0010¸\u0001\u001a\u00020\u00002\u0007\u0010¹\u0001\u001a\u00020\fJ\u0010\u0010º\u0001\u001a\u00020\u00002\u0007\u0010»\u0001\u001a\u00020\fJ\u0007\u0010¼\u0001\u001a\u00020\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006½\u0001"}, d2 = {"Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "configuration", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)V", "activityTitle", "", "annotationListEnabled", "", "annotationListReorderingEnabled", "annotationNoteHintsEnabled", "bookmarkListEnabled", "Lcom/pspdfkit/configuration/PdfConfiguration;", "defaultToolbarEnabled", "documentEditorEnabled", "documentInfoViewEnabled", "documentInfoViewSeparated", "hideUserInterfaceWhenCreatingAnnotations", "immersiveMode", "layoutRes", "", "listedAnnotationTypes", "Ljava/util/EnumSet;", "Lcom/pspdfkit/annotations/AnnotationType;", "outlineEnabled", Location.TYPE_PAGE, "printingEnabled", "readerViewEnabled", "redactionUiEnabled", "embeddedFilesViewEnabled", "searchConfiguration", "Lcom/pspdfkit/configuration/search/SearchConfiguration;", "searchEnabled", "searchType", "Lcom/pspdfkit/configuration/search/SearchType;", "settingsItemEnabled", "settingsMenuItemShown", "Lcom/pspdfkit/configuration/settings/SettingsMenuItemType;", "showDocumentTitleOverlay", "showNavigationButtons", "showPageLabels", "showPageNumberOverlay", "forceSignatureButtonPositionInMainToolbar", "tabBarMode", "Lcom/pspdfkit/configuration/activity/TabBarHidingMode;", "themeResId", "themeDarkResId", "thumbnailBarMode", "Lcom/pspdfkit/configuration/activity/ThumbnailBarMode;", "thumbnailGridEnabled", "userInterfaceViewMode", "Lcom/pspdfkit/configuration/activity/UserInterfaceViewMode;", "volumeButtonsNavigationEnabled", "title", "layout", "theme", "themeRes", "themeDark", "themeDarkRes", "scrollDirection", "orientation", "Lcom/pspdfkit/configuration/page/PageScrollDirection;", "scrollMode", DiagnosisParams.DIAGNOSIS_MODE, "Lcom/pspdfkit/configuration/page/PageScrollMode;", "layoutMode", "Lcom/pspdfkit/configuration/page/PageLayoutMode;", "themeMode", "Lcom/pspdfkit/configuration/theming/ThemeMode;", "firstPageAlwaysSingle", "showGapBetweenPages", "fitMode", "Lcom/pspdfkit/configuration/page/PageFitMode;", "scrollbarsEnabled", "invertColors", "automaticallyInvertColorsForNightTheme", "automaticallyInvertColors", "toGrayscale", "autosaveEnabled", "isAutosaveEnabled", "pagePadding", "pagePaddingDp", "restoreLastViewedPage", "automaticallyGenerateLinks", "copyPastEnabled", "enable", "setEnabledCopyPasteFeatures", "enabledFeatures", "Lcom/pspdfkit/configuration/annotations/CopyPasteFeatures;", "undoEnabled", "redoEnabled", "setSignaturePickerOrientation", "Lcom/pspdfkit/configuration/forms/SignaturePickerOrientation;", "signatureSavingStrategy", "Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "signatureColorOptions", "Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;", "signatureCreationModes", "", "Lcom/pspdfkit/configuration/signatures/SignatureCreationMode;", "annotationReplyFeatures", "Lcom/pspdfkit/configuration/annotations/AnnotationReplyFeatures;", "backgroundColor", "loadingProgressDrawable", "(Ljava/lang/Integer;)Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration$Builder;", "memoryCacheSize", "setDocumentInfoViewSeparated", "separated", "immersiveModeEnabled", "pageNumberOverlayEnabled", "pageLabelsEnabled", "documentTitleOverlayEnabled", "navigationButtonsEnabled", "settingsMenuEnabled", "setSettingsMenuItems", "setThumbnailBarMode", "setEnabledShareFeatures", "enabledShareFeatures", "Lcom/pspdfkit/configuration/sharing/ShareFeatures;", "formEditingEnabled", "annotationEditingEnabled", "annotationRotationEnabled", "contentEditingEnabled", "editableAnnotationTypes", "useCubicInterpolationForInkAnnotations", "enabledAnnotationTools", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationTool;", "setSelectedAnnotationResizeEnabled", "enabled", "selectedAnnotationResizeGuidesEnabled", "selectedFreetextAnnotationFontScalingOnResizeEnabled", "setResizeGuideSnapAllowance", "snapAllowance", "", "setResizeGuideLineIntervals", "intervals", "setAnnotationInspectorEnabled", "isEnabled", "setAnnotationNoteHintingEnabled", "setSearchType", "setUserInterfaceViewMode", "pageIndex", "startZoomScale", "maxZoomScale", "scale", "zoomOutBounce", "textSelectionEnabled", "isTextSelectionEnabled", "excludedAnnotationTypes", "setMeasurementToolsEnabled", "measurementToolsEnabled", "disableAnnotationLimitedToPageBounds", "setEnableNoteAnnotationNoZoomHandling", "noZoomHandlingEnabled", "setJavaScriptEnabled", "setTabBarHidingMode", "tabBarHidingMode", "setVolumeButtonsNavigationEnabled", "isVolumeButtonsNavigationEnabled", "textSelectionPopupToolbarEnabled", "annotationPopupToolbarEnabled", "allowMultipleBookmarksPerPage", "allowed", "scrollOnEdgeTapEnabled", "animateScrollOnEdgeTaps", "scrollOnEdgeTapMargin", "marginDp", "enableMagnifier", "showSignHereOverlay", "showOverlay", "setOutlineElementState", "outlineElementState", "Lcom/pspdfkit/document/OutlineElementState;", "showNoteEditorForNewNoteAnnotations", "enableReaderView", "setRedactionUiEnabled", "setMultithreadedRenderingEnabled", "isMultithreadedRenderingEnabled", "stylusOnDetectionEnabled", "enableStylusOnDetection", "setAiAssistantEnabled", "isAiAssistantEnabled", "setAnnotationsBlockLinks", "annotationsBlockLinks", "build", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private String activityTitle;
        private boolean annotationListEnabled;
        private boolean annotationListReorderingEnabled;
        private boolean annotationNoteHintsEnabled;
        private boolean bookmarkListEnabled;
        private PdfConfiguration configuration;
        private boolean defaultToolbarEnabled;
        private boolean documentEditorEnabled;
        private boolean documentInfoViewEnabled;
        private boolean documentInfoViewSeparated;
        private boolean embeddedFilesViewEnabled;
        private boolean forceSignatureButtonPositionInMainToolbar;
        private boolean hideUserInterfaceWhenCreatingAnnotations;
        private boolean immersiveMode;
        private int layoutRes;
        private EnumSet<AnnotationType> listedAnnotationTypes;
        private boolean outlineEnabled;
        private int page;
        private boolean printingEnabled;
        private boolean readerViewEnabled;
        private boolean redactionUiEnabled;
        private SearchConfiguration searchConfiguration;
        private boolean searchEnabled;
        private SearchType searchType;
        private boolean settingsItemEnabled;
        private EnumSet<SettingsMenuItemType> settingsMenuItemShown;
        private boolean showDocumentTitleOverlay;
        private boolean showNavigationButtons;
        private boolean showPageLabels;
        private boolean showPageNumberOverlay;
        private TabBarHidingMode tabBarMode;
        private int themeDarkResId;
        private int themeResId;
        private ThumbnailBarMode thumbnailBarMode;
        private boolean thumbnailGridEnabled;
        private UserInterfaceViewMode userInterfaceViewMode;
        private boolean volumeButtonsNavigationEnabled;

        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class EntriesMappings {
            public static final /* synthetic */ EnumEntries<SettingsMenuItemType> entries$0 = EnumEntriesKt.enumEntries(SettingsMenuItemType.values());
        }

        public Builder(Context context) {
            context.getClass();
            this.annotationListEnabled = true;
            this.annotationListReorderingEnabled = true;
            this.annotationNoteHintsEnabled = true;
            this.bookmarkListEnabled = true;
            this.configuration = new PdfConfiguration.Builder().build();
            this.defaultToolbarEnabled = true;
            this.documentEditorEnabled = true;
            this.documentInfoViewEnabled = true;
            this.documentInfoViewSeparated = true;
            this.hideUserInterfaceWhenCreatingAnnotations = true;
            this.immersiveMode = true;
            this.layoutRes = R.layout.pspdf__pdf_activity;
            this.listedAnnotationTypes = PdfActivityConfiguration.INSTANCE.getDEFAULT_LISTED_ANNOTATION_TYPES();
            this.outlineEnabled = true;
            this.printingEnabled = true;
            this.redactionUiEnabled = true;
            this.embeddedFilesViewEnabled = true;
            this.searchEnabled = true;
            this.settingsItemEnabled = true;
            EnumSet<SettingsMenuItemType> enumSetCopyOf = EnumSet.copyOf((Collection) EntriesMappings.entries$0);
            enumSetCopyOf.getClass();
            this.settingsMenuItemShown = enumSetCopyOf;
            this.showDocumentTitleOverlay = true;
            this.showNavigationButtons = true;
            this.showPageLabels = true;
            this.showPageNumberOverlay = true;
            this.tabBarMode = TabBarHidingMode.AUTOMATIC_HIDE_SINGLE;
            this.themeResId = -1;
            this.themeDarkResId = -1;
            this.thumbnailBarMode = ThumbnailBarMode.THUMBNAIL_BAR_MODE_FLOATING;
            this.thumbnailGridEnabled = true;
            this.userInterfaceViewMode = UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_AUTOMATIC;
            this.searchType = uc.a(context, 540) ? SearchType.MODULAR : SearchType.INLINE;
        }

        public final Builder allowMultipleBookmarksPerPage(boolean allowed) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, allowed, false, false, 0, false, false, false, false, null, false, false, false, -1, -16777217, 15, null);
            return this;
        }

        public final Builder animateScrollOnEdgeTaps(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, enabled, 0, false, false, false, false, null, false, false, false, -1, -67108865, 15, null);
            return this;
        }

        public final Builder annotationEditingEnabled(boolean enable) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, enable, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -2097153, -1, 15, null);
            return this;
        }

        public final Builder annotationListEnabled(boolean enable) {
            this.annotationListEnabled = enable;
            return this;
        }

        public final Builder annotationListReorderingEnabled(boolean enable) {
            this.annotationListReorderingEnabled = enable;
            return this;
        }

        public final Builder annotationPopupToolbarEnabled(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, enabled, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -4194305, 15, null);
            return this;
        }

        public final Builder annotationReplyFeatures(AnnotationReplyFeatures annotationReplyFeatures) {
            annotationReplyFeatures.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, annotationReplyFeatures, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -4097, 15, null);
            return this;
        }

        public final Builder annotationRotationEnabled(boolean enable) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, enable, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -4194305, -1, 15, null);
            return this;
        }

        public final Builder automaticallyGenerateLinks(boolean automaticallyGenerateLinks) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, automaticallyGenerateLinks, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -129, 15, null);
            return this;
        }

        public final Builder automaticallyInvertColorsForNightTheme(boolean automaticallyInvertColors) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, automaticallyInvertColors, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -4097, -1, 15, null);
            return this;
        }

        public final Builder autosaveEnabled(boolean isAutosaveEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, isAutosaveEnabled, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -17, 15, null);
            return this;
        }

        public final Builder backgroundColor(int backgroundColor) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, backgroundColor, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -257, -1, 15, null);
            return this;
        }

        public final Builder bookmarkListEnabled(boolean enable) {
            this.bookmarkListEnabled = enable;
            return this;
        }

        public final PdfActivityConfiguration build() {
            return new PdfActivityConfiguration(this.configuration, this.activityTitle, this.layoutRes, this.themeResId, this.themeDarkResId, this.immersiveMode, this.showPageNumberOverlay, this.forceSignatureButtonPositionInMainToolbar, this.showPageLabels, this.showDocumentTitleOverlay, this.showNavigationButtons, this.thumbnailBarMode, this.thumbnailGridEnabled, this.documentEditorEnabled, this.searchEnabled, this.settingsItemEnabled, this.settingsMenuItemShown, this.searchType, this.printingEnabled, this.userInterfaceViewMode, this.hideUserInterfaceWhenCreatingAnnotations, this.annotationListEnabled, this.defaultToolbarEnabled, this.annotationListReorderingEnabled, this.listedAnnotationTypes, this.outlineEnabled, this.embeddedFilesViewEnabled, this.bookmarkListEnabled, this.documentInfoViewEnabled, this.documentInfoViewSeparated, this.page, this.searchConfiguration, this.annotationNoteHintsEnabled, this.tabBarMode, this.volumeButtonsNavigationEnabled, this.redactionUiEnabled, this.readerViewEnabled);
        }

        public final Builder configuration(PdfConfiguration configuration) {
            configuration.getClass();
            this.configuration = configuration;
            return this;
        }

        public final Builder contentEditingEnabled(boolean enable) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, enable, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -8388609, -1, 15, null);
            return this;
        }

        public final Builder copyPastEnabled(boolean enable) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, enable, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -257, 15, null);
            return this;
        }

        public final Builder defaultToolbarEnabled(boolean enable) {
            this.defaultToolbarEnabled = enable;
            return this;
        }

        public final Builder disableAnnotationLimitedToPageBounds() {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -33554433, -1, 15, null);
            return this;
        }

        public final Builder documentEditorEnabled(boolean enable) {
            this.documentEditorEnabled = enable;
            return this;
        }

        public final Builder documentInfoViewEnabled(boolean enable) {
            this.documentInfoViewEnabled = enable;
            return this;
        }

        public final Builder documentTitleOverlayEnabled(boolean enable) {
            this.showDocumentTitleOverlay = enable;
            return this;
        }

        public final Builder editableAnnotationTypes(List<? extends AnnotationType> editableAnnotationTypes) {
            editableAnnotationTypes.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, editableAnnotationTypes, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -134217729, -1, 15, null);
            return this;
        }

        public final Builder embeddedFilesViewEnabled(boolean enable) {
            this.embeddedFilesViewEnabled = enable;
            return this;
        }

        public final Builder enableMagnifier(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, enabled, false, false, false, null, false, false, false, -1, -268435457, 15, null);
            return this;
        }

        public final Builder enableReaderView(boolean readerViewEnabled) {
            if (readerViewEnabled && !ar.b().a(NativeLicenseFeatures.READER_VIEW)) {
                throw new InvalidNutrientLicenseException("Your current license doesn't allow using the reader view.");
            }
            this.readerViewEnabled = readerViewEnabled;
            return this;
        }

        public final Builder enabledAnnotationTools(List<? extends AnnotationTool> enabledAnnotationTools) {
            enabledAnnotationTools.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, enabledAnnotationTools, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -268435457, -1, 15, null);
            return this;
        }

        public final Builder excludedAnnotationTypes(List<? extends AnnotationType> excludedAnnotationTypes) {
            excludedAnnotationTypes.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, excludedAnnotationTypes, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -9, 15, null);
            return this;
        }

        public final Builder firstPageAlwaysSingle(boolean firstPageAlwaysSingle) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, firstPageAlwaysSingle, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -33, -1, 15, null);
            return this;
        }

        public final Builder fitMode(PageFitMode mode) {
            mode.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, mode, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -5, -1, 15, null);
            return this;
        }

        public final Builder forceSignatureButtonPositionInMainToolbar(boolean forceSignatureButtonPositionInMainToolbar) {
            if (forceSignatureButtonPositionInMainToolbar) {
                ar.b().getClass();
                if (!tg.b()) {
                    throw new InvalidNutrientLicenseException("Creating signature annotations requires Electronic Signatures.");
                }
            }
            this.forceSignatureButtonPositionInMainToolbar = forceSignatureButtonPositionInMainToolbar;
            return this;
        }

        public final Builder formEditingEnabled(boolean enable) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, enable, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -262145, -1, 15, null);
            return this;
        }

        public final Builder hideUserInterfaceWhenCreatingAnnotations(boolean hideUserInterfaceWhenCreatingAnnotations) {
            this.hideUserInterfaceWhenCreatingAnnotations = hideUserInterfaceWhenCreatingAnnotations;
            return this;
        }

        public final Builder immersiveModeEnabled(boolean immersiveModeEnabled) {
            this.immersiveMode = immersiveModeEnabled;
            return this;
        }

        public final Builder invertColors(boolean invertColors) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, invertColors, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -2049, -1, 15, null);
            return this;
        }

        public final Builder layout(int layoutRes) {
            this.layoutRes = layoutRes;
            return this;
        }

        public final Builder layoutMode(PageLayoutMode mode) {
            mode.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, mode, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -9, -1, 15, null);
            return this;
        }

        public final Builder listedAnnotationTypes(EnumSet<AnnotationType> listedAnnotationTypes) {
            listedAnnotationTypes.getClass();
            this.listedAnnotationTypes = listedAnnotationTypes;
            return this;
        }

        public final Builder loadingProgressDrawable(Integer loadingProgressDrawable) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, loadingProgressDrawable, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -513, -1, 15, null);
            return this;
        }

        public final Builder maxZoomScale(float scale) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, scale, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -32769, -1, 15, null);
            return this;
        }

        public final Builder memoryCacheSize(int memoryCacheSize) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, memoryCacheSize, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1025, -1, 15, null);
            return this;
        }

        public final Builder navigationButtonsEnabled(boolean enable) {
            this.showNavigationButtons = enable;
            return this;
        }

        public final Builder outlineEnabled(boolean enable) {
            this.outlineEnabled = enable;
            return this;
        }

        public final Builder page(int pageIndex) {
            this.page = pageIndex;
            return this;
        }

        public final Builder pageLabelsEnabled(boolean enable) {
            this.showPageLabels = enable;
            return this;
        }

        public final Builder pageNumberOverlayEnabled(boolean enable) {
            this.showPageNumberOverlay = enable;
            return this;
        }

        public final Builder pagePadding(int pagePaddingDp) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, pagePaddingDp, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -33, 15, null);
            return this;
        }

        public final Builder printingEnabled(boolean enable) {
            this.printingEnabled = enable;
            return this;
        }

        public final Builder redoEnabled(boolean redoEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, redoEnabled, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -2049, 15, null);
            return this;
        }

        public final Builder restoreLastViewedPage(boolean restoreLastViewedPage) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, restoreLastViewedPage, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -65, 15, null);
            return this;
        }

        public final Builder scrollDirection(PageScrollDirection orientation) {
            orientation.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, orientation, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -2, -1, 15, null);
            return this;
        }

        public final Builder scrollMode(PageScrollMode mode) {
            mode.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, mode, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -3, -1, 15, null);
            return this;
        }

        public final Builder scrollOnEdgeTapEnabled(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, enabled, false, 0, false, false, false, false, null, false, false, false, -1, -33554433, 15, null);
            return this;
        }

        public final Builder scrollOnEdgeTapMargin(int marginDp) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, marginDp, false, false, false, false, null, false, false, false, -1, -134217729, 15, null);
            return this;
        }

        public final Builder scrollbarsEnabled(boolean scrollbarsEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, scrollbarsEnabled, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -129, -1, 15, null);
            return this;
        }

        public final Builder searchConfiguration(SearchConfiguration searchConfiguration) {
            searchConfiguration.getClass();
            this.searchConfiguration = searchConfiguration;
            return this;
        }

        public final Builder searchEnabled(boolean enable) {
            this.searchEnabled = enable;
            return this;
        }

        public final Builder selectedAnnotationResizeGuidesEnabled(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, enabled, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1073741825, -1, 15, null);
            return this;
        }

        public final Builder selectedFreetextAnnotationFontScalingOnResizeEnabled(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, enabled, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, Integer.MAX_VALUE, -1, 15, null);
            return this;
        }

        public final Builder setAiAssistantEnabled(boolean isAiAssistantEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, isAiAssistantEnabled, false, -1, -1, 11, null);
            return this;
        }

        public final Builder setAnnotationInspectorEnabled(boolean isEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, isEnabled, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -5, 15, null);
            return this;
        }

        public final Builder setAnnotationNoteHintingEnabled(boolean isEnabled) {
            this.annotationNoteHintsEnabled = isEnabled;
            return this;
        }

        public final Builder setAnnotationsBlockLinks(boolean annotationsBlockLinks) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, annotationsBlockLinks, -1, -1, 7, null);
            return this;
        }

        public final Builder setDocumentInfoViewSeparated(boolean separated) {
            this.documentInfoViewSeparated = separated;
            return this;
        }

        public final Builder setEnableNoteAnnotationNoZoomHandling(boolean noZoomHandlingEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, noZoomHandlingEnabled, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -524289, 15, null);
            return this;
        }

        public final Builder setEnabledCopyPasteFeatures(EnumSet<CopyPasteFeatures> enabledFeatures) {
            enabledFeatures.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, enabledFeatures, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -513, 15, null);
            return this;
        }

        public final Builder setEnabledShareFeatures(EnumSet<ShareFeatures> enabledShareFeatures) {
            enabledShareFeatures.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, enabledShareFeatures, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -8388609, 15, null);
            return this;
        }

        public final Builder setJavaScriptEnabled(boolean isEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, isEnabled, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -1048577, 15, null);
            return this;
        }

        public final Builder setMeasurementToolsEnabled(boolean measurementToolsEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, measurementToolsEnabled, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -16777217, -1, 15, null);
            return this;
        }

        public final Builder setMultithreadedRenderingEnabled(boolean isMultithreadedRenderingEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, isMultithreadedRenderingEnabled, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -16385, 15, null);
            return this;
        }

        public final Builder setOutlineElementState(OutlineElementState outlineElementState) {
            outlineElementState.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, outlineElementState, false, false, false, -1, -1, 14, null);
            return this;
        }

        public final Builder setRedactionUiEnabled(boolean redactionUiEnabled) {
            this.redactionUiEnabled = redactionUiEnabled;
            return this;
        }

        public final Builder setResizeGuideLineIntervals(List<Float> intervals) {
            intervals.getClass();
            if (intervals.size() < 2 || intervals.size() % 2 != 0) {
                throw new IllegalArgumentException(("intervals must contain at least 2 elements and an even number. Found: " + intervals.size()).toString());
            }
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, intervals, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -3, 15, null);
            return this;
        }

        public final Builder setResizeGuideSnapAllowance(float snapAllowance) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, snapAllowance, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -2, 15, null);
            return this;
        }

        public final Builder setSearchType(SearchType searchType) {
            searchType.getClass();
            this.searchType = searchType;
            return this;
        }

        public final Builder setSelectedAnnotationResizeEnabled(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, enabled, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -536870913, -1, 15, null);
            return this;
        }

        public final Builder setSettingsMenuItems(EnumSet<SettingsMenuItemType> settingsMenuItemShown) {
            settingsMenuItemShown.getClass();
            this.settingsMenuItemShown = settingsMenuItemShown;
            settingsMenuEnabled(!settingsMenuItemShown.isEmpty());
            return this;
        }

        public final Builder setSignaturePickerOrientation(SignaturePickerOrientation orientation) {
            orientation.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, orientation, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -32769, 15, null);
            return this;
        }

        public final Builder setTabBarHidingMode(TabBarHidingMode tabBarHidingMode) {
            tabBarHidingMode.getClass();
            this.tabBarMode = tabBarHidingMode;
            return this;
        }

        public final Builder setThumbnailBarMode(ThumbnailBarMode thumbnailBarMode) {
            thumbnailBarMode.getClass();
            this.thumbnailBarMode = thumbnailBarMode;
            return this;
        }

        public final Builder setUserInterfaceViewMode(UserInterfaceViewMode userInterfaceViewMode) {
            userInterfaceViewMode.getClass();
            this.userInterfaceViewMode = userInterfaceViewMode;
            return this;
        }

        public final Builder setVolumeButtonsNavigationEnabled(boolean isVolumeButtonsNavigationEnabled) {
            this.volumeButtonsNavigationEnabled = isVolumeButtonsNavigationEnabled;
            return this;
        }

        public final Builder settingsMenuEnabled(boolean enable) {
            if (enable && this.settingsMenuItemShown.isEmpty()) {
                return this;
            }
            this.settingsItemEnabled = enable;
            return this;
        }

        public final Builder showGapBetweenPages(boolean showGapBetweenPages) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, showGapBetweenPages, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -65, -1, 15, null);
            return this;
        }

        public final Builder showNoteEditorForNewNoteAnnotations(boolean showNoteEditorForNewNoteAnnotations) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, showNoteEditorForNewNoteAnnotations, false, null, false, false, false, -1, -1073741825, 15, null);
            return this;
        }

        public final Builder showSignHereOverlay(boolean showOverlay) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, showOverlay, false, false, null, false, false, false, -1, -536870913, 15, null);
            return this;
        }

        public final Builder signatureColorOptions(SignatureColorOptions signatureColorOptions) {
            signatureColorOptions.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, signatureColorOptions, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -131073, 15, null);
            return this;
        }

        public final Builder signatureCreationModes(List<? extends SignatureCreationMode> signatureCreationModes) {
            signatureCreationModes.getClass();
            PdfConfiguration.INSTANCE.validateSignatureCreationModes$sdk_nutrient(signatureCreationModes);
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, signatureCreationModes, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -262145, 15, null);
            return this;
        }

        public final Builder signatureSavingStrategy(SignatureSavingStrategy signatureSavingStrategy) {
            signatureSavingStrategy.getClass();
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, signatureSavingStrategy, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -65537, 15, null);
            return this;
        }

        public final Builder startZoomScale(float startZoomScale) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, startZoomScale, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -16385, -1, 15, null);
            return this;
        }

        public final Builder stylusOnDetectionEnabled(boolean enableStylusOnDetection) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, enableStylusOnDetection, null, false, false, false, -1, Integer.MAX_VALUE, 15, null);
            return this;
        }

        public final Builder textSelectionEnabled(boolean isTextSelectionEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, isTextSelectionEnabled, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -131073, -1, 15, null);
            return this;
        }

        @Deprecated(message = "The legacy text selection toolbar is deprecated. The popup toolbar will be the only option in a future version.")
        public final Builder textSelectionPopupToolbarEnabled(boolean enabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, enabled, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -2097153, 15, null);
            return this;
        }

        public final Builder theme(int themeRes) {
            this.themeResId = themeRes;
            return this;
        }

        public final Builder themeDark(int themeDarkRes) {
            this.themeDarkResId = themeDarkRes;
            return this;
        }

        public final Builder themeMode(ThemeMode mode) {
            ThemeMode themeMode;
            boolean zIsInvertColors;
            mode.getClass();
            PdfConfiguration pdfConfiguration = this.configuration;
            if (pdfConfiguration.getAutomaticallyInvertColorsForNightTheme()) {
                themeMode = mode;
                zIsInvertColors = themeMode == ThemeMode.NIGHT;
            } else {
                themeMode = mode;
                zIsInvertColors = this.configuration.isInvertColors();
            }
            this.configuration = PdfConfiguration.copy$default(pdfConfiguration, null, null, null, null, themeMode, false, false, false, 0, null, 0, zIsInvertColors, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -2065, -1, 15, null);
            return this;
        }

        public final Builder thumbnailGridEnabled(boolean enable) {
            this.thumbnailGridEnabled = enable;
            return this;
        }

        public final Builder title(String title) {
            this.activityTitle = title;
            return this;
        }

        public final Builder toGrayscale(boolean toGrayscale) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, toGrayscale, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -8193, -1, 15, null);
            return this;
        }

        public final Builder undoEnabled(boolean undoEnabled) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, undoEnabled, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -1, -1025, 15, null);
            return this;
        }

        public final Builder useCubicInterpolationForInkAnnotations(boolean useCubicInterpolationForInkAnnotations) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, false, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, useCubicInterpolationForInkAnnotations, false, false, -1, -1, 13, null);
            return this;
        }

        public final Builder zoomOutBounce(boolean zoomOutBounce) {
            this.configuration = PdfConfiguration.copy$default(this.configuration, null, null, null, null, null, false, false, false, 0, null, 0, false, false, false, 0.0f, 0.0f, zoomOutBounce, false, false, false, false, false, false, false, false, false, false, null, null, false, false, false, 0.0f, null, false, null, false, 0, false, false, false, null, false, false, null, null, false, null, null, null, null, false, false, false, false, null, false, false, false, 0, false, false, false, false, null, false, false, false, -65537, -1, 15, null);
            return this;
        }

        public Builder(PdfActivityConfiguration pdfActivityConfiguration) {
            pdfActivityConfiguration.getClass();
            this.annotationListEnabled = true;
            this.annotationListReorderingEnabled = true;
            this.annotationNoteHintsEnabled = true;
            this.bookmarkListEnabled = true;
            this.configuration = new PdfConfiguration.Builder().build();
            this.defaultToolbarEnabled = true;
            this.documentEditorEnabled = true;
            this.documentInfoViewEnabled = true;
            this.documentInfoViewSeparated = true;
            this.hideUserInterfaceWhenCreatingAnnotations = true;
            this.immersiveMode = true;
            this.layoutRes = R.layout.pspdf__pdf_activity;
            this.listedAnnotationTypes = PdfActivityConfiguration.INSTANCE.getDEFAULT_LISTED_ANNOTATION_TYPES();
            this.outlineEnabled = true;
            this.printingEnabled = true;
            this.redactionUiEnabled = true;
            this.embeddedFilesViewEnabled = true;
            this.searchEnabled = true;
            this.settingsItemEnabled = true;
            EnumSet<SettingsMenuItemType> enumSetCopyOf = EnumSet.copyOf((Collection) EntriesMappings.entries$0);
            enumSetCopyOf.getClass();
            this.settingsMenuItemShown = enumSetCopyOf;
            this.showDocumentTitleOverlay = true;
            this.showNavigationButtons = true;
            this.showPageLabels = true;
            this.showPageNumberOverlay = true;
            this.tabBarMode = TabBarHidingMode.AUTOMATIC_HIDE_SINGLE;
            this.themeResId = -1;
            this.themeDarkResId = -1;
            this.thumbnailBarMode = ThumbnailBarMode.THUMBNAIL_BAR_MODE_FLOATING;
            this.thumbnailGridEnabled = true;
            this.userInterfaceViewMode = UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_AUTOMATIC;
            this.activityTitle = pdfActivityConfiguration.getActivityTitle();
            this.annotationListEnabled = pdfActivityConfiguration.isAnnotationListEnabled();
            this.annotationListReorderingEnabled = pdfActivityConfiguration.isAnnotationListReorderingEnabled();
            this.annotationNoteHintsEnabled = pdfActivityConfiguration.isAnnotationNoteHintingEnabled();
            this.bookmarkListEnabled = pdfActivityConfiguration.isBookmarkListEnabled();
            this.configuration = pdfActivityConfiguration.getConfiguration();
            this.defaultToolbarEnabled = pdfActivityConfiguration.isDefaultToolbarEnabled();
            this.documentEditorEnabled = pdfActivityConfiguration.isDocumentEditorEnabled();
            this.documentInfoViewEnabled = pdfActivityConfiguration.isDocumentInfoViewEnabled();
            this.documentInfoViewSeparated = pdfActivityConfiguration.isDocumentInfoViewSeparated();
            this.hideUserInterfaceWhenCreatingAnnotations = pdfActivityConfiguration.getHideUserInterfaceWhenCreatingAnnotations();
            this.immersiveMode = pdfActivityConfiguration.isImmersiveModeEnabled();
            this.layoutRes = pdfActivityConfiguration.getLayout();
            this.listedAnnotationTypes = pdfActivityConfiguration.getListedAnnotationTypes();
            this.outlineEnabled = pdfActivityConfiguration.isOutlineEnabled();
            this.page = pdfActivityConfiguration.getPage();
            this.printingEnabled = pdfActivityConfiguration.isPrintingEnabled();
            this.readerViewEnabled = pdfActivityConfiguration.isReaderViewEnabled();
            this.redactionUiEnabled = pdfActivityConfiguration.isRedactionUiEnabled();
            this.searchConfiguration = pdfActivityConfiguration.getSearchConfiguration();
            this.searchEnabled = pdfActivityConfiguration.isSearchEnabled();
            this.searchType = pdfActivityConfiguration.getSearchType();
            this.settingsItemEnabled = pdfActivityConfiguration.isSettingsItemEnabled();
            this.settingsMenuItemShown = pdfActivityConfiguration.getSettingsMenuItemShown();
            this.showDocumentTitleOverlay = pdfActivityConfiguration.isShowDocumentTitleOverlayEnabled();
            this.showNavigationButtons = pdfActivityConfiguration.isShowNavigationButtonsEnabled();
            this.showPageLabels = pdfActivityConfiguration.isShowPageLabels();
            this.showPageNumberOverlay = pdfActivityConfiguration.isShowPageNumberOverlay();
            this.forceSignatureButtonPositionInMainToolbar = pdfActivityConfiguration.isSignatureButtonPositionForcedInMainToolbar();
            this.tabBarMode = pdfActivityConfiguration.getTabBarHidingMode();
            this.themeResId = pdfActivityConfiguration.getTheme();
            this.themeDarkResId = pdfActivityConfiguration.getDarkTheme();
            this.thumbnailBarMode = pdfActivityConfiguration.getThumbnailBarMode();
            this.thumbnailGridEnabled = pdfActivityConfiguration.isThumbnailGridEnabled();
            this.userInterfaceViewMode = pdfActivityConfiguration.getUserInterfaceViewMode();
            this.volumeButtonsNavigationEnabled = pdfActivityConfiguration.isVolumeButtonsNavigationEnabled();
            this.embeddedFilesViewEnabled = pdfActivityConfiguration.isEmbeddedFilesViewEnabled();
        }
    }
}
