package br.com.multicinema.cinemaapi.model.entity;

public enum TipoMeiaEntrada {
    ESTUDANTE(1),
    TERCEIRA_IDADE(2),
    PESSOA_COM_DEFICIENCIA(3),
    ESPECIAL(4);

    private final int codigo;

    TipoMeiaEntrada(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
