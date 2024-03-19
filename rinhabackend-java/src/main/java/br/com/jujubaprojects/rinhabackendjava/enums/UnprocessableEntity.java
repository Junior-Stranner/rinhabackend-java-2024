package br.com.jujubaprojects.rinhabackendjava.enums;

public enum UnprocessableEntity {

    NOT_FOUND(404, "Not Found"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity");

    private final int codigo;
    private final String descricao;

    UnprocessableEntity(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
