package rpg.personagens;

import java.util.*;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) { super(nome, 15, 8, 5, 120, 50); }

    @Override
    protected double aplicarPassivaReducao(int dano) { return 0.20; } // Pele Dura

    @Override
    public void atacar(List<Personagem> inimigos) {
        if (arma == null) { System.out.println(nome + " não possui arma equipada."); return; }
        if (!estaVivo()) return;
        List<Personagem> alvos = new ArrayList<>();
        for (Personagem p : inimigos) if (p.estaVivo()) { alvos.add(p); break; }
        arma.atacar(this, alvos);
    }
}
