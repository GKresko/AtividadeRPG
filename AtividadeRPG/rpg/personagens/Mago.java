package rpg.personagens;

import java.util.*;

public class Mago extends Personagem {
    public Mago(String nome) { super(nome, 5, 7, 18, 70, 150); }

    @Override
    public void atacar(List<Personagem> inimigos) {
        if (arma == null) { System.out.println(nome + " não possui arma equipada."); return; }
        if (!estaVivo()) return;
        arma.atacar(this, inimigos);
    }

    @Override
    public void fimTurno() {
        restaurarMana(10);
        System.out.printf("%s regenera 10 de mana. Mana atual: %d\n", nome, mana);
    }
}
