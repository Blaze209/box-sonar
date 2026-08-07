package com.apollographql.apollo3.api.test;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.CompiledType;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TestResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JW\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2$\u0010\n\u001a \u0012\u001a\b\u0001\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\f\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/apollographql/apollo3/api/test/TestResolver;", "", Gen204FileActivityEventLogger.ACTION_RESOLVE, ExifInterface.GPS_DIRECTION_TRUE, "responseName", "", "compiledType", "Lcom/apollographql/apollo3/api/CompiledType;", "enumValues", "", "ctors", "", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lcom/apollographql/apollo3/api/CompiledType;Ljava/util/List;[Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface TestResolver {
    <T> T resolve(String responseName, CompiledType compiledType, List<String> enumValues, Function0<? extends Map<String, ? extends Object>>[] ctors);
}
