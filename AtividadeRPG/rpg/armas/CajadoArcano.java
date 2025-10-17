package rpg.armas;

import rpg.personagens.Personagem;
import rpg.status.*;
import rpg.util.Utils;
import java.util.*;

public class CajadoArcano implements Arma {
    @Override
    public String getNome() { return "Cajado Arcano"; }
    @Override
    public int getDanoBase() { return 8; }
    @Override
    public int getCustoMana() { return 25; }
    @Override
    public boolean podeUsar(Personagem p) { return p.getInteligencia() >= 12; }

    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        if (alvos.isEmpty() || atacante.getMana() < getCustoMana()) {
            System.out.printf("%s não pode usar %s.\n", atacante.getNome(), getNome());
            return;
        }
        atacante.gastarMana(getCustoMana());
        Personagem alvo = alvos.get(0);
        int dano = Utils.calcularDanoComCritico(getDanoBase());
        alvo.receberDano(dano);
        alvo.aplicarEfeito(new EfeitoStatus(TipoEfeito.QUEIMADURA, 2, 10));
        System.out.printf("%s lança Bola de Fogo em %s causando %d dano e aplicando Queimadura.\n",
                atacante.getNome(), alvo.getNome(), dano);
    }
}
