/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.chatescritaemarquivo;

/**
 *
 * @author Aluísio
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ManipulaArquivo {

    public ManipulaArquivo() {
        ServerSocket server;
        try {
            server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                new Thread(new ManipulaArquivo.EscultarCliente(socket)).start();
            }
        } catch (IOException e) {
        }
    }

    private class EscultarCliente implements Runnable {

        Scanner leitor;

        public EscultarCliente(Socket socket) {

//            String path = "C:\\Users\\CLIENTE\\Documents\\pastapod\\arquivo.txt";
            String path = "C:/Users/CLIENTE/Documents/pastapod/arquivo.txt";
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
                }
            } catch (Exception x) {
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new ManipulaArquivo();

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

//    public static void escritor(String path) throws IOException {
//        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
//        String linha = "[NODE1] ";
//        Scanner in = new Scanner(System.in);
//        System.out.println("Texto: ");
//        linha = linha + in.nextLine();
//        buffWrite.append(linha + "\n");
//        buffWrite.close();
//    }
    public static void escritor(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Arquivo criado com sucesso");
        } else if (file.exists() == true) {
            System.out.println("Arquivo ja existe");
        }
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        BufferedWriter bw = new BufferedWriter(pw);
        String linha = " [NODE: ] ";
        Scanner in = new Scanner(System.in);
        System.out.println("Texto: ");
        linha = linha + in.nextLine();
        bw.append(linha + "\n");
        bw.close();
    }

}
