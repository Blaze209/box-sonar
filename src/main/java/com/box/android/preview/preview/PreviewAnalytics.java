package com.box.android.preview.preview;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.analytics.WopiPropertyBuilder;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.previewtype.document.DisplayMode;
import com.box.android.preview.routing.PreviewRoute;
import com.box.android.preview.wopi.OfficeAppType;
import com.box.android.preview.wopi.WopiConfiguration;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewAnalytics.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010'\u001a\u00020(2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010\t*\u00020\u000fH\u0002J\f\u0010*\u001a\u00020\t*\u00020+H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/box/android/preview/preview/PreviewAnalytics;", "", "wopiEventBuilder", "Lcom/box/android/domain/analytics/WopiPropertyBuilder;", "<init>", "(Lcom/box/android/domain/analytics/WopiPropertyBuilder;)V", "itemIdToLaunchMode", "", "Lcom/box/android/domain/models/ItemId;", "", "navigationTriggered", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "route", "Lcom/box/android/preview/routing/PreviewRoute;", "copyLinkTriggered", "makeAvailableOfflineTriggered", "renameTriggered", "displayModeTriggered", "displayMode", "Lcom/box/android/preview/previewtype/document/DisplayMode;", "moreActionsMenuTriggered", "galleryViewTriggered", "playlistViewTriggered", "annotationsTriggered", "boxAiTriggered", "closeTriggered", "previewInitiated", "previewLaunchMode", "previewError", "previewScreenRenderingInitiated", "previewScreenLoaded", "searchDocumentTriggered", "previewByWopiTriggered", "wopiConfiguration", "Lcom/box/android/preview/wopi/WopiConfiguration;", "previousVersionPreviewScreenLoaded", "noteOpened", "previewEventBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$PreviewEventPropertyBuilder;", "toEventName", "toPageName", "Lcom/box/android/preview/wopi/OfficeAppType;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewAnalytics {
    public static final int $stable = 8;
    private final Map<ItemId, String> itemIdToLaunchMode;
    private final WopiPropertyBuilder wopiEventBuilder;

    /* JADX INFO: compiled from: PreviewAnalytics.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DisplayMode.values().length];
            try {
                iArr[DisplayMode.Thumbnails.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayMode.FullItem.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayMode.Outline.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OfficeAppType.values().length];
            try {
                iArr2[OfficeAppType.WORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OfficeAppType.EXCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[OfficeAppType.POWERPOINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[OfficeAppType.OFFICE_365.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public PreviewAnalytics(WopiPropertyBuilder wopiEventBuilder) {
        Intrinsics.checkNotNullParameter(wopiEventBuilder, "wopiEventBuilder");
        this.wopiEventBuilder = wopiEventBuilder;
        this.itemIdToLaunchMode = new LinkedHashMap();
    }

    public final void navigationTriggered(FileModel fileModel, PreviewRoute route) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(route, "route");
        String eventName = toEventName(route);
        if (eventName != null) {
            previewEventBuilder(fileModel).logEvent(eventName);
        }
    }

    public final void copyLinkTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_COPY_SHARED_LINK_TRIGGERED);
    }

    public final void makeAvailableOfflineTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_MAKE_AVAILABLE_OFFLINE);
    }

    public final void renameTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_RENAME_TRIGGERED);
    }

    public final void displayModeTriggered(FileModel fileModel, DisplayMode displayMode) {
        String str;
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        int i = WhenMappings.$EnumSwitchMapping$0[displayMode.ordinal()];
        if (i == 1) {
            str = BoxAnalyticsParams.EVENT_THUMBNAILS_VIEW_TRIGGERED;
        } else if (i == 2) {
            str = BoxAnalyticsParams.EVENT_PAGE_VIEW_TRIGGERED;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = BoxAnalyticsParams.EVENT_OUTLINE_TRIGGERED;
        }
        previewEventBuilder(fileModel).logEvent(str);
    }

    public final void moreActionsMenuTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_MORE_ACTIONS_MENU_TRIGGERED);
    }

    public final void galleryViewTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_GALLERY_VIEW_TRIGGERED);
    }

    public final void playlistViewTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_PLAYLIST_VIEW_TRIGGERED);
    }

    public final void annotationsTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_ANNOTATIONS_TRIGGERED);
    }

    public final void boxAiTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_PREVIEW_BOX_AI_BUTTON_CLICKED);
    }

    public final void closeTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_PREVIEW_CLOSED);
    }

    public final void previewInitiated(FileModel fileModel, String previewLaunchMode) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewLaunchMode, "previewLaunchMode");
        this.itemIdToLaunchMode.put(fileModel.getItemId(), previewLaunchMode);
        previewEventBuilder(fileModel).setLaunchMode(previewLaunchMode).logEvent(BoxAnalyticsParams.EVENT_SELECT_FILE_CTA_TRIGGERED);
    }

    public final void previewError(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        String strRemove = this.itemIdToLaunchMode.remove(fileModel.getItemId());
        BoxAmplitudeAnalytics.PreviewEventPropertyBuilder previewEventPropertyBuilderPreviewEventBuilder = previewEventBuilder(fileModel);
        if (strRemove != null) {
            previewEventPropertyBuilderPreviewEventBuilder.setLaunchMode(strRemove);
            previewEventPropertyBuilderPreviewEventBuilder.logEvent(BoxAnalyticsParams.EVENT_PREVIEW_ERROR);
        } else {
            previewEventPropertyBuilderPreviewEventBuilder.logEvent(BoxAnalyticsParams.EVENT_FILE_PREFETCH_ERROR);
        }
    }

    public final void previewScreenRenderingInitiated(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        String str = this.itemIdToLaunchMode.get(fileModel.getItemId());
        BoxAmplitudeAnalytics.PreviewEventPropertyBuilder previewEventPropertyBuilderPreviewEventBuilder = previewEventBuilder(fileModel);
        if (str != null) {
            previewEventPropertyBuilderPreviewEventBuilder.setLaunchMode(str);
            previewEventPropertyBuilderPreviewEventBuilder.logEvent(BoxAnalyticsParams.EVENT_PREVIEW_SCREEN_RENDERING_INITIATED);
        }
    }

    public final void previewScreenLoaded(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        String strRemove = this.itemIdToLaunchMode.remove(fileModel.getItemId());
        BoxAmplitudeAnalytics.PreviewEventPropertyBuilder previewEventPropertyBuilderPreviewEventBuilder = previewEventBuilder(fileModel);
        if (strRemove != null) {
            previewEventPropertyBuilderPreviewEventBuilder.setLaunchMode(strRemove);
            previewEventPropertyBuilderPreviewEventBuilder.logEvent(BoxAnalyticsParams.EVENT_PREVIEW_SCREEN_LOADED);
        }
    }

    public final void searchDocumentTriggered(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_DOCUMENT_SEARCH_TRIGGERED);
    }

    public final void previewByWopiTriggered(WopiConfiguration wopiConfiguration) {
        Intrinsics.checkNotNullParameter(wopiConfiguration, "wopiConfiguration");
        BoxAmplitudeAnalytics.getInstance().setCurrentPage(toPageName(wopiConfiguration.getAppType()));
        this.wopiEventBuilder.setServiceId(wopiConfiguration.getServiceId()).setIsFileEditable(wopiConfiguration.isEditable()).setFileExtension(wopiConfiguration.getFileExtension()).getEventPropertyBuilder().logEvent(WopiPropertyBuilder.PREVIEW_BY_WOPI);
    }

    public final void previousVersionPreviewScreenLoaded(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_PREVIEW_OLDER_VERSION);
    }

    public final void noteOpened(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        previewEventBuilder(fileModel).logEvent(BoxAnalyticsParams.EVENT_NOTE_OPENED);
    }

    private final BoxAmplitudeAnalytics.PreviewEventPropertyBuilder previewEventBuilder(FileModel fileModel) {
        BoxAmplitudeAnalytics.EventPropertyBuilder flow = BoxAmplitudeAnalytics.createPreviewEventPropertyBuilder().setBoxItem(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, fileModel, false, 1, null)).setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        Intrinsics.checkNotNull(flow, "null cannot be cast to non-null type com.box.android.domain.analytics.BoxAmplitudeAnalytics.PreviewEventPropertyBuilder");
        return (BoxAmplitudeAnalytics.PreviewEventPropertyBuilder) flow;
    }

    private final String toEventName(PreviewRoute previewRoute) {
        if (previewRoute instanceof PreviewRoute.FileInformation) {
            return BoxAnalyticsParams.EVENT_MENU_ITEM_INFO_TRIGGERED;
        }
        if (previewRoute instanceof PreviewRoute.FileActivities) {
            return BoxAnalyticsParams.EVENT_FILE_ACTIVITY_TRIGGERED;
        }
        if (previewRoute instanceof PreviewRoute.MoveOrCopy) {
            return BoxAnalyticsParams.EVENT_MOVE_OR_COPY_FILE_TRIGGERED;
        }
        if (previewRoute instanceof PreviewRoute.Share) {
            return BoxAnalyticsParams.EVENT_SHARE_STARTED;
        }
        if (previewRoute instanceof PreviewRoute.Collections) {
            return BoxAnalyticsParams.EVENT_COLLECTIONS_PREVIEW_TRIGGERED;
        }
        if (previewRoute instanceof PreviewRoute.AddTask) {
            return BoxAnalyticsParams.EVENT_ADD_TASK_TRIGGERED;
        }
        return null;
    }

    private final String toPageName(OfficeAppType officeAppType) {
        int i = WhenMappings.$EnumSwitchMapping$1[officeAppType.ordinal()];
        if (i == 1) {
            return BoxAnalyticsParams.PAGE_NAME_MS_WORD;
        }
        if (i == 2) {
            return BoxAnalyticsParams.PAGE_NAME_MS_EXCEL;
        }
        if (i == 3) {
            return BoxAnalyticsParams.PAGE_NAME_MS_POWERPOINT;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return BoxAnalyticsParams.PAGE_NAME_MS_365;
    }
}
