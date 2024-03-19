package br.com.fiap.telagift

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.telagift.R.color
import br.com.fiap.telagift.model.Cupom
import br.com.fiap.telagift.repository.getAllCupom
import br.com.fiap.telagift.ui.theme.TelaGiftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaGiftTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GiftScreen()
                }
            }
        }
    }
}

@Composable
fun GiftScreen() {
    /* --- variavel calcular --- */
    var qntdPontos: Int = 150
    val pontosCupom: Int = 25

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(modifier = Modifier.fillMaxWidth()
        ) {

            /* ----- header ----- */
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(colorResource(id = color.pink_0))
            ) {
                Spacer(modifier = Modifier.height(28.dp))
                Text(
                    text = "Resgatar Recompensas",
                    color = colorResource(id = color.white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Troque pontos por voucher ou cupons de desconto\n" +
                            "nas suas lojas e serviços favoritos. Converta-os em vantagens\n" +
                            "reais para aproveitar ao máximo suas compras.  ",
                    color = colorResource(id = color.white),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }

            /* --- Pontos Conta --- */
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {

                /* --- Card de Pontos Usuário  --- */
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-30).dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 32.dp
                        )
                    ) {
                        Text(
                            text = "Você possui",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "$qntdPontos pontos",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.green)
                        )
                    }
                }
                /* -----  Chamada Lista Card do Cupom ----- */
                LazyColumn(){
                    items(getAllCupom()) {
                        CupomCard(cupom = it)
                    }
                }
            }
        } 
    }
}

//função da lista
@Composable
fun CupomCard(cupom : Cupom) {
    Card (modifier = Modifier.padding(bottom = 8.dp))
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(3f)) {
                Text(
                    text = cupom.empresa,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = cupom.categoria,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

                // >> obs: não consigo fazer calculo dos pontos <<
                Spacer(modifier = Modifier.height(5.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(35.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.green)
                    )
                )
                {
                    Text(text = "Adquirir")
                }
            }
            Text(
                text = cupom.desconto,
                modifier = Modifier
                    .weight(1f).fillMaxWidth(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GiftScreenPreview() {
    GiftScreen()
}