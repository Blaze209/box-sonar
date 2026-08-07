package sdk.pendo.io.l1;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private final Integer a;
    private final Integer b;
    private final a c;

    public enum a {
        SLICE_FROM,
        SLICE_TO,
        SLICE_BETWEEN
    }

    private d(Integer num, Integer num2, a aVar) {
        this.a = num;
        this.b = num2;
        this.c = aVar;
    }

    public Integer a() {
        return this.a;
    }

    public a b() {
        return this.c;
    }

    public Integer c() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Integer num = this.a;
        sb.append(num == null ? "" : num.toString());
        sb.append(":");
        Integer num2 = this.b;
        sb.append(num2 != null ? num2.toString() : "");
        sb.append("]");
        return sb.toString();
    }

    public static d a(String str) {
        a aVar;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isDigit(cCharAt) && cCharAt != '-' && cCharAt != ':') {
                throw new sdk.pendo.io.d1.f("Failed to parse SliceOperation: " + str);
            }
        }
        String[] strArrSplit = str.split(":");
        Integer numA = a(strArrSplit, 0);
        Integer numA2 = a(strArrSplit, 1);
        if (numA != null && numA2 == null) {
            aVar = a.SLICE_FROM;
        } else if (numA != null) {
            aVar = a.SLICE_BETWEEN;
        } else {
            if (numA2 == null) {
                throw new sdk.pendo.io.d1.f("Failed to parse SliceOperation: " + str);
            }
            aVar = a.SLICE_TO;
        }
        return new d(numA, numA2, aVar);
    }

    private static Integer a(String[] strArr, int i) {
        if (strArr.length <= i || strArr[i].equals("")) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(strArr[i]));
    }
}
