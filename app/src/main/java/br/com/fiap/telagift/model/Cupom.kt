package br.com.fiap.telagift.model

/* ----- classe de dados ----- */
data class Cupom(
    val id: Long = 0,
    val empresa: String,
    val desconto: String,
    val categoria: String
)