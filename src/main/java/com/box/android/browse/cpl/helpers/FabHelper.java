package com.box.android.browse.cpl.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.views.menu.UploadOptionsFragment;
import com.box.android.browse.R;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.browse.fab.FabManager;
import com.box.android.browse.cpl.browse.fab.FabMenuCaptureMediaOptionResult;
import com.box.android.browse.cpl.browse.fab.FabMenuOptionResult;
import com.box.android.browse.cpl.browse.fab.FabMenuUploadContentOptionResult;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.androidsdk.content.models.BoxFolder;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FabHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001-B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJH\u0010\u0015\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019j\u0002`\u001b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u0014JH\u0010\u001c\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0019j\u0002`\u001e2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u0014J,\u0010\u001f\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0018\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0019j\u0002`\u001eH\u0007J\u0012\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010$\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010%\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010&\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0012\u0010(\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0002J\n\u0010)\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u001a\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0002`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/box/android/browse/cpl/helpers/FabHelper;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "fabManager", "Lcom/box/android/browse/cpl/browse/fab/FabManager;", "activity", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/browse/cpl/browse/fab/FabManager;Lcom/box/android/base/presentation/activities/BoxFragmentActivity;)V", "floatingMenu", "Lcom/github/clans/fab/FloatingActionMenu;", "floatingButton", "Lcom/github/clans/fab/FloatingActionButton;", "fabActionHandled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sendBrowseAction", "Lkotlin/Function1;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "", "Lcom/box/android/browse/cpl/helpers/SendBrowseAction;", "initializeFab", "floatingMenuContainer", "Landroid/widget/RelativeLayout;", "getCurrentFolder", "Lkotlin/Function0;", "Lcom/box/androidsdk/content/models/BoxFolder;", "Lcom/box/android/browse/cpl/helpers/GetCurrentBoxFolder;", "initializeFabFolderModel", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/browse/cpl/helpers/GetCurrentFolderModel;", "setBoxNoteMenuItem", "isBoxNoteCreationEnabled", "", "onNewFolderClick", "folder", "onNewDocumentClick", "onNewNoteClick", "onNewMediaClick", "requestPermissionToUpload", "onLibraryClick", "initializeFABForAccessibility", "sendFABPageExitedAnalytics", "handleFabMenuAccessibility", "opened", "Factory", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FabHelper {
    public static final int $stable = 8;
    private final BoxFragmentActivity activity;
    private final AtomicBoolean fabActionHandled;
    private final FabManager fabManager;
    private FloatingActionButton floatingButton;
    private FloatingActionMenu floatingMenu;
    private Function1<? super BrowseReducer.Action, Unit> sendBrowseAction;
    private final IUserContextManager userContextManager;

    /* JADX INFO: compiled from: FabHelper.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/browse/cpl/helpers/FabHelper$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/browse/cpl/helpers/FabHelper;", "activity", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory {
        FabHelper create(BoxFragmentActivity activity);
    }

    @AssistedInject
    public FabHelper(IUserContextManager userContextManager, FabManager fabManager, @Assisted BoxFragmentActivity activity) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(fabManager, "fabManager");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.userContextManager = userContextManager;
        this.fabManager = fabManager;
        this.activity = activity;
        this.fabActionHandled = new AtomicBoolean(false);
        this.sendBrowseAction = new Function1() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FabHelper.sendBrowseAction$lambda$0((BrowseReducer.Action) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBrowseAction$lambda$0(BrowseReducer.Action it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void initializeFab(FloatingActionMenu floatingMenu, RelativeLayout floatingMenuContainer, final Function0<? extends BoxFolder> getCurrentFolder, Function1<? super BrowseReducer.Action, Unit> sendBrowseAction) {
        Intrinsics.checkNotNullParameter(getCurrentFolder, "getCurrentFolder");
        Intrinsics.checkNotNullParameter(sendBrowseAction, "sendBrowseAction");
        initializeFabFolderModel(floatingMenu, floatingMenuContainer, new Function0() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FabHelper.initializeFab$lambda$0(getCurrentFolder);
            }
        }, sendBrowseAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FolderModel initializeFab$lambda$0(Function0 function0) {
        BoxFolder boxFolder = (BoxFolder) function0.invoke();
        if (boxFolder != null) {
            return FolderModelMapper.toFolderModel$default(FolderModelMapper.INSTANCE, boxFolder, false, 1, null);
        }
        return null;
    }

    public final void initializeFabFolderModel(final FloatingActionMenu floatingMenu, final RelativeLayout floatingMenuContainer, final Function0<FolderModel> getCurrentFolder, Function1<? super BrowseReducer.Action, Unit> sendBrowseAction) {
        Intrinsics.checkNotNullParameter(getCurrentFolder, "getCurrentFolder");
        Intrinsics.checkNotNullParameter(sendBrowseAction, "sendBrowseAction");
        if (floatingMenu == null) {
            return;
        }
        this.floatingMenu = floatingMenu;
        this.sendBrowseAction = sendBrowseAction;
        this.floatingButton = initializeFABForAccessibility();
        floatingMenu.findViewById(R.id.fab_new_folder).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FabHelper.initializeFabFolderModel$lambda$0(this.f$0, getCurrentFolder, view);
            }
        });
        View viewFindViewById = floatingMenu.findViewById(R.id.fab_new_document);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FabHelper.initializeFabFolderModel$lambda$1(this.f$0, getCurrentFolder, view);
                }
            });
        }
        setBoxNoteMenuItem(floatingMenu, isBoxNoteCreationEnabled(), getCurrentFolder);
        floatingMenu.findViewById(R.id.fab_new_media).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FabHelper.initializeFabFolderModel$lambda$2(this.f$0, getCurrentFolder, view);
            }
        });
        floatingMenu.findViewById(R.id.fab_library).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FabHelper.initializeFabFolderModel$lambda$3(this.f$0, getCurrentFolder, view);
            }
        });
        floatingMenu.setClosedOnTouchOutside(true);
        floatingMenu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda4
            @Override // com.github.clans.fab.FloatingActionMenu.OnMenuToggleListener
            public final void onMenuToggle(boolean z) {
                FabHelper.initializeFabFolderModel$lambda$4(floatingMenu, this, floatingMenuContainer, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeFabFolderModel$lambda$0(FabHelper fabHelper, Function0 function0, View view) {
        fabHelper.onNewFolderClick((FolderModel) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeFabFolderModel$lambda$1(FabHelper fabHelper, Function0 function0, View view) {
        fabHelper.onNewDocumentClick((FolderModel) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeFabFolderModel$lambda$2(FabHelper fabHelper, Function0 function0, View view) {
        fabHelper.onNewMediaClick((FolderModel) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeFabFolderModel$lambda$3(FabHelper fabHelper, Function0 function0, View view) {
        fabHelper.onLibraryClick((FolderModel) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeFabFolderModel$lambda$4(FloatingActionMenu floatingActionMenu, FabHelper fabHelper, RelativeLayout relativeLayout, boolean z) {
        Context context = floatingActionMenu.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        floatingActionMenu.setMenuButtonColorNormal(CommonBoxUtil.getColorFromAttribute(context, z ? com.box.android.common.R.attr.mainInactiveControl : com.box.android.common.R.attr.mainActiveControl));
        if (z) {
            BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_ADD_CTA_TRIGGERED);
            fabHelper.fabActionHandled.set(false);
            FloatingActionButton floatingActionButton = fabHelper.floatingButton;
            if (floatingActionButton != null) {
                floatingActionButton.setContentDescription(floatingActionMenu.getContext().getString(R.string.fab_talkback_label_close));
            }
            fabHelper.activity.amplitudeSetCurrentPage();
        } else {
            if (!fabHelper.fabActionHandled.get()) {
                fabHelper.sendFABPageExitedAnalytics();
                fabHelper.activity.amplitudeSetCurrentPage();
            }
            FloatingActionButton floatingActionButton2 = fabHelper.floatingButton;
            if (floatingActionButton2 != null) {
                floatingActionButton2.setContentDescription(floatingActionMenu.getContext().getString(R.string.fab_talkback_label_add));
            }
        }
        fabHelper.handleFabMenuAccessibility(z, relativeLayout);
    }

    public final void setBoxNoteMenuItem(FloatingActionMenu floatingMenu, boolean isBoxNoteCreationEnabled, final Function0<FolderModel> getCurrentFolder) {
        Intrinsics.checkNotNullParameter(floatingMenu, "floatingMenu");
        Intrinsics.checkNotNullParameter(getCurrentFolder, "getCurrentFolder");
        FloatingActionButton floatingActionButton = (FloatingActionButton) floatingMenu.findViewById(R.id.fab_new_note);
        if (!isBoxNoteCreationEnabled) {
            if (floatingActionButton != null) {
                floatingMenu.removeMenuButton(floatingActionButton);
                return;
            }
            return;
        }
        if (floatingActionButton == null) {
            floatingActionButton = new FloatingActionButton(floatingMenu.getContext());
            floatingActionButton.setId(R.id.fab_new_note);
            floatingActionButton.setButtonSize(1);
            floatingActionButton.setColorNormal(ContextCompat.getColor(floatingActionButton.getContext(), R.color.box_purple));
            floatingActionButton.setImageResource(R.drawable.ic_fab_action_note);
            floatingActionButton.setLabelText(floatingActionButton.getContext().getString(R.string.New_boxnote));
            floatingMenu.addMenuButton(floatingActionButton);
        }
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FabHelper.setBoxNoteMenuItem$lambda$1(this.f$0, getCurrentFolder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBoxNoteMenuItem$lambda$1(FabHelper fabHelper, Function0 function0, View view) {
        fabHelper.onNewNoteClick((FolderModel) function0.invoke());
    }

    private final void onNewFolderClick(FolderModel folder) {
        if (folder == null) {
            return;
        }
        FloatingActionMenu floatingActionMenu = this.floatingMenu;
        if (floatingActionMenu != null) {
            floatingActionMenu.close(false);
        }
        if (this.fabManager.handleNewFolderClick(folder, this.activity) instanceof FabMenuOptionResult.Success) {
            this.sendBrowseAction.invoke(BrowseReducer.Action.CreateFolder.INSTANCE);
            this.fabActionHandled.set(true);
        }
    }

    private final void onNewDocumentClick(FolderModel folder) {
        if (folder == null) {
            return;
        }
        FloatingActionMenu floatingActionMenu = this.floatingMenu;
        if (floatingActionMenu != null) {
            floatingActionMenu.close(false);
        }
        if (this.fabManager.handleNewDocumentClick(folder, this.activity, true) instanceof FabMenuOptionResult.Success) {
            this.fabActionHandled.set(true);
        }
    }

    private final void onNewNoteClick(FolderModel folder) {
        if (folder == null) {
            return;
        }
        FloatingActionMenu floatingActionMenu = this.floatingMenu;
        if (floatingActionMenu != null) {
            floatingActionMenu.close(false);
        }
        if (this.fabManager.handleNewBoxNoteClick(new NewNoteLocation.Folder(folder), PreviewSource.Browse.INSTANCE, this.activity) instanceof FabMenuOptionResult.Success) {
            this.fabActionHandled.set(true);
        }
    }

    private final void onNewMediaClick(FolderModel folder) {
        if (folder == null) {
            return;
        }
        FloatingActionMenu floatingActionMenu = this.floatingMenu;
        if (floatingActionMenu != null) {
            floatingActionMenu.close(false);
        }
        FabMenuCaptureMediaOptionResult fabMenuCaptureMediaOptionResultHandleCaptureMediaClicked = this.fabManager.handleCaptureMediaClicked(folder, this.activity);
        if (fabMenuCaptureMediaOptionResultHandleCaptureMediaClicked instanceof FabMenuCaptureMediaOptionResult.StorageAccessNeeded) {
            requestPermissionToUpload();
        } else if (fabMenuCaptureMediaOptionResultHandleCaptureMediaClicked instanceof FabMenuCaptureMediaOptionResult.Success) {
            this.fabActionHandled.set(true);
        }
    }

    private final void requestPermissionToUpload() {
        ActivityCompat.requestPermissions(this.activity, new String[]{"android.permission.MANAGE_EXTERNAL_STORAGE"}, 204);
    }

    private final void onLibraryClick(FolderModel folder) {
        if (folder == null) {
            return;
        }
        FabMenuUploadContentOptionResult fabMenuUploadContentOptionResultHandleUploadContentClicked = this.fabManager.handleUploadContentClicked(folder, this.activity);
        if (fabMenuUploadContentOptionResultHandleUploadContentClicked instanceof FabMenuUploadContentOptionResult.MAMBlocked) {
            return;
        }
        FloatingActionMenu floatingActionMenu = this.floatingMenu;
        if (floatingActionMenu != null) {
            floatingActionMenu.close(false);
        }
        if (fabMenuUploadContentOptionResultHandleUploadContentClicked instanceof FabMenuUploadContentOptionResult.StorageAccessNeeded) {
            requestPermissionToUpload();
        } else if (fabMenuUploadContentOptionResultHandleUploadContentClicked instanceof FabMenuUploadContentOptionResult.Success) {
            UploadOptionsFragment.newInstance(this.activity, FolderModelMapper.toBoxFolder$default(FolderModelMapper.INSTANCE, folder, false, 1, null)).setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.box.android.browse.cpl.helpers.FabHelper$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FabHelper.onLibraryClick$lambda$0(this.f$0, dialogInterface);
                }
            }).show(this.activity.getSupportFragmentManager(), BottomSheetMenuFragment.TAG);
            this.fabActionHandled.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLibraryClick$lambda$0(FabHelper fabHelper, DialogInterface dialogInterface) {
        fabHelper.activity.amplitudeSetCurrentPage();
    }

    private final FloatingActionButton initializeFABForAccessibility() {
        Context context;
        try {
            Field declaredField = FloatingActionMenu.class.getDeclaredField("mMenuButton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.floatingMenu);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.github.clans.fab.FloatingActionButton");
            FloatingActionButton floatingActionButton = (FloatingActionButton) obj;
            FloatingActionMenu floatingActionMenu = this.floatingMenu;
            floatingActionButton.setContentDescription((floatingActionMenu == null || (context = floatingActionMenu.getContext()) == null) ? null : context.getString(R.string.fab_talkback_label_add));
            return floatingActionButton;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private final void sendFABPageExitedAnalytics() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_UPLOAD).setTimeOnPage().logEvent(BoxAnalyticsParams.EVENT_FAB_PAGE_EXITED);
    }

    private final void handleFabMenuAccessibility(boolean opened, RelativeLayout floatingMenuContainer) {
        if (floatingMenuContainer != null) {
            ViewGroup.LayoutParams layoutParams = floatingMenuContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.height = opened ? -1 : floatingMenuContainer.getContext().getResources().getDimensionPixelSize(R.dimen.floating_action_menu_container_size);
            floatingMenuContainer.setLayoutParams(layoutParams);
        }
    }

    private final boolean isBoxNoteCreationEnabled() {
        return this.userContextManager.getUserInfo().isBoxNoteCreationEnabled();
    }
}
