package com.box.android.data.mappers;

import com.apollographql.apollo3.cache.normalized.FetchPolicy;
import com.box.android.domain.configuration.DataPolicy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataPolicyMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"cachePolicyRepresentation", "Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;", "Lcom/box/android/domain/configuration/DataPolicy;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DataPolicyMapperKt {

    /* JADX INFO: compiled from: DataPolicyMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataPolicy.values().length];
            try {
                iArr[DataPolicy.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataPolicy.REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataPolicy.CACHE_OR_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataPolicy.CACHE_AND_REMOTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DataPolicy.REMOTE_OR_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final FetchPolicy cachePolicyRepresentation(DataPolicy dataPolicy) {
        Intrinsics.checkNotNullParameter(dataPolicy, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[dataPolicy.ordinal()];
        if (i == 1) {
            return FetchPolicy.CacheOnly;
        }
        if (i == 2) {
            return FetchPolicy.NetworkOnly;
        }
        if (i == 3) {
            return FetchPolicy.CacheFirst;
        }
        if (i == 4) {
            return FetchPolicy.CacheAndNetwork;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return FetchPolicy.NetworkFirst;
    }
}
