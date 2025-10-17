package rpg.armas;

import rpg.personagens.Personagem;
import rpg.util.Utils;
import java.util.List;

public class AdagaSombria implements Arma {
    @Override
    public String getNome() { return "Adaga Sombria"; }
    @Override
    public int getDanoBase() { return 10; }
    @Override
    public int getCustoMana() { return 10; }
    @Override
    public boolean podeUsar(Personagem p) { return p.getDestreza() >= 12; }

    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        if (alvos.isEmpty()) return;
        Personagem alvo = alvos.get(0);
        int dano = getDanoBase();
        if (!alvo.estaAtento()) dano *= 3;
        dano = Utils.calcularDanoComCritico(dano);
        alvo.receberDano(dano);
        System.out.printf("%s ataca furtivamente %s causando %d dano.\n",
                atacante.getNome(), alvo.getNome(), dano);
    }
}
