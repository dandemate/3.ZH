/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csoki;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author hallgato
 */
public class Csokigyar implements Etelgyar, Comparable<Csokigyar>{
    private String csokiFajta;
    private String[] alapanyagok;
    private int kakaóTartalma;

    public Csokigyar(String csokiFajta, String[] alapanyagok, int kakaóTartalma) {
        this.csokiFajta = csokiFajta;
        this.alapanyagok = alapanyagok;
        this.kakaóTartalma = kakaóTartalma;
    }

    @Override
    public String[] mibolKeszul() {
        return this.alapanyagok;
    }

    @Override
    public boolean megfeleloMinoseg() throws SilanyMinosegException {
        try{
            if(this.kakaóTartalma>50)
                return true;
            else if(this.kakaóTartalma<=0 && this.kakaóTartalma<50)
                return false;
            else
                throw new SilanyMinosegException("Nem igazi csoki!");
        }catch(SilanyMinosegException s){
            System.out.println(s);
        }
        return false;
    }

    public String getCsokiFajta() {
        return csokiFajta;
    }

    public void setCsokiFajta(String csokiFajta) {
        this.csokiFajta = csokiFajta;
    }

    public String[] getAlapanyagok() {
        return alapanyagok;
    }

    public void setAlapanyagok(String[] alapanyagok) {
        this.alapanyagok = alapanyagok;
    }

    public int getKakaóTartalma() {
        return kakaóTartalma;
    }

    public void setKakaóTartalma(int kakaóTartalma) {
        this.kakaóTartalma = kakaóTartalma;
    }

    @Override
    public String toString() {
        return "Csokigyar{" + "csokiFajta=" + csokiFajta + ", alapanyagok=" + alapanyagok + ", kaka\u00f3Tartalma=" + kakaóTartalma + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        Csokigyar o = (Csokigyar)obj;
        if(o == null || !(o instanceof Csokigyar)){
            return false;
        }
        
        return this.kakaóTartalma==o.getKakaóTartalma() && this.csokiFajta.equals(o.getCsokiFajta());
    }

    @Override
    public int compareTo(Csokigyar o) {
        int result = this.kakaóTartalma-o.kakaóTartalma;
        if(result>0) return -1;
        else if(result<0) return 1;
        else{
            result = this.alapanyagok.length - o.alapanyagok.length;
            if(result>0) return 1;
            else if(result<0) return -1;
            else{
                return this.csokiFajta.compareTo(o.csokiFajta);
            }
        }
                
    }
    
    
    
    
}
