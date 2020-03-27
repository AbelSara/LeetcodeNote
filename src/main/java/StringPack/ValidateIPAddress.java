package StringPack;

/**
 * @author Honghan Zhu
 * @leetcode 468
 * @grade medium
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        int flag = -1;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                flag = 0;
                break;
            } else if (IP.charAt(i) == ':') {
                flag = 1;
                break;
            }
        }
        String res = "Neither";
        if (flag == 0) {
            res = IPv4(IP) ? "IPv4" : res;
        } else if (flag == 1) {
            res = IPv6(IP) ? "IPv6" : res;
        }
        return res;
    }

    private boolean IPv4(String IP) {
        if (IP.charAt(IP.length() - 1) == '.')
            return false;
        String[] words = IP.split("\\.");
        if (words.length != 4)
            return false;
        for (String word : words) {
            int ip = 0;
            if (word.length() > 1 && word.charAt(0) == '0')
                return false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) > '9' || word.charAt(i) < '0')
                    return false;
                ip = ip * 10 + (word.charAt(i) - '0');
            }
            if (ip > 255 || ip < 0 || word.length() <= 0)
                return false;
        }
        return true;
    }

    private boolean IPv6(String IP) {
        if (IP.charAt(IP.length() - 1) == ':')
            return false;
        String[] ips = IP.split(":");
        if (ips.length != 8)
            return false;
        for (String ip : ips) {
            ip = ip.toLowerCase();
            for (int i = 0; i < ip.length(); i++) {
                char ipc = ip.charAt(i);
                if (ipc >= 'g' || !(ipc >= '0' && ipc <= '9' || ipc >= 'a' && ipc <= 'z'))
                    return false;
            }
            if (ip.length() <= 0 || ip.length() > 4)
                return false;
        }
        return true;
    }
}
