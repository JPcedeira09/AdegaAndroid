package techold.com.adegaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

<<<<<<< HEAD:app/src/main/java/techold/com/adegaandroid/Login.java
public class Login extends AppCompatActivity {
    private EditText CampoEmail, CampoSenha;
    private Button botaoEnviar, botaoCadastrar;
    private Usuario usuario;
    private FirebaseAuth Autentificaçao;
=======
public class MainActivity extends AppCompatActivity {
>>>>>>> b05c3d2cd07f8f17a66bacaa1be4564fb1c6072d:app/src/main/java/techold/com/adegaandroid/MainActivity.java

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD:app/src/main/java/techold/com/adegaandroid/Login.java
        setContentView(R.layout.Login_main);

        CampoEmail = findViewById(R.id.editEmail);
        CampoSenha = findViewById(R.id.editSenha);
        botaoEnviar = findViewById(R.id.Enviar);
        botaoCadastrar = findViewById(R.id.Cadastrar);


        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = CampoEmail.getText().toString();
                String Senha = CampoSenha.getText().toString();
                //Validar se os campos foram Preenchidos
                if (!Email.isEmpty()) {
                    if (!Senha.isEmpty()){
                         usuario = new Usuario();
                         usuario.setEmail(Email);
                         usuario.setSenha(Senha);

                        }else{
                        Toast.makeText(Login.this,"Preencha a Senha" ,Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(Login.this,"Preencha o Email" ,Toast.LENGTH_SHORT).show();

                }
            }


            });

}



    public void ValidarLogin(){
     Autentificaçao = ConfiguraçaoFirebase.getFirebaseAutenticaçao();
     Autentificaçao.signInWithEmailAndPassword(
             usuario.getEmail(),
             usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>()  {
            @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful() ){
        Toast.makeText(Login.this,"Sucesso ao fazer o login!" ,Toast.LENGTH_SHORT).show();
        } else{
        Toast.makeText(Login.this,"Erro ao fazer o login!" ,Toast.LENGTH_SHORT).show();

        }

        }
        });
  }
}
=======
        setContentView(R.layout.activity_main);
    }
}
>>>>>>> b05c3d2cd07f8f17a66bacaa1be4564fb1c6072d:app/src/main/java/techold/com/adegaandroid/MainActivity.java
