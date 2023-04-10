/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brsgm;

/**
 *
 * @author LENOVO
 */
public class session {

    private static String u_username;
    private static String u_nama;
    private static String u_role;

    public static String getU_username() {
        return u_username;
    }

    public static void setU_username(String u_username) {
        session.u_username = u_username;
    }

    public static String getU_nama() {
        return u_nama;
    }

    public static void setU_nama(String u_nama) {
        session.u_nama = u_nama;
    }

    public static String getU_role() {
        return u_role;
    }

    public static void setU_role(String u_role) {
        session.u_role = u_role;
    }
}
