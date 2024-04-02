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
public class TSelectionSort extends TSortThread{

    public TSelectionSort(int[] array, Graphics g) {
        super(array, g);
    }
/*
    procedure TSelectionSort.Sort(var A: array of Integer);
var
  I, J, T: Integer;
begin
  for I := Low(A) to High(A) - 1 do
    for J := High(A) downto I + 1 do
      if A[I] > A[J] then
      begin
        VisualSwap(A[I], A[J], I, J);
        T := A[I];
        A[I] := A[J];
        A[J] := T;
        if Terminated then Exit;
      end;
end;
    
    */
    @Override
    public void Sort(int[] array) {
        int size = array.length;
        int t=0;
        
        for(int i=0;i<size;++i)
            for(int j=size-1;j>i+1;--j)
            {
                if(array[i]>array[j])
                {
                    VisualSwap(array[i],array[j], i, j);
                    
                    t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
    }
    
}
