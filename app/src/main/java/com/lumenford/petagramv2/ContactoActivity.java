package com.lumenford.petagramv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class ContactoActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtCorreo;
    EditText txtMensaje;
    String sEmail, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        txtNombre = (EditText) findViewById(R.id.txtNombreContacto);
        txtCorreo = (EditText) findViewById(R.id.txtCorreoContacto);
        txtMensaje = (EditText) findViewById(R.id.txtMensajeContacto);
    }

    public void EnviarCorreo(View v)
    {
        if (txtNombre.getText().toString().isEmpty())
        {
            txtNombre.setError("Campo obligatorio");
            Toast.makeText(this, "Debe indicar un nombre válido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (txtCorreo.getText().toString().isEmpty())
        {
            txtCorreo.setError("Campo obligatorio");
            Toast.makeText(this,"Debe indicar una dirección de correo válido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (txtMensaje.getText().toString().isEmpty())
        {
            txtMensaje.setError("Campo obligatorio");
            Toast.makeText(this, "Debe indicar un mensaje válido", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
        txtNombre.setText("");
        txtMensaje.setText("");
        txtCorreo.setText("");
        txtNombre.requestFocus();


        //Este es el proceso con JavaMail solo que por obvias razones no voy a compartir mi cuenta de correo y contraseña
        /*
        sEmail = "*******";
        sPassword = "*******";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sEmail, sPassword);
            }
        });

        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sEmail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("ochoarayo@hotmail.com"));
            message.setSubject("Contacto desde APP Petagram");
            message.setText(txtMensaje.getText().toString().trim());

            //Send Email
            new SendMail().execute(message);
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }

         */

    }

    private class SendMail extends AsyncTask<Message, String, String> {


        //Initializa progress dialog
        //private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Create and show progress dialog
            //progressDialog = ProgressDialog.show(ContactoActivity.this,"Please Wait", "Sending Mail...", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                //Cuando es exitoso
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                //Cuando falla
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Cierra el progress dialog
            //progressDialog.dismiss();
            if(s.equals("Success"))
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(ContactoActivity.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324>Success</font>"));
                builder.setMessage("Mail send successfully.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        //Limpia todos los edit text
                        txtNombre.setText("");
                        txtCorreo.setText("");
                        txtMensaje.setText("");
                    }
                });
                builder.show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Algo salió mal",Toast.LENGTH_SHORT).show();
            }
        }
    }
}