package org.example.threads;

public class Multithread extends Thread {
    private String name;

    private SitcomLines sitcomLines;

    public Multithread(String name, SitcomLines lines) {
        this.name = name;
        this.sitcomLines = lines;
    }
    @Override
    public void run() {
        String[][] lines = sitcomLines.getLines();

        synchronized (sitcomLines) {
            while (sitcomLines.getIndex() < lines.length){
                if (this.name.equals(sitcomLines.getLine()[0])) {
                    System.out.println(this.name + ": " + sitcomLines.getLine()[1]);

                    sitcomLines.incrementIndex();
                    sitcomLines.notifyAll();
                }
                try {
                    sitcomLines.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sitcomLines.notifyAll();
        }


    }
}
