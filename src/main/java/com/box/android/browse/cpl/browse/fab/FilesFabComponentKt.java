package com.box.android.browse.cpl.browse.fab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemColors;
import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.base.compose.BoxModalBottomSheetKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.compose.button.fab.BoxFabButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.browse.R;
import com.box.android.browse.cpl.browse.fab.newfile.NewFileType;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.hc.core5.http.HttpStatus;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* JADX INFO: compiled from: FilesFabComponent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a`\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a7\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\u001a\u001a/\u0010\u001b\u001a\u00020\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00172\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\u001f\u001a!\u0010 \u001a\u00020\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010#\u001aC\u0010$\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010&2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0003¢\u0006\u0002\u0010+\u001a]\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\f\u00102\u001a\b\u0012\u0004\u0012\u000201002\f\u00103\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010&H\u0003¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u000209H\u0003¢\u0006\u0002\u0010:\u001a\f\u0010;\u001a\u00020<*\u00020\u0018H\u0002\u001a\u0014\u0010=\u001a\u00020\u0005*\u00020\u00182\u0006\u00104\u001a\u000205H\u0002\u001a\f\u0010>\u001a\u00020<*\u00020\u0018H\u0002\u001a\f\u0010;\u001a\u00020<*\u00020\u001dH\u0002\u001a\f\u0010>\u001a\u00020<*\u00020\u001dH\u0002¨\u0006?²\u0006\n\u0010@\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"FilesFabComponent", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$State;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onCreateNewDocumentClicked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "modifier", "Landroidx/compose/ui/Modifier;", "isVisible", "", "(Lcom/box/android/cpl/Store;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "FabOptionsBottomSheetContent", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "menuOptions", "", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$FabMenuOption;", "onOptionClick", "(Lcom/box/android/domain/models/item/FolderModel;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CreateFileOptionsBottomSheetContent", "newFileTypes", "Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileType;", "onFileTypeClick", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "UploadContentOptionsBottomSheetContent", "onUploadTypeSelected", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FabMenuBottomSheet", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ViewEffectProcessor", GuideTransition.GUIDE_TRANSITION_EFFECT_FIELD, "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "filePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "folderPickerLauncher", "storageAccessRequestLauncher", "activity", "Landroid/app/Activity;", "onProcessed", "(Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;Landroidx/compose/material3/SnackbarHostState;Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/ActivityResultLauncher;Landroidx/activity/result/ActivityResultLauncher;Landroid/app/Activity;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "createListItemColors", "Landroidx/compose/material3/ListItemColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ListItemColors;", "toStringRes", "", "toOnClickAction", "toIconRes", "browse_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesFabComponentKt {

    /* JADX INFO: compiled from: FilesFabComponent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FilesFabReducer.FabMenuOption.values().length];
            try {
                iArr[FilesFabReducer.FabMenuOption.NEW_FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FilesFabReducer.FabMenuOption.NEW_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FilesFabReducer.FabMenuOption.UPLOAD_CONTENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FilesFabReducer.FabMenuOption.CAPTURE_MEDIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FilesFabReducer.FabMenuOption.NEW_BOX_NOTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NewFileType.values().length];
            try {
                iArr2[NewFileType.Word.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[NewFileType.Ppt.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[NewFileType.Spreadsheet.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[NewFileType.Text.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFileOptionsBottomSheetContent$lambda$1(List list, Function1 function1, int i, Composer composer, int i2) {
        CreateFileOptionsBottomSheetContent(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FabMenuBottomSheet$lambda$1(Modifier modifier, Function0 function0, Function3 function3, int i, int i2, Composer composer, int i3) {
        FabMenuBottomSheet(modifier, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FabOptionsBottomSheetContent$lambda$1(FolderModel folderModel, List list, Function1 function1, int i, Composer composer, int i2) {
        FabOptionsBottomSheetContent(folderModel, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$1(Store store, SnackbarHostState snackbarHostState, Function1 function1, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        FilesFabComponent(store, snackbarHostState, function1, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$16(Store store, SnackbarHostState snackbarHostState, Function1 function1, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        FilesFabComponent(store, snackbarHostState, function1, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$2(Store store, SnackbarHostState snackbarHostState, Function1 function1, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        FilesFabComponent(store, snackbarHostState, function1, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentOptionsBottomSheetContent$lambda$1(Function1 function1, int i, Composer composer, int i2) {
        UploadContentOptionsBottomSheetContent(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ViewEffectProcessor$lambda$1(FilesFabReducer.ViewEffect viewEffect, SnackbarHostState snackbarHostState, ActivityResultLauncher activityResultLauncher, ActivityResultLauncher activityResultLauncher2, ActivityResultLauncher activityResultLauncher3, Activity activity, Function0 function0, int i, Composer composer, int i2) {
        ViewEffectProcessor(viewEffect, snackbarHostState, activityResultLauncher, activityResultLauncher2, activityResultLauncher3, activity, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0217  */
    /* JADX WARN: Code duplicated, block: B:103:0x0247  */
    /* JADX WARN: Code duplicated, block: B:105:0x025a  */
    /* JADX WARN: Code duplicated, block: B:106:0x025c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0263  */
    /* JADX WARN: Code duplicated, block: B:111:0x026b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0285  */
    /* JADX WARN: Code duplicated, block: B:115:0x0287  */
    /* JADX WARN: Code duplicated, block: B:118:0x028e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0296  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:125:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:127:0x0300  */
    /* JADX WARN: Code duplicated, block: B:128:0x0302  */
    /* JADX WARN: Code duplicated, block: B:131:0x0309  */
    /* JADX WARN: Code duplicated, block: B:133:0x0311  */
    /* JADX WARN: Code duplicated, block: B:136:0x032d  */
    /* JADX WARN: Code duplicated, block: B:137:0x032f  */
    /* JADX WARN: Code duplicated, block: B:140:0x0336  */
    /* JADX WARN: Code duplicated, block: B:142:0x033e  */
    /* JADX WARN: Code duplicated, block: B:144:0x0361  */
    /* JADX WARN: Code duplicated, block: B:147:0x0371  */
    /* JADX WARN: Code duplicated, block: B:149:0x038a  */
    /* JADX WARN: Code duplicated, block: B:150:0x038c  */
    /* JADX WARN: Code duplicated, block: B:153:0x0393  */
    /* JADX WARN: Code duplicated, block: B:155:0x039b  */
    /* JADX WARN: Code duplicated, block: B:158:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:159:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:162:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:164:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:167:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:168:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:171:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:173:0x0405  */
    /* JADX WARN: Code duplicated, block: B:175:0x0439  */
    /* JADX WARN: Code duplicated, block: B:178:0x0458  */
    /* JADX WARN: Code duplicated, block: B:180:0x046e  */
    /* JADX WARN: Code duplicated, block: B:181:0x0470  */
    /* JADX WARN: Code duplicated, block: B:184:0x0477  */
    /* JADX WARN: Code duplicated, block: B:186:0x047f  */
    /* JADX WARN: Code duplicated, block: B:188:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:191:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:192:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:195:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:197:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:200:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:201:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:204:0x050b  */
    /* JADX WARN: Code duplicated, block: B:206:0x0513  */
    /* JADX WARN: Code duplicated, block: B:209:0x0534  */
    /* JADX WARN: Code duplicated, block: B:210:0x0536  */
    /* JADX WARN: Code duplicated, block: B:213:0x0542  */
    /* JADX WARN: Code duplicated, block: B:215:0x054a  */
    /* JADX WARN: Code duplicated, block: B:218:0x0572  */
    /* JADX WARN: Code duplicated, block: B:219:0x0574  */
    /* JADX WARN: Code duplicated, block: B:222:0x057b  */
    /* JADX WARN: Code duplicated, block: B:224:0x0583  */
    /* JADX WARN: Code duplicated, block: B:227:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:229:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:232:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:56:0x00af  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:70:0x010b  */
    /* JADX WARN: Code duplicated, block: B:72:0x0118  */
    /* JADX WARN: Code duplicated, block: B:74:0x011e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0127  */
    /* JADX WARN: Code duplicated, block: B:79:0x013a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0185  */
    /* JADX WARN: Code duplicated, block: B:84:0x0191  */
    /* JADX WARN: Code duplicated, block: B:85:0x0195  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:94:0x0206  */
    /* JADX WARN: Code duplicated, block: B:95:0x0208  */
    /* JADX WARN: Code duplicated, block: B:98:0x020f  */
    public static final void FilesFabComponent(final Store<FilesFabReducer.State, FilesFabReducer.Action> store, final SnackbarHostState snackbarHostState, final Function1<? super String, Unit> onCreateNewDocumentClicked, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        boolean z3;
        final Function1<? super String, Unit> function1;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier modifier3;
        boolean z5;
        final boolean z6;
        final State stateCollectAsStateWithLifecycle;
        final Activity activity;
        Function0<ComposeUiNode> constructor;
        boolean z7;
        int i7;
        boolean z8;
        Object objRememberedValue;
        Composer composer2;
        int i8;
        Activity activity2;
        final Store<FilesFabReducer.State, FilesFabReducer.Action> store2;
        String str;
        final State state;
        String str2;
        boolean z9;
        boolean z10;
        Object objRememberedValue2;
        boolean z11;
        final Activity activity3;
        boolean zChangedInstance;
        Object objRememberedValue3;
        boolean z12;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        boolean z13;
        Object objRememberedValue5;
        boolean z14;
        Object objRememberedValue6;
        boolean z15;
        Object objRememberedValue7;
        boolean z16;
        Object objRememberedValue8;
        boolean z17;
        Object objRememberedValue9;
        boolean z18;
        Object objRememberedValue10;
        boolean z19;
        Object objRememberedValue11;
        boolean z20;
        Object objRememberedValue12;
        boolean z21;
        Object objRememberedValue13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup3;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onCreateNewDocumentClicked, "onCreateNewDocumentClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1141563538);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesFabComponent)N(store,snackbarHostState,onCreateNewDocumentClicked,modifier,isVisible)69@3259L29,71@3323L7,77@3400L1104,153@6580L229,153@6496L313,160@6923L292,160@6839L376,167@7331L293,167@7247L377,182@7955L60,175@7630L391:FilesFabComponent.kt#oln4ex");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCreateNewDocumentClicked) ? 256 : 128;
        }
        int i9 = i2 & 8;
        if (i9 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i3;
                if ((i6 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                    function1 = onCreateNewDocumentClicked;
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1141563538, i6, -1, "com.box.android.browse.cpl.browse.fab.FilesFabComponent (FilesFabComponent.kt:68)");
                    }
                    z6 = z5;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localActivity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    activity = (Activity) objConsume;
                    if (activity == null) {
                        if (!FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isInitialized()) {
                            Modifier modifier4 = modifier3;
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1803243222, "C82@3597L47,79@3485L77,78@3449L316:FilesFabComponent.kt#oln4ex");
                            String strStringResource = StringResources_androidKt.stringResource(R.string.fab_talkback_label_add, composerStartRestartGroup, 0);
                            if (z6 || !FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isFabVisible()) {
                                z7 = false;
                            } else {
                                z7 = true;
                            }
                            Modifier modifierBoxFabButtonDefaultModifier = BoxFabButtonKt.boxFabButtonDefaultModifier(boxScopeInstance);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1028000641, "CC(remember):FilesFabComponent.kt#9igjgp");
                            i7 = i6 & 14;
                            if (i7 == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxFabButtonKt.BoxFabButton((Function0) objRememberedValue, strStringResource, modifierBoxFabButtonDefaultModifier, z7, null, composerStartRestartGroup, 0, 16);
                            composer2 = composerStartRestartGroup;
                            if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isMenuExpanded()) {
                                composer2.startReplaceGroup(1799788302);
                            } else {
                                composer2.startReplaceGroup(1803581493);
                                ComposerKt.sourceInformation(composer2, "88@3831L55,90@3970L91,90@3955L106,94@4115L373,89@3899L589");
                                ComposerKt.sourceInformationMarkerStart(composer2, 1028011691, "CC(remember):FilesFabComponent.kt#9igjgp");
                                if (i7 == 4) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                objRememberedValue12 = composer2.rememberedValue();
                                if (!z20 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue12 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda9
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$3$1$0(store);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue12);
                                }
                                final Function0 function0 = (Function0) objRememberedValue12;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1028016175, "CC(remember):FilesFabComponent.kt#9igjgp");
                                if (i7 == 4) {
                                    z21 = true;
                                } else {
                                    z21 = false;
                                }
                                objRememberedValue13 = composer2.rememberedValue();
                                if (!z21 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue13 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$3$2$0(store);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue13);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                FabMenuBottomSheet(AnalyticsUtilsKt.trackOnVisible(companion, null, (Function0) objRememberedValue13, composer2, 6, 1), function0, ComposableLambdaKt.rememberComposableLambda(-1671319556, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$3(function0, store, activity, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54), composer2, 384, 0);
                            }
                            composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isUploadContentMenuVisible()) {
                                composer2.startReplaceGroup(-771258060);
                            } else {
                                composer2.startReplaceGroup(-766726294);
                                ComposerKt.sourceInformation(composer2, "109@4625L90,109@4610L105,112@4741L88,113@4840L320,108@4558L602");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, -1825846488, "CC(remember):FilesFabComponent.kt#9igjgp");
                                if (i7 == 4) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                objRememberedValue10 = composer2.rememberedValue();
                                if (!z18 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue10 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda13
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$4$0(store);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue10);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                Modifier modifierTrackOnVisible = AnalyticsUtilsKt.trackOnVisible(companion2, null, (Function0) objRememberedValue10, composer2, 6, 1);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1825842778, "CC(remember):FilesFabComponent.kt#9igjgp");
                                if (i7 == 4) {
                                    z19 = true;
                                } else {
                                    z19 = false;
                                }
                                objRememberedValue11 = composer2.rememberedValue();
                                if (!z19 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue11 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$5$0(store);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue11);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                FabMenuBottomSheet(modifierTrackOnVisible, (Function0) objRememberedValue11, ComposableLambdaKt.rememberComposableLambda(-1773197139, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$6(store, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54), composer2, 384, 0);
                            }
                            composer2.endReplaceGroup();
                            if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isStorageAccessDialogVisible()) {
                                i8 = -771258060;
                                activity2 = activity;
                                store2 = store;
                                str = "CC(remember):FilesFabComponent.kt#9igjgp";
                                composer2.startReplaceGroup(-771258060);
                            } else {
                                composer2.startReplaceGroup(-766063793);
                                ComposerKt.sourceInformation(composer2, "129@5499L73,133@5714L67,136@5870L67,124@5222L725");
                                int i10 = R.string.job_item_error_type_permission;
                                int i11 = R.string.Please_grant_permission_in_settings;
                                int i12 = R.string.account_settings;
                                ComposerKt.sourceInformationMarkerStart(composer2, -1825818537, "CC(remember):FilesFabComponent.kt#9igjgp");
                                if (i7 == 4) {
                                    z15 = true;
                                } else {
                                    z15 = false;
                                }
                                objRememberedValue7 = composer2.rememberedValue();
                                if (!z15 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue7 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$7$0(store);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue7, i12, 1, null);
                                int i13 = R.string.dismiss;
                                ComposerKt.sourceInformationMarkerStart(composer2, -1825811663, "CC(remember):FilesFabComponent.kt#9igjgp");
                                if (i7 == 4) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                objRememberedValue8 = composer2.rememberedValue();
                                if (!z16 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue8 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda33
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$8$0(store);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue8);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ButtonItem.TextButtonItem textButtonItem2 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue8, i13, 1, null);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1825806671, "CC(remember):FilesFabComponent.kt#9igjgp");
                                if (i7 == 4) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                objRememberedValue9 = composer2.rememberedValue();
                                if (!z17 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue9 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda34
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$9$0(store);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue9);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                store2 = store;
                                str = "CC(remember):FilesFabComponent.kt#9igjgp";
                                i8 = -771258060;
                                activity2 = activity;
                                BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i10, i11, textButtonItem, textButtonItem2, "StoragePermissionDialog", (Function0) objRememberedValue9, 0L, 0L, composer2, 24576, 192);
                                composer2 = composer2;
                            }
                            composer2.endReplaceGroup();
                            if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).getCreateNewDocumentMenuState().isVisible()) {
                                function1 = onCreateNewDocumentClicked;
                                state = stateCollectAsStateWithLifecycle;
                                str2 = str;
                                z9 = true;
                                composer2.startReplaceGroup(i8);
                            } else {
                                composer2.startReplaceGroup(-765284236);
                                ComposerKt.sourceInformation(composer2, "141@6033L69,142@6153L296,142@6111L338");
                                str2 = str;
                                ComposerKt.sourceInformationMarkerStart(composer2, -1825801453, str2);
                                if (i7 == 4) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                objRememberedValue6 = composer2.rememberedValue();
                                if (!z14 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda35
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return FilesFabComponentKt.FilesFabComponent$lambda$10$0(store2);
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue6);
                                }
                                final Function0 function2 = (Function0) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                function1 = onCreateNewDocumentClicked;
                                state = stateCollectAsStateWithLifecycle;
                                z9 = true;
                                FabMenuBottomSheet(null, function2, ComposableLambdaKt.rememberComposableLambda(157928495, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$11(function2, function1, state, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composer2, 54), composer2, 384, 1);
                            }
                            composer2.endReplaceGroup();
                            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825783789, str2);
                            if (r11 == 4) {
                                z10 = z9;
                            } else {
                                z10 = false;
                            }
                            objRememberedValue2 = composer2.rememberedValue();
                            if (!z10 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$12$0(store2, (ActivityResult) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue2, composer2, 0);
                            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825772750, str2);
                            if (r11 == 4) {
                                z11 = z9;
                            } else {
                                z11 = false;
                            }
                            activity3 = activity2;
                            zChangedInstance = composer2.changedInstance(activity3) | z11;
                            objRememberedValue3 = composer2.rememberedValue();
                            if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$13$0(store2, activity3, (ActivityResult) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult2, (Function1) objRememberedValue3, composer2, 0);
                            ActivityResultContracts.StartActivityForResult startActivityForResult3 = new ActivityResultContracts.StartActivityForResult();
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825759693, str2);
                            if (r11 == 4) {
                                z12 = z9;
                            } else {
                                z12 = false;
                            }
                            zChangedInstance2 = composer2.changedInstance(activity3) | z12;
                            objRememberedValue4 = composer2.rememberedValue();
                            if (!zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$14$0(store2, activity3, (ActivityResult) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult3, (Function1) objRememberedValue4, composer2, 0);
                            FilesFabReducer.ViewEffect viewEffect = FilesFabComponent$lambda$0(state).getViewEffect();
                            ManagedActivityResultLauncher managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult2;
                            ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncherRememberLauncherForActivityResult3;
                            ManagedActivityResultLauncher managedActivityResultLauncher3 = managedActivityResultLauncherRememberLauncherForActivityResult;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825739958, str2);
                            if (r11 == 4) {
                                z13 = z9;
                            } else {
                                z13 = false;
                            }
                            objRememberedValue5 = composer2.rememberedValue();
                            if (!z13 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$15$0(store2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Composer composer3 = composer2;
                            ViewEffectProcessor(viewEffect, snackbarHostState, managedActivityResultLauncher, managedActivityResultLauncher2, managedActivityResultLauncher3, activity3, (Function0) objRememberedValue5, composer3, (i6 & 112) | (ManagedActivityResultLauncher.$stable << 6) | (ManagedActivityResultLauncher.$stable << 9) | (ManagedActivityResultLauncher.$stable << 12));
                            composerStartRestartGroup = composer3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z6;
                            modifier2 = modifier4;
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup2 != null) {
                                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$2(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup3 != null) {
                            scopeUpdateScopeEndRestartGroup3.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda32
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$1(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier5 = modifier2;
                    final Function1<? super String, Unit> function3 = function1;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FilesFabComponentKt.FilesFabComponent$lambda$16(store, snackbarHostState, function3, modifier5, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            i6 = i3;
            if ((i6 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                function1 = onCreateNewDocumentClicked;
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1141563538, i6, -1, "com.box.android.browse.cpl.browse.fab.FilesFabComponent (FilesFabComponent.kt:68)");
                }
                z6 = z5;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localActivity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                activity = (Activity) objConsume2;
                if (activity == null) {
                    if (!FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isInitialized()) {
                        Modifier modifier6 = modifier3;
                        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier6, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
                        Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1803243222, "C82@3597L47,79@3485L77,78@3449L316:FilesFabComponent.kt#oln4ex");
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.fab_talkback_label_add, composerStartRestartGroup, 0);
                        if (z6) {
                            z7 = false;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierBoxFabButtonDefaultModifier2 = BoxFabButtonKt.boxFabButtonDefaultModifier(boxScopeInstance2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1028000641, "CC(remember):FilesFabComponent.kt#9igjgp");
                        i7 = i6 & 14;
                        if (i7 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxFabButtonKt.BoxFabButton((Function0) objRememberedValue, strStringResource2, modifierBoxFabButtonDefaultModifier2, z7, null, composerStartRestartGroup, 0, 16);
                        composer2 = composerStartRestartGroup;
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isMenuExpanded()) {
                            composer2.startReplaceGroup(1799788302);
                        } else {
                            composer2.startReplaceGroup(1803581493);
                            ComposerKt.sourceInformation(composer2, "88@3831L55,90@3970L91,90@3955L106,94@4115L373,89@3899L589");
                            ComposerKt.sourceInformationMarkerStart(composer2, 1028011691, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue12 = composer2.rememberedValue();
                            if (!z20) {
                                objRememberedValue12 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$1$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue12);
                            } else {
                                objRememberedValue12 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$1$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue12);
                            }
                            final Function0 function4 = (Function0) objRememberedValue12;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1028016175, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            objRememberedValue13 = composer2.rememberedValue();
                            if (!z21) {
                                objRememberedValue13 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$2$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue13);
                            } else {
                                objRememberedValue13 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$2$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue13);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            FabMenuBottomSheet(AnalyticsUtilsKt.trackOnVisible(companion3, null, (Function0) objRememberedValue13, composer2, 6, 1), function4, ComposableLambdaKt.rememberComposableLambda(-1671319556, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$3(function4, store, activity, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), composer2, 384, 0);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isUploadContentMenuVisible()) {
                            composer2.startReplaceGroup(-771258060);
                        } else {
                            composer2.startReplaceGroup(-766726294);
                            ComposerKt.sourceInformation(composer2, "109@4625L90,109@4610L105,112@4741L88,113@4840L320,108@4558L602");
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825846488, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            objRememberedValue10 = composer2.rememberedValue();
                            if (!z18) {
                                objRememberedValue10 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$4$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue10);
                            } else {
                                objRememberedValue10 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$4$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue10);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Modifier modifierTrackOnVisible2 = AnalyticsUtilsKt.trackOnVisible(companion4, null, (Function0) objRememberedValue10, composer2, 6, 1);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825842778, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            objRememberedValue11 = composer2.rememberedValue();
                            if (!z19) {
                                objRememberedValue11 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$5$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue11);
                            } else {
                                objRememberedValue11 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$5$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue11);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            FabMenuBottomSheet(modifierTrackOnVisible2, (Function0) objRememberedValue11, ComposableLambdaKt.rememberComposableLambda(-1773197139, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$6(store, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), composer2, 384, 0);
                        }
                        composer2.endReplaceGroup();
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isStorageAccessDialogVisible()) {
                            i8 = -771258060;
                            activity2 = activity;
                            store2 = store;
                            str = "CC(remember):FilesFabComponent.kt#9igjgp";
                            composer2.startReplaceGroup(-771258060);
                        } else {
                            composer2.startReplaceGroup(-766063793);
                            ComposerKt.sourceInformation(composer2, "129@5499L73,133@5714L67,136@5870L67,124@5222L725");
                            int i14 = R.string.job_item_error_type_permission;
                            int i15 = R.string.Please_grant_permission_in_settings;
                            int i16 = R.string.account_settings;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825818537, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            objRememberedValue7 = composer2.rememberedValue();
                            if (!z15) {
                                objRememberedValue7 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$7$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            } else {
                                objRememberedValue7 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$7$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ButtonItem.TextButtonItem textButtonItem3 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue7, i16, 1, null);
                            int i17 = R.string.dismiss;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825811663, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            objRememberedValue8 = composer2.rememberedValue();
                            if (!z16) {
                                objRememberedValue8 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda33
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$8$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue8);
                            } else {
                                objRememberedValue8 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda33
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$8$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue8);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ButtonItem.TextButtonItem textButtonItem4 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue8, i17, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825806671, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            objRememberedValue9 = composer2.rememberedValue();
                            if (!z17) {
                                objRememberedValue9 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda34
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$9$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda34
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$9$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue9);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            store2 = store;
                            str = "CC(remember):FilesFabComponent.kt#9igjgp";
                            i8 = -771258060;
                            activity2 = activity;
                            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i14, i15, textButtonItem3, textButtonItem4, "StoragePermissionDialog", (Function0) objRememberedValue9, 0L, 0L, composer2, 24576, 192);
                            composer2 = composer2;
                        }
                        composer2.endReplaceGroup();
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).getCreateNewDocumentMenuState().isVisible()) {
                            function1 = onCreateNewDocumentClicked;
                            state = stateCollectAsStateWithLifecycle;
                            str2 = str;
                            z9 = true;
                            composer2.startReplaceGroup(i8);
                        } else {
                            composer2.startReplaceGroup(-765284236);
                            ComposerKt.sourceInformation(composer2, "141@6033L69,142@6153L296,142@6111L338");
                            str2 = str;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825801453, str2);
                            if (i7 == 4) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue6 = composer2.rememberedValue();
                            if (!z14) {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda35
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$10$0(store2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda35
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$10$0(store2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue6);
                            }
                            final Function0 function5 = (Function0) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            function1 = onCreateNewDocumentClicked;
                            state = stateCollectAsStateWithLifecycle;
                            z9 = true;
                            FabMenuBottomSheet(null, function5, ComposableLambdaKt.rememberComposableLambda(157928495, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$11(function5, function1, state, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), composer2, 384, 1);
                        }
                        composer2.endReplaceGroup();
                        ActivityResultContracts.StartActivityForResult startActivityForResult4 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825783789, str2);
                        if (r11 == 4) {
                            z10 = z9;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue2 = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$12$0(store2, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$12$0(store2, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult4 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult4, (Function1) objRememberedValue2, composer2, 0);
                        ActivityResultContracts.StartActivityForResult startActivityForResult5 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825772750, str2);
                        if (r11 == 4) {
                            z11 = z9;
                        } else {
                            z11 = false;
                        }
                        activity3 = activity2;
                        zChangedInstance = composer2.changedInstance(activity3) | z11;
                        objRememberedValue3 = composer2.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$13$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$13$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult5 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult5, (Function1) objRememberedValue3, composer2, 0);
                        ActivityResultContracts.StartActivityForResult startActivityForResult6 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825759693, str2);
                        if (r11 == 4) {
                            z12 = z9;
                        } else {
                            z12 = false;
                        }
                        zChangedInstance2 = composer2.changedInstance(activity3) | z12;
                        objRememberedValue4 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$14$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$14$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult6 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult6, (Function1) objRememberedValue4, composer2, 0);
                        FilesFabReducer.ViewEffect viewEffect2 = FilesFabComponent$lambda$0(state).getViewEffect();
                        ManagedActivityResultLauncher managedActivityResultLauncher4 = managedActivityResultLauncherRememberLauncherForActivityResult5;
                        ManagedActivityResultLauncher managedActivityResultLauncher5 = managedActivityResultLauncherRememberLauncherForActivityResult6;
                        ManagedActivityResultLauncher managedActivityResultLauncher6 = managedActivityResultLauncherRememberLauncherForActivityResult4;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825739958, str2);
                        if (r11 == 4) {
                            z13 = z9;
                        } else {
                            z13 = false;
                        }
                        objRememberedValue5 = composer2.rememberedValue();
                        if (!z13) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$15$0(store2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$15$0(store2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Composer composer4 = composer2;
                        ViewEffectProcessor(viewEffect2, snackbarHostState, managedActivityResultLauncher4, managedActivityResultLauncher5, managedActivityResultLauncher6, activity3, (Function0) objRememberedValue5, composer4, (i6 & 112) | (ManagedActivityResultLauncher.$stable << 6) | (ManagedActivityResultLauncher.$stable << 9) | (ManagedActivityResultLauncher.$stable << 12));
                        composerStartRestartGroup = composer4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z6;
                        modifier2 = modifier6;
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$2(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup3 != null) {
                        scopeUpdateScopeEndRestartGroup3.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda32
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$1(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier7 = modifier2;
                final Function1 function6 = function1;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesFabComponentKt.FilesFabComponent$lambda$16(store, snackbarHostState, function6, modifier7, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i3;
            if ((i6 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
                function1 = onCreateNewDocumentClicked;
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1141563538, i6, -1, "com.box.android.browse.cpl.browse.fab.FilesFabComponent (FilesFabComponent.kt:68)");
                }
                z6 = z5;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ProvidableCompositionLocal<Activity> localActivity3 = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localActivity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                activity = (Activity) objConsume3;
                if (activity == null) {
                    if (!FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isInitialized()) {
                        Modifier modifier8 = modifier3;
                        Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier8, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
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
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1803243222, "C82@3597L47,79@3485L77,78@3449L316:FilesFabComponent.kt#oln4ex");
                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.fab_talkback_label_add, composerStartRestartGroup, 0);
                        if (z6) {
                            z7 = false;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierBoxFabButtonDefaultModifier3 = BoxFabButtonKt.boxFabButtonDefaultModifier(boxScopeInstance3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1028000641, "CC(remember):FilesFabComponent.kt#9igjgp");
                        i7 = i6 & 14;
                        if (i7 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxFabButtonKt.BoxFabButton((Function0) objRememberedValue, strStringResource3, modifierBoxFabButtonDefaultModifier3, z7, null, composerStartRestartGroup, 0, 16);
                        composer2 = composerStartRestartGroup;
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isMenuExpanded()) {
                            composer2.startReplaceGroup(1799788302);
                        } else {
                            composer2.startReplaceGroup(1803581493);
                            ComposerKt.sourceInformation(composer2, "88@3831L55,90@3970L91,90@3955L106,94@4115L373,89@3899L589");
                            ComposerKt.sourceInformationMarkerStart(composer2, 1028011691, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            objRememberedValue12 = composer2.rememberedValue();
                            if (!z20) {
                                objRememberedValue12 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$1$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue12);
                            } else {
                                objRememberedValue12 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$1$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue12);
                            }
                            final Function0 function7 = (Function0) objRememberedValue12;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Modifier.Companion companion5 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1028016175, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            objRememberedValue13 = composer2.rememberedValue();
                            if (!z21) {
                                objRememberedValue13 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$2$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue13);
                            } else {
                                objRememberedValue13 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$3$2$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue13);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            FabMenuBottomSheet(AnalyticsUtilsKt.trackOnVisible(companion5, null, (Function0) objRememberedValue13, composer2, 6, 1), function7, ComposableLambdaKt.rememberComposableLambda(-1671319556, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$3(function7, store, activity, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), composer2, 384, 0);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isUploadContentMenuVisible()) {
                            composer2.startReplaceGroup(-771258060);
                        } else {
                            composer2.startReplaceGroup(-766726294);
                            ComposerKt.sourceInformation(composer2, "109@4625L90,109@4610L105,112@4741L88,113@4840L320,108@4558L602");
                            Modifier.Companion companion6 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825846488, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            objRememberedValue10 = composer2.rememberedValue();
                            if (!z18) {
                                objRememberedValue10 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$4$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue10);
                            } else {
                                objRememberedValue10 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$4$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue10);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            Modifier modifierTrackOnVisible3 = AnalyticsUtilsKt.trackOnVisible(companion6, null, (Function0) objRememberedValue10, composer2, 6, 1);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825842778, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            objRememberedValue11 = composer2.rememberedValue();
                            if (!z19) {
                                objRememberedValue11 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$5$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue11);
                            } else {
                                objRememberedValue11 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$5$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue11);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            FabMenuBottomSheet(modifierTrackOnVisible3, (Function0) objRememberedValue11, ComposableLambdaKt.rememberComposableLambda(-1773197139, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$6(store, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), composer2, 384, 0);
                        }
                        composer2.endReplaceGroup();
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isStorageAccessDialogVisible()) {
                            i8 = -771258060;
                            activity2 = activity;
                            store2 = store;
                            str = "CC(remember):FilesFabComponent.kt#9igjgp";
                            composer2.startReplaceGroup(-771258060);
                        } else {
                            composer2.startReplaceGroup(-766063793);
                            ComposerKt.sourceInformation(composer2, "129@5499L73,133@5714L67,136@5870L67,124@5222L725");
                            int i18 = R.string.job_item_error_type_permission;
                            int i19 = R.string.Please_grant_permission_in_settings;
                            int i110 = R.string.account_settings;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825818537, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z15 = true;
                            } else {
                                z15 = false;
                            }
                            objRememberedValue7 = composer2.rememberedValue();
                            if (!z15) {
                                objRememberedValue7 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$7$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            } else {
                                objRememberedValue7 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$7$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ButtonItem.TextButtonItem textButtonItem5 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue7, i110, 1, null);
                            int i111 = R.string.dismiss;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825811663, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            objRememberedValue8 = composer2.rememberedValue();
                            if (!z16) {
                                objRememberedValue8 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda33
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$8$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue8);
                            } else {
                                objRememberedValue8 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda33
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$8$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue8);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ButtonItem.TextButtonItem textButtonItem6 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue8, i111, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825806671, "CC(remember):FilesFabComponent.kt#9igjgp");
                            if (i7 == 4) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            objRememberedValue9 = composer2.rememberedValue();
                            if (!z17) {
                                objRememberedValue9 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda34
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$9$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue9);
                            } else {
                                objRememberedValue9 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda34
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$9$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue9);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            store2 = store;
                            str = "CC(remember):FilesFabComponent.kt#9igjgp";
                            i8 = -771258060;
                            activity2 = activity;
                            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i18, i19, textButtonItem5, textButtonItem6, "StoragePermissionDialog", (Function0) objRememberedValue9, 0L, 0L, composer2, 24576, 192);
                            composer2 = composer2;
                        }
                        composer2.endReplaceGroup();
                        if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).getCreateNewDocumentMenuState().isVisible()) {
                            function1 = onCreateNewDocumentClicked;
                            state = stateCollectAsStateWithLifecycle;
                            str2 = str;
                            z9 = true;
                            composer2.startReplaceGroup(i8);
                        } else {
                            composer2.startReplaceGroup(-765284236);
                            ComposerKt.sourceInformation(composer2, "141@6033L69,142@6153L296,142@6111L338");
                            str2 = str;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1825801453, str2);
                            if (i7 == 4) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            objRememberedValue6 = composer2.rememberedValue();
                            if (!z14) {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda35
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$10$0(store2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda35
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return FilesFabComponentKt.FilesFabComponent$lambda$10$0(store2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue6);
                            }
                            final Function0 function8 = (Function0) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            function1 = onCreateNewDocumentClicked;
                            state = stateCollectAsStateWithLifecycle;
                            z9 = true;
                            FabMenuBottomSheet(null, function8, ComposableLambdaKt.rememberComposableLambda(157928495, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$11(function8, function1, state, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composer2, 54), composer2, 384, 1);
                        }
                        composer2.endReplaceGroup();
                        ActivityResultContracts.StartActivityForResult startActivityForResult7 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825783789, str2);
                        if (r11 == 4) {
                            z10 = z9;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue2 = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$12$0(store2, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$12$0(store2, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult7 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult7, (Function1) objRememberedValue2, composer2, 0);
                        ActivityResultContracts.StartActivityForResult startActivityForResult8 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825772750, str2);
                        if (r11 == 4) {
                            z11 = z9;
                        } else {
                            z11 = false;
                        }
                        activity3 = activity2;
                        zChangedInstance = composer2.changedInstance(activity3) | z11;
                        objRememberedValue3 = composer2.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$13$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$13$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult8 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult8, (Function1) objRememberedValue3, composer2, 0);
                        ActivityResultContracts.StartActivityForResult startActivityForResult9 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825759693, str2);
                        if (r11 == 4) {
                            z12 = z9;
                        } else {
                            z12 = false;
                        }
                        zChangedInstance2 = composer2.changedInstance(activity3) | z12;
                        objRememberedValue4 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$14$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$14$0(store2, activity3, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult9 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult9, (Function1) objRememberedValue4, composer2, 0);
                        FilesFabReducer.ViewEffect viewEffect3 = FilesFabComponent$lambda$0(state).getViewEffect();
                        ManagedActivityResultLauncher managedActivityResultLauncher7 = managedActivityResultLauncherRememberLauncherForActivityResult8;
                        ManagedActivityResultLauncher managedActivityResultLauncher8 = managedActivityResultLauncherRememberLauncherForActivityResult9;
                        ManagedActivityResultLauncher managedActivityResultLauncher9 = managedActivityResultLauncherRememberLauncherForActivityResult7;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825739958, str2);
                        if (r11 == 4) {
                            z13 = z9;
                        } else {
                            z13 = false;
                        }
                        objRememberedValue5 = composer2.rememberedValue();
                        if (!z13) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$15$0(store2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$15$0(store2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Composer composer5 = composer2;
                        ViewEffectProcessor(viewEffect3, snackbarHostState, managedActivityResultLauncher7, managedActivityResultLauncher8, managedActivityResultLauncher9, activity3, (Function0) objRememberedValue5, composer5, (i6 & 112) | (ManagedActivityResultLauncher.$stable << 6) | (ManagedActivityResultLauncher.$stable << 9) | (ManagedActivityResultLauncher.$stable << 12));
                        composerStartRestartGroup = composer5;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z6;
                        modifier2 = modifier8;
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$2(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup3 != null) {
                        scopeUpdateScopeEndRestartGroup3.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda32
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$1(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier9 = modifier2;
                final Function1 function9 = function1;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesFabComponentKt.FilesFabComponent$lambda$16(store, snackbarHostState, function9, modifier9, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        i6 = i3;
        if ((i6 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i6 & 1)) {
            function1 = onCreateNewDocumentClicked;
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i9 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1141563538, i6, -1, "com.box.android.browse.cpl.browse.fab.FilesFabComponent (FilesFabComponent.kt:68)");
            }
            z6 = z5;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<Activity> localActivity4 = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localActivity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            activity = (Activity) objConsume4;
            if (activity == null) {
                if (!FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isInitialized()) {
                    Modifier modifier10 = modifier3;
                    Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(modifier10, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default4);
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
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1803243222, "C82@3597L47,79@3485L77,78@3449L316:FilesFabComponent.kt#oln4ex");
                    String strStringResource4 = StringResources_androidKt.stringResource(R.string.fab_talkback_label_add, composerStartRestartGroup, 0);
                    if (z6) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierBoxFabButtonDefaultModifier4 = BoxFabButtonKt.boxFabButtonDefaultModifier(boxScopeInstance4);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1028000641, "CC(remember):FilesFabComponent.kt#9igjgp");
                    i7 = i6 & 14;
                    if (i7 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesFabComponentKt.FilesFabComponent$lambda$3$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesFabComponentKt.FilesFabComponent$lambda$3$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxFabButtonKt.BoxFabButton((Function0) objRememberedValue, strStringResource4, modifierBoxFabButtonDefaultModifier4, z7, null, composerStartRestartGroup, 0, 16);
                    composer2 = composerStartRestartGroup;
                    if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isMenuExpanded()) {
                        composer2.startReplaceGroup(1799788302);
                    } else {
                        composer2.startReplaceGroup(1803581493);
                        ComposerKt.sourceInformation(composer2, "88@3831L55,90@3970L91,90@3955L106,94@4115L373,89@3899L589");
                        ComposerKt.sourceInformationMarkerStart(composer2, 1028011691, "CC(remember):FilesFabComponent.kt#9igjgp");
                        if (i7 == 4) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        objRememberedValue12 = composer2.rememberedValue();
                        if (!z20) {
                            objRememberedValue12 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$1$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue12);
                        } else {
                            objRememberedValue12 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$1$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue12);
                        }
                        final Function0 function10 = (Function0) objRememberedValue12;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier.Companion companion7 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1028016175, "CC(remember):FilesFabComponent.kt#9igjgp");
                        if (i7 == 4) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        objRememberedValue13 = composer2.rememberedValue();
                        if (!z21) {
                            objRememberedValue13 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$2$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue13);
                        } else {
                            objRememberedValue13 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$3$2$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue13);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        FabMenuBottomSheet(AnalyticsUtilsKt.trackOnVisible(companion7, null, (Function0) objRememberedValue13, composer2, 6, 1), function10, ComposableLambdaKt.rememberComposableLambda(-1671319556, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$3$3(function10, store, activity, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), composer2, 384, 0);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isUploadContentMenuVisible()) {
                        composer2.startReplaceGroup(-771258060);
                    } else {
                        composer2.startReplaceGroup(-766726294);
                        ComposerKt.sourceInformation(composer2, "109@4625L90,109@4610L105,112@4741L88,113@4840L320,108@4558L602");
                        Modifier.Companion companion8 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825846488, "CC(remember):FilesFabComponent.kt#9igjgp");
                        if (i7 == 4) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        objRememberedValue10 = composer2.rememberedValue();
                        if (!z18) {
                            objRememberedValue10 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$4$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue10);
                        } else {
                            objRememberedValue10 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$4$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue10);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierTrackOnVisible4 = AnalyticsUtilsKt.trackOnVisible(companion8, null, (Function0) objRememberedValue10, composer2, 6, 1);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825842778, "CC(remember):FilesFabComponent.kt#9igjgp");
                        if (i7 == 4) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        objRememberedValue11 = composer2.rememberedValue();
                        if (!z19) {
                            objRememberedValue11 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$5$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$5$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        FabMenuBottomSheet(modifierTrackOnVisible4, (Function0) objRememberedValue11, ComposableLambdaKt.rememberComposableLambda(-1773197139, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$6(store, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), composer2, 384, 0);
                    }
                    composer2.endReplaceGroup();
                    if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).isStorageAccessDialogVisible()) {
                        i8 = -771258060;
                        activity2 = activity;
                        store2 = store;
                        str = "CC(remember):FilesFabComponent.kt#9igjgp";
                        composer2.startReplaceGroup(-771258060);
                    } else {
                        composer2.startReplaceGroup(-766063793);
                        ComposerKt.sourceInformation(composer2, "129@5499L73,133@5714L67,136@5870L67,124@5222L725");
                        int i112 = R.string.job_item_error_type_permission;
                        int i113 = R.string.Please_grant_permission_in_settings;
                        int i114 = R.string.account_settings;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825818537, "CC(remember):FilesFabComponent.kt#9igjgp");
                        if (i7 == 4) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        objRememberedValue7 = composer2.rememberedValue();
                        if (!z15) {
                            objRememberedValue7 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$7$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        } else {
                            objRememberedValue7 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$7$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ButtonItem.TextButtonItem textButtonItem7 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue7, i114, 1, null);
                        int i115 = R.string.dismiss;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825811663, "CC(remember):FilesFabComponent.kt#9igjgp");
                        if (i7 == 4) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objRememberedValue8 = composer2.rememberedValue();
                        if (!z16) {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda33
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$8$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda33
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$8$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ButtonItem.TextButtonItem textButtonItem8 = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue8, i115, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825806671, "CC(remember):FilesFabComponent.kt#9igjgp");
                        if (i7 == 4) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        objRememberedValue9 = composer2.rememberedValue();
                        if (!z17) {
                            objRememberedValue9 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda34
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$9$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda34
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$9$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        store2 = store;
                        str = "CC(remember):FilesFabComponent.kt#9igjgp";
                        i8 = -771258060;
                        activity2 = activity;
                        BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i112, i113, textButtonItem7, textButtonItem8, "StoragePermissionDialog", (Function0) objRememberedValue9, 0L, 0L, composer2, 24576, 192);
                        composer2 = composer2;
                    }
                    composer2.endReplaceGroup();
                    if (FilesFabComponent$lambda$0(stateCollectAsStateWithLifecycle).getCreateNewDocumentMenuState().isVisible()) {
                        function1 = onCreateNewDocumentClicked;
                        state = stateCollectAsStateWithLifecycle;
                        str2 = str;
                        z9 = true;
                        composer2.startReplaceGroup(i8);
                    } else {
                        composer2.startReplaceGroup(-765284236);
                        ComposerKt.sourceInformation(composer2, "141@6033L69,142@6153L296,142@6111L338");
                        str2 = str;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1825801453, str2);
                        if (i7 == 4) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        objRememberedValue6 = composer2.rememberedValue();
                        if (!z14) {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda35
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$10$0(store2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda35
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FilesFabComponentKt.FilesFabComponent$lambda$10$0(store2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue6);
                        }
                        final Function0 function11 = (Function0) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        function1 = onCreateNewDocumentClicked;
                        state = stateCollectAsStateWithLifecycle;
                        z9 = true;
                        FabMenuBottomSheet(null, function11, ComposableLambdaKt.rememberComposableLambda(157928495, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$11(function11, function1, state, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), composer2, 384, 1);
                    }
                    composer2.endReplaceGroup();
                    ActivityResultContracts.StartActivityForResult startActivityForResult10 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1825783789, str2);
                    if (r11 == 4) {
                        z10 = z9;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue2 = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$12$0(store2, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$12$0(store2, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult10 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult10, (Function1) objRememberedValue2, composer2, 0);
                    ActivityResultContracts.StartActivityForResult startActivityForResult11 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1825772750, str2);
                    if (r11 == 4) {
                        z11 = z9;
                    } else {
                        z11 = false;
                    }
                    activity3 = activity2;
                    zChangedInstance = composer2.changedInstance(activity3) | z11;
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$13$0(store2, activity3, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$13$0(store2, activity3, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult11 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult11, (Function1) objRememberedValue3, composer2, 0);
                    ActivityResultContracts.StartActivityForResult startActivityForResult12 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -1825759693, str2);
                    if (r11 == 4) {
                        z12 = z9;
                    } else {
                        z12 = false;
                    }
                    zChangedInstance2 = composer2.changedInstance(activity3) | z12;
                    objRememberedValue4 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$14$0(store2, activity3, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$14$0(store2, activity3, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult12 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult12, (Function1) objRememberedValue4, composer2, 0);
                    FilesFabReducer.ViewEffect viewEffect4 = FilesFabComponent$lambda$0(state).getViewEffect();
                    ManagedActivityResultLauncher managedActivityResultLauncher10 = managedActivityResultLauncherRememberLauncherForActivityResult11;
                    ManagedActivityResultLauncher managedActivityResultLauncher11 = managedActivityResultLauncherRememberLauncherForActivityResult12;
                    ManagedActivityResultLauncher managedActivityResultLauncher12 = managedActivityResultLauncherRememberLauncherForActivityResult10;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1825739958, str2);
                    if (r11 == 4) {
                        z13 = z9;
                    } else {
                        z13 = false;
                    }
                    objRememberedValue5 = composer2.rememberedValue();
                    if (!z13) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesFabComponentKt.FilesFabComponent$lambda$15$0(store2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FilesFabComponentKt.FilesFabComponent$lambda$15$0(store2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer6 = composer2;
                    ViewEffectProcessor(viewEffect4, snackbarHostState, managedActivityResultLauncher10, managedActivityResultLauncher11, managedActivityResultLauncher12, activity3, (Function0) objRememberedValue5, composer6, (i6 & 112) | (ManagedActivityResultLauncher.$stable << 6) | (ManagedActivityResultLauncher.$stable << 9) | (ManagedActivityResultLauncher.$stable << 12));
                    composerStartRestartGroup = composer6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                    modifier2 = modifier10;
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FilesFabComponentKt.FilesFabComponent$lambda$2(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup3 != null) {
                    scopeUpdateScopeEndRestartGroup3.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FilesFabComponentKt.FilesFabComponent$lambda$1(store, snackbarHostState, onCreateNewDocumentClicked, modifier3, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier11 = modifier2;
            final Function1 function12 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesFabComponentKt.FilesFabComponent$lambda$16(store, snackbarHostState, function12, modifier11, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$3$0$0(Store store) {
        store.send(FilesFabReducer.Action.FabClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$3$1$0(Store store) {
        store.send(FilesFabReducer.Action.FabMenuDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$3$2$0(Store store) {
        store.send(FilesFabReducer.Action.FabContentViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$3$3(final Function0 function0, final Store store, final Activity activity, State state, ColumnScope FabMenuBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FabMenuBottomSheet, "$this$FabMenuBottomSheet");
        ComposerKt.sourceInformation(composer, "C98@4302L154,95@4133L341:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1671319556, i, -1, "com.box.android.browse.cpl.browse.fab.FilesFabComponent.<anonymous>.<anonymous> (FilesFabComponent.kt:95)");
            }
            FolderModel currentFolder = FilesFabComponent$lambda$0(state).getCurrentFolder();
            List<FilesFabReducer.FabMenuOption> menuOptions = FilesFabComponent$lambda$0(state).getMenuOptions();
            ComposerKt.sourceInformationMarkerStart(composer, 179681526, "CC(remember):FilesFabComponent.kt#9igjgp");
            boolean zChanged = composer.changed(function0) | composer.changed(store) | composer.changedInstance(activity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesFabComponentKt.FilesFabComponent$lambda$3$3$0$0(function0, store, activity, (FilesFabReducer.FabMenuOption) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FabOptionsBottomSheetContent(currentFolder, menuOptions, (Function1) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$3$3$0$0(Function0 function0, Store store, Activity activity, FilesFabReducer.FabMenuOption selectedOption) {
        Intrinsics.checkNotNullParameter(selectedOption, "selectedOption");
        function0.invoke();
        store.send(toOnClickAction(selectedOption, activity));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$4$0(Store store) {
        store.send(FilesFabReducer.Action.UploadContentMenuViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$5$0(Store store) {
        store.send(new FilesFabReducer.Action.UploadSelectionDismissed(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$6(final Store store, ColumnScope FabMenuBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FabMenuBottomSheet, "$this$FabMenuBottomSheet");
        ComposerKt.sourceInformation(composer, "C115@4933L203,114@4854L296:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1773197139, i, -1, "com.box.android.browse.cpl.browse.fab.FilesFabComponent.<anonymous> (FilesFabComponent.kt:114)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1059569112, "CC(remember):FilesFabComponent.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesFabComponentKt.FilesFabComponent$lambda$6$0$0(store, (FilesFabReducer.UploadType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            UploadContentOptionsBottomSheetContent((Function1) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$6$0$0(Store store, FilesFabReducer.UploadType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new FilesFabReducer.Action.UploadSelectionDismissed(false));
        store.send(new FilesFabReducer.Action.UploadTypeSelected(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$7$0(Store store) {
        store.send(FilesFabReducer.Action.StorageAccessDialogPositiveClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$8$0(Store store) {
        store.send(FilesFabReducer.Action.StorageAccessDialogDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$9$0(Store store) {
        store.send(FilesFabReducer.Action.StorageAccessDialogDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$10$0(Store store) {
        store.send(FilesFabReducer.Action.CreateNewDocumentMenuDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$11(final Function0 function0, final Function1 function1, State state, ColumnScope FabMenuBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FabMenuBottomSheet, "$this$FabMenuBottomSheet");
        ComposerKt.sourceInformation(composer, "C145@6313L112,143@6167L272:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(157928495, i, -1, "com.box.android.browse.cpl.browse.fab.FilesFabComponent.<anonymous> (FilesFabComponent.kt:143)");
            }
            List<NewFileType> menuItems = FilesFabComponent$lambda$0(state).getCreateNewDocumentMenuState().getMenuItems();
            ComposerKt.sourceInformationMarkerStart(composer, 1445433567, "CC(remember):FilesFabComponent.kt#9igjgp");
            boolean zChanged = composer.changed(function0) | composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesFabComponentKt.FilesFabComponent$lambda$11$0$0(function0, function1, (NewFileType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CreateFileOptionsBottomSheetContent(menuItems, (Function1) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$11$0$0(Function0 function0, Function1 function1, NewFileType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        function1.invoke(it.getAssetName());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$12$0(Store store, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (OSPermissionUtils.INSTANCE.hasStoragePermission(true)) {
            store.send(FilesFabReducer.Action.StorageAccessGranted.INSTANCE);
        } else {
            store.send(FilesFabReducer.Action.StorageAccessDenied.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$13$0(Store store, Activity activity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getData() != null) {
            Intent data = result.getData();
            Intrinsics.checkNotNull(data);
            store.send(new FilesFabReducer.Action.UploadDataSelected(activity, data, FilesFabReducer.UploadType.UPLOAD_FILES));
        } else {
            store.send(new FilesFabReducer.Action.UploadSelectionDismissed(true));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$14$0(Store store, Activity activity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getData() != null) {
            Intent data = result.getData();
            Intrinsics.checkNotNull(data);
            store.send(new FilesFabReducer.Action.UploadDataSelected(activity, data, FilesFabReducer.UploadType.UPLOAD_FOLDER));
        } else {
            store.send(new FilesFabReducer.Action.UploadSelectionDismissed(true));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesFabComponent$lambda$15$0(Store store) {
        store.send(FilesFabReducer.Action.OnViewEffectProcessed.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void FabOptionsBottomSheetContent(final FolderModel folder, final List<? extends FilesFabReducer.FabMenuOption> menuOptions, final Function1<? super FilesFabReducer.FabMenuOption, Unit> onOptionClick, Composer composer, final int i) {
        Composer composer2;
        String name;
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(menuOptions, "menuOptions");
        Intrinsics.checkNotNullParameter(onOptionClick, "onOptionClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1389668502);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FabOptionsBottomSheetContent)N(folder,menuOptions,onOptionClick)188@8180L1706:FilesFabComponent.kt#oln4ex");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(folder) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(menuOptions) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onOptionClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1389668502, i2, -1, "com.box.android.browse.cpl.browse.fab.FabOptionsBottomSheetContent (FilesFabComponent.kt:187)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -834476752, "C195@8367L70,197@8521L6,194@8342L415:FilesFabComponent.kt#oln4ex");
            if (folder.isRoot()) {
                composerStartRestartGroup.startReplaceGroup(-834486580);
                ComposerKt.sourceInformation(composerStartRestartGroup, "190@8252L30");
                name = StringResources_androidKt.stringResource(R.string.files, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-834427649);
                composerStartRestartGroup.endReplaceGroup();
                name = folder.getName();
            }
            int i3 = i2;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.fab_menu_title_add_to_folder, new Object[]{name}, composerStartRestartGroup, 0), PaddingKt.m1222paddingqDBjuR0$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(22), 0.0f, 2, null), 0.0f, Dp.m9687constructorimpl(6), 0.0f, Dp.m9687constructorimpl(16), 5, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9585getMiddleEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composerStartRestartGroup, 0, 24960, 110584);
            composerStartRestartGroup.startReplaceGroup(-26900594);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*227@9782L25,228@9834L22,206@8854L200,212@9089L645,205@8810L1060");
            for (final FilesFabReducer.FabMenuOption fabMenuOption : menuOptions) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2028958581, "CC(remember):FilesFabComponent.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(fabMenuOption.ordinal()) | ((i3 & 896) == 256);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesFabComponentKt.FabOptionsBottomSheetContent$lambda$0$0$0$0(onOptionClick, fabMenuOption);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(1852875198, true, new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesFabComponentKt.FabOptionsBottomSheetContent$lambda$0$0$1(fabMenuOption, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ClickableKt.m632clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue, 15, null), null, null, ComposableLambdaKt.rememberComposableLambda(-1345011654, true, new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesFabComponentKt.FabOptionsBottomSheetContent$lambda$0$0$2(fabMenuOption, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, createListItemColors(composerStartRestartGroup, 0), 0.0f, 0.0f, composerStartRestartGroup, 24582, HttpStatus.SC_PRECONDITION_REQUIRED);
            }
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesFabComponentKt.FabOptionsBottomSheetContent$lambda$1(folder, menuOptions, onOptionClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FabOptionsBottomSheetContent$lambda$0$0$1(FilesFabReducer.FabMenuOption fabMenuOption, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C208@8913L36,207@8876L160:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1852875198, i, -1, "com.box.android.browse.cpl.browse.fab.FabOptionsBottomSheetContent.<anonymous>.<anonymous>.<anonymous> (FilesFabComponent.kt:207)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(toStringRes(fabMenuOption), composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FabOptionsBottomSheetContent$lambda$0$0$2(FilesFabReducer.FabMenuOption fabMenuOption, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C217@9297L6,213@9111L605:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1345011654, i, -1, "com.box.android.browse.cpl.browse.fab.FabOptionsBottomSheetContent.<anonymous>.<anonymous>.<anonymous> (FilesFabComponent.kt:213)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11534getMainActiveControlBackground0d7_KjU(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 446948435, "C221@9476L35,222@9562L36,223@9644L6,220@9442L252:FilesFabComponent.kt#oln4ex");
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(toIconRes(fabMenuOption), composer, 0), StringResources_androidKt.stringResource(toStringRes(fabMenuOption), composer, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), composer, Painter.$stable, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FabOptionsBottomSheetContent$lambda$0$0$0$0(Function1 function1, FilesFabReducer.FabMenuOption fabMenuOption) {
        function1.invoke(fabMenuOption);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v18 */
    public static final void CreateFileOptionsBottomSheetContent(final List<? extends NewFileType> newFileTypes, final Function1<? super NewFileType, Unit> onFileTypeClick, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(newFileTypes, "newFileTypes");
        Intrinsics.checkNotNullParameter(onFileTypeClick, "onFileTypeClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2130201990);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateFileOptionsBottomSheetContent)N(newFileTypes,onFileTypeClick)236@10030L726:FilesFabComponent.kt#oln4ex");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(newFileTypes) ? 4 : 2) | i : i;
        int i3 = 32;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFileTypeClick) ? 32 : 16;
        }
        boolean z = true;
        int i4 = 0;
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2130201990, i2, -1, "com.box.android.browse.cpl.browse.fab.CreateFileOptionsBottomSheetContent (FilesFabComponent.kt:235)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1736306060, "C:FilesFabComponent.kt#oln4ex");
            composerStartRestartGroup.startReplaceGroup(-56009470);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*251@10648L29,252@10704L22,239@10138L202,245@10375L225,238@10094L646");
            for (final NewFileType newFileType : newFileTypes) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -938183028, "CC(remember):FilesFabComponent.kt#9igjgp");
                ?? r7 = ((i2 & 112) == i3 ? z : i4) | (composerStartRestartGroup.changed(newFileType.ordinal()) ? 1 : 0);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (r7 != 0 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesFabComponentKt.CreateFileOptionsBottomSheetContent$lambda$0$0$0$0(onFileTypeClick, newFileType);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(-1163594739, z, new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesFabComponentKt.CreateFileOptionsBottomSheetContent$lambda$0$0$1(newFileType, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ClickableKt.m632clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue, 15, null), null, null, ComposableLambdaKt.rememberComposableLambda(-931665647, z, new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesFabComponentKt.CreateFileOptionsBottomSheetContent$lambda$0$0$2(newFileType, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, createListItemColors(composerStartRestartGroup, i4), 0.0f, 0.0f, composerStartRestartGroup, 24582, HttpStatus.SC_PRECONDITION_REQUIRED);
                z = z;
                i4 = i4;
                i2 = i2;
                i3 = i3;
            }
            composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesFabComponentKt.CreateFileOptionsBottomSheetContent$lambda$1(newFileTypes, onFileTypeClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFileOptionsBottomSheetContent$lambda$0$0$1(NewFileType newFileType, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C241@10197L38,240@10160L162:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1163594739, i, -1, "com.box.android.browse.cpl.browse.fab.CreateFileOptionsBottomSheetContent.<anonymous>.<anonymous>.<anonymous> (FilesFabComponent.kt:240)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(toStringRes(newFileType), composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFileOptionsBottomSheetContent$lambda$0$0$2(NewFileType newFileType, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C247@10438L37,248@10522L38,246@10397L185:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-931665647, i, -1, "com.box.android.browse.cpl.browse.fab.CreateFileOptionsBottomSheetContent.<anonymous>.<anonymous>.<anonymous> (FilesFabComponent.kt:246)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(toIconRes(newFileType), composer, 0), StringResources_androidKt.stringResource(toStringRes(newFileType), composer, 0), (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateFileOptionsBottomSheetContent$lambda$0$0$0$0(Function1 function1, NewFileType newFileType) {
        function1.invoke(newFileType);
        return Unit.INSTANCE;
    }

    public static final void UploadContentOptionsBottomSheetContent(final Function1<? super FilesFabReducer.UploadType, Unit> onUploadTypeSelected, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onUploadTypeSelected, "onUploadTypeSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-751495802);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(UploadContentOptionsBottomSheetContent)N(onUploadTypeSelected)260@10874L773:FilesFabComponent.kt#oln4ex");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(onUploadTypeSelected) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-751495802, i2, -1, "com.box.android.browse.cpl.browse.fab.UploadContentOptionsBottomSheetContent (FilesFabComponent.kt:259)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1801743335, "C268@11156L49,269@11228L22,261@10891L369,279@11536L50,280@11609L22,272@11270L371:FilesFabComponent.kt#oln4ex");
            Function2<Composer, Integer, Unit> function2M12199getLambda$1333148454$browse_generalProdRelease = ComposableSingletons$FilesFabComponentKt.INSTANCE.m12199getLambda$1333148454$browse_generalProdRelease();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1305038963, "CC(remember):FilesFabComponent.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesFabComponentKt.UploadContentOptionsBottomSheetContent$lambda$0$0$0(onUploadTypeSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ListItemKt.m3695ListItemHXNGIdc(function2M12199getLambda$1333148454$browse_generalProdRelease, ClickableKt.m632clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue, 15, null), null, null, null, null, createListItemColors(composerStartRestartGroup, 0), 0.0f, 0.0f, composerStartRestartGroup, 6, 444);
            Function2<Composer, Integer, Unit> function2M12200getLambda$75142895$browse_generalProdRelease = ComposableSingletons$FilesFabComponentKt.INSTANCE.m12200getLambda$75142895$browse_generalProdRelease();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1305026802, "CC(remember):FilesFabComponent.kt#9igjgp");
            boolean z2 = i3 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesFabComponentKt.UploadContentOptionsBottomSheetContent$lambda$0$1$0(onUploadTypeSelected);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ListItemKt.m3695ListItemHXNGIdc(function2M12200getLambda$75142895$browse_generalProdRelease, ClickableKt.m632clickableoSLSa3U$default(companion3, false, null, null, null, (Function0) objRememberedValue2, 15, null), null, null, null, null, createListItemColors(composerStartRestartGroup, 0), 0.0f, 0.0f, composerStartRestartGroup, 6, 444);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesFabComponentKt.UploadContentOptionsBottomSheetContent$lambda$1(onUploadTypeSelected, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentOptionsBottomSheetContent$lambda$0$0$0(Function1 function1) {
        function1.invoke(FilesFabReducer.UploadType.UPLOAD_FILES);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UploadContentOptionsBottomSheetContent$lambda$0$1$0(Function1 function1) {
        function1.invoke(FilesFabReducer.UploadType.UPLOAD_FOLDER);
        return Unit.INSTANCE;
    }

    private static final void FabMenuBottomSheet(Modifier modifier, final Function0<Unit> function0, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-249861055);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FabMenuBottomSheet)N(modifier,onDismiss,content)288@11856L59,293@12073L6,294@12126L6,295@12155L197,289@11920L432:FilesFabComponent.kt#oln4ex");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249861055, i3, -1, "com.box.android.browse.cpl.browse.fab.FabMenuBottomSheet (FilesFabComponent.kt:287)");
            }
            composer2 = composerStartRestartGroup;
            BoxModalBottomSheetKt.m11602BoxModalBottomSheet4erKP6g(function0, modifier2, ModalBottomSheetKt.rememberModalBottomSheetState(true, null, composerStartRestartGroup, 6, 2), 0.0f, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11516getDialogContainer0d7_KjU(), 0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), ComposableLambdaKt.rememberComposableLambda(56236593, true, new Function3() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FilesFabComponentKt.FabMenuBottomSheet$lambda$0(function3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 12582912 | ((i3 << 3) & 112), 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier3 = modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesFabComponentKt.FabMenuBottomSheet$lambda$1(modifier3, function0, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FabMenuBottomSheet$lambda$0(Function3 function3, ColumnScope BoxModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BoxModalBottomSheet, "$this$BoxModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C299@12280L21,296@12165L181:FilesFabComponent.kt#oln4ex");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(56236593, i, -1, "com.box.android.browse.cpl.browse.fab.FabMenuBottomSheet.<anonymous> (FilesFabComponent.kt:296)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(16), 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1219165395, "C301@12327L9:FilesFabComponent.kt#oln4ex");
            function3.invoke(columnScopeInstance, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ViewEffectProcessor(final FilesFabReducer.ViewEffect viewEffect, final SnackbarHostState snackbarHostState, final ActivityResultLauncher<Intent> activityResultLauncher, final ActivityResultLauncher<Intent> activityResultLauncher2, final ActivityResultLauncher<Intent> activityResultLauncher3, final Activity activity, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        SnackbarHostState snackbarHostState2;
        Composer composerStartRestartGroup = composer.startRestartGroup(381767289);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ViewEffectProcessor)N(effect,snackbarHostState,filePickerLauncher,folderPickerLauncher,storageAccessRequestLauncher,activity,onProcessed)316@12809L7,317@12855L70,318@12953L1537,318@12930L1560:FilesFabComponent.kt#oln4ex");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(viewEffect) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            snackbarHostState2 = snackbarHostState;
            i2 |= composerStartRestartGroup.changed(snackbarHostState2) ? 32 : 16;
        } else {
            snackbarHostState2 = snackbarHostState;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(activityResultLauncher) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(activityResultLauncher2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(activityResultLauncher3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(activity) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(381767289, i2, -1, "com.box.android.browse.cpl.browse.fab.ViewEffectProcessor (FilesFabComponent.kt:315)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            String strStringResource = StringResources_androidKt.stringResource(R.string.Please_retry_operation_after_grant_permission, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1806164570, "CC(remember):FilesFabComponent.kt#9igjgp");
            int i3 = i2 & 14;
            boolean zChangedInstance = (i3 == 4) | composerStartRestartGroup.changedInstance(activityResultLauncher) | ((3670016 & i2) == 1048576) | composerStartRestartGroup.changedInstance(activityResultLauncher2) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(activity) | composerStartRestartGroup.changedInstance(activityResultLauncher3) | ((i2 & 112) == 32) | composerStartRestartGroup.changed(strStringResource);
            FilesFabComponentKt$ViewEffectProcessor$1$1 filesFabComponentKt$ViewEffectProcessor$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || filesFabComponentKt$ViewEffectProcessor$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                filesFabComponentKt$ViewEffectProcessor$1$1RememberedValue = new FilesFabComponentKt$ViewEffectProcessor$1$1(viewEffect, activityResultLauncher, function0, activityResultLauncher2, context, activityResultLauncher3, snackbarHostState2, strStringResource, activity, null);
                composerStartRestartGroup.updateRememberedValue(filesFabComponentKt$ViewEffectProcessor$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(viewEffect, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesFabComponentKt$ViewEffectProcessor$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.fab.FilesFabComponentKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesFabComponentKt.ViewEffectProcessor$lambda$1(viewEffect, snackbarHostState, activityResultLauncher, activityResultLauncher2, activityResultLauncher3, activity, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ListItemColors createListItemColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1035565328, "C(createListItemColors)362@14598L6,363@14651L6,361@14560L110:FilesFabComponent.kt#oln4ex");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1035565328, i, -1, "com.box.android.browse.cpl.browse.fab.createListItemColors (FilesFabComponent.kt:361)");
        }
        ListItemColors listItemColorsM3668colorsJ08w3E = ListItemDefaults.INSTANCE.m3668colorsJ08w3E(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, ListItemDefaults.$stable << 27, 508);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listItemColorsM3668colorsJ08w3E;
    }

    private static final int toStringRes(FilesFabReducer.FabMenuOption fabMenuOption) {
        int i = WhenMappings.$EnumSwitchMapping$0[fabMenuOption.ordinal()];
        if (i == 1) {
            return R.string.fab_create_folder;
        }
        if (i == 2) {
            return R.string.fab_create_document;
        }
        if (i == 3) {
            return R.string.add_from_library;
        }
        if (i == 4) {
            return R.string.new_media;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.fab_create_box_note;
    }

    private static final FilesFabReducer.Action toOnClickAction(FilesFabReducer.FabMenuOption fabMenuOption, Activity activity) {
        int i = WhenMappings.$EnumSwitchMapping$0[fabMenuOption.ordinal()];
        if (i == 1) {
            return new FilesFabReducer.Action.CreateNewFolderClicked(activity);
        }
        if (i == 2) {
            return new FilesFabReducer.Action.CreateNewDocumentClicked(activity);
        }
        if (i == 3) {
            return new FilesFabReducer.Action.UploadContentClicked(activity);
        }
        if (i == 4) {
            return new FilesFabReducer.Action.CaptureMediaClicked(activity);
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return new FilesFabReducer.Action.CreateNewBoxNoteClicked(activity);
    }

    private static final int toIconRes(FilesFabReducer.FabMenuOption fabMenuOption) {
        int i = WhenMappings.$EnumSwitchMapping$0[fabMenuOption.ordinal()];
        if (i == 1) {
            return R.drawable.ic_folder_outlined;
        }
        if (i == 2) {
            return R.drawable.ic_fab_action_document_updated;
        }
        if (i == 3) {
            return R.drawable.ic_fab_action_upload_content_updated;
        }
        if (i == 4) {
            return R.drawable.ic_fab_action_capture_media;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return R.drawable.ic_fab_action_boxnote_updated;
    }

    private static final int toStringRes(NewFileType newFileType) {
        int i = WhenMappings.$EnumSwitchMapping$1[newFileType.ordinal()];
        if (i == 1) {
            return com.box.android.base.R.string.doc_type_word_document;
        }
        if (i == 2) {
            return com.box.android.base.R.string.doc_type_powerpoint_presentation;
        }
        if (i == 3) {
            return com.box.android.base.R.string.doc_type_excel_spreadsheet;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return com.box.android.base.R.string.doc_type_text_document;
    }

    private static final int toIconRes(NewFileType newFileType) {
        int i = WhenMappings.$EnumSwitchMapping$1[newFileType.ordinal()];
        if (i == 1) {
            return com.box.android.base.R.drawable.ic_box_browsesdk_word;
        }
        if (i == 2) {
            return com.box.android.base.R.drawable.ic_box_browsesdk_presentation;
        }
        if (i == 3) {
            return com.box.android.base.R.drawable.ic_box_browsesdk_spreadsheet;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return com.box.android.base.R.drawable.ic_box_browsesdk_doc;
    }

    private static final FilesFabReducer.State FilesFabComponent$lambda$0(State<FilesFabReducer.State> state) {
        return state.getValue();
    }
}
