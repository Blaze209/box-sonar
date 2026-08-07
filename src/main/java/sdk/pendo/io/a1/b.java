package sdk.pendo.io.a1;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static String a(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th);
        while (th.getCause() != null) {
            th = th.getCause();
            sb.append("; caused by: ").append(th);
        }
        return sb.toString();
    }

    public static String a(Throwable th, Class cls) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (th != null) {
            if (!z) {
                sb.append("; caused by: ");
            }
            sb.append(th).append(" at ");
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (stackTraceElement.getClassName().equals(cls.getName())) {
                    sb.append("...omitted...");
                    break;
                }
                sb.append(stackTraceElement).append("; ");
            }
            th = th.getCause();
            z = false;
        }
        return sb.toString();
    }
}
