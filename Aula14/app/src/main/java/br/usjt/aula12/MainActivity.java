package br.usjt.aula12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void solicitarConsultaAutomoveis(View view)
    {
        Spinner spinner = (Spinner)findViewById(R.id.SPNCidades);
        TextView textView = (TextView)findViewById(R.id.LBErro);

        //Se ele selecionou algo no Spinner (0 é a opção de selecionar a cidade)
        if(spinner.getSelectedItemPosition() != 0)
        {
            String cidade = spinner.getSelectedItem().toString();
            Intent intent = new Intent(this, ConsultaAutomovel.class);
            intent.putExtra("CIDADE", cidade);
            textView.setText(""); //Apaga o textview de erro para não ficar apresentando mensagem
            startActivity(intent);
        }
        else
        {
            textView.setText("Selecione uma cidade");
        }
    }
}
