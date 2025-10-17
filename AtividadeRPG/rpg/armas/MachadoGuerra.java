package rpg.armas;

import rpg.personagens.Personagem;
import rpg.status.*;
import rpg.util.Utils;
import java.util.*;

public class MachadoGuerra implements Arma {
    private final Random rnd = new Random();
    @Override
    public String getNome() { return "Machado de Guerra"; }
    @Override
    public int getDanoBase() { return 18; }
    @Override
    public int getCustoMana() { return 5; }
    @Override
    public boolean podeUsar(Personagem p) { return p.getForca() >= 15; }

    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        if (alvos.isEmpty()) return;
        Personagem alvo = alvos.get(0);
        int dano = Utils.calcularDanoComCritico(getDanoBase());
        alvo.receberDano(dano);
        System.out.printf("%s golpeia %s com %s causando %d dano.\n",
                atacante.getNome(), alvo.getNome(), getNome(), dano);
        if (rnd.nextInt(100) < 25) {
            alvo.aplicarEfeito(new EfeitoStatus(TipoEfeito.ATORDOADO, 1, 0));
            System.out.printf("-> %s foi atordoado!\n", alvo.getNome());
        }
    }
}
