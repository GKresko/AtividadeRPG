package rpg.armas;

import rpg.personagens.Personagem;
import rpg.status.*;
import rpg.util.Utils;
import java.util.*;

public class EspadaLonga implements Arma {
    private final Random rnd = new Random();
    @Override
    public String getNome() { return "Espada Longa"; }
    @Override
    public int getDanoBase() { return 15; }
    @Override
    public int getCustoMana() { return 0; }
    @Override
    public boolean podeUsar(Personagem p) { return p.getForca() >= 10; }

    @Override
    public void atacar(Personagem atacante, List<Personagem> alvos) {
        if (alvos.isEmpty()) return;
        Personagem alvo = alvos.get(0);
        int dano = Utils.calcularDanoComCritico(getDanoBase());
        alvo.receberDano(dano);
        System.out.printf("%s ataca %s com %s causando %d dano.\n",
                atacante.getNome(), alvo.getNome(), getNome(), dano);

        if (rnd.nextInt(100) < 30) {
            alvo.aplicarEfeito(new EfeitoStatus(TipoEfeito.SANGRAMENTO, 3, 5));
            System.out.printf("-> %s sofreu Sangramento! (5 por turno por 3 turnos)\n", alvo.getNome());
        }
    }
}
