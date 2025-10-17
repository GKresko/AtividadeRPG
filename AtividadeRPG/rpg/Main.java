package rpg;

import rpg.batalha.Batalha;
import rpg.personagens.*;
import rpg.armas.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Guerreiro g = new Guerreiro("Thorin");
        Arqueiro a = new Arqueiro("Legolas");
        Mago m = new Mago("Gandalf");

        g.equiparArma(new EspadaLonga());
        a.equiparArma(new ArcoElfico());
        m.equiparArma(new CajadoArcano());

        Batalha batalha = new Batalha();
        batalha.adicionarCombatente(g);
        batalha.adicionarCombatente(a);
        batalha.adicionarCombatente(m);

        batalha.iniciar();
    }
}