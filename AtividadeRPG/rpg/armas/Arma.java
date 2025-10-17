package rpg.armas;

import rpg.personagens.Personagem;
import java.util.List;

public interface Arma {
    String getNome();
    int getDanoBase();
    int getCustoMana();
    boolean podeUsar(Personagem p);
    void atacar(Personagem atacante, List<Personagem> alvos);
}
