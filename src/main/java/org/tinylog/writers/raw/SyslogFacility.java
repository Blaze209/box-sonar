package org.tinylog.writers.raw;

/* JADX INFO: loaded from: classes5.dex */
public enum SyslogFacility {
    KERN(0),
    USER(1),
    MAIL(2),
    DAEMON(3),
    AUTH(4),
    SYSLOG(5),
    LPR(6),
    NEWS(7),
    UUCP(8),
    CRON(9),
    AUTHPRIV(10),
    FTP(11),
    NTP(12),
    SECURITY(13),
    CONSOLE(14),
    CLOCK(15),
    LOCAL0(16),
    LOCAL1(17),
    LOCAL2(18),
    LOCAL3(19),
    LOCAL4(20),
    LOCAL5(21),
    LOCAL6(22),
    LOCAL7(23);

    private final int code;

    SyslogFacility(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
