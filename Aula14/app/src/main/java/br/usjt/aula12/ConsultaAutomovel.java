package br.usjt.aula12;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

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
        ListView listView = (ListView)findViewById(R.id.listView);
        String[] automoveis = null;

        //Apenas para teste
        switch (cidade)
        {
            case "São Paulo":
                automoveis = new String[] {"Chevrolet - Camaro", "Fiat - Punto"};
                break;
            case "Rio de Janeiro":
                automoveis = new String[] {"Furgão - Blindado", "Estrela - Bicicleta"};
                break;
            case "Rio Branco":
                automoveis = new String[] {"Dinossauro - T'Rex", "Dinossauro - Pterodáctilo"};
                break;
        }

        ArrayList<String> listaAutomoveis = new ArrayList<String>();
        listaAutomoveis.addAll(Arrays.asList(automoveis));

        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.linha, listaAutomoveis);
        listView.setAdapter(listAdapter);
    }
}
