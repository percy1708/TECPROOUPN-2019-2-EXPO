
package Clases;
// esta es la barrita de carga, y su libreria, no se olviden que los comentarios se van a borrar 
import javax.swing.JProgressBar;

public class Cargar extends Thread{
    JProgressBar pro;
    public Cargar(JProgressBar pro){
        super();
        this.pro=pro;
    }
    public void run(){
        for(int i=1;i<=100;i++){
            pro.setValue(i);
            pausa(50);
        }
    }
    public void pausa(int mlseg){
        try {
            Thread.sleep(mlseg);
        }
        catch(Exception e){
        }
    }
    
}
