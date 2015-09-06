package br.usjt.aula12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConsultaAutomovel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_automovel);

        Intent intent = getIntent();
        String cidade = intent.getStringExtra("CIDADE");

        TextView textView = (TextView)findViewById(R.id.LBNomeCidade);
        textView.setText("Automóveis em " + cidade);

        consultarAutomovel(cidade);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consulta_automovel, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void consultarAutomovel(String cidade)
    {
        TextView textView = (TextView)findViewById(R.id.LBAutomoveis);

        //Apenas para teste
        switch (cidade)
        {
            case "São Paulo":
                textView.setText("Chevrolet - Camaro\nFiat - Punto");
                break;
            case "Rio de Janeiro":
                textView.setText("Furgão - Blindado\nEstrela - Bicicleta");
                break;
            case "Rio Branco":
                textView.setText("Dinossauro - T'Rex\nDinossauro - Pterodáctilo");
                break;
            default:
                textView.setText("Cidade não informada");
                break;

        }
    }
}
