package com.donc.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donovan on 26/10/16.
 */
public class StringUtility {

    public static String reverse(String s) {
        List<String> tempArray = new ArrayList<>(s.length());
        for (int i=0; i<s.length(); i++) {
            tempArray.add(s.substring(i, i+1));
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i=tempArray.size()-1; i>=0; i--) {
            sb.append(tempArray.get(i));
        }
        return sb.toString();
    }
}
