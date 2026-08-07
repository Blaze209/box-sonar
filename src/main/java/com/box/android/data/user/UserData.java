package com.box.android.data.user;

import android.content.Context;
import com.apollographql.apollo3.ApolloClient;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: UserData.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002,-B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dJ5\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0\u001d2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020!0#J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\nH\u0002J\u000e\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006."}, d2 = {"Lcom/box/android/data/user/UserData;", "", "context", "Landroid/content/Context;", "databaseProvider", "Lcom/box/android/data/user/DatabaseProvider;", "<init>", "(Landroid/content/Context;Lcom/box/android/data/user/DatabaseProvider;)V", "users", "", "", "Lcom/box/android/data/user/UserData$UserMetadata;", "getUsers$annotations", "()V", "getUsers", "()Ljava/util/Map;", "setUsers", "(Ljava/util/Map;)V", "currentUserContextId", "getCurrentUserContextId", "()Ljava/lang/String;", "setCurrentUserContextId", "(Ljava/lang/String;)V", "createUser", "", "userContextId", "logout", "shutdownUser", "getBoxDatabase", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/persistence/BoxDatabase;", "Lcom/box/android/data/datasource/CacheError;", "retrieveApolloClient", "Lcom/apollographql/apollo3/ApolloClient;", "createApolloClient", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "apolloDbName", "createDb", "boxBbName", "getBoxDbName", "isGQLDb", "", "UserMetadata", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserData {
    private static final String DB_NAME_PREFIX = "boxdata";
    private static final String DB_NAME_SEPARATOR = "_";
    private static final String DB_NAME_SUFFIX = ".db";
    private static final String GQL_DB_NAME_PREFIX = "GQL_Boxdata";
    private static final String LOGTAG = "UserData";
    private final Context context;
    private String currentUserContextId;
    private final DatabaseProvider databaseProvider;
    private Map<String, UserMetadata> users;

    public static /* synthetic */ void getUsers$annotations() {
    }

    @Inject
    public UserData(Context context, DatabaseProvider databaseProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(databaseProvider, "databaseProvider");
        this.context = context;
        this.databaseProvider = databaseProvider;
        this.users = new LinkedHashMap();
    }

    /* JADX INFO: compiled from: UserData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/user/UserData$UserMetadata;", "", "boxDatabase", "Lcom/box/android/data/persistence/BoxDatabase;", "apolloClient", "Lcom/apollographql/apollo3/ApolloClient;", "<init>", "(Lcom/box/android/data/persistence/BoxDatabase;Lcom/apollographql/apollo3/ApolloClient;)V", "getBoxDatabase", "()Lcom/box/android/data/persistence/BoxDatabase;", "setBoxDatabase", "(Lcom/box/android/data/persistence/BoxDatabase;)V", "getApolloClient", "()Lcom/apollographql/apollo3/ApolloClient;", "setApolloClient", "(Lcom/apollographql/apollo3/ApolloClient;)V", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UserMetadata {
        private ApolloClient apolloClient;
        private BoxDatabase boxDatabase;

        /* JADX WARN: Multi-variable type inference failed */
        public UserMetadata() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ UserMetadata copy$default(UserMetadata userMetadata, BoxDatabase boxDatabase, ApolloClient apolloClient, int i, Object obj) {
            if ((i & 1) != 0) {
                boxDatabase = userMetadata.boxDatabase;
            }
            if ((i & 2) != 0) {
                apolloClient = userMetadata.apolloClient;
            }
            return userMetadata.copy(boxDatabase, apolloClient);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BoxDatabase getBoxDatabase() {
            return this.boxDatabase;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ApolloClient getApolloClient() {
            return this.apolloClient;
        }

        public final UserMetadata copy(BoxDatabase boxDatabase, ApolloClient apolloClient) {
            return new UserMetadata(boxDatabase, apolloClient);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserMetadata)) {
                return false;
            }
            UserMetadata userMetadata = (UserMetadata) other;
            return Intrinsics.areEqual(this.boxDatabase, userMetadata.boxDatabase) && Intrinsics.areEqual(this.apolloClient, userMetadata.apolloClient);
        }

        public int hashCode() {
            BoxDatabase boxDatabase = this.boxDatabase;
            int iHashCode = (boxDatabase == null ? 0 : boxDatabase.hashCode()) * 31;
            ApolloClient apolloClient = this.apolloClient;
            return iHashCode + (apolloClient != null ? apolloClient.hashCode() : 0);
        }

        public String toString() {
            return "UserMetadata(boxDatabase=" + this.boxDatabase + ", apolloClient=" + this.apolloClient + ")";
        }

        public UserMetadata(BoxDatabase boxDatabase, ApolloClient apolloClient) {
            this.boxDatabase = boxDatabase;
            this.apolloClient = apolloClient;
        }

        public /* synthetic */ UserMetadata(BoxDatabase boxDatabase, ApolloClient apolloClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : boxDatabase, (i & 2) != 0 ? null : apolloClient);
        }

        public final ApolloClient getApolloClient() {
            return this.apolloClient;
        }

        public final BoxDatabase getBoxDatabase() {
            return this.boxDatabase;
        }

        public final void setApolloClient(ApolloClient apolloClient) {
            this.apolloClient = apolloClient;
        }

        public final void setBoxDatabase(BoxDatabase boxDatabase) {
            this.boxDatabase = boxDatabase;
        }
    }

    public final Map<String, UserMetadata> getUsers() {
        return this.users;
    }

    public final void setUsers(Map<String, UserMetadata> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.users = map;
    }

    public final String getCurrentUserContextId() {
        return this.currentUserContextId;
    }

    public final void setCurrentUserContextId(String str) {
        this.currentUserContextId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void createUser(String userContextId) {
        Intrinsics.checkNotNullParameter(userContextId, "userContextId");
        BoxLogUtils.d(LOGTAG, "Creating user " + userContextId);
        this.currentUserContextId = userContextId;
        this.users.put(userContextId, new UserMetadata(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public final synchronized void logout() {
        BoxDatabase boxDatabase;
        UserMetadata userMetadata = this.users.get(this.currentUserContextId);
        if (userMetadata != null && (boxDatabase = userMetadata.getBoxDatabase()) != null) {
            BoxLogUtils.d(LOGTAG, "Deleting " + boxDatabase.getOpenHelper().getDatabaseName());
            if (!this.context.deleteDatabase(boxDatabase.getOpenHelper().getDatabaseName())) {
                BoxLogUtils.e(LOGTAG, "Error deleting box database " + boxDatabase.getOpenHelper().getDatabaseName());
            }
        }
        if (userMetadata != null && userMetadata.getApolloClient() != null) {
            BoxLogUtils.d(LOGTAG, "Deleting " + getBoxDbName(true));
            if (!this.context.deleteDatabase(getBoxDbName(true))) {
                BoxLogUtils.e(LOGTAG, "Error deleting apollo box database " + getBoxDbName(true));
            }
        }
        TypeIntrinsics.asMutableMap(this.users).remove(this.currentUserContextId);
        this.currentUserContextId = null;
    }

    public final synchronized void shutdownUser() {
        BoxDatabase boxDatabase;
        UserMetadata userMetadata = this.users.get(this.currentUserContextId);
        if (userMetadata != null && (boxDatabase = userMetadata.getBoxDatabase()) != null) {
            BoxLogUtils.d(LOGTAG, "Closing " + boxDatabase.getOpenHelper().getDatabaseName());
            boxDatabase.close();
        }
        String str = this.currentUserContextId;
        if (str != null) {
            this.users.put(str, null);
        }
        this.currentUserContextId = null;
    }

    public final synchronized Result<BoxDatabase, CacheError> getBoxDatabase() {
        Result.Error error;
        String str = this.currentUserContextId;
        UserMetadata userMetadata = str != null ? this.users.get(str) : null;
        if (userMetadata != null) {
            try {
                BoxDatabase boxDatabase = userMetadata.getBoxDatabase();
                if (boxDatabase == null) {
                    boxDatabase = createDb(getBoxDbName(false));
                }
                userMetadata.setBoxDatabase(boxDatabase);
                error = new Result.Success(boxDatabase);
            } catch (Exception unused) {
                error = new Result.Error(CacheError.DatabaseInitError.INSTANCE);
            }
        } else {
            error = new Result.Error(CacheError.NoUserLoggedInError.INSTANCE);
        }
        return error;
    }

    public final Result<ApolloClient, CacheError> retrieveApolloClient(Function1<? super String, ApolloClient> createApolloClient) {
        Intrinsics.checkNotNullParameter(createApolloClient, "createApolloClient");
        String str = this.currentUserContextId;
        UserMetadata userMetadata = str != null ? this.users.get(str) : null;
        if (userMetadata != null) {
            try {
                ApolloClient apolloClient = userMetadata.getApolloClient();
                if (apolloClient == null) {
                    apolloClient = createApolloClient.invoke(getBoxDbName(true));
                }
                userMetadata.setApolloClient(apolloClient);
                return new Result.Success(apolloClient);
            } catch (Exception unused) {
                return new Result.Error(CacheError.DatabaseInitError.INSTANCE);
            }
        }
        return new Result.Error(CacheError.NoUserLoggedInError.INSTANCE);
    }

    private final BoxDatabase createDb(String boxBbName) {
        return (BoxDatabase) this.databaseProvider.createDb(this.context, BoxDatabase.class, boxBbName);
    }

    public final String getBoxDbName(boolean isGQLDb) {
        String str = this.currentUserContextId;
        if (str == null) {
            str = "";
        }
        return isGQLDb ? "GQL_Boxdata_" + str + DB_NAME_SUFFIX : "boxdata_" + str + DB_NAME_SUFFIX;
    }
}
