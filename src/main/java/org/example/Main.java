package org.example;

public class Main {
    public static int checkStrongPassword(String password) {
        int changes = 0, repeating = 0;
        boolean upperCase = false, lowerCase = false, digit = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                lowerCase = true;
                //verificam daca avem lowercase
            } else if (Character.isUpperCase(password.charAt(i))) {
                upperCase = true;
                //verificam daca avem uppercase
            } else if (Character.isDigit(password.charAt(i))) {
                digit = true;
                //verificam daca avem cifra
            }

            if (i >= 2 && password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
                repeating++;
                i++;
                //verificam daca un caracter se repeta de trei ori consecutiv
            }
        }

        changes += repeating;
        //adaugam repetarea/repetarile de 3 ori consecutiva/consecutive a unui/unor caracter(e) la schimbari necesare

        if (!upperCase) {
            changes++;
            //daca nu avem uppercase, avem nevoie de o schimbare
        }
        if (!lowerCase) {
            changes++;
            //daca nu avem lowercase, avem nevoie de o schimbare
        }
        if (!digit) {
            changes++;
            //daca nu avem cifra, avem nevoie de o schimbare
        }

        if (password.length() < 6) {
            changes += 6 - (password.length() + changes);
            //daca parola are mai putin de 6 caractere, folosim formula de mai sus pentru
            //a determina numarul de schimbari necesare
        } else if (password.length() > 20) {
            changes += password.length() - 20;
            //daca parola are mai mult de 20 de caractere, folosim formula de mai sus pentru
            //a determina numarul de schimbari necesare
        }
        return changes;
        //returnam numarul de schimbari necesare pentru ca parola sa fie sigura
    }
    public static void main(String[] args) {
        String password = "abcdA3";
        System.out.println(checkStrongPassword(password));

    }
}