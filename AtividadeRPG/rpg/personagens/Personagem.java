package rpg.personagens;

import rpg.armas.Arma;
import rpg.status.EfeitoStatus;
import rpg.status.TipoEfeito;
import java.util.*;

public abstract class Personagem {
    protected String nome;
    protected int forca, destreza, inteligencia;
    protected int vida, vidaMax;
    protected int mana, manaMax;
    protected Arma arma;
    protected List<EfeitoStatus> efeitos = new ArrayList<>();

    public Personagem(String nome, int forca, int destreza, int inteligencia, int vida, int mana) {
        this.nome = nome;
        this.forca = forca; this.destreza = destreza; this.inteligencia = inteligencia;
        this.vida = this.vidaMax = vida; this.mana = this.manaMax = mana;
    }

    public String getNome() { return nome; }
    public int getForca() { return forca; }
    public int getDestreza() { return destreza; }
    public int getInteligencia() { return inteligencia; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }

    public void equiparArma(Arma a) {
        if (a.podeUsar(this)) {
            this.arma = a;
            System.out.printf("%s equipou %s.\n", nome, a.getNome());
        } else {
            System.out.printf("%s não atende aos requisitos para %s.\n", nome, a.getNome());
        }
    }

    public boolean estaVivo() { return vida > 0; }

    public void receberDano(int d) {
        double reduz = aplicarPassivaReducao(d);
        int danoFinal = (int)Math.max(0, Math.round(d * (1 - reduz)));
        vida -= danoFinal;
        if (vida < 0) vida = 0;
    }

    protected double aplicarPassivaReducao(int dano) { return 0.0; }

    public void aplicarEfeito(EfeitoStatus e) { efeitos.add(e); }

    public void processarEfeitos() {
        Iterator<EfeitoStatus> it = efeitos.iterator();
        while (it.hasNext()) {
            EfeitoStatus e = it.next();
            if (e.getTipo() == TipoEfeito.SANGRAMENTO || e.getTipo() == TipoEfeito.QUEIMADURA) {
                receberDano(e.getValorPorTurno());
                System.out.printf("%s sofre %d de %s (turnos restantes: %d)\n",
                        nome, e.getValorPorTurno(), e.getTipo(), e.getDuracao());
            }
            e.decrementarDuracao();
            if (e.getDuracao() <= 0) it.remove();
        }
    }

    public boolean estaAtento() {
        for (EfeitoStatus e : efeitos)
            if (e.getTipo() == TipoEfeito.ATORDOADO) return false;
        return true;
    }

    public void gastarMana(int m) { mana = Math.max(0, mana - m); }
    public void restaurarMana(int m) { mana = Math.min(manaMax, mana + m); }

    public abstract void atacar(List<Personagem> inimigos);
    public void fimTurno() { }
}