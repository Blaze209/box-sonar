package com.geniusscansdk.structureddata.reader;

import com.box.androidsdk.content.models.BoxIterator;
import com.geniusscansdk.ocr.RectangleF;
import com.geniusscansdk.ocr.SpatialString;
import com.geniusscansdk.ocr.SpatialStringKt;
import com.geniusscansdk.ocr.SpatialText;
import com.geniusscansdk.structureddata.ReceiptCategory;
import com.geniusscansdk.structureddata.data.MerchantData;
import java.io.IOException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MerchantReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\u0010\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002J \u0010\u0012\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/MerchantReader;", "", "merchantData", "Lcom/geniusscansdk/structureddata/data/MerchantData;", "<init>", "(Lcom/geniusscansdk/structureddata/data/MerchantData;)V", "merchant", "", "spatialText", "Lcom/geniusscansdk/ocr/SpatialText;", "category", "Lcom/geniusscansdk/structureddata/ReceiptCategory;", "previousMerchants", "", "clean", "Lcom/geniusscansdk/ocr/SpatialString;", "findMatch", "wordList", "findURLMatch", "rawText", "linkHosts", "Ljava/net/URL;", "text", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MerchantReader {
    private final MerchantData merchantData;

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantReader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MerchantReader(MerchantData merchantData) {
        Intrinsics.checkNotNullParameter(merchantData, "merchantData");
        this.merchantData = merchantData;
    }

    public /* synthetic */ MerchantReader(MerchantData merchantData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MerchantData() : merchantData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String merchant$default(MerchantReader merchantReader, SpatialText spatialText, ReceiptCategory receiptCategory, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return merchantReader.merchant(spatialText, receiptCategory, list);
    }

    public final String merchant(SpatialText spatialText, ReceiptCategory category, List<String> previousMerchants) throws IOException {
        String strFindMatch;
        Intrinsics.checkNotNullParameter(spatialText, "spatialText");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(previousMerchants, "previousMerchants");
        List<SpatialString> listClean = clean(spatialText);
        if (!previousMerchants.isEmpty() && (strFindMatch = findMatch(listClean, previousMerchants)) != null) {
            return strFindMatch;
        }
        String strFindMatch2 = findMatch(listClean, (List) MapsKt.getValue(this.merchantData.getMerchantResources(), category));
        if (strFindMatch2 != null) {
            return strFindMatch2;
        }
        String strFindMatch3 = findMatch(listClean, (List) MapsKt.getValue(this.merchantData.getMerchantResources(), ReceiptCategory.SUPERMARKET));
        if (strFindMatch3 != null) {
            return strFindMatch3;
        }
        String strFindURLMatch = findURLMatch(listClean, CollectionsKt.joinToString$default(listClean, "\n", null, null, 0, null, new Function1() { // from class: com.geniusscansdk.structureddata.reader.MerchantReader$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MerchantReader.merchant$lambda$4((SpatialString) obj);
            }
        }, 30, null));
        if (strFindURLMatch != null) {
            return strFindURLMatch;
        }
        if (listClean.isEmpty()) {
            return null;
        }
        return ((SpatialString) CollectionsKt.first((List) listClean)).getString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence merchant$lambda$4(SpatialString spatialString) throws IOException {
        Intrinsics.checkNotNullParameter(spatialString, "spatialString");
        String string = spatialString.getString();
        StringBuilder sb = new StringBuilder();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = string.charAt(i);
            if (!CharsKt.isWhitespace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private final List<SpatialString> clean(final SpatialText spatialText) {
        final List listListOf = CollectionsKt.listOf((Object[]) new String[]{"welcome to", "welcome", "feedback", "thank you", "survey", "duplicate", BoxIterator.FIELD_ORDER, "use your", "rebate", "card", "payment", "invoice", "carte", "bancaire", "sans contact", "server", "bartender", "swiped", "bill", "save"});
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(SequencesKt.map(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(spatialText.getSpatialString()), new Function1() { // from class: com.geniusscansdk.structureddata.reader.MerchantReader$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MerchantReader.clean$lambda$6(spatialText, (SpatialString) obj));
            }
        }), new Function1() { // from class: com.geniusscansdk.structureddata.reader.MerchantReader$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MerchantReader.clean$lambda$8((SpatialString) obj));
            }
        }), new Function1() { // from class: com.geniusscansdk.structureddata.reader.MerchantReader$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MerchantReader.clean$lambda$10((SpatialString) obj);
            }
        }), new Function1() { // from class: com.geniusscansdk.structureddata.reader.MerchantReader$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MerchantReader.clean$lambda$11(listListOf, (SpatialString) obj));
            }
        }), new Function1() { // from class: com.geniusscansdk.structureddata.reader.MerchantReader$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MerchantReader.clean$lambda$12((SpatialString) obj));
            }
        }), new Function1() { // from class: com.geniusscansdk.structureddata.reader.MerchantReader$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MerchantReader.clean$lambda$13((SpatialString) obj));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clean$lambda$6(SpatialText spatialText, SpatialString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SpatialStringKt.intersects(it, 0.2f, spatialText.topPositionsOfText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clean$lambda$8(SpatialString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RectangleF boundingBox = it.getBoundingBox();
        return boundingBox == null || boundingBox.getLeft() < ((float) (it.getDocumentSize().getWidth() / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SpatialString clean$lambda$10(SpatialString spatialString) {
        Intrinsics.checkNotNullParameter(spatialString, "spatialString");
        String strReplace = StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(spatialString.getString(), "welcome to", "", true), "welcone to", "", true), "shopping at", "", true), "visiting", "", true);
        int length = strReplace.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zIsLetter = Character.isLetter(strReplace.charAt(!z ? i : length));
            if (z) {
                if (zIsLetter) {
                    break;
                }
                length--;
            } else if (zIsLetter) {
                z = true;
            } else {
                i++;
            }
        }
        return new SpatialString(StringsKt.trim((CharSequence) strReplace.subSequence(i, length + 1).toString()).toString(), spatialString.getConfidence(), spatialString.getBoundingBox(), spatialString.getDocumentSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clean$lambda$11(List list, SpatialString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (StringsKt.contains((CharSequence) it.getString(), (CharSequence) it2.next(), true)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clean$lambda$12(SpatialString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Pattern patternCompile = Pattern.compile("^\\s*[0-9]+.*", 2);
        Intrinsics.checkNotNull(patternCompile);
        return new Regex(patternCompile).find(it.getString(), 0) == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clean$lambda$13(SpatialString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getString().length() > 3;
    }

    private final String findMatch(List<SpatialString> spatialText, List<String> wordList) throws IOException {
        for (SpatialString spatialString : spatialText) {
            for (String str : wordList) {
                String strNormalize = Normalizer.normalize(spatialString.getString(), Normalizer.Form.NFD);
                String strNormalize2 = Normalizer.normalize(str, Normalizer.Form.NFD);
                Intrinsics.checkNotNull(strNormalize);
                String str2 = strNormalize;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str2.length(); i++) {
                    char cCharAt = str2.charAt(i);
                    if (!CharsKt.isWhitespace(cCharAt)) {
                        sb.append(cCharAt);
                    }
                }
                String lowerCase = sb.toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String str3 = lowerCase;
                Intrinsics.checkNotNull(strNormalize2);
                String str4 = strNormalize2;
                StringBuilder sb2 = new StringBuilder();
                for (int i2 = 0; i2 < str4.length(); i2++) {
                    char cCharAt2 = str4.charAt(i2);
                    if (!CharsKt.isWhitespace(cCharAt2)) {
                        sb2.append(cCharAt2);
                    }
                }
                String lowerCase2 = sb2.toString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) str3, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    return str;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a4  */
    private final String findURLMatch(List<SpatialString> spatialText, String rawText) throws IOException {
        String value;
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        List<URL> listLinkHosts = linkHosts(rawText);
        if (listLinkHosts.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : spatialText) {
            SpatialString spatialString = (SpatialString) obj;
            Iterator<URL> it = listLinkHosts.iterator();
            while (true) {
                if (it.hasNext()) {
                    String host = it.next().getHost();
                    if (host != null) {
                        String lowerCase = spatialString.getString().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) host, false, 2, (Object) null)) {
                            break;
                        }
                    }
                }
                arrayList.add(obj);
                break;
            }
        }
        ArrayList arrayList2 = arrayList;
        Pattern patternCompile = Pattern.compile("([a-z]+\\.)?(?<domain>[a-z\\-]+)(\\.[a-z]+){1,2}", 2);
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it2 = listLinkHosts.iterator();
        while (it2.hasNext()) {
            String host2 = ((URL) it2.next()).getHost();
            if (host2 != null) {
                Intrinsics.checkNotNull(patternCompile);
                MatchResult matchResultFind$default = Regex.find$default(new Regex(patternCompile), host2, 0, 2, null);
                if (matchResultFind$default == null || (groups = matchResultFind$default.getGroups()) == null || (matchGroup = groups.get(2)) == null) {
                    value = null;
                } else {
                    value = matchGroup.getValue();
                }
            } else {
                value = null;
            }
            if (value != null) {
                arrayList3.add(value);
            }
        }
        ArrayList<String> arrayList4 = arrayList3;
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            String string = ((SpatialString) it3.next()).getString();
            StringBuilder sb = new StringBuilder();
            int length = string.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = string.charAt(i);
                if (!CharsKt.isWhitespace(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String lowerCase2 = sb.toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            for (String str : arrayList4) {
                if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str, false, 2, (Object) null)) {
                    return str;
                }
            }
        }
        return null;
    }

    private final List<URL> linkHosts(String text) throws IOException {
        ArrayList arrayList = new ArrayList();
        Pattern patternCompile = Pattern.compile("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})", 42);
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        MatchResult matchResultFind = new Regex(patternCompile).find(text, 0);
        if (matchResultFind != null) {
            String value = matchResultFind.getValue();
            StringBuilder sb = new StringBuilder();
            int length = value.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = value.charAt(i);
                if (!CharsKt.isWhitespace(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            if (!StringsKt.startsWith$default(string, "http", false, 2, (Object) null)) {
                string = "http://" + string;
            }
            arrayList.add(new URL(string));
        }
        return arrayList;
    }
}
