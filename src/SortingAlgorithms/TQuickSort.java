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
        QuickSort(array, 0, array.length-1);

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
    
}
