/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


/**
 *
 * @author BanhMi88
 */
public class GetSource {

    private static final String sourceLight = "images/light/";
    private static final String sourceDark = "images/dark/";
    
    public static String Image(String fileName) {
        return sourceLight + fileName;
    }
}
