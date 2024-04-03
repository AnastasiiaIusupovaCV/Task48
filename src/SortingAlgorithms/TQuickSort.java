/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortingAlgorithms;

import java.awt.Graphics;
import java.util.Vector;

/**
 *
 * @author a.yusupova
 */
public class TQuickSort extends TSortThread{

    public TQuickSort(int[] array, Graphics g) {
        super(array, g);
    }

    @Override
    public void Sort(int[] array) {
//        QuickSort(array, 0, array.length-1);
        QuickSortWiki(array, 0, array.length-1);

    }
    
    
//    procedure QuickSort(var A: array of Integer; iLo, iHi: Integer);
//  var
//    Lo, Hi, Mid, T: Integer;
//  begin
//    Lo := iLo;
//    Hi := iHi;
//    Mid := A[(Lo + Hi) div 2];
//    repeat
//      while A[Lo] < Mid do Inc(Lo);
//      while A[Hi] > Mid do Dec(Hi);
//      if Lo <= Hi then
//      begin
//        VisualSwap(A[Lo], A[Hi], Lo, Hi);
//        T := A[Lo];
//        A[Lo] := A[Hi];
//        A[Hi] := T;
//        Inc(Lo);
//        Dec(Hi);
//      end;
//    until Lo > Hi;
//    if Hi > iLo then QuickSort(A, iLo, Hi);
//    if Lo < iHi then QuickSort(A, Lo, iHi);
//    if Terminated then Exit;
//  end;
    
    private void QuickSort(int[] array, int iLo, int iHi)
    {
        int Lo, Hi, Mid, T;
        
        
        Lo = iLo;//    Lo := iLo;
        Hi = iHi;//    Hi := iHi;
        Mid = array[(Lo+Hi)/2];//    Mid := A[(Lo + Hi) div 2];
        do {

            while(array[Lo]<Mid ){ Lo++;} //      while A[Lo] < Mid do Inc(Lo);
            while(array[Hi]>Mid && Hi >= 0){ Hi--; }//      while A[Hi] > Mid do Dec(Hi);
            
            if(Lo <= Hi)//if Lo <= Hi then
            {
                VisualSwap(array[Lo], array[Hi], Lo, Hi);
                T = array[Lo];//        T := A[Lo];
                
                array[Lo] = array[Hi];//        A[Lo] := A[Hi];
                array[Hi] = T;//        A[Hi] := T;
                Lo++;//        Inc(Lo);
                Hi--;//        Dec(Hi);

            }
            
        } while (Lo > Hi);//    until Lo > Hi;
        
        if( Hi > iLo)//    if Hi > iLo then QuickSort(A, iLo, Hi);
            QuickSort(array, iLo, Hi);
        if (Lo < iHi)//    if Lo < iHi then QuickSort(A, Lo, iHi);
            QuickSort(array, Lo, iHi);

    }
    
 /*   
    // Sorts a (portion of an) array, divides it into partitions, then sorts those
algorithm quicksort(A, lo, hi) is 
  // Ensure indices are in correct order
  if lo >= hi || lo < 0 then 
    return
    
  // Partition array and get the pivot index
  p := partition(A, lo, hi) 
      
  // Sort the two partitions
  quicksort(A, lo, p - 1) // Left side of pivot
  quicksort(A, p + 1, hi) // Right side of pivot

// Divides array into two partitions
algorithm partition(A, lo, hi) is 
  pivot := A[hi] // Choose the last element as the pivot

  // Temporary pivot index
  i := lo - 1

  for j := lo to hi - 1 do 
    // If the current element is less than or equal to the pivot
    if A[j] <= pivot then 
      // Move the temporary pivot index forward
      i := i + 1
      // Swap the current element with the element at the temporary pivot index
      swap A[i] with A[j]

  // Move the pivot element to the correct pivot position (between the smaller and larger elements)
  i := i + 1
  swap A[i] with A[hi]
  return i // the pivot index

*/
    
    private void QuickSortWiki(int[] array, int lo, int hi)
    {
        // Ensure indices are in correct order
//        if lo >= hi || lo < 0 then return
        if (lo >= hi || lo < 0) return;
        
        // Partition array and get the pivot index
        int p = partition(array, lo, hi);
        // Sort the two partitions
        QuickSortWiki(array, lo, p - 1); // Left side of pivot
        QuickSortWiki(array, p + 1, hi); // Right side of pivot
          
        
    }
    
    int partition(int[] array, int lo, int hi)
    {
        int i=0;
        int t=0;
        int pivot = array[hi]; // Choose the last element as the pivot
        i = lo - 1; // Temporary pivot index

        //for j := lo to hi - 1 do 
        for(int j = lo; j< hi;j++){
          // If the current element is less than or equal to the pivot
          //if A[j] <= pivot then 
          if(array[j]<= pivot)
          {  // Move the temporary pivot index forward
            i = i + 1;
            VisualSwap(array[i], array[j], i, j);
            // Swap the current element with the element at the temporary pivot index
            // swap A[i] with A[j]
            t = array[i];
            array[i] = array[j];
            array[j] = t;
          }
        }
        // Move the pivot element to the correct pivot position (between the smaller and larger elements)
        i = i + 1;
        //swap A[i] with A[hi]
  
        VisualSwap(array[i], array[hi], i, hi);
        t = array[i];
        array[i] = array[hi];
        array[hi] = t;
  
  
        return i;
    }
}
