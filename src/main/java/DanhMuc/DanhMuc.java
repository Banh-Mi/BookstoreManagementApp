/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DanhMuc;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author VONG VINH LOI
 */
public class DanhMuc {
    private String kind;
    private JPanel jpn;

    public DanhMuc() {
    }

    public DanhMuc(String kind, JPanel jpn) {
        this.kind = kind;
        this.jpn = jpn;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    
}
