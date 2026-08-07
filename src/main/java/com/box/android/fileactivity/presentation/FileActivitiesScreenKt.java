package com.box.android.fileactivity.presentation;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.outlined.ArrowBackKt;
import androidx.compose.material.icons.outlined.CloseKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.KeyboardOpenedGesturesBlockerKt;
import com.box.android.base.compose.UserAvatarKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.base.compose.dialog.BoxProgressDialogKt;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.base.compose.popup.BoxPopupMenuKt;
import com.box.android.base.compose.popup.model.PopupMenuItem;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.components.commentbar.TimestampData;
import com.box.android.base.presentation.components.commentbar.TimestampProcessingResult;
import com.box.android.base.presentation.components.commentbar.TimestampUtil;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import com.box.android.fileactivity.R;
import com.box.android.fileactivity.model.AnnotationLocationUIModel;
import com.box.android.fileactivity.model.AnnotationUIModelV2;
import com.box.android.fileactivity.model.CommentUIModelV2;
import com.box.android.fileactivity.model.FileActivityUIModelV2;
import com.box.android.fileactivity.model.FileActivityUIModelsV2Kt;
import com.box.android.fileactivity.model.MentionInfo;
import com.box.android.fileactivity.model.UserUIModel;
import com.box.android.fileactivity.model.VersionsUIModelV2;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u001aO\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\u0014\u001a)\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0005H\u0007¢\u0006\u0002\u0010\u0019\u001a#\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010 \u001a)\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010%\u001a9\u0010&\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010'\u001a\u00020(H\u0003¢\u0006\u0002\u0010)\u001a\u001d\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101\u001a/\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\b\b\u0002\u0010\"\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u00106\u001a\u0017\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0003¢\u0006\u0002\u0010;\u001a,\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u0002082\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00052\u0006\u0010>\u001a\u00020?H\u0002\u001aK\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\r2\n\b\u0002\u0010=\u001a\u0004\u0018\u0001082\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00030\u000fH\u0007¢\u0006\u0002\u0010H\u001a#\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020K2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0007¢\u0006\u0002\u0010L\u001a#\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020O2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0007¢\u0006\u0002\u0010P\u001a-\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\tH\u0007¢\u0006\u0002\u0010W\u001a\r\u0010X\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010 \u001a#\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dH\u0007¢\u0006\u0002\u0010[\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\\²\u0006\n\u0010\u0013\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010]\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010^\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"DATE_FORMAT_STRING", "", "FileActivitiesScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;", "Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$Action;", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "userUIModel", "Lcom/box/android/fileactivity/model/UserUIModel;", "isRedesignedVersion", "", "handleClose", "Lkotlin/Function1;", "", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/fileactivity/model/UserUIModel;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "FileActivitiesContent", "fileActivitiesState", "(Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "ItemMenu", "itemState", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "(Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "FileActivitiesToolbar", "isSingleThreadView", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FileActivitiesEmptyScreen", "(Landroidx/compose/runtime/Composer;I)V", "ReplyIndicator", "isSelected", ViewProps.PADDING_START, ViewProps.PADDING_BOTTOM, "(ZIILandroidx/compose/runtime/Composer;II)V", "LoadedScreen", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lcom/box/android/fileactivity/presentation/FileActivitiesReducer$State;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lcom/box/android/cpl/Store;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "FileActivityErrorHeader", "title", "subtitle", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "VersionItem", "versionItem", "Lcom/box/android/fileactivity/model/VersionsUIModelV2;", "(Lcom/box/android/fileactivity/model/VersionsUIModelV2;Landroidx/compose/runtime/Composer;I)V", "FileActivityCell", "fileActivity", "Lcom/box/android/fileactivity/presentation/FileActivity;", "isEndOfCommentThread", "(Lcom/box/android/fileactivity/presentation/FileActivity;ZZLcom/box/android/base/compose/DefaultAvatarControllerWrapper;Landroidx/compose/runtime/Composer;II)V", "createAnnotationLink", "Lcom/box/android/fileactivity/presentation/AnnotationLink;", "item", "Lcom/box/android/fileactivity/model/FileActivityUIModelV2;", "(Lcom/box/android/fileactivity/model/FileActivityUIModelV2;Landroidx/compose/runtime/Composer;I)Lcom/box/android/fileactivity/presentation/AnnotationLink;", "handleAnnotationLinkClick", "annotationLink", "context", "Landroid/content/Context;", "constructStyledMessage", "Landroidx/compose/ui/text/AnnotatedString;", "message", "tags", "", "Lcom/box/android/fileactivity/model/MentionInfo;", "isEdited", "onAnnotationLinkClick", "(Ljava/lang/String;Ljava/util/List;ZLcom/box/android/fileactivity/presentation/AnnotationLink;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/AnnotatedString;", "PageVersionBubble", "versionInfo", "Lcom/box/android/fileactivity/presentation/VersionInfo;", "(Lcom/box/android/fileactivity/presentation/VersionInfo;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReplyButton", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FileActivitiesUserInfo", "createdUserId", "creatorUserName", "createdAt", "Ljava/util/Date;", "avatarController", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;Landroidx/compose/runtime/Composer;I)V", "ResolvedBubble", "ReplyCountMessage", "replyCountMessage", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "file-activity_generalProdRelease", "showMenu", "showDeleteCommentConfirmation"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileActivitiesScreenKt {
    private static final String DATE_FORMAT_STRING = "MMM d, yyyy 'at' h:mm a";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesContent$lambda$2(FileActivitiesReducer.State state, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Store store, int i, Composer composer, int i2) {
        FileActivitiesContent(state, defaultAvatarControllerWrapper, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesEmptyScreen$lambda$0(int i, Composer composer, int i2) {
        FileActivitiesEmptyScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesScreen$lambda$2(Store store, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, UserUIModel userUIModel, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        FileActivitiesScreen(store, defaultAvatarControllerWrapper, userUIModel, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesToolbar$lambda$2(boolean z, Function0 function0, int i, Composer composer, int i2) {
        FileActivitiesToolbar(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesUserInfo$lambda$1(String str, String str2, Date date, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, int i, Composer composer, int i2) {
        FileActivitiesUserInfo(str, str2, date, defaultAvatarControllerWrapper, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivityCell$lambda$3(FileActivity fileActivity, boolean z, boolean z2, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, int i, int i2, Composer composer, int i3) {
        FileActivityCell(fileActivity, z, z2, defaultAvatarControllerWrapper, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivityErrorHeader$lambda$1(String str, String str2, int i, Composer composer, int i2) {
        FileActivityErrorHeader(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$11(FileActivityReducer.State state, Store store, int i, Composer composer, int i2) {
        ItemMenu(state, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$6(FileActivityReducer.State state, Store store, int i, Composer composer, int i2) {
        ItemMenu(state, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadedScreen$lambda$2(FileActivitiesReducer.State state, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Store store, LazyListState lazyListState, int i, Composer composer, int i2) {
        LoadedScreen(state, defaultAvatarControllerWrapper, store, lazyListState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageVersionBubble$lambda$0(VersionInfo versionInfo, Function0 function0, int i, Composer composer, int i2) {
        PageVersionBubble(versionInfo, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageVersionBubble$lambda$2(VersionInfo versionInfo, Function0 function0, int i, Composer composer, int i2) {
        PageVersionBubble(versionInfo, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyButton$lambda$2(Modifier modifier, Function0 function0, int i, Composer composer, int i2) {
        ReplyButton(modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyCountMessage$lambda$1(String str, Function0 function0, int i, Composer composer, int i2) {
        ReplyCountMessage(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyIndicator$lambda$0(boolean z, int i, int i2, int i3, int i4, Composer composer, int i5) {
        ReplyIndicator(z, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResolvedBubble$lambda$0(int i, Composer composer, int i2) {
        ResolvedBubble(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VersionItem$lambda$1(VersionsUIModelV2 versionsUIModelV2, int i, Composer composer, int i2) {
        VersionItem(versionsUIModelV2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0084  */
    /* JADX WARN: Code duplicated, block: B:40:0x0087  */
    /* JADX WARN: Code duplicated, block: B:44:0x0092  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:48:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009f  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:64:0x0104  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    public static final void FileActivitiesScreen(final Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store, final DefaultAvatarControllerWrapper avatarControllerWrapper, final UserUIModel userUIModel, boolean z, final Function1<? super Integer, Unit> handleClose, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z5;
        final State stateCollectAsStateWithLifecycle;
        int i4;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Intrinsics.checkNotNullParameter(userUIModel, "userUIModel");
        Intrinsics.checkNotNullParameter(handleClose, "handleClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-825998967);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActivitiesScreen)N(store,avatarControllerWrapper,userUIModel,isRedesignedVersion,handleClose)114@5635L29,119@5787L1531,119@5778L1540:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(userUIModel) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(handleClose)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i5 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-825998967, i3, -1, "com.box.android.fileactivity.presentation.FileActivitiesScreen (FileActivitiesScreen.kt:113)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                if (FileActivitiesScreen$lambda$0(stateCollectAsStateWithLifecycle).isClosing()) {
                    handleClose.invoke(Integer.valueOf(FileActivitiesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFileActivities().size()));
                }
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(27096916, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FileActivitiesScreenKt.FileActivitiesScreen$lambda$1(z5, store, userUIModel, avatarControllerWrapper, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FileActivitiesScreenKt.FileActivitiesScreen$lambda$2(store, avatarControllerWrapper, userUIModel, z4, handleClose, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(handleClose)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i5 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-825998967, i3, -1, "com.box.android.fileactivity.presentation.FileActivitiesScreen (FileActivitiesScreen.kt:113)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            if (FileActivitiesScreen$lambda$0(stateCollectAsStateWithLifecycle).isClosing()) {
                handleClose.invoke(Integer.valueOf(FileActivitiesScreen$lambda$0(stateCollectAsStateWithLifecycle).getFileActivities().size()));
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(27096916, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesScreen$lambda$1(z5, store, userUIModel, avatarControllerWrapper, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesScreen$lambda$2(store, avatarControllerWrapper, userUIModel, z4, handleClose, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesScreen$lambda$1(boolean z, final Store store, UserUIModel userUIModel, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, State state, Composer composer, int i) {
        long jM11499getAppBackgroundAlt0d7_KjU;
        ComposerKt.sourceInformation(composer, "C120@5797L1108:FileActivitiesScreen.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(27096916, i, -1, "com.box.android.fileactivity.presentation.FileActivitiesScreen.<anonymous> (FileActivitiesScreen.kt:120)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            if (z) {
                composer.startReplaceGroup(270336321);
                ComposerKt.sourceInformation(composer, "122@5899L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
            } else {
                composer.startReplaceGroup(270337444);
                ComposerKt.sourceInformation(composer, "122@5934L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
            }
            composer.endReplaceGroup();
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(companion, jM11499getAppBackgroundAlt0d7_KjU, null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -816067818, "C125@5996L489,139@6630L55,141@6712L183:FileActivitiesScreen.kt#dcyg9a");
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 988021230, "C126@6050L373,134@6440L31:FileActivitiesScreen.kt#dcyg9a");
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1786909495, "C129@6229L58,127@6079L230,132@6331L74:FileActivitiesScreen.kt#dcyg9a");
            boolean z2 = FileActivitiesScreen$lambda$0(state).getOpenedFileActivity() != null;
            ComposerKt.sourceInformationMarkerStart(composer, -1743468544, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileActivitiesScreenKt.FileActivitiesScreen$lambda$1$0$0$0$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FileActivitiesToolbar(z2, (Function0) objRememberedValue, composer, 0);
            FileActivitiesContent(FileActivitiesScreen$lambda$0(state), defaultAvatarControllerWrapper, store, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            KeyboardOpenedGesturesBlockerKt.KeyboardOpenedGesturesBlocker(null, composer, 0, 1);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$1 fileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$1 = new PropertyReference1Impl() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((FileActivitiesReducer.State) obj).getCommentWithMentionsState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, 1497715329, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1 fileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1RememberedValue = composer.rememberedValue();
            if (fileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                fileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1RememberedValue = FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1.INSTANCE;
                composer.updateRememberedValue(fileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FileActivitiesScreenBottomBarKt.BottomBar(store.scope(fileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$1, (Function1) ((KFunction) fileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1RememberedValue)), userUIModel, defaultAvatarControllerWrapper, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Integer errorMessageRes = FileActivitiesScreen$lambda$0(state).getErrorMessageRes();
            if (errorMessageRes == null) {
                composer.startReplaceGroup(-208465397);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-208465396);
                ComposerKt.sourceInformation(composer, "*148@6988L179,148@6969L198");
                int iIntValue = errorMessageRes.intValue();
                Integer numValueOf = Integer.valueOf(iIntValue);
                ComposerKt.sourceInformationMarkerStart(composer, 835154289, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(iIntValue) | composer.changed(store);
                FileActivitiesScreenKt$FileActivitiesScreen$1$2$1$1 fileActivitiesScreenKt$FileActivitiesScreen$1$2$1$1RememberedValue = composer.rememberedValue();
                if (zChanged2 || fileActivitiesScreenKt$FileActivitiesScreen$1$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    fileActivitiesScreenKt$FileActivitiesScreen$1$2$1$1RememberedValue = new FileActivitiesScreenKt$FileActivitiesScreen$1$2$1$1(iIntValue, store, null);
                    composer.updateRememberedValue(fileActivitiesScreenKt$FileActivitiesScreen$1$2$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) fileActivitiesScreenKt$FileActivitiesScreen$1$2$1$1RememberedValue, composer, 0);
                Unit unit = Unit.INSTANCE;
                composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            if (!FileActivitiesScreen$lambda$0(state).isCommentSubmissionInProgress()) {
                composer.startReplaceGroup(-215368786);
            } else {
                composer.startReplaceGroup(-208181560);
                ComposerKt.sourceInformation(composer, "155@7256L46");
                BoxProgressDialogKt.BoxProgressDialog(CommonBoxUtil.LS(R.string.saving_comment), composer, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesScreen$lambda$1$0$0$0$0$0(Store store) {
        store.send(FileActivitiesReducer.Action.ToolbarAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0179  */
    /* JADX WARN: Code duplicated, block: B:59:0x018b  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v13 */
    public static final void FileActivitiesContent(FileActivitiesReducer.State state, DefaultAvatarControllerWrapper avatarControllerWrapper, Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store, Composer composer, final int i) {
        int i2;
        final Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store2;
        final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper;
        int i3;
        ?? r6;
        int i4;
        int i5;
        final FileActivitiesReducer.State fileActivitiesState = state;
        Intrinsics.checkNotNullParameter(fileActivitiesState, "fileActivitiesState");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1307060328);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActivitiesContent)N(fileActivitiesState,avatarControllerWrapper,store)166@7576L23:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(fileActivitiesState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(avatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            store2 = store;
            defaultAvatarControllerWrapper = avatarControllerWrapper;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1307060328, i2, -1, "com.box.android.fileactivity.presentation.FileActivitiesContent (FileActivitiesScreen.kt:165)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            FileActivityReducer.State openedFileActivity = fileActivitiesState.getOpenedFileActivity();
            Unit unit = null;
            if (openedFileActivity == null) {
                composerStartRestartGroup.startReplaceGroup(461044221);
                composerStartRestartGroup.endReplaceGroup();
                i4 = 3;
                i5 = i2;
                r6 = 0;
            } else {
                composerStartRestartGroup.startReplaceGroup(461044222);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*176@7953L23,168@7658L328");
                i3 = i2;
                FileActivitiesReducer.State stateCopy$default = FileActivitiesReducer.State.copy$default(fileActivitiesState, null, null, IdentifiedListKt.identifiedListOf(openedFileActivity), null, null, false, null, null, false, null, null, null, 4091, null);
                r6 = 0;
                i4 = 3;
                LoadedScreen(stateCopy$default, avatarControllerWrapper, store, LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3), composerStartRestartGroup, i5 & 1008);
                composerStartRestartGroup.endReplaceGroup();
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                i5 = i3;
                composerStartRestartGroup = composerStartRestartGroup;
                fileActivitiesState = state;
                defaultAvatarControllerWrapper = avatarControllerWrapper;
                store2 = store;
                composerStartRestartGroup.startReplaceGroup(1954534591);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i5 = i3;
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(461406891);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                FileActivitiesReducer.LoadingState loadingState = state.getLoadingState();
                if (loadingState instanceof FileActivitiesReducer.LoadingState.Loading) {
                    composerStartRestartGroup.startReplaceGroup(1954549148);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "179@8095L20");
                    ItemStateScreensKt.LoadingItemsScreen(null, r6, composerStartRestartGroup, r6, i4);
                    composerStartRestartGroup.endReplaceGroup();
                    fileActivitiesState = state;
                    defaultAvatarControllerWrapper = avatarControllerWrapper;
                    store2 = store;
                } else {
                    if (!(loadingState instanceof FileActivitiesReducer.LoadingState.Loaded)) {
                        composerStartRestartGroup.startReplaceGroup(1954546743);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(461576802);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    IdentifiedList<FileActivityIdModel, FileActivityReducer.State> fileActivities = state.getFileActivities();
                    if ((fileActivities instanceof Collection) && fileActivities.isEmpty()) {
                        fileActivitiesState = state;
                        defaultAvatarControllerWrapper = avatarControllerWrapper;
                        store2 = store;
                        if (fileActivitiesState.getIsInitialRefreshComplete()) {
                            composerStartRestartGroup.startReplaceGroup(461979895);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "191@8618L27");
                            FileActivitiesEmptyScreen(composerStartRestartGroup, r6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(462071934);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "195@8711L20");
                            ItemStateScreensKt.LoadingItemsScreen(null, r6, composerStartRestartGroup, r6, i4);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        Iterator<FileActivityReducer.State> it = fileActivities.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                FileActivityReducer.State next = it.next();
                                if ((next.getItem() instanceof CommentUIModelV2) || (next.getItem() instanceof AnnotationUIModelV2)) {
                                    composerStartRestartGroup.startReplaceGroup(461800870);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8436L76");
                                    fileActivitiesState = state;
                                    defaultAvatarControllerWrapper = avatarControllerWrapper;
                                    store2 = store;
                                    LoadedScreen(fileActivitiesState, defaultAvatarControllerWrapper, store2, lazyListStateRememberLazyListState, composerStartRestartGroup, i5 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                fileActivitiesState = state;
                                defaultAvatarControllerWrapper = avatarControllerWrapper;
                                store2 = store;
                                if (fileActivitiesState.getIsInitialRefreshComplete()) {
                                    composerStartRestartGroup.startReplaceGroup(461979895);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "191@8618L27");
                                    FileActivitiesEmptyScreen(composerStartRestartGroup, r6);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(462071934);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "195@8711L20");
                                    ItemStateScreensKt.LoadingItemsScreen(null, r6, composerStartRestartGroup, r6, i4);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            }
                        }
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesContent$lambda$2(fileActivitiesState, defaultAvatarControllerWrapper, store2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ItemMenu(final FileActivityReducer.State itemState, final Store<FileActivityReducer.State, FileActivityReducer.Action> store, Composer composer, final int i) {
        final Store<FileActivityReducer.State, FileActivityReducer.Action> store2;
        Composer composer2;
        int i2;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(itemState, "itemState");
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(2042511187);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemMenu)N(itemState,store)204@8937L34,205@9013L46,232@10069L683,252@10783L873:FileActivitiesScreen.kt#dcyg9a");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(itemState) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            store2 = store;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2042511187, i3, -1, "com.box.android.fileactivity.presentation.ItemMenu (FileActivitiesScreen.kt:203)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 53201013, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 53203457, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            List<FileActivityReducer.MenuButtonConfig> enabledMenuItems = itemState.getEnabledMenuItems();
            if (!enabledMenuItems.isEmpty()) {
                if (!ItemMenu$lambda$4(mutableState3)) {
                    i2 = i3;
                    mutableState = mutableState3;
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(1640363855);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1649557556);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "218@9457L164,225@9765L41,214@9257L619");
                    int i4 = i3;
                    int i5 = R.string.delete_comment;
                    int i6 = R.string.delete_comment_confirmation;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 53217783, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                    boolean zChangedInstance = ((i4 & 112) == 32) | composerStartRestartGroup.changedInstance(itemState);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FileActivitiesScreenKt.ItemMenu$lambda$7$0(store, itemState, mutableState3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue3, R.string.LO_Delete, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 53227516, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FileActivitiesScreenKt.ItemMenu$lambda$8$0(mutableState3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    i2 = i4;
                    mutableState = mutableState3;
                    BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i5, i6, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue4, R.string.LO_Cancel, 1, null), null, null, 0L, 0L, composer2, 0, PsExtractor.VIDEO_STREAM_MASK);
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composer2, 53237886, r6);
                boolean zChangedInstance2 = ((i2 & 112) == 32) | composer2.changedInstance(itemState);
                Object objRememberedValue5 = composer2.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    store2 = store;
                    objRememberedValue5 = new Function1() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FileActivitiesScreenKt.ItemMenu$lambda$9$0(store2, itemState, mutableState, mutableState2, (FileActivityReducer.MenuButtonConfig) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                } else {
                    store2 = store;
                }
                final Function1 function1 = (Function1) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1662832287, "C257@10969L19,253@10797L418,267@11295L20,265@11224L426:FileActivitiesScreen.kt#dcyg9a");
                Modifier modifierTestTag = TestTagKt.testTag(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), FileActivityUIModelsV2Kt.getMessage(itemState.getItem()).getMessage() + ":ItemMenu");
                ComposerKt.sourceInformationMarkerStart(composer2, 1331838240, r6);
                Object objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FileActivitiesScreenKt.ItemMenu$lambda$10$0$0(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                IconButtonKt.IconButton((Function0<Unit>) objRememberedValue6, modifierTestTag, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FileActivitiesScreenKt.INSTANCE.m12595getLambda$1842365905$file_activity_generalProdRelease(), composer2, 1572870, 60);
                boolean zItemMenu$lambda$1 = ItemMenu$lambda$1(mutableState2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1331848673, r6);
                Object objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FileActivitiesScreenKt.ItemMenu$lambda$10$1$0(mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                Function0 function0 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.startReplaceGroup(1331850749);
                ComposerKt.sourceInformation(composer2, "*271@11478L26");
                List<FileActivityReducer.MenuButtonConfig> list = enabledMenuItems;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (final FileActivityReducer.MenuButtonConfig menuButtonConfig : list) {
                    int stringRes = menuButtonConfig.getStringRes();
                    ComposerKt.sourceInformationMarkerStart(composer2, 592268955, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                    boolean zChanged = composer2.changed(function1) | composer2.changed(menuButtonConfig);
                    Object objRememberedValue8 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FileActivitiesScreenKt.ItemMenu$lambda$10$2$0$0(function1, menuButtonConfig);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    arrayList.add(new PopupMenuItem(stringRes, (Function0) objRememberedValue8, Integer.valueOf(menuButtonConfig.getDrawableRes()), (Integer) null, (PaddingValues) null, false, 56, (DefaultConstructorMarker) null));
                }
                composer2.endReplaceGroup();
                BoxPopupMenuKt.m11733BoxPopupMenuUTokNlU(zItemMenu$lambda$1, function0, arrayList, SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(200)), null, 0L, composer2, 3120, 48);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FileActivitiesScreenKt.ItemMenu$lambda$6(itemState, store, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.ItemMenu$lambda$11(itemState, store2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ItemMenu$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ItemMenu$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ItemMenu$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ItemMenu$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$7$0(Store store, FileActivityReducer.State state, MutableState mutableState) {
        store.send(new FileActivityReducer.Action.TriggerDelete(state.getId()));
        ItemMenu$lambda$5(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$8$0(MutableState mutableState) {
        ItemMenu$lambda$5(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$9$0(Store store, FileActivityReducer.State state, MutableState mutableState, MutableState mutableState2, FileActivityReducer.MenuButtonConfig it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it, FileActivityReducer.MenuButtonConfig.INSTANCE.getRESOLVE())) {
            store.send(new FileActivityReducer.Action.SubmitUpdateStatus(FileActivityModel.Status.RESOLVED));
        } else if (Intrinsics.areEqual(it, FileActivityReducer.MenuButtonConfig.INSTANCE.getUNRESOLVE())) {
            store.send(new FileActivityReducer.Action.SubmitUpdateStatus(FileActivityModel.Status.OPEN));
        } else if (Intrinsics.areEqual(it, FileActivityReducer.MenuButtonConfig.INSTANCE.getMODIFY())) {
            store.send(new FileActivityReducer.Action.TriggerModify(state.getItem()));
        } else if (Intrinsics.areEqual(it, FileActivityReducer.MenuButtonConfig.INSTANCE.getDELETE())) {
            ItemMenu$lambda$5(mutableState, true);
        }
        ItemMenu$lambda$2(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$10$0$0(MutableState mutableState) {
        ItemMenu$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$10$1$0(MutableState mutableState) {
        ItemMenu$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemMenu$lambda$10$2$0$0(Function1 function1, FileActivityReducer.MenuButtonConfig menuButtonConfig) {
        function1.invoke(menuButtonConfig);
        return Unit.INSTANCE;
    }

    public static final void FileActivitiesToolbar(final boolean z, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1641853403);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActivitiesToolbar)N(isSingleThreadView,onClick)285@11866L6,319@13153L6,320@13224L6,321@13299L6,322@13359L6,318@13098L288,302@12519L542,287@11950L551,283@11794L1598:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1641853403, i2, -1, "com.box.android.fileactivity.presentation.FileActivitiesToolbar (FileActivitiesScreen.kt:282)");
            }
            Modifier modifierStatusBarsPadding = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11575getTopBarBackground0d7_KjU(), null, 2, null));
            TopAppBarColors topAppBarColorsM4782topAppBarColors5tl4gsc = TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11575getTopBarBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11575getTopBarBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11579getTopBarText0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11579getTopBarText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48);
            composerStartRestartGroup = composerStartRestartGroup;
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1937892321, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesToolbar$lambda$0(z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifierStatusBarsPadding, ComposableLambdaKt.rememberComposableLambda(-1946464609, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesToolbar$lambda$1(onClick, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0.0f, null, topAppBarColorsM4782topAppBarColors5tl4gsc, null, composerStartRestartGroup, 390, 184);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesToolbar$lambda$2(z, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesToolbar$lambda$1(Function0 function0, final boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C288@12029L462,288@11964L527:FileActivitiesScreen.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1946464609, i, -1, "com.box.android.fileactivity.presentation.FileActivitiesToolbar.<anonymous> (FileActivitiesScreen.kt:288)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, TestTagKt.testTag(Modifier.INSTANCE, "toolbarNavigationButton"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-973066431, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesToolbar$lambda$1$0(z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572912, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesToolbar$lambda$1$0(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:FileActivitiesScreen.kt#dcyg9a");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-973066431, i, -1, "com.box.android.fileactivity.presentation.FileActivitiesToolbar.<anonymous>.<anonymous> (FileActivitiesScreen.kt:289)");
            }
            if (z) {
                composer.startReplaceGroup(-1887717103);
                ComposerKt.sourceInformation(composer, "290@12093L168");
                IconKt.m3576Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Outlined.INSTANCE), CommonBoxUtil.LS(R.string.file_activities_back_content_description), (Modifier) null, 0L, composer, 0, 12);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1887505311);
                ComposerKt.sourceInformation(composer, "295@12307L152");
                IconKt.m3576Iconww6aTOc(CloseKt.getClose(Icons.Outlined.INSTANCE), CommonBoxUtil.LS(R.string.file_activities_close_content_description), (Modifier) null, 0L, composer, 0, 12);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivitiesToolbar$lambda$0(boolean z, Composer composer, int i) {
        String strLS;
        ComposerKt.sourceInformation(composer, "C304@12577L10,303@12533L518:FileActivitiesScreen.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1937892321, i, -1, "com.box.android.fileactivity.presentation.FileActivitiesToolbar.<anonymous> (FileActivitiesScreen.kt:303)");
            }
            TextStyle titleLarge = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge();
            if (z) {
                strLS = CommonBoxUtil.LS(R.string.file_activity_thread_title);
            } else {
                strLS = CommonBoxUtil.LS(R.string.activity_header_text);
            }
            TextKt.m4494TextNvy7gAk(strLS, TestTagKt.testTag(Modifier.INSTANCE, "toolbarTitle"), 0L, null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9531getStarte0LSkKk()), 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, titleLarge, composer, 48, 24960, 109564);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void FileActivitiesEmptyScreen(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2010961531);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActivitiesEmptyScreen)329@13446L270:FileActivitiesScreen.kt#dcyg9a");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2010961531, i, -1, "com.box.android.fileactivity.presentation.FileActivitiesEmptyScreen (FileActivitiesScreen.kt:328)");
            }
            ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.activity, CommonBoxUtil.LS(R.string.no_activity_to_show), null, null, 12, null), "FileActivitiesEmptyScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, 0L, composerStartRestartGroup, 432, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesEmptyScreen$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x009a  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:51:0x0103  */
    /* JADX WARN: Code duplicated, block: B:54:0x010d  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    public static final void ReplyIndicator(final boolean z, int i, int i2, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        final int i10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM11523getFileActivityReplyIndicator0d7_KjU;
        Composer composerStartRestartGroup = composer.startRestartGroup(-97163506);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ReplyIndicator)N(isSelected,paddingStart,paddingBottom)342@13966L250:FileActivitiesScreen.kt#dcyg9a");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i11 = i4 & 2;
        if (i11 == 0) {
            if ((i3 & 48) == 0) {
                i6 = i;
                i5 |= composerStartRestartGroup.changed(i6) ? 32 : 16;
            }
            i7 = i4 & 4;
            if (i7 != 0) {
                if ((i3 & 384) == 0) {
                    i8 = i2;
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 256;
                    } else {
                        i9 = 128;
                    }
                    i5 |= i9;
                }
                if ((i5 & Token.DOTQUERY) != 146) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i11 != 0) {
                        i6 = 0;
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-97163506, i5, -1, "com.box.android.fileactivity.presentation.ReplyIndicator (FileActivitiesScreen.kt:340)");
                    }
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(1115155984);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "341@13872L6");
                        jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11524getFileActivityReplyIndicatorSelected0d7_KjU();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1115157768);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "341@13928L6");
                        jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11523getFileActivityReplyIndicator0d7_KjU();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    float f = 4;
                    BoxKt.Box(ClipKt.clip(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1271width3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(i6), 0.0f, 0.0f, Dp.m9687constructorimpl(i8), 6, null), Dp.m9687constructorimpl(f)), jM11523getFileActivityReplyIndicator0d7_KjU, null, 2, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f))), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                i10 = i8;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i12 = i6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FileActivitiesScreenKt.ReplyIndicator$lambda$0(z, i12, i10, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 384;
            i8 = i2;
            if ((i5 & Token.DOTQUERY) != 146) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i11 != 0) {
                    i6 = 0;
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-97163506, i5, -1, "com.box.android.fileactivity.presentation.ReplyIndicator (FileActivitiesScreen.kt:340)");
                }
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(1115155984);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "341@13872L6");
                    jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11524getFileActivityReplyIndicatorSelected0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1115157768);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "341@13928L6");
                    jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11523getFileActivityReplyIndicator0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                float f2 = 4;
                BoxKt.Box(ClipKt.clip(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1271width3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(i6), 0.0f, 0.0f, Dp.m9687constructorimpl(i8), 6, null), Dp.m9687constructorimpl(f2)), jM11523getFileActivityReplyIndicator0d7_KjU, null, 2, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f2))), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            i10 = i8;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i13 = i6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FileActivitiesScreenKt.ReplyIndicator$lambda$0(z, i13, i10, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        i6 = i;
        i7 = i4 & 4;
        if (i7 != 0) {
            if ((i3 & 384) == 0) {
                i8 = i2;
                if (composerStartRestartGroup.changed(i8)) {
                    i9 = 256;
                } else {
                    i9 = 128;
                }
                i5 |= i9;
            }
            if ((i5 & Token.DOTQUERY) != 146) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i11 != 0) {
                    i6 = 0;
                }
                if (i7 != 0) {
                    i8 = 0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-97163506, i5, -1, "com.box.android.fileactivity.presentation.ReplyIndicator (FileActivitiesScreen.kt:340)");
                }
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(1115155984);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "341@13872L6");
                    jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11524getFileActivityReplyIndicatorSelected0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1115157768);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "341@13928L6");
                    jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11523getFileActivityReplyIndicator0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                float f3 = 4;
                BoxKt.Box(ClipKt.clip(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1271width3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(i6), 0.0f, 0.0f, Dp.m9687constructorimpl(i8), 6, null), Dp.m9687constructorimpl(f3)), jM11523getFileActivityReplyIndicator0d7_KjU, null, 2, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f3))), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            i10 = i8;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final int i14 = i6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FileActivitiesScreenKt.ReplyIndicator$lambda$0(z, i14, i10, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        i8 = i2;
        if ((i5 & Token.DOTQUERY) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                i6 = 0;
            }
            if (i7 != 0) {
                i8 = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-97163506, i5, -1, "com.box.android.fileactivity.presentation.ReplyIndicator (FileActivitiesScreen.kt:340)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1115155984);
                ComposerKt.sourceInformation(composerStartRestartGroup, "341@13872L6");
                jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11524getFileActivityReplyIndicatorSelected0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(1115157768);
                ComposerKt.sourceInformation(composerStartRestartGroup, "341@13928L6");
                jM11523getFileActivityReplyIndicator0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11523getFileActivityReplyIndicator0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            float f4 = 4;
            BoxKt.Box(ClipKt.clip(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1271width3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(i6), 0.0f, 0.0f, Dp.m9687constructorimpl(i8), 6, null), Dp.m9687constructorimpl(f4)), jM11523getFileActivityReplyIndicator0d7_KjU, null, 2, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f4))), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        i10 = i8;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i15 = i6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.ReplyIndicator$lambda$0(z, i15, i10, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void LoadedScreen(final FileActivitiesReducer.State state, final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store, LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        final Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store2 = store;
        final LazyListState lazyListState2 = lazyListState;
        Composer composerStartRestartGroup = composer.startRestartGroup(1658372030);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedScreen)N(fileActivitiesState,avatarControllerWrapper,store,listState)361@14574L6,362@14617L2175,359@14487L2305:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(defaultAvatarControllerWrapper) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyListState2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1658372030, i2, -1, "com.box.android.fileactivity.presentation.LoadedScreen (FileActivitiesScreen.kt:358)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 262668253, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            int i3 = i2 & 896;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(state) | (i3 == 256) | ((i2 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FileActivitiesScreenKt.LoadedScreen$lambda$0$0(state, store2, defaultAvatarControllerWrapper, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = i2;
            LazyDslKt.LazyColumn(modifierM589backgroundbw27NRU$default, lazyListState2, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, (i2 >> 6) & 112, 508);
            lazyListState2 = lazyListState2;
            if (state.getScrollToCommentIndex() <= 0) {
                store2 = store;
                composerStartRestartGroup.startReplaceGroup(-461787228);
            } else {
                composerStartRestartGroup.startReplaceGroup(-445065549);
                ComposerKt.sourceInformation(composerStartRestartGroup, "410@16912L171,410@16858L225");
                String scrollToCommentId = state.getScrollToCommentId();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 262739689, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(state) | ((i4 & 7168) == 2048) | (i3 == 256);
                FileActivitiesScreenKt$LoadedScreen$2$1 fileActivitiesScreenKt$LoadedScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || fileActivitiesScreenKt$LoadedScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    store2 = store;
                    fileActivitiesScreenKt$LoadedScreen$2$1RememberedValue = new FileActivitiesScreenKt$LoadedScreen$2$1(lazyListState2, state, store2, null);
                    composerStartRestartGroup.updateRememberedValue(fileActivitiesScreenKt$LoadedScreen$2$1RememberedValue);
                } else {
                    store2 = store;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(scrollToCommentId, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) fileActivitiesScreenKt$LoadedScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.LoadedScreen$lambda$2(state, defaultAvatarControllerWrapper, store2, lazyListState2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadedScreen$lambda$0$0(final FileActivitiesReducer.State state, final Store store, final DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, LazyListScope LazyColumn) {
        LazyListScope lazyListScope;
        FileActivityIdModel activityId;
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final FileActivitiesReducer.FailedToFetchSomeItems errorItem = state.getErrorItem();
        if (errorItem != null) {
            lazyListScope = LazyColumn;
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1684653844, true, new Function3() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FileActivitiesScreenKt.LoadedScreen$lambda$0$0$0$0(errorItem, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        } else {
            lazyListScope = LazyColumn;
        }
        FileActivityReducer.State state2 = (FileActivityReducer.State) CollectionsKt.lastOrNull((List) state.getShownFileActivities());
        final String activityId2 = (state2 == null || (activityId = state2.getId()) == null) ? null : activityId.getActivityId();
        final boolean z = state.getOpenedFileActivity() != null;
        final List<FileActivityReducer.State> shownFileActivities = state.getShownFileActivities();
        final Function1 function1 = new Function1() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivitiesScreenKt.LoadedScreen$lambda$0$0$1((FileActivityReducer.State) obj);
            }
        };
        final FileActivitiesScreenKt$LoadedScreen$lambda$0$0$$inlined$items$default$1 fileActivitiesScreenKt$LoadedScreen$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$LoadedScreen$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FileActivityReducer.State state3) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((FileActivityReducer.State) obj);
            }
        };
        lazyListScope.items(shownFileActivities.size(), new Function1<Integer, Object>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$LoadedScreen$lambda$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function1.invoke(shownFileActivities.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$LoadedScreen$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return fileActivitiesScreenKt$LoadedScreen$lambda$0$0$$inlined$items$default$1.invoke(shownFileActivities.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$LoadedScreen$lambda$0$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:42:0x00be  */
            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                FileActivityReducer.State state3;
                boolean z2;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                boolean z3 = true;
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                FileActivityReducer.State state4 = (FileActivityReducer.State) shownFileActivities.get(i);
                composer.startReplaceGroup(-1927498353);
                ComposerKt.sourceInformation(composer, "CN(fileActivityState)*380@15493L52:FileActivitiesScreen.kt#dcyg9a");
                boolean z4 = activityId2 != null && Intrinsics.areEqual(state4.getId().getActivityId(), activityId2);
                Store store2 = store;
                FileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$1 fileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$1 = new PropertyReference1Impl() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((FileActivitiesReducer.State) obj).getFileActivities();
                    }
                };
                FileActivityIdModel parentId = state4.getParentId();
                if (parentId == null) {
                    parentId = state4.getId();
                }
                ComposerKt.sourceInformationMarkerStart(composer, -1863285390, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                FileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$2$1 fileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$2$1RememberedValue = composer.rememberedValue();
                if (fileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    fileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$2$1RememberedValue = FileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$2$1.INSTANCE;
                    composer.updateRememberedValue(fileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Store storeScope = store2.scope(fileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$1, parentId, (Function2<? super FileActivityIdModel, ? super LocalAction, ? extends Action>) ((KFunction) fileActivitiesScreenKt$LoadedScreen$1$1$3$scopedStore$2$1RememberedValue));
                FileActivityIdModel parentId2 = state4.getParentId();
                if (parentId2 != null) {
                    Identifiable byId = state.getFileActivities().getById(parentId2);
                    Intrinsics.checkNotNull(byId);
                    state3 = (FileActivityReducer.State) byId;
                    if (state3 == null) {
                        state3 = state4;
                    }
                } else {
                    state3 = state4;
                }
                if (!state3.getShownReplies().isEmpty() && !Intrinsics.areEqual(CollectionsKt.last((List) state3.getShownReplies()), state4)) {
                    z3 = false;
                }
                FileActivityUIModelV2 item = state4.getItem();
                if (item instanceof VersionsUIModelV2) {
                    composer.startReplaceGroup(-1863268873);
                    ComposerKt.sourceInformation(composer, "389@16010L25");
                    FileActivitiesScreenKt.VersionItem((VersionsUIModelV2) item, composer, 0);
                    composer.endReplaceGroup();
                    z2 = z3;
                } else {
                    if (!(item instanceof CommentUIModelV2) && !(item instanceof AnnotationUIModelV2)) {
                        composer.startReplaceGroup(-1863271137);
                        composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceGroup(-1926656890);
                    ComposerKt.sourceInformation(composer, "391@16100L478");
                    z2 = z3;
                    FileActivitiesScreenKt.FileActivityCell(new FileActivity(state4, state3, storeScope), Intrinsics.areEqual(state4.getId().getActivityId(), state.getSelectedActivityID()), z2, defaultAvatarControllerWrapper, composer, 0, 0);
                    composer.endReplaceGroup();
                }
                if (z4 || z || !z2) {
                    composer.startReplaceGroup(-1942643900);
                } else {
                    composer.startReplaceGroup(-1926053010);
                    ComposerKt.sourceInformation(composer, "404@16740L22");
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
                }
                composer.endReplaceGroup();
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadedScreen$lambda$0$0$0$0(FileActivitiesReducer.FailedToFetchSomeItems failedToFetchSomeItems, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C365@14701L170,369@14888L22:FileActivitiesScreen.kt#dcyg9a");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1684653844, i, -1, "com.box.android.fileactivity.presentation.LoadedScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FileActivitiesScreen.kt:365)");
            }
            FileActivityErrorHeader(CommonBoxUtil.LS(R.string.activity_error_header), CollectionsKt.joinToString$default(failedToFetchSomeItems.getListOfFeatures(), null, null, null, 0, null, null, 63, null), composer, 0);
            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LoadedScreen$lambda$0$0$1(FileActivityReducer.State it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    public static final void FileActivityErrorHeader(final String title, String subtitle, Composer composer, final int i) {
        int i2;
        final String str;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Composer composerStartRestartGroup = composer.startRestartGroup(1723309429);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActivityErrorHeader)N(title,subtitle)424@17322L6,419@17172L628:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(title) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(subtitle) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            str = subtitle;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1723309429, i2, -1, "com.box.android.fileactivity.presentation.FileActivityErrorHeader (FileActivitiesScreen.kt:418)");
            }
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(BackgroundKt.m588backgroundbw27NRU(PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(16)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11540getNotificationContainer0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(10))), Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -440495928, "C432@17602L6,429@17490L145,437@17761L6,434@17644L150:FileActivitiesScreen.kt#dcyg9a");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(title, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11541getNotificationText0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer2, i2 & 14, 0, 131066);
            str = subtitle;
            TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11541getNotificationText0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, (i2 >> 3) & 14, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivityErrorHeader$lambda$1(title, str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void VersionItem(final VersionsUIModelV2 versionItem, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(versionItem, "versionItem");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1622109920);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VersionItem)N(versionItem)449@18017L6,444@17870L776:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(versionItem) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1622109920, i2, -1, "com.box.android.fileactivity.presentation.VersionItem (FileActivitiesScreen.kt:443)");
            }
            float f = 16;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11525getFileActivityVersionItemBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(10))), Dp.m9687constructorimpl(f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -219116226, "C459@18393L6,455@18223L197,462@18457L35,465@18606L6,461@18429L211:FileActivitiesScreen.kt#dcyg9a");
            TextKt.m4494TextNvy7gAk(versionItem.getMessage(), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composerStartRestartGroup, 0, 0, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_info, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(14)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.VersionItem$lambda$1(versionItem, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0361  */
    /* JADX WARN: Code duplicated, block: B:104:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:107:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:108:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:114:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:116:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:120:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:122:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:125:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0059  */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0082  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    /* JADX WARN: Code duplicated, block: B:50:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:63:0x010e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0112  */
    /* JADX WARN: Code duplicated, block: B:66:0x012d  */
    /* JADX WARN: Code duplicated, block: B:69:0x0152  */
    /* JADX WARN: Code duplicated, block: B:70:0x0159  */
    /* JADX WARN: Code duplicated, block: B:73:0x0160  */
    /* JADX WARN: Code duplicated, block: B:74:0x0163  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:82:0x0234  */
    /* JADX WARN: Code duplicated, block: B:83:0x027f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0292  */
    /* JADX WARN: Code duplicated, block: B:87:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:90:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:91:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0350 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0352  */
    /* JADX WARN: Code duplicated, block: B:96:0x0355  */
    /* JADX WARN: Code duplicated, block: B:98:0x035a  */
    public static final void FileActivityCell(final FileActivity fileActivity, boolean z, final boolean z2, final DefaultAvatarControllerWrapper avatarControllerWrapper, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        boolean z4;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z6;
        boolean zIsThreadedRepliesEnabled;
        final Store<FileActivityReducer.State, FileActivityReducer.Action> store;
        final FileActivityUIModelV2 item;
        FileActivityReducer.State itemState;
        FileActivityReducer.State parentItemState;
        final Context context;
        boolean z7;
        boolean z8;
        boolean z9;
        long jM6850getUnspecified0d7_KjU;
        FileActivityIdModel activityId;
        FileActivityReducer.State state;
        FileActivityIdModel activityId2;
        float f;
        final boolean zIsThreadedRepliesEnabled2;
        float f2;
        boolean z10;
        boolean zChanged;
        Object objRememberedValue;
        Modifier modifierTestTag;
        boolean z11;
        boolean z12;
        boolean z13;
        Function0<ComposeUiNode> constructor;
        int i4;
        Function0<ComposeUiNode> constructor2;
        int i5;
        FileActivityPermissionsModel permissions;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(fileActivity, "fileActivity");
        Intrinsics.checkNotNullParameter(avatarControllerWrapper, "avatarControllerWrapper");
        Composer composerStartRestartGroup = composer.startRestartGroup(553276302);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActivityCell)N(fileActivity,isSelected,isEndOfCommentThread,avatarControllerWrapper)485@19185L7,491@19434L7,597@23661L7,601@23863L381:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(fileActivity) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                z3 = z;
                i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i3 |= i7;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(avatarControllerWrapper)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z5 = z3;
            } else {
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(553276302, i3, -1, "com.box.android.fileactivity.presentation.FileActivityCell (FileActivitiesScreen.kt:484)");
                }
                ProvidableCompositionLocal<IFileActivityFeatureFlipProvider> localFileActivityFeatureFlips = FileActivityFeatureFlipProviderKt.getLocalFileActivityFeatureFlips();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localFileActivityFeatureFlips);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zIsThreadedRepliesEnabled = ((IFileActivityFeatureFlipProvider) objConsume).isThreadedRepliesEnabled();
                store = fileActivity.getStore();
                item = fileActivity.getItemState().getItem();
                itemState = fileActivity.getItemState();
                parentItemState = fileActivity.getParentItemState();
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume2;
                if (itemState.getParentId() != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (FileActivityUIModelsV2Kt.isResolved(parentItemState.getItem())) {
                    z8 = false;
                } else {
                    permissions = FileActivityUIModelsV2Kt.getPermissions(parentItemState.getItem());
                    Intrinsics.checkNotNull(permissions);
                    if (permissions.getCanReply() || !zIsThreadedRepliesEnabled) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                }
                if (itemState.isSingleThreadView() && z8 && z2) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-1425813137);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "590@23342L6");
                    jM6850getUnspecified0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11522getFileActivityContentBackgroundSelected0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1425739853);
                    composerStartRestartGroup.endReplaceGroup();
                    jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                }
                long j = jM6850getUnspecified0d7_KjU;
                Modifier.Companion companion = Modifier.INSTANCE;
                activityId = item.getId();
                state = (FileActivityReducer.State) CollectionsKt.firstOrNull((List) parentItemState.getShownReplies());
                if (state != null) {
                    activityId2 = state.getId();
                } else {
                    activityId2 = null;
                }
                if (Intrinsics.areEqual(activityId, activityId2)) {
                    f = -8;
                } else {
                    f = 0;
                }
                Modifier modifierM1175offsetVpY3zN4$default = OffsetKt.m1175offsetVpY3zN4$default(companion, 0.0f, Dp.m9687constructorimpl(f), 1, null);
                ProvidableCompositionLocal<IFileActivityFeatureFlipProvider> localFileActivityFeatureFlips2 = FileActivityFeatureFlipProviderKt.getLocalFileActivityFeatureFlips();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localFileActivityFeatureFlips2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zIsThreadedRepliesEnabled2 = ((IFileActivityFeatureFlipProvider) objConsume3).isThreadedRepliesEnabled();
                f2 = 8;
                z10 = z6;
                Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(PaddingKt.m1220paddingVpY3zN4$default(modifierM1175offsetVpY3zN4$default, Dp.m9687constructorimpl(f2), 0.0f, 2, null), j, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -877260373, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(zIsThreadedRepliesEnabled2) | composerStartRestartGroup.changed(store) | composerStartRestartGroup.changedInstance(item) | composerStartRestartGroup.changedInstance(context);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FileActivitiesScreenKt.FileActivityCell$lambda$1$0(zIsThreadedRepliesEnabled2, store, item, context);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierTestTag = TestTagKt.testTag(PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(modifierM588backgroundbw27NRU, false, null, null, null, (Function0) objRememberedValue, 15, null), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f2)), FileActivityUIModelsV2Kt.getMessage(item).getMessage() + "; Selected:" + z10 + " Reply:" + (!fileActivity.getIsParentFileActivity()));
                if (z7) {
                    z11 = z7;
                    z12 = z10;
                    z13 = z9;
                    if (zIsThreadedRepliesEnabled) {
                        composerStartRestartGroup.startReplaceGroup(-1424497218);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "618@24631L667");
                        Modifier modifierHeight = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int i9 = i3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHeight);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 805498884, "C619@24685L400,628@25098L190:FileActivitiesScreen.kt#dcyg9a");
                        if (!itemState.isSingleThreadView()) {
                            if (z13) {
                                i5 = 36;
                            } else {
                                i5 = 0;
                            }
                            i4 = i5 + 16;
                        } else if (z2 || z12) {
                            i4 = 0;
                        } else {
                            i4 = 8;
                        }
                        ReplyIndicator(z12, 16, i4, composerStartRestartGroup, ((i9 >> 3) & 14) | 48, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1244676525, "C629@25130L144:FileActivitiesScreen.kt#dcyg9a");
                        composerStartRestartGroup = composerStartRestartGroup;
                        FileActivityCell$ContentBlock(item, fileActivity, zIsThreadedRepliesEnabled, itemState, store, context, z13, z11, parentItemState, avatarControllerWrapper, RowScope.weight$default(rowScopeInstance, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (parentItemState.isSingleThreadView() || !z12 || !z2) {
                            composerStartRestartGroup.startReplaceGroup(-1448952684);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1423662295);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "640@25560L27");
                            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1448952684);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1424690224);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "614@24463L38,615@24510L22,616@24541L38");
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                    z12 = z10;
                    FileActivityCell$ContentBlock(item, fileActivity, zIsThreadedRepliesEnabled, itemState, store, context, z9, z7, parentItemState, avatarControllerWrapper, modifierTestTag, composerStartRestartGroup, 0, 0);
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z12;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FileActivitiesScreenKt.FileActivityCell$lambda$3(fileActivity, z5, z2, avatarControllerWrapper, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z3 = z;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changed(avatarControllerWrapper)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z5 = z3;
        } else {
            if (i8 != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(553276302, i3, -1, "com.box.android.fileactivity.presentation.FileActivityCell (FileActivitiesScreen.kt:484)");
            }
            ProvidableCompositionLocal<IFileActivityFeatureFlipProvider> localFileActivityFeatureFlips3 = FileActivityFeatureFlipProviderKt.getLocalFileActivityFeatureFlips();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localFileActivityFeatureFlips3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zIsThreadedRepliesEnabled = ((IFileActivityFeatureFlipProvider) objConsume4).isThreadedRepliesEnabled();
            store = fileActivity.getStore();
            item = fileActivity.getItemState().getItem();
            itemState = fileActivity.getItemState();
            parentItemState = fileActivity.getParentItemState();
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume5;
            if (itemState.getParentId() != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (FileActivityUIModelsV2Kt.isResolved(parentItemState.getItem())) {
                permissions = FileActivityUIModelsV2Kt.getPermissions(parentItemState.getItem());
                Intrinsics.checkNotNull(permissions);
                if (permissions.getCanReply()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
            } else {
                z8 = false;
            }
            if (itemState.isSingleThreadView()) {
                z9 = false;
            } else {
                z9 = false;
            }
            if (z6) {
                composerStartRestartGroup.startReplaceGroup(-1425813137);
                ComposerKt.sourceInformation(composerStartRestartGroup, "590@23342L6");
                jM6850getUnspecified0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11522getFileActivityContentBackgroundSelected0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1425739853);
                composerStartRestartGroup.endReplaceGroup();
                jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
            }
            long j2 = jM6850getUnspecified0d7_KjU;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            activityId = item.getId();
            state = (FileActivityReducer.State) CollectionsKt.firstOrNull((List) parentItemState.getShownReplies());
            if (state != null) {
                activityId2 = state.getId();
            } else {
                activityId2 = null;
            }
            if (Intrinsics.areEqual(activityId, activityId2)) {
                f = -8;
            } else {
                f = 0;
            }
            Modifier modifierM1175offsetVpY3zN4$default2 = OffsetKt.m1175offsetVpY3zN4$default(companion2, 0.0f, Dp.m9687constructorimpl(f), 1, null);
            ProvidableCompositionLocal<IFileActivityFeatureFlipProvider> localFileActivityFeatureFlips4 = FileActivityFeatureFlipProviderKt.getLocalFileActivityFeatureFlips();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localFileActivityFeatureFlips4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zIsThreadedRepliesEnabled2 = ((IFileActivityFeatureFlipProvider) objConsume6).isThreadedRepliesEnabled();
            f2 = 8;
            z10 = z6;
            Modifier modifierM588backgroundbw27NRU2 = BackgroundKt.m588backgroundbw27NRU(PaddingKt.m1220paddingVpY3zN4$default(modifierM1175offsetVpY3zN4$default2, Dp.m9687constructorimpl(f2), 0.0f, 2, null), j2, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -877260373, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(zIsThreadedRepliesEnabled2) | composerStartRestartGroup.changed(store) | composerStartRestartGroup.changedInstance(item) | composerStartRestartGroup.changedInstance(context);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileActivitiesScreenKt.FileActivityCell$lambda$1$0(zIsThreadedRepliesEnabled2, store, item, context);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileActivitiesScreenKt.FileActivityCell$lambda$1$0(zIsThreadedRepliesEnabled2, store, item, context);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifierTestTag = TestTagKt.testTag(PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(modifierM588backgroundbw27NRU2, false, null, null, null, (Function0) objRememberedValue, 15, null), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f2)), FileActivityUIModelsV2Kt.getMessage(item).getMessage() + "; Selected:" + z10 + " Reply:" + (!fileActivity.getIsParentFileActivity()));
            if (z7) {
                composerStartRestartGroup.startReplaceGroup(-1424690224);
                ComposerKt.sourceInformation(composerStartRestartGroup, "614@24463L38,615@24510L22,616@24541L38");
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                z12 = z10;
                FileActivityCell$ContentBlock(item, fileActivity, zIsThreadedRepliesEnabled, itemState, store, context, z9, z7, parentItemState, avatarControllerWrapper, modifierTestTag, composerStartRestartGroup, 0, 0);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                z11 = z7;
                z12 = z10;
                z13 = z9;
                if (zIsThreadedRepliesEnabled) {
                    composerStartRestartGroup.startReplaceGroup(-1424497218);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "618@24631L667");
                    Modifier modifierHeight2 = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int i10 = i3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHeight2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 805498884, "C619@24685L400,628@25098L190:FileActivitiesScreen.kt#dcyg9a");
                    if (!itemState.isSingleThreadView()) {
                        if (z13) {
                            i5 = 36;
                        } else {
                            i5 = 0;
                        }
                        i4 = i5 + 16;
                    } else if (z2) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    ReplyIndicator(z12, 16, i4, composerStartRestartGroup, ((i10 >> 3) & 14) | 48, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1244676525, "C629@25130L144:FileActivitiesScreen.kt#dcyg9a");
                    composerStartRestartGroup = composerStartRestartGroup;
                    FileActivityCell$ContentBlock(item, fileActivity, zIsThreadedRepliesEnabled, itemState, store, context, z13, z11, parentItemState, avatarControllerWrapper, RowScope.weight$default(rowScopeInstance2, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (parentItemState.isSingleThreadView()) {
                        composerStartRestartGroup.startReplaceGroup(-1448952684);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1448952684);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1448952684);
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z12;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivityCell$lambda$3(fileActivity, z5, z2, avatarControllerWrapper, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void FileActivityCell$ContentBlock(FileActivityUIModelV2 fileActivityUIModelV2, FileActivity fileActivity, boolean z, FileActivityReducer.State state, final Store<FileActivityReducer.State, FileActivityReducer.Action> store, final Context context, boolean z2, boolean z3, FileActivityReducer.State state2, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        int i4;
        ComposerKt.sourceInformationMarkerStart(composer, 1012656749, "C(ContentBlock)N(modifier)501@19831L3442:FileActivitiesScreen.kt#dcyg9a");
        Modifier.Companion companion = (i2 & 1) != 0 ? Modifier.INSTANCE : modifier;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1012656749, i, -1, "com.box.android.fileactivity.presentation.FileActivityCell.ContentBlock (FileActivitiesScreen.kt:500)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1029634007, "C502@19862L485,522@20614L26,529@20916L115,524@20676L369,537@21198L6,534@21059L227:FileActivitiesScreen.kt#dcyg9a");
        float f = 16;
        Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 601215782, "C506@20023L222,512@20262L27,514@20307L26:FileActivitiesScreen.kt#dcyg9a");
        FileActivitiesUserInfo(FileActivityUIModelsV2Kt.getCreatedByUserId(fileActivityUIModelV2), FileActivityUIModelsV2Kt.getCreatedByUserName(fileActivityUIModelV2), FileActivityUIModelsV2Kt.getCreatedAt(fileActivityUIModelV2), defaultAvatarControllerWrapper, composer, 0);
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
        ItemMenu(state, store, composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (!FileActivityUIModelsV2Kt.isResolved(fileActivityUIModelV2) || !fileActivity.getIsParentFileActivity() || !z) {
            composer.startReplaceGroup(1009824479);
        } else {
            composer.startReplaceGroup(1030112367);
            ComposerKt.sourceInformation(composer, "518@20467L16");
            ResolvedBubble(composer, 0);
        }
        composer.endReplaceGroup();
        AnnotationLink annotationLinkCreateAnnotationLink = createAnnotationLink(fileActivityUIModelV2, composer, 0);
        String message = FileActivityUIModelsV2Kt.getMessage(fileActivityUIModelV2).getMessage();
        List<MentionInfo> mentionSpans = FileActivityUIModelsV2Kt.getMessage(fileActivityUIModelV2).getMentionSpans();
        boolean isEdited = state.getIsEdited();
        ComposerKt.sourceInformationMarkerStart(composer, -105302890, "CC(remember):FileActivitiesScreen.kt#9igjgp");
        boolean zChanged = composer.changed(store) | composer.changedInstance(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileActivitiesScreenKt.FileActivityCell$ContentBlock$lambda$0$1$0(store, context, (AnnotationLink) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextKt.m4495TextZ58ophY(constructStyledMessage(message, mentionSpans, isEdited, annotationLinkCreateAnnotationLink, (Function1) objRememberedValue, composer, 0, 0), TestTagKt.testTag(Modifier.INSTANCE, "ItemMessage"), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composer, 48, 0, 262136);
        if (!(fileActivityUIModelV2 instanceof AnnotationUIModelV2) || (FileActivityUIModelsV2Kt.isResolved(fileActivityUIModelV2) && z)) {
            i3 = 1009824479;
            i4 = 0;
            composer.startReplaceGroup(1009824479);
        } else {
            composer.startReplaceGroup(1031070825);
            ComposerKt.sourceInformation(composer, "544@21563L112");
            AnnotationUIModelV2 annotationUIModelV2 = (AnnotationUIModelV2) fileActivityUIModelV2;
            Integer number = annotationUIModelV2.getVersion().getNumber();
            if (annotationUIModelV2.isOnLatestVersion()) {
                number = null;
            }
            Integer pageNumber = FileActivityUIModelsV2Kt.getPageNumber(fileActivityUIModelV2);
            ComposerKt.sourceInformationMarkerStart(composer, -105282189, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store) | composer.changedInstance(context);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileActivitiesScreenKt.FileActivityCell$ContentBlock$lambda$0$3$0(store, context);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (number == null && pageNumber == null) {
                i3 = 1009824479;
                composer.startReplaceGroup(1009824479);
            } else {
                i3 = 1009824479;
                composer.startReplaceGroup(1031395643);
                ComposerKt.sourceInformation(composer, "549@21764L28");
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            }
            composer.endReplaceGroup();
            if (number == null || pageNumber == null) {
                i4 = 0;
                if (number != null) {
                    composer.startReplaceGroup(1031730257);
                    ComposerKt.sourceInformation(composer, "558@22104L62");
                    PageVersionBubble(new VersionInfo.Version(number.intValue()), function0, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    if (pageNumber != null) {
                        composer.startReplaceGroup(1031882839);
                        ComposerKt.sourceInformation(composer, "562@22258L56");
                        PageVersionBubble(new VersionInfo.Page(pageNumber.intValue()), function0, composer, 0);
                    } else {
                        composer.startReplaceGroup(i3);
                    }
                    composer.endReplaceGroup();
                }
            } else {
                composer.startReplaceGroup(1031556254);
                ComposerKt.sourceInformation(composer, "554@21928L81");
                i4 = 0;
                PageVersionBubble(new VersionInfo.VersionAndPage(number.intValue(), pageNumber.intValue()), function0, composer, 0);
                composer.endReplaceGroup();
            }
        }
        composer.endReplaceGroup();
        if (state.isSingleThreadView() || !z) {
            composer.startReplaceGroup(i3);
        } else {
            composer.startReplaceGroup(-105252333);
            ComposerKt.sourceInformation(composer, "");
            String replyCountMessage = FileActivityUIModelsV2Kt.getReplyCountMessage(fileActivityUIModelV2);
            if (replyCountMessage == null) {
                composer.startReplaceGroup(1032144974);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1032144975);
                ComposerKt.sourceInformation(composer, "*569@22518L28,570@22609L105,570@22567L147");
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
                ComposerKt.sourceInformationMarkerStart(composer, 201067841, "CC(remember):FileActivitiesScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(store);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FileActivitiesScreenKt.FileActivityCell$ContentBlock$lambda$0$4$0$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ReplyCountMessage(replyCountMessage, (Function0) objRememberedValue3, composer, i4);
                Unit unit = Unit.INSTANCE;
                composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
        }
        composer.endReplaceGroup();
        if (z2) {
            composer.startReplaceGroup(1032444931);
            ComposerKt.sourceInformation(composer, "582@23152L97,577@22805L444");
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(OffsetKt.m1175offsetVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(z3 ? -16 : i4), 0.0f, 2, null), 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), FileActivityUIModelsV2Kt.getMessage(state2.getItem()).getMessage() + ":ReplyButton");
            ComposerKt.sourceInformationMarkerStart(composer, -105231356, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            boolean zChanged4 = composer.changed(store);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileActivitiesScreenKt.FileActivityCell$ContentBlock$lambda$0$5$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ReplyButton(modifierTestTag, (Function0) objRememberedValue4, composer, i4);
        } else {
            composer.startReplaceGroup(i3);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivityCell$ContentBlock$lambda$0$1$0(Store store, Context context, AnnotationLink annotationLink) {
        Intrinsics.checkNotNullParameter(annotationLink, "annotationLink");
        handleAnnotationLinkClick(annotationLink, store, context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivityCell$ContentBlock$lambda$0$3$0(Store store, Context context) {
        store.send(new FileActivityReducer.Action.PageVersionBubbleClicked(context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivityCell$ContentBlock$lambda$0$4$0$0(Store store) {
        store.send(FileActivityReducer.Action.MoreRepliesClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivityCell$ContentBlock$lambda$0$5$0(Store store) {
        store.send(FileActivityReducer.Action.ReplyButtonClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActivityCell$lambda$1$0(boolean z, Store store, FileActivityUIModelV2 fileActivityUIModelV2, Context context) {
        if (z) {
            store.send(FileActivityReducer.Action.ItemClicked.INSTANCE);
        } else if (FileActivityUIModelsV2Kt.getPageNumber(fileActivityUIModelV2) != null) {
            store.send(new FileActivityReducer.Action.PageVersionBubbleClicked(context));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0064  */
    /* JADX WARN: Code duplicated, block: B:14:0x0082  */
    private static final AnnotationLink createAnnotationLink(FileActivityUIModelV2 fileActivityUIModelV2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 136846209, "C(createAnnotationLink)N(item)659@26251L7:FileActivitiesScreen.kt#dcyg9a");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(136846209, i, -1, "com.box.android.fileactivity.presentation.createAnnotationLink (FileActivitiesScreen.kt:658)");
        }
        ProvidableCompositionLocal<IFileActivityFeatureFlipProvider> localFileActivityFeatureFlips = FileActivityFeatureFlipProviderKt.getLocalFileActivityFeatureFlips();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localFileActivityFeatureFlips);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AnnotationLink timestampComment = null;
        if (((IFileActivityFeatureFlipProvider) objConsume).isVideoAnnotationsEnabled()) {
            if (fileActivityUIModelV2 instanceof AnnotationUIModelV2) {
                AnnotationUIModelV2 annotationUIModelV2 = (AnnotationUIModelV2) fileActivityUIModelV2;
                if (annotationUIModelV2.getLocation() instanceof AnnotationLocationUIModel.Frame) {
                    timestampComment = new AnnotationLink.FrameAnnotation(((AnnotationLocationUIModel.Frame) annotationUIModelV2.getLocation()).getFrameTimestampMs(), annotationUIModelV2.getVersion().getId(), fileActivityUIModelV2.getId().getActivityId());
                } else {
                    TimestampProcessingResult timestampProcessingResultProcessTimestamp = TimestampUtil.INSTANCE.processTimestamp(FileActivityUIModelsV2Kt.getMessage(fileActivityUIModelV2).getMessage());
                    String processedText = timestampProcessingResultProcessTimestamp.getProcessedText();
                    TimestampData timestampData = (TimestampData) CollectionsKt.firstOrNull((List) timestampProcessingResultProcessTimestamp.component2());
                    timestampComment = timestampData != null ? new AnnotationLink.TimestampComment(processedText, timestampData) : null;
                }
            } else {
                TimestampProcessingResult timestampProcessingResultProcessTimestamp2 = TimestampUtil.INSTANCE.processTimestamp(FileActivityUIModelsV2Kt.getMessage(fileActivityUIModelV2).getMessage());
                String processedText2 = timestampProcessingResultProcessTimestamp2.getProcessedText();
                TimestampData timestampData2 = (TimestampData) CollectionsKt.firstOrNull((List) timestampProcessingResultProcessTimestamp2.component2());
                timestampComment = timestampData2 != null ? new AnnotationLink.TimestampComment(processedText2, timestampData2) : null;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return timestampComment;
    }

    private static final void handleAnnotationLinkClick(AnnotationLink annotationLink, Store<FileActivityReducer.State, FileActivityReducer.Action> store, Context context) {
        if (annotationLink instanceof AnnotationLink.FrameAnnotation) {
            store.send(new FileActivityReducer.Action.FrameAnnotationClicked(context));
        } else {
            if (!(annotationLink instanceof AnnotationLink.TimestampComment)) {
                throw new NoWhenBranchMatchedException();
            }
            TimestampData timestampData = ((AnnotationLink.TimestampComment) annotationLink).getTimestampData();
            store.send(new FileActivityReducer.Action.TimestampClicked(timestampData.getTimestampMs(), timestampData.getVersionId(), context));
        }
    }

    public static final AnnotatedString constructStyledMessage(String message, List<MentionInfo> tags, boolean z, AnnotationLink annotationLink, final Function1<? super AnnotationLink, Unit> onAnnotationLinkClick, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(onAnnotationLinkClick, "onAnnotationLinkClick");
        ComposerKt.sourceInformationMarkerStart(composer, 1567654296, "C(constructStyledMessage)N(message,tags,isEdited,annotationLink,onAnnotationLinkClick):FileActivitiesScreen.kt#dcyg9a");
        final AnnotationLink annotationLink2 = (i2 & 8) != 0 ? null : annotationLink;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1567654296, i, -1, "com.box.android.fileactivity.presentation.constructStyledMessage (FileActivitiesScreen.kt:706)");
        }
        composer.startReplaceGroup(-1017732857);
        ComposerKt.sourceInformation(composer, "");
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        if (annotationLink2 instanceof AnnotationLink.FrameAnnotation) {
            composer.startReplaceGroup(1092219695);
            ComposerKt.sourceInformation(composer, "718@28412L6,722@28590L85");
            AnnotationLink.FrameAnnotation frameAnnotation = (AnnotationLink.FrameAnnotation) annotationLink2;
            String timestampForDisplay = TimestampUtil.INSTANCE.formatTimestampForDisplay(frameAnnotation.getTimestampMs());
            builder.append(timestampForDisplay + " " + message);
            String str = "frameAnnotation:" + frameAnnotation.getAnnotationId();
            TextLinkStyles textLinkStyles = new TextLinkStyles(new SpanStyle(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null), null, null, null, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1836368280, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            boolean z2 = ((((i & 7168) ^ 3072) > 2048 && composer.changed(annotationLink2)) || (i & 3072) == 2048) | ((((i & 57344) ^ 24576) > 16384 && composer.changed(onAnnotationLinkClick)) || (i & 24576) == 16384);
            Object objRememberedValue = composer.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new LinkInteractionListener() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda7
                    @Override // androidx.compose.ui.text.LinkInteractionListener
                    public final void onClick(LinkAnnotation linkAnnotation) {
                        FileActivitiesScreenKt.constructStyledMessage$lambda$0$0$0(onAnnotationLinkClick, annotationLink2, linkAnnotation);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            builder.addLink(new LinkAnnotation.Clickable(str, textLinkStyles, (LinkInteractionListener) objRememberedValue), 0, timestampForDisplay.length() + 1);
            composer.endReplaceGroup();
        } else if (annotationLink2 instanceof AnnotationLink.TimestampComment) {
            composer.startReplaceGroup(1093107070);
            ComposerKt.sourceInformation(composer, "740@29242L6,744@29420L85");
            AnnotationLink.TimestampComment timestampComment = (AnnotationLink.TimestampComment) annotationLink2;
            builder.append(timestampComment.getDisplayMessage());
            TimestampData timestampData = timestampComment.getTimestampData();
            String str2 = "timestamp:" + timestampData.getTimestampMs() + ",versionId:" + timestampData.getVersionId();
            TextLinkStyles textLinkStyles2 = new TextLinkStyles(new SpanStyle(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null), null, null, null, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1836394840, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            boolean z3 = ((((i & 57344) ^ 24576) > 16384 && composer.changed(onAnnotationLinkClick)) || (i & 24576) == 16384) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(annotationLink2)) || (i & 3072) == 2048);
            Object objRememberedValue2 = composer.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new LinkInteractionListener() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda8
                    @Override // androidx.compose.ui.text.LinkInteractionListener
                    public final void onClick(LinkAnnotation linkAnnotation) {
                        FileActivitiesScreenKt.constructStyledMessage$lambda$0$1$0(onAnnotationLinkClick, annotationLink2, linkAnnotation);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            builder.addLink(new LinkAnnotation.Clickable(str2, textLinkStyles2, (LinkInteractionListener) objRememberedValue2), timestampData.getRange().getFirst(), timestampData.getRange().getLast() + 1);
            composer.endReplaceGroup();
        } else {
            if (annotationLink2 != null) {
                composer.startReplaceGroup(1836346960);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(1836402258);
            composer.endReplaceGroup();
            builder.append(message);
        }
        int length = message.length() - builder.getLength();
        composer.startReplaceGroup(-1017670342);
        ComposerKt.sourceInformation(composer, "*763@29952L6");
        for (MentionInfo mentionInfo : tags) {
            builder.addStyle(new SpanStyle(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null), mentionInfo.getStartIndex() - length, (mentionInfo.getEndIndex() + 1) - length);
        }
        composer.endReplaceGroup();
        if (z) {
            composer.startReplaceGroup(1094390129);
            ComposerKt.sourceInformation(composer, "774@30223L6");
            int iPushStyle = builder.pushStyle(new SpanStyle(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0L, FontWeight.INSTANCE.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null));
            try {
                builder.append(" (" + CommonBoxUtil.LS(R.string.edited) + ")");
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
            } catch (Throwable th) {
                builder.pop(iPushStyle);
                throw th;
            }
        } else {
            composer.startReplaceGroup(1064476927);
        }
        composer.endReplaceGroup();
        AnnotatedString annotatedString = builder.toAnnotatedString();
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void constructStyledMessage$lambda$0$0$0(Function1 function1, AnnotationLink annotationLink, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(annotationLink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void constructStyledMessage$lambda$0$1$0(Function1 function1, AnnotationLink annotationLink, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(annotationLink);
    }

    public static final void PageVersionBubble(final VersionInfo versionInfo, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final VersionInfoBubbleStyle versionInfoBubbleStyle;
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(263128934);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PageVersionBubble)N(versionInfo,onClick)842@32465L328,838@32327L466:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(versionInfo) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(263128934, i2, -1, "com.box.android.fileactivity.presentation.PageVersionBubble (FileActivitiesScreen.kt:791)");
            }
            if (versionInfo instanceof VersionInfo.Version) {
                composerStartRestartGroup.startReplaceGroup(558914022);
                ComposerKt.sourceInformation(composerStartRestartGroup, "796@30856L7,800@30994L6,801@31059L6");
                int i3 = R.string.annotation_nav_button_text_version_only;
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                versionInfoBubbleStyle = new VersionInfoBubbleStyle(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), Color.INSTANCE.m6849getTransparent0d7_KjU(), BoxPresentationUtils.localize(i3, (Context) objConsume, Integer.valueOf(((VersionInfo.Version) versionInfo).getVersionNumber())), null);
                composerStartRestartGroup.endReplaceGroup();
            } else if (versionInfo instanceof VersionInfo.Page) {
                composerStartRestartGroup.startReplaceGroup(559443564);
                ComposerKt.sourceInformation(composerStartRestartGroup, "810@31378L7,816@31609L6");
                int i4 = R.string.annotation_nav_button_text;
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                versionInfoBubbleStyle = new VersionInfoBubbleStyle(Color.INSTANCE.m6851getWhite0d7_KjU(), Color.INSTANCE.m6849getTransparent0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), BoxPresentationUtils.localize(i4, (Context) objConsume2, Integer.valueOf(((VersionInfo.Page) versionInfo).getPageNumber())), null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!(versionInfo instanceof VersionInfo.VersionAndPage)) {
                    composerStartRestartGroup.startReplaceGroup(-536160461);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(559948926);
                ComposerKt.sourceInformation(composerStartRestartGroup, "824@31898L7,829@32076L6,830@32141L6");
                int i5 = R.string.annotation_nav_button_text_prev_version;
                ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localContext3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                VersionInfo.VersionAndPage versionAndPage = (VersionInfo.VersionAndPage) versionInfo;
                versionInfoBubbleStyle = new VersionInfoBubbleStyle(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), Color.INSTANCE.m6849getTransparent0d7_KjU(), BoxPresentationUtils.localize(i5, (Context) objConsume3, Integer.valueOf(versionAndPage.getVersionNumber()), Integer.valueOf(versionAndPage.getPageNumber())), null);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (versionInfoBubbleStyle.getText() != null) {
                SurfaceKt.m4323SurfaceT9BRK9s(null, RoundedCornerShapeKt.getCircleShape(), versionInfoBubbleStyle.m12615getBackgroundColor0d7_KjU(), 0L, 0.0f, 0.0f, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), versionInfoBubbleStyle.m12616getBorderColor0d7_KjU()), ComposableLambdaKt.rememberComposableLambda(1282460097, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FileActivitiesScreenKt.PageVersionBubble$lambda$1(versionInfoBubbleStyle, onClick, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 57);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FileActivitiesScreenKt.PageVersionBubble$lambda$0(versionInfo, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.PageVersionBubble$lambda$2(versionInfo, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageVersionBubble$lambda$1(VersionInfoBubbleStyle versionInfoBubbleStyle, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C843@32475L312:FileActivitiesScreen.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1282460097, i, -1, "com.box.android.fileactivity.presentation.PageVersionBubble.<anonymous> (FileActivitiesScreen.kt:843)");
            }
            TextKt.m4494TextNvy7gAk(versionInfoBubbleStyle.getText(), ClickableKt.m632clickableoSLSa3U$default(PaddingKt.m1219paddingVpY3zN4(TestTagKt.testTag(Modifier.INSTANCE, "PageBubble"), Dp.m9687constructorimpl(8), Dp.m9687constructorimpl(2)), false, null, null, null, function0, 15, null), versionInfoBubbleStyle.m12617getFontColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold10(), composer, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ReplyButton(final Modifier modifier, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-743475758);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ReplyButton)N(modifier,onClick)857@32895L20,857@32872L555:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743475758, i2, -1, "com.box.android.fileactivity.presentation.ReplyButton (FileActivitiesScreen.kt:856)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1515629530, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            boolean z = (i2 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileActivitiesScreenKt.ReplyButton$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifier, false, null, null, null, (Function0) objRememberedValue, 15, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM632clickableoSLSa3U$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 104041959, "C859@32945L33,861@33075L6,858@32927L220,864@33156L38,869@33388L6,865@33203L218:FileActivitiesScreen.kt#dcyg9a");
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.reply, composerStartRestartGroup, 0), (String) null, rowScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composerStartRestartGroup, Painter.$stable | 48, 0);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
            TextKt.m4494TextNvy7gAk(CommonBoxUtil.LS(R.string.reply), rowScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold14(), composerStartRestartGroup, 0, 0, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.ReplyButton$lambda$2(modifier, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyButton$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void FileActivitiesUserInfo(final String createdUserId, final String creatorUserName, Date createdAt, final DefaultAvatarControllerWrapper avatarController, Composer composer, final int i) {
        int i2;
        Date date;
        Intrinsics.checkNotNullParameter(createdUserId, "createdUserId");
        Intrinsics.checkNotNullParameter(creatorUserName, "creatorUserName");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(avatarController, "avatarController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-772126632);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActivitiesUserInfo)N(createdUserId,creatorUserName,createdAt,avatarController)881@33609L1065:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(createdUserId) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(creatorUserName) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(createdAt) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(avatarController) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            date = createdAt;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-772126632, i3, -1, "com.box.android.fileactivity.presentation.FileActivitiesUserInfo (FileActivitiesScreen.kt:880)");
            }
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1288740407, "C882@33702L186,888@33897L771:FileActivitiesScreen.kt#dcyg9a");
            UserAvatarKt.UserAvatar(createdUserId, creatorUserName, avatarController.getDefaultAvatarController(), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, BoxTheme.INSTANCE.getSizes().getAvatar().m11349getLargeD9Ej5fM()), composerStartRestartGroup, i3 & 126, 0);
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -233211092, "C893@34164L6,889@33961L234,899@34372L7,905@34621L6,895@34208L450:FileActivitiesScreen.kt#dcyg9a");
            TextKt.m4494TextNvy7gAk(creatorUserName, TestTagKt.testTag(Modifier.INSTANCE, "activityItemUserName"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold15(), composerStartRestartGroup, ((i3 >> 3) & 14) | 48, 0, 131064);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            date = createdAt;
            String formattedDate = BoxDateUtils.getFormattedDate(DATE_FORMAT_STRING, date, (Context) objConsume);
            Intrinsics.checkNotNullExpressionValue(formattedDate, "getFormattedDate(...)");
            TextKt.m4494TextNvy7gAk(formattedDate, TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(2), 0.0f, 0.0f, 13, null), "activityItemTimestamp"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 48, 0, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Date date2 = date;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.FileActivitiesUserInfo$lambda$1(createdUserId, creatorUserName, date2, avatarController, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ResolvedBubble(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1246262923);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ResolvedBubble)916@34836L6,913@34717L513:FileActivitiesScreen.kt#dcyg9a");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1246262923, i, -1, "com.box.android.fileactivity.presentation.ResolvedBubble (FileActivitiesScreen.kt:912)");
            }
            float f = 2;
            SurfaceKt.m4323SurfaceT9BRK9s(TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(16), 7, null), "ResolvedBubble"), RoundedCornerShapeKt.getCircleShape(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11558getStatusDone0d7_KjU(), 0L, 0.0f, Dp.m9687constructorimpl(f), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(f), Color.INSTANCE.m6849getTransparent0d7_KjU()), ComposableSingletons$FileActivitiesScreenKt.INSTANCE.m12594getLambda$1726490138$file_activity_generalProdRelease(), composerStartRestartGroup, 14352390, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.ResolvedBubble$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ReplyCountMessage(final String replyCountMessage, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(replyCountMessage, "replyCountMessage");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1152288250);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ReplyCountMessage)N(replyCountMessage,onClick)935@35413L13,938@35542L6,932@35322L250:FileActivitiesScreen.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(replyCountMessage) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1152288250, i2, -1, "com.box.android.fileactivity.presentation.ReplyCountMessage (FileActivitiesScreen.kt:931)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 752559475, "CC(remember):FileActivitiesScreen.kt#9igjgp");
            boolean z = (i2 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FileActivitiesScreenKt.ReplyCountMessage$lambda$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(replyCountMessage, TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null), "ReplyCountMessage"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold14(), composer2, i2 & 14, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesScreenKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesScreenKt.ReplyCountMessage$lambda$1(replyCountMessage, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyCountMessage$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final FileActivitiesReducer.State FileActivitiesScreen$lambda$0(State<FileActivitiesReducer.State> state) {
        return state.getValue();
    }
}
