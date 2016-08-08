/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.chatescritaemarquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Aluísio
 */
public class ChatServidor {

    public ChatServidor() {
        ServerSocket server;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                new Thread(new EscutaCliente(socket)).start();
            }
        } catch (IOException e) {
        }
    }

    public class EscutaCliente implements Runnable {

        Scanner leitor;

        public EscutaCliente(Socket socket) {
            
            String path = "C:\\Users\\CLIENTE\\Documents\\pastapod\\arquivo.txt";
            try {
                leitor = new Scanner(socket.getInputStream());
                escritor(path);
            } catch (Exception e) {

            }
        }

        @Override
        public void run() {
            try {
                String texto;
                while ((texto = leitor.nextLine()) != null) {
                    System.out.println("->" + texto);
                    escritor(texto);
                }
            } catch (Exception x) {
            }
        }

    }

    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);

            } else {
                break;
            }
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    public static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "[NODE1] ";
        Scanner in = new Scanner(System.in);
        System.out.println("Texto: ");
        linha = linha + in.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }

    public static void main(String[] args) throws IOException {
        new ChatServidor();

    }

}
