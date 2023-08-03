package algorithms.easy.defanging_an_ip_address_1108;

public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
