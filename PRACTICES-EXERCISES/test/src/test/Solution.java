/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Chris_Eteka
 */
public class Solution {
    public static int[][] distance_path (int src, int dest, int[][]wizards) {
        int result[][] = new int[2][];
        int minCost = 0;
        int[] minPath = null;
        // Put your code here to calculate minCost and minPath
        List<Integer> minPathList = new ArrayList<>();
        List<int[]> wizardList = Arrays.asList(wizards);
        
        int nextIndex = 0;
        for (int i = 0; i < wizardList.size(); i++){
            
            int[] array = wizardList.get(nextIndex);
            nextIndex = Arrays.stream(array).min().getAsInt();
            if(!minPathList.contains(nextIndex)){
                minCost += Math.pow((wizardList.indexOf(array) - nextIndex), 2);
                minPathList.add(nextIndex);
                minPath[minPath.length - 1] = nextIndex;
            }
        }
        // Return the result, do not change the structure
        result[0] = new int[]{ minCost };
        if (minPath == null) { minPath = new int[] {}; }        
        result[1] = minPath;
        return result;
    }
}
