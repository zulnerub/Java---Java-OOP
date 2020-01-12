package WORKSHOP_THREE.logic.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class InputReader {
    private BufferedReader rd;

    public InputReader() {
        this.rd = new BufferedReader(new InputStreamReader(System.in));
    }

    public String line() throws IOException {
        return rd.readLine();
    }
}
