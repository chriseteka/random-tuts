/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Chris_Eteka
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numberOfWizards = 10;
        
        Scanner sc = new Scanner(System.in);
        int src = sc.nextInt();
        int dest = sc.nextInt();
        
        int matrix[][] = new int[numberOfWizards][];
        int i;
        for(i=0;i<numberOfWizards;i++){
            String line = sc.next();
            char[] ch = line.toCharArray();
            matrix[i] = new int[line.length()];            
            for(int j = 0; j < line.length(); j++) {
               matrix[i][j] = Character.getNumericValue(ch[j]);
            }
        }
        
        int[][] result = Solution.distance_path(src, dest, matrix);
        String[] sarr = Arrays.stream(result[1]).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.valueOf(result[0][0]) + " " + String.join("", sarr));
    }
    
}
