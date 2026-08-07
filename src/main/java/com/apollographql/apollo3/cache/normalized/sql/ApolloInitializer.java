package com.apollographql.apollo3.cache.normalized.sql;

import android.content.Context;
import androidx.startup.Initializer;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApolloInitializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/ApolloInitializer;", "Landroidx/startup/Initializer;", "", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "Companion", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloInitializer implements Initializer<Unit> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static Context context;

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Unit create(Context context2) {
        create2(context2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public void create2(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        INSTANCE.setContext$apollo_normalized_cache_sqlite_release(context2);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return new ArrayList();
    }

    /* JADX INFO: compiled from: ApolloInitializer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/sql/ApolloInitializer$Companion;", "", "()V", "context", "Landroid/content/Context;", "getContext$apollo_normalized_cache_sqlite_release", "()Landroid/content/Context;", "setContext$apollo_normalized_cache_sqlite_release", "(Landroid/content/Context;)V", "apollo-normalized-cache-sqlite_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Context getContext$apollo_normalized_cache_sqlite_release() {
            Context context = ApolloInitializer.context;
            if (context != null) {
                return context;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            return null;
        }

        public final void setContext$apollo_normalized_cache_sqlite_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            ApolloInitializer.context = context;
        }
    }
}
