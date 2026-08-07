package com.geniusscansdk.structureddata.data;

import com.geniusscansdk.structureddata.ReceiptCategory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: MerchantData.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/geniusscansdk/structureddata/data/MerchantData;", "Lcom/geniusscansdk/structureddata/data/BaseData;", "<init>", "()V", "merchantResources", "", "Lcom/geniusscansdk/structureddata/ReceiptCategory;", "", "", "getMerchantResources", "()Ljava/util/Map;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MerchantData extends BaseData {
    private final Map<ReceiptCategory, List<String>> merchantResources = MapsKt.mapOf(TuplesKt.to(ReceiptCategory.GAS, loadDataFromResources("raw/gas_stations.txt")), TuplesKt.to(ReceiptCategory.TRANSPORTATION, CollectionsKt.emptyList()), TuplesKt.to(ReceiptCategory.RESTAURANT, loadDataFromResources("raw/restaurant_chains.txt")), TuplesKt.to(ReceiptCategory.SUPERMARKET, loadDataFromResources("raw/supermarket_chains.txt")), TuplesKt.to(ReceiptCategory.ACCOMMODATION, CollectionsKt.emptyList()), TuplesKt.to(ReceiptCategory.OTHER, loadDataFromResources("raw/other_chains.txt")));

    public final Map<ReceiptCategory, List<String>> getMerchantResources() {
        return this.merchantResources;
    }
}
