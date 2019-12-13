
package daoClases;

import Clases.ProductoA;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class daoProductoA {
    private ArrayList<ProductoA> pa;
    private String Archivo;
    public daoProductoA(String Archivo){
        pa=new ArrayList<ProductoA>();
        this.Archivo=Archivo;
        cargar(); //Nunca te olvides de esta madre cuando uses archivos!!
    }

    public daoProductoA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void agregar(ProductoA a){
        pa.add(a);
    }
    public ProductoA obtener(int i){
        return pa.get(i);
    }
    public int tamaño(){
        return pa.size();
    }
    public void eliminar(ProductoA obj){
        pa.remove(obj);
    }
    public ProductoA buscarCod(int cod){
        for(int i=0;i<tamaño();i++){
            if(String.valueOf(pa.get(i).getCodigo()).equalsIgnoreCase(String.valueOf(cod)))
                return pa.get(i);
        }
        return null;
    }
    public int getCorrelativo(){
        if(tamaño()==0){
            return 1000;
        }else{
            return obtener(tamaño() - 1).getCodigo()+1;
        }      
    }
    /*Implementar Archivos*/
   public void grabar(){
     try{  
         PrintWriter pw;
         String linea;
         pw = new PrintWriter(new FileWriter(Archivo));         
         for(int i=0;i<tamaño();i++){
             linea = (obtener(i).getCodigo()+ ";" +
                        obtener(i).getMarca()+ ";" +
                        obtener(i).getModelo()+ ";" +
                        obtener(i).getAño()+ ";" + 
                        obtener(i).getColor()+ ";" +
                        obtener(i).getTipo()+ ";" +
                        obtener(i).getPrecio()
                     );
             pw.println(linea); 
         }  
         pw.close();
      }
      catch(Exception e){
         System.out.println(e.getMessage());
      }      
    }
    public void cargar(){
        try{
            BufferedReader br;
            String linea = null;
            String[] array = null;
            
            br = new BufferedReader(new FileReader(Archivo));
            while((linea = br.readLine())!= null){
                array = linea.split(";");
                ProductoA a = new ProductoA(Integer.parseInt(array[0].trim()),
                    array[1].trim(),
                    array[2].trim(),
                    array[3].trim(),
                    array[4].trim(),
                    array[5].trim(),
                    Double.parseDouble(array[6].trim()));
                agregar(a);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
