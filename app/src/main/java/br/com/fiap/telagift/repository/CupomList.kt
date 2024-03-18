package br.com.fiap.telagift.repository

import br.com.fiap.telagift.model.Cupom

fun getAllCupom(): List<Cupom> {
    return listOf(
        Cupom(id = 2401, desconto = "25%",
            empresa = "ReStyle", categoria = "Shopping"),
        Cupom(id = 2402, desconto = "R$80",
            empresa = "EcoServe", categoria = "Serviços"),
        Cupom(id = 2403, desconto = "R$15",
            empresa = "Vibe Gourmet", categoria = "Alimentação"),
        Cupom(id = 2404, desconto = "10%",
            empresa = "Herbal Tea", categoria = "Bebida")
    )
}

fun getCupomByEmpresa(empresa : String): List<Cupom>{
    return getAllCupom().filter {
        it.empresa.startsWith(prefix = empresa,true)
    }
}