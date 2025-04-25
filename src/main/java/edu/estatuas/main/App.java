package edu.estatuas.main;

import edu.estatuas.CreditCard;
import edu.estatuas.Receptivo;
import edu.estatuas.guess_dispatchers.CrystalExpender;
import edu.estatuas.guess_dispatchers.RickMenu;
import edu.estatuas.guess_dispatchers.UfosPark;

public class App {
    public static void main(String[] args) {

        //region Credit Card
        CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");

        System.out.println("\n" + "Tarjeta de Abradolph" + "\n" +
                "====================");
        System.out.println(abradolph);

        //region Ufos Park
        UfosPark ufosPark = new UfosPark();

        String[] ufosID = { "unx", "dox" };
        for (String ovni : ufosID) {
            ufosPark.add(ovni);
        }

        // Procesamos el pago y reserva de ovni de Abradolph
        ufosPark.dispatch(abradolph);

        // Mostramos el ID del ovni asignado a Abradolph
        System.out.println("\nOvni de Abradolph\n" +
                "=================");
        System.out.println(ufosPark.getUfoOf(abradolph.number()));

        // Mostramos el credito de la tarjeta de Abradolph
        System.out.println("Credito de Abradolph: " + abradolph.credit());

        // Abradolph quiere reservar otro ovni.
        // El sistema detecta que ya tiene uno
        // e ignora la petición.

        System.out.println("\nAbradolph quiere otro ovni\n" +
                "==========================");
        ufosPark.dispatch(abradolph);
        System.out.println("Su credito no ha cambiado: " + abradolph.credit());
        System.out.println("Ovni de Abradolph: " + ufosPark.getUfoOf(abradolph.number()));

        // A GearHead le vacía la tarjeta el alien "Cámara Lenta"
        // mientras le daba la chapa, justo antes de pagar el ovni.
        // Intenta reservarlo y el componente de reserva de ovnis
        // no le asigna ninguno.
        System.out.println("\nLLega GearHead!\n" +
                "===============");
        CreditCard gearHead = new CreditCard("Gearhead", "8888888888888888");

        gearHead.pay(3000); // le vacían la cartera
        ufosPark.dispatch(gearHead);
        System.out.println("Su credito es cero: " + gearHead.credit());
        System.out.println("No puede reservar ovni: " + ufosPark.getUfoOf(gearHead.number()));

         // Squanchy deja su ovni reservado
        // antes de irse a squanchear
        System.out.println("\nLLega Squanchy!\n" + 
                             "==============");
        CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
        ufosPark.dispatch(squanchy);
        System.out.println("Su credito es: " + squanchy.credit());
        System.out.println("Su ovni es: " + ufosPark.getUfoOf(squanchy.number()));

        // Morty quiere un ovni para huir de la fiesta
        // pero ya no queda ninguno disponible
        System.out.println("\nAlgun ovni para Morty?\n" + 
                             "======================");
        CreditCard morty = new CreditCard("Morty", "0000000000000000");
        ufosPark.dispatch(morty);
        System.out.println("Su credito no ha cambiado: " + morty.credit());
        System.out.println("No hay ovni Morty: " + ufosPark.getUfoOf(morty.number()));

        //region Flota de ovnis
        System.out.println("\nFlota de ovnis\n" + 
                             "==============");
        ufosPark.add("trex");
        System.out.println(ufosPark);

        /**
         * Construye el dispensador de packs de bienvenida.
         * Indica el numero de unidades y el coste de cada
         * uno de ellos, que es de 50 EZIs
         */
        //region Pack Expender
        CrystalExpender packExpender = new CrystalExpender(3, 50);
         // Muestra el total de packs y su precio unidad
        System.out.println("\nPacks\n" + 
                             "=====");
        System.out.println(packExpender);

        // Abradolph compra su pack de bienvenida
        packExpender.dispatch(abradolph);

        System.out.println("\nAbradolph compra su pack\n" + 
                             "========================");
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de Abradolph: " + abradolph.credit());

         // El pobre GerHead no tiene crédito para comprar su pack
        System.out.println("\nGearHead sin credito para su pack\n" + 
                             "=================================");
        packExpender.dispatch(gearHead);
        System.out.println("Packs\n" + packExpender);
        System.out.println("Credito de GearHead: " + gearHead.credit());

        //region Receptivo
        Receptivo receptivo = new Receptivo();
        receptivo.registra(packExpender);
        receptivo.registra(ufosPark);

        System.out.println("\nLLega Squanchy!\n" + 
                             "===============");
        receptivo.dispatch(squanchy);
        mostrarReserva(squanchy, packExpender, ufosPark);

        // Gearhead reserva ovni y pack.
        // No tiene crédito.
        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        gearHead.pay(3000); // no tiene crédito
        receptivo.dispatch(gearHead);
        mostrarReserva(gearHead, packExpender, ufosPark);

        // Birdpearson es recibido en la fiesta
         System.out.println("\nLLega Birdpearson!\n" + 
                             "==================");
        CreditCard birdpearson = new CreditCard("Birdpearson", "1111111111111111");
        receptivo.dispatch(birdpearson);
        mostrarReserva(birdpearson, packExpender, ufosPark);

        // Morty intenta reserver un ovni y un pack pero no quedan
        System.out.println("\nMorty quiere pack y ovni pero no quedan :(\n" + 
                             "==========================================");
        morty = new CreditCard("Morty", "0000000000000000");
        receptivo.dispatch(morty);
        mostrarReserva(morty, packExpender, ufosPark);

        //region Rick Menu
        RickMenu rickMenu = new RickMenu(100, 10);
        
        receptivo.registra(rickMenu);

        System.out.println("\nLLega Abradolph!\n" + 
                             "===============");
        receptivo.dispatch(abradolph);
        mostrarReserva(abradolph, packExpender, ufosPark, rickMenu);

        System.out.println("\nLLega Squanchy!\n" + 
                             "===============");
        receptivo.dispatch(squanchy);
        mostrarReserva(squanchy, packExpender, ufosPark, rickMenu);

        System.out.println("\nLLega GearHead!\n" + 
                             "===============");
        receptivo.dispatch(gearHead);
        mostrarReserva(gearHead, packExpender, ufosPark, rickMenu);

        // Birdpearson es recibido en la fiesta
         System.out.println("\nLLega Birdpearson!\n" + 
                             "==================");
        receptivo.dispatch(birdpearson);
        mostrarReserva(birdpearson, packExpender, ufosPark, rickMenu);

        // Morty intenta reserver un ovni y un pack pero no quedan
        System.out.println("\nLLega Morty\n" + 
                             "==========================================");
        receptivo.dispatch(morty);
        mostrarReserva(morty, packExpender, ufosPark, rickMenu);


        
    }
    private static void mostrarReserva(CreditCard card, CrystalExpender expender, UfosPark ufos) {
        System.out.println(card);
        System.out.println("Packs: " + expender.getStock());
        System.out.println("Ovni: " + ufos.getUfoOf(card.number()));
    }
    private static void mostrarReserva(CreditCard card, CrystalExpender expender, UfosPark ufos, RickMenu rickMenu) {
        System.out.println(card);
        System.out.println("Packs: " + expender.getStock());
        System.out.println("Ovni: " + ufos.getUfoOf(card.number()));
        System.out.println("RickMenús: " + rickMenu.getStock());
    }
}
