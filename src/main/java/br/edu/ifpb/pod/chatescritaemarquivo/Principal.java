/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.chatescritaemarquivo;

import java.io.IOException;

/**
 *
 * @author Aluísio
 */
public class Principal {

    public static void main(String args[]) throws IOException, InterruptedException {
        String path = "C:/Users/CLIENTE/Documents/pastapod/arquivo.txt";
        // ManipulaArquivo.escritor(path);
        while (true) {
            Thread.sleep(2016);
            ManipulaArquivo.leitor(path);
        }
    }

}
