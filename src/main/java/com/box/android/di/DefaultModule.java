package com.box.android.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.application.UserContextMigration;
import com.box.android.boxai.AiCenterSessionInfoProviderImpl;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.controller.AndroidForWorkController;
import com.box.android.coreservices.api.ShareController;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBatchOperations;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.AiCenterSessionInfoProvider;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.identity.IDeviceIdStorage;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.localrepo.BoxLocalCache;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.modelcontroller.MoCoAdminSettings;
import com.box.android.modelcontroller.MoCoBatchOperations;
import com.box.android.modelcontroller.MoCoBoxRecentEvents;
import com.box.android.modelcontroller.MoCoBoxTransfers;
import com.box.android.modelcontroller.ShareModelController;
import com.box.android.pushnotification.BoxPushNotifContainer;
import com.box.android.requests.BoxApiFeatures;
import com.box.android.requests.BoxApiInvitee;
import com.box.android.utilities.DeviceIdStorage;
import com.box.android.utilities.FileStorage;
import com.box.android.utilities.IStorage;
import com.box.androidsdk.content.BoxApiBookmark;
import com.box.androidsdk.content.BoxApiComment;
import com.box.androidsdk.content.BoxApiEvent;
import com.box.androidsdk.content.BoxApiMetadata;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.BoxApiRecentItems;
import com.box.androidsdk.content.BoxApiSearch;
import com.box.androidsdk.content.BoxApiShare;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequestRecentItems;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiSearch;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0011"}, d2 = {"Lcom/box/android/di/DefaultModule;", "", "<init>", "()V", "provideBoxCache", "Lcom/box/androidsdk/content/BoxCache;", SemanticAttributes.DbSystemValues.CACHE, "Lcom/box/android/localrepo/BoxLocalCache;", "provideShareController", "Lcom/box/android/coreservices/api/ShareController;", "controller", "Lcom/box/android/modelcontroller/ShareModelController;", "provideSessionInfoProvider", "Lcom/box/android/domain/analytics/AiCenterSessionInfoProvider;", "aiCenterSessionInfoProviderImpl", "Lcom/box/android/boxai/AiCenterSessionInfoProviderImpl;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class DefaultModule {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract BoxCache provideBoxCache(BoxLocalCache cache);

    @Binds
    public abstract AiCenterSessionInfoProvider provideSessionInfoProvider(AiCenterSessionInfoProviderImpl aiCenterSessionInfoProviderImpl);

    @Binds
    public abstract ShareController provideShareController(ShareModelController controller);

    /* JADX INFO: compiled from: DefaultModule.kt */
    @Metadata(d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J8\u0010&\u001a\u00020'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010-\u001a\u00020.2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007J\u0010\u00103\u001a\u0002042\u0006\u00101\u001a\u000205H\u0007J\u0010\u00106\u001a\u0002072\u0006\u00101\u001a\u000208H\u0007J\u0010\u00109\u001a\u00020:2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010;\u001a\u00020<H\u0007J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020<2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020>H\u0007J\u0018\u0010C\u001a\u00020D2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0007H\u0007J\u0010\u0010F\u001a\u00020G2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0007J\u0018\u0010L\u001a\u00020M2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010N\u001a\u00020O2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J0\u0010P\u001a\u00020Q2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010R\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010S\u001a\u00020T2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010U\u001a\u00020V2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010W\u001a\u00020X2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010Y\u001a\u00020Z2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010[\u001a\u00020\\H\u0007J\b\u0010]\u001a\u00020^H\u0007¨\u0006_"}, d2 = {"Lcom/box/android/di/DefaultModule$Companion;", "", "<init>", "()V", "provideAndroidForWorkController", "Lcom/box/android/controller/AndroidForWorkController;", "restrictionsManager", "Lcom/box/android/domain/services/IAppRestrictionsManager;", "context", "Landroid/content/Context;", "provideBoxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "provideBoxApiWeblink", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;", "provideSearchApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiSearch;", "provideBoxApiShare", "Lcom/box/androidsdk/content/BoxApiShare;", "provideBoxApiUser", "Lcom/box/androidsdk/content/BoxApiUser;", "provideBoxApiCollaboration", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiCollaboration;", SemanticAttributes.DbSystemValues.CACHE, "Lcom/box/androidsdk/content/BoxCache;", "provideBoxApiCollections", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiCollections;", "provideBoxApiComment", "Lcom/box/androidsdk/content/BoxApiComment;", "provideBoxApiEvent", "Lcom/box/androidsdk/content/BoxApiEvent;", "provideBoxApiMetadata", "Lcom/box/androidsdk/content/BoxApiMetadata;", "provideBoxApiPreview", "Lcom/box/androidsdk/content/BoxApiPreview;", "provideBoxApiSearch", "Lcom/box/androidsdk/content/BoxApiSearch;", "provideBoxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "folderApi", "fileApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "weblinkApi", "collectionsApi", "provideBoxExtendedApiPreview", "Lcom/box/androidsdk/content/BoxExtendedApiPreview;", "provideIMoCoBoxTransfers", "Lcom/box/android/coreservices/modelcontroller/IMoCoBoxTransfers;", "moco", "Lcom/box/android/modelcontroller/MoCoBoxTransfers;", "providesIMoCoBatchOperations", "Lcom/box/android/coreservices/modelcontroller/IMoCoBatchOperations;", "Lcom/box/android/modelcontroller/MoCoBatchOperations;", "provideIMoCoAdminSettings", "Lcom/box/android/coreservices/modelcontroller/IMoCoAdminSettings;", "Lcom/box/android/modelcontroller/MoCoAdminSettings;", "providesSortPreferences", "Lcom/box/android/domain/localrepo/LocalSortPreferences;", "provideStorage", "Lcom/box/android/utilities/IStorage;", "provideDeviceIdStorage", "Lcom/box/android/domain/identity/IDeviceIdStorage;", "storage", "provideDeviceId", "Lcom/box/android/domain/identity/DeviceId;", "deviceIdStorage", "provideUserContextMigration", "Lcom/box/android/application/UserContextMigration;", "appRestrictionsManager", "provideLocalBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "provideBoxPushNotifContainer", "Lcom/box/android/pushnotification/BoxPushNotifContainer;", "localSharedPreferences", "Lcom/box/android/localrepo/LocalSharedPreferences;", "provideBoxApiBookmark", "Lcom/box/androidsdk/content/BoxApiBookmark;", "provideBoxApiInvitee", "Lcom/box/android/requests/BoxApiInvitee;", "providesIMoCoBoxRecentEvents", "Lcom/box/android/coreservices/modelcontroller/IMoCoBoxRecentEvents;", "privateApi", "provideBoxApiFeatures", "Lcom/box/android/requests/BoxApiFeatures;", "provideBoxApiRecentItems", "Lcom/box/androidsdk/content/BoxApiRecentItems;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "provideBoxApiLocalRecentItems", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiRecentItems;", "provideSearchActionLogHelper", "Lcom/box/android/browse/fragments/SearchFragment$SearchActionLogHelper;", "provideTimeLogHelper", "Lcom/box/android/browse/fragments/SearchFragment$TimeLogHelper;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        @Singleton
        public final AndroidForWorkController provideAndroidForWorkController(IAppRestrictionsManager restrictionsManager, Context context) {
            Intrinsics.checkNotNullParameter(restrictionsManager, "restrictionsManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new AndroidForWorkController(context, restrictionsManager);
        }

        @Provides
        @Singleton
        public final BoxExtendedApiFolder provideBoxExtendedApiFolder(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiFolder(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxExtendedApiWeblink provideBoxApiWeblink(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiWeblink(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxExtendedApiSearch provideSearchApi(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiSearch(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiShare provideBoxApiShare(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiShare(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiUser provideBoxApiUser(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            final BoxSession boxSession = userContextManager.getBoxSession(context);
            return new BoxApiUser(boxSession) { // from class: com.box.android.di.DefaultModule$Companion$provideBoxApiUser$1
            };
        }

        @Provides
        @Singleton
        public final BoxExtendedApiCollaboration provideBoxApiCollaboration(IUserContextManager userContextManager, BoxCache cache, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(cache, "cache");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiCollaboration(userContextManager.getBoxSession(context), cache);
        }

        @Provides
        @Singleton
        public final BoxExtendedApiCollections provideBoxApiCollections(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiCollections(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiComment provideBoxApiComment(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiComment(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiEvent provideBoxApiEvent(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiEvent(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiMetadata provideBoxApiMetadata(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiMetadata(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiPreview provideBoxApiPreview(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiPreview(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiSearch provideBoxApiSearch(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiSearch(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiPrivate provideBoxApiPrivate(IUserContextManager userContextManager, BoxExtendedApiFolder folderApi, BoxExtendedApiFile fileApi, BoxExtendedApiWeblink weblinkApi, BoxExtendedApiCollections collectionsApi, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(folderApi, "folderApi");
            Intrinsics.checkNotNullParameter(fileApi, "fileApi");
            Intrinsics.checkNotNullParameter(weblinkApi, "weblinkApi");
            Intrinsics.checkNotNullParameter(collectionsApi, "collectionsApi");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiPrivate(userContextManager.getBoxSession(context), folderApi, fileApi, weblinkApi, collectionsApi);
        }

        @Provides
        @Singleton
        public final BoxExtendedApiPreview provideBoxExtendedApiPreview(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiPreview(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final IMoCoBoxTransfers provideIMoCoBoxTransfers(MoCoBoxTransfers moco) {
            Intrinsics.checkNotNullParameter(moco, "moco");
            return moco;
        }

        @Provides
        @Singleton
        public final IMoCoBatchOperations providesIMoCoBatchOperations(MoCoBatchOperations moco) {
            Intrinsics.checkNotNullParameter(moco, "moco");
            return moco;
        }

        @Provides
        @Singleton
        public final IMoCoAdminSettings provideIMoCoAdminSettings(MoCoAdminSettings moco) {
            Intrinsics.checkNotNullParameter(moco, "moco");
            return moco;
        }

        @Provides
        @Singleton
        public final LocalSortPreferences providesSortPreferences(IUserContextManager userContextManager) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            return new LocalSortPreferences(userContextManager);
        }

        @Provides
        @Singleton
        public final IStorage provideStorage() {
            return new FileStorage();
        }

        @Provides
        @Singleton
        public final IDeviceIdStorage provideDeviceIdStorage(IStorage storage, Context context) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            return new DeviceIdStorage((Application) applicationContext, storage);
        }

        @Provides
        @Singleton
        public final DeviceId provideDeviceId(IDeviceIdStorage deviceIdStorage) {
            Intrinsics.checkNotNullParameter(deviceIdStorage, "deviceIdStorage");
            return new DeviceId(deviceIdStorage);
        }

        @Provides
        @Singleton
        public final UserContextMigration provideUserContextMigration(Context context, IAppRestrictionsManager appRestrictionsManager) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
            return new UserContextMigration(context, appRestrictionsManager.isAppFedrampHighCompliant());
        }

        @Provides
        @Singleton
        public final LocalBroadcastManager provideLocalBroadcastManager(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(...)");
            return localBroadcastManager;
        }

        @Provides
        @Singleton
        public final BoxPushNotifContainer provideBoxPushNotifContainer(LocalSharedPreferences localSharedPreferences) {
            Intrinsics.checkNotNullParameter(localSharedPreferences, "localSharedPreferences");
            SharedPreferences sharedPreferences = localSharedPreferences.getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
            return new BoxPushNotifContainer(sharedPreferences);
        }

        @Provides
        @Singleton
        public final BoxApiBookmark provideBoxApiBookmark(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiBookmark(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiInvitee provideBoxApiInvitee(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiInvitee(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final IMoCoBoxRecentEvents providesIMoCoBoxRecentEvents(IUserContextManager userContextManager, BoxApiPrivate privateApi, BoxExtendedApiFile fileApi, BoxExtendedApiFolder folderApi, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(privateApi, "privateApi");
            Intrinsics.checkNotNullParameter(fileApi, "fileApi");
            Intrinsics.checkNotNullParameter(folderApi, "folderApi");
            Intrinsics.checkNotNullParameter(context, "context");
            return new MoCoBoxRecentEvents(context, userContextManager, privateApi, folderApi, fileApi);
        }

        @Provides
        @Singleton
        public final BoxApiFeatures provideBoxApiFeatures(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxApiFeatures(userContextManager.getBoxSession(context));
        }

        @Provides
        @Singleton
        public final BoxApiRecentItems provideBoxApiRecentItems(IUserContextManager userContextManager, final IntentServices intentServices, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(intentServices, "intentServices");
            Intrinsics.checkNotNullParameter(context, "context");
            final BoxSession boxSession = userContextManager.getBoxSession(context);
            return new BoxApiRecentItems(boxSession) { // from class: com.box.android.di.DefaultModule$Companion$provideBoxApiRecentItems$1
                @Override // com.box.androidsdk.content.BoxApiRecentItems
                public BoxRequestRecentItems.GetRecentItems getRecentItemsRequest() {
                    CustomBoxSession customBoxSession = new CustomBoxSession(this.mSession);
                    customBoxSession.setSharedLink(null);
                    customBoxSession.setPassword(null);
                    customBoxSession.setIntentServices(intentServices);
                    return new BoxRequestRecentItems.GetRecentItems(getRecentItemsUrl(), customBoxSession);
                }
            };
        }

        @Provides
        @Singleton
        public final BoxExtendedApiRecentItems provideBoxApiLocalRecentItems(IUserContextManager userContextManager, Context context) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxExtendedApiRecentItems(userContextManager.getBoxSession(context));
        }

        @Provides
        public final SearchFragment.SearchActionLogHelper provideSearchActionLogHelper() {
            return new SearchFragment.SearchActionLogHelper();
        }

        @Provides
        public final SearchFragment.TimeLogHelper provideTimeLogHelper() {
            return new SearchFragment.TimeLogHelper();
        }
    }
}
