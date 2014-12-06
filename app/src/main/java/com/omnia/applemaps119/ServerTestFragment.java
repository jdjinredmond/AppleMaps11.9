package com.omnia.applemaps119;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerTestFragment extends ActionBarFragment
{
    private TextView mServerResponse;
    private EditText mUserResponse;
    private Button mGoooo;
    private Socket kkSocket;
    private PrintWriter out;
    private BufferedReader in;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_server_test, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_server_test);
        mToolbar.setTitle(R.string.title_server_test);
        super.onCreateView(inflater, container, savedInstanceState);
        mServerResponse = (TextView) view.findViewById(R.id.textView_server_message);
        mUserResponse = (EditText) view.findViewById(R.id.editText_user_input);
        mGoooo = (Button) view.findViewById(R.id.submit_goooo);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        new ConnectSocket().execute();
        super.onCreate(savedInstanceState);
    }

    private class GooooClick extends AsyncTask<CharSequence, Void, String>
    {
        @Override
        protected String doInBackground(CharSequence... fromUserS)
        {
            CharSequence fromUser = fromUserS[0];
            String fromServer;
            try
            {
                if (fromUser != null)
                {
                    out.println(fromUser);
                }
                if ((fromServer = in.readLine()) != null)
                    return fromServer;
                else
                    throw new NoMoreJokesException();
            }
            catch (IOException e)
            {
                mNavigationDrawerFragment.selectItem(0);
                return null;
            }
            catch (NoMoreJokesException e)
            {
                mNavigationDrawerFragment.selectItem(0);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String fromServer)
        {
            mServerResponse.setText(fromServer);
            if (fromServer.equals("Bye."))
                mNavigationDrawerFragment.selectItem(0);
        }
    }

    private class ConnectSocket extends AsyncTask<Void, Void, String>
    {
        @Override
        protected String doInBackground(Void... params)
        {
            try
            {
                Socket socket = new Socket("omnia69.asuscomm.com", 4444);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                return in.readLine();
            }
            catch (UnknownHostException e)
            {
                mNavigationDrawerFragment.selectItem(0);
            }
            catch (IOException e)
            {
                mNavigationDrawerFragment.selectItem(0);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result)
        {
            mServerResponse.setText(result);
            mGoooo.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    new GooooClick().execute(mUserResponse.getText());
                    mUserResponse.setText("");
                }
            });
        }
    }

    private class NoMoreJokesException extends Exception
    {}
}
