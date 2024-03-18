package br.com.fiap.telagift.repository

import br.com.fiap.telagift.model.Cupom

fun getAllCupom(): List<Cupom> {
    return listOf(
        Cupom(id = 2401, descricao = "", empresa = "TerraViva"),
        Cupom(id = 2402, descricao = "", empresa = "Green World"),
        Cupom(id = 2403, descricao = "", empresa = "VitalGourmet"),
        Cupom(id = 2404, descricao = "", empresa = "Vibe Vegana"),
        Cupom(id = 2405, descricao = "", empresa = "ReStyle"),
        Cupom(id = 2405, descricao = "", empresa = "Herbal Tea")
    )
}

fun getCupomByEmpresa(empresa : String): List<Cupom>{
    return getAllCupom().filter {
        it.empresa.startsWith(prefix = empresa,true)
    }
}