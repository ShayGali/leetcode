class Solution {
    public String validIPAddress(String queryIP) {
        if(isIPv4(queryIP)) return "IPv4";
        else if (isIPv6(queryIP)) return "IPv6";
        return "Neither";
    }
    
    boolean isIPv4(String ip){
        if(ip.endsWith("."))return false;
        String[] octs = ip.split("\\.");
        if(octs.length != 4) return false;
        for(String oc : octs){
            // יותר מ 3 ספרות
            if (oc.length() < 1 || oc.length() > 3) return false;
            // אורך 1
            if(oc.length() == 1){
                if((oc.charAt(0) < '0' || oc.charAt(0) > '9'))
                    return false;
            // אורך 2
            }else if(oc.length() == 2){
                // אם הראשון הוא 0 או לא ספרה
                if(oc.charAt(0) <= '0' || oc.charAt(0) > '9') return false;
                // אם השני הוא ספרה
                if(oc.charAt(1) < '0' || oc.charAt(1) > '9') return false;
            }
            // אורך 3
            else{
                // אם הוא 0 או גדול מ 299
                if(oc.charAt(0) <= '0' || oc.charAt(0) > '2') return false;
                // אם הוא ב 200
                if(oc.charAt(0) == '2'){ 
                    // אם הוא גדול מ 259 או לא ספרה
                    if(oc.charAt(1) > '5' || oc.charAt(1) < '0') return false;
                    // אם הוא 250 ומשהו
                    if(oc.charAt(1) == '5'){
                        
                        // אם הוא גדול מ 255
                        if(oc.charAt(2) < '0' || oc.charAt(2) > '5') return false;
                    }
                    // אני יודע שהוא בין 249 ל -200
                    else if(oc.charAt(2) < '0' || oc.charAt(2) > '9') return false;
                }else{
                    // אני יודע שהוא 100 ומשהו
                    if(oc.charAt(1) < '0'|| oc.charAt(1) > '9' || oc.charAt(2) < '0'|| oc.charAt(2) > '9')
                        return false;
                }
            }
        }
        return true;
    }

    boolean isIPv6(String ip){
        if(ip.endsWith(":"))return false;
        String[] octs = ip.split(":");
        if(octs.length !=8) return false;
        for(String oct : octs){
            if(oct.length() == 0 || oct.length() > 4) return false;
            if(!isHex(oct)) return false;
        }
        return true;
    }
    
    boolean isHex(String s){
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            if(!(
                (ch>='0' && ch <='9') ||
                (ch>='a' && ch <='f') ||
                (ch>='A' && ch <='F')
            )) return false;
        }
        return true;
    }

}
