package com.zipcodewilmington;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        boolean result = false;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                result = true;
                break;
            } else {
                result =  false;
            }
        }
        return result;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reverseArray = new String[array.length];
        for(int i = 0; i < array.length; i++) {
            reverseArray[i] = array[array.length - 1 - i];
        }
        return reverseArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length - 1 - i]) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Character arrayChar = '0';
        Character alphaChar = '0';
        int count = 0;

        for (int i = 0; i < alphabet.length(); i++) {
            alphaChar = alphabet.charAt(i);

            first_inner_loop:
            for (int j = 0; j < array.length; j++) {

                second_inner_loop:
                for (int k = 0; k < array[j].length(); k++) {
                    arrayChar = array[j].charAt(k);
                    System.out.println(arrayChar);

                    if ( Character.toLowerCase(arrayChar) == alphaChar ) {
                        count += 1;
                        break first_inner_loop;
                    }
                }
            }
        }
        return count == 26;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToRemove) {
                count += 1;
            }
        }

        String[] newArray = new String[array.length - count];
        for (int j = 0, k=0; j < array.length; j++) {
            if (array[j] != valueToRemove) {
                newArray[k] = array[j];
                k++;
            }
        }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        int m = 1;
        int countDeletions = 0;
        while (m < array.length - countDeletions) {
            if ( array[m - 1].equals(array[m]) ) {
                for (int n = m - 1; n < array.length - 1 - countDeletions; n++) {
                    array[n] = array[n + 1];
                }
                countDeletions += 1;
            } else {
                m++;
            }
        }

        String[] arrayNoDupes = new String[array.length - countDeletions];
        System.arraycopy(array, 0, arrayNoDupes, 0, array.length - countDeletions);

        return arrayNoDupes;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if ( array[i - 1].equals(array[i] ) )  {
                count += 1;
            }
        }

        String[] arrayPackDupes = new String[array.length - count];
        int k = 1;

        outloop:
        for (int j = 0; j < arrayPackDupes.length; j++) {
            arrayPackDupes[j] = "";

            innerloop:
            while (k < array.length) {
                if ( array[k - 1].equals( array[k] ) ) {
                    arrayPackDupes[j] += array[k];
                    k++;
                } else if ( !(array[k - 1].equals( array[k])) ) {
                    arrayPackDupes[j] += array[k - 1];
                    k++;
                    break innerloop;
                }

            }
        }

        arrayPackDupes[arrayPackDupes.length - 1] += array[array.length - 1];

        return arrayPackDupes;
    }


}
