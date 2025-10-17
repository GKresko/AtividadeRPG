package rpg.personagens;

import java.util.*;

public class Paladino extends Personagem {
    public Paladino(String nome) { super(nome, 12, 10, 12, 110, 100); }

    @Override
    protected double aplicarPassivaReducao(int dano) { return 0.10; }

    @Override
    public void atacar(List<Personagem> inimigos) {
        if (arma == null) { System.out.println(nome + " não possui arma equipada."); return; }
        if (!estaVivo()) return;
        List<Personagem> alvos = new ArrayList<>();
        for (Personagem p : inimigos) if (p.estaVivo()) { alvos.add(p); break; }
        arma.atacar(this, alvos);
        this.vida = Math.min(this.vidaMax, this.vida + 5);
        System.out.printf("%s recupera 5 de vida por fervor divino. Vida atual: %d\n", nome, vida);
    }
}
