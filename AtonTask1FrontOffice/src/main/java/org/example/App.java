package org.example;

import org.example.threads.Multithread;
import org.example.threads.SitcomLines;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SitcomLines sitcomLines = new SitcomLines();
        String[] thread_names = {"Joey", "Chandler", "Phoebe", "Monica", "Rachel"};

        for (int i = 0; i < thread_names.length; i++) {
            Multithread multithread = new Multithread(thread_names[i], sitcomLines);
            multithread.start();
        }
    }
}
