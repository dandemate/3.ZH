/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csoki;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author hallgato
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String[] token;
        String line;
        List<Csokigyar> lista = new ArrayList<>();
        Csokigyar cs;
        
        
        while((line = br.readLine())!=null){
            token = line.split(";");
            String[] alapanyagok = new String[token.length-2];
            
            for(int i=0; i<alapanyagok.length; i++){
                alapanyagok[i] = token[i+2];
            }
            cs = new Csokigyar(token[0], alapanyagok, Integer.parseInt(token[1]));
            if(!(lista.contains(cs)))
                lista.add(cs);
        }
        br.close();
        Collections.sort(lista);
        FileWriter fw = new FileWriter("rcsoki.txt");
        
        for (Csokigyar i : lista) {
            if(i.getAlapanyagok().length>=2){
                fw.write(i.getCsokiFajta()+" ");
                for (String s : i.mibolKeszul()) {
                    fw.write(s+" ");
                }
                fw.write(i.getKakaóTartalma()+"");
                fw.write("\n");
            }
        }
        
        fw.close();
        
        
    }
}
