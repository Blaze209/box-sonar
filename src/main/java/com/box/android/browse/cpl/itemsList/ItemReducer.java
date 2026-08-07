package com.box.android.browse.cpl.itemsList;

import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.cpl.ItemThumbnailReducer;
import com.box.android.base.cpl.ThumbnailSource;
import com.box.android.browse.R;
import com.box.android.browse.cpl.helpers.RecentItemsHelper;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.SizeUtils;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ItemReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "environment", "Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceOfflineState", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemReducer implements Reducable<State, Action> {
    private final Reducable<State, Action> build;
    private final ItemEnvironment environment;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public ItemReducer(ItemEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new ItemReducer$build$1(this));
        final ItemReducer$build$2 itemReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ItemReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemReducer.State) obj).getThumbnailState();
            }
        };
        final ItemReducer$build$3 itemReducer$build$3 = ItemReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new ItemThumbnailReducer(environment.getThumbnailEnvironment()), new Function1<State, ItemThumbnailReducer.State>() { // from class: com.box.android.browse.cpl.itemsList.ItemReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.cpl.ItemThumbnailReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.State invoke(ItemReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return itemReducer$build$2.invoke(it);
            }
        }, new Function1<Action, ItemThumbnailReducer.Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ItemThumbnailReducer.Action invoke(ItemReducer.Action action) {
                if (!(action instanceof ItemReducer.Action.ThumbnailAction)) {
                    action = null;
                }
                ItemReducer.Action.ThumbnailAction thumbnailAction = (ItemReducer.Action.ThumbnailAction) action;
                if (thumbnailAction != null) {
                    return thumbnailAction.getAction();
                }
                return null;
            }
        }, new Function2<State, ItemThumbnailReducer.State, State>() { // from class: com.box.android.browse.cpl.itemsList.ItemReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final ItemReducer.State invoke(ItemReducer.State parentState, ItemThumbnailReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = itemReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(ItemReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, state)));
                        if (rCallBy != 0) {
                            return (ItemReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemThumbnailReducer.Action, Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemReducer.Action invoke(ItemThumbnailReducer.Action action) {
                Object objInvoke = itemReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (ItemReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.itemsList.ItemReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemReducer.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J;\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010!\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b'\u0010\u0011R\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00068"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "Lcom/box/android/cpl/Identifiable;", "Lcom/box/android/domain/models/ItemId$Remote;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "isEnabled", "", "thumbnailState", "Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "offlineState", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "uniqueCancelEffectKey", "", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;ZLcom/box/android/base/cpl/ItemThumbnailReducer$State;Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;Ljava/lang/String;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "()Z", "getThumbnailState", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "getOfflineState", "()Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "getUniqueCancelEffectKey", "()Ljava/lang/String;", "id", "getId", "()Lcom/box/android/domain/models/ItemId$Remote;", "name", "getName", "formattedDescription", "getFormattedDescription", "formattedDescription$delegate", "Lkotlin/Lazy;", "isInCollections", "commentsCount", "", "getCommentsCount", "()J", "hasSharedLink", "getHasSharedLink", "itemThumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", "getItemThumbnail", "()Lcom/box/android/base/compose/ItemThumbnail;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<ItemId.Remote> {
        public static final int $stable = 8;

        /* JADX INFO: renamed from: formattedDescription$delegate, reason: from kotlin metadata */
        private final Lazy formattedDescription;
        private final ItemId.Remote id;
        private final boolean isEnabled;
        private final ItemModel itemModel;
        private final BoxModelOfflineManager.State offlineState;
        private final ItemThumbnailReducer.State thumbnailState;
        private final String uniqueCancelEffectKey;

        public static /* synthetic */ State copy$default(State state, ItemModel itemModel, boolean z, ItemThumbnailReducer.State state2, BoxModelOfflineManager.State state3, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                itemModel = state.itemModel;
            }
            if ((i & 2) != 0) {
                z = state.isEnabled;
            }
            if ((i & 4) != 0) {
                state2 = state.thumbnailState;
            }
            if ((i & 8) != 0) {
                state3 = state.offlineState;
            }
            if ((i & 16) != 0) {
                str = state.uniqueCancelEffectKey;
            }
            String str2 = str;
            ItemThumbnailReducer.State state4 = state2;
            return state.copy(itemModel, z, state4, state3, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemThumbnailReducer.State getThumbnailState() {
            return this.thumbnailState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final BoxModelOfflineManager.State getOfflineState() {
            return this.offlineState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getUniqueCancelEffectKey() {
            return this.uniqueCancelEffectKey;
        }

        public final State copy(ItemModel itemModel, boolean isEnabled, ItemThumbnailReducer.State thumbnailState, BoxModelOfflineManager.State offlineState, String uniqueCancelEffectKey) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            Intrinsics.checkNotNullParameter(thumbnailState, "thumbnailState");
            Intrinsics.checkNotNullParameter(offlineState, "offlineState");
            Intrinsics.checkNotNullParameter(uniqueCancelEffectKey, "uniqueCancelEffectKey");
            return new State(itemModel, isEnabled, thumbnailState, offlineState, uniqueCancelEffectKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemModel, state.itemModel) && this.isEnabled == state.isEnabled && Intrinsics.areEqual(this.thumbnailState, state.thumbnailState) && this.offlineState == state.offlineState && Intrinsics.areEqual(this.uniqueCancelEffectKey, state.uniqueCancelEffectKey);
        }

        public int hashCode() {
            return (((((((this.itemModel.hashCode() * 31) + Boolean.hashCode(this.isEnabled)) * 31) + this.thumbnailState.hashCode()) * 31) + this.offlineState.hashCode()) * 31) + this.uniqueCancelEffectKey.hashCode();
        }

        public String toString() {
            return "State(itemModel=" + this.itemModel + ", isEnabled=" + this.isEnabled + ", thumbnailState=" + this.thumbnailState + ", offlineState=" + this.offlineState + ", uniqueCancelEffectKey=" + this.uniqueCancelEffectKey + ")";
        }

        public State(ItemModel itemModel, boolean z, ItemThumbnailReducer.State thumbnailState, BoxModelOfflineManager.State offlineState, String uniqueCancelEffectKey) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            Intrinsics.checkNotNullParameter(thumbnailState, "thumbnailState");
            Intrinsics.checkNotNullParameter(offlineState, "offlineState");
            Intrinsics.checkNotNullParameter(uniqueCancelEffectKey, "uniqueCancelEffectKey");
            this.itemModel = itemModel;
            this.isEnabled = z;
            this.thumbnailState = thumbnailState;
            this.offlineState = offlineState;
            this.uniqueCancelEffectKey = uniqueCancelEffectKey;
            this.id = ItemModelKt.toItemIdRemoteId(itemModel);
            this.formattedDescription = LazyKt.lazy(new Function0() { // from class: com.box.android.browse.cpl.itemsList.ItemReducer$State$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ItemReducer.State.formattedDescription_delegate$lambda$0(this.f$0);
                }
            });
        }

        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ State(ItemModel itemModel, boolean z, ItemThumbnailReducer.State state, BoxModelOfflineManager.State state2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str2;
            boolean z2 = (i & 2) != 0 ? true : z;
            ItemThumbnailReducer.State state3 = (i & 4) != 0 ? new ItemThumbnailReducer.State(new ThumbnailSource.Item(itemModel, false, 2, null), null, false, 6, null) : state;
            BoxModelOfflineManager.State state4 = (i & 8) != 0 ? BoxModelOfflineManager.State.NONE : state2;
            if ((i & 16) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                str2 = string;
            } else {
                str2 = str;
            }
            this(itemModel, z2, state3, state4, str2);
        }

        public final ItemThumbnailReducer.State getThumbnailState() {
            return this.thumbnailState;
        }

        public final BoxModelOfflineManager.State getOfflineState() {
            return this.offlineState;
        }

        public final String getUniqueCancelEffectKey() {
            return this.uniqueCancelEffectKey;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.box.android.cpl.Identifiable
        public ItemId.Remote getId() {
            return this.id;
        }

        public final String getName() {
            return this.itemModel.getName();
        }

        public final String getFormattedDescription() {
            return (String) this.formattedDescription.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:28:0x0066  */
        public static final String formattedDescription_delegate$lambda$0(State state) {
            String str;
            String strLS;
            String name;
            String formattedSize;
            String string;
            ItemModel itemModel = state.itemModel;
            if (itemModel instanceof RecentFileModel) {
                return RecentItemsHelper.INSTANCE.getRecentItemDescription(((RecentFileModel) state.itemModel).getRecentItem());
            }
            Date modifiedDate = itemModel.getModifiedDate();
            String str2 = "";
            if (modifiedDate == null || (str = DateFormat.getDateInstance(2).format(modifiedDate)) == null) {
                str = "";
            }
            Long size = state.itemModel.getSize();
            if (size != null && (formattedSize = SizeUtils.INSTANCE.toFormattedSize(size.longValue())) != null && (string = StringsKt.trim((CharSequence) formattedSize).toString()) != null) {
                str2 = string;
            }
            UserModel updatedBy = state.itemModel.getUpdatedBy();
            if (updatedBy == null || (name = updatedBy.getName()) == null) {
                strLS = CommonBoxUtil.LS(R.string.Prior_Collaborator);
            } else {
                String str3 = name;
                if (StringsKt.isBlank(str3)) {
                    str3 = null;
                }
                strLS = str3;
                if (strLS == null) {
                    strLS = CommonBoxUtil.LS(R.string.Prior_Collaborator);
                }
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str4 = String.format(Locale.ENGLISH, CommonBoxUtil.LS(R.string.item_description_format), Arrays.copyOf(new Object[]{str2, str, strLS}, 3));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            return str4;
        }

        public final boolean isInCollections() {
            List<CollectionModel> collections = this.itemModel.getCollections();
            return collections != null && collections.size() > 0;
        }

        public final long getCommentsCount() {
            FileModel fileModel = ItemModelKt.fileModel(this.itemModel);
            if (fileModel == null) {
                return 0L;
            }
            Long commentCount = fileModel.getCommentCount();
            long jLongValue = commentCount != null ? commentCount.longValue() : 0L;
            Long annotationCount = fileModel.getAnnotationCount();
            return jLongValue + (annotationCount != null ? annotationCount.longValue() : 0L);
        }

        public final boolean getHasSharedLink() {
            return this.itemModel.getSharedLink() != null;
        }

        public final ItemThumbnail getItemThumbnail() {
            return this.thumbnailState.getThumbnail();
        }
    }

    /* JADX INFO: compiled from: ItemReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "", "<init>", "()V", "Clicked", "LongClicked", "CheckboxClicked", "MenuClicked", "UpdateClicked", "ThumbnailAction", "UpdateOfflineState", "ObserveOfflineState", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$CheckboxClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$Clicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$LongClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$MenuClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$ObserveOfflineState;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$ThumbnailAction;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$UpdateClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$UpdateOfflineState;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$Clicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Clicked extends Action {
            public static final int $stable = 0;
            public static final Clicked INSTANCE = new Clicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Clicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 38598552;
            }

            public String toString() {
                return "Clicked";
            }

            private Clicked() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$LongClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LongClicked extends Action {
            public static final int $stable = 0;
            public static final LongClicked INSTANCE = new LongClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LongClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 59155708;
            }

            public String toString() {
                return "LongClicked";
            }

            private LongClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$CheckboxClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CheckboxClicked extends Action {
            public static final int $stable = 0;
            public static final CheckboxClicked INSTANCE = new CheckboxClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CheckboxClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1901510315;
            }

            public String toString() {
                return "CheckboxClicked";
            }

            private CheckboxClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$MenuClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MenuClicked extends Action {
            public static final int $stable = 0;
            public static final MenuClicked INSTANCE = new MenuClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MenuClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1143119687;
            }

            public String toString() {
                return "MenuClicked";
            }

            private MenuClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$UpdateClicked;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateClicked extends Action {
            public static final int $stable = 0;
            public static final UpdateClicked INSTANCE = new UpdateClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -619087409;
            }

            public String toString() {
                return "UpdateClicked";
            }

            private UpdateClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$ThumbnailAction;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", "getAction", "()Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ThumbnailAction extends Action implements Embedded<ItemThumbnailReducer.Action> {
            public static final int $stable = ItemThumbnailReducer.Action.$stable;
            private final ItemThumbnailReducer.Action action;

            public static /* synthetic */ ThumbnailAction copy$default(ThumbnailAction thumbnailAction, ItemThumbnailReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = thumbnailAction.action;
                }
                return thumbnailAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }

            public final ThumbnailAction copy(ItemThumbnailReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ThumbnailAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ThumbnailAction) && Intrinsics.areEqual(this.action, ((ThumbnailAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ThumbnailAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThumbnailAction(ItemThumbnailReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemThumbnailReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$UpdateOfflineState;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "offlineState", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "<init>", "(Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;)V", "getOfflineState", "()Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateOfflineState extends Action {
            public static final int $stable = 0;
            private final BoxModelOfflineManager.State offlineState;

            public static /* synthetic */ UpdateOfflineState copy$default(UpdateOfflineState updateOfflineState, BoxModelOfflineManager.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = updateOfflineState.offlineState;
                }
                return updateOfflineState.copy(state);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxModelOfflineManager.State getOfflineState() {
                return this.offlineState;
            }

            public final UpdateOfflineState copy(BoxModelOfflineManager.State offlineState) {
                Intrinsics.checkNotNullParameter(offlineState, "offlineState");
                return new UpdateOfflineState(offlineState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateOfflineState) && this.offlineState == ((UpdateOfflineState) other).offlineState;
            }

            public int hashCode() {
                return this.offlineState.hashCode();
            }

            public String toString() {
                return "UpdateOfflineState(offlineState=" + this.offlineState + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateOfflineState(BoxModelOfflineManager.State offlineState) {
                super(null);
                Intrinsics.checkNotNullParameter(offlineState, "offlineState");
                this.offlineState = offlineState;
            }

            public final BoxModelOfflineManager.State getOfflineState() {
                return this.offlineState;
            }
        }

        /* JADX INFO: compiled from: ItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action$ObserveOfflineState;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ObserveOfflineState extends Action {
            public static final int $stable = 0;
            public static final ObserveOfflineState INSTANCE = new ObserveOfflineState();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ObserveOfflineState)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -651616869;
            }

            public String toString() {
                return "ObserveOfflineState";
            }

            private ObserveOfflineState() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceOfflineState(State state, Action action) {
        if (action instanceof Action.UpdateOfflineState) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, ((Action.UpdateOfflineState) action).getOfflineState(), null, 23, null), null, 2, null);
        }
        if (action instanceof Action.ObserveOfflineState) {
            final Flow<BoxModelOfflineManager.State> stateFlow = this.environment.getBoxModelOfflineManagerWrapper().getStateFlow(state.getItemModel().getItemId());
            return new ReducerResult<>(state, EffectKt.toEffect(new Flow<Action>() { // from class: com.box.android.browse.cpl.itemsList.ItemReducer$reduceOfflineState$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super ItemReducer.Action> flowCollector, Continuation continuation) {
                    Object objCollect = stateFlow.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemReducer$reduceOfflineState$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemReducer$reduceOfflineState$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemReducer$reduceOfflineState$$inlined$map$1$2", f = "ItemReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            ItemReducer.Action.UpdateOfflineState updateOfflineState = new ItemReducer.Action.UpdateOfflineState((BoxModelOfflineManager.State) obj);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(updateOfflineState, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }).cancellable(INSTANCE.offlineStateEffectId(state.getUniqueCancelEffectKey()), true));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: compiled from: ItemReducer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemReducer$Companion;", "", "<init>", "()V", "offlineStateEffectId", "", "cancelKey", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String offlineStateEffectId(String cancelKey) {
            Intrinsics.checkNotNullParameter(cancelKey, "cancelKey");
            String str = String.format("OFFLINE_STATE_EFFECT_ID:%s", Arrays.copyOf(new Object[]{cancelKey}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }
}
