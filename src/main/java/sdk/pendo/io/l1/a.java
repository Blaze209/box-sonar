package sdk.pendo.io.l1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final Pattern b = Pattern.compile("\\s*,\\s*");
    private final List<Integer> a;

    private a(List<Integer> list) {
        this.a = Collections.unmodifiableList(list);
    }

    public List<Integer> a() {
        return this.a;
    }

    public boolean b() {
        return this.a.size() == 1;
    }

    public String toString() {
        return "[" + sdk.pendo.io.e1.i.a(",", this.a) + "]";
    }

    public static a a(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isDigit(cCharAt) && cCharAt != ',' && cCharAt != ' ' && cCharAt != '-') {
                throw new sdk.pendo.io.d1.f("Failed to parse ArrayIndexOperation: " + str);
            }
        }
        String[] strArrSplit = b.split(str, -1);
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            arrayList.add(b(str2));
        }
        return new a(arrayList);
    }

    private static Integer b(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception e) {
            throw new sdk.pendo.io.d1.f("Failed to parse token in ArrayIndexOperation: " + str, e);
        }
    }
}
