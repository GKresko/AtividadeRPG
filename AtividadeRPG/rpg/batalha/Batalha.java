package rpg.batalha;

import rpg.personagens.Personagem;
import java.util.*;

public class Batalha {
    private final List<Personagem> combatentes = new ArrayList<>();
    private int turno = 1;

    public void adicionarCombatente(Personagem p) { combatentes.add(p); }

    public void iniciar() {
        System.out.println("=== BATALHA INICIADA ===");
        while (!fim()) {
            System.out.println("\n--- Turno " + turno + " ---");
            for (Personagem p : new ArrayList<>(combatentes)) {
                if (!p.estaVivo()) continue;
                if (!p.estaAtento()) {
                    System.out.printf("%s está atordoado e perde o turno.\n", p.getNome());
                } else {
                    List<Personagem> inimigos = new ArrayList<>();
                    for (Personagem o : combatentes) if (o != p && o.estaVivo()) inimigos.add(o);
                    p.atacar(inimigos);
                }
                p.processarEfeitos();
                p.fimTurno();
            }
            turno++;
        }
        mostrarResultado();
    }

    private boolean fim() {
        long vivos = combatentes.stream().filter(Personagem::estaVivo).count();
        return vivos <= 1 || turno > 100;
    }

    private void mostrarResultado() {
        System.out.println("\n=== RESULTADO DA BATALHA ===");
        for (Personagem p : combatentes) {
            System.out.printf("%s - Vida: %d - %s\n", p.getNome(), p.getVida(),
                    p.estaVivo() ? "VIVO" : "MORTO");
        }
    }
}
