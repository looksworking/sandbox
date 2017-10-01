package org.looksworking.sandbox.misc;

public class IpTest {
    public static void main(String[] args) {
        System.out.println(check("192.168.15.7", "192.168.17.1/12"));
    }

    public static boolean check(String ipaddr, String ipnet) {
        int check_ip = aton(ipaddr);
        String[] parts = ipnet.split("/");
        int base_ip = aton(parts[0]);
        int mask = Integer.parseInt(parts[1]);
        return (check_ip >> (32 - mask)) == (base_ip >> (32 - mask));
    }

    public static int aton(String ipaddr) {
        String[] parts = ipaddr.split("\\.");
        int ip = 0;
        for (int i = 0; i < 4; i++) {
            ip += Integer.parseInt(parts[i]) << ((3 - i) * 8);
        }
        return ip;
    }
}