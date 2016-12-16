/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dy.fw.util;

/**
 *
 * @author duyi
 */
public class ReflectUtil {

    public static String getSetMethod(String fieldName) {
        StringBuilder sb = new StringBuilder();
        sb.append("set");
        sb.append(fieldName.substring(0, 1).toUpperCase());
        sb.append(fieldName.substring(1));
        return sb.toString();
    }
}
