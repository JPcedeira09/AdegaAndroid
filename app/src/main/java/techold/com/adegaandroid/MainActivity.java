package techold.com.adegaandroid;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import techold.com.adegaandroid.Config.ConfiguraçaoFirebase;
import techold.com.adegaandroid.model.Usuario;

public class MainActivity extends AppCompatActivity {
    private EditText CampoEmail, CampoSenha;
    private Button botaoEnviar, botaoCadastrar;
    private Usuario usuario;
    private FirebaseAuth Autentificaçao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        Toast.makeText(MainActivity.this,"Preencha a Senha" ,Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Preencha o Email" ,Toast.LENGTH_SHORT).show();

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
        Toast.makeText(MainActivity.this,"Sucesso ao fazer o login!" ,Toast.LENGTH_SHORT).show();
        } else{
        Toast.makeText(MainActivity.this,"Erro ao fazer o login!" ,Toast.LENGTH_SHORT).show();

        }

        }
        });
  }
}
