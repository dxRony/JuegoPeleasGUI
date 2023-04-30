package com.mycompany.juegopeleasgui.be.jugadores;

public class Usuario extends Jugador {

    private int oro;
//    private Jugables[] inventarioJugables;
//    private Jugables[] listaJugables;
//    private Articulos[] inventarioArticulos;
//    private Articulos[] listaArticulos;
//    private Jugables personajePrincipalUsuario;

    public Usuario() {
//        inventarioJugables = new Jugables[5];
//        listaJugables = new Jugables[6];
//        inventarioArticulos = new Articulos[10];
//        listaArticulos = new Articulos[7];
//        personajePrincipalUsuario = new Jugables();
        oro = 500;
//        listaArticulos[0] = new CapaDeMovilidad();
//        listaArticulos[1] = new Dano();
//        listaArticulos[2] = new ElixirVerde();
//        listaArticulos[3] = new Movilidad();
//        listaArticulos[4] = new SemillaDeVida();
//        listaArticulos[5] = new Vida();
//        listaArticulos[6] = new ArticuloVacio();
//        listaJugables[0] = new Arquero();
//        listaJugables[1] = new Caballero();
//        listaJugables[2] = new Dragon();
//        listaJugables[3] = new Gigante();
//        listaJugables[4] = new Mago();
//        listaJugables[5] = new PersonajeVacio();
//        iniciarInventarioUsuario();
//        iniciarInventarioArticulos();
    }

//    public void iniciarInventarioUsuario() {
//        for (int i = 0; i < 5; i++) {
//            inventarioJugables[i] = listaJugables[5];
//        }
//    }
//
//    public void iniciarInventarioArticulos() {
//        for (int i = 0; i < inventarioArticulos.length; i++) {
//            inventarioArticulos[i] = listaArticulos[6];
//        }
//    }
//
//    public void pintarInventarioUsuario() {
//        System.out.println("Inventario Personajes(usuario): ");
//        for (int i = 0; i < 5; i++) {
//            System.out.print("[" + i + "] " + inventarioJugables[i].getNombre());
//            System.out.print("\n");
//        }
//        System.out.println("--------------------------------------");
//    }
//
//    public void pintarInventarioArticulos() {
//        System.out.println("Inventario Articulos(usuario):");
//        for (int i = 0; i < inventarioArticulos.length; i++) {
//            System.out.print("[" + i + "] " + inventarioArticulos[i].getNombre());
//            System.out.print("\n");
//        }
//        System.out.println("--------------------------------------");
//    }
//
//    public void comprarJugables(Jugables jugables, int oro) {
//        if (this.oro >= jugables.getCoste()) {
//            for (int i = 0; i < inventarioJugables.length; i++) {
//                if (this.inventarioJugables[i] instanceof PersonajeVacio) {
//                    this.oro -= jugables.getCoste();
//                    this.inventarioJugables[i] = jugables;
//                    System.out.println("Compraste al: " + jugables.getNombre());
//                    System.out.println("Tienes: " + this.oro + " de oro");
//                    return;
//                }
//            }
//        }
//        System.out.println("No tienes el suficiente oro");
//    }
//
//    public void comprarArticulos(Articulos articulos, int oro) {
//        if (this.oro >= articulos.getCoste()) {
//            for (int i = 0; i < inventarioArticulos.length; i++) {
//                if (this.inventarioArticulos[i] instanceof ArticuloVacio) {
//                    this.oro -= articulos.getCoste();
//                    this.inventarioArticulos[i] = articulos;
//                    System.out.println("Compraste: " + articulos.getNombre());
//                    System.out.println("Tienes: " + this.oro + " de oro");
//                    return;
//                }
//            }
//        }
//        System.out.println("No tienes el oro suficiente");
//    }
//
//    public void almacenarPrincipalUsuario(Jugables personajePrincipalUsuario) {
//        this.personajePrincipalUsuario = personajePrincipalUsuario;
//    }
//
    public int getOro() {
        return oro;
    }
//
//    public Jugables[] getInventarioJugables() {
//        return inventarioJugables;
//    }
//
//    public Articulos[] getInventarioArticulos() {
//        return inventarioArticulos;
//    }
//
//    public Jugables[] getListaJugables() {
//        return listaJugables;
//    }
//
//    public Articulos[] getListaArticulos() {
//        return listaArticulos;
//    }
//
//    public Jugables getPersonajePrincipalUsuario() {
//        return personajePrincipalUsuario;
//    }
}
