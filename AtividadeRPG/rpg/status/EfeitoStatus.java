package rpg.status;

public class EfeitoStatus {
    private TipoEfeito tipo;
    private int duracao;
    private int valorPorTurno;

    public EfeitoStatus(TipoEfeito tipo, int duracao, int valorPorTurno) {
        this.tipo = tipo; this.duracao = duracao; this.valorPorTurno = valorPorTurno;
    }

    public TipoEfeito getTipo() { return tipo; }
    public int getDuracao() { return duracao; }
    public int getValorPorTurno() { return valorPorTurno; }
    public void decrementarDuracao() { duracao--; }
}
