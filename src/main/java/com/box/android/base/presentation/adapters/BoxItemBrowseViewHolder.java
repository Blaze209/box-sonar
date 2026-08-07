package com.box.android.base.presentation.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.R;
import com.box.android.base.databinding.BrowseListItemBinding;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FlowExtensionsKt;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.SdkUtils;
import com.google.android.material.imageview.ShapeableImageView;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: BoxItemBrowseViewHolder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 =2\u00020\u0001:\u0001=BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\u0011H\u0016J \u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(H\u0016J\u0006\u00101\u001a\u00020\u0011J\u0006\u00102\u001a\u00020\u0011J\u0010\u00103\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0010H\u0002J\u0010\u00106\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0010H\u0002J\b\u00107\u001a\u00020\u0003H\u0016J\u0010\u00108\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020;H\u0002J\u0006\u0010<\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010)¨\u0006>"}, d2 = {"Lcom/box/android/base/presentation/adapters/BoxItemBrowseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "offlineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onUpdateClick", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "", "<init>", "(Landroid/view/View;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "getView", "()Landroid/view/View;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "itemModel", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "setItemModel", "(Lcom/box/android/domain/models/item/ItemModel;)V", "commonBinding", "Lcom/box/android/base/databinding/BrowseListItemBinding;", "getCommonBinding", "()Lcom/box/android/base/databinding/BrowseListItemBinding;", "offlineStateJob", "Lkotlinx/coroutines/Job;", "isRedesignedVersion", "", "()Z", "bindItem", "loadFileThumbnail", "setDescription", "handleMultiSelectMode", "isMultiSelectMode", "isSelected", "isSelectable", "enableView", "disableView", "updateChatBadge", "updateSharedLinkBadge", "item", "updateCollectionsBadge", "getSecondaryActionView", "updateOfflineBadge", "applyRedesignedOfflineState", "state", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "cancelOfflineObservation", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class BoxItemBrowseViewHolder extends RecyclerView.ViewHolder {
    public static final String DESCRIPTION_TEMPLATE = "%s  • %s";
    private final BrowseListItemBinding commonBinding;
    private final CoroutineScope coroutineScope;
    private final FeatureFlips featureFlips;
    public ItemModel itemModel;
    private final BoxModelOfflineManagerWrapper offlineManagerWrapper;
    private Job offlineStateJob;
    private final Function1<ItemModel, Unit> onUpdateClick;
    private final ThumbnailManager thumbnailManager;
    private final IUserContextManager userContextManager;
    private final View view;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: BoxItemBrowseViewHolder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxModelOfflineManager.State.values().length];
            try {
                iArr[BoxModelOfflineManager.State.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxModelOfflineManager.State.OFFLINE_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxModelOfflineManager.State.OUT_OF_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BoxItemBrowseViewHolder(View view, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager userContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineScope coroutineScope, Function1<? super ItemModel, Unit> function1) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.view = view;
        this.thumbnailManager = thumbnailManager;
        this.featureFlips = featureFlips;
        this.userContextManager = userContextManager;
        this.offlineManagerWrapper = boxModelOfflineManagerWrapper;
        this.coroutineScope = coroutineScope;
        this.onUpdateClick = function1;
        BrowseListItemBinding browseListItemBindingBind = BrowseListItemBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(browseListItemBindingBind, "bind(...)");
        this.commonBinding = browseListItemBindingBind;
    }

    public /* synthetic */ BoxItemBrowseViewHolder(View view, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager iUserContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineScope coroutineScope, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, thumbnailManager, featureFlips, iUserContextManager, (i & 16) != 0 ? null : boxModelOfflineManagerWrapper, (i & 32) != 0 ? null : coroutineScope, (i & 64) != 0 ? null : function1);
    }

    public final View getView() {
        return this.view;
    }

    public final ThumbnailManager getThumbnailManager() {
        return this.thumbnailManager;
    }

    public final FeatureFlips getFeatureFlips() {
        return this.featureFlips;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final ItemModel getItemModel() {
        ItemModel itemModel = this.itemModel;
        if (itemModel != null) {
            return itemModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemModel");
        return null;
    }

    public final void setItemModel(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "<set-?>");
        this.itemModel = itemModel;
    }

    public final BrowseListItemBinding getCommonBinding() {
        return this.commonBinding;
    }

    private final boolean isRedesignedVersion() {
        return this.featureFlips.getMainScreenRedesign().getEnabled();
    }

    public void bindItem(ItemModel itemModel) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        setItemModel(itemModel);
        this.commonBinding.boxBrowsesdkNameText.setText(itemModel.getName());
        AppCompatImageButton appCompatImageButton = this.commonBinding.secondaryAction;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(CommonBoxUtil.LS(R.string.browse_item_talkback_more_actions), Arrays.copyOf(new Object[]{itemModel.getName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        appCompatImageButton.setContentDescription(str);
        loadFileThumbnail();
        setDescription();
        Job job = this.offlineStateJob;
        if (job != null) {
            FlowExtensionsKt.cancelIfActive(job);
        }
        if (isRedesignedVersion()) {
            this.commonBinding.badgeOffline.setVisibility(8);
            this.commonBinding.offlineOverlayBadgeRedesigned.setVisibility(8);
            this.commonBinding.updateButtonRedesigned.setVisibility(8);
            this.commonBinding.updateButtonRedesigned.setOnClickListener(null);
            if (this.offlineManagerWrapper != null && (coroutineScope = this.coroutineScope) != null) {
                this.offlineStateJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass1(itemModel, null), 2, null);
            }
        } else {
            this.commonBinding.offlineOverlayBadgeRedesigned.setVisibility(8);
            this.commonBinding.updateButtonRedesigned.setVisibility(8);
            this.commonBinding.updateButtonRedesigned.setOnClickListener(null);
            updateOfflineBadge(itemModel);
        }
        updateChatBadge(itemModel);
        updateSharedLinkBadge(itemModel);
        updateCollectionsBadge(itemModel);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder$bindItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxItemBrowseViewHolder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder$bindItem$1", f = "BoxItemBrowseViewHolder.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemModel $itemModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemModel itemModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemModel = itemModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxItemBrowseViewHolder.this.new AnonymousClass1(this.$itemModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<BoxModelOfflineManager.State> stateFlow = BoxItemBrowseViewHolder.this.offlineManagerWrapper.getStateFlow(this.$itemModel.getItemId());
                final BoxItemBrowseViewHolder boxItemBrowseViewHolder = BoxItemBrowseViewHolder.this;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder.bindItem.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((BoxModelOfflineManager.State) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(BoxModelOfflineManager.State state, Continuation<? super Unit> continuation) {
                        boxItemBrowseViewHolder.applyRedesignedOfflineState(state);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public void loadFileThumbnail() {
        ThumbnailManager thumbnailManager = this.thumbnailManager;
        BoxItem boxItem$default = ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, getItemModel(), false, 1, null);
        ShapeableImageView boxBrowsesdkThumbImage = this.commonBinding.boxBrowsesdkThumbImage;
        Intrinsics.checkNotNullExpressionValue(boxBrowsesdkThumbImage, "boxBrowsesdkThumbImage");
        thumbnailManager.loadThumbnail(boxItem$default, boxBrowsesdkThumbImage);
    }

    public void setDescription() {
        String str;
        Date modifiedDate = getItemModel().getModifiedDate();
        if (modifiedDate == null || (str = DateFormat.getDateInstance(2).format(modifiedDate)) == null) {
            str = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.ENGLISH;
        Context context = this.view.getContext();
        Long size = getItemModel().getSize();
        String str2 = String.format(locale, DESCRIPTION_TEMPLATE, Arrays.copyOf(new Object[]{str, SdkUtils.getLocalizedFileSize(context, size != null ? size.longValue() : 0.0d)}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        this.commonBinding.metalineDescription.setText(str2);
    }

    public void handleMultiSelectMode(boolean isMultiSelectMode, boolean isSelected, boolean isSelectable) {
        if (isMultiSelectMode) {
            getSecondaryActionView().setVisibility(8);
            this.commonBinding.boxItemCheckBox.setVisibility(0);
            this.commonBinding.boxItemCheckBox.setChecked(isSelected);
            this.commonBinding.boxItemSelectedLayout.setSelected(isSelected);
            if (isSelectable) {
                enableView();
                return;
            } else {
                disableView();
                return;
            }
        }
        getSecondaryActionView().setVisibility(0);
        this.commonBinding.boxItemCheckBox.setVisibility(8);
        this.commonBinding.boxItemCheckBox.setChecked(false);
        this.commonBinding.boxItemSelectedLayout.setSelected(false);
        enableView();
    }

    public final void enableView() {
        this.view.setEnabled(true);
        this.commonBinding.boxItemSelectedLayout.setAlpha(1.0f);
    }

    public final void disableView() {
        this.view.setEnabled(false);
        this.commonBinding.boxItemSelectedLayout.setAlpha(0.5f);
    }

    private final void updateChatBadge(ItemModel itemModel) {
        int iLongValue;
        BoxItem boxItem$default = ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, itemModel, false, 1, null);
        if (boxItem$default instanceof BoxFile) {
            Long commentCount = ((BoxFile) boxItem$default).getCommentCount(Boolean.valueOf(this.featureFlips.getViewAnnotations().getEnabled()));
            iLongValue = commentCount != null ? (int) commentCount.longValue() : 0;
            this.commonBinding.badgeChatCount.setText(String.valueOf(iLongValue));
        } else {
            iLongValue = 0;
        }
        this.commonBinding.badgeChat.setVisibility(iLongValue <= 0 ? 8 : 0);
    }

    private final void updateSharedLinkBadge(ItemModel item) {
        this.commonBinding.badgeSharedLink.setVisibility(item.getSharedLink() != null ? 0 : 8);
    }

    private final void updateCollectionsBadge(ItemModel item) {
        FrameLayout frameLayout = this.commonBinding.badgeCollection;
        List<CollectionModel> collections = item.getCollections();
        frameLayout.setVisibility((collections == null || collections.isEmpty()) ? 8 : 0);
    }

    public View getSecondaryActionView() {
        AppCompatImageButton secondaryAction = this.commonBinding.secondaryAction;
        Intrinsics.checkNotNullExpressionValue(secondaryAction, "secondaryAction");
        return secondaryAction;
    }

    private final void updateOfflineBadge(ItemModel item) {
        this.commonBinding.badgeOffline.setState(BoxModelOfflineManager.getState(item, this.userContextManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyRedesignedOfflineState(BoxModelOfflineManager.State state) {
        int i;
        int color = ContextCompat.getColor(this.view.getContext(), R.color.light_green_115);
        int color2 = ContextCompat.getColor(this.view.getContext(), R.color.orange_115);
        Context context = this.view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (this.commonBinding.boxItemSelectedLayout.isSelected()) {
            i = R.attr.contentBackgroundSelected;
        } else {
            i = R.attr.contentBackground;
        }
        int colorFromAttribute = CommonBoxUtil.getColorFromAttribute(context, i);
        int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i2 == 1) {
            this.commonBinding.offlineOverlayBadgeRedesigned.setVisibility(0);
            this.commonBinding.offlineOverlayBadgeRedesigned.setImageResource(R.drawable.ic_checkmark_underline);
            this.commonBinding.offlineOverlayBadgeRedesigned.setBackgroundTintList(ColorStateList.valueOf(color));
            this.commonBinding.offlineOverlayBadgeRedesigned.setImageTintList(ColorStateList.valueOf(colorFromAttribute));
        } else if (i2 == 2 || i2 == 3) {
            this.commonBinding.offlineOverlayBadgeRedesigned.setVisibility(0);
            this.commonBinding.offlineOverlayBadgeRedesigned.setImageResource(R.drawable.ic_arrows_spinning);
            this.commonBinding.offlineOverlayBadgeRedesigned.setBackgroundTintList(ColorStateList.valueOf(color2));
            this.commonBinding.offlineOverlayBadgeRedesigned.setImageTintList(ColorStateList.valueOf(colorFromAttribute));
        } else {
            this.commonBinding.offlineOverlayBadgeRedesigned.setVisibility(8);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i3 == 2) {
            this.commonBinding.metalineDescription.setText(this.view.getContext().getString(R.string.downloading));
        } else if (i3 == 3) {
            this.commonBinding.metalineDescription.setText(this.view.getContext().getString(R.string.new_version_available));
        } else {
            setDescription();
        }
        boolean z = state == BoxModelOfflineManager.State.OUT_OF_DATE;
        this.commonBinding.updateButtonRedesigned.setVisibility(z ? 0 : 8);
        if (z) {
            this.commonBinding.updateButtonRedesigned.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BoxItemBrowseViewHolder.applyRedesignedOfflineState$lambda$0(this.f$0, view);
                }
            });
        } else {
            this.commonBinding.updateButtonRedesigned.setOnClickListener(null);
        }
        if (state == BoxModelOfflineManager.State.OFFLINE_PENDING || state == BoxModelOfflineManager.State.OUT_OF_DATE) {
            this.commonBinding.badgeSharedLink.setVisibility(8);
            this.commonBinding.badgeChat.setVisibility(8);
            this.commonBinding.badgeCollection.setVisibility(8);
        } else {
            updateChatBadge(getItemModel());
            updateSharedLinkBadge(getItemModel());
            updateCollectionsBadge(getItemModel());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyRedesignedOfflineState$lambda$0(BoxItemBrowseViewHolder boxItemBrowseViewHolder, View view) {
        Function1<ItemModel, Unit> function1 = boxItemBrowseViewHolder.onUpdateClick;
        if (function1 != null) {
            function1.invoke(boxItemBrowseViewHolder.getItemModel());
        }
    }

    public final void cancelOfflineObservation() {
        Job job = this.offlineStateJob;
        if (job != null) {
            FlowExtensionsKt.cancelIfActive(job);
        }
        this.offlineStateJob = null;
    }
}
