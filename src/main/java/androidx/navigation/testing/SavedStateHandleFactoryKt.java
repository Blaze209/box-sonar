package androidx.navigation.testing;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavArgument;
import androidx.navigation.NavType;
import androidx.navigation.NavTypeKt;
import androidx.navigation.serialization.RouteEncoder;
import androidx.navigation.serialization.RouteSerializerKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* JADX INFO: compiled from: SavedStateHandleFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001d\b\u0002\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0007\u0012\r\u0012\u000b\u0012\u0002\b\u00030\b¢\u0006\u0002\b\t0\u0006H\u0086\u0002¨\u0006\n"}, d2 = {"invoke", "Landroidx/lifecycle/SavedStateHandle;", "Landroidx/lifecycle/SavedStateHandle$Companion;", "route", "", "typeMap", "", "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "Lkotlin/jvm/JvmSuppressWildcards;", "navigation-testing"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandleFactoryKt {
    public static /* synthetic */ SavedStateHandle invoke$default(SavedStateHandle.Companion companion, Object obj, Map map, int i, Object obj2) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return invoke(companion, obj, map);
    }

    public static final SavedStateHandle invoke(SavedStateHandle.Companion companion, Object route, Map<KType, NavType<?>> typeMap) {
        Pair[] pairArr;
        Pair[] pairArr2;
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        KSerializer kSerializerSerializer = SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<NamedNavArgument> listGenerateNavArguments = RouteSerializerKt.generateNavArguments(kSerializerSerializer, typeMap);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listGenerateNavArguments, 10));
        for (NamedNavArgument namedNavArgument : listGenerateNavArguments) {
            arrayList.add((NavArgument) linkedHashMap.put(namedNavArgument.getName(), namedNavArgument.getArgument()));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
        }
        Map<String, List<String>> mapEncodeToArgMap = new RouteEncoder(kSerializerSerializer, linkedHashMap2).encodeToArgMap(route);
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList2 = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry2 : mapEmptyMap.entrySet()) {
                arrayList2.add(TuplesKt.to((String) entry2.getKey(), entry2.getValue()));
            }
            pairArr = (Pair[]) arrayList2.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m11040constructorimpl(bundleBundleOf);
        for (Map.Entry<String, List<String>> entry3 : mapEncodeToArgMap.entrySet()) {
            String key = entry3.getKey();
            NavType navType = (NavType) linkedHashMap2.get(entry3.getKey());
            if (navType == null) {
                throw new IllegalStateException(("SavedStateHandleFactory could not locate NavType for argument [" + key + "]. Pleaseprovide NavType in typeMap.").toString());
            }
            Map mapEmptyMap2 = MapsKt.emptyMap();
            if (mapEmptyMap2.isEmpty()) {
                pairArr2 = new Pair[0];
            } else {
                ArrayList arrayList3 = new ArrayList(mapEmptyMap2.size());
                for (Map.Entry entry4 : mapEmptyMap2.entrySet()) {
                    arrayList3.add(TuplesKt.to((String) entry4.getKey(), entry4.getValue()));
                }
                pairArr2 = (Pair[]) arrayList3.toArray(new Pair[0]);
            }
            Bundle bundleBundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr2, pairArr2.length));
            SavedStateWriter.m11040constructorimpl(bundleBundleOf2);
            if (navType instanceof CollectionNavType) {
                NavArgument navArgument = (NavArgument) linkedHashMap.get(key);
                Boolean boolValueOf = navArgument != null ? Boolean.valueOf(navArgument.getIsDefaultValuePresent()) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (!boolValueOf.booleanValue()) {
                    CollectionNavType collectionNavType = (CollectionNavType) navType;
                    collectionNavType.put(bundleBundleOf2, key, collectionNavType.emptyCollection());
                }
            }
            for (String str : entry3.getValue()) {
                try {
                    if (!SavedStateReader.m10955containsimpl(SavedStateReader.m10954constructorimpl(bundleBundleOf2), key)) {
                        NavTypeKt.parseAndPutFromUri(navType, bundleBundleOf2, key, str);
                    } else {
                        NavTypeKt.parseAndPutFromUri(navType, bundleBundleOf2, key, str, navType.get(bundleBundleOf2, key));
                    }
                } catch (IllegalArgumentException unused) {
                }
            }
            SavedStateWriter.m11044putAllimpl(SavedStateWriter.m11040constructorimpl(bundleBundleOf), bundleBundleOf2);
        }
        return new SavedStateHandle(SavedStateReader.m11035toMapimpl(SavedStateReader.m10954constructorimpl(bundleBundleOf)));
    }
}
