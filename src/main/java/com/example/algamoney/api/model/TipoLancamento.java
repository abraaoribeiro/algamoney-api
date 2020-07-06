package com.example.algamoney.api.model;

public enum TipoLancamento {

	RECEITA("Receita"), DESPESA("Despesa");

	private final String descricao;

	TipoLancamento(String descircao) {
		this.descricao = descircao;
	}

	public String getDescricao() {
		return descricao;
	}
}
