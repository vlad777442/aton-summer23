package org.example.threads;

public class SitcomLines {
    private int index = 0;
    private String[][] lines = {
            {"Joey", "Hey, hey."},
            {"Chandler", "Hey."},
            {"Phoebe", "Hey."},
            {"Chandler", "And this from cry-for-help department. Are you wearing makeup?"},
            {"Joey", "Yes, I am. As for today, I am officially Joey Tribbiani, actor slash model."},
            {"Chandler", "That's so funny, 'cause I was thinking you look more like Joey Tribbiani, man slash woman."},
            {"Phoebe", "What were you modelling for?"},
            {"Joey", "You know those posters for City Free Clinic?"},
            {"Monica", "Oh, wow, so you're gonna be one of those \"healthy, healthy, healthy guys\"?"},
            {"Phoebe", "You know, the asthma guys was really cute."},
            {"Chandler", "Do you know which one you're gonna be?"},
            {"Joey", "No ,but I hear that lyme disease is open, so... (crosses fingers)"},
            {"Chandler", "Good luck, man. I hope you get it."},
            {"Joey", "Thanks."},
    };

    public String[][] getLines() {
        return this.lines;
    }

    public String[] getLine() {
        return this.lines[index];
    }

    public synchronized void incrementIndex() {
        this.index++;
    }

    public int getIndex() {
        return this.index;
    }
}
