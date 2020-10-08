package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {
    final public boolean checkISBN(String isbn) {
        int sum=0;
        final int len = 10;
        if(isbn.length()==len) {
            for (int i = 0; i < isbn.length(); i++) {
                char c = isbn.charAt(i);
                if(!Character.isDigit(c) && i<9){
                    throw new NumberFormatException("ISBN can onl have numerical values");
                }
                if(c == 'X'){
                    sum +=10;
                }
                else{
                    sum +=Integer.parseInt(Character.toString(c)) * (len-i);
                }

            }
            if (sum % 11 == 0)
                return true;
            else
                return false;
        }
        else {
            throw new NumberFormatException("ISBN no.s must be 10 digits long");
        }

    }
}
