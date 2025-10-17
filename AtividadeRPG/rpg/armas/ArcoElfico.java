package rpg.armas;

import rpg.personagens.Personagem;
import rpg.util.Utils;
import java.util.List;

public class ArcoElfico implements Arma {
    @Override
    public String getNome() { return "Arco Élfico"; }
    @Override
    public int getDanoBase() { return 12; }
    @Override
    public int getCustoMana() { return 15; }
    @Override
    public boolean podeUsar(Personagem p) { return p.getDestreza() >= 8; }

    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        for (Personagem alvo : alvos) {
            int dano = Utils.calcularDanoComCritico(getDanoBase());
            alvo.receberDano(dano);
            System.out.printf("%s atira em %s com %s causando %d dano.\n",
                    atacante.getNome(), alvo.getNome(), getNome(), dano);
        }
    }
}
