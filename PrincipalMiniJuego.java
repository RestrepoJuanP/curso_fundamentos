import java.util.*;
public class PrincipalMiniJuego{
    //Metodos
    public static void main(String args[]){
        //Atributos
        boolean estado = false;
        int filas = 2;
        int columnas = 2;
        
        //Inicio del programa - Que desicion desea tomar 
        Scanner entrada = new Scanner(System.in);
        System.out.println("Opcion 1: Iniciar el programa");
        System.out.println("Opcion 2: Salir del programa");
        System.out.println("¿Que desea hacer?");
        int decision = entrada.nextInt();
        
        while(decision != 2){
            switch(decision){
                case 1:
                    //Tablero del juego
                    Bichos Bichos [][] = new Bichos [filas][columnas];
                    
                    //Cantidad de bichos, tipo y ubicacion
                    int CantidadBichos = (int) (Math.random() * 4 + 1);
                    for(int y = 0; y<CantidadBichos; y++){
                        int aleatorio = (int) (Math.random() * 2 + 1);
                        Bichos b1;
                        if(aleatorio == 1){
                            b1 = new BichosNormales(10, "BN");
                        }else{
                            b1 = new BichosAliens(20, "BA");
                        }
                        switch(y){
                            case 0:
                            Bichos [0][0] = b1;
                            break;
                            case 1:
                            Bichos [0][1] = b1;
                            break;
                            case 2:
                            Bichos [1][0] = b1;
                            break;
                            case 3:
                            Bichos [1][1] = b1;
                            break;
                        }
                    }
                    
                    //Impresion del tablero
                    System.out.println("--[0][0]--[0][1]--");
                    System.out.println("| " + Bichos [0][0]  +  " | " + Bichos [0][1] + " |");
                    System.out.println("-------------------");
                    System.out.println("| " + Bichos [1][0]  +  " | " + Bichos [1][1] + " |");
                    System.out.println("--[1][0]--[1][1]--");
                    
                    //Ciclo de ataque
                    while(estado == false){
                        System.out.println("¿Que fila desea atacar?");
                        int UbicacionFila = entrada.nextInt();
                        if(UbicacionFila > 2){
                            System.out.println("Ubicacion incorrecta");
                        }
                        System.out.println("¿Que columna desea atacar?");
                        int UbicacionColumna = entrada.nextInt();
                        if(UbicacionColumna > 2){
                            System.out.println("Ubicacion incorrecta");
                        }
                        
                        //Disminuir Salud
                        Bichos[UbicacionFila][UbicacionColumna].DisminuirSalud();
                        
                        //Mapeado y removido de bichos
                        if(Bichos[UbicacionFila][UbicacionColumna].getSalud() == 0){
                            Bichos[UbicacionFila][UbicacionColumna] = null;
                        }
                        for(int a = 0; a<filas; a++){
                            for(int b = 0; b<columnas; b++){
                                if(Bichos [0][0] == null && Bichos [0][1] == null && Bichos [1][0] == null && Bichos [1][1] == null){
                                   decision = 2;
                                   estado = true;
                                   break;
                                }
                            }
                        }
                        
                        System.out.println("----------------");
                        System.out.println("| " + Bichos [0][0]  +  " | " + Bichos [0][1] + " |");
                        System.out.println("----------------");
                        System.out.println("| " + Bichos [1][0]  +  " | " + Bichos [1][1] + " |");
                        System.out.println("----------------");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            System.out.println("¡Felicidades!");
            System.out.println("");
            System.out.println("Opcion 1: Iniciar el programa");
            System.out.println("Opcion 2: Salir del programa");
            System.out.println("¿Que desea hacer?");
            decision = entrada.nextInt();
        }
        System.out.println("Saliendo del programa...");
    }
}