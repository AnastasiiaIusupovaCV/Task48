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
public class TBubbleSort extends TSortThread{

    public TBubbleSort(int[] array, Graphics g) {
        super(array, g);
    }

//    procedure TBubbleSort.Sort(var A: array of Integer);
//var
//  I, J, T: Integer;
//begin
//  for I := High(A) downto Low(A) do
//    for J := Low(A) to High(A) - 1 do
//      if A[J] > A[J + 1] then
//      begin
//        VisualSwap(A[J], A[J + 1], J, J + 1);
//        T := A[J];
//        A[J] := A[J + 1];
//        A[J + 1] := T;
//        if Terminated then Exit;
//      end;
//end;

    @Override
    public void Sort(int[] array) {
        
        int t=0;
        int size = array.length;
        
        for(int i=0;i<size;++i)
            for(int j=0;j<size-1;++j)
            {
                
                if(array[j]>array[j+1])
                {
                    VisualSwap(array[j],array[j+1], j, j+1);
                    
                    t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
    }
    
}
