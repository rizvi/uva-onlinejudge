/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addhoc2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Masudul Haque
 */
public class Acm187 {

    public static byte[] cinbuf = new byte[1024];
    public static final boolean WINDOWS = System.getProperty("os.name").startsWith("Windows");
    public static String readToken() {
        int offset = 0;
        int bytedata = -1;

        try {
            bytedata = System.in.read();
            while (bytedata == 9 || bytedata == 10 || bytedata == 13 || bytedata == 32) {
                bytedata = System.in.read();
            }

            // 載入單字的字元
            while (bytedata != -1) {
                if (bytedata == 9 || bytedata == 10 || bytedata == 13 || bytedata == 32) {
                    break;
                } else {
                    cinbuf[offset++] = (byte) bytedata;
                }
                bytedata = System.in.read();
            }
        } catch (Exception e) {
        }

        if (offset + bytedata == -1) {
            return null; // 串流結束
        }
        return new String(cinbuf, 0, offset);
    }

    public static String readLine() {
        int offset = 0;
        int bytedata = -1;

        try {
            bytedata = System.in.read();
            while (bytedata != -1) {
                if (bytedata == 10) {
                    break;
                } else {
                    if (bytedata > 126) {
                        throw new RuntimeException("偵測到非 ASCII 字元");
                    }
                    cinbuf[offset++] = (byte) bytedata;
                }
                bytedata = System.in.read();
            }
        } catch (Exception e) {
        }

        if (offset + bytedata == -1) {
            return null; // 串流結束
        }
        if (WINDOWS && cinbuf[offset - 1] == '\r') {
            offset--;
        }

        return new String(cinbuf, 0, offset);
    }

    // 轉成 int 型態 (比 Integer.parseInt() 快)
    public static int parseInt(String s) {
        int i;
        int mul = 10;
        int value;

        if (s.charAt(0) == '-') {
            value = 48 - s.charAt(s.length() - 1);
            for (i = s.length() - 2; i >= 1; i--) {
                value -= (s.charAt(i) - 48) * mul;
                mul *= 10;
            }
        } else {
            value = s.charAt(s.length() - 1) - 48;
            for (i = s.length() - 2; i >= 0; i--) {
                value += (s.charAt(i) - 48) * mul;
                mul *= 10;
            }
        }

        return value;
    }

    public static void main(String[] args) {
        String iid;
        String item;
        String line = readLine();
        Map<String, String> items = new HashMap<String, String>();

        // 讀取名目表
        iid = line.substring(0, 3);
        while (!iid.equals("000")) {
            item = line.substring(3);
            items.put(iid, item);
            line = readLine();
            iid = line.substring(0, 3);
        }

        // 讀取交易資料
        int cents;
        int sum;
        String token = readToken();
        String tid = token.substring(0, 3);
        String prevtid;
        StringBuffer sbuf = new StringBuffer();

        while (!tid.equals("000")) {
            iid = token.substring(3);
            cents = parseInt(readToken());
            sum = cents;
            sbuf.append("*** Transaction " + tid + " is out of balance ***\n");
            sbuf.append(String.format("%s %-30s %10.2f\n", iid, items.get(iid), cents / 100.0));
            prevtid = tid;

            token = readToken();
            tid = token.substring(0, 3);
            while (tid.equals(prevtid)) {
                iid = token.substring(3);
                cents = parseInt(readToken());
                sum += cents;
                sbuf.append(String.format("%s %-30s %10.2f\n", iid, items.get(iid), cents / 100.0));
                prevtid = tid;

                token = readToken();
                tid = token.substring(0, 3);
            }

            if (sum != 0) {
                sbuf.append(String.format("999 Out of Balance                 %10.2f\n", sum * -0.01));
                System.out.println(sbuf);
            }

            sbuf.delete(0, sbuf.length());
        }
    }
}
