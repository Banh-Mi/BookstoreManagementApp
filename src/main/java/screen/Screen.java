/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screen;

import javax.swing.JPanel;

/**
 *
 * @author VONG VINH LOI
 */
public class Screen {

    private String type;
    private JPanel jpn;

    public Screen() {
    }

    public Screen(String type, JPanel jpn) {
        this.type = type;
        this.jpn = jpn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

}
