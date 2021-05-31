public class Bichos{
    
    //Atributos
    int salud;
    String nombre;
    
    public Bichos(int s, String n){
        this.salud = s;
        this.nombre = n;
    }
    public int getSalud(){
        return this.salud;
    }
    public String toString(){
        String toStr = this.nombre + "-" + this.salud;
        return toStr;
    }
    public int DisminuirSalud(){
        this.salud = this.salud - 5;
        return this.salud;
    }
}