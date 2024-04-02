/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortingAlgorithms;

import java.awt.Color;
import java.util.Vector;

    



/**
 *
 * @author a.yusupova
 */
public abstract class TSortThread extends Thread{
    
    /**
     * Pointer to graphics object that the figure is to be drawn on
     */
    protected java.awt.Graphics graphics;
    protected int[] FSortArray;
    protected int size;
    protected int FA, FB, FI, FJ;
    
    
    protected TSortThread(int[] array, java.awt.Graphics g){
        this.graphics = g;
        FSortArray = array;
        size = FSortArray.length;
        
        g.setColor(Color.white);
//        g.fillRect(0, 0, 
//                g.getClipBounds().width, g.getClipBounds().height);
    }

    @Override
    public void run() {
        this.Sort(FSortArray);
        System.out.println("Exited");
    }
    
    
//    { Since DoVisualSwap uses a VCL component (i.e., the TPaintBox) it should never
//  be called directly by this thread.  DoVisualSwap should be called by passing
//  it to the Synchronize method which causes DoVisualSwap to be executed by the
//  main VCL thread, avoiding multi-thread conflicts. See VisualSwap for an
//  example of calling Synchronize. }
//
//procedure TSortThread.DoVisualSwap;
//begin
//  with FBox do
//  begin
//    Canvas.Pen.Color := clBtnFace;
//    PaintLine(Canvas, FI, FA);
//    PaintLine(Canvas, FJ, FB);
//    Canvas.Pen.Color := clRed;
//    PaintLine(Canvas, FI, FB);
//    PaintLine(Canvas, FJ, FA);
//  end;
//end;
    
    private void DoVisualSwap()
    {
        Color old = graphics.getColor();
        PaintLine(graphics, FI, FA);
        PaintLine(graphics, FJ, FB);
        graphics.setColor(Color.red);
        PaintLine(graphics, FI, FB);
        PaintLine(graphics, FJ, FA);
        
        graphics.setColor(old);
        
    }

    
//    procedure PaintLine(Canvas: TCanvas; I, Len: Integer);
//begin
//  Canvas.PolyLine([Point(0, I * 2 + 1), Point(Len, I * 2 + 1)]);
//end;
    
    private void PaintLine(java.awt.Graphics g, int I, int len)
    {
        g.drawLine(0, I * 2 + 1, len, I * 2 + 1);
    }


//    procedure TSortThread.VisualSwap(A, B, I, J: Integer);
//begin
//  FA := A;
//  FB := B;
//  FI := I;
//  FJ := J;
//  Synchronize(DoVisualSwap);
//end;

    protected void VisualSwap(int A, int B, int I, int J)
    {
        FA = A;//  FA := A;
        FB = B;//  FB := B;
        FI = I;//  FI := I;
        FJ = J;//  FJ := J;
        
        synchronized (graphics) {
            this.DoVisualSwap();
        }
    }
    
//    procedure Sort(var A: array of Integer); virtual; abstract;
    public abstract void Sort(int[] array);


  
    
    
}
