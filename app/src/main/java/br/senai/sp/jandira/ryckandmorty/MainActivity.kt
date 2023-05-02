package br.senai.sp.jandira.ryckandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.ryckandmorty.model.CharacterList
import br.senai.sp.jandira.ryckandmorty.service.RetrofitFactory
import br.senai.sp.jandira.ryckandmorty.ui.theme.RyckAndMortyTheme
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RyckAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var results by remember{
        mutableStateOf(listOf<br.senai.sp.jandira.ryckandmorty.model.Character>())
    }




  Column() {
      Button(onClick = { /*TODO*/ }) {

          //Chamada para a API
          val call = RetrofitFactory().getCharacterService().getCharacters()

          call.enqueue(object : Callback<CharacterList>{
              override fun onResponse(
                  call: Call<CharacterList>,
                  response: Response<CharacterList>
              ) {
                  results = response.body()!!.results
              }

              override fun onFailure(call: Call<CharacterList>, t: Throwable) {
              
              }

          })



          Text(text ="List all Characters")
      }
      LazyColumn(){
        items(results){
            Column() {
                Text(text = it.name)
                Text(text = it.species)
                
            }
        }
      }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RyckAndMortyTheme {
        Greeting("Android")
    }
}