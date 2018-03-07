/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vorkjoonis;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author erike
 */
public class Vorkjoonis extends JPanel{
    
    java.util.List<double[]> seisud;
    static java.util.List<Integer> tiim1 = new ArrayList<Integer>();
    static java.util.List<Integer> tiim2 = new ArrayList<Integer>();
    
    public java.util.List<double[]> tooSeisud() throws FileNotFoundException{
        if (seisud == null){
            seisud=new ArrayList<>();
            try{
                FileReader in = new FileReader("seisud.txt");
                BufferedReader br = new BufferedReader(in);
                
                String rida = br.readLine();
                while (rida!=null){
                    String[] tulemus = rida.split(",");
                    System.out.println(Arrays.toString(tulemus));
                    rida = br.readLine();
                }
            } catch(IOException ex){
            }
        }
        return null;
    }
    void joonistaSeisudT1(Graphics g){
        int i;
        int sum = 0;
        for (i = 0; i < tiim1.size(); i++){
            g.fillOval((int)(tiim1.get(i)), getHeight() - (int)(tiim1.get(i)), 5, 5);
            g.setColor(Color.BLUE);
            sum = sum + (int) tiim1.get(i);
        }
        int avg = sum / tiim1.size();
        System.out.println(avg);
        g.drawLine(0, getHeight() - avg, 400, getHeight() - avg);
    }
    void joonistaSeisudT2(Graphics g){
        int i;
        int sum = 0;
        for (i = 0; i < tiim2.size(); i++){
            g.fillOval((int)(tiim2.get(i)), getHeight() - (int)(tiim2.get(i)), 5, 5);
            g.setColor(Color.RED);
            sum = sum + (int) tiim2.get(i);
        }
        int avg = sum / tiim1.size();
        System.out.println(avg);
        g.drawLine(0, getHeight() - avg, 400, getHeight() - avg);
    }
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double koef=10;
        joonistaSeisudT1(g);
        joonistaSeisudT2(g);
    }
    public static void main(String[] args) throws FileNotFoundException {
        java.util.List<String[]> seisud;
        try{
                FileReader in = new FileReader("E:\\kool\\progepõhi\\t04vorkjoonis\\vorkjoonis\\src\\vorkjoonis\\seisud.txt");
                BufferedReader br = new BufferedReader(in);
                
                String rida = br.readLine();
                JFrame f = new JFrame("Õunte joonis");
                f.getContentPane().add(new Vorkjoonis());
                f.setSize(400, 300);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                while (rida!=null){
                    String[] tulemus = rida.split(",");
                    String tulemusStr = Arrays.toString(tulemus);
                    String[] tulemusSing = tulemusStr.split(":");
                    String tiim1Score = tulemusSing[0];
                    int tiim1Scoreint;
                    int tiim2Scoreint;
                    tiim1Score = tiim1Score.replaceAll("\\[", "");
                    tiim1Scoreint = Integer.parseInt(tiim1Score);
                    String tiim2Score = tulemusSing[1];
                    tiim2Score = tiim2Score.replaceAll("\\]", "");
                    tiim2Scoreint = Integer.parseInt(tiim2Score);
                    tiim1.add(tiim1Scoreint);
                    tiim2.add(tiim2Scoreint);
                    rida = br.readLine();
                }
                br.close();
            } catch(Exception ex){
                System.out.println("Probleem: "+ex);
        }
    }
    
}
