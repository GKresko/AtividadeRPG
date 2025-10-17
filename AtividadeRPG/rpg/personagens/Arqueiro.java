package rpg.personagens;

import java.util.*;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) { super(nome, 8, 15, 7, 90, 80); }

    @Override
    public void atacar(List<Personagem> inimigos) {
        if (arma == null) { System.out.println(nome + " não possui arma equipada."); return; }
        if (!estaVivo()) return;
        arma.atacar(this, inimigos);
    }
}
